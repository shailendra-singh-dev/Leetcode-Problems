package main.utilities;

public class Node implements Comparable<Node> {
	// reference to the next node in the chain,
	// or null if there isn't one.
	public Node next;
	public Node previous;
	public Node child;
	public Node bottom;
	public Node random;
	public int key;
	public int value;
	// data carried by this node.
	// could be of any type you need.
	public int data =-1;

	// Node constructor
	public Node(int _data) {
		next = null;
		this.data = _data;
	}
	
	public Node(int key,int value) {
		this.key = key;
		this.value = value;
	}
	
	public Node() {
		next = null;
		previous =null;
		child=null;
		bottom =null;
	}

	@Override
	public String toString() {
		return data == -1 ? "[]" : "[" + data + "]";
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals() called ");
		if (null == obj)
			return false;
		Node node = (Node) obj;
		return data == node.data;
	}

	@Override
	public int hashCode() {
		return data;
	}
	@Override
	public int compareTo(Node obj) {
		if (null == obj)
			return 0;

		if (data > obj.data) {
			return data - obj.data;
		} else if (data < obj.data) {
			return obj.data - data;
		} else {
			return 0;
		}
	}
	
	public static void printList(Node head) {
		Node current = head;
		while (null != current) {
			System.out.print(" " + current);
			current = current.next;
		}
	}

}
