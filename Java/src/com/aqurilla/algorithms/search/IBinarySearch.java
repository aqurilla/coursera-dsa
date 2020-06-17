package com.aqurilla.algorithms.search;

/**
 * Binary search implementation (iterative)
 *
 * @author Nitin Suresh
 *
 */
public class IBinarySearch {

	/**
	 * Search for a key inside given array
	 *
	 * @param A   array to search in
	 * @param n   length of array
	 * @param key element to search for
	 * @return index of key if found, else -1
	 */
	public static int bsearch(int[] A, int n, int key) {

		int low = 0;
		int high = n - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (key == A[mid]) {
				return mid;
			}
			if (key > A[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		assert bsearch(new int[] { 1, 2, 3, 4, 5 }, 5, 5) == 4;
		assert bsearch(new int[] { 1, 2, 3, 4, 5 }, 5, 7) == -1;
	}

}
