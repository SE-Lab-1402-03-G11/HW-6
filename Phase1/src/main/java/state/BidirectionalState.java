package state;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.util.Iterator;

public class BidirectionalState implements State {
    @Override
    public void toggleDirection(Graph graph) {
        for (Node node : graph.getGraph()) {
            for (Edge edge : node.getEdges()) {
                edge.setDirected(true);
            }
        }
    }

    @Override
    public State nextState() {
        return new UnidirectionalState();
    }
}
