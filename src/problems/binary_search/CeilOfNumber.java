package problems.binary_search;

/*
 * https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
 */
public class CeilOfNumber {
	
	// Lower bound
	public int getCeil(int[] a, int x) {
		int pos = a.length;
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

	public void test() {
		int[] a = { 3, 4, 4, 7, 8, 10 };
		System.out.println(getCeil(a, 8));
	}
}
