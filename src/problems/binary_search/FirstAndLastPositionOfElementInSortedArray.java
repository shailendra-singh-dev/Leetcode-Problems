package problems.binary_search;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class FirstAndLastPositionOfElementInSortedArray {
	
	//For both 
	/**
	 * Time Complexity: O(logN), where N = size of the given array.
	   Reason: We are basically using the Binary Search algorithm.		
	   Space Complexity: O(1) as we are using no extra space.
	 */
	public int getFirstPosition(int[] a, int target) {
		int first = -1;
		int low = 0, high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == target) {
				first = mid;
				high = mid - 1;
			} else if (a[mid] < target) {
				low = mid + 1;								
			} else {
				high = mid - 1;
			}
		}
		return first;
	}
	
	public int getLastPosition(int[] a, int target) {
		int last = -1;
		int low = 0, high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == target) {
				last = mid;
				low = mid + 1;
			} else if (a[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return last;
	}
	
	public int[] searchRange(int[] a, int target) {
		int first = getFirstPosition(a, target);
		if(first == -1) {
			return new int[]{-1,-1};
		}
		int last = getLastPosition(a, target);
		return new int[] {first, last};
	}

	public void test() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 0;
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}
}
