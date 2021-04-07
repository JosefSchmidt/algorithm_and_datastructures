package com.company.aflevering_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aflevering_2_4 {

    private static Queue<Node> queue = new LinkedList<Node>();
    public static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {
        int houseNumber;
        boolean visited;
        List<Node> neighbours;
        int dayCount;


        public int getHouseNumber() {
            return houseNumber;
        }

        public Node(int houseNumber) {
            this.houseNumber = houseNumber;
            this.neighbours = new ArrayList<Node>();
        }


        public void addNeighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public int getDayCount() {
            return dayCount;
        }

        public void setDayCount(int dayCount) {
            this.dayCount = dayCount;
        }
    }

    public static void bfs(Node node) {
        queue.add(node);
        node.visited = true;

        int dayCount = 1;

        while (!queue.isEmpty()) {
            Node element = queue.remove();
            List<Node> neighbours = element.getNeighbours();

            int currentDayCount = element.getDayCount();

            boolean shouldContinue = false;

            // Prevent sending letters to nodes that has already received
            for (Node neighbour : neighbours) {
                if (!neighbour.visited) shouldContinue = true;
            }
            if (!shouldContinue) continue;


            if (dayCount != currentDayCount) {
                System.out.println("Day " + dayCount);
                dayCount++;
            }

            for (Node n : neighbours) {
                if (n != null && !n.visited) {

                    n.setDayCount(dayCount + 1);
                    queue.add(n);
                    n.visited = true;
                    System.out.println(n.getHouseNumber());
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Antal borgere
        int n = Integer.parseInt(in.readLine());

        // Antal dage, undtagen startdagen 0
        int m = Integer.parseInt(in.readLine());

        // Create Node objects
        for (int i = 0; i < n; i++) nodes.add(new Node(i));


        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            boolean hasAssignedBase = false;
            Node baseNode = null;
            while (st.hasMoreTokens()) {
                if (!hasAssignedBase) {
                    baseNode = nodes.get(Integer.parseInt(st.nextToken()));
                } else {
                    baseNode.addNeighbours(nodes.get(Integer.parseInt(st.nextToken())));
                }
                hasAssignedBase = true;
            }
        }

        bfs(nodes.get(0));

    }
}

