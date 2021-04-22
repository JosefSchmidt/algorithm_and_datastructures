package com.company.aflevering_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class aflevering_2_5 {

    public static int earningPerConnection;

    public static class Connection {
        Node firstNode;
        Node secondNode;
        int distance;
        boolean visited = false;

        public Connection(Node firstNode, Node secondNode, int distance) {
            this.firstNode = firstNode;
            this.secondNode = secondNode;
            this.distance = distance;
        }
    }

    public static class Node {
        int key;
        Node parent;
        LinkedList<Connection> connections;

        public Node() {
            this.connections = new LinkedList<>();
        }

        public void createConnection(Connection connection) {
            connections.add(connection);
        }
    }

    public static void isItProfitable(LinkedList<Node> graph, Node startNode) {
        PriorityQueue<Node> nodesArray = new PriorityQueue<Node>((node1, node2) -> {
            return node1.key - node2.key;
        });

        // Add to holder array
        for (Node node : graph) {
            node.key = 999999;
            node.parent = null;
            nodesArray.add(node);
        }

        // Set the first element to point to itself
        startNode.key = 0;
        startNode.parent = startNode;

        while (nodesArray.size() != 0) {
            Node extractedNode = nodesArray.poll();
            for (int i = 0; i < extractedNode.connections.size(); i++) {
                if (nodesArray.contains(extractedNode.connections.get(i).firstNode) && extractedNode.connections.get(i).distance < extractedNode.connections.get(i).firstNode.key) {
                    nodesArray.remove(extractedNode.connections.get(i).firstNode);
                    extractedNode.connections.get(i).firstNode.key = extractedNode.connections.get(i).distance;
                    extractedNode.connections.get(i).firstNode.parent = extractedNode;
                    nodesArray.add(extractedNode.connections.get(i).firstNode);
                    extractedNode.connections.get(i).visited = true;

                } else if (nodesArray.contains(extractedNode.connections.get(i).secondNode) && extractedNode.connections.get(i).distance < extractedNode.connections.get(i).secondNode.key) {
                    nodesArray.remove(extractedNode.connections.get(i).secondNode);
                    extractedNode.connections.get(i).secondNode.key = extractedNode.connections.get(i).distance;
                    extractedNode.connections.get(i).secondNode.parent = extractedNode;
                    nodesArray.add(extractedNode.connections.get(i).secondNode);
                    extractedNode.connections.get(i).visited = true;
                }
            }
        }

        int ourEarnings = 0;

        // Remove connections that has been used
        for (int i = 0; i <graph.size(); i++) {
            for (int j = 0; j <graph.get(i).connections.size(); j++) {
                if(!graph.get(i).connections.get(j).visited && graph.get(i).connections.get(j).distance < earningPerConnection) {
                    ourEarnings = ourEarnings + (earningPerConnection - graph.get(i).connections.get(j).distance);
                }
            }
        }


        int totalCosts = 0;
        ourEarnings = ourEarnings + (earningPerConnection * (graph.size() - 1));

        for (Node node : graph) {
            totalCosts = totalCosts + node.key;
        }

        if (totalCosts < ourEarnings) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    public static void main(String[] args) throws IOException {

        LinkedList<Node> nodesArray = new LinkedList<Node>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        // Create Node objects
        for (int i = 0; i < n; i++) nodesArray.add(new Node());

        int m = Integer.parseInt(in.readLine());

        // Calculate the total price is must cost
        earningPerConnection = Integer.parseInt(in.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int firstValue = Integer.parseInt(st.nextToken());
            int secondValue = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node firstNode = nodesArray.get(firstValue);
            Node secondNode = nodesArray.get(secondValue);

            Connection connection = new Connection(firstNode, secondNode, weight);
            firstNode.createConnection(connection);
            secondNode.createConnection(connection);

        }


        // The steps are:
        // Create a prim structure
        // Loop the prim structure through and count the total
        // Compare the total to the expected and return "YES" or "NO"
        isItProfitable(nodesArray, nodesArray.get(0));


    }
}
