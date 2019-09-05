    def canJump(self, nums: List[int]) -> bool:
        maxposindex = 0
        for i,n in enumerate(nums):
            if i > maxposindex:
                return False
            maxposindex = max(maxposindex, i+n)
        return True
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0: return 0
        numcoins = [math.inf for _ in range(amount+1)]
        combpos = [-1 for _ in range(amount+1)]
        numcoins[0] = 0
        
        for j in range(len(coins)):
            for i in range(1, amount+1):
                if i >= coins[j]:
                    if (numcoins[i-coins[j]] + 1 < numcoins[i]):
                        numcoins[i] = numcoins[i - coins[j]] + 1
                        combpos[i] = j
        
        if combpos[amount] == -1:
            return -1
        else:
            return numcoins[amount]
        
    def lengthOfLIS(self, nums: List[int]) -> int:
        # O(n^2) soln
        if not nums:
            return 0
        lis = [1 for _ in range(len(nums))]
    
        for j in range(1, len(nums)):
            for i in range(j):
                if nums[j] > nums[i]:
                    lis[j] = max(lis[j], lis[i] + 1)
        
        return max(lis)
