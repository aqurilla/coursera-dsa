package com.aqurilla.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] A, int l, int h) {
		if (A.length == 0) {
			return;
		}

		// if the section is larger than one element
		if (l < h) {
			int mid = (l + h) / 2;
			// recursively call merge sort on each half
			sort(A, l, mid);
			sort(A, mid + 1, h);
			merge(A, l, mid, h);
		}
	}

	public static void merge(int[] A, int l, int mid, int h) {
		// merge the two array sections
		// from l to mid, and mid+1 to h
		int[] sortedArr = new int[h - l + 1];

		int i = l;
		int j = mid + 1;
		int k = 0;

		// Compare elements and merge
		while (i <= mid && j <= h) {
			if (A[i] < A[j]) {
				sortedArr[k++] = A[i++];
			} else {
				sortedArr[k++] = A[j++];
			}
		}

		// Copy the remaining elements
		while (i <= mid) {
			sortedArr[k++] = A[i++];
		}

		while (j <= h) {
			sortedArr[k++] = A[j++];
		}

		// Copy back the sorted elements to A
		for (i = l; i <= h; i++) {
			A[i] = sortedArr[i - l];
		}
	}

	public static void main(String[] args) {

		int[] A = { 9, 6, 23, 14, 8, 1, 2, 18, 7, 5 };
		MergeSort.sort(A, 0, A.length - 1);
		assert Arrays.equals(A, new int[] { 1, 2, 5, 6, 7, 8, 9, 14, 18, 23 });

	}

}
