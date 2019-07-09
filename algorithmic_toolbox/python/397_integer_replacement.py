# https://leetcode.com/problems/integer-replacement/

class Solution:
    def integerReplacement(self, n: int) -> int:

        if n <= 1:
            return 0
        div2 = n//2
        if (n%2 == 0):
            return self.integerReplacement(n/2) + 1
        else:
            if (div2 == 1) or (div2%2 == 0):
                return self.integerReplacement(n-1) + 1
            else:
                return self.integerReplacement(n+1) + 1
