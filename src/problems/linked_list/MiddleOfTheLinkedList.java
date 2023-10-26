package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/
 * @author shailendra
 *
 */
public class MiddleOfTheLinkedList {
	
	public void test() {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node6=new Node(6);
		node1.next=node2;
		node2.next=node3;		
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		LinkedList.printList(middleNode(node1));
	}
	
	public Node middleNode(Node head) {
        Node slow= head;
        Node fast= head;
        while(fast!= null && fast.next!=null) {
        	slow=slow.next;
        	fast=fast.next.next;
        }
        return slow;
    }
}
