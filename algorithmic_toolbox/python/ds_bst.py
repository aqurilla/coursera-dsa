# Binary Search Tree
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        
class BST:
    def __init__(self):
        self.root = None
        
    def insert(self, val):
        newNode = Node(val)
        if not self.root:
            self.root = newNode
            return self
        currNode = self.root
        while True:
            if val == currNode.val: return None
            if val < currNode.val:
                if currNode.left == None:
                    currNode.left = newNode
                    return self
                else:
                    currNode = currNode.left
            else:
                if currNode.right == None:
                    currNode.right = newNode
                    return self
                else:
                    currNode = currNode.right
                    
    def find(self, val):
        if not self.root: 
            print('Empty tree')
            return False
        currNode = self.root
        while currNode:
            if currNode.val == val:
                print(f'Found {val}')
                return currNode
            elif currNode.val > val:
                currNode = currNode.left
            else:
                currNode = currNode.right
        
        print(f'Did not find {val}')
        return False
    
    def BFS(self):
        data = []
        queue = []
        queue.append(self.root)
        while queue:
            currNode = queue.pop(0)
            data.append(currNode.val)
            if currNode.left: queue.append(currNode.left)
            if currNode.right: queue.append(currNode.right)
        return data
        
    def DFSPreOrder(self):
        data = []
        
        def traverse(currNode):
            data.append(currNode.val)
            if currNode.left:
                traverse(currNode.left)
            if currNode.right:
                traverse(currNode.right)
        
        traverse(self.root)
        return data
    
    def DFSInOrder(self):
        data = []
        
        def traverse(currNode):
            if currNode.left:
                traverse(currNode.left)
            data.append(currNode.val)
            if currNode.right:
                traverse(currNode.right)
        
        traverse(self.root)
        return data
    
    def DFSPostOrder(self):
        data = []
        
        def traverse(currNode):
            if currNode.left:
                traverse(currNode.left)
            if currNode.right:
                traverse(currNode.right)
            data.append(currNode.val)
        
        traverse(self.root)
        return data
                     
# Driver code
bst1 = BST()
bst1.insert(10)
bst1.insert(6)
bst1.insert(15)
bst1.insert(3)
bst1.insert(8)
bst1.insert(20)
           
print('Breadth first search:')
print(bst1.BFS())
print('Pre-order DFS:')
print(bst1.DFSPreOrder())
print('In-order DFS:')
print(bst1.DFSInOrder())
print('Post-order DFS:')
print(bst1.DFSPostOrder())
        
