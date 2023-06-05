package AirFreigtApp;

import GraphFrameWork.Edge; // Import the Edge and Vertex classes from the GraphFrameWork package
import GraphFrameWork.Vertex;

public class Route extends Edge { // The Route class extends the Edge class

    private String name; // A private instance variable to store the route's name

    // A constructor that takes a source vertex, a destination vertex, a weight, and a name as parameters, and calls the constructor of the superclass (Edge) with the source, destination, and weight parameters
    public Route(Vertex source, Vertex destination, int weight, String name) {
        super(source, destination, weight);
        this.name = name;
    }

    // A getter method to return the route's name
    public String getName() {
        return name;
    }

    // A setter method to set the route's name
    public void setName(String name) {
        this.name = name;
    }
}