# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        
        num1 = 0
        num2 = 0
        
        ptr1 = l1
        ptr2 = l2
        factor = 1
        
        while ptr1:
            num1 += ptr1.val*factor
            factor *= 10
            ptr1 = ptr1.next
        
        factor = 1 
        
        while ptr2:
            num2 += ptr2.val*factor
            factor *= 10
            ptr2 = ptr2.next
        
        total = num1 + num2
        
        head = ListNode(total%10)
        total = total//10
        ptr = head
        
        while total:
            tmp = ListNode(total % 10)
            ptr.next = tmp
            ptr = tmp
            total = total//10
            
        return head
    
    def oddEvenList(self, head: ListNode) -> ListNode:
        
        if not head or head.next == None:
            return head
        
        oddhead = head
        evenhead = head.next
        
        oddPtr = oddhead
        evenPtr = evenhead
        
        while oddPtr and evenPtr and oddPtr.next and evenPtr.next:
            oddPtr.next = oddPtr.next.next
            evenPtr.next = evenPtr.next.next
            oddPtr = oddPtr.next
            evenPtr = evenPtr.next
            
        oddPtr.next = evenhead
        
        return oddhead
            
            
            
        
        
