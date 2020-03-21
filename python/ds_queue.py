class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
        
class Queue:
    def __init__(self):
        self.size = 0
        self.first = None
        self.last = None
    
    def enq(self, val):
        # Add to end
        newNode = Node(val)
        if self.size == 0:
            self.first = newNode
            self.last = newNode
        else:
            self.last.next = newNode
            self.last = newNode
        self.size += 1
        return self.size
        
    def deq(self):
        # Remove from beginning
        if self.size == 0:
            print('Empty queue')
            return
        tmp = self.first
        if self.size == 1:
            self.first = None
            self.last = None
        else:
            self.first = tmp.next
        tmp.next = None
        self.size -= 1
        print(f'Got {tmp.val}')
        return tmp

    def traverse(self):
        # Func for traversing
        print('Traversing:')
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
a = Queue()

a.enq(143)
a.enq(270)
a.enq(981)
a.enq(2120)
a.enq(1243)

a.traverse()

a.deq()
a.deq()
a.deq()
a.deq()
a.deq()
a.deq()
a.deq()


a.traverse()
