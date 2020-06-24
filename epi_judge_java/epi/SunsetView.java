package epi;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SunsetView {
	public static List<Integer> examineBuildingsWithSunset(Iterator<Integer> sequence) {

		Deque<IdxHeight> stack = new LinkedList<>();
		int height;
		int idx = 0;

		// Iterate from E to W
		while (sequence.hasNext()) {
			height = sequence.next();

			// Remove all previous buildings of lower height
			while (!stack.isEmpty() && stack.peek().height <= height) {
				stack.pop();
			}

			// Push the new building
			stack.push(new IdxHeight(idx, height));
			idx++;
		}

		List<Integer> result = new ArrayList<Integer>();

		for (IdxHeight elem : stack) {
			result.add(elem.id);
		}

		return result;
	}

	@EpiTest(testDataFile = "sunset_view.tsv")
	public static List<Integer> examineBuildingsWithSunsetWrapper(List<Integer> sequence) {
		return examineBuildingsWithSunset(sequence.iterator());
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "SunsetView.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}

class IdxHeight {
	public int id;
	public int height;

	public IdxHeight(int id, int height) {
		this.id = id;
		this.height = height;
	}
}
