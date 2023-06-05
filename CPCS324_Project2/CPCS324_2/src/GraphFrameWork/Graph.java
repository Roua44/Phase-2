package GraphFrameWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Graph {

    private HashMap<String, Vertex> vertices; // A private instance variable to store the vertices in the graph
    private ArrayList<Edge> edges; // A private instance variable to store the edges in the graph

    public Graph() {
        vertices = new HashMap<String, Vertex>();
        edges = new ArrayList<Edge>();
    }

    // A method to add a vertex to the graph given its name
    public Vertex addVertex(String name) {
        Vertex vertex = vertices.get(name); // Check if the vertex already exists in the graph
        if (vertex == null) { // If it doesn't exist, create a new vertex and add it to the vertices map
            vertex = new Vertex(name);
            vertices.put(name, vertex);
        }

        return vertex;
    }

    // A method to add an edge to the graph given its source vertex, destination vertex, and weight
    public void addEdge(Vertex source, Vertex destination, int weight) {
        source.addNeighbour(destination, weight); // Add the destination vertex as a neighbour of the source vertex
        destination.addNeighbour(source, weight); // Add the source vertex as a neighbour of the destination vertex
        edges.add(new Edge(source, destination, weight)); // Add the edge to the edges list
    }

    // A method to return a list of vertex names in the graph
    public ArrayList<String> getVertices() {
        return new ArrayList<String>(vertices.keySet());
    }

    // A method to return a vertex given its name
    public Vertex getVertex(String sourceLabel) {
        return vertices.get(sourceLabel);
    }

    // A method to return an edge given its source vertex and destination vertex
    public Edge getEdge(Vertex source, Vertex destination) {
        for (Edge edge : edges) { // Iterate through the edges in the graph
            if ((edge.getSource() == source && edge.getDestination() == destination)
                    || (edge.getSource() == destination && edge.getDestination() == source)) { // Check if the edge connects the given source and destination vertices
                return edge;
            }
        }
        return null;
    }

    // A method to return a list of edges connected to a given vertex
    public ArrayList<Edge> getEdges(Vertex vertex) {
        ArrayList<Edge> vertexEdges = new ArrayList<Edge>();
        for (Edge edge : edges) { // Iterate through the edges in the graph
            if (edge.getSource() == vertex || edge.getDestination() == vertex) { // Check if the edge is connected to the given vertex
                vertexEdges.add(edge);
            }
        }
        return vertexEdges;
    }

    // A static method to create a random graph with a given number of vertices and edges
    public static Graph makeGraph(int verticesNo, int edgeNo) {
        Random random = new Random();
        Graph graph = new Graph();

        // Add vertices to the graph
        for (int i = 0; i < verticesNo; i++) {
            String vertexName = String.valueOf((char) ('A' + i));
            graph.addVertex(vertexName);
        }

        // Connect all vertices in a line
        for (int i = 0; i < verticesNo - 1; i++) {
            Vertex source = graph.getVertex(String.valueOf((char) ('A' + i)));
            Vertex destination = graph.getVertex(String.valueOf((char) ('A' + i + 1)));
            int weight = random.nextInt(20) + 1;
            graph.addEdge(source, destination, weight);
        }

        // Add remaining edges
        int remaining = edgeNo - (verticesNo - 1) * 2;

        while (remaining > 0) {
            Vertex source = graph.getVertex(String.valueOf((char) ('A' + random.nextInt(verticesNo))));
            Vertex destination = graph.getVertex(String.valueOf((char) ('A' + random.nextInt(verticesNo))));
            int weight = random.nextInt(20) + 1;

            if (source != destination && !graph.isConnected(source, destination)) { // Check if the source and destination vertices are not the same and if there is not already an edge connecting them
                graph.addEdge(source, destination, weight);
                remaining--;
            }
        }

        return graph;
    }

    // A method to check if there is an edge connecting two given vertices
    public boolean isConnected(Vertex source, Vertex destination) {
        for (Edge edge : edges) { // Iterate through the edges in the graph
            if ((edge.getSource() == source && edge.getDestination() == destination)
                    || (edge.getSource() == destination && edge.getDestination() == source)) { // Check if the edge connects the given source and destination vertices
                return true;
            }
        }
        return false;
    }

    // A static method to read a graph from a file with a specific format
    public static Graph readGraphFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));

        String type = scanner.next();
        boolean isDigraph = true;
        if (scanner.nextInt() == 0) { // Check if the graph is directed or undirected
            isDigraph = false;
        }

        int numVertices = scanner.nextInt();
        int numEdges = scanner.nextInt();

        Graph graph = new Graph();

        // Add the edges to the graph
        while (scanner.hasNext()) {
            String sourceLabel = scanner.next();
            String targetLabel = scanner.next();
            int weight = scanner.nextInt();

            Vertex src = graph.addVertex(sourceLabel);
            Vertex dst = graph.addVertex(targetLabel);

            graph.addEdge(src, dst, weight);
            graph.addEdge(dst, src, weight);
            
        }

        scanner.close();

        return graph;
    }
}