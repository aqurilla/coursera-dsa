# https://leetcode.com/problems/edit-distance/

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:

        nrows = len(word2) + 1
        ncols = len(word1) + 1

        T = [[0 for c in range(ncols)] for r in range(nrows)]

        for i in range(nrows):
            T[i][0] = i

        for j in range(ncols):
            T[0][j] = j

        for i in range(1, nrows):
            for j in range(1, ncols):

                if word2[i-1]==word1[j-1]:
                    # If characters match, same value as substring without the character
                    T[i][j] = T[i-1][j-1]
                else:
                    # o.w. minimum solution from either ins, rep or del
                    T[i][j] = min(T[i-1][j-1], T[i-1][j], T[i][j-1]) + 1

        return T[nrows-1][ncols-1]
