class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numdict = {}
        for i,n in enumerate(nums):
            if n in numdict and (target==2*n):
                return numdict[n], i
            numdict[n] = i
            if (target-n) in numdict and (i != numdict[target-n]):
                return (numdict[target-n], i)
