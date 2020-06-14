package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class DeleteKthLastFromList {
	@EpiTest(testDataFile = "delete_kth_last_from_list.tsv")

	// Assumes L has at least k nodes, deletes the k-th last node in L.
	public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {

		// Set two pointers K distance apart
		ListNode<Integer> l0 = L;
		ListNode<Integer> l1 = L;

		while (k-- > 0) {
			l1 = l1.next;
		}

		// EDGE CASE
		// If l1 reached null, first element of LL is to be removed
		if (l1 == null) {
			return L.next;
		}

		// Iterate through list until second pointer points to null
		while (l1 != null && l1.next != null) {
			l0 = l0.next;
			l1 = l1.next;
		}

		// Update next of first pointer
		l0.next = l0.next.next;

		return L;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "DeleteKthLastFromList.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
