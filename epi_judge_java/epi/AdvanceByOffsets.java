package epi;

import java.util.List;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class AdvanceByOffsets {
	@EpiTest(testDataFile = "advance_by_offsets.tsv")
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {

		if (maxAdvanceSteps.isEmpty()) {
			return false;
		}

		int maxReachable = maxAdvanceSteps.get(0);

		for (int i = 0; i < maxAdvanceSteps.size(); i++) {

			// If current index greater than maximum reachable
			// cannot reach end
			if (i > maxReachable) {
				return false;
			}

			// Update maxReachable if required
			maxReachable = Math.max(maxReachable, i + maxAdvanceSteps.get(i));

			// if possible to reach end
			if (maxReachable >= maxAdvanceSteps.size() - 1) {
				return true;
			}

		}

		return true;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "AdvanceByOffsets.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
