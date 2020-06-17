package com.aqurilla.algorithms.search;

/**
 * Binary search implementation (recursive)
 *
 * @author Nitin Suresh
 *
 */
public class RBinarySearch {

	/**
	 * Search for a key inside given array
	 *
	 * @param l   low index
	 * @param h   high index
	 * @param key element to search for
	 * @return index of key if found, else -1
	 */
	public static int bsearch(int[] A, int l, int h, int key) {

		// Base case
		if (l == h) {
			if (A[l] == key) {
				return l;
			} else {
				return -1;
			}
		}

		int mid = (l + h) / 2;

		if (A[mid] == key) {
			return mid;
		} else if (key < A[mid]) {
			return bsearch(A, l, mid - 1, key);
		} else {
			return bsearch(A, mid + 1, h, key);
		}
	}

	public static void main(String[] args) {
		assert bsearch(new int[] { 1, 2, 3, 4, 5 }, 0, 4, 5) == 4;
		assert bsearch(new int[] { 1, 2, 3, 4, 5 }, 0, 4, 7) == -1;
	}

}
