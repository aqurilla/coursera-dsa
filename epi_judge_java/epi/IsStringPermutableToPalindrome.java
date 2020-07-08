package epi;

import java.util.HashMap;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsStringPermutableToPalindrome {
  @EpiTest(testDataFile = "is_string_permutable_to_palindrome.tsv")

  public static boolean canFormPalindrome(String s) {

    // What strings can form palindromes?
    char[] charArray = s.toCharArray();
    HashMap<Character, Integer> charMap = new HashMap<>();
    int numberOfOddChars = 0;

    // Find numbers of each character
    for (Character c : charArray) {
      if (!charMap.containsKey(c)) {
        charMap.put(c, 1);
      } else {
        charMap.put(c, charMap.get(c) + 1);
      }
    }

    for (int value : charMap.values()) {
      if (value % 2 != 0) {
        numberOfOddChars++;
      }
      // if more than 1 char with odd total
      // impossible to form palindrome
      if (numberOfOddChars > 1) {
        return false;
      }
    }

    return numberOfOddChars == 0 ? true : s.length() % 2 != 0;

  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "IsStringPermutableToPalindrome.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
