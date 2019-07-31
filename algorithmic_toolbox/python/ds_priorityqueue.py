# Priority Queue
class Node:
    def __init__(self, val, priority):
        self.val = val
        self.priority = priority

class PriorityQueue:
    # Min-priority queue
    def __init__(self):
        self.values = []
        
    def enqueue(self, val, priority):
        newNode = Node(val, priority)
        self.values.append(newNode)
        self.bubbleUp()
        
    def bubbleUp(self):
        idx = len(self.values) - 1
        while idx > 0:
            parentIdx = math.floor((idx-1)/2)
            if self.values[idx].priority < \
               self.values[parentIdx].priority:
                self.values[parentIdx], self.values[idx] = \
                self.values[idx], self.values[parentIdx]
                idx = parentIdx
            else:
                break
        return
    
    def dequeue(self):
        if not self.values:
            print('Empty heap')
            return None
        minval = self.values[0]
        lastval = self.values.pop()
        if len(self.values) > 0:
            self.values[0] = lastval
            self.sinkDown()
        return minval
        
    def sinkDown(self):
        idx = 0
        length = len(self.values)
        elem = self.values[0]
        while True:
            leftIdx = 2*idx + 1
            rightIdx = 2*idx + 2
            swap = None
            if leftIdx < length:
                leftChild = self.values[leftIdx]
                if leftChild.priority < elem.priority:
                    swap = leftIdx
            if rightIdx < length:
                rightChild = self.values[rightIdx]
                if (swap == None and rightChild.priority < elem.priority) or \
                   (swap != None and rightChild.priority < leftChild.priority):
                    swap = rightIdx
            if swap == None:
                break
            else:
                self.values[idx], self.values[swap] = \
                self.values[swap], self.values[idx]
                idx = swap
    
        
