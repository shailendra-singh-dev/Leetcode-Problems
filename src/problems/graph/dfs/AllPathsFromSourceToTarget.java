package problems.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * 
 * @author ShSingh
 *
 */
public class AllPathsFromSourceToTarget {
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		
		queue.add(Arrays.asList(0));
		int goalNode = graph.length-1;
		
		while(!queue.isEmpty()) {
			List<Integer> path = queue.poll();
			int lastNode = path.get(path.size()-1);
			if(lastNode == goalNode) {
				result.add(new ArrayList<>(path));
			}else{
				int[] neighbours= graph[lastNode];
				for(int child: neighbours) {
					ArrayList<Integer> children = new ArrayList<>(path);
					children.add(child);
					queue.add(children);
				}				
			}
		}			
		return result;
	}
	
	public void test() {
		int[][] graph = { {1,2}, {3}, {3},{}};
		ArrayList<List<Integer>> paths = (ArrayList<List<Integer>>) allPathsSourceTarget(graph);
		System.out.println(paths);
	}
}
