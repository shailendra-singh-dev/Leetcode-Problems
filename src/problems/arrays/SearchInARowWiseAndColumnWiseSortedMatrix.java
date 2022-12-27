package problems.arrays;

public class SearchInARowWiseAndColumnWiseSortedMatrix {
	
	public void test() {
		int[][] a = { 
				{10, 20, 30, 40},  
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
		int target = 29;
		System.out.println(searchMatrix(a, target));
	}
	
	/*
	 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int low = 0, high = matrix.length + matrix[0].length;
		int mid = (low + high) / 2;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (target == matrix[i][j]) {
					System.out.println("Found at i=" + i + ",j=" + j);
					return true;
				}
				if (matrix[i][j] < target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return false;
	}
}
