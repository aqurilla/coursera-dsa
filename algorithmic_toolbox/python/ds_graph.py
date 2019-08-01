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
        
# Driver code
g = Graph()
g.addVertex('Dallas')
g.addVertex('Palau')
g.addVertex('Bahamas')
print(g.adjacencyList)
g.addEdge('Dallas', 'Palau')
g.addEdge('Dallas', 'Bahamas')
print(g.adjacencyList)
g.removeVertex('Bahamas')
print(g.adjacencyList)
