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
    
    def modTraversal(self, soln, root, counter, k):
        
        if root == None:
            return
        
        self.modTraversal(soln, root.left, counter, k)
        soln.append(root.val)
        counter += 1
        if counter >= k:
            return
        self.modTraversal(soln, root.right, counter, k)
        
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        soln = []
        counter = 0
        self.modTraversal(soln, root, counter, k)
        
        return soln[k-1]
    
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        soln = []
        nodeq = []
        
        nodeq.append(root)
        
        k = 1
        lvl = 1
        counter = 0
        
        while nodeq:
            elem = nodeq.pop(0)
            if not elem:
                soln.append(None)
                continue
            soln.append(elem.val)
            if elem.left:
                nodeq.append(elem.left)
            else:
                nodeq.append(None)
            if elem.right:
                nodeq.append(elem.right)
            else:
                nodeq.append(None)
        
        # Remove trailing None
        while soln and not soln[-1]:
            soln.pop()
        
        zigzag = []
        
        numelem = 1
        start = 0
        end = 0
        k = 1
        
        while end < len(soln):
            start = end
            end = start + numelem
            if end >= len(soln):
                tmp = soln[start:]
            else:
                tmp = soln[start:end]
            tmp = [x for x in tmp if x is not None]
            
            if k>0:
                zigzag.append(tmp)
            else:
                zigzag.append(reversed(tmp))
                
            k *= -1
            numelem *= 2
        
        return soln
