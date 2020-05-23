package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class Parity {

    @EpiTest(testDataFile = "parity.tsv")
    public static short parity(long x) {

        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4; // 1101 0111 ^ 0000 1101
        x ^= x >>> 2; // 1101 1010 ^ 0011 0110
        x ^= x >>> 1; // 1110 1100 ^ 0111 0110

        return (short) (x & 1);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "Parity.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
