package problems.linked_list;

import main.utilities.Node;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * https://takeuforward.org/data-structure/merge-two-sorted-linked-lists/
 * @author ssingh42
 *
 */

public class MergeTwoSortedLists {
	
	public void test() {
		//list1 = [1,2,4], list2 = [1,3,4]
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(4);
		node1.next= node2;
		node2.next= node3;
		
		Node node4=new Node(1);
		Node node5=new Node(3);
		Node node6=new Node(4);
		node4.next= node5;
		node5.next= node6;
		
		Node result = mergeTwoListsV2(node1,node4);
		Node.printList(result);		
	}
	
	private void swap2(Node left, Node right) {
		Node temp=left.next;
		left.next = right.next;
		right.next = temp;
	} 
	
	/**
	 * Time Complexity: O(m+n) where m,n are list sizes.
	 * Space Complexity: O(m+n) 
	 */
	public Node mergeTwoListsV1(Node left, Node right) {
        if(left == null)
            return right;
        if(right == null)
            return left;

        Node dummy = new Node(-1);
        Node temp = dummy;
        while(left != null && right != null){
            if(left.data < right.data){ 
                temp.next = left;
                left = left.next;
            }else { 
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }    
        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        } 
        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return dummy.next; 
    }

	/**
	 * Time Complexity: O(m+n) where m,n are list sizes.
	 * Space Complexity: O(1) 
	 */
	public Node mergeTwoListsV2(Node left, Node right) {
		if (left == null)
			return right;
		if (right == null)
			return left;
		if (right.data < left.data)
			swap(left, right);
		
		Node result = left;
		while (left != null && right != null) {
			Node temp = null;
			while (left.data <= right.data) {
				left = left.next;
				temp = left;
			}
			if(null != temp)
				temp.next = right;
			swap(left, right);
		}
		return result;
	}
	
	private void swap(Node left, Node right) {
		Node temp = left.next;
		left.next = right.next;
		right.next = temp;
	} 
	
	/***
	 * Time Complexity: O(m+n) where m,n are list sizes.
	 * Space Complexity: O(1)
	 */
	public Node mergeTwoListsV3(Node l1, Node l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.data < l2.data){
			l1.next = mergeTwoListsV3(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoListsV3(l1, l2.next);
			return l2;
		}
    }
	
}
