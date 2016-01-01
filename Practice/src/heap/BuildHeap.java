package heap;

public class BuildHeap {

	int count;
	int[] heap;
	
	public BuildHeap (int capacity) {
		count = 0;
		heap = new int[capacity];
	}
	
	public void insert(int data){
		int pos = ++this.count;
		while(pos > 1 && data > this.heap[(pos)/2]) {
			this.heap[pos] = this.heap[(pos)/2];
			pos = pos/2;
		}
		this.heap[pos] = data;
	} // O(log n)
	
	
	public void printHeap(){
		for(int i=1 ; i<=this.count ; i++)
			System.out.print(this.heap[i]+" ");
	}
	
	public int deleteMax() {
		if(this.count == 0) 
			return -1;
		int data = this.heap[1];
		this.heap[1] = this.heap[count];
		this.count--;
		perlocateDown(1);
		return data;
		
	}
	
	public void perlocateDown(int i){
		int l,r,max,temp;
		l = this.leftChild(i);
		r = this.rightChild(i);
		
		if(l != -1 && this.heap[l] > this.heap[i]) 
			max = l;
		else max = i;
		if(r != -1 && this.heap[r] > this.heap[max])
			max = r;
		
		if(max != i) {
			temp = this.heap[i];
			this.heap[i] = this.heap[max];
			this.heap[max] = temp;
			perlocateDown(max);
		}
	}
	
	public int Parent(int i){
		if(i <= 1 || i >= this.count)
			return -1;
		return i/2;
	}
	
	public int leftChild(int i){
		int left = 2*i;
		if(left > this.count) 
			return -1;
		return left;
	}
	
	public int rightChild(int i){
		int right = 2*i + 1;
		if(right > this.count) 
			return -1;
		return right;
	}
	
	public static void main(String[] args) {
		BuildHeap maxHeap = new BuildHeap(11);
		for(int i=1 ; i<=10 ; i++){
			maxHeap.insert(i);
		}
		
		maxHeap.printHeap();
		System.out.println("Count = "+maxHeap.count);
		System.out.println();
		System.out.println("Delete Max and heapify");
		System.out.println(maxHeap.deleteMax());
		maxHeap.printHeap();
		

	}

}
