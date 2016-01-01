	package array;

public class MaxSubArray {

	private static int[] A = {1,2,-3,3,4};
	
 	public static void maxSubArray(){
 		int maxSum = Integer.MIN_VALUE;
 		int cumulativeSum = 0;
 		int maxStartIndex = 0;
 		int maxEndIndex = 0;
 		
 		int maxStartIndexUntilNow = 0;
 		
 		for(int currentIndex=0 ; currentIndex < A.length ; currentIndex++) {
 			cumulativeSum += A[currentIndex];
 			
 			if(cumulativeSum > maxSum) {
 				maxSum = cumulativeSum;
 				maxStartIndex = maxStartIndexUntilNow;
 				maxEndIndex = currentIndex;
 			}
 			if(cumulativeSum < 0) {
 				cumulativeSum = 0;
 				maxStartIndexUntilNow = currentIndex + 1;
 			}
 		}
 		
 		System.out.println("Max sum         : "+maxSum);
        System.out.println("Max start index : "+maxStartIndex);
        System.out.println("Max end index   : "+maxEndIndex);
 		
	}
 	
 	public static int subArray() {
 		int maxSum = Integer.MIN_VALUE;
 		int cumulativeSum = 0;
 		
 		for(int i=0 ; i<A.length ; i++) {
 			cumulativeSum = cumulativeSum + A[i];
 			
 			if(cumulativeSum > maxSum) {
 				maxSum = cumulativeSum;
 			}
 			if(cumulativeSum < 0) 
 				cumulativeSum = 0;
 		}
 		return maxSum;
 	}
 	
	public static void main(String[] args) {
		maxSubArray();
		System.out.println(subArray());

	}

}
