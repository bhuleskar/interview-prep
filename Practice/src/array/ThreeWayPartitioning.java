package array;

public class ThreeWayPartitioning {

	private static int[] a = {1,1,0,2,2,1,2,0,0,1,2,1};
	
	public static void partition() {
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		System.out.println(a[mid]);
		
		while(mid <= high) {
			if(a[mid] == 0){
				int temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				mid++;
			    low++;
			} else if(a[mid] == 1) {
				mid++;
			} else {
				int tmp = a[mid];
				a[mid] = a[high];
				a[high] = tmp;
				high--;
			}
		}
	}
	
	private static void swap(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}
 	public static void main(String[] args) {
		partition();
		for(int i=0 ; i < a.length ; i++) 
			System.out.print(a[i]+" ");
		

	}

}
