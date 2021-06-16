package main.utilities.graph;

import java.util.LinkedList;

public class Node {
	
	public int id;
	public LinkedList<Node> adjacentNodes = new LinkedList<>();
	 
	public Node (int id) {
		this.id= id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Node node = (Node) obj;
		return id == node.id;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("id=" + id);
		stringBuilder.append(",AdjacentNodes=");
		for(Node child:adjacentNodes) {
			stringBuilder.append(child.id);
			stringBuilder.append(",");
		}
		return stringBuilder.toString().substring(0,stringBuilder.toString().length()-1);
	}
	
}
