package NotificationSystem;

import graph.Edge;
import graph.Graph;
import graph.Node;
import state.BidirectionalState;
import state.UnidirectionalState;
import strategy.BusStrategy;
import strategy.StrategyApproach;
import strategy.TrainStrategy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node cityA = new Node();
        Node cityB = new Node();
        Node cityC = new Node();
        Node cityD = new Node();

        Edge.createEdge(cityA, cityB, false, 1);
        Edge.createEdge(cityB, cityC, false, 2);
        Edge.createEdge(cityC, cityD, false, 1);
        Edge.createEdge(cityA, cityD, false, 4);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(cityA);
        nodes.add(cityB);
        nodes.add(cityC);
        nodes.add(cityD);
        Graph graph = new Graph(nodes);
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
                    Integer trainSpeed = scanner.nextInt();
                    api.setTrainSpeed(trainSpeed);
                    System.out.println("train speed changed to " + trainSpeed);
                    break;

                case "traindistance":
                    System.out.println("Enter source city (A, B, C, D): ");
                    Node trainSource = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    System.out.println("Enter destination city (A, B, C, D): ");
                    Node trainDestination = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    api.setStrategy(new TrainStrategy());
                    int trainDistance = api.calculateDistance(trainSource, trainDestination);
                    System.out.println("Train distance: " + trainDistance);
                    break;

                case "busdistance":
                    System.out.println("Enter source city (A, B, C, D): ");
                    Node busSource = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    System.out.println("Enter destination city (A, B, C, D): ");
                    Node busDestination = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    api.setStrategy(new BusStrategy());
                    int busDistance = api.calculateDistance(busSource, busDestination);
                    System.out.println("Bus distance: " + busDistance);
                    break;

                case "faster":
                    System.out.println("Enter source city (A, B, C, D): ");
                    Node fasterSource = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    System.out.println("Enter destination city (A, B, C, D): ");
                    Node fasterDestination = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    StrategyApproach fasterTransport = api.getFasterTransport(fasterSource, fasterDestination);
                    System.out.println("Faster transport: " + fasterTransport);
                    break;

                case "avoidcity":
                    System.out.println("Enter source city (A, B, C, D): ");
                    Node avoidSource = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    System.out.println("Enter destination city (A, B, C, D): ");
                    Node avoidDestination = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
                    System.out.println("Enter hated city (A, B, C, D): ");
                    Node hatedCity = getNode(scanner.nextLine(), cityA, cityB, cityC, cityD);
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

    private static Node getNode(String cityName, Node cityA, Node cityB, Node cityC, Node cityD) {
        switch (cityName.toUpperCase()) {
            case "A":
                return cityA;
            case "B":
                return cityB;
            case "C":
                return cityC;
            case "D":
                return cityD;
            default:
                throw new IllegalArgumentException("Invalid city name: " + cityName);
        }
    }
}
