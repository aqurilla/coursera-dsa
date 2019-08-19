# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    
    def visitNode(self, soln, root):
        if not root:
            return
        
        self.visitNode(soln, root.left)
        soln.append(root.val)
        self.visitNode(soln, root.right)
    
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        soln = []
        self.visitNode(soln, root)
        return soln
