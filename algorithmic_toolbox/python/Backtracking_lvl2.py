import itertools

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits == "":
            return []
        mydict = {'2':['a', 'b', 'c'],
                 '3':['d', 'e', 'f'],
                 '4':['g', 'h', 'i'],
                 '5':['j', 'k', 'l'],
                 '6':['m', 'n', 'o'],
                 '7':['p', 'q', 'r', 's'],
                 '8':['t', 'u', 'v'],
                 '9':['w', 'x', 'y', 'z']}
        
        inplist = list(digits)
        charlist = [mydict[x] for x in inplist]
        soln = [''.join(elem) for elem in itertools.product(*charlist)]
        
        return soln
    
    def permute(self, nums: List[int]) -> List[List[int]]:
        # In-built function
        # return itertools.permutations(nums)
        
        # Recursive approach
        if not nums:
            return []
        
        if len(nums) == 1:
            return [nums]
        
        soln = []
        
        for i in range(len(nums)):
            elem = nums[i]
            rLst = nums[:i] + nums[i+1:]
            
            for Lst in self.permute(rLst):
                soln.append([elem] + Lst)
                
        return soln
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        soln = [[]]
        for n in nums:
            soln = soln + [[n] + elem for elem in soln]                 
        return soln
