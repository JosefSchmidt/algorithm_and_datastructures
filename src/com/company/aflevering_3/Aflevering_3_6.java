package com.company.aflevering_3;


import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Aflevering_3_6 {

    public static LinkedList<Node> nodes = new LinkedList<Node>();

    public static class Node{
        LinkedList<Node> notDirect;
        int x;
        int y;

        public Node(LinkedList<Node> notDirect, int x, int y) {
            this.notDirect = notDirect;
            this.x = x;
            this.y = y;
        }


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
        }

        //groupSortAlgorithm(nodes);
    }
}
