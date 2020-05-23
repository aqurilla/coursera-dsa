package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class ReverseDigits {
  @EpiTest(testDataFile = "reverse_digits.tsv")
  public static long reverse(int x) {
    long absVal = Math.abs(x);

    String stringVal = String.valueOf(absVal);

    long res = Long.parseLong(new StringBuilder(stringVal).reverse().toString());

    return x > 0 ? res : -res;

    // Second approach is to % 10, and build up solution
  }

  public static void main(String[] args) {
    System.exit(
            GenericTest
                    .runFromAnnotations(args, "ReverseDigits.java",
                            new Object() {
                            }.getClass().getEnclosingClass())
                    .ordinal());
  }
}
