package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * @author ShSingh
 *
 */

public class RemoveKFromList {

	public static void test() {
		// 1->2->6->3->4->5->6
		Node node1 = new Node(6);
		Node node2 = new Node(2);
		Node node6_1 = new Node(6);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6_2 = new Node(6);

		Node head = node1;
		node1.next = node2;
		node2.next = node6_1;
		node6_1.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6_2;
		node6_2.next = null;

		LinkedList.printList(head);
//		head = removeElementRecursive(head, 6);
//		head = removeElementIterativeV1(head, 6);
		head = removeElementIterativeV2(head, 6);
		LinkedList.printList(head);
	}

	private static Node removeElementRecursive(Node head, int k) {
		if (head == null)
			return null;
		
		if(head.next == null) {
			if(head.data == k)
				return null;
		}
		
		if (head.data == k)
			return removeElementRecursive(head.next, k);

		head.next = removeElementRecursive(head.next, k);

		return head;
	}

	private static void removeElementWithoutHead(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
	}

	private static Node removeElementIterativeV1(Node head, int k) {
		if(head.data == k) {
			head = head.next;
		}
		
		Node current = head;
		while (current != null) {
			if (current.data == k) {
				if (current.next != null) {
					removeElementWithoutHead(current);
				}
			}
			if (current.next.data == k) {
				current.next = current.next.next;
			}

			current = current.next;
		}
		return head;
	}

	private static Node removeElementIterativeV2(Node head, int k) {
		if (head.data == k)
			head = head.next;

		Node current = head;
		
		while (current != null) {
			if (current.next != null && current.next.data == k)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return head;
	}
}
