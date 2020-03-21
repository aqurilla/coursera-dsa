class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        i = 0
        j = 1
        
        while j<len(nums):
            while j<len(nums) and nums[i]==nums[j]:
                j+=1
            if j>=len(nums): break
            i+=1
            nums[i] = nums[j]
            j+=1
            
        return i+1
