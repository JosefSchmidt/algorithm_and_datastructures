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

        public void setNode(Node node) {
            this.node = node;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }


    public static class Node {
        int value;
        Connection key = null;
        Node parent;
        LinkedList<Connection> connections;

        public Node(int value) {
            this.value = value;
            this.connections = new LinkedList<Connection>();
        }

        public LinkedList<Connection> getConnections() {
            return connections;
        }

        public void setKey(Connection key) {
            this.key = key;
        }

        public void createConnection(Node node, int weight) {
            connections.add(new Connection(node, weight));
        }
    }

    public static void isItProfitable() {

        // Add all element to queue
        queue.addAll(nodesArray);

        Node node = nodesArray.get(0);
        node.setKey(new Connection(node, 0));

        while (!queue.isEmpty()) {
            Node element = queue.remove();
            LinkedList<Connection> neighbours = element.getConnections();

            // Get the lowest weight connection
            Node currentNode = getLowestKey();
            for (int i = 0; i < neighbours.size(); i++) {
                if (neighbours.get(i).distance > currentNode.key.distance) {
                    neighbours.get(i).node.key = currentNode.key;
                    neighbours.get(i).node.parent = currentNode;
                }
            }

        }
    }

    public static Node getLowestKey() {
        Node lowestNode = nodesArray.get(0);

        for (int i = 0; i < nodesArray.size(); i++) {
            if (lowestNode.key.distance > nodesArray.get(i).key.distance) {
                lowestNode = nodesArray.get(i);
            }
        }

        return lowestNode;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        // Create Node objects
        for (int i = 0; i < n; i++) nodesArray.add(new Node(i));

        int m = Integer.parseInt(in.readLine());

        // Calculate the total price is must cost
        maxCosts = Integer.parseInt(in.readLine()) * m;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int firstValue = Integer.parseInt(st.nextToken());
            int secondValue = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node firstNode = nodesArray.get(firstValue);
            Node secondNode = nodesArray.get(secondValue);

            firstNode.createConnection(secondNode, weight);
            secondNode.createConnection(firstNode, weight);
        }

        isItProfitable();


    }
}
