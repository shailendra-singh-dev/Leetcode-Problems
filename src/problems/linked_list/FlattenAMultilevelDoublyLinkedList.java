package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://www.youtube.com/watch?v=rbXeQ0E7v70&t=457s
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list
 * 
 * @author shailendra
 *
 */
public class FlattenAMultilevelDoublyLinkedList {

	/**
	 * Time Complexity: O(N), where N is the total number of nodes present. Reason: We are visiting all the nodes present in the given list.
       Space Complexity: O(1). Reason: We are not creating new nodes or using any other data structure.
	 */
	public Node flatten(Node root) {
		if (root == null) {
			return null;
		}
		Node it = root;
		while (it!= null) {
			if (it.child != null) {
				// For setting later in next level.
				Node next = it.next;

				it.next = flatten(it.child);
				it.next.previous = it;
				it.child = null;
				

				//Move till last node
				while (it.next != null) {
					it = it.next;
				}
								
				//Stich to next from previous level. 
				if (next != null) {
					it.next = next;
					it.next.previous = it;
				}
			}
			it = it.next;
		}
		return root;
	}
	
	public void test() {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node6=new Node(6);
		Node node7=new Node(7);
		Node node8=new Node(8);
		Node node9=new Node(9);
		Node node10=new Node(10);
		Node node11=new Node(11);
		Node node12=new Node(12);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node3.child=node7;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		
		node7.next=node8;
		node8.next=node9;
		node8.child=node11;		
		node9.next=node10;
		node10.next=null;
		
		node11.next=node12;
		node12.next=null;
		
		LinkedList.printList(flatten(node1));
		
	}

}
