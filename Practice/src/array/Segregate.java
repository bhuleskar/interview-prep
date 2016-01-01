package array;

public class Segregate {

	private static int[] arr = {2,4,6,8,1,3,5,7};
	
	//segregate 0 and 1
	public static void segregate0and1(int size)
	{
	    /* Initialize left and right indexes */
	    int left = 0, right = size-1;
	 
	    while (left < right)
	    {
	        /* Increment left index while we see 0 at left */
	        while (arr[left] == 0 && left < right)
	            left++;
	 
	        /* Decrement right index while we see 1 at right */
	        while (arr[right] == 1 && left < right)
	            right--;
	 
	        /* If left is smaller than right then there is a 1 at left
	          and a 0 at right.  Exchange arr[left] and arr[right]*/
	        if (left < right)
	        {
	            arr[left] = 0;
	            arr[right] = 1;
	            left++;
	            right--;
	        }
	    }
	}
	
	//segregate even and odd numbers
	public static void segregateOddAndEven(int size){
		int left = 0;
		int right = size - 1;
		
		while(left < right) {
			while(arr[left]%2 == 1 && left < right)
				left++;
			
			while(arr[right]%2 == 0 && left < right)
				right--;
			
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
			
		}
	}
	
	public static void main(String[] args) {
		segregateOddAndEven(arr.length);
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

}
