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
                else if (s.charAt(0) == 'E' && stack.size() > 0) {
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
                else if (s.charAt(0) == 'E' && queue.size() > 0) {

                    int returnedValue = queue.poll();
                    if (returnedValue == (int) s.charAt(2)) {
                        isQueueValid = "YES";
                    } else {
                        isQueueValid = "NO";
                    }
                }
            }
            System.out.println(isQueueValid);
        }

        if (type.equals(FIRST_IN_QUEUE)) {
            List<Integer> queueLast = new LinkedList<>();
            String isQueueLastValid = "NO";

            for (String s : array) {
                if (s.charAt(0) == 'I') {
                    queueLast.add((int) s.charAt(2));
                }
                else if (s.charAt(0) == 'E' && queueLast.size() > 0) {

                    int smallestValue = Collections.min(queueLast);

                    for (int i = 0; i < queueLast.size(); i++) {
                        if (queueLast.get(i) == smallestValue) {
                            queueLast.remove(i);
                            break;
                        }
                    }

                    if (smallestValue == (int) s.charAt(2)) {
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
