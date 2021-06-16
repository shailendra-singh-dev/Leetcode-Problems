package problems.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/missing-number/
 * @author ShSingh
 *
 */
public class MissingNumber {

	public static void test() {
		int[] a = new int[] { 3, 0, 1 };
		System.out.println(Arrays.toString(a));
		int missingNumber = missingNumberV4(a);
		System.out.println(missingNumber);
	}

	public static int missingNumberV4(int[] a) {
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int low = 0, high = a.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (mid < a[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		if(low >= a[low]) {
			return a.length;
		}
		return low;
	}

	public static int missingNumberV3(int[] a) {
		HashSet<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}
		int lengthExpected = a.length + 1; // Including missing number , length would be (a.length+1)
		for (int i = 0; i < lengthExpected; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	public static int missingNumberV2(int[] a) {
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		if (0 != a[0]) {
			return 0;
		} else if (a[a.length - 1] != a.length) {
			return a.length;
		}
		for (int i = 1; i < a.length; i++) {
			int expectedNumer = a[i - 1] + 1;
			if (expectedNumer != a[i]) {
				return expectedNumer;
			}
		}
		return -1;
	}

	public int missingNumberV1(int[] nums) {
		int n = nums.length;
		int sum1 = (n * (n + 1)) / 2, sum2 = 0;
		for (int i = 0; i < nums.length; i++) {
			sum2 += nums[i];
		}
		int missingNumber = sum1 - sum2;
		return missingNumber;
	}
}
