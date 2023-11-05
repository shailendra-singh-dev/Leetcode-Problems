package problems.linked_list;

import main.utilities.Node;

public class PalindromeLinkedList {
	
	public boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		if (slow == null || fast == null) {
			return false;
		}
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		slow.next = reverse(slow.next);
		slow = slow.next;
		while (slow != null && head != null) {
			if (slow == head) {
				return true;
			}
			slow = slow.next;
			head = head.next;
		}
		return false;
	}
	
	public Node reverse(Node head) {
		Node newHead = null;
		while (head != null) {
			Node next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}
