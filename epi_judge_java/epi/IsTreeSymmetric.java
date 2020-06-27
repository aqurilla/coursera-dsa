package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsTreeSymmetric {

  @EpiTest(testDataFile = "is_tree_symmetric.tsv")
  /**
   * Checks if a given tree is symmetric
   * 
   * @param tree
   * @return
   */
  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    return tree == null || twoSymmetric(tree.left, tree.right);
  }

  /**
   * Check whether data is same, and whether it is mirror
   * 
   * @param node1
   * @param node2
   * @return
   */
  public static boolean twoSymmetric(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {

    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 != null && node2 != null) {
      return (node1.data == node2.data) && twoSymmetric(node1.left, node2.right)
          && twoSymmetric(node1.right, node2.left);
    }

    // only one node is null
    return false;

  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "IsTreeSymmetric.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
