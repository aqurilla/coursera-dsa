    def canJump(self, nums: List[int]) -> bool:
        maxposindex = 0
        for i,n in enumerate(nums):
            if i > maxposindex:
                return False
            maxposindex = max(maxposindex, i+n)
        return True
