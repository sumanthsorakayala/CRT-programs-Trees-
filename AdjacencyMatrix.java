// Java Program to Implement Graph Adjacency Matrix

// Driver Class
public class AdjacencyMatrix {

    // 2D array to store the adjacency matrix
    private boolean[][] adjacencyMatrix;

    // Number of vertices in the graph
    private int numVertices;

    // Constructor to initialize the graph with a given
    // number of vertices
    public AdjacencyMatrix(int numVertices)
    {
        this.numVertices = numVertices;
        adjacencyMatrix
            = new boolean[numVertices][numVertices];
    }

    // Method to add an edge between two vertices
    public void addEdge(int i, int j)
    {
        adjacencyMatrix[i][j] = true;
        // For undirected graphs
        adjacencyMatrix[j][i] = true;
    }

    // Method to remove an edge between two vertices
    public void removeEdge(int i, int j)
    {
        adjacencyMatrix[i][j] = false;

        // For undirected graphs
        adjacencyMatrix[j][i] = false;
    }

    // Method to check whether an edge exists between two
    // vertices
    public boolean hasEdge(int i, int j)
    {
        return adjacencyMatrix[i][j];
    }

    // Method to print the adjacency matrix representation
    // of the graph
    public void printGraph()
    {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(
                    adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    // Main method to test the Graph class
    public static void main(String[] args)
    {
        // Create a new graph with 4 vertices
        AdjacencyMatrix graph = new AdjacencyMatrix(4);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);

        // Print the adjacency matrix representation of the
        // graph
        System.out.println(
            "Graph Representation (Adjacency Matrix):");
        graph.printGraph();

        // Check if there's an edge between vertices 0 and 1
        System.out.println(
            "Checking if there's an edge between vertices 0 and 1: "
            + graph.hasEdge(0, 1));

        // Check if there's an edge between vertices 0 and 3
        System.out.println(
            "Checking if there's an edge between vertices 0 and 3: "
            + graph.hasEdge(0, 3));

        // Remove the edge between vertices 1 and 2
        graph.removeEdge(1, 2);
        System.out.println(
            "After removing edge between vertices 1 and 2:");

        graph.printGraph();
    }
}