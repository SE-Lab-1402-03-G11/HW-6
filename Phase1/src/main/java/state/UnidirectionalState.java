package state;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnidirectionalState implements State {
    @Override
    public void toggleDirection(Graph graph) {
        for (Node node : graph.getGraph()) {
            for (Edge edge : node.getEdges()) {
                edge.setDirected(false);
            }
        }
    }

    @Override
    public State nextState() {
        return new BidirectionalState();
    }
}
