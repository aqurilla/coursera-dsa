import numpy as np
import random

def Partition(A, l, r):
    x = A[l]
    j = l
    for i in range(l+1, r+1):
        if A[i]<=x:
            j = j+1
            A[j], A[i] = A[i], A[j]
    A[l], A[j] = A[j], A[l]
    return j

def quicksort(A, l, r):
    if l >= r:
        return

    k = np.random.randint(l, r+1)
    A[l], A[k] = A[k], A[l]

    m = Partition(A, l, r)

    quicksort(A, l, m-1)
    quicksort(A, m+1, r)

# Test
while True:
    A = random.sample(range(1,100), 10)
    initialA = A
    quicksort(A, 0, len(A)-1)
    initialA.sort(reverse=True)
    if A == initialA:
        print('OK')
    else:
        print('Error')
        break

# Selection sort code        
def selectionSort(a):
    
    for i in range(len(a)):
        minidx = i
        for j in range(i+1, len(a)):
            if a[j] < a[minidx]:
                minidx = j
        a[minidx], a[i] = a[i], a[minidx]

    return a
