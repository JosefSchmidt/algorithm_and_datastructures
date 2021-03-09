package com.company.aflevering_1;

import java.util.*;

public class Aflevering_1_6 {

    public static void checkDataStructure(AbstractDataType dataType, List<String> array) {

        for (String s : array) {

            if (s.charAt(0) == 'I') {
                dataType.insert(s.charAt(2));
            } else if (s.charAt(0) == 'E' && dataType.extract() != (int) s.charAt(2)) {
                System.out.println("NO");
                return;
            }
        }

        // Print the result
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
        this.priorityQueue.add(value);
    }

    @Override
    int getSize() {
        return this.priorityQueue.size();
    }
}

