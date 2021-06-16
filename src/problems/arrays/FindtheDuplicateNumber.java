package problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import main.utilities.SortingAlgos;

/**
 * https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/
 * https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * @author ssingh42 
 */
public class FindtheDuplicateNumber {
	
	
	public void test() {
				//    0 1 2	3 4
		int[] nums = {3,1,3,4,2};
		int duplicate=findDuplicateV1(nums);
		System.out.println(duplicate);
	}
	

	/**Index Array
	 * Time Complexity : O(n), Space Complexity: O(n)
	 */
	public int findDuplicateV1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int[] indexes = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indexes[nums[i]] += 1 ;
		}
		System.out.println(Arrays.toString(indexes));
		for (int i = 0; i < indexes.length; i++) {
			if(indexes[nums[i]] > 1) {
				return nums[i];
			}
		}
		return -1;
	}

	
	/**
	 * Time Complexity : O(n), Space Complexity: O(n)
	 */
	public int findDuplicateV2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				int count= map.get(nums[i]);
				map.put(nums[i], count+1 );
			}
		}
		System.out.println(map);
		for (int i = 0; i < nums.length; i++) {
			int count= map.get(nums[i]);
			if(count > 1) {
				return nums[i];
			}
		}
		return -1;
	}
	
	/**
	 * Time Complexity : O(n), Space Complexity: O(n)
	 */
	public int findDuplicateV3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		HashSet<Integer> set= new HashSet<Integer>();
		for(int i=0;i<nums.length;i++) {
			if(!set.add(nums[i])) {
				return nums[i];
			}
		}
		return -1;
	}
	
	
	/**
	 *  Time Complexity : O(n*Logn), Space Complexity: O(1)
	 */
	public int findDuplicateV4(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		nums = SortingAlgos.quickSort(0,nums.length-1,nums); // 1,2,2,3,4.
		System.out.println(Arrays.toString(nums));
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] ==nums[i+1]) {
				return nums[i];
			}
		}
		return -1;
	}		
	
	/** Optimal.
	 * Time Complexity : O(n), Space Complexity: O(1) 
	 */
	public int findDuplicateV5(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int slow = nums[0];//1
		int fast = nums[0];//1
		do{
			slow = nums[slow]; // 3,2
			fast = nums[nums[fast]]; //2,2
		}while (slow!= fast);
		
		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
