package problems.arrays;

import java.util.Arrays;

public class GlobalAndLocalInversions {

	public void test() {
		int[] arr = { 1,0,2};
		System.out.println(isIdealPermutation(arr));
	}

	/**
	 * https://leetcode.com/problems/global-and-local-inversions/solutions/113644/c-java-python-easy-and-concise-solution/
	 */
	public boolean isIdealPermutation(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length - 2; i++) {
			max = Math.max(max, A[i]);
			if (max > A[i + 2]) {
				return false;
			}
		}
		return true;
	}

}
