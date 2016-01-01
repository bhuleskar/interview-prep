package sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7,10,1 };
		
 
		int low = 0;
		int high = x.length - 1;
 
		quickSort(x, low, high);
		
		//Result Sorted
		for(int i=0 ; i<x.length ; i++){
			System.out.print(x[i]+" ");
		}
		
	}
	
	private static void quickSort(int[] array,int low,int high) {
		if(array == null || array.length == 0) return;
		if(low >= high) return;
		
		int middle = low + (high-low)/2;
		int pivot = array[middle];
		
		//make left < pivot < right
		int i = low;
		int j = high;
		
		while(i <= j) {
			while(array[i] < pivot) {
				i++;
			}
			while(array[j] > pivot) {
				j--;
			}
			if(i<=j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		// recursively sort two sub parts
		if (low < j)
			quickSort(array, low, j);
 
		if (high > i)
			quickSort(array, i, high);
	}
}
