package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class ReverseSublist {
	@EpiTest(testDataFile = "reverse_sublist.tsv")

	public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {

		if (start == finish) {
			return L;
		}

		// Initialize index
		int i = 1;
		ListNode<Integer> dummyhead = new ListNode<Integer>(0, L);
		ListNode<Integer> temphead = dummyhead;

		while (i < start) {
			temphead = temphead.next;
			i++;
		}

		// Reverse sublist
		ListNode<Integer> currNode = temphead.next;

		while (i < finish) {
			ListNode<Integer> temp = currNode.next;
			currNode.next = temp.next;
			temp.next = temphead.next;
			temphead.next = temp;
			i++;
		}

		return dummyhead.next;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "ReverseSublist.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
