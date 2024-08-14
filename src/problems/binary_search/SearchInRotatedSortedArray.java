package problems.binary_search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

	/**
	 * Time Complexity: O(logN), N = size of the given array.Reason: We are using binary search to search the target.
	   Space Complexity: O(1). Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int low = 0, high = nums.length -1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (target == nums[mid]) {
				return mid;
			}

			// Check if left half is sorted.
			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target <= nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (nums[mid] <= target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public void test() {
		 int[] nums = {1};//{4,5,6,7,0,1,2}; //{4,5,6,7,0,1,2}; 
		 int target = 0;//3;//0;
		 System.out.println(search(nums, target));
	}
}
