package NotificationSystem;

import graph.Edge;
import graph.Graph;
import graph.Node;
import state.BidirectionalState;
import strategy.BusStrategy;
import strategy.StrategyApproach;
import strategy.TrainStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Node> cities = new HashMap<>();
        cities.put("A", new Node());
        cities.put("B", new Node());
        cities.put("C", new Node());
        cities.put("D", new Node());

        Edge.createEdge(cities.get("A"), cities.get("B"), false, 1);
        Edge.createEdge(cities.get("B"), cities.get("C"), false, 2);
        Edge.createEdge(cities.get("C"), cities.get("D"), false, 1);
        Edge.createEdge(cities.get("A"), cities.get("D"), false, 4);

        Graph graph = new Graph(new ArrayList<>(cities.values()));
        NotificationSystem api = new NotificationSystem(graph, new BidirectionalState());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a command (toggle, trainDistance, changeTrainSpeed, busDistance, faster, avoidCity, exit):");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "toggle":
                    api.toggleDirection();
                    System.out.println("Route directions toggled.");
                    break;

                case "changetrainspeed":
                    System.out.println("Enter new speed for train: ");
                    int trainSpeed = scanner.nextInt();
                    api.setTrainSpeed(trainSpeed);
                    System.out.println("Train speed changed to " + trainSpeed + ".");
                    break;

                case "traindistance":
                    System.out.println("Enter source city (" + String.join(", ", cities.keySet()) + "): ");
                    Node trainSource = getNode(scanner.nextLine(), cities);
                    System.out.println("Enter destination city (" + String.join(", ", cities.keySet()) + "): ");
                    Node trainDestination = getNode(scanner.nextLine(), cities);
                    api.setStrategy(new TrainStrategy());
                    int trainDistance = api.calculateDistance(trainSource, trainDestination);
                    if(trainDistance == Integer.MAX_VALUE) {
                        System.out.println("No route found.");
                    }
                    else {
                        System.out.println("Train distance: " + trainDistance);
                    }
                    break;

                case "busdistance":
                    System.out.println("Enter source city (" + String.join(", ", cities.keySet()) + "): ");
                    Node busSource = getNode(scanner.nextLine(), cities);
                    System.out.println("Enter destination city (" + String.join(", ", cities.keySet()) + "): ");
                    Node busDestination = getNode(scanner.nextLine(), cities);
                    api.setStrategy(new BusStrategy());
                    int busDistance = api.calculateDistance(busSource, busDestination);
                    if(busDistance == Integer.MAX_VALUE) {
                        System.out.println("No route found.");
                    }
                    else {
                        System.out.println("Bus distance: " + busDistance);
                    }
                    break;

                case "faster":
                    System.out.println("Enter source city (" + String.join(", ", cities.keySet()) + "): ");
                    Node fasterSource = getNode(scanner.nextLine(), cities);
                    System.out.println("Enter destination city (" + String.join(", ", cities.keySet()) + "): ");
                    Node fasterDestination = getNode(scanner.nextLine(), cities);
                    StrategyApproach fasterTransport = api.getFasterTransport(fasterSource, fasterDestination);
                    System.out.println("Faster transport: " + fasterTransport);
                    break;

                case "avoidcity":
                    System.out.println("Enter source city (" + String.join(", ", cities.keySet()) + "): ");
                    Node avoidSource = getNode(scanner.nextLine(), cities);
                    System.out.println("Enter destination city (" + String.join(", ", cities.keySet()) + "): ");
                    Node avoidDestination = getNode(scanner.nextLine(), cities);
                    System.out.println("Enter hated city (" + String.join(", ", cities.keySet()) + "): ");
                    Node hatedCity = getNode(scanner.nextLine(), cities);
                    boolean canTravel = api.existPath(avoidSource, avoidDestination, hatedCity);
                    System.out.println("Can travel without passing hated city: " + canTravel);
                    break;

                case "exit":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    private static Node getNode(String cityName, Map<String, Node> cities) {
        Node city = cities.get(cityName.toUpperCase());
        if (city == null) {
            throw new IllegalArgumentException("Invalid city name: " + cityName);
        }
        return city;
    }
}
