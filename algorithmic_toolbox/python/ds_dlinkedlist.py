class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None
        
class DoublyLinkedList:
    def __init__(self):
        self.length = 0
        self.head = None
        self.tail = None
        
    def push(self, val):
        # Add node at end of DLL
        print(f'Pushing {val}')
        newNode = Node(val)
        if self.length == 0:
            self.head = newNode
            self.tail = newNode
        else:
            self.tail.next = newNode
            newNode.prev = self.tail
            self.tail = newNode    
        self.length += 1
        return self
    
    def pop(self):
        # Remove from end of DLL
        if self.length == 0:
            print('Empty list!')
            return
        popNode = self.tail
        self.tail = popNode.prev
        if self.tail:
            self.tail.next = None
        self.length -= 1
        if self.length == 0: self.head = None
        print(f'Pop value: {popNode.val}')
        popNode.prev = None
        return popNode
            
    def traverse(self):
        # Func for traversing list
        print('Traversing list:')
        print('[', end = '')
        k = self.head
        while k:
            if k.next:
                print(k.val, end = ', ')
            else:
                print(k.val, end = '')
            k = k.next
        print(']')
        return
    
# Driver code
a = DoublyLinkedList()

a.push(143)
a.push(270)
a.push(981)
a.push(2120)
a.push(1243)

a.traverse()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.traverse()
