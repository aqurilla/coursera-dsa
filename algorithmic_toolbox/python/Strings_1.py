class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        i = 0
        j = len(s)-1
        
        while i<j:
            tmp = s[i]
            s[i] = s[j]
            s[j] = tmp
            i = i+1
            j = j-1
            
        return

    def firstNonRepeatingChar(self, s: str) -> int:
        
        i = 0
        j = 0
        
        while i<len(s):
            k = 0
            j = i+1
            while j<len(s) and s[i]==s[j]:
                k+=1
                j+=1
            if k == 0:
                return i
            elif j==len(s):
                return -1
            else:
                i = j

    
