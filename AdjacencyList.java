// Java Program to Implement Adjacency List
import java.util.*;

// Class representing a graph using adjacency list
// representation
class Graph {
    private Map<Integer, List<Integer> > adjacencyList;

    // Constructor to initialize the adjacency list
    public Graph() {
      adjacencyList = new HashMap<>();
    }

    // Method to add a new vertex to the graph
    public void addVertex(int vertex)
    {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int destination)
    {
        adjacencyList.get(source).add(destination);
    }

    // Method to remove a vertex from the graph
    public void removeVertex(int vertex)
    {
        adjacencyList.remove(vertex);
        // Remove the vertex from the neighbors of other
        // vertices
        for (List<Integer> neighbors :
             adjacencyList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    // Method to remove an edge between two vertices
    public void removeEdge(int source, int destination)
    {
        adjacencyList.get(source).remove(
            Integer.valueOf(destination));

        // For undirected graph, uncomment below line
        // adjacencyList.get(destination).remove(Integer.valueOf(source));
    }

    // Method to get the neighbors of a vertex
    public List<Integer> getNeighbors(int vertex)
    {
        return adjacencyList.get(vertex);
    }

    // Method to print the graph
    public void printGraph()
    {
        for (Map.Entry<Integer, List<Integer> > entry :
             adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyList {
    public static void main(String[] args)
    {
        // Create a graph
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);

        // Print the graph
        System.out.println("Graph:");
        graph.printGraph();

        // Remove an edge and print the graph
        graph.removeEdge(0, 1);
        System.out.println("After removing edge (0, 1):");
        graph.printGraph();

        // Remove a vertex and print the graph
        graph.removeVertex(2);
        System.out.println("After removing vertex 2:");
        graph.printGraph();
    }
}