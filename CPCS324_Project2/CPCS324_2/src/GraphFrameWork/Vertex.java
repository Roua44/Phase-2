

package GraphFrameWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private int distance;
    private Vertex previous;
    private Map<Vertex, Integer> neighbours;

    public Vertex(String name) {
        this.name = name;
        distance = Integer.MAX_VALUE;
        previous = null;
        neighbours = new HashMap<Vertex, Integer>();
    }

    public void addNeighbour(Vertex vertex, int weight) {
        neighbours.put(vertex, weight);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public Map<Vertex, Integer> getNeighbours() {
        return neighbours;
    }

    public int compareTo(Vertex other) {
        return Integer.compare(distance, other.distance);
    }
}