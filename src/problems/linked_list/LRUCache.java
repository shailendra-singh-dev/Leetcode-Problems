package problems.linked_list;

import java.util.HashMap;

import main.utilities.Node;

public class LRUCache {

	HashMap<Integer, Node> map = new HashMap<>();
	Node head;
	Node tail;
	int capacity;

	public LRUCache(int _capacity) {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		capacity = _capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			insert(node);
			System.out.println(node.value);
			return node.value;
		}
		return -1;
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.previous.next = node.next;
		node.next.previous = node.previous;
	}

	private void insert(Node node) {
		map.put(node.key, node);
		Node headNext = head.next;
		head.next = node;
		node.previous = head;
		headNext.previous = node;
		node.next = headNext;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(tail.previous);
		}
		insert(new Node(key, value));
		System.out.println("null");
	}
	
	public void test() {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		lRUCache.get(1);    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lRUCache.get(2);    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lRUCache.get(1);    // return -1 (not found)
		lRUCache.get(3);    // return 3
		lRUCache.get(4);    // return 4		
	}

}
