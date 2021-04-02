package com.company.aflevering_2;

import java.awt.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Aflevering_2_5 {
    public static  ArrayList<Node> nodes = new ArrayList<Node>();
    private static Queue<Node> queue = new LinkedList<Node>();

    static class Node {
        int workers;
        List<Node> neighbours;

        public Node(int medarbejdere) {
            this.workers = workers;
            this.neighbours = new ArrayList<Node>();
        }

        public void addNeighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeigbours(){
            return neighbours;
        }
        public int getMedarbejdere() {
            return workers;
        }

    }

    public static  void Test(Node node){
        queue.add(node);
        for (Node queue : queue) {
            System.out.println(queue);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //antal medarbejdere
        int n = Integer.parseInt(in.readLine());

        //antal fjendepar
        int m = Integer.parseInt(in.readLine());

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

        Test(queue.element());
    }
}
