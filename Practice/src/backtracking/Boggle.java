//package backtracking;
//
//import java.util.ArrayList;
//
//public class Boggle {
//
//	/*Given a 2D maze and a dictionary, find all valid English words that can be made by walking left, 
//	 * right up or down. Borders are crossable i.e right from the last element in a row will take you
//	 *  to first at the row.
//	 */
//	public ArrayList<String> findWord(StringBuilder s,int i,int j,char[][] matrix) {
//		ArrayList<String> result = new ArrayList<String>();
//		s.append(matrix[i][j]);
//		if(isExist(s))
//			result.add(s.toString());
//		if(!isExist(s))
//			return result;
//		
//		findWord(s, i-1, j, matrix);
//		findWord(s, i+1, j, matrix);
//		findWord(s, i, j+1, matrix);
//		findWord(s, i, j-1, matrix);
//			
//	}
//	
//	private boolean isExist(StringBuilder s) {
//		
//	}
// 	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
