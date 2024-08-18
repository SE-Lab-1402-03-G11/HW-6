package NotificationSystem;
import graph.Graph;
import graph.Node;
import graph.Edge;
import org.junit.jupiter.api.Test;
import state.BidirectionalState;
import state.State;
import state.UnidirectionalState;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    @Test
    public void testToggleToUnidirectional() {
        Node cityA = new Node();
        Node cityB = new Node();

        Edge.createEdge(cityA, cityB, false, 1);

        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB)));
        NotificationSystem context = new NotificationSystem(graph, new UnidirectionalState());
        context.toggleDirection(graph);
        assertTrue(cityA.getEdges().get(0).isDirected());
    }

    @Test
    public void testToggleToBidirectional() {
        Node cityA = new Node();
        Node cityB = new Node();
        Edge.createEdge(cityA, cityB, true, 1);  // Initially unidirectional
        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB)));
        NotificationSystem context = new NotificationSystem(graph, new BidirectionalState());
        context.toggleDirection(graph);
        assertFalse(cityA.getEdges().get(0).isDirected());
    }
}