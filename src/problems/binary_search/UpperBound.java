package problems.binary_search;

/*
 * https://leetcode.com/discuss/study-guide/1675643/lower-bound-and-upper-bound
 * https://takeuforward.org/arrays/implement-upper-bound/
 * https://www.youtube.com/watch?v=6zhGS79oQ4k&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=5
 */
public class UpperBound {
	
	public void test() {
		int[] a = {1,2,3,4,6,6,8,11};
		System.out.println(upperBound(a, 6));
	}
	
	/*
	 * Time Complexity: O(logN), where N = size of the given array.
	   Reason: We are basically using the Binary Search algorithm.
       Space Complexity: O(1) as we are using no extra space.
	 */
	public int upperBound(int[] a, int target) {
		int pos = a.length;
		int low = 0, high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] > target) {
				pos = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return pos;
	}
}
