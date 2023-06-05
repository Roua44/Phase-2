package GraphFrameWork;

public class Edge {

    private Vertex source; // A private instance variable to store the source vertex of the edge
    private Vertex destination; // A private instance variable to store the destination vertex of the edge
    private int weight; // A private instance variable to store the weight of the edge

    // A constructor that takes a source vertex, a destination vertex, and a weight as parameters and sets the corresponding instance variables
    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // A getter method to return the source vertex of the edge
    public Vertex getSource() {
        return source;
    }

    // A getter method to return the destination vertex of the edge
    public Vertex getDestination() {
        return destination;
    }

    // A getter method to return the weight of the edge
    public int getWeight() {
        return weight;
    }
}