class Graph {
    private int[][] adjMatrix;
    private int numVertices;

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add an edge
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;  // Remove this line for directed graph
    }


    // Print the adjacency matrix
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class File01_AdjacencyMatrix {
    public static void main(String[] args) {
        Graph g = new Graph(5);  // Create a graph with 5 vertices

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Adjacency Matrix:");
        g.printMatrix();
    }
}


// Output:
// Adjacency Matrix:
// 0 1 0 0 1 
// 1 0 1 1 1 
// 0 1 0 1 0 
// 0 1 1 0 1 
// 1 1 0 1 0 