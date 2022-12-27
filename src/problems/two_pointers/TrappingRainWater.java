package problems.two_pointers;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

	public static void test() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int volume = new TrappingRainWater().trapV4(height);
		System.out.println("volume:" + volume);
	}

	/**
	 * https://www.youtube.com/watch?v=C8UjlJZsHBw
	 */
	// 1st Optimal Approach O(N) SPACE
	public int trap(int[] height) {
		int n = height.length;
		if (n <= 2) {
			return 0;
		}
		int[] leftMaxArray = new int[n];
		int[] rightMaxArray = new int[n];

		int leftMax = height[0];
		leftMaxArray[0] = 0;
		for (int i = 1; i < n; i++) {
			leftMaxArray[i] = leftMax;
			leftMax = Math.max(leftMax, height[i]);
		}

		int rightMax = height[n - 1];
		leftMaxArray[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			rightMaxArray[i] = rightMax;
			rightMax = Math.max(rightMax, height[i]);
		}

		int trappedWater = 0;
		for (int i = 0; i < n; i++) {
			if (height[i] < leftMaxArray[i] && height[i] < rightMaxArray[i]) {
				trappedWater += Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
			}
		}

		return trappedWater;
	}

	// Optimal O(1) SPACE
	public int trapV2(int[] height) {
		int n = height.length;
		if (n <= 2)
			return 0;

		int leftMaxArray = height[0];
		int rightMaxArray = height[n - 1];
		int trappedWater = 0;
		int leftMax = 1; // Left pointer
		int rightMax = n - 2; // Right pointer
		while (leftMax <= rightMax) {
			if (leftMaxArray < rightMaxArray) {
				if (height[leftMax] >= leftMaxArray)
					leftMaxArray = height[leftMax];
				else
					trappedWater += leftMaxArray - height[leftMax];
				leftMax += 1;
			} else {
				if (height[rightMax] > rightMaxArray)
					rightMaxArray = height[rightMax];
				else
					trappedWater += rightMaxArray - height[rightMax];
				rightMax -= 1;
			}
		}
		return trappedWater;
	}

    //Vanhack
	public int trapV3(int[] height) {
		int[] maxLeft = new int[height.length];
		int[] maxRight = new int[height.length];
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			max = Math.max(max, height[i]);
			maxLeft[i] = max;
		}
		max = 0;
		for (int i = height.length - 1; i >= 0; i--) {
			max = Math.max(max, height[i]);
			maxRight[i] = max;
		}
		int volume = 0;
		for (int i = 0; i < height.length; i++) {
			int space = Math.min(maxLeft[i], maxRight[i]);
			volume += (space - height[i]);
		}
		return volume;
	}
	
	public int trapV4(int[] height) {
		int left = 0, right = height.length - 1;
		int res = 0;
		int leftMax = 0, rightMax = 0;
		while (left <= right) {
			if (height[left] <= height[right]) {
				if (height[left] >= leftMax) {
					leftMax = height[left];
				} else {
					res += leftMax - height[left];
				}
				left++;
			} else {
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					res += rightMax - height[right];
				}
				right--;
			}
		}
		return res;
	}

}
