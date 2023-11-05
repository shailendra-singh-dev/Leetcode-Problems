package problems.linked_list;

import main.utilities.Node;

public class DetectACycleInLinkedList {
		
	public void test() {
		Node node3=new Node(3);
		Node node2=new Node(2);
		Node node0=new Node(0);
		Node node4=new Node(-4);

		node3.next= node2;
		node2.next= node3;
		node0.next= node4;
		node4.next= node2;
		System.out.println(hasCycle(node3));		
	}

	/*
	 * Time Complexity: O(N).Reason: In the worst case, all the nodes of the list are visited.
	 * Space Complexity: O(1). Reason: No extra data structure is used. 
	*/
	public static boolean hasCycle(Node head) {
        Node slow= head;
        Node fast= head;
        if(slow == null || fast == null){
            return false;
        }
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }            
        }
        return false;    
    }
	
}
