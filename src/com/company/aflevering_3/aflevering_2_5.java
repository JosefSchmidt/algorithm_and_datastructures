package com.company.aflevering_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class aflevering_2_5 {

    public static LinkedList<Node> nodesArray = new LinkedList<Node>();
    public static Queue<Node> queue = new LinkedList<Node>();
    public static int maxCosts;


    public static class Connection {
        Node node;
        int distance;

        public Connection(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public Node getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }
    }


    public static class Node {
        public boolean visited;
        int value;
        LinkedList<Connection> connections;

        public Node(int value) {
            this.value = value;
            this.connections = new LinkedList<Connection>();
        }

        public LinkedList<Connection> getConnections() {
            return connections;
        }

        public void createConnection(Node node, int weight) {
            connections.add(new Connection(node, weight));
        }
    }

    public static void isItProfitable(Node node) {

        queue.add(node);
        node.visited = true;

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            LinkedList<Connection> neighbours = element.getConnections();

            // Get the lowest weight connection

        }
    }

    public Node 

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        // Create Node objects
        for (int i = 0; i <n; i++) nodesArray.add(new Node(i));

        int m = Integer.parseInt(in.readLine());

        // Calculate the total price is must cost
        maxCosts = Integer.parseInt(in.readLine()) * m;

        for (int i = 0; i <m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int firstValue = Integer.parseInt(st.nextToken());
            int secondValue = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node firstNode = nodesArray.get(firstValue);
            Node secondNode = nodesArray.get(secondValue);

            firstNode.createConnection(secondNode, weight);
            secondNode.createConnection(firstNode, weight);
        }

        isItProfitable(nodesArray.get(0));

    }
}
