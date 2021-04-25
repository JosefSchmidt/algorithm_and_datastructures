package com.company.aflevering_3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Aflevering_3_6 {


    public static class Node {
        int number;
        int x;
        int y;
        int distanceFromOrigin;
        LinkedList<Node> neighbours;

        public Node(int number) {
            this.number = number;
            neighbours = new LinkedList<>();
            distanceFromOrigin = Integer.MAX_VALUE;
        }

        public void addNeighbor(Node node) {
            neighbours.add(node);
        }
    }


    public static void main(String[] args) throws IOException {

        LinkedList<Node> nodesArray = new LinkedList<>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Total number of dropLocations
        int n = Integer.parseInt(in.readLine());

        // Create dropLocations
        for (int i = 0; i < n; i++) nodesArray.add(new Node(i));

        // Number of removable locations
        int m = Integer.parseInt(in.readLine());

        // Add connections between all the nodes
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Node node = nodesArray.get(i);
            node.x = x;
            node.y = y;


            node.neighbours.addAll(nodesArray);
            node.neighbours.remove(node);

        }

        // Remove the connections between the nodes
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int nodeNumber1 = Integer.parseInt(st.nextToken());
            int nodeNumber2 = Integer.parseInt(st.nextToken());


            Node node1 = nodesArray.get(nodeNumber1);
            Node node2 = nodesArray.get(nodeNumber2);
            node1.neighbours.remove(node2);
            node2.neighbours.remove(node1);

        }

        showShortestRoute(nodesArray, nodesArray.get(0));

    }

    public static void showShortestRoute(LinkedList<Node> graph, Node startNode) {
        PriorityQueue<Node> nodesArray = new PriorityQueue<Node>((node1, node2) -> {
            return node1.distanceFromOrigin - node2.distanceFromOrigin;
        });

        nodesArray.addAll(graph);
        startNode.distanceFromOrigin = 0;


        while (nodesArray.size() != 0) {
            Node extractedNode = nodesArray.poll();

            for (int i = 0; i <extractedNode.neighbours.size(); i++) {
                if(
                    nodesArray.contains(extractedNode.neighbours.get(i)) &&
                    calculatePyth(extractedNode, extractedNode.neighbours.get(i)) + extractedNode.distanceFromOrigin < extractedNode.neighbours.get(i).distanceFromOrigin) {
                    nodesArray.remove(extractedNode.neighbours.get(i));
                    extractedNode.neighbours.get(i).distanceFromOrigin = calculatePyth(extractedNode, extractedNode.neighbours.get(i)) + extractedNode.distanceFromOrigin;
                    nodesArray.add(extractedNode.neighbours.get(i));
                }
            }
        }


        for (int i = 0; i <graph.size(); i++) {
            System.out.println(graph.get(i).distanceFromOrigin);
        }


    }

    public static int calculatePyth(Node node1, Node node2) {
        double x1 = node1.x;
        double y1 = node1.y;

        double x2 = node2.x;
        double y2 = node2.y;

        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);

        return (int) Math.floor(Math.hypot(ac, cb));
    }
}
