package epi;

import java.util.Deque;
import java.util.LinkedList;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsValidParenthesization {
	@EpiTest(testDataFile = "is_valid_parenthesization.tsv")

	public static boolean isWellFormed(String s) {

		Deque<Character> stack = new LinkedList<>();
		Character ch;

		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (ch == ')' && stack.pop() != '(') {
					return false;
				} else if (ch == '}' && stack.pop() != '{') {
					return false;
				} else if (ch == ']' && stack.pop() != '[') {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "IsValidParenthesization.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
