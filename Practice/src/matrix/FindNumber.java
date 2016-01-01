package matrix;

public class FindNumber {

	static int N = 4;
	private static int[][] table = new int[N][N];

	/*
	 * 2D matrix with nums increasing in right direction and downwards direction. 
	 * Search for a target number.
	 */
	public static void initialize() {
		for (int row = 0; row < N; row ++) {
			for (int col = 0; col < N; col++)
                table[row][col] =  ('1' + row * N + col);
		}
	}
	
	public static void print() {
        for (int row = 0; row < N; row ++) {
        	for (int col = 0; col < N; col++)
                System.out.print (table[row][col]+"    ");
            System.out.println();
        }
	}

	public static void printSpiral() {
		int row = 0;
		int maxRow = N-1;
		int column = 0;
		int maxColumn = N-1;
		
		while(true)
	    {
	         // Print top row
	         for(int j = column; j <= maxColumn; ++j) 
	        	 System.out.print(table[row][j] + " ");
	         row++;
	        
	         if(row > maxRow || column > maxColumn) 
	        	 break;
	         
	         //Print the rightmost column
	         for(int i = row; i <= maxRow; ++i) 
	        	 System.out.print(table[i][maxColumn] + " ");
	         maxColumn--;
	         
	         if(row > maxRow || column > maxColumn) 
	        	 break;
	         
	         //Print the bottom row
	         for(int j = maxColumn; j >= column; --j) 
	        	 System.out.print(table[maxRow][j] + " ");
	         maxRow--;
	         
	         if(row > maxRow || column > maxColumn) 
	        	 break;
	         
	         //Print the leftmost column
	         for(int i = maxRow; i >= row; --i) 
	        	 System.out.print(table[i][column] + " ");
	         column++;
	         
	         if(row > maxRow || column > maxColumn) 
	        	 break;
	     }
	}
	
	public static void findNumber(int value){
		int i = 0;
		int j = N - 1 ;
		
		while(j >= 0 && i < N) {
			if(table[i][j] == value) {
				System.out.println("Value found at index "+i+" and "+j);
				return;
			} else if(value > table[i][j]){
				i++;
			} else 
				j--;
		}
		System.out.println("Could not find the value");
	}
	
	public static void rotateMatrix(){
		for(int layer=0 ; layer < N/2 ;layer++){
			for(int i=layer ; i<N-1-layer ; i++){
				int temp = table[layer][i];
				table[layer][i] = table[N-1-i][layer];
				table[N-1-i][layer] = table[N-1-layer][N-1-i];
				table[N-1-layer][N-1-i] = table[i][N-1-layer];
				table[i][N-1-layer] = temp;
				
			}
		}
	}
	
	public static void main(String[] args) {
		initialize();
		print();
		System.out.println();
		findNumber(58);
		rotateMatrix();
		print();
		System.out.println("~~~~~~~");
		System.out.println("Print Spiral Order");
		printSpiral();

	}

}
