class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = -1
        j = 0
        while j<len(nums):
            while j < len(nums) and nums[j] == 0:
                j += 1
            if j >= len(nums): break
            i += 1
            nums[i] = nums[j]
            j += 1
        i += 1    
        while i < len(nums):
            nums[i] = 0
            i += 1
            
        return
