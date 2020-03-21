# https://leetcode.com/problems/leaf-similar-trees/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    def traverseleaf(self, root, A):
        if root == None:
            return

        if (root.left == None) and (root.right) == None:
            A.append(root.val)
        else:
            self.traverseleaf(root.left, A)
            self.traverseleaf(root.right, A)

        return

    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:

        lval_1 = []
        lval_2 = []

        self.traverseleaf(root1, lval_1)
        self.traverseleaf(root2, lval_2)

        if lval_1 == lval_2:
            return True
        else:
            return False
