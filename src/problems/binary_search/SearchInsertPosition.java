package problems.binary_search;

/**
 * https://leetcode.com/problems/search-insert-position/
 * https://takeuforward.org/arrays/search-insert-position/
 */
public class SearchInsertPosition {

	public int searchInsert(int[] a, int target) {
        int pos = a.length;
		int low = 0, high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] >= target) {
				pos = mid;
				//look for smaller index on the left
				high = mid - 1;
			} else {
				// look on the right
				low = mid + 1;
			}
		}
		return pos;
    }
	
	public void test() {
		int[] a = { 1,3,5,6 };
		int target = 7;
		System.out.println(searchInsert(a, target));
	}
	
}
