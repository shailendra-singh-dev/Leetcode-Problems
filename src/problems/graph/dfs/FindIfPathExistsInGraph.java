package problems.graph.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import main.utilities.graph.Node;

//https://leetcode.com/discuss/interview-question/1408211/3-dfs-for-graphs

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/
 * @author ShSingh
 */
public class FindIfPathExistsInGraph {

	private HashMap<Integer,Node>  nodeLookup= new HashMap<>();
	
	public Node getNode(int id) {
		return nodeLookup.get(id);
	}
	
	public void addEdge(int source,int destination, boolean isUndirectedGraph) {
		Node sourceNode = nodeLookup.get(source);
		Node destinationNode = nodeLookup.get(destination);
		sourceNode.adjacentNodes.add(destinationNode);
		if(isUndirectedGraph) 
			destinationNode.adjacentNodes.add(sourceNode);
	}
	
	private boolean hasDFS(int source, int destination) {
		Node sourceNode = nodeLookup.get(source);
		Node destinationNode = nodeLookup.get(destination);
		HashSet<Node> visited= new HashSet<>();
		return hasDFS(sourceNode, destinationNode, visited); 
	}

	private boolean hasDFS(Node sourceNode, Node destinationNode, HashSet<Node> visited) {
		if(visited.contains(sourceNode)) {
			return false;
		}
		visited.add(sourceNode);
		if(sourceNode == destinationNode) {
			return true;
		}
		for(Node child: sourceNode.adjacentNodes) {
			if(hasDFS(child, destinationNode, visited)) {
				System.out.println("child=" + child);
				return true;
			}
		}
		return false;
	}

    public boolean validPath(int n, int[][] edges, int source, int destination) {
    	for(int i=0;i < n;i++) {
    		nodeLookup.put(i,new Node(i));
    	}
    	for(int i=0;i < edges.length;i++) {
    		int[] array = edges[i];
    		addEdge(array[0],array[1], true);
    	}
    	return hasDFS(source, destination);
    }
    
    private void printGraph() {
    	for(Map.Entry<Integer, Node> entry:nodeLookup.entrySet()) {
    		System.out.println(entry.getValue());
    	}
    }

    public void test() {
    	//Input1
    	
    	int[][] edges = new int[][] { {0,1},{1,2},{2,0} };
    	int n = 3, source = 0, destination = 2;
    	
    	//Input2
    	/**
    	int[][] edges = new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}};
    	int n = 6, source = 0, destination = 5;
    	**/
    	
    	//Input3
    	/**
    	int[][] edges = new int[][] {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
    	int n = 10, source = 7, destination = 5;
    	**/
    	
    	System.out.println(validPath(n, edges, source, destination));
    	printGraph();
    }
}
