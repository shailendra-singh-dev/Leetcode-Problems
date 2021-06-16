package problems.graph;

import java.util.Arrays;

public class UniquePathsII {

	public void test() {
		int[][] matrix1 = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] matrix2 = new int[][] { { 0, 0, 1, 0 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 } };

		int paths = uniquePathsWithObstacles(matrix1);
		System.out.println("uniquePathsWithObstacles:" + paths);
	}

	private int uniquePathsWithObstacles(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					paths[i][j] = 0;
				} else if (i == 0 && j == 0) {
					paths[i][j] = 1;
				} else if (i == 0) {
					paths[i][j] = paths[i][j - 1];
				} else if (j == 0) {
					paths[i][j] = paths[i - 1][j];
				} else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
		}
		for (int i = 0; i < m; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(" " + paths[i][j]);
			}
		}
		System.out.println();
		return paths[m - 1][n - 1];
	}

	public int uniquePathsWithObstaclesV1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] paths = new int[m][n];

		// First column
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				paths[i][0] = 1;
			} else {
				break;
			}
		}
		// First Row
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				paths[0][i] = 1;
			} else {
				break;
			}
		}
		// For others,it's total number of unique paths from and left.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] != 1) {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
		}
		return paths[m - 1][n - 1];

	}

	public int uniquePathsWithObstaclesV2(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int dp[][] = new int[m][n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1) {// If obstacle, no path is possible
					dp[i][j] = 0;
				} else if (i == m - 1 && j == n - 1) {// if no obstacle at bottom right
					dp[i][j] = 1;
				} else if (i == m - 1) {// robot is at last row - copy from next col
					dp[i][j] = dp[i][j + 1];
				} else if (j == n - 1) {// robot is at last column - copy from next row
					dp[i][j] = dp[i + 1][j];
				} else {
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1]; // i & j are good so add right and bottom value
				}
			}
		}

		return dp[0][0];
	}

	/**
	 * Explanation - base case - there is only one possible way to reach top left
	 * cell if there is no obstacle recursive step - at every other cell we can
	 * either come from left or top recursive step - at every other cell in the
	 * first row we can come from left recursive step - at every other cell in the
	 * first col we can come from top Time complexity - O(M * N ) Space complexity -
	 * O(M * N )
	 */
	public int uniquePathsWithObstaclesV3(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
