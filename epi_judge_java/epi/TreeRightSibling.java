package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeRightSibling {
  public static class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;
    public BinaryTreeNode<T> next = null; // Populates this field.

    public BinaryTreeNode(T data) {
      this.data = data;
    }
  }

  public static void constructRightSibling(BinaryTreeNode<Integer> tree) {

    // Approach #1

    // at each level, the next fields can be set for the level below it
    BinaryTreeNode<Integer> startingNode = tree;
    BinaryTreeNode<Integer> currNode = startingNode;

    while (startingNode != null) {
      startingNode = startingNode.left;

      while (currNode != null) {
        if (currNode.left != null) {
          currNode.left.next = currNode.right;
        }

        if (currNode.right != null && currNode.next != null) {
          currNode.right.next = currNode.next.left;
        }

        currNode = currNode.next;
      }

      currNode = startingNode;

    }

    // Approach #2

    // Deque<BinaryTreeNode<Integer>> currLevel = new
    // LinkedList<BinaryTreeNode<Integer>>();
    // Deque<BinaryTreeNode<Integer>> nextLevel = new
    // LinkedList<BinaryTreeNode<Integer>>();
    // List<BinaryTreeNode<Integer>> nodeList = new
    // LinkedList<BinaryTreeNode<Integer>>();

    // currLevel.add(tree);

    // while (!currLevel.isEmpty()) {
    // BinaryTreeNode<Integer> node = currLevel.removeFirst();

    // if (node.left != null) {
    // nextLevel.addLast(node.left);
    // nodeList.add(node.left);
    // }
    // if (node.right != null) {
    // nextLevel.addLast(node.right);
    // nodeList.add(node.right);
    // }

    // if (currLevel.isEmpty() && !nextLevel.isEmpty()) {

    // // make connections
    // for (int i = 0; i < nodeList.size() - 1; i++) {
    // nodeList.get(i).next = nodeList.get(i + 1);
    // }

    // // swap curr and next levels
    // currLevel = nextLevel;
    // nextLevel = new LinkedList<BinaryTreeNode<Integer>>();
    // nodeList = new LinkedList<BinaryTreeNode<Integer>>();

    // }

    // }

    return;
  }

  private static BinaryTreeNode<Integer> cloneTree(BinaryTree<Integer> original) {
    if (original == null) {
      return null;
    }
    BinaryTreeNode<Integer> cloned = new BinaryTreeNode<>(original.data);
    cloned.left = cloneTree(original.left);
    cloned.right = cloneTree(original.right);
    return cloned;
  }

  @EpiTest(testDataFile = "tree_right_sibling.tsv")
  public static List<List<Integer>> constructRightSiblingWrapper(TimedExecutor executor, BinaryTree<Integer> tree)
      throws Exception {
    BinaryTreeNode<Integer> cloned = cloneTree(tree);

    executor.run(() -> constructRightSibling(cloned));

    List<List<Integer>> result = new ArrayList<>();
    BinaryTreeNode<Integer> levelStart = cloned;
    while (levelStart != null) {
      List<Integer> level = new ArrayList<>();
      BinaryTreeNode<Integer> levelIt = levelStart;
      while (levelIt != null) {
        level.add(levelIt.data);
        levelIt = levelIt.next;
      }
      result.add(level);
      levelStart = levelStart.left;
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "TreeRightSibling.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
