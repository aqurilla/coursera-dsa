class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        dict = {}
        
        for n in nums:
            dict[n] = dict.get(n, 0) + 1
            
        for k,v in dict.items():
            if v==1:
                return k
