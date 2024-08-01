package problems.binary_search;

/**
 * https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
 */
public class FloorAndCeilInSortedArray {
	
	//For Both 
	/**
	 * Time Complexity: O(logN), where N = size of the given array.
	   Reason: We are basically using the Binary Search algorithm.		
	   Space Complexity: O(1) as we are using no extra space.
	 */

	// Lower bound
	public int getCeil(int[] a, int x) {
		int pos = -1;
		int low = 0, high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] >= x) {
				pos = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return a[pos];
	}

	
	public int getFloor(int[] a, int x) {
		int pos = -1;
		int low = 0, high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] <= x) {
				pos = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return a[pos];
	}

	public void test() {
		int target = 5;
		int[] a = { 3, 4, 4, 7, 8, 10 };
		System.out.println("Ceil:" + getCeil(a, target) + " ,Floor " + getFloor(a, target) + " of " + target);
		target = 8;
		System.out.println("Ceil:" + getCeil(a, target) + " ,Floor " + getFloor(a, target) + " of " + target);
	}

}
