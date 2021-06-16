package problems.linked_list;

import main.utilities.Node;
import main.utilities.LinkedList;

/**
 * https://takeuforward.org/data-structure/add-two-numbers-represented-as-linked-lists/
 * https://leetcode.com/problems/add-two-numbers/submissions/
 * @author ssingh42
 *
 */

public class AddTwoNumbers {
	
	public void test() {
		 //l1 = [2,4,3], l2 = [5,6,4]
		Node node1=new Node(2);
		Node node2=new Node(4);
		Node node3=new Node(3);
		Node node4=new Node(5);
		Node node5=new Node(6);
		Node node6=new Node(4);
		
		node1.next=node2;
		node2.next=node3;
		
		node4.next=node5;
		node5.next=node6;

		Node result= addTwoNumbers(node1, node4);
		LinkedList.printList(result);
	}
	
	 public Node addTwoNumbers(Node l1, Node l2) {
	        Node dummy=new Node(-1);        
	        Node temp = dummy;
	        int carry=0;
	        /**
	         *   l1 = [2,4,3], 
	         *   l2 = [5,6,4]
	             Output: [7,0,8]
	         */        
			while (l1 != null || l2 != null || carry == 1) {
	            int sum=0;
				if(l1 != null){
	                sum += l1.data;
	                l1 =l1.next;
	            }
	            if(l2 != null){
	                sum += l2.data;
	                l2 =l2.next;
	            }           
	            sum += carry;
	            carry = sum/10;
	            Node node = new Node(sum%10);                    
	            temp.next= node;
	            temp = node;            
			}
	        return dummy.next;
	    } 
}
