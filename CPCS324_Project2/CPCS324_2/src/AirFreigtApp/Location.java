package AirFreigtApp;

import GraphFrameWork.Vertex; // Import the Vertex class from the GraphFrameWork package

public class Location extends Vertex { // The Location class extends the Vertex class

    private String address; // A private instance variable to store the location's address

    // A constructor that takes a name and an address as parameters and calls the constructor of the superclass (Vertex) with the name parameter
    public Location(String name, String address) {
        super(name);
        this.address = address;
    }

    // A getter method to return the location's address
    public String getAddress() {
        return address;
    }

    // A setter method to set the location's address
    public void setAddress(String address) {
        this.address = address;
    }
}