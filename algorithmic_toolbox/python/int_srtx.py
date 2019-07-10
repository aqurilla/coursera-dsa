# https://leetcode.com/problems/sqrtx/

class Solution:

    def bs_search(self, x, l, r):
        if l>r:
            return -1
        m = l + (r-l)//2
        if m*m==x or (m*m<x and (m+1)*(m+1)>x):
            return m

        if m*m<x:
            return self.bs_search(x, m+1, r)
        else:
            return self.bs_search(x, l, m-1)



    def mySqrt(self, x: int) -> int:

        if x==0:
            return 0

        return self.bs_search(x, 0, (x+4)//2)
