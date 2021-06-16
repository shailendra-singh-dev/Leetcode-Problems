package problems.arrays;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
 * https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * https://www.youtube.com/watch?v=5nMGY4VUoRY&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=3
 * @author ssingh42
 *
 */
public class FindTheMissingAndRepeatingNumber {
	
	public void test() {
		int[] a= {3, 1, 3};
		 int[] result=getMissingAndRepeatingNumbersV2(a);
		 System.out.println(Arrays.toString(result));
	}	
	
	/**Solution 1: Using Count Sort
	 * Time Complexity:O(n)
	 * Space Complexity: O(n) 
	 * @param a
	 * @return
	 */
	public int[] getMissingAndRepeatingNumbersV1(int[] a) {
		int[] result = new int[2];
		if(a == null || a.length ==0) {
			return result;	
		}
		int[] frequency_array = new int[a.length+1];
		for(int i=0;i<a.length;i++) {
			frequency_array[a[i]]++;
		}
		for(int i=1;i<frequency_array.length;i++) {
			if(frequency_array[i] >1)
				result[0] = i; 
			if(frequency_array[i] ==0)
				result[1] = i;	
		}	
		return result;
	}
	
	/**
	 * Solution 2: Using Maths.
	 * Time Complexity:O(n)
	 * Space Complexity: O(n)  
	 * @param a
	 * @return
	 */
	private int[] getMissingAndRepeatingNumbersV2(int[] a) {
		int[] result = new int[2];
		if(a == null || a.length ==0) {
			return result;	
		}
		/**
		 * x-y=S (n*(n+1)/2)
		 * x²-y²=P (n*(n+1)*(2*n+1)/6)
		 * (x-y)(x+y)=P
		 * x+y=P/S
		 * x=(S+P/S)/2
		 * y=x-S
		 */
		int n = a.length, x = 0, y = 0;
		int S = (n * (n + 1)) / 2, P = (n * (n + 1) * (2 * n + 1)) / 6;
		for (int i = 0; i < a.length; i++) {
			S -= a[i];
			P -= Math.pow(a[i], 2);
		}
		x = (S + P / S) / 2;
		y = x-S;
		return new int[] { x, y };
	}
}
