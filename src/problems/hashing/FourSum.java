package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 * https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/
 */
public class FourSum {
	
	
	/**
	 * Time Complexity: O(N3), where N = size of the array.
	   Reason: Each of the pointers i and j, is running for approximately N times. 
	   And both the pointers k and l combined can run for approximately N times including the operation 
	   of skipping duplicates. So the total time complexity will be O(N3). 
	   Space Complexity: O(no. of quadruplets), This space is only used to store the answer.
	   We are not using any extra space to solve this problem. So, from that perspective, 
	   space complexity can be written as O(1).
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int n = nums.length;
		if (nums == null || n == 0) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int target2 = target - (nums[i] + nums[j]);
				int front = j + 1;
				int back = n - 1;
				while (front < back) {
					int two_sum = nums[front] + nums[back];
					if (two_sum < target2) {
						front++;
					} else if (two_sum > target2) {
						back--;
					} else {
						ArrayList<Integer> quad = new ArrayList<Integer>();
						quad.add(nums[i]);
						quad.add(nums[j]);
						quad.add(nums[front]);
						quad.add(nums[back]);
						res.add(quad);

						// Processing of duplication of number 3
						while (front < back && nums[front] == quad.get(2))
							++front;
						// Processing of duplication of number 4
						while (front < back && nums[back] == quad.get(3))
							--back;
					}
				}
				// Processing of duplication of number 2
				while (j + 1 < n && nums[j] == nums[j + 1])
					++j;
			}
			// Processing of duplication of number 1
			while (i + 1 < n && nums[i] == nums[i + 1])
				++i;
		}
		return res;
	}

	public void test() {
		int[] a = new int[] { 1, 0, -1, 0, -2, 2 };
		// int[] a = new int[] { 2,2,2,2,2 };
		int target = 0;// 0;
		// twoSumV1(a, target);
		System.out.println(fourSum(a, target));
	}

}
