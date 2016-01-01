package array;

public class RemoveDuplicates {
	
	public int removeDuplicates(int[] A) {
	      int length = A.length; 
	      if(length == 0 || length == 1) return length;
	      
	      int i = 1; 
	      for(int j=1; j<length; j++) 
	      {
	        if(A[j] != A[j-1])
	        {
	          A[i]=A[j]; 
	          i++; 
	        }
	      }
	      
	      if(i < length) 
	    	  A[i]='\0';
	      return i; 
	    }
	
	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		int[] A = {1,2,3,4,4,5,5};
		int k = r.removeDuplicates(A);
		
		for(int i=0 ; i <k ; i++){
			System.out.print(A[i]+" ");
		}

	}

}
