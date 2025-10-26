import java.util.*;

class GraphList {
    private int numVertices;
    private List<List<Integer>> adjList;

    // Constructor
    public GraphList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);  // Remove for directed graph
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int node : adjList.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

public class File02_AdjacencyList {
    public static void main(String[] args) {
        GraphList g = new GraphList(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }
}

// Output:
// 0: 1 4 
// 1: 0 2 3 4 
// 2: 1 3 
// 3: 1 2 4 
// 4: 0 1 3 
