class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        mydict = {0:0, 1:0, 2:0}
        
        for n in nums:
            mydict[n] += 1
        print(mydict)
        
        nums[:mydict[0]] = [0]*mydict[0]
        nums[mydict[0]:mydict[0]+mydict[1]] = [1]*mydict[1]
        nums[mydict[0]+mydict[1]:mydict[0]+mydict[1]+mydict[2]] = [2]*mydict[2]
        
        return
