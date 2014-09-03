import java.util.Arrays;

//1. Assume matrix is a N * M array. matrix.length = N 
public class Question1_7 {
	
	public static void nullifyRow(int[][] matrix, int row) {
		for(int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
	
	public static void nullifyCol(int[][] matrix, int col) {
		for(int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}
	
	public static void setZero(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		//check if first row has zero
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0){
				rowHasZero = true;
				break;
			}
		}
		
		//check if first col has zero
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j ++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				nullifyCol(matrix, i);
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		
		if(rowHasZero) {
			nullifyRow(matrix, 0);
		}
		
		if(colHasZero) {
			nullifyCol(matrix, 0);
		}			
	}
	public static void main(String[] args) {
		int[][] matrix = {{2,1,5,7,0}, {2,1,3,7,9},{2,4,0,2,0}};
		setZero(matrix);
		for(int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}
