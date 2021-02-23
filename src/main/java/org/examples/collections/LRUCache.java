package org.examples.collections;

import java.util.HashMap;

public class LRUCache<K, V> {

	private HashMap<K, Node<K, V>> lruCache = new HashMap<>();
	private Node<K, V> head = new Node<>();
	private Node<K, V> tail = new Node<>();

	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public V get(K key) {
		Node<K, V> node = null;
		if (lruCache.containsKey(key)) {
			node = lruCache.get(key);
			deleteNode(node);
			addNode(node);
		}

		return (node != null) ? node.val : null;
	}

	private void deleteNode(Node<K, V> node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	private void addNode(Node<K, V> node) {
		node.next = head.next;
		if (node.next != null) {
			node.next.prev = node;
		}

		head.next = node;
		node.prev = head;
	}

	public void put(K key, V value) {
		if (lruCache.containsKey(key)) {
			Node<K, V> node = lruCache.get(key);
			node.val = value;

			deleteNode(node);
			addNode(node);
		} else {
			Node<K, V> node = new Node<>(key, value);

			if (lruCache.size() >= capacity) {
				lruCache.remove(tail.prev.key);
				deleteNode(tail.prev);
			}

			lruCache.put(key, node);
			addNode(node);
		}
	}

	private void logInfo() {
		Node<K, V> nodeToUse = head.next;
		System.out.print("{");
		while (nodeToUse != null) {
			if(nodeToUse.key == null) {
				break;
			}
			System.out.print(nodeToUse.key + "=" + nodeToUse.val + ", ");
			nodeToUse = nodeToUse.next;
		}
		System.out.print("}");
		System.out.println();
	}

	private static class Node<K, V> {
		public K key;
		public V val;
		public Node<K, V> prev;
		public Node<K, V> next;

		public Node() {
		}

		public Node(K key, V val) {
			super();
			this.key = key;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		LRUCache<Integer, Integer> lruCacheMain = new LRUCache<Integer, Integer>(2);
		lruCacheMain.put(1, 1); // cache is {1=1}
		lruCacheMain.put(2, 2); // cache is {1=1, 2=2}
		lruCacheMain.logInfo();
		System.out.println(lruCacheMain.get(1)); // return 1
		lruCacheMain.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lruCacheMain.logInfo();

		System.out.println(lruCacheMain.get(2)); // returns -1 (not found)
		lruCacheMain.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lruCacheMain.get(1); // return -1 (not found)
		lruCacheMain.get(3); // return 3
		lruCacheMain.get(4); // return 4
	}

}
