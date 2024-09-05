package problems.hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	
	/*
	 * Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
	   Reason: O(N) for putting all the elements into the set data structure. 
	   After that for every starting element, we are finding the consecutive elements. 
	   Though we are using nested loops, the set will be traversed at most twice in the worst case. 
	   So, the time complexity is O(2*N) instead of O(N2).
	   Space Complexity: O(N), as we are using the set data structure to solve this problem.
	*/
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		HashSet<Integer> hashset = new HashSet<Integer>();
		for (int num : nums) {
			hashset.add(num);
		}

		int maxSequence = 0;
		for (int num : nums) {
			int currentSequence = 1;
			if (!hashset.contains(num - 1)) {
				int currentNum = num;
				while (hashset.contains(currentNum + 1)) {
					currentNum += 1;
					currentSequence += 1;
				}
			}
			maxSequence = Math.max(maxSequence, currentSequence);
		}
		return maxSequence;
	}

	public void test() {
		 int[] nums = {100,4,200,1,3,2};
		 System.out.println(longestConsecutive(nums));
	}
}
