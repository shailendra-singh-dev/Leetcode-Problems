package main;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

import main.utilities.TreeNode;
import problems.arrays.MergeTwoSortedArraysWithoutExtraSpace;
import problems.linked_list.AddTwoNumbers;
import problems.linked_list.MergeTwoSortedLists;

public class Main {

	public static void main(String[] args) {
		new MergeTwoSortedLists().test();	
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
