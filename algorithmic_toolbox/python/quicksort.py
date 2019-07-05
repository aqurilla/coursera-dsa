from numpy import random

def Partition(A, l, r):
    x = A[l]
    
    while A[j]



def quicksort(A, l, r):
    if l >= r:
        return
    k = random.randint(l, r+1)
    A[0], A[k] = A[k], A[0]

    m = Partition(A, l, r)

    quicksort(A, l, m-1)
    quicksort(A, m+1, r)

    return A
