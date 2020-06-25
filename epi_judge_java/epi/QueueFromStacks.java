package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueFromStacks {

  public static class Queue {

    // Only stacks can be used
    private Deque<Integer> stack1 = new LinkedList<>();
    private Deque<Integer> stack2 = new LinkedList<>();

    public void enqueue(Integer x) {
      stack1.addFirst(x);
      return;
    }

    public Integer dequeue() {

      // once s1 elems are transfered to s2
      // dequeues can be done till s2 is empty
      // enqueues are automatically valid into s1

      if (stack2.isEmpty()) {
        // reverse order into stack2
        while (!stack1.isEmpty()) {
          stack2.addFirst(stack1.removeFirst());
        }
      }

      // pop last element from s2
      int elem = stack2.removeFirst();

      return elem;
    }
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

  @EpiTest(testDataFile = "queue_from_stacks.tsv")
  public static void queueTest(List<QueueOp> ops) throws TestFailure {
    try {
      Queue q = new Queue();

      for (QueueOp op : ops) {
        switch (op.op) {
          case "QueueWithMax":
            q = new Queue();
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
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "QueueFromStacks.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
