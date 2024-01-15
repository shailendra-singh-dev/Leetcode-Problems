package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/
 * 
 * @author shailendra
 *
 */
public class ReverseNodesInkGroup {

	public void test() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		LinkedList.printList(node1);
		LinkedList.printList(reverseKGroup(node1, 2));
	}

	/**
	 * Time Complexity: O(N),Nested iteration with O((N/k)*k) which makes it equal to O(N). 
	 * Space Complexity: O(1),No extra data structures are used for computation.
	 */
	public Node reverseKGroup(Node head, int k) {
		if (head == null || k == 1) {
			return head;
		}
		int length = 0;

		Node tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			length++;
		}

		Node temp = new Node(0);
		temp.next = head;

		Node prev = temp;
		Node curr;
		Node next;

		while (length >= k) {
			curr = prev.next;
			next = curr.next;
			for (int i = 1; i < k; i++) {
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			prev = curr;
			length -= k;
		}
		return temp.next;
	}
}
