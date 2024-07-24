package problems.binary_search;

/*
 * https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
 */
public class FloorOfNumber {
	
	public int getFloor(int[] a, int x) {
		int pos = a.length;
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
		int[] a = { 3, 4, 4, 7, 8, 10 };
		System.out.println(getFloor(a, 5));
	}
}
