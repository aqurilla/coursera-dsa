package epi;

import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

public class LowestCommonAncestorWithParent {

  public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0, BinaryTree<Integer> node1) {

    // Find the heights of each node
    int h0 = treeHeight(node0);
    int h1 = treeHeight(node1);

    // Make node0 the further one
    if (h1 > h0) {
      BinaryTree<Integer> temp = node0;
      node0 = node1;
      node1 = temp;
    }

    int hdiff = Math.abs(h0 - h1);

    // Move the further node by the difference
    while (hdiff > 0) {
      if (node0 == node1) {
        return node0;
      }
      node0 = node0.parent;
      hdiff--;
    }

    // Find first node where pointers are equal
    while (node0 != null && node1 != null) {
      if (node0 == node1) {
        return node0;
      }
      node0 = node0.parent;
      node1 = node1.parent;
    }

    return null;
  }

  private static int treeHeight(BinaryTree<Integer> node) {
    int height = 0;

    while (node.parent != null) {
      node = node.parent;
      height++;
    }

    return height;
  }

  @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
  public static int lcaWrapper(TimedExecutor executor, BinaryTree<Integer> tree, Integer key0, Integer key1)
      throws Exception {
    BinaryTree<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BinaryTree<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BinaryTree<Integer> result = executor.run(() -> LCA(node0, node1));

    if (result == null) {
      throw new TestFailure("Result can not be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "LowestCommonAncestorWithParent.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
