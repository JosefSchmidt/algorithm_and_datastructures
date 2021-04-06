package com.company.aflevering_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aflevering_2_5 {

    public static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {
        int houseNumber;
        List<Node> neighbours;


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

    }

    public static void topologicalSort(ArrayList<Node> nodes) {

        ArrayList<Node> groupOne = new ArrayList<Node>();
        ArrayList<Node> groupTwo = new ArrayList<Node>();


        for (int i = 0; i < nodes.size(); i++) {
            Node baseNode = nodes.get(i);

            if (baseNode.getNeighbours().size() == 0 && groupOne.size() == 0) {
                groupOne.add(baseNode);

            } else if (baseNode.getNeighbours().size() == 0) {
                groupTwo.add(baseNode);

            } else {

                ArrayList<Node> neighbours = (ArrayList<Node>) baseNode.neighbours;

                boolean groupOneExist = false;
                boolean groupTwoExist = false;

                for (Node neighbourNode : neighbours) {

                    boolean localGroupOneExist = doesElementExist(groupOne, neighbourNode);
                    boolean localGroupTwoExist = doesElementExist(groupTwo, neighbourNode);

                    if (!groupOneExist && localGroupOneExist) {
                        groupOneExist = localGroupOneExist;
                    }

                    if (!groupTwoExist && localGroupTwoExist) {
                        groupTwoExist = localGroupTwoExist;
                    }


                    if (groupOneExist && groupTwoExist) {
                        System.out.println("NO");
                        return;
                    }
                }

                if (!groupOneExist) {
                    groupOne.add(baseNode);
                } else {
                    groupTwo.add(baseNode);
                }
            }
        }

        String firstLine = "";
        String secondLine = "";

        for (Node node : groupOne) {
            firstLine = firstLine + node.houseNumber + " ";
        }

        System.out.println(firstLine);

        for (Node node : groupTwo) {
            secondLine = secondLine + node.houseNumber + " ";
        }

        System.out.println(secondLine);

    }

    public static boolean doesElementExist(ArrayList<Node> nodes, Node baseNode) {
        for (Node node : nodes) {
            if (baseNode.houseNumber == node.houseNumber) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        // Create Node objects
        for (int i = 0; i < n; i++) nodes.add(new Node(i));

        int m = Integer.parseInt(in.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int firstValue = Integer.parseInt(st.nextToken());
            int secondValue = Integer.parseInt(st.nextToken());

            Node firstNode = nodes.get(firstValue);
            Node secondNode = nodes.get(secondValue);

            firstNode.addNeighbours(secondNode);
            secondNode.addNeighbours(firstNode);
        }

        topologicalSort(nodes);

    }

}
