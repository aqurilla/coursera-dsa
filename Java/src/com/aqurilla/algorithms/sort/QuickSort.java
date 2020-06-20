package com.aqurilla.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	/**
	 * Performs a quicksort on the given array
	 *
	 * @param A Array to sort
	 */
	public static void sort(int[] A) {
		sort(A, 0, A.length - 1);
	}

	public static void sort(int[] A, int l, int h) {

		if (l < h + 1) {
			int j = partition(A, l, h);
			sort(A, l, j - 1);
			sort(A, j + 1, h);
		}

	}

	/**
	 * Partitions the array, and returns index of sorted element
	 *
	 * @param A Array to be partitioned
	 * @param l Index of lowest element
	 * @param h Index of highest element
	 * @return Index of element that is placed in sorted order
	 */
	public static int partition(int[] A, int l, int h) {
		// Select mid element as pivot
		// Can alternately select a random index
		Random rand = new Random();
		int pivotIdx = l + rand.nextInt(h - l + 1);
		int pivot = A[pivotIdx];

		// Swap to bring pivot to beginning
		swap(A, pivotIdx, l);

		// Shifts numbers according to pivot
		int partitionIdx = l + 1;
		for (int i = partitionIdx; i <= h; i++) {
			if (A[i] < pivot) {
				swap(A, partitionIdx++, i);
			}
		}

		// Swap back into correct index
		swap(A, l, partitionIdx - 1);

		return partitionIdx - 1;
	}

	public static void swap(int[] A, int idx1, int idx2) {
		int temp = A[idx1];
		A[idx1] = A[idx2];
		A[idx2] = temp;
	}

	public static void main(String[] args) {
		int[] A = { 10, 6, 8, 12, 15, 6, 3, 9, 5 };
		QuickSort.sort(A, 0, A.length - 1);
		assert Arrays.equals(A, new int[] { 3, 5, 6, 6, 8, 9, 10, 12, 15 });
	}

}
