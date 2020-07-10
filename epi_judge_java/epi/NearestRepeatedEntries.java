package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntries {
  @EpiTest(testDataFile = "nearest_repeated_entries.tsv")

  public static int findNearestRepetition(List<String> paragraph) {

    // Make a hashmap for string and previous index
    Map<String, Integer> stringMap = new HashMap<>();
    int nearestRepetition = Integer.MAX_VALUE;

    for (int i = 0; i < paragraph.size(); i++) {
      String currentString = paragraph.get(i);
      if (!stringMap.containsKey(currentString)) {
        // add to map
        stringMap.put(currentString, i);

      } else {
        // check distance from previous
        int prevDist = stringMap.get(currentString);
        stringMap.put(currentString, i);
        //
        nearestRepetition = Math.min(nearestRepetition, i - prevDist);
      }

    }

    return nearestRepetition == Integer.MAX_VALUE ? -1 : nearestRepetition;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "NearestRepeatedEntries.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
