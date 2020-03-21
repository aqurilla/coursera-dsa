class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
        
class Stack:
    def __init__(self):
        self.size = 0
        self.first = None
        self.last = None
    
    def push(self, val):
        newNode = Node(val)
        if self.size == 0:
            self.first = newNode
            self.last = newNode
        else:
            newNode.next = self.first
            self.first = newNode
        self.size += 1
        return self.size
        
    def pop(self):
        if self.size == 0:
            print('Empty stack')
            return
        tmp = self.first
        if self.size == 1:
            self.first = None
            self.last = None
        else:
            self.first = tmp.next
        tmp.next = None
        self.size -= 1
        print(f'Pop {tmp.val}')
        return tmp

    def traverse(self):
        # Func for traversing
        print('Traversing stack:')
        print('[', end = '')
        k = self.first
        while k:
            if k.next:
                print(k.val, end = ', ')
            else:
                print(k.val, end = '')
            k = k.next
        print(']')
        return

# Driver code
a = Stack()

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

a.traverse()
