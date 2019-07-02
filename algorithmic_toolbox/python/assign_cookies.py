# Src: https://leetcode.com/problems/assign-cookies/submissions/

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:

        num_content = 0
        i = 0
        j = 0

        g.sort()
        s.sort()

        while i<len(g) and j<len(s):
            if g[i]<=s[j]:
                i+=1
                num_content+=1
                j+=1
            else:
                j+=1

        return num_content
