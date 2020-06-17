package com.aqurilla.algorithms.misc;

import java.util.Arrays;

public class Heapify {

	/**
	 * Converts an array in place to a max-heap in O(n) time
	 *
	 * @param A array to perform heapify
	 */
	public static void maxHeapify(int[] A) {
		int n = A.length - 1;

		// Work backwards and swap required elements
		for (int i = n; i >= 0; i--) {
			siftDown(A, i);
		}

	}

	private static void siftDown(int[] a, int i) {

		int n = a.length;
		int temp = a[i];
		int leftIndex;
		int rightIndex;
		int swapIndex = i;

		while (i < n) {
			swapIndex = i;
			leftIndex = 2 * i + 1;
			rightIndex = 2 * i + 2;
			// Check if left child should be swapped
			if (leftIndex < n && a[leftIndex] > temp) {
				swapIndex = leftIndex;
			}
			// Check if right child should be swapped
			if (rightIndex < n && a[rightIndex] > temp && a[rightIndex] > a[leftIndex]) {
				swapIndex = rightIndex;
			}
			// If swap index unchanged, no further swaps required
			if (i == swapIndex) {
				break;
			}
			a[i] = a[swapIndex];
			i = swapIndex;
		}

		a[swapIndex] = temp;

	}

	public static void main(String[] args) {
		int[] A = new int[] { 10, 20, 25, 12, 40, 80, 90, 100, 15, 18 };
		System.out.println("Original array: " + Arrays.toString(A));
		Heapify.maxHeapify(A);
		assert A[0] == 100;
		System.out.println("After heapify: " + Arrays.toString(A));
	}
}
