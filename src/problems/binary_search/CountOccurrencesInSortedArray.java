package problems.binary_search;

import java.util.Arrays;

/**
 * https://leetcode.com/discuss/interview-question/algorithms/124724/facebook-onsite-count-occurrences-of-a-number-in-a-sorted-array
 * https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/
 */
public class CountOccurrencesInSortedArray {
	
	//For Both 
		/**
		 * Time Complexity: O(logN), where N = size of the given array.
		   Reason: We are basically using the Binary Search algorithm.		
		   Space Complexity: O(1) as we are using no extra space.
		 */
	
	public int count(int[] nums, int target) {
		FirstAndLastPositionOfElementInSortedArray obj = new FirstAndLastPositionOfElementInSortedArray();
		if (obj.getFirstPosition(nums, target) == -1) {
			return 0;
		}
		return obj.getLastPosition(nums, target) - obj.getFirstPosition(nums, target) + 1;
	}

	public void test() {
		int[] nums = { 2, 2, 3, 3, 3, 3, 4 };
		int target = 3;
		System.out.println(count(nums, target));
	}
}
