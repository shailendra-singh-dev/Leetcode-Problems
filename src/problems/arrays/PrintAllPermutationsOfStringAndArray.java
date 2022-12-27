package problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutationsOfStringAndArray {

	List<List<Integer>> permutations = new ArrayList<List<Integer>>();

	/**
	 * Time Complexity: O(N! X N)
	 * Space Complexity: O(1)
	 */
	public List<List<Integer>> getAllPermutations(int index, int[] nums) {
		if (index == nums.length) {
			List<Integer> permutation = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				permutation.add(nums[i]);
			}
			permutations.add(new ArrayList<Integer>(permutation));
			System.out.println("getAllPermutations() permutations:" + permutations);
			return permutations;
		}
		for (int i = index; i < nums.length; i++) {
			swap(i, index, nums);
			permutations = getAllPermutations(index + 1, nums);
			swap(i, index, nums);
		}
		return permutations;
	}

	private void swap(int i, int index, int[] nums) {
		System.out.println("swap() b/w " + nums[i] + "," + nums[index]);
		int temp = nums[i];
		nums[i] = nums[index];
		nums[index] = temp;
	}

	public void test() {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> permutations = getAllPermutations(0, nums);
		System.out.println(permutations);
	}
}
