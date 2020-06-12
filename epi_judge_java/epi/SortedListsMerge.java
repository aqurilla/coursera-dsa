package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SortedListsMerge {
	@EpiTest(testDataFile = "sorted_lists_merge.tsv")
	// @include
	public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1, ListNode<Integer> L2) {

		if (L1 == null) {
			return L2;
		} else if (L2 == null) {
			return L1;
		}

		// Get pointers to the two nodes
		ListNode<Integer> i;
		ListNode<Integer> j;
		ListNode<Integer> temp;

		// If L1 is greater than L2, swap the references
		if (L1.data > L2.data) {
			temp = L1;
			L1 = L2;
			L2 = temp;
		}

		// Start at L1
		temp = L1;
		i = L1.next;
		j = L2;

		while (i != null && j != null) {
			if (i.data < j.data) {
				temp.next = i;
				i = i.next;
			} else {
				temp.next = j;
				j = j.next;
			}
			temp = temp.next;
		}

		if (i == null) {
			temp.next = j;
		} else if (j == null) {
			temp.next = i;
		}

		return L1;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "SortedListsMerge.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
