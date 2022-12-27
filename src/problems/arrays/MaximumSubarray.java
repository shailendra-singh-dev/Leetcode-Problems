package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
	
	public void test() {
		int[] a= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(a));
		System.out.println(getMaxSubArray(a));
		
	}
	
	/**
	 * It will return max sum of sub array irrespective of positive/negative sum. 
	 */
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int currentMax = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			currentMax = Math.max(currentMax + nums[i], nums[i]);
			max = Math.max(currentMax, max);
		}
		return max;
	}
	
	/**
	 * It will return sub array containing positive sum.
	 */
	public ArrayList<Integer> getMaxSubArray(int[] nums) {
		int max = nums[0], sum = 0, start = 0, end = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum < 0) {
				sum = 0;
				start = i + 1;
			}
			if (sum > max) {
				max = sum;
				end = i;
			}
		}
		ArrayList<Integer> result= new ArrayList();
		for (int i = start; i<= end; i++) {
			result.add(nums[i]);
		}
		return result;
	}
	
}
