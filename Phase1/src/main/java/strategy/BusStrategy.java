package strategy;

import graph.Graph;
import graph.Node;

public class BusStrategy implements Strategy {

    @Override
    public int calculateDistance(Node source, Node destination, Graph graph, int trainPrice) {
        return 0;
    }
}