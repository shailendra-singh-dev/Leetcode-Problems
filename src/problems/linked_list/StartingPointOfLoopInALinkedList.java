package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
   https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/#google_vignette 
 */
public class StartingPointOfLoopInALinkedList {

	public void test() {
		Node node1 = new Node(3);
		Node node2 = new Node(2);
		Node node3 = new Node(0);
		Node node4 = new Node(4);
		Node node5 = new Node(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		LinkedList.printList(node1);
		LinkedList.printList(detectCycle(node1));
	}

	/**
	 *   Time Complexity: O(N),Reason: We can take overall iterations and club them to O(N)
         Space Complexity: O(1), Reason: No extra data structure is used.
	 */
	public Node detectCycle(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node slow = head;
		Node fast = head;
		Node start = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (start != slow) {
					start = start.next;
					slow = slow.next;
				}
				return start;
			}
		}
		return start;
	}

}
