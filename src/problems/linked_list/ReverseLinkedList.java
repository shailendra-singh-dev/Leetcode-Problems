package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/*
 * https://takeuforward.org/data-structure/reverse-a-linked-list/
 */
public class ReverseLinkedList {
	
	public void test() {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);		
		node1.next=node2;
		node2.next=node3;		
		node3.next=node4;
		node4.next=node5;
		
		LinkedList.printList(reverseList(node1));
	}

	public Node reverseList(Node head) {
		return recursive(head);
	}

	public Node iterative(Node head) {
		Node newHead = null;
		while (head != null) {
			Node next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

	public Node recursive(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node newHead = recursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
