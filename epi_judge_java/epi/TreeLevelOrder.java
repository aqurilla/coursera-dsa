package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelOrder {
  @EpiTest(testDataFile = "tree_level_order.tsv")

  public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
    // Variation of Breadth First Search

    if (tree == null) {
      // no nodes
      return new LinkedList<>();
    }

    // Solution list
    List<List<Integer>> soln = new LinkedList<>();

    // 3 queues for storing nodes
    Deque<BinaryTreeNode<Integer>> currNodes = new LinkedList<>();
    Deque<BinaryTreeNode<Integer>> nextNodes = new LinkedList<>();
    List<Integer> dataVals = new LinkedList<>();

    // Initialize queues
    currNodes.addLast(tree);

    while (!currNodes.isEmpty()) {

      // iterates over all nodes
      BinaryTreeNode<Integer> node = currNodes.removeFirst();
      if (node != null) {
        dataVals.add(node.data);

        // add left and right nodes to queue
        nextNodes.addLast(node.left);
        nextNodes.addLast(node.right);
      }

      if (currNodes.isEmpty()) {
        if (!dataVals.isEmpty())
          soln.add(dataVals);

        // switch curr and next nodes list
        currNodes = nextNodes;
        nextNodes = new LinkedList<>();

        // clear the array for next values
        dataVals = new LinkedList<>();
      }

    }

    return soln;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "TreeLevelOrder.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
