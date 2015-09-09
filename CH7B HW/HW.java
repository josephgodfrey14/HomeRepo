import java.util.*;
public class HW {
	public static void main(String args[]){
		int[][] matrix = {{1,0,1},{3,4,2},{9,5,1},{3,5,5}};
		System.out.println(Arrays.toString(colSums( matrix)));
		
	}
	public static int[] colSums(int[][] matrix){
		int[] newMatrix = new int[matrix.length-1];
		for (int col = 0; col< matrix[0].length; col++){
			int colSum = 0;
			for (int row=0; row<matrix.length; row++){
				colSum = colSum + matrix[row][col];
			}
			newMatrix[col]=colSum;
		}
		return newMatrix;
	}
	
}
