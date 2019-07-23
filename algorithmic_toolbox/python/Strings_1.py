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
	
    def firstUniqChar(self, s: str) -> int:
        
        mydict = {}
        
        for i,c in enumerate(s):
            if c not in mydict:
                mydict[c] = [i, 1]
            else:
                mydict[c][1] += 1
                        
        filt_l = [v[0] for (k,v) in mydict.items() if v[1]==1]
        
        if filt_l == []:
            return -1
        else:
            return min(filt_l)

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

    
