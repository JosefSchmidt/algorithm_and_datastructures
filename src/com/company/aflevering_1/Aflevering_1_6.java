package com.company.aflevering_1;

import java.util.*;

public class Aflevering_1_6 {

    public static void checkDataStructure(AbstractDataType dataType, String[] array) {

        String isValid = "NO";

        for (String s : array) {
            if (s.charAt(0) == 'I') {
                dataType.insert(s.charAt(2));
            }

            if (s.charAt(0) == 'E') {
                if (dataType.extract() == (int) s.charAt(2)) {
                    isValid = "YES";
                } else {
                    isValid = "NO";
                }
            }
        }
        // Print the result
        System.out.println(isValid);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] array = new String[n];
        in.nextLine();

        for (int i = 0; i < array.length; i++) {
            String input = in.nextLine();
            array[i] = input;
        }


        checkDataStructure(new MyQueue(), array);
        checkDataStructure(new MyStack(), array);
        checkDataStructure(new MyPriorityQueue(), array);

    }
}


abstract class AbstractDataType {
    abstract int extract();
    abstract void insert(int value);
}

class MyQueue extends AbstractDataType {
    Queue<Integer> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    @Override
    public int extract() {
        return this.queue.poll();
    }

    @Override
    public void insert(int value) {
        this.queue.add(value);
    }
}

class MyStack extends AbstractDataType {
    Stack<Integer> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    @Override
    public int extract() {
        return this.stack.pop();
    }

    @Override
    public void insert(int value) {
        this.stack.add(value);
    }
}


class MyPriorityQueue extends AbstractDataType {

    PriorityQueue<Integer> priorityQueue;

    public MyPriorityQueue() {
        this.priorityQueue = new PriorityQueue<>();
    }

    @Override
    public int extract() {
        return priorityQueue.poll();
    }

    @Override
    public void insert(int value) {
        this.priorityQueue.add(value);
    }
}

