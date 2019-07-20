class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        
        if digits[-1]!=9:
            digits[-1]=digits[-1]+1
            return digits
        else:
            digits[-1]=0
            j=-2
            while j >= -len(digits):
                if digits[j]==9:
                    digits[j]=0
                    j-=1
                else:
                    digits[j]=digits[j]+1
                    break
            if j<-len(digits):
                digits.insert(0,1)
                
        return digits
