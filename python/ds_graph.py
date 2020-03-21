# Graphs

class Graph:
    def __init__(self):
        self.adjacencyList = {}
        
    def addVertex(self, vertex):
        if vertex not in self.adjacencyList:
            self.adjacencyList[vertex] = []
        return
        
    def addEdge(self, vertex1, vertex2):
        self.adjacencyList[vertex1].append(vertex2)
        self.adjacencyList[vertex2].append(vertex1)
        return
        
    def removeEdge(self, vertex1, vertex2):
        self.adjacencyList[vertex1] = [v for v in self.adjacencyList[vertex1] if v != vertex2]
        self.adjacencyList[vertex2] = [v for v in self.adjacencyList[vertex2] if v != vertex1]
        return
    
    def removeVertex(self, vertex):
        while self.adjacencyList[vertex]:
            vertex1 = self.adjacencyList[vertex].pop()
            self.removeEdge(vertex, vertex1)
        self.adjacencyList.pop(vertex)
        return
    
    def DFSrecursive(self, start):
        soln = []
        visited = {}
        
        def DFS(vertex):
            if not vertex:
                return
            visited[vertex] = True
            soln.append(vertex)
            for v in self.adjacencyList[vertex]:
                if v not in visited:
                    DFS(v)            
        DFS(start)
        return soln
    
    def DFSiterative(self, start):
        S = []
        soln = []
        visited = {}
        S.insert(0, start)
        while S:
            vertex = S.pop(0)
            if vertex not in visited:
                soln.append(vertex)
                visited[vertex] = True
                for v in self.adjacencyList[vertex]:
                    S.insert(0, v)
        return soln
    
    def BFStraverse(self, start):
        Q = []
        soln = []
        visited = {}
        Q.append(start)
        while Q:
            vertex = Q.pop(0)
            if vertex not in visited:
                visited[vertex] = True
                soln.append(vertex)
                for v in self.adjacencyList[vertex]:
                    Q.append(v)
        return soln

# Driver code
g = Graph()
g.addVertex("A")
g.addVertex("B")
g.addVertex("C")
g.addVertex("D")
g.addVertex("E")
g.addVertex("F")

g.addEdge("A","B")
g.addEdge("A","C")
g.addEdge("B","D")
g.addEdge("C","E")
g.addEdge("D","E")
g.addEdge("D","F")
g.addEdge("E","F")

k1 = list(g.adjacencyList.keys())[0]
print('DFS traversal (recursive):')
print(g.DFSrecursive(k1))
print('DFS traversal (iterative):')
print(g.DFSiterative(k1))
print('BFS traversal (iterative):')
print(g.BFStraverse(k1))

