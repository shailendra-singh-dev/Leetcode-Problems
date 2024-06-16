package problems.linked_list;

import main.utilities.LinkedList;
import main.utilities.Node;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * https://www.youtube.com/watch?v=VNf6VynfpdM&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=14
 * https://takeuforward.org/data-structure/clone-linked-list-with-random-and-next-pointer/
 */

public class CopyListWithRandomPointer {
	
	public void test() {
		Node node7=new Node(7);
		Node node13=new Node(13);
		Node node11=new Node(11);
		Node node10=new Node(10);
		Node node1=new Node(1);
		
		node7.next=node13;
		node7.random=null;
		
		node13.next=node11;
		node13.random=node7;
		
		node11.next=node10;
		node11.random=node1;
		
		node10.next=node1;
		node10.random=node11;
		
		node1.next=null;
		node1.random=node11;
		
		LinkedList.printList(node7);
		LinkedList.printList(copyRandomList(node7));
		
	}
	
	/*
	 * Time Complexity: O(3N)where N is the number of nodes in the linked list. The algorithm makes three 
	 * traversals of the linked list, once to create copies and insert them between original nodes, then to 
	 * set the random pointers of the copied nodes to their appropriate copied nodes and then to separate 
	 * the copied and original nodes.

	   Space Complexity : O(N) where N is the number of nodes in the linked list as the only extra additional 
	   space allocated it to create the copied list without creating any other additional data structures.
	 */
	public Node copyRandomList(Node head){
	    // First round: make copy of each node,
        // and link them together side-by-side in a single list.
	    Node iter = head;

	    while(iter != null) {
	    	Node front = iter.next;
		    
		    Node copy = new Node(iter.data);
		    iter.next = copy;
		    copy.next = front;
		    
		    iter = front;// iter.next;
	    }

        // Second round: assign random pointers for the copy nodes.
	    iter = head;
	    while(iter != null) {
	    	 if(iter.random != null) {
	    		 iter.next.random = iter.random.next;
	    	 }
             iter = iter.next.next;
	    }

	    //Extract clone list. Keep original .
         iter = head;
	     Node psuedodNode = new Node(-1);
	     Node copy = psuedodNode;
	     while(iter != null) {
	    	 Node front = iter.next.next;
	    	 
	    	 //extract copy list
	    	 copy.next = iter.next;
	    	 copy = copy.next;
	    	 
             // restore the original list   
	    	 iter.next= front;
	    	 
	    	 iter= front ; //iter.next.next;	    	 
	     }     
	     return psuedodNode.next;
	 }
}