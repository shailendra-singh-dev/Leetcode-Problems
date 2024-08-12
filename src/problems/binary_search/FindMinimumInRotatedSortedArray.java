package problems.binary_search;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

	/**
	 *  Time Complexity: O(logN), N = size of the given array.
		Reason: We are basically using binary search to find the minimum. 		
		Space Complexity: O(1)
		Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).
	 */
	public int findMin(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int ans = Integer.MAX_VALUE;
		int low = 0, high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if(a[low] <= a[high]) { // a[low] <= a[mid] && a[mid] <= a[high]
				ans = Math.min(ans, a[low]);
				break;
			}
			
			if (a[low] <= a[mid]) {
				//First half is sorted.
				ans = Math.min(ans, a[low]);
				low = mid + 1;				
			} else {
				//Second half is sorted.
				ans = Math.min(ans, a[mid]);
				high = mid - 1;
			}
		}
		return ans;
	}

	public void test() {
		//int[] a = { 3,4,5,1,2};
		int[] a = {4,5,6,7,0,1,2};
		System.out.println(findMin(a));
	}
}
