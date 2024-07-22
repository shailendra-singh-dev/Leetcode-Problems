package problems.arrays;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * https://takeuforward.org/data-structure/contains-duplicate-check-if-a-value-appears-atleast-twice/ *
 */
public class ContainsDuplicate {
	
	private HashSet<Integer> set= new HashSet<>();
	
	/**
	 * Time Complexity:  O(N), where N is the length of the array. As searching hash_set takes O(1)
	   Space Complexity: O(N), Where N is the number of elements stored in the set
	 */
	public boolean containsDuplicate(int[] nums) {
		if(nums.length == 0) {
			return false;
		}
		for(int num:nums) {
			set.add(num);
		}
		return set.size() < nums.length;
    }
}
