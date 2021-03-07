package com.company.uge_seddel_4;

import java.util.ArrayList;

public class Question_5_1 {

    public static void main(String[] args) {

        Stack stack = new Stack(new Node(1, null));

    }

    public static class Node {
        int key;
        Node next;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public static class Stack {
        Node top;

        public Stack(Node top) {
            this.top = top;
        }
    }

    public static void push (Stack S, Node x) {
        x.next = S.top;
        S.top = x;
    }
}

