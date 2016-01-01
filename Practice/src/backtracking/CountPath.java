package backtracking;

public class CountPath {

	public int countPath(int[][] matrix,int i,int j,int N) {
		if(i > N || j > N) return 0;
		
		if(i == N-1 && j == N-1 ){
			return 1;
		}
		
		return countPath(matrix, i+1, j,N) + countPath(matrix, i, j+1,N);
	}
	public static void main(String[] args) {
		int N = 4;
		int[][] matrix = new int[N][N];
		
		CountPath c = new CountPath();
		System.out.println(c.countPath(matrix, 0, 0,N));
	}

}



