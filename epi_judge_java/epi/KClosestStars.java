package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.EpiTestExpectedType;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiPredicate;

public class KClosestStars {
  @EpiUserType(ctorParams = { double.class, double.class, double.class })

  public static class Star implements Comparable<Star> {
    private double x, y, z;

    public Star(double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    public double distance() {
      return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public int compareTo(Star that) {
      return Double.compare(this.distance(), that.distance());
    }

    @Override
    public String toString() {
      return String.valueOf(distance());
    }
  }

  public static List<Star> findClosestKStars(Iterator<Star> stars, int k) {

    // use a size k max-heap to store k closest stars
    // Collections.reverseOrder used to get reverse of natural ordering
    // specified by the Star's compareTo method
    PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

    while (stars.hasNext()) {
      if (maxHeap.size() < k) {
        maxHeap.add(stars.next());
      } else {
        // Check if next star is smaller than the
        // furthest one among the current k stars
        Star nextStar = stars.next();
        Star maxClosest = maxHeap.peek();
        if (nextStar.compareTo(maxClosest) < 0) {
          maxHeap.poll();
          maxHeap.add(nextStar);
        }
      }
    }

    return new ArrayList<>(maxHeap);
  }

  @EpiTest(testDataFile = "k_closest_stars.tsv")
  public static List<Star> findClosestKStarsWrapper(List<Star> stars, int k) {
    return findClosestKStars(stars.iterator(), k);
  }

  @EpiTestExpectedType
  public static List<Double> expectedType;

  @EpiTestComparator
  public static BiPredicate<List<Double>, List<Star>> comp = (expected, result) -> {
    if (expected.size() != result.size()) {
      return false;
    }
    Collections.sort(result);
    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).distance() != expected.get(i)) {
        return false;
      }
    }
    return true;
  };

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "KClosestStars.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
