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

    def isAnagram(self, s: str, t: str) -> bool:
        mydict = {}
        
        for c1 in s:
            mydict[c1] = mydict.get(c1,0) + 1
            
        for c2 in t:
            if c2 in mydict:
                mydict[c2] -= 1
            else:
                return False
            
        for v in mydict.values():
            if v != 0:
                return False
        
        return True

    def isPalindrome(self, s: str) -> bool:
        if s==[]:
            return True
        
        s_corr = [c for c in s.lower() if c.isalnum()]
        
        i = 0
        j = len(s_corr)-1
        
        while i<j:
            if s_corr[i] != s_corr[j]:
                return False
            else:
                i += 1
                j -= 1
        
        return True

    def myAtoi(self, str: str) -> int:
        
        str2 = [c for c in str if c.isnumeric() or c=='-']
        
        if str2 == []:
            return 0
        
        neg = False
        
        if str2[0]=='-':
            neg = True
            str2 = str2[1:]
            
        j = len(str2)-1
        i = 1
        total = 0 
        
        while j>=0:
            total += i*int(str2[j])
            j -= 1
            i *= 10
            
        if neg:
            return -1*total
        else:
            return total
    
    def strStr(self, haystack: str, needle: str) -> int:
        
        if not needle:
            return 0
        
        i = 0
        
        while i <= (len(haystack) - len(needle)):
            
            if haystack[i] == needle[0]:
                j = 0
                while j < len(needle) and (haystack[i+j] == needle[j]):
                    j += 1
                if j == len(needle):
                    return i
            
            i += 1
                
        return -1
