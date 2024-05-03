package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

public class RotateLinkedList {
	
	/*
	 *Time Complexity: O(length of list) + O(length of list - (length of list%k))
      Reason: O(length of the list) for calculating the length of the list. O(length of the list - (length of list%k)) for breaking link.
      Space Complexity: O(1)
      Reason: No extra data structure is used for computation. 
	 */
	public static Node rotateRight(Node head,int k) {
	    if(head == null||head.next == null||k == 0) return head;
	    //calculating length
	    Node temp = head;
	    int length = 1;
	    while(temp.next != null) {
	        ++length;
	        temp = temp.next;
	    }
	    //link last node to first node
	    temp.next = head;
	    k = k%length; //when k is more than length of list
	    int end = length-k; //to get end of the list
	    while(end--!=0) temp = temp.next;
	    //breaking last node link and pointing to NULL
	    head = temp.next;
	    temp.next = null;
	        
	    return head;
	}
	
	public static void test() {
		// 1->2->6->3->4->5->6
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		Node head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;

		LinkedList.printList(head);
		LinkedList.printList(rotateRight(head, 2));
	}

}
