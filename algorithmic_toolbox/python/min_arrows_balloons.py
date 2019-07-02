# Src: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:

        points.sort(key = lambda x : (x[0],x[1]))

        i = 0
        num_arrows = 0

        while i<len(points):
            prev_point = points[i]
            j = i+1
            num_arrows += 1
            while j<len(points) and prev_point[1] >= points[j][0]:
                prev_point = [ max(prev_point[0], points[j][0]), min(prev_point[1], points[j][1])]
                j+=1
            i=j
        return num_arrows
