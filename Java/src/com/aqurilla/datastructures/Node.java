package com.aqurilla.datastructures;

//Node for linked list
public class Node<T> {
	public T data;
	public Node<T> next;

	// Constructors
	public Node() {
		data = null;
		next = null;
	}

	public Node(T value) {
		data = value;
		next = null;
	}

	public Node(T value, Node<T> nextNode) {
		data = value;
		next = nextNode;
	}
}
