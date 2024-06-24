package problems.linked_list;

import java.util.HashMap;

import main.utilities.Node;

/*
 * https://leetcode.com/problems/lru-cache/
 * 
 */
public class LRUCache {

	HashMap<Integer, Node> map = new HashMap<>();
	Node head;
	Node tail;
	int capacity;

	public LRUCache(int _capacity) {
		head = new Node(0,0);
		tail = new Node(0,0);
		head.next =tail;
		tail.previous = head;
		capacity = _capacity;
	}

	/**
	 * Time Complexity:O(N)
	   Space Complexity:O(1)
	 */
	public int get(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			insert(node);
			System.out.println(node.data);
			return node.data;
		}
		return -1;
	}
	
	/**
	 * Time Complexity:O(N)
	   Space Complexity:O(1)
	 */
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			remove(map.get(key));
		}
		if(map.size() == capacity) {
			remove(tail.previous);
		}
		insert(new Node(key,value));
		System.out.println("null");
	}
	
	private void remove(Node node) {
		map.remove(node.key);
		node.previous.next = node.next;
		node.next.previous = node.previous;
	}
	
	private void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		head.next.previous = node;
		head.next = node;
		node.previous = head;				
	}	
	
	public void test() {
		LRUCache obj = new LRUCache(2);		
		obj.put(1,1);
		obj.put(2,2);
		obj.get(1);
		obj.put(3,3);		
		obj.get(2);		
		obj.put(4,4);
		obj.get(1);
		obj.get(3);
		obj.get(4);
	}
}
