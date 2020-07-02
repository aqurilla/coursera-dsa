package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeFromPreorderInorder {
  @EpiTest(testDataFile = "tree_from_preorder_inorder.tsv")

  public static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {

    Map<Integer, Integer> mapToInorder = new HashMap<Integer, Integer>();

    for (int i = 0; i < inorder.size(); i++) {
      mapToInorder.put(inorder.get(i), i);
    }

    return buildTree(preorder, 0, preorder.size(), 0, inorder.size(), mapToInorder);
  }

  private static BinaryTreeNode<Integer> buildTree(List<Integer> preorder, int preorderStart, int preorderEnd,
      int inorderStart, int inorderEnd, Map<Integer, Integer> mapToInorder) {

    // check if out of bounds
    if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
      return null;
    }

    // find index of root
    int rootIndx = mapToInorder.get(preorder.get(preorderStart));

    // find length of left subtree
    int leftSubtreeSize = rootIndx - inorderStart;

    // Build subtrees recursively
    return new BinaryTreeNode<>(preorder.get(preorderStart),
        buildTree(preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize, inorderStart, rootIndx,
            mapToInorder),
        buildTree(preorder, preorderStart + 1 + leftSubtreeSize, preorderEnd, rootIndx + 1, inorderEnd, mapToInorder));
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "TreeFromPreorderInorder.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
