package epi;

import java.util.List;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

public class SortedArrayRemoveDups {
	// Returns the number of valid entries after deletion.
	public static int deleteDuplicates(List<Integer> A) {

		if (A.isEmpty()) {
			return 0;
		}

		int i = 1;
		int j = 0;

		while (i < A.size()) {
			while (i < A.size() && A.get(i).equals(A.get(j))) {
				i++;
			}

			// if end of list
			if (i >= A.size()) {
				break;
			}

			// else set element at j
			j++;
			A.set(j, A.get(i));
		}

		return j + 1;
	}

	@EpiTest(testDataFile = "sorted_array_remove_dups.tsv")
	public static List<Integer> deleteDuplicatesWrapper(TimedExecutor executor, List<Integer> A) throws Exception {
		int end = executor.run(() -> deleteDuplicates(A));
		return A.subList(0, end);
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "SortedArrayRemoveDups.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
