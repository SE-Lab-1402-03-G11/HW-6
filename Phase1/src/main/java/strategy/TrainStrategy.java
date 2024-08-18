package strategy;

import graph.Graph;
import graph.Node;

public class TrainStrategy implements Strategy {

    @Override
    public int calculateDistance(Node source, Node destination, Graph graph, int trainPrice) {
        graph.bfs(source);
        return destination.getDistance() * trainPrice;
    }
}
