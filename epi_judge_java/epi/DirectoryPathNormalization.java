package epi;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class DirectoryPathNormalization {
	@EpiTest(testDataFile = "directory_path_normalization.tsv")

	public static String shortestEquivalentPath(String path) {

		if (path.equals("")) {
			throw new IllegalArgumentException("Empty path");
		}

		// Create a stack to store parts of the path
		Deque<String> pathStack = new LinkedList<>();

		// If starts with "/", add it
		if (path.startsWith("/")) {
			pathStack.push("/");
		}

		for (String s : path.split("/")) {

			if (s.equals("..")) {
				if (pathStack.isEmpty() || pathStack.peek().equals("..")) {
					pathStack.push(s);
				} else {
					if (pathStack.peek().equals("/")) {
						throw new IllegalArgumentException("Path error");
					}
					pathStack.pop();
				}
			} else if (!s.equals(".") && !s.isEmpty()) {
				pathStack.push(s);
			}

		}

		// Use a reverse iterator to get the parts in FIFO
		StringBuilder result = new StringBuilder();

		if (!pathStack.isEmpty()) {
			Iterator<String> it = pathStack.descendingIterator();
			String p = it.next();
			result.append(p);
			while (it.hasNext()) {
				// Add dividers / in between parts
				if (!p.equals("/")) {
					result.append("/");
				}
				p = it.next();
				result.append(p);
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "DirectoryPathNormalization.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
