package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://leetcode.com/problems/palindrome-linked-list/ 
   https://takeuforward.org/data-structure/check-if-given-linked-list-is-plaindrome/ 
 * @author shailendra
 *
 */
public class PalindromeLinkedList {
	
	public void test() {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node2_=new Node(2);
		Node node1_=new Node(1);

		node1.next= node2;
		node2.next= node2_;
		node2_.next= node1_;
		LinkedList.printList(node1);
		System.out.println(isPalindrome(node1));		
	}	
	
	/**
	 * Time Complexity: O(N/2)+O(N/2)+O(N/2), Reason: O(N/2) for finding the middle element, reversing the list from the middle element, 
	 * and traversing again to find palindrome respectively.
	   Space Complexity: O(1)
	 */
	public boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		if (slow == null || fast == null) {
			return true;
		}
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = reverse(slow.next);
		slow = slow.next;
		
		while (slow != null) {
			if (slow.data != head.data) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
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
