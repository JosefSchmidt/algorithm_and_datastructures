package com.company.aflevering_1;

import java.util.Scanner;

public class Aflevering_1_5 {

    // [1, 2, 2, 2, 1, 1]

    public static void getHighSlet(int[] array) {
        int index = -1;
        int size = 0;
        int count = 0;


        for (int i = 1; i < array.length; i++) {

            // Start
            if(array[i-1] < array[i]) {
                count = 1;
            }

            // End
            else if (array[i-1] > array[i] && count > size) {
                    size = count;
                    index = i - count;
                    count = 0;
            }

            // Increment
            else if(array[i-1] == array[i] && count > 0) {
                count++;
            }

            else {
                count = 0;
            }
        }

        System.out.println(index);
        System.out.println(size);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            int input =  in.nextInt();
            array[i] = input;
        }

        getHighSlet(array);

    }
}



