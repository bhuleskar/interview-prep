package array;

import javax.swing.text.html.MinimalHTMLWriter;

public class MergeArrays {

	private static int[] a = {2,4,6,8,0,0,0,0,0};
	//private static int[] a = {2,4,6};
	private static int[] b = {1,3,5,7,9};
	private static int[] c = {10,12,13,14,16,20};
	/*
	 * Merge two sorted arrays. Array A has enough space to accomoate both arrays
	 */
	public static int[] mergeTwo(int[] a, int[] b, int n, int m) {
		
		if (a == null && b == null) {
			System.out.println("Both arrays are bull");
			return null;
		}
		if(b.length == 0) return a;
		if(a.length == 0) return b;
		
		int k = m + n - 1;
		int i = n - 1;
		int j = m - 1;
		
		while(i >= 0 && j >= 0) {
			if(a[i] > b[j]) {
				a[k] = a[i];
				k--;
				i--;
			} else {
				a[k] = b[j];
				k--;
				j--;
			}
		}
		while(j >= 0) {
			a[k] = b[j];
			k--;
			j--;
		}

		return a;
	}
	
	public static int[] merge(int[] a, int[] b) {

	    int[] answer = new int[a.length + b.length];
	    int i = 0, j = 0, k = 0;

	    while (i < a.length && j < b.length)
	    {
	        if (a[i] < b[j])       
	            answer[k++] = a[i++];

	        else        
	            answer[k++] = b[j++];               
	    }

	    while (i < a.length)  
	        answer[k++] = a[i++];


	    while (j < b.length)    
	        answer[k++] = b[j++];

	    return answer;
	}
	
	
	public static void main(String[] args) {
		
		mergeTwo(a, b, 4, b.length);
		for(int i=0 ; i<a.length ; i++) {
			System.out.print(a[i]+" ");
		}
		
		
	}

}
