package strategy;

import graph.Graph;
import graph.Node;

public class TrainStrategy implements Strategy {

    @Override
    public int calculateDistance(Node source, Node destination, Graph graph, int trainPrice) {
        graph.bfs(source, null);
        return destination.getDistance() * trainPrice;
    }

    @Override
    public boolean existPath(Node source, Node destination, Node hatedCity, Graph graph) {
        graph.bfs(source, hatedCity);
        return destination.getDistance() < Integer.MAX_VALUE;
    }
}
