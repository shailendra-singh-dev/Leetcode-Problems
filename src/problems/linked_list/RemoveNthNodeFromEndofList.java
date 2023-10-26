package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=list&envId=9p9tccj2
 * https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/
 * @author shailendra
 *
 */
public class RemoveNthNodeFromEndofList {
	
	public void test() {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		//Node node6=new Node(6);
		//node1.next=node2;
		//node2.next=node3;		
		//node3.next=node4;
		//node4.next=node5;
		//node5.next=node6;
		int n=1;
		LinkedList.printList(removeNthNode(node1, n));
	}

	private Node removeNthNode(Node head, int n) {
		Node node=new Node();
		node.next = head;
		Node slow = node;
		Node fast = node;
		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return node.next;
	}
}
