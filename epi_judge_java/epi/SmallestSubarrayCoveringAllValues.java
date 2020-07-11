package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestSubarrayCoveringAllValues {

  public static class Subarray {
    // Represent subarray by starting and ending indices, inclusive.
    public Integer start;
    public Integer end;

    public Subarray(Integer start, Integer end) {
      this.start = start;
      this.end = end;
    }
  }

  public static Subarray findSmallestSequentiallyCoveringSubset(List<String> paragraph, List<String> keywords) {

    // use a 2-pointer approach to identify the minimum subarray
    Map<String, Integer> stringMap = new HashMap<>();

    // fill the map
    for (String keyword : keywords) {
      stringMap.put(keyword, stringMap.containsKey(keyword) ? stringMap.get(keyword) + 1 : 1);
    }

    Subarray soln = new Subarray(-1, -1);
    int balance = keywords.size();

    for (int left = 0, right = 0; right < paragraph.size(); right++) {

      Integer keywordCount = stringMap.get(paragraph.get(right));
      if (keywordCount != null) {
        keywordCount--;
        stringMap.put(paragraph.get(right), keywordCount);
        if (keywordCount >= 0) {
          balance--;
        }
      }

      // if it covers all keywords, move left forwards
      while (balance == 0) {

        // smaller range found
        if ((soln.start == -1 && soln.end == -1) || right - left < soln.end - soln.start) {
          soln.start = left;
          soln.end = right;
        }

        // if removed element is a keyword, add back to hashmap
        keywordCount = stringMap.get(paragraph.get(left));
        if (keywordCount != null) {
          keywordCount++;
          stringMap.put(paragraph.get(left), keywordCount);
          if (keywordCount > 0) {
            balance++;
          }
        }
        left++;
      }
    }
    return soln;
  }

  @EpiTest(testDataFile = "smallest_subarray_covering_all_values.tsv")
  public static int findSmallestSequentiallyCoveringSubsetWrapper(TimedExecutor executor, List<String> paragraph,
      List<String> keywords) throws Exception {
    Subarray result = executor.run(() -> findSmallestSequentiallyCoveringSubset(paragraph, keywords));

    int kwIdx = 0;
    if (result.start < 0) {
      throw new TestFailure("Subarray start index is negative");
    }
    int paraIdx = result.start;

    while (kwIdx < keywords.size()) {
      if (paraIdx >= paragraph.size()) {
        throw new TestFailure("Not all keywords are in the generated subarray");
      }
      if (paraIdx >= paragraph.size()) {
        throw new TestFailure("Subarray end index exceeds array size");
      }
      if (paragraph.get(paraIdx).equals(keywords.get(kwIdx))) {
        kwIdx++;
      }
      paraIdx++;
    }
    return result.end - result.start + 1;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "SmallestSubarrayCoveringAllValues.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
