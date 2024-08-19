package NotificationSystem;

import graph.Graph;
import graph.Node;
import state.State;
import lombok.Getter;
import lombok.Setter;
import state.UnidirectionalState;
import strategy.BusStrategy;
import strategy.Strategy;
import strategy.StrategyApproach;
import strategy.TrainStrategy;

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

    public void toggleDirection() {
        state.toggleDirection(graph);
        state = state.nextState();
    }

    public Integer calculateDistance(Node source, Node destination){
        return strategy.calculateDistance(source, destination, graph, trainSpeed);
    }

    public boolean existPath(Node source, Node destination, Node hatedCity) {
        return strategy.existPath(source, destination, hatedCity, graph);
    }

    public StrategyApproach getFasterTransport(Node source, Node destination) {
        this.setStrategy(new TrainStrategy());
        Integer trainDistance =  this.calculateDistance(source, destination);
        this.setStrategy(new BusStrategy());
        Integer busDistance = this.calculateDistance(source, destination);
        if (trainDistance > busDistance) { return StrategyApproach.BUS;}
        else { return StrategyApproach.TRAIN;}
    }
}