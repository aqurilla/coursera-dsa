class WeightedGraph:
    def __init__(self):
        self.adjacencyList = {}
        
    def addVertex(self, vertex):
        if vertex not in self.adjacencyList:
            self.adjacencyList[vertex] = []
            
    def addEdge(self, vertex1, vertex2, weight):
        self.adjacencyList[vertex1].append({'node':vertex2, 'weight':weight})
        self.adjacencyList[vertex2].append({'node':vertex1, 'weight':weight})




# Driver code
wg = WeightedGraph()
wg.addVertex("A")
wg.addVertex("B")
wg.addVertex("C")
wg.addEdge("A", "B", 9)
wg.addEdge("A", "C", 5)
wg.addEdge("B", "C", 7)
print(wg.adjacencyList)

        
