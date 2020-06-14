package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class RemoveDuplicatesFromSortedList {
	@EpiTest(testDataFile = "remove_duplicates_from_sorted_list.tsv")

	public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {

		// Iterate through list
		ListNode<Integer> p = L;

		while (p != null) {
			// Update next to first different element
			ListNode<Integer> q = p.next;
			while (q != null && q.data == p.data) {
				q = q.next;
			}
			p.next = q;
			p = p.next;
		}

		return L;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "RemoveDuplicatesFromSortedList.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
