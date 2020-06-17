package com.aqurilla.datastructures;

import java.util.Iterator;

@SuppressWarnings("unchecked")
/**
 * Dynamic Array: Auto-resizing array implementation
 *
 * @author Nitin Suresh
 *
 * @param <T> type of element stored in array
 */
public class DynamicArray<T> implements Iterable<T> {

	private T[] arr;
	private int len = 0;
	private int capacity = 0;

	// Constructors
	public DynamicArray() {
		this(10);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal capacity entered: " + capacity);
		}
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int index) {
		return arr[index];
	}

	public void set(int index, T elem) {
		arr[index] = elem;
	}

	public void clear() {
		for (int i = 0; i < capacity; i++) {
			arr[i] = null;
		}
		len = 0;
	}

	// Add element to end of list
	public void add(T elem) {
		// if array reaches capacity, double size
		if (len + 1 >= capacity) {
			if (capacity == 0) {
				capacity = 1;
			} else {
				capacity *= 2;
			}
			T[] temparr = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++) {
				temparr[i] = arr[i];
			}
			arr = temparr;
		}
		arr[len++] = elem;
	}

	// Remove element from specified index
	public T removeAt(int index) {
		if (index >= len || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		T elem = arr[index];
		for (int i = index; i < len - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[len - 1] = null;
		len--;
		return elem;
	}

	// Remove element from array
	public boolean remove(T elem) {
		for (int i = 0; i < len; i++) {
			if (arr[i].equals(elem)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < len;
			}

			@Override
			public T next() {
				return arr[index++];
			}

		};
	}

	@Override
	public String toString() {
		if (len == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder(len*2).append("[");
			for(int i=0;i<len-1; i++) {
				sb.append(arr[i]+", ");
			}
			return sb.append(arr[len-1]+"]").toString();
		}
	}

}
