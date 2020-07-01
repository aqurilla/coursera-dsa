package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SumRootToLeaf {
  @EpiTest(testDataFile = "sum_root_to_leaf.tsv")

  public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
    return sumValue(0, tree);
  }

  private static int sumValue(int parentVal, BinaryTreeNode<Integer> node) {

    // if node null
    if (node == null) {
      return 0;
    }
    // At any node, the integer value is
    // parent * 2 + node bit
    int nodeVal = parentVal * 2 + node.data;

    // for a non-leaf, return sum of left and right child
    // for a leaf, return the node value
    if (node.left == null && node.right == null) {
      return nodeVal;
    } else {
      return sumValue(nodeVal, node.left) + sumValue(nodeVal, node.right);
    }

  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "SumRootToLeaf.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
