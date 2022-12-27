package problems.arrays;

public class BestTimeToBuyAndSellStock {
	
	public void test() {
		int[] a= {7,1,5,3,6,4};
		System.out.println(maxProfit(a));
	}

	/**
	 * Time complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i]);
		}
		return maxProfit;
	}
}
