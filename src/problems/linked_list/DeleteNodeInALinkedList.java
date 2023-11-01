package problems.linked_list;

import main.utilities.Node;

public class DeleteNodeInALinkedList {

	public void test() {
		//list1 = [1,2,4], list2 = [1,3,4]
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node1=new Node(1);
		Node node9=new Node(9);
		
		node4.next= node5;
		node5.next= node1;		
		node1.next= node9;
		
		Node.printList(node4);
		deleteNode(node5);
		System.out.println();
		Node.printList(node4);
	}
	
	
	/**
	 * Solution: Optimal, Iterative. 
	 * Time Complexity: O(n) 
	 * Space Complexity O(1)
	 */
	public void deleteNode(Node node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}
}
