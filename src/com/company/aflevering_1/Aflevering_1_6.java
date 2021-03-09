package com.company.aflevering_1;

import java.util.*;

public class Aflevering_1_6 {

    public static void checkDataStructure(AbstractDataType dataType, List<String> array) {

        for (String s : array) {

            String operator = s.substring(0, 1);
            int length = s.length();
            int value = Integer.parseInt(s.substring(2, length));

            if (operator.equals("I")) {
                dataType.insert(value);
            }

            if (operator.equals("E") && dataType.extract() != value) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        ArrayList<String> array = new ArrayList<>();
        in.nextLine();

        if (n <= 1) {
            System.out.println("YES");
            System.out.println("YES");
            System.out.println("YES");
            return;
        }


        for (int i = 0; i < n; i++) {
            String input = in.nextLine();
            array.add(input);
        }

        checkDataStructure(new MyQueue(), array);
        checkDataStructure(new MyStack(), array);
        checkDataStructure(new MyPriorityQueue(), array);
    }
}


abstract class AbstractDataType {
    abstract int extract();

    abstract void insert(int value);

    abstract int getSize();
}

class MyQueue extends AbstractDataType {
    public Queue<Integer> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    @Override
    public int extract() {
        if (queue.size() > 0) {
            return this.queue.poll();
        } else {
            return -1;
        }
    }

    @Override
    public void insert(int value) {
        if (value < 0 || value > 2000) return;
        this.queue.add(value);
    }

    @Override
    int getSize() {
        return this.queue.size();
    }
}

class MyStack extends AbstractDataType {
    public Stack<Integer> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    @Override
    public int extract() {
        if (stack.size() > 0) {
            return this.stack.pop();
        } else {
            return -1;
        }
    }

    @Override
    public void insert(int value) {
        if (value < 0 || value > 2000) return;
        this.stack.add(value);
    }

    @Override
    int getSize() {
        return this.stack.size();
    }
}


class MyPriorityQueue extends AbstractDataType {

    public PriorityQueue<Integer> priorityQueue;

    public MyPriorityQueue() {
        this.priorityQueue = new PriorityQueue<>();
    }

    @Override
    public int extract() {
        if (priorityQueue.size() > 0) {
            return priorityQueue.poll();
        } else {
            return -1;
        }
    }

    @Override
    public void insert(int value) {
        if (value < 0 || value > 2000) return;
        this.priorityQueue.add(value);
    }

    @Override
    int getSize() {
        return this.priorityQueue.size();
    }
}

