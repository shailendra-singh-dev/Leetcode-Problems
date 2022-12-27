package problems.arrays;

public class SearchA2DMatrix {

	
	public void test() {
		int[][] a ={
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,60}
			};
		int target = 13;
		System.out.println(searchMatrix(a, target));
	}
	/*
	 * https://leetcode.com/problems/search-a-2d-matrix/
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int N = matrix.length, M = matrix[0].length;
		int i = 0, j = M - 1;
		while (i < N && j >= 0) {
			if (matrix[i][j] == target) {
				System.out.println("Found at i="+i +",j="+ j);
				return true;
			}
			if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}
