/*
Rahaf AlGarni 2106045
Roua Radwan 2010229
Hayat Alzhrani 2105101
Raghad Nahari 2009063
*/
package AirFreigtApp;

import GraphFrameWork.DBAllSourceSPAlg;
import GraphFrameWork.Graph;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirFrightApp {

    static Scanner input = new Scanner(System.in);
    static Graph graph = new Graph();

    public static void main(String[] args) throws FileNotFoundException {

        // Prompt the user to choose which requirement they want to run
        System.out.println("Dijkstra Algorithem to solve Shortest Path problem \nchoose which requirment you want to run \nEnter 1 for requirment 1  or"
                + " Enter 2 for Requirment 2: \n");

        // Read the user's choice
        int input1 = input.nextInt();

        if (input1 == 2) { // If the user chose requirement 2

            // Display a list of options representing different cases with different numbers of vertices and edges
            System.out.println(">>> n is the number of vertices) and (m is the number of edges) : ");
            System.out.println(" 1:  n=1,000 ,  m=10,000");
            System.out.println(" 2:  n=1,000 ,  m=15,000");
            System.out.println(" 3:  n=1,000 ,  m=25,000");
            System.out.println(" 4:  n=5,000 ,  m=15,000");
            System.out.println(" 5:  n=5,000 ,  m=25,000");
            System.out.println(" 6:  n=10,000 , m=15,000");
            System.out.println(" 7:  n=10,000 , m=25,000");

            System.out.print(">>> Enter a case to test : ");
            int Case = input.nextInt();

            switch (Case) {
                case 1:
                    graph = graph(1000, 10000);
                    break;
                case 2:
                    graph = graph(1000, 15000);
                    break;
                case 3:
                    graph = graph(1000, 25000);
                    break;
                case 4:
                    graph = graph(5000, 15000);
                    break;
                case 5:
                    graph = graph(5000, 25000);
                    break;
                case 6:
                    graph = graph(10000, 15000);
                    break;
                case 7:
                    graph = graph(10000, 25000);
                    break;
                default:
                    System.out.println("---Invalid input!---");
                    break;
            }

            // Run Dijkstra's Algorithm on the generated graph for 10 iterations using a loop
            for (int n = 1; n < 11; n++) {
                System.out.println("--------------------------(" + n + ")----------------------------\n\nDijkstra Based Algrothim:");

                DBAllSourceSPAlg alg = new DBAllSourceSPAlg();
                alg.computeDijkstraBasedSPAlg(graph, input1);

            }

        }
        if (input1 == 1) { // If the user chose requirement 1

            // Read a graph from a file
            graph = Graph.readGraphFromFile("input2.txt");

            // Run Dijkstra's Algorithm on the graph
            DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg();
            dijkstra.computeDijkstraBasedSPAlg(graph, input1);

        }
    }

    // A method that generates a random graph with the specified number of vertices and edges using the makeGraph method from the Graph class
    public static Graph graph(int verteces, int edge) throws FileNotFoundException {
        Graph graph = Graph.makeGraph(verteces, edge);
        return graph;
    }
}