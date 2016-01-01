package sorting;

public class MergeSort {

	private static int[] numbers = {4,1,10,2,7,6,5,8,9};
	private static int[] helper;
	
	public static void main(String[] args) {
		mergerSort(0, numbers.length-1);
		for(int i=0 ; i<numbers.length ; i++) {
			System.out.print(numbers[i]+" ");
		}
		
	}
	
	public static void mergerSort(int low,int high) {
		if(low < high) {
			int middle = low + (high-low)/2;
			
			mergerSort(low, middle);
			mergerSort(middle+1, high);
			
			merge(low,middle,high);
		}
	}
	
	public static void merge(int low,int middle,int high) {
		// Copy both parts into the helper array
	    for (int i = low; i <= high; i++) {
	      helper[i] = numbers[i];
	    }
	    
	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while(i <= middle && j <= high) {
	    	if(helper[i] <= helper[j]) {
	    		numbers[k] = helper[i];
	    		i++;
	    	} else {
	    		numbers[k] = helper[j];
	    		j++;
	    	}
	    	k++;
	    }
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) {
	      numbers[k] = helper[i];
	      k++;
	      i++;
	    }
	    
	}

}
