# Src: https://leetcode.com/problems/last-stone-weight/submissions/

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:

        if stones == []:
            return 0

        while len(stones)>1:
            stones.sort(reverse=True)
            if stones[0]==stones[1]:
                del stones[0]
                del stones[0]
            else:
                stones[0]-=stones[1]
                del stones[1]

        if stones:
            return stones[0]
        else:
            return 0
