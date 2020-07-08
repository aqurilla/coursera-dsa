package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiPredicate;

public class KLargestInHeap {
  @EpiTest(testDataFile = "k_largest_in_heap.tsv")

  public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {

    // Approach 1
    if (k <= 0) {
      return new ArrayList<>();
    }
    List<Integer> soln = new ArrayList<>();
    int leftIndex, rightIndex;

    PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(10, (o1, o2) -> {
      return Integer.compare(o2.value, o1.value);
    });

    maxHeap.add(new HeapEntry(0, A.get(0)));

    for (int i = 0; i < k; i++) {
      // add elements to maxheap
      // extract elements based on max value
      HeapEntry heapEntry = maxHeap.poll();
      soln.add(heapEntry.value);
      leftIndex = heapEntry.index * 2 + 1;
      rightIndex = heapEntry.index * 2 + 2;

      // add elements at left and right index
      if (leftIndex < A.size()) {
        maxHeap.add(new HeapEntry(leftIndex, A.get(leftIndex)));
      }

      if (rightIndex < A.size()) {
        maxHeap.add(new HeapEntry(rightIndex, A.get(rightIndex)));
      }

    }

    return soln;

    // Approach 2
    // // use a size-k minheap
    // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // for (int n : A) {
    // if (minHeap.size() < k) {
    // minHeap.add(n);
    // } else if (n > minHeap.peek()) {
    // minHeap.poll();
    // minHeap.add(n);
    // }
    // }

    // return new ArrayList<>(minHeap);
  }

  private static class HeapEntry {
    public Integer index;
    public Integer value;

    public HeapEntry(Integer index, Integer value) {
      this.index = index;
      this.value = value;
    }

  }

  @EpiTestComparator
  public static BiPredicate<List<Integer>, List<Integer>> comp = (expected, result) -> {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "KLargestInHeap.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
