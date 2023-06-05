/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreigtApp;

import GraphFrameWork.Graph;
import GraphFrameWork.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AFRouteMap extends Graph {

    private String airportCode;

    public AFRouteMap(String airportCode) {
        super();
        this.airportCode = airportCode;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public static AFRouteMap readAFRouteMapFromFile(String fileName, String airportCode) throws FileNotFoundException {
        AFRouteMap afRouteMap = new AFRouteMap(airportCode);
        Scanner scanner = new Scanner(new File(fileName));

        int verticesCount = scanner.nextInt();
        int edgesCount = scanner.nextInt();

        for (int i = 0; i < verticesCount; i++) {
            String vertexName = scanner.next();
            afRouteMap.addVertex(vertexName);
        }

        for (int i = 0; i < edgesCount; i++) {
            String sourceName = scanner.next();
            String destinationName = scanner.next();
            int weight = scanner.nextInt();

            Vertex source = afRouteMap.getVertex(sourceName);
            Vertex destination = afRouteMap.getVertex(destinationName);

            afRouteMap.addEdge(source, destination, weight);
        }

        return afRouteMap;
    }
}
