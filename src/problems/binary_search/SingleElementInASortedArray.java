package problems.binary_search;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray {

	/**
	  Time Complexity: O(logN), N = size of the given array.
	  Reason: We are basically using the Binary Search algorithm.
      Space Complexity: O(1) as we are not using any extra space.
	 */
	public int getSingleElement(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int low = 0, high = a.length - 2;
		while (low <= high) {
			int mid = (low + high) >> 1;
			/** In order to check for left half
				1.1st instance even
				2.2nd instance odd **/	 
			if (a[mid] == a[mid ^ 1]) {
				low = mid + 1;				
			} else {
				high = mid - 1;
			}
		}
		return a[low];
	}
	
	public void test() {
		int[] a= {3,3,7,7,10,11,11}; //{1,1,2,3,3,4,4,8,8};
		System.out.println(getSingleElement(a));
	}
}
