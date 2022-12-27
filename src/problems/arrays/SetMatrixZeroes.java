package problems.arrays;

import java.util.Arrays;

public class SetMatrixZeroes {

	/**
	 * Time Complexity: O(N*M + N*M)
	 * Space Complexity: O(N)
	 */
	public void setZeroesV1(int[][] matrix) {
		int[] rows = new int[matrix.length];
		Arrays.fill(rows, -1);
		int[] columns = new int[matrix[0].length];
		Arrays.fill(columns, -1);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 0;
					columns[j] = 0;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rows[i] == 0 || columns[j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}		
	}

	/**
	 * Time Complexity: O(N*M + N*M)
	 * Space Complexity: O(1)
	 */
	public void setZeroesV2(int[][] matrix) {
		int col = 1;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				col = 0;
			}
			for (int j = 1; j < matrix[0].length; j++) {				
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i =matrix.length-1 ; i >=0 ; i--) {
			for (int j = matrix[0].length-1; j >=1 ; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
				if(col ==0) {
					matrix[i][0] = 0;
				}					
			}
		}
	}
}
