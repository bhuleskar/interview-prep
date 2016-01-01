package array;

import java.util.HashSet;

public class AddUpToK {

	private static int[] arr = {-1,-3,-6,-8,-2,-9,-5,-5};
	/*
	 * Given an unordered large array of integers, find all pairs of numbers that add up to a 
	 * particular given sum
	 */
	public static void findPair(int target){
		if(arr.length == 0 || arr.length == 1) {
			System.out.println("Cannot find pair");
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0 ; i<arr.length ; i++) {
			int diff = target - arr[i];
			if(set.contains(diff)) {
				System.out.println("Pair is-"+arr[i]+" and "+diff);
			} else {
				set.add(arr[i]);
			}
		}
		
	}
	
	public static void threeSum(int k) {
		for(int i=0 ; i<arr.length-3 ; i++) {
			int a = arr[i];
			int start = i+1;
			int end = arr.length - 1;
			while(start < end) {
				int b = arr[start];
				int c = arr[end];
				if(a+b+c == k) {
					System.out.println("pairs are "+a+","+b+","+c);
					start++;
					end--;
				}
				else if(a+b+c > k){
					end--;
				} else
					start++;
			}
		}
	}
	public static void main(String[] args) {
	//	threeSum(6);
		findPair(-10);

	}

}
