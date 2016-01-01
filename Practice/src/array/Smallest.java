package array;

public class Smallest {

	//find kth smallest element in two sorted arrays
	public int kthSmallest(int[] a,int[] b,int k) {
		if(a == null || b == null) 
			return -1;
		if(a.length == 0 && b.length == 0) {
			return -1;
		}
		if(k > a.length + b.length) 
			return -1;
		
		int i = 0;
		int j = 0;
		int count = 0;
		
		while(i < a.length && j < b.length) {
			if(a[i] == b[j]) {
				count++;
				if(count == k) 
					return a[i];
				i++;
				j++;
			} else if(a[i] < b[j]) {
				count++;
				if(count == k) 
					return a[i];
				i++;
			} else {
				count++;
				if(count == k) 
					return b[j];
				j++;
			}
		}
		while(i < a.length) {
			count++;
			if(count == k) 
				return a[i];
			i++;
		}
		while(j < b.length) {
			count++;
			if(count == k) 
				return b[j];
			j++;
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int[] arr1 = {1,1,2,3,7,9};
		int[] arr2 = {1,2,6,8};
		
		Smallest kthsmallest = new Smallest();
		System.out.println(kthsmallest.kthSmallest(arr1, arr2, 2));

	}

}
