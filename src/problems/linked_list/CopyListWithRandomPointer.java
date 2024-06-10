package problems.linked_list;

import main.utilities.Node;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * https://www.youtube.com/watch?v=VNf6VynfpdM&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=14
 */

public class CopyListWithRandomPointer {

	public Node copyRandomList(Node head){
	    //create copy nodes.
	    Node iter = head;
	    while(iter != null) {
	    	Node front = iter.next.next;
		    
		    Node copy = new Node(iter.data);
		    iter.next = copy;
		    copy.next = front;
		    
		    iter= iter.next;
	    }
	    //link random with next pointer.
	     iter = head;
	     while(iter.next.next != null) {
	    	 if(iter.next != null) {
	    		 iter.next.random = iter.random.next;
	    	 }
	     }
	     //Extract clone list. Keep original .
	     Node psuedodNode = head;
	     Node copy=head;
	     while(psuedodNode != null) {
	    	 Node front = iter.next.next;
	    	 
	    	 //extract copy list
	    	 copy = iter.next;
	    	 psuedodNode.next= copy;
	    	 
	    	 iter.next= front;
	    	 
	    	 iter= front;	    	 
	     }     
	     return psuedodNode.next;
	 }
}