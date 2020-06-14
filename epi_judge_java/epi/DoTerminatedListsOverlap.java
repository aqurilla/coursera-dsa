package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

public class DoTerminatedListsOverlap {

	public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {

		// Find length of both lists
		int length0 = 0;
		int length1 = 0;

		ListNode<Integer> temp = l0;
		while (temp != null) {
			length0++;
			temp = temp.next;
		}

		temp = l1;
		while (temp != null) {
			length1++;
			temp = temp.next;
		}

		// If necessary, swap to make l0 point to longer list
		int diff = Math.abs(length0 - length1);

		if (length1 > length0) {
			temp = l1;
			l1 = l0;
			l0 = temp;
		}

		// Move the longer list by the difference in lengths
		while (diff > 0) {
			l0 = l0.next;
			diff--;
		}

		// Iterate together till either null or a common node
		while (l0 != null && l1 != null && l0 != l1) {
			l0 = l0.next;
			l1 = l1.next;
		}

		if (l0 == null || l1 == null) {
			return null;
		} else {
			return l0;
		}

	}

	@EpiTest(testDataFile = "do_terminated_lists_overlap.tsv")
	public static void overlappingNoCycleListsWrapper(TimedExecutor executor, ListNode<Integer> l0,
			ListNode<Integer> l1, ListNode<Integer> common) throws Exception {
		if (common != null) {
			if (l0 != null) {
				ListNode<Integer> i = l0;
				while (i.next != null) {
					i = i.next;
				}
				i.next = common;
			} else {
				l0 = common;
			}

			if (l1 != null) {
				ListNode<Integer> i = l1;
				while (i.next != null) {
					i = i.next;
				}
				i.next = common;
			} else {
				l1 = common;
			}
		}

		final ListNode<Integer> finalL0 = l0;
		final ListNode<Integer> finalL1 = l1;
		ListNode<Integer> result = executor.run(() -> overlappingNoCycleLists(finalL0, finalL1));

		if (result != common) {
			throw new TestFailure("Invalid result");
		}
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "DoTerminatedListsOverlap.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
