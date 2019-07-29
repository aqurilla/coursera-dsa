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
    
    def shift(self):
        # Remove node from beginning of DLL
        if self.length == 0:
            print('Empty list!')
            return
        tmp = self.head
        if self.length == 1:
            self.head = None
            self.tail = None
        else:
            self.head = tmp.next
            self.head.prev = None
        tmp.next = None
        self.length -= 1
        return tmp
    
    def unshift(self, val):
        # Add node at beginning of DLL
        newNode = Node(val)
        if self.length == 0:
            self.head = newNode
            self.tail = newNode
        else:
            self.head.prev = newNode
            newNode.next = self.head
            self.head = newNode
        self.length += 1
        return self
    
    def getter(self, idx):
        # Get index value
        if idx < 0 or idx >= self.length:
            print('Invalid index')
            return None
        if idx <= self.length/2:
            # Start at head
            counter = 0
            tmp = self.head
            while counter != idx:
                tmp = tmp.next
                counter += 1
        else:
            # Start at tail
            counter = self.length - 1
            tmp = self.tail
            while counter != idx:
                tmp = tmp.prev
                counter -= 1
        print(f'Got {tmp.val}')
        return tmp
    
    def setter(self, idx, val):
        # Set index value
        setNode = self.getter(idx)
        if setNode:
            setNode.val = val
            return True
        else:
            print('Invalid index')
            return False
        
    def insert(self, idx, val):
        # Insert into DLL
        if idx < 0 or idx > self.length:
            return False
        if idx == 0:
            return self.unshift(val)
        if idx == self.length:
            return self.push(val)
        currNode = Node(val)
        prevNode = self.getter(idx-1)
        nextNode = prevNode.next
        currNode.prev = prevNode
        currNode.next = nextNode
        prevNode.next = currNode
        nextNode.prev = currNode
        self.length += 1
        return True
    
    def remove(self, idx):
        # Remove from DLL
        if idx < 0 or idx >= self.length:
            print('Invalid index')
            return None
        if idx == 0:
            return self.shift()
        if idx == self.length-1:
            return self.pop()
        currNode = self.getter(idx)
        prevNode = currNode.prev
        nextNode = currNode.next
        prevNode.next = nextNode
        nextNode.prev = prevNode
        currNode.prev = None
        currNode.next = None
        self.length -= 1
        return currNode
             
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

a.traverse()

