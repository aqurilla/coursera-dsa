class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
        
class SinglyLinkedList:
    def __init__(self):
        self.length = 0
        self.head = None
        self.tail = None
        
    def push(self, val):
        newNode = Node(val)
        if not self.head:
            self.head = newNode
            self.tail = newNode
        else:
            self.tail.next = newNode
            self.tail = newNode
        self.length += 1
        return
    
    def traverseList(self):
        # func for traversing the list
        k = self.head
        while k:
            print(k.val)
            k = k.next
        return
            
    
# def push(self, val):
#     newNode = Node(val)
#     newNode.next = self.head
#     if self.length == 0:
#         self.tail = newNode
#     self.head = newNode
#     self.length += 1
        
a = SinglyLinkedList()

a.push('hi')
print(a.tail.val)
print(a.length)
a.push('bye')
print(a.tail.val)
print(a.length)

print(a.traverseList())
