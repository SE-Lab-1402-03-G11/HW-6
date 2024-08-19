package strategy;

import graph.Graph;
import graph.Node;

public class BusStrategy implements Strategy {

    @Override
    public int calculateDistance(Node source, Node destination, Graph graph, int trainPrice) {
        graph.dijkstra(source, null);
        return destination.getDistance();
    }

    @Override
    public boolean existPath(Node source, Node destination, Node hatedCity, Graph graph) {
        graph.dijkstra(source, hatedCity);
        return destination.getDistance() < Integer.MAX_VALUE;
    }
}