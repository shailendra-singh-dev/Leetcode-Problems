package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public void test() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}

	/**
	 * Time complexity: O(n^2)
	 * Space complexity:  O(3*k)  // k is the no.of triplets. 
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if ((i == 0) || (i > 0 && nums[i] != nums[i - 1])) {
				int low = i + 1, high = nums.length - 1;
				int sum = -nums[i];
				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						ArrayList<Integer> list = new ArrayList();
						result.add(Arrays.asList(nums[low],nums[high], nums[i]));

						while (low < high && nums[low] == nums[low + 1])
							low++;
						while (low < high && nums[high] == nums[high - 1])
							high--;

						low++;
						high--;
					} else if (nums[low] + nums[high] < sum) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		return result;
	}

}
