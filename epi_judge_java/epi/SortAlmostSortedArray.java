package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {

  public static List<Integer> sortApproximatelySortedData(Iterator<Integer> sequence, int k) {

    // maintain a min-heap of 2k+1 length
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(2 * k + 1, (Integer i1, Integer i2) -> {
      return Integer.compare(i1, i2);
    });

    List<Integer> soln = new ArrayList<>();

    while (sequence.hasNext()) {
      if (minHeap.size() < 2 * k + 1) {
        minHeap.add(sequence.next());
      } else {
        soln.add(minHeap.poll());
      }
    }

    // add remaining elements to solution
    while (!minHeap.isEmpty()) {
      soln.add(minHeap.poll());
    }

    return soln;
  }

  @EpiTest(testDataFile = "sort_almost_sorted_array.tsv")
  public static List<Integer> sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
    return sortApproximatelySortedData(sequence.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "SortAlmostSortedArray.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
