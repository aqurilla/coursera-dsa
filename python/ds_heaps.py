# Heaps
class MaxBinaryHeap:
    def __init__(self):
        self.values = []
        
    def insert(self, val):
        self.values.append(val)
        index = len(self.values) - 1
        self.bubbleUp()
        
    def bubbleUp(self):
        idx = len(self.values) - 1
        while idx > 0:
            parentIdx = math.floor((idx-1)/2)
            if self.values[idx] > self.values[parentIdx]:
                self.values[parentIdx], self.values[idx] = self.values[idx], self.values[parentIdx]
                idx = parentIdx
            else:
                break
        return
    
    def extractMax(self):
        if not self.values:
            print('Empty heap')
            return None
        maxval = self.values[0]
        lastval = self.values.pop()
        if len(self.values) > 0:
            self.values[0] = lastval
            self.maxHeapify()
        return maxval
        
    def maxHeapify(self):
        idx = 0
        length = len(self.values)
        elem = self.values[0]
        while True:
            leftIdx = 2*idx + 1
            rightIdx = 2*idx + 2
            swap = None
            if leftIdx < length:
                leftChild = self.values[leftIdx]
                if leftChild > elem:
                    swap = leftIdx
            if rightIdx < length:
                rightChild = self.values[rightIdx]
                if (swap == None and rightChild > elem) or \
                   (swap != None and rightChild > leftChild):
                    swap = rightIdx
            if swap == None:
                break
            else:
                self.values[idx], self.values[swap] = \
                self.values[swap], self.values[idx]
                idx = swap
        
# Driver code
a = MaxBinaryHeap()
a.insert(41)
a.insert(39)
a.insert(33)
a.insert(18)
a.insert(27)
a.insert(12)
a.insert(55)
a.insert(1)
a.insert(200)
print(a.values)
print(a.extractMax())
print(a.extractMax())
print(a.extractMax())
print(a.extractMax())
print(a.extractMax())
print(a.extractMax())
print(a.extractMax())
print(a.extractMax())
print(a.extractMax())
    
        
