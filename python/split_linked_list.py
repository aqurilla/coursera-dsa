# https://leetcode.com/problems/split-linked-list-in-parts/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        head = root
        numelem = 0
        
        while head!=None:
            numelem += 1
            head = head.next
        
        soln = []
        
        if numelem <= k:
            head = root
            
            while head != None:
                a = ListNode(head.val)
                a.next = None
                soln.append(a)
                head = head.next
            
            for _ in range(k-numelem):
                soln.append(None)
                
            return soln
        else:
            ndiv = numelem//k
            nrem = numelem % k
            
            head = root
            
            for _ in range(nrem):
		# can define function
                p = head
                q = p
                for _ in range(ndiv):
                    q = q.next
                head = q.next
                q.next = None
                soln.append(p)
            while head != None:
                p = head
                q = p
                for _ in range(ndiv-1):
                    q = q.next
                head = q.next
                q.next = None
                soln.append(p)
            
            return soln
