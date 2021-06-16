package problems.arrays;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
 * https://leetcode.com/problems/sort-colors/
 * https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2
 * 
 * @author ssingh42
 */

public class SortAnArrayOf_0s_1s_and_2s {

	
	public void test() {
		int[] nums= {2,0,2,1,1,0};
		sortColorsV2(nums);
	}
	
	/**
	 * Counting Sort. 
	 * Time complexity :O(n), Space Complexity:O(1). 3 pass.
	 * @param nums
	 */
	public void sortColorsV1(int[] nums) {
		if(nums == null || nums.length ==0) {
			return ;	
		}
		int count0 =0, count1=0, count2=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] == 0) {
				count0++;
			}else if(nums[i] == 1) {
				count1++;
			}else if(nums[i] == 2) {
				count2++;
			}
		}
		int i=0;
		while(count0-- > 0) {
			nums[i++] =0;
		}
		while(count1-- > 0) {
			nums[i++] =1;
		}
		while(count2-- > 0) {
			nums[i++] =2;
		}
		System.out.println(Arrays.toString(nums));
    }
	
	
	/*
	 * Optimal solution.Dutch National Flag Algorithm. 
	 * Time complexity :O(n), Space Complexity:O(1). 1 pass.
	 * @param nums
	 */
	private void sortColorsV2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		// 2 0 2 1 1 0
		int low = 0, high = nums.length - 1, mid = 0, temp=0;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			
			case 1:
				mid++;
				break;
			
			case 2:
				temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
				break;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	
}


