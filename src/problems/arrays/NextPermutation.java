package problems.arrays;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return;
		}
		int i = nums.length - 2;
		while (nums[i] >= nums[i + 1]) {
			i--;
		}
		int j = nums.length - 1;
		if (i >= 0) {
			while (nums[j] < nums[i]) {
				j--;
			}
		}
		swap(i, j, nums);
		reverse(i + 1, nums.length - 1, nums);
		System.out.println(Arrays.toString(nums));
	}

	private void reverse(int i, int j, int[] nums) {
		while (i < j)
			swap(i++, j--, nums);
	}

	private void swap(int i, int index, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[index];
		nums[index] = temp;
	}

	public void test() {
		int[] nums = new int[] { 1, 2, 3 };

		nextPermutation(nums);
	}

}
