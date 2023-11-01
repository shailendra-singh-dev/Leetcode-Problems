package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

import main.utilities.TreeNode;
import problems.linked_list.DeleteNodeInALinkedList;

public class Main {

	public static void main(String[] args) {
		new DeleteNodeInALinkedList().test();
	}
	
	static int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid; 
        for(int i = low;i<=mid-1;i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - mid);
        }
        
        //int[] temp = new int[nums.length]; 
        ArrayList<Integer> temp = new ArrayList();
        int left = low, right = mid;
        int k=low;
        while(left <= mid-1 && right<=high) {
            if(nums[left]<=nums[right]) {
            	temp.add(nums[left++]);
                //temp[k++] = nums[left++]; 
            }
            else {
            	temp.add(nums[right++]);
            	//temp[k++] = nums[right++];
            }
        }
        
        while(left<=mid-1) {
        	//temp[k++] = nums[left++]; 
        	temp.add(nums[left++]);
        }
        while(right<=high) {
        	//temp[k++] = nums[right++];
        	temp.add(nums[right++]);
        }
        for(int i = low; i<=high;i++) {
            //nums[i] = temp[i];
        	nums[i] = temp.get(i-low);
        }
        return cnt; 
    }
	
    static int mergeSort(int[] nums, int low, int high) {
        if(low>=high) return 0; 
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid); 
        inv += mergeSort(nums, mid+1, high); 
        inv += merge(nums, low, mid+1, high); 
        return inv; 
    }

	private static void constructBinaryTree() {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		root.left = node1;
		root.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.left = node5;
		node2.right = node6;
		
		/**
		 *               0 
		 *              / \ 
		 *             1   2 
		 *            / \ / \ 
		 *           3  4 5  6
		 * 
		 */

		traversePostOrderWithoutRecursion(root);
	}

	public static void traversePostOrderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = root;
		TreeNode current = root;
		stack.push(root);

		while (!stack.isEmpty()) {
			current = stack.peek();
			boolean hasChild = (current.left != null || current.right != null);
			boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

			if (!hasChild || isPrevLastChild) {
				current = stack.pop();
				visit(current);
				prev = current;
			} else {
				if (current.right != null) {
					stack.push(current.right);
				}
				if (current.left != null) {
					stack.push(current.left);
				}
			}
		}
	}

	private static void visit(TreeNode node) {
		System.out.println(node.data);

	}

	private static void test() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(4);
		priorityQueue.add(10);
		priorityQueue.add(2);
		priorityQueue.add(1);
		priorityQueue.add(3);
		Iterator<Integer> iterator = priorityQueue.iterator();
		System.out.println(priorityQueue.toString());
		while (iterator.hasNext()) {
			System.out.println(priorityQueue.peek());
			System.out.println(priorityQueue.poll());
		}

//		while (!priorityQueue.isEmpty()) {
//			priorityQueue.poll();
//			int lastElement = priorityQueue.peek();
//			System.out.println(lastElement);
//		}

	}

}
