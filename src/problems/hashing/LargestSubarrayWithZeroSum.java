package problems.hashing;

import java.util.HashMap;

/**
 * https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
 * https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
 * https://leetcode.com/discuss/general-discussion/1042029/find-length-of-the-largest-subarray-with-sum-0
 */
public class LargestSubarrayWithZeroSum {

	/**
	 * Time Complexity: O(N), as we are traversing the array only once.
	   Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into our hashmap.
	 */
	public int maxSubArray(int[] nums, int n) {
		if (nums == null || n == 0) {
			return 0;
		}
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int sum = 0, maxIndex = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (sum == 0) {
				maxIndex = i + 1;
			} else {
				if (hashMap.get(sum) != null) {
					maxIndex = Math.max(maxIndex, i - hashMap.get(sum));
				} else {
					hashMap.put(sum, i);
				}
			}
		}
		return maxIndex;
	}
	
	public void test() {
		int[] nums = {15,-2,2,-8,1,7,10,23};
		int n = nums.length;
		System.out.println(maxSubArray(nums, n));
		
	}

}
