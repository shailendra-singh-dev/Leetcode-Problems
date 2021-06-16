package problems.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * 
 * @author ShSingh
 *
 */

public class RunningSumOf1dArray {

	public static int[] getRunnningSumV1(int[] a) {
		for (int i = 1; i < a.length; i++) {
			a[i] += a[i - 1];
		}
		return a;
	}

	public static void test() {
		int[] a = new int[] { 1, 2, 3, 4 };
		int[] b = getRunnningSumV1(a);
		System.out.println(Arrays.toString(b));
	}

	public int[] getRunnningSumV2(int[] nums) {
		int[] temp = new int[nums.length];

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <= i && j < nums.length; j++) {
				sum += nums[j];
			}
			temp[i] = sum;
			sum = 0;
		}
		return temp;
	}

}
