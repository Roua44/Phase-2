package GraphFrameWork;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.PriorityQueue;

public class SingleSourceSPAlg extends ShortestPathAlgorihtm {

    // Static method to compute Dijkstra's algorithm for a given source vertex
    public static void computeDijkstraAlg(Vertex source) {
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        source.setDistance(0);
        queue.add(source);

        // Loop until all vertices have been visited
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            // Loop through all neighbors of the current vertex
            for (Map.Entry<Vertex, Integer> neighbourEntry : current.getNeighbours().entrySet()) {
                Vertex neighbour = neighbourEntry.getKey();
                int weight = neighbourEntry.getValue();
                int distance = current.getDistance() + weight;

                // If the new distance to the neighbor is shorter, update the neighbor's distance and previous vertex
                if (distance < neighbour.getDistance()) {
                    queue.remove(neighbour);
                    neighbour.setDistance(distance);
                    neighbour.setPrevious(current);
                    queue.add(neighbour);
                }
            }
        }
    }

    @Override
    public void computeShortestPaths(Graph graph) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}