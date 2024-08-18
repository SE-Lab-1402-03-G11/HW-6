package strategy;

import graph.Graph;
import graph.Node;

public interface Strategy {
    int calculateDistance(Node source, Node destination, Graph graph, int trainPrice);

    boolean existPath(Node source, Node destination, Node hatedCity, Graph graph);
}