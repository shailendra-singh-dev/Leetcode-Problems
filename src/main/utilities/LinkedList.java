package main.utilities;


public class LinkedList {

	public static void printList(Node node) {
		Node current = node;
		String output = "[";
		while (current != null) {
			output += "[" + current.data + "],";
			current = current.next;
		}
		output = output.substring(0, output.length() - 1);
		output += "]";
		System.out.println(output);
	}

	
	//To be done
	public static Node getList(int[] a) {
		Node head = null;
		for (int i = 0; i < a.length ; i++) {
			if(head == null) {
				head = new Node(a[i]);
			}
			Node next = new Node(a[i]);
			head.next = next;
			
		}
		return head;
	}

}
