package GraphFrameWork;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DBAllSourceSPAlg extends ShortestPathAlgorihtm {

    public DBAllSourceSPAlg() {
    }

    // A static method to compute the shortest paths from a selected vertex to all other vertices in the graph using Dijkstra's algorithm
    public static void computeDijkstraBasedSPAlg(Graph graph, int input) throws FileNotFoundException {

        double startTime = 0;
        double finishTime = 0;

        startTime = System.nanoTime();

        if (input == 1) { // If the input is 1, compute the shortest paths from a selected vertex to all other vertices in the graph

            char selectedVertex = 'A'; // Change this to the selected vertex

            for (String v : graph.getVertices()) { // Iterate through all vertices in the graph
                selectedVertex = v.charAt(0);
                System.out.println("\n-------------------------------\n"
                        + "\nThe starting point location is " + selectedVertex
                        + "\nThe routes from location " + selectedVertex + " to the rest of the locations are: \n");

                Vertex source = null;

                for (String vertexName : graph.getVertices()) { // Find the vertex with the selected vertex name
                    if (vertexName.charAt(0) == selectedVertex) {
                        source = graph.getVertex(vertexName);
                        break;
                    }
                }

                if (source == null) { // If the vertex is not found, print an error message and continue to the next vertex
                    System.out.println("Selected vertex not found.");
                    continue;
                }

                SingleSourceSPAlg.computeDijkstraAlg(source); // Compute the shortest path from the selected vertex to all other vertices using Dijkstra's algorithm

                for (String vertexName : graph.getVertices()) { // Iterate through all vertices in the graph
                    if (!vertexName.equals(source.getName())) { // If the vertex is not the same as the selected vertex
                        ArrayList<Vertex> path = new ArrayList<Vertex>();
                        Vertex current = null;
                        int distance = 0;

                        for (Edge edge : graph.getEdges(source)) { // Iterate through all edges connected to the selected vertex
                            Vertex vertex = edge.getDestination();
                            if (vertex.getName().equals(vertexName)) { // If the edge connects to the current vertex, set it as the current vertex
                                current = vertex;
                                break;
                            }
                        }

                        if (current == null) { // If the current vertex is not found, print an error message and continue to the next vertex
                            System.out.println("No path from " + source.getName() + " to " + vertexName);
                            continue;
                        }

                        // Add all vertices in the shortest path to the path list and calculate the distance
                        while (current != null && current.getPrevious() != null && !current.getName().equals(source.getName()) && !path.contains(current)) {
                            path.add(0, current);
                            Vertex previous = current.getPrevious();
                            Edge edge = graph.getEdge(previous, current);
                            if (edge != null) {
                                distance += edge.getWeight();
                            }
                            current = previous;
                        }

                        path.add(0, source);

                        System.out.print("loc." + source.getName() + " : ");
                        for (int i = 0; i < path.size(); i++) { // Print the shortest path
                            System.out.print("loc." + path.get(i).getName());

                            if (i < path.size() - 1) {
                                // Calculate the distance between adjacent vertices in the path
                                Edge edge = graph.getEdge(path.get(i), path.get(i + 1));
                                if (edge != null) {
                                    distance += edge.getWeight();
                                    System.out.print(" - ");
                                }
                            }
                        }

                        System.out.println(" --- route length: " + distance / 2);
                    }
                }
            }
        }
        finishTime = System.nanoTime();

        double totalTime = finishTime - startTime;
        if (input == 2) { // If the input is 2, print the total runtime
            System.out.println("Runtime (in Nano) : " + totalTime + "\n\n");
        }

    }

    @Override
    public void computeShortestPaths(Graph graph) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}