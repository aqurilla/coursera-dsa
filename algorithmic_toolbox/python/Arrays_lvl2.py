class Solution:
    
    def print2d(self, matrix):
        for row in matrix:
            for item in row:
                print(item, end=" ")
            print()
    
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Given an m x n matrix, if an element is 0, 
        sets its entire row and column to 0
        """
        # Print original matrix
        self.print2d(matrix)
        rowlocs = set()
        collocs = set()
        
        for i,row in enumerate(matrix):
            for j,item in enumerate(row):
                if item == 0:
                    rowlocs.add(i)
                    collocs.add(j)
        
        for r in rowlocs:
            matrix[r] = [0 for _ in range(len(matrix[r]))]
            
        for c in collocs:
            for row in matrix:
                row[c] = 0
        
        # Modified matrix
        self.print2d(matrix)
        
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        Finds groups of anagrams in input list of strings
        """
        soln = {}     
        for word in strs:
            sortedWord = "".join(sorted(word))
            if sortedWord not in soln:
                soln[sortedWord] = []
            soln[sortedWord].append(word)
                  
        return soln.values()
    
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if s == "":
            return 0
        
        left = 0
        right = 0
        maxlen = 0
        mychars = set()
        
        while right < len(s) and left < len(s):
            if s[right] not in mychars:
                mychars.add(s[right])
                right += 1
                maxlen = max(maxlen, right - left) 
            else:
                mychars.remove(s[left])
                left += 1
                
        return maxlen
    
    def increasingTriplet(self, nums: List[int]) -> bool:
        
        n1 = math.inf
        n2 = math.inf
        
        for n in nums:
            if n <= n1:
                n1 = n
            elif n <= n2:
                n2 = n
            else:
                return True
        
        return False
    
    def threeSum(self, nums: List[int]) -> List[List[int]]:   
        soln = []      
        nums.sort()    
        for idx in range(len(nums) - 2):
            if idx > 0 and nums[idx] == nums[idx-1]:
                continue
            n = nums[idx]
            left = idx+1
            right = len(nums) - 1
            while left < right:
                sum2 = nums[left] + nums[right]
                if sum2 == -n:
                    triplet = [n, nums[left], nums[right]]
                    soln.append(triplet)
                    while left < right and nums[left]==nums[left+1]:
                        left += 1
                    left += 1
                    while left < right and nums[right]==nums[right-1]:
                        right -= 1
                    right -= 1
                elif sum2 < -n:
                    left += 1
                else:
                    right -= 1
        return soln
