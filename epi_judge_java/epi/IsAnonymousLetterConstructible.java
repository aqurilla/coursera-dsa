package epi;

import java.util.HashMap;
import java.util.Map;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsAnonymousLetterConstructible {
  @EpiTest(testDataFile = "is_anonymous_letter_constructible.tsv")

  private static HashMap<Character, Integer> createMap(String text) {

    HashMap<Character, Integer> charMap = new HashMap<>();

    for (Character c : text.toCharArray()) {

      if (!charMap.containsKey(c)) {
        charMap.put(c, 0);
      } else {
        charMap.put(c, charMap.get(c) + 1);
      }

    }

    return charMap;

  }

  public static boolean isLetterConstructibleFromMagazine(String letterText, String magazineText) {

    // create hashmap of letter
    HashMap<Character, Integer> letterMap = createMap(letterText);

    // go through magazine, till the letter's hashmap becomes empty
    for (Character c : magazineText.toCharArray()) {

      if (letterMap.containsKey(c)) {
        letterMap.put(c, letterMap.get(c) - 1);

        if (letterMap.get(c) == 0) {
          letterMap.remove(c);
          // if hashmap becomes empty, break
          if (letterMap.isEmpty()) {
            break;
          }
        }
      }
    }

    // if letter's hashmap still non-empty, return false
    return letterMap.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "IsAnonymousLetterConstructible.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
