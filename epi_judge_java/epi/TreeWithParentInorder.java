package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.LinkedList;
import java.util.List;

public class TreeWithParentInorder {
  @EpiTest(testDataFile = "tree_with_parent_inorder.tsv")

  public static List<Integer> inorderTraversal(BinaryTree<Integer> tree) {

    // inorder traversal using O(1) space
    // without recursion
    BinaryTree<Integer> prevNode = null;
    BinaryTree<Integer> currNode = tree;
    BinaryTree<Integer> nextNode = tree;

    List<Integer> soln = new LinkedList<>();

    while (currNode != null) {
      if (currNode.left == null && currNode.right == null) {
        // if at leaf, add to solution
        // go back to parent
        soln.add(currNode.data);
        nextNode = currNode.parent;
      } else if (prevNode == null || prevNode.equals(currNode.parent)) {
        // if prev was parent, go to left child
        if (currNode.left != null) {
          nextNode = currNode.left;
        } else {
          soln.add(currNode.data);
          nextNode = currNode.right;
        }

      } else if (prevNode.equals(currNode.left)) {
        // if prev was left child, add to soln, go to right if not null
        soln.add(currNode.data);
        nextNode = currNode.right != null ? currNode.right : currNode.parent;

      } else if (prevNode.equals(currNode.right)) {
        // if prev was right child, go to parent
        nextNode = currNode.parent;
      }

      prevNode = currNode;
      currNode = nextNode;

    }

    return soln;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "TreeWithParentInorder.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
