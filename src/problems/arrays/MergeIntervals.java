package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
 * https://leetcode.com/problems/merge-intervals/
 * 
 * @author ssingh42
 *
 */
public class MergeIntervals {
	
	public void test() {
		int[][] nums ={{1,3},{2,6},{8,10},{15,18}};
		nums=merge(nums);
		System.out.println(nums);
		for(int[] interval:nums) {
			System.out.println(interval[0]+","+interval[1]);
		}
	}
	
	public int[][] merge(int[][] intervals) {
		ArrayList<int[]> result = new ArrayList<int[]>();
		int start=intervals[0][0];
		int end=intervals[0][1];
		for(int[] interval:intervals) {
			if(interval[0] < end) {
				end = interval[1];
			}else {
				result.add(new int[] {start,end});
				start = interval[0];
				end = interval[1];
			}
		}
		result.add(new int[] {start,end});
		return result.toArray(new int[0][]);		
	}
}
