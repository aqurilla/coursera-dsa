package epi;

import java.util.ArrayList;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsListPalindromic {
  @EpiTest(testDataFile = "is_list_palindromic.tsv")

  public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {

    ArrayList<Integer> array = new ArrayList<>();

    while (L != null) {
      array.add(L.data);
      L = L.next;
    }

    for (int i = 0, j = array.size() - 1; i < j; i++, j--) {
      if (!array.get(i).equals(array.get(j))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "IsListPalindromic.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
