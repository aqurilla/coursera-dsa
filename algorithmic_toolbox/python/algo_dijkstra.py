import math

class WeightedGraph:
    def __init__(self):
        self.adjacencyList = {}
        
    def addVertex(self, vertex):
        if vertex not in self.adjacencyList:
            self.adjacencyList[vertex] = []
            
    def addEdge(self, vertex1, vertex2, weight):
        self.adjacencyList[vertex1].append({'node':vertex2, 'weight':weight})
        self.adjacencyList[vertex2].append({'node':vertex1, 'weight':weight})
        
    def dijkstra(self, start, finish):
        nodes = PriorityQueue()
        distances = {}
        previous = {}
        path = []
        
        # initialize
        for vertex in self.adjacencyList:
            if vertex == start:
                distances[vertex] = 0
                nodes.enq(vertex, 0)
            else:
                distances[vertex] = math.inf
                nodes.enq(vertex, math.inf)
            previous[vertex] = None
        
        while nodes.values:
            minNode = nodes.deq()[0]
            if minNode == finish:
                # build return path
                while previous[minNode]:
                    path.append(minNode)
                    minNode = previous[minNode]
                break
                
            if (minNode or distances[minNode] != math.inf):
                for nextNode in self.adjacencyList[minNode]:
                    candidate = distances[minNode] + nextNode['weight']
                    if candidate < distances[nextNode['node']]:
                        # updating minimum distance
                        distances[nextNode['node']] = candidate
                        # updating previous node to neighbor for min distance
                        previous[nextNode['node']] = minNode
                        nodes.enq(nextNode['node'], candidate)
        path.append(start)
        return list(reversed(path))
                         
class PriorityQueue:
    # simple pq
    def __init__(self):
        self.values = []
    
    def enq(self, val, priority):
        self.values.append((val, priority))
        self.sort()
    
    def deq(self):
        return self.values.pop(0)
    
    def sort(self):
        self.values = sorted(self.values, key = lambda x: x[1])

# Driver code
graph = WeightedGraph()
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addVertex("D");
graph.addVertex("E");
graph.addVertex("F");

graph.addEdge("A","B", 4);
graph.addEdge("A","C", 2);
graph.addEdge("B","E", 3);
graph.addEdge("C","D", 2);
graph.addEdge("C","F", 4);
graph.addEdge("D","E", 3);
graph.addEdge("D","F", 1);
graph.addEdge("E","F", 1);

print(graph.dijkstra("A", "E"))

        
