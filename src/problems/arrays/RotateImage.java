package problems.arrays;

import java.util.Arrays;

public class RotateImage {
	
	public void test() {
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}	
		};
		rotate(matrix);
	}
	
	private void print(int[][] matrix) {
		//transpose.
        int row = matrix.length, col= matrix[0].length;
        for(int i=0;i<row;i++){
        	 System.out.println();
            for(int j=0;j<col;j++){
                System.out.print(" "+matrix[i][j]);
            }
        }
	}

	public void rotate(int[][] matrix) {
        //transpose.
        int row = matrix.length, col= matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int temp=matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        // Reverse each row .
        for(int i=0;i<row;i++){
            for(int j=0;j<row/2;j++){
                int temp=matrix[i][j];
                matrix[i][j] = matrix[i][col-j-1];
                matrix[i][col-j-1]= temp;
            }
        }
        print(matrix);
    }
}
