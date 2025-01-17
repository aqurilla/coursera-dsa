package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class PowerXY {
  @EpiTest(testDataFile = "power_x_y.tsv")
  public static double power(double x, int y) {

    double res = 1.0;
    long power = y;

    if (y < 0) {
      x = 1.0/x;
      y = -y;
    }

    while (power != 0) {
      if ((power & 1) != 0) {
        res *= x;
      }
      x *= x;
      power >>>= 1;
    }

    return res;
  }

  public static void main(String[] args) {
    System.exit(
            GenericTest
                    .runFromAnnotations(args, "PowerXY.java",
                            new Object() {
                            }.getClass().getEnclosingClass())
                    .ordinal());
  }
}
