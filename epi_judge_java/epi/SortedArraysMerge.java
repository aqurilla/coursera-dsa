package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedArraysMerge {
  @EpiTest(testDataFile = "sorted_arrays_merge.tsv")

  public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {

    // get the iterators for each array
    List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());

    for (List<Integer> array : sortedArrays) {
      iters.add(array.iterator());
    }

    PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(), (ArrayEntry a1, ArrayEntry a2) -> {
      return Integer.compare(a1.value, a2.value);
    });

    // Build the min heap consisting of array iterators
    for (int i = 0; i < iters.size(); i++) {
      if (iters.get(i).hasNext()) {
        minHeap.add(new ArrayEntry(iters.get(i).next(), i));
      }
    }

    // add the minimum to the array and add the
    // next element from the same array
    List<Integer> result = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      ArrayEntry firstElem = minHeap.poll();
      result.add(firstElem.value);
      if (iters.get(firstElem.arrayId).hasNext()) {
        minHeap.add(new ArrayEntry(iters.get(firstElem.arrayId).next(), firstElem.arrayId));
      }
    }

    return result;
  }

  // Store the next smallest value and the array ID
  private static class ArrayEntry {
    public Integer value;
    public Integer arrayId;

    public ArrayEntry(Integer value, Integer arrayId) {
      this.value = value;
      this.arrayId = arrayId;
    }

  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "SortedArraysMerge.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
