package epi;

import java.util.List;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IntAsArrayIncrement {
	@EpiTest(testDataFile = "int_as_array_increment.tsv")
	public static List<Integer> plusOne(List<Integer> A) {
		int lastIdx = A.size() - 1;

		if (A.isEmpty()) {
			return A;
		}

		// If last digit is not 9
		if (A.get(lastIdx) != 9) {
			A.set(lastIdx, A.get(lastIdx) + 1);
			return A;
		}

		// Find location to increment
		int i = lastIdx;
		while (i >= 0 && A.get(i) == 9) {
			A.set(i, 0);
			i--;
		}

		// Check if all 9s or not
		if (i >= 0) {
			A.set(i, A.get(i) + 1);
		} else {
			A.add(0, 1);
		}

		return A;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "IntAsArrayIncrement.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
