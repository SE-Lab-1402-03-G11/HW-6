package NotificationSystem;

import graph.Graph;
import graph.Node;
import state.State;
import lombok.Getter;
import lombok.Setter;
import state.UnidirectionalState;

@Getter
@Setter
public class NotificationSystem {
    private Graph graph;
    private int trainSpeed = 1;
    private State state;

    public NotificationSystem(Graph graph, State unidirectionalState) {
        this.graph = graph;
        this.state = unidirectionalState;
    }

    public void toggleDirection(Graph graph) {
    }

    public void setState(State unidirectionalState) {
    }
}