package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class OnlineMedian {
  public static List<Double> onlineMedian(Iterator<Integer> sequence) {

    // Setup a maxheap and a minheap for storing numbers
    Double currentMedian = 0.0;
    List<Double> soln = new ArrayList<>();

    // minheap of numbers greater than current median
    PriorityQueue<Double> minHeap = new PriorityQueue<>(10);

    // maxheap of numbers smaller than current median
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());

    while (sequence.hasNext()) {

      Double nextNumber = (double) sequence.next();

      // if both heaps are empty
      if (minHeap.size() == 0 && maxHeap.size() == 0) {
        currentMedian = (double) nextNumber;
        soln.add(currentMedian);
        minHeap.add(currentMedian);
        continue;
      }

      // if number is > current median
      if (nextNumber > currentMedian) {
        // if size of minheap greater than maxheap
        // move smallest to maxheap
        if (minHeap.size() > maxHeap.size()) {
          maxHeap.add(minHeap.poll());
        }
        // add to minheap
        minHeap.add(nextNumber);
      } else if (nextNumber <= currentMedian) {
        // if number < current median
        // if size of maxheap greater than minheap
        // move largest to minheap
        if (maxHeap.size() > minHeap.size()) {
          minHeap.add(maxHeap.poll());
        }
        // add to maxheap
        maxHeap.add(nextNumber);
      }

      // calculate median and add
      // if sizes equal
      if (minHeap.size() == maxHeap.size()) {
        currentMedian = (maxHeap.peek() + minHeap.peek()) / 2;
      } else if (minHeap.size() > maxHeap.size()) {
        currentMedian = minHeap.peek();
      } else {
        currentMedian = maxHeap.peek();
      }

      soln.add(currentMedian);
    }

    return soln;
  }

  @EpiTest(testDataFile = "online_median.tsv")
  public static List<Double> onlineMedianWrapper(List<Integer> sequence) {
    return onlineMedian(sequence.iterator());
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "OnlineMedian.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
