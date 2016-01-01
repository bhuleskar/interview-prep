package backtracking;

public class AllPathsPrinter {
	/* mat:  Pointer to the starting of mXn matrix
	   i, j: Current position of the robot (For the first call use 0,0)
	   m, n: Dimentions of given the matrix
	   pi:   Next index to be filed in path array
	   *path[0..pi-1]: The path traversed by robot till now (Array to hold the
	                  path need to have space for at least m+n elements) */
   
	public void printAllPaths(int[][] array,int currX, int currY,int m,int n, String path){
 
    	// Reached the bottom of the matrix so we are left with
        // only option to move right
        if(currX == m-1){
            for(int j=currY;j<=n-1;j++){
                path = path + array[currX][j];
            }
            System.out.println("Path : " + path);
            return;
        }
        // Reached the right corner of the matrix we are left with
        // only the downward movement.
        if(currY == n-1){
            for(int i=currX;i<=m-1;i++){
                path = path + array[i][currY];
            }
            System.out.println("Path : " + path);
            return;
        }
        path = path + array[currX][currY];
        printAllPaths(array,currX+1, currY,m,n, path);
        printAllPaths(array,currX, currY+1,m,n, path);
 
    }
 
    public static void main(String args[]){
 
    	int m = 3;
    	int n = 3;
        int [][] array = new int[][]{{1, 2, 3}, {4, 5, 6},{7,8,9}};
        AllPathsPrinter allPathsPrinter = new AllPathsPrinter();
        allPathsPrinter.printAllPaths(array,0,0,m,n,"");
 
 
    }
 
 
}

