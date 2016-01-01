package heap;

public class MinHeap {

	int count;
	int[] heap;
	
	public MinHeap (int capacity) {
		count = 0;
		heap = new int[capacity];
	}
	
	public void findLargest(int[] array) {
		// Build a Min Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)
		for(int i=0 ; i<5 ; i++) {
			insert(array[i]);
		}
		//Build min heap of first k elements--> O(k)
		System.out.println("~~~Initial Min Heap~~~");
		for(int i=1 ; i<=this.count ; i++) {
			System.out.print(heap[i]+ " ");
		}
		System.out.println();
		
		/*
		 * 2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
			……a) If the element is greater than the root then make it root and call heapify for MH
			……b) Else ignore it.
			// The step 2 is O((n-k)*logk)
		 */
		for(int i=5; i<array.length ; i++){
			if(array[i] > this.getMax()) {
				this.heap[1] = array[i];
				heapify(1);
			}
		}
		
		//Final min heap
		System.out.println("~~~Final Min Heap~~~");
		for(int i=1 ; i<=this.count ; i++) {
			System.out.print(heap[i]+ " ");
		}
	}
	
	private void heapify(int i) {
		int l,r,min,temp;
		l = leftChild(i);
		r = rightChild(i);
		
		if(l != -1 && this.heap[l] < this.heap[i])
			min = l;
		else min = i;
		
		if(r != -1 && this.heap[r] < this.heap[min])
			min = r;
		
		if(min != i){
			temp = this.heap[i];
			this.heap[i] = this.heap[min];
			this.heap[min] = temp;
			heapify(min);
		}
	}
	
	private int leftChild(int i){
		int left = 2*i;
		if(left > this.count) 
			return -1;
		return left;
	}
	
	private int rightChild(int i) {
		int right = 2*i + 1;
		if(right > this.count)
			return -1;
		return right;
	}
	
	private int getMax(){
		if(this.count == 0) 
			return -1;
		int data = this.heap[1];
		return data;
	}
	
	public void insert(int data) {
		int pos = ++this.count;
		while(pos>1 && data < this.heap[(pos)/2]){
			this.heap[pos] = this.heap[(pos)/2];
			pos = pos/2;
		}
		this.heap[pos] = data;
	}
	
	public static void main(String[] args) {
		MinHeap heap = new MinHeap(6);
		int[] array = {5,3,1,4,2,10,20,30,40,50};
		heap.findLargest(array);
	}

}
