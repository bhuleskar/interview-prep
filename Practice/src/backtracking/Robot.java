package backtracking;

public class Robot {

	/*
	 * Given a 2D maze, and a bot at a random position, which can go in either 4 directions, 
	 * there is gold in one of the blocks of the maze and also some cells are blocked. 
	 * find the cell with gold. This will find out all the possible routs 
	 */
	public void findTheCell(int[][] matrix,int i,int j) {
		if(i>3 || j>3) return;
		
		if(matrix[i][j] == 1){
			return;
		}
		if(matrix[i][j] == 5){
			System.out.println("found gold at position"+i+j);
			return;
		}
		
		findTheCell(matrix, i+1, j);
		findTheCell(matrix, i, j+1);
	}
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		matrix[3][0] = 5;
		matrix[0][1] = 1;
		matrix[0][2] = 1;
		matrix[0][3] = 1;
		matrix[1][1] = 1;
		matrix[1][2] = 1;
		matrix[1][3] = 1;
		matrix[2][3] = 1;
		matrix[2][3] = 1;
		matrix[2][3] = 1;
		matrix[3][1] = 1;
		matrix[3][2] = 1;
		matrix[3][3] = 1;
		Robot b = new Robot();
		b.findTheCell(matrix, 0, 0);
	}

}
