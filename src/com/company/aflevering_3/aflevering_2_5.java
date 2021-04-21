package com.company.aflevering_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class aflevering_2_5 {

    public static int maxCosts;

    public static class Connection {
        Node node;
        int distance;

        public Connection(Node node, int distance) {
            this.node = node;
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

        public void createConnection(Node node, int weight) {
            connections.add(new Connection(node, weight));
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
                if (nodesArray.contains(extractedNode.connections.get(i).node) && extractedNode.connections.get(i).distance < extractedNode.connections.get(i).node.key) {
                    nodesArray.remove(extractedNode.connections.get(i).node);
                    extractedNode.connections.get(i).node.key = extractedNode.connections.get(i).distance;
                    extractedNode.connections.get(i).node.parent = extractedNode;
                    nodesArray.add(extractedNode.connections.get(i).node);
                }
            }
        }



        int costs = 0;
        for (Node node : graph) {
            costs = costs + node.key;
        }

        if(costs >= maxCosts) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
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
        maxCosts = Integer.parseInt(in.readLine()) * (n-1);

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


        // The steps are:
        // Create a prim structure
        // Loop the prim structure through and count the total
        // Compare the total to the expected and return "YES" or "NO"
        isItProfitable(nodesArray, nodesArray.get(0));


    }
}
