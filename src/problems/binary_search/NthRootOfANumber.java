package problems.binary_search;

/*
 * https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
 */
public class NthRootOfANumber {

	public int multiply(int mid, int n, int m) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= mid;	
			if (result > m) {
				return 2;
			}
			if (result == m) {
				return 1;
			}
		}		
		return 0;
	}

	/**
	 * Time complexity : N*LogM
	 * Space Complexity : O(1)
	 */
	public int getNthRoot(int n, int m) {
		if (n == 0 || m == 0) {
			return 1;
		}
		int low = 1, high = m;		
		while (low <= high) {
			int mid = (low + high) / 2;		
			int result = multiply(mid, n, m);
			if (result == 1) {
				return mid;
			} else if (result == 0) {
				low = mid + 1;				
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public void test() {
		int n = 3, m = 27;
		int ans = getNthRoot(n, m);
		System.out.println("The answer is: " + ans);
	}

}
