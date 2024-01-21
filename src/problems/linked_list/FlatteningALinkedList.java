package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

public class FlatteningALinkedList {
	
	public void test() {
		Node node5 = new Node(1);
		Node node7 = new Node(2);
		Node node8 = new Node(3);
		Node node30 = new Node(4);
		node5.bottom=node7;
		node7.bottom=node8;
		node8.bottom=node30;
		
		Node node10= new Node(10);
		node5.next= node10;
		
		Node node19 = new Node(19);
		Node node22 = new Node(22);
		Node node50 = new Node(50);
		node10.next= node19;
		node19.bottom=node22;
		node22.bottom=node50;
		
		Node node28= new Node(28);
		node19.bottom=node28;

		LinkedList.printList(node5);
		LinkedList.printList(flatten(node5));
	}

	
	/**
	 * Time Complexity: O(N), where N is the total number of nodes present. Reason: We are visiting all the nodes present in the given list.
       Space Complexity: O(1). Reason: We are not creating new nodes or using any other data structure.
	 */
	private Node flatten(Node root) {
		if (root == null || root.next == null) {
			return root;
		}
		root.next = flatten(root.next);
		root = mergeTwoList(root, root.next);
		return root;
	}
	
	private Node mergeTwoList(Node a, Node b) {
		Node temp = new Node(0);
		Node res = temp;
		while (a != null && b != null) {
			if (a.data < b.data) {
				temp.bottom = a;
				a = a.bottom;
				temp = temp.bottom;
			} else {
				temp.bottom = b;
				b = b.bottom;
				temp = temp.bottom;
			}
		}
		if (a != null) {
			temp.bottom = a;
		}
		if (b != null) {
			temp.bottom = b;
		}
		return res.bottom;
	}

}
