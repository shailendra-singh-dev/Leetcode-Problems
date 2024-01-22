package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/?envType=list&envId=9d4v7ldm
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/#google_vignette
 */
public class TwoSum {
	public void test() {
		// int[] a= new int[] {2,7, 11, 15};
		// int[] a = new int[] { 3, 3 };
		int[] a = new int[] { 3, 2, 4 };
		int target = 6;
		//twoSumV1(a, target);
		System.out.println(Arrays.toString(twoSumV2(a, target)));
	}

	/**
	 * Time Complexity: O(N), where N = size of the array.
       Reason: The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).
       Space Complexity: O(N) as we use the map data structure.
	 */
	public int[] twoSumV2(int[] nums, int target) {
		int[] res = new int[] { -1, -1 };
		if (null == nums || nums.length == 0) {
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[1]= i;
				res[0]= map.get(target - nums[i]);
				break;
			}else {
				map.put(nums[i], i);
			}			
		}
		return res;
	}

	public void twoSumV1(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		while (left != right) {
			if (nums[left] + nums[right] == target) {
				System.out.println("YES");
				return;
			} else {
				if (nums[left] + nums[right] < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		System.out.println("NO");
	}

}
