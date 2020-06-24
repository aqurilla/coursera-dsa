package epi;

import java.util.LinkedList;
import java.util.Deque;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class EvaluateRpn {
  @EpiTest(testDataFile = "evaluate_rpn.tsv")

  public static int eval(String expression) {

    Deque<Integer> stack = new LinkedList<>();
    int op1 = 0;
    int op2 = 0;

    // note: op2 should be the first operand
    for (String s : expression.split(",")) {
      switch (s) {
        case "+":
          op1 = stack.removeFirst();
          op2 = stack.removeFirst();
          stack.addFirst(op2 + op1);
          break;

        case "-":
          op1 = stack.removeFirst();
          op2 = stack.removeFirst();
          stack.addFirst(op2 - op1);
          break;

        case "*":
          op1 = stack.removeFirst();
          op2 = stack.removeFirst();
          stack.addFirst(op2 * op1);
          break;

        case "/":
          op1 = stack.removeFirst();
          op2 = stack.removeFirst();
          stack.addFirst(op2 / op1);
          break;

        default:
          stack.addFirst(Integer.parseInt(s));
          break;
      }
    }

    return stack.removeFirst();
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "EvaluateRpn.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
