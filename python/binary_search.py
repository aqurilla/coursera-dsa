# https://leetcode.com/problems/binary-search/
from math import floor

class Solution:
    def BinarySearch(self, nums, low, high, target):
        if high<low:
            return -1
        mid = floor(low + (high-low)/2)
        if nums[mid]==target:
            return mid
        elif nums[mid]<target:
            return self.BinarySearch(nums, mid+1, high, target)
        else:
            return self.BinarySearch(nums, low, mid-1, target)

    def search(self, nums: List[int], target: int) -> int:
        return self.BinarySearch(nums, 0, len(nums)-1, target)
