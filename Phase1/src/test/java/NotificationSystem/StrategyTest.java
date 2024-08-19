package NotificationSystem;


import graph.Graph;
import graph.Node;
import graph.Edge;
import org.junit.jupiter.api.Test;
import state.BidirectionalState;
import state.UnidirectionalState;
import strategy.BusStrategy;
import strategy.StrategyApproach;
import strategy.TrainStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    @Test
    public void testTrainStrategy() {
        Node cityA = new Node();
        Node cityB = new Node();

        Edge.createEdge(cityA, cityB, false, 4);

        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB)));
        NotificationSystem context = new NotificationSystem(graph, new UnidirectionalState());
        context.setStrategy(new TrainStrategy());

        int distance = context.calculateDistance(cityA, cityB);
        assertEquals(1, distance);
    }

    @Test
    public void testBusStrategy() {
        Node cityA = new Node();
        Node cityB = new Node();

        Edge.createEdge(cityA, cityB, false, 2);

        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB)));
        NotificationSystem context = new NotificationSystem(graph, new BidirectionalState());
        context.setStrategy(new BusStrategy());

        int distance = context.calculateDistance(cityA, cityB);
        assertEquals(2, distance);
    }

    @Test
    public void testFasterStrategy1() {
        Node cityA = new Node();
        Node cityB = new Node();

        Edge.createEdge(cityA, cityB, false, 2);

        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB)));
        NotificationSystem context = new NotificationSystem(graph, new BidirectionalState());
        context.setStrategy(new BusStrategy());

        StrategyApproach faster = context.getFasterTransport(cityA, cityB);
        assertEquals(faster, StrategyApproach.TRAIN);
    }

    @Test
    public void testFasterStrategy2() {
        Node cityA = new Node();
        Node cityB = new Node();

        Edge.createEdge(cityA, cityB, false, 2);

        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB)));
        NotificationSystem context = new NotificationSystem(graph, new BidirectionalState());
        context.setTrainSpeed(3);
        context.setStrategy(new BusStrategy());

        StrategyApproach faster = context.getFasterTransport(cityA, cityB);
        assertEquals(faster, StrategyApproach.BUS);
    }

    @Test
    public void testHatedCity1() {
        Node cityA = new Node();
        Node cityB = new Node();
        Node cityC = new Node();

        Edge.createEdge(cityA, cityB, false, 4);
        Edge.createEdge(cityB, cityC, false, 4);

        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB, cityC)));
        NotificationSystem context = new NotificationSystem(graph, new UnidirectionalState());
        context.setStrategy(new TrainStrategy());
        boolean existPath = context.existPath(cityA, cityC, cityB);
        assertFalse(existPath);
    }

    @Test
    public void testHatedCity2() {
        Node cityA = new Node();
        Node cityB = new Node();
        Node cityC = new Node();

        Edge.createEdge(cityA, cityB, false, 4);
        Edge.createEdge(cityB, cityC, false, 4);

        Graph graph = new Graph(new ArrayList<>(List.of(cityA, cityB, cityC)));
        NotificationSystem context = new NotificationSystem(graph, new UnidirectionalState());
        context.setStrategy(new TrainStrategy());
        boolean existPath = context.existPath(cityA, cityB, cityC);
        assertTrue(existPath);
    }
}
