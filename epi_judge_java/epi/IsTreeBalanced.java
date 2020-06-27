package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsTreeBalanced {

  private static class heightBalanced {
    private int height;
    private boolean balanced;

    public heightBalanced(int height, boolean balanced) {
      this.height = height;
      this.balanced = balanced;
    }
  }

  /**
   * Calculates the height of a tree
   * 
   * @param tree
   * @return
   */
  public static heightBalanced height(BinaryTreeNode<Integer> tree) {

    // base case
    if (tree == null) {
      return new heightBalanced(-1, true);
    }

    heightBalanced lheightB = height(tree.left);
    heightBalanced rheightB = height(tree.right);

    if (!lheightB.balanced) {
      return lheightB;
    }

    if (!rheightB.balanced) {
      return rheightB;
    }

    int height = 1 + Math.max(lheightB.height, rheightB.height);
    boolean balanced = Math.abs(lheightB.height - rheightB.height) <= 1;

    return new heightBalanced(height, balanced);

  }

  @EpiTest(testDataFile = "is_tree_balanced.tsv")
  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    return height(tree).balanced;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "IsTreeBalanced.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
