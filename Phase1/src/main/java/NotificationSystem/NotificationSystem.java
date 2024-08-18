package NotificationSystem;

import graph.Graph;
import graph.Node;
import state.State;
import lombok.Getter;
import lombok.Setter;
import state.UnidirectionalState;
import strategy.Strategy;

@Setter
@Getter
public class NotificationSystem {
    private Graph graph;
    private State state;
    private Strategy strategy;
    private Integer trainSpeed = 1;

    public NotificationSystem(Graph graph, State state) {
        this.graph = graph;
        this.setState(state);
    }

    public void toggleDirection(Graph graph) {
        state.toggleDirection(graph);
        state = state.nextState();
    }

    public Integer calculateDistance(Node source, Node destination){
        return strategy.calculateDistance(source, destination, graph, trainSpeed);
    }

    public boolean existPath(Node source, Node destination, Node hatedCity) {
        return true;
    }
}