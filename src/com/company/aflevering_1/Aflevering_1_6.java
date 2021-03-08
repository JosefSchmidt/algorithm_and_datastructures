package com.company.aflevering_1;

import java.util.*;

public class Aflevering_1_6 {

    public static String STACK = "STACK";
    public static String QUEUE = "QUEUE";
    public static String FIRST_IN_QUEUE = "FIRST_IN_QUEUE";


    public static void checkDataStructure(String type, String[] array) {

        // Check if it could be one of the 3 data structures
        if (type.equals(STACK)) {
            Stack<Integer> stack = new Stack<>();
            String isStackValid = "NO";

            for (String s : array) {
                if (s.charAt(0) == 'I') {
                    stack.push((int) s.charAt(2));
                }
                if (s.charAt(0) == 'E') {
                    int returnedValue = stack.pop();
                    if (returnedValue == (int) s.charAt(2)) {
                        isStackValid = "YES";
                    } else {
                        isStackValid = "NO";
                    }
                }
            }
            // Print the result
            System.out.println(isStackValid);

        }

        if (type.equals(QUEUE)) {
            Queue<Integer> queue = new LinkedList<>();
            String isQueueValid = "NO";

            for (String s : array) {
                if (s.charAt(0) == 'I') {
                    queue.add((int) s.charAt(2));
                }
                if (s.charAt(0) == 'E') {

                    int returnedValue = queue.poll();
                    int value = s.charAt(2);
                    if (returnedValue == value) {
                        isQueueValid = "YES";
                    } else {
                        isQueueValid = "NO";
                    }
                }
            }
            System.out.println(isQueueValid);
        }

        if (type.equals(FIRST_IN_QUEUE)) {
            List<Integer> queueLast = new ArrayList<>();
            String isQueueLastValid = "NO";

            for (String s : array) {
                if (s.charAt(0) == 'I') {
                    queueLast.add((int) s.charAt(2));
                }
                if (s.charAt(0) == 'E') {

                    int smallestValue = Collections.min(queueLast);

                    for (int i = queueLast.size() - 1; i >= 0; i--) {
                        if (queueLast.get(i) == smallestValue) {
                            queueLast.remove(i);
                            break;
                        }
                    }

                    int value = s.charAt(2);
                    if (smallestValue == value) {
                        isQueueLastValid = "YES";
                    } else {
                        isQueueLastValid = "NO";
                    }
                }
            }
            System.out.println(isQueueLastValid);
        }
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

        checkDataStructure(QUEUE, array);
        checkDataStructure(STACK, array);
        checkDataStructure(FIRST_IN_QUEUE, array);


    }

}
