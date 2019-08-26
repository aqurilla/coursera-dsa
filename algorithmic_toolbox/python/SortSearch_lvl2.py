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
    
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        
        for n in range(1,len(nums)-1):
            if nums[n-1]<nums[n] and nums[n+1]<nums[n]:
                return n
            
        if nums[0]>nums[1]:
            return 0
        elif nums[len(nums)-1]>nums[len(nums)-2]:
            return len(nums)-1
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        
        left = 0
        right = len(nums)-1
        
        while left <= right:
            mid = left + (right - left)//2
            if nums[mid] == target:
                leftrange = mid
                rightrange = mid
                while leftrange > 0 and nums[leftrange-1] == target:
                    leftrange -= 1
                while rightrange < len(nums)-1 and nums[rightrange+1] == target:
                    rightrange += 1
                return [leftrange, rightrange]
                    
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        # Not found
        return [-1, -1]
    
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # O(nlogn) solution
        nums.sort(reverse=True)
        return nums[k-1]
    
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        if not nums:
            return []
        
        mydict = {}
        
        for n in nums:
            mydict[n] = mydict.get(n,0) + 1
            
        soln = []
        
        for key, val in mydict.items():
            if not soln:
                soln.append((key, val))
                continue
            i = 0
            while i<len(soln) and soln[i][1]>=val:
                i += 1
            soln.insert(i, (key,val))
        
        return [key for (key,val) in soln[:k]]
