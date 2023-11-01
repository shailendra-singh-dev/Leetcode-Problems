package problems.linked_list;

import main.utilities.Node;

public class IntersectionPointOfTwoLinkedLists {

	public void test() {
		//list1 = [1,2,4], list2 = [1,3,4]
		Node node1=new Node(4);
		Node node2=new Node(1);
		Node node3=new Node(8);
		Node node4=new Node(4);
		Node node5=new Node(5);
		node1.next= node2;
		node2.next= node3;
		node3.next= node4;
		node4.next= node5;
		
		Node node5_=new Node(5);
		Node node6=new Node(6);
		Node node1_=new Node(1);
		node5_.next= node6;
		node6.next= node1_;
		
		Node result = getIntersectionNode(node1,node4);
		Node.printList(result);		
	}
	
	/**
	 * Solution: Two Pointer approach
	 * Time Complexity: O(2*max(length of list1,length of list2))
	 * Space Complexity: O(1)
	 * */
	public Node getIntersectionNode(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return null;
		}
		Node a = headA;
		Node b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

}
