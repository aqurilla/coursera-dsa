package com.aqurilla.datastructures;

/**
 * Dynamic Array - Mutable array implementation with automatic resizing
 *
 * @author aqurilla
 *
 */
public class DynamicArray {

	private int size = 0;
	private int capacity = 10;

	private int[] arr = new int[capacity];

	// Constructors
	public DynamicArray() {
	}

	public DynamicArray(int[] theArr) {
		if (theArr.length > capacity) {
			arr = new int[theArr.length * 2];
		}
		for (int i = 0; i < theArr.length; i++) {
			arr[i] = theArr[i];
		}
		size = theArr.length;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int at(int i) {
		if (i > size) {
			throw new Error("Index out of bounds");
		}
		return arr[i];
	}

	// Push to end of array
	public void push(int elem) {
		if (size == capacity) {
			resize();
		}
		size++;
		arr[size - 1] = elem;
	}

	// Insert element at index
	public void insert(int index, int elem) {
		if (size == capacity) {
			resize();
		}
		for (int i = size; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		arr[index] = elem;
		size++;
	}

	// Prepend to start of array
	public void prepend(int elem) {
		insert(0, elem);
	}

	// Pop from end of array
	public int pop() {
		if (isEmpty()) {
			throw new Error("Popping from empty array");
		}
		int elem = arr[size - 1];
		delete(size - 1);
		return elem;
	}

	// Delete element at index
	public void delete(int index) {
		for (int i = index; i < size; i++) {
			arr[i] = arr[i + 1];
		}
		size--;
		if (size < capacity / 4) {
			resize();
		}
	}

	// Remove element from multiple places in array
	public void remove(int elem) {
		int[] temp = new int[capacity];
		int j = 0;
		int count = 0;

		if (isEmpty()) {
			throw new Error("Empty array");
		}

		for (int i = 0; i < size; i++) {
			if (arr[i] != elem) {
				temp[j] = arr[i];
				j++;
			} else {
				count++;
			}
		}
		arr = temp;
		size -= count;

		if (size < capacity / 4) {
			resize();
		}

	}

	// Find first index of item, -1 if not present
	public int find(int elem) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == elem) {
				return i;
			}
		}
		return -1;
	}

	// Resize array
	private void resize() {
		if (size == capacity) {
			capacity *= 2;
		} else if (size < capacity / 4) {
			capacity /= 2;
		}
		int[] temp = new int[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	@Override
	public String toString() {
		String repr = "[";
		for (int i = 0; i < size; i++) {
			repr += Integer.toString(arr[i]) + ", ";
		}
		repr = repr.substring(0, repr.length() - 2) + "]";
		return repr;
	}

	// main
	public static void main(String[] args) {
		DynamicArray dynamicArray = new DynamicArray(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("Initial array: " + dynamicArray);

		dynamicArray.pop();
		System.out.println("Pop: " + dynamicArray);

		dynamicArray.insert(1, 21);
		System.out.println("Insert 21 at index 1: " + dynamicArray);

		dynamicArray.push(15);
		System.out.println("Push 15: " + dynamicArray);

		dynamicArray.push(21);
		System.out.println("Push 21: " + dynamicArray);

		dynamicArray.delete(2);
		System.out.println("Delete index 2: " + dynamicArray);

		dynamicArray.remove(21);
		System.out.println("Remove 21: " + dynamicArray);

		System.out.println("Find 15: " + dynamicArray.find(15));

		System.out.println("Find 9: " + dynamicArray.find(9));

		// Check auto-resizing
		dynamicArray.push(21);
		dynamicArray.push(4);
		dynamicArray.push(123);
		dynamicArray.push(35);
		dynamicArray.push(11);
		dynamicArray.push(123);
		dynamicArray.push(73);
		dynamicArray.push(13);

		System.out.println("Resized after push: " + dynamicArray);

		// Deleting items
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();
		dynamicArray.pop();

		System.out.println("Resized after pop: " + dynamicArray);

	}
}
