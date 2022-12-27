package problems.arrays;

public class MajorityElement {
	
	public void test() {
		int nums[] = { 3, 2, 3 };
		System.out.println("majorityElement:" + majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		int num = 0;
		int count = 0;
		for (int n : nums) {
			if (count == 0)
				num = n;
			if (num == n)
				count++;
			else
				count--;
		}
		if (count >= nums.length / 2)
			return num;
		return num;
	}
}
