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
