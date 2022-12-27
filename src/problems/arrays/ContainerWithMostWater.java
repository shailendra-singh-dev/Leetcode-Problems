package problems.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * @author ShSingh
 *
 */
public class ContainerWithMostWater {

	public static void test() {
		int[] a = new int[] {1,8,6,2,5,4,8,3,7};
		int maxArea= maxAreaV1(a);
		System.out.println("maxArea:"+ maxArea);
	}
	
	public static int maxAreaV1(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (i != j) {
					int area = Math.min(a[i], a[j]) * (j - i);
					if (area > max)
						max = area;
				}
			}
		}
		return max;
	}

	public static int maxAreaV2(int[] a) {
		int max = 0;
		int start = 0, end = a.length - 1;
		while (start < end) {
			int area = Math.min(a[start], a[end]) * (end - start);
			max = Math.max(area, max);
			if (a[start] < a[end]) {
				start++;
			} else {
				end--;
			}
		}
		return max;
	}

}
