package com.aqurilla.datastructures;

/**
 * Singly-linked LinkedList implementation
 *
 * @author aqurilla
 *
 */
public class LinkedList {

	private Node<Integer> head;
	private int size = 0;

	// Constructors
	public LinkedList() {
		head = new Node<Integer>(0);
	}

	public LinkedList(Node<Integer> head, int size) {
		this.head = head;
		this.size = size;
	}

	// Get size
	public int size() {
		return size;
	}

	// Check if the linkedlist is empty
	public boolean isEmpty() {
		return head == null;
	}

	// Search for key
	public static Node<Integer> search(Node<Integer> L, int key) {

		while (L != null && L.data != key) {
			L = L.next;
		}

		return L;
	}

	// Insert new node

	// Delete node

	public static void main() {

	}

}
