package array;

public class RotatedSortedArray {

	private static int[] A = {4,5,6,7,0,1,2};
	
	public static int find(int N,int key) {
		int L = 0;
		int R = N - 1;
	
		while(L <= R) {
			int M = L + ((R-L)/2);
			if(A[M] == key) {
				return M;
			} 
			
			if(A[L] <= A[M]) {
				if(A[L] <= key &&  key < A[M])
					R = M - 1;
				else
					L = M + 1;
			}
			else {
				if(A[M] < key && key <= A[R])
					L = M + 1;
				else
					R = M - 1;
			}
		}
		return -1;
		
	}
	
	/*
	 * This time you have to search for the rotation pivot. There is a subtle observation. 
	 * This problem is in fact the same as finding the minimum element’s index.
	 *  If the middle element is greater than the right most element, then the pivot must be to the right;
	 *   if it is not, the pivot must be to the left.
	 */
	static int findPivot(int N) {
		  int L = 0;
		  int R = N - 1;
		  
		  while (A[L] > A[R]) {
		    int M = L + (R - L) / 2;
		    if (A[M] > A[R])
		      L = M + 1;
		    else
		      R = M;
		  }
		  return L;
	}
	
	public static void main(String[] args) {
		System.out.println(find(A.length, 4));
		System.out.println(findPivot(A.length));

	}

}
