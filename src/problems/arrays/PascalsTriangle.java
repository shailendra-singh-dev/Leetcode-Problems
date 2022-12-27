package problems.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
 * 
 * @author ssingh42
 */
public class PascalsTriangle {
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> row, prev = null;
		for (int i = 0; i < numRows; i++) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(prev.get(j - 1) + prev.get(j));
				}				
			}
			prev = row;
			result.add(row);
		}
		return result;
	}
	
	public void test() {
		List<List<Integer>> result = generate(5);
		for(List<Integer> row:result) {
			System.out.println(row);
		}
	}
}
