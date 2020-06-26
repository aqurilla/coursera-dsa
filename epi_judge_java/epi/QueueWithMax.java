package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueWithMax {

  // queue for storing elems
  // stack for keeping track of max
  private Deque<Integer> queue = new LinkedList<>();
  private Deque<Integer> maxQueue = new LinkedList<>();

  public void enqueue(Integer x) {
    queue.addLast(x);

    // Remove elements from tail if smaller
    while (!maxQueue.isEmpty() && x.compareTo(maxQueue.peekLast()) > 0) {
      maxQueue.removeLast();
    }

    maxQueue.addLast(x);
    return;
  }

  public Integer dequeue() {
    Integer elem = queue.removeFirst();

    // If head of maxQueue is equal, remove that as well
    if (elem.compareTo(maxQueue.peekFirst()) == 0) {
      maxQueue.removeFirst();
    }

    return elem;
  }

  public Integer max() {
    return maxQueue.peekFirst();
  }

  @EpiUserType(ctorParams = { String.class, int.class })
  public static class QueueOp {
    public String op;
    public int arg;

    public QueueOp(String op, int arg) {
      this.op = op;
      this.arg = arg;
    }
  }

  @EpiTest(testDataFile = "queue_with_max.tsv")
  public static void queueTest(List<QueueOp> ops) throws TestFailure {
    try {
      QueueWithMax q = new QueueWithMax();

      for (QueueOp op : ops) {
        switch (op.op) {
          case "QueueWithMax":
            q = new QueueWithMax();
            break;
          case "enqueue":
            q.enqueue(op.arg);
            break;
          case "dequeue":
            int result = q.dequeue();
            if (result != op.arg) {
              throw new TestFailure("Dequeue: expected " + String.valueOf(op.arg) + ", got " + String.valueOf(result));
            }
            break;
          case "max":
            int s = q.max();
            if (s != op.arg) {
              throw new TestFailure("Max: expected " + String.valueOf(op.arg) + ", got " + String.valueOf(s));
            }
            break;
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "QueueWithMax.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
