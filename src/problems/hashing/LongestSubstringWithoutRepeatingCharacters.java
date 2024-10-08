package problems.hashing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public void test() {
		String str = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(str));
	}

	/**
	 * Time Complexity: O( N )
	   Space Complexity: O(N) where N represents the size of HashSet where we are storing our elements
	 */
	public int lengthOfLongestSubstring(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		int left = 0, right = 0, n = str.length() - 1 , len =0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while (right < n) {
			if (map.containsKey(str.charAt(right))) {
				left = Math.max(left, map.get(str.charAt(right)) + 1);
			}
			map.put(str.charAt(right), right);			
			len = Math.max(right - left + 1, len);
			right++;
		}
		return len;
	}

}
