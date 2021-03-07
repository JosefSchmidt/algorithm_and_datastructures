package com.company.afleveringer;

import java.util.Scanner;

public class Aflevering_1 {





    public static void getHighSlet(int[] array) {
        int index = -1;
        int size = 0;

        int count = 0;



        // Loop over elements in array
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] <= array[i] && array[i] >= array[i + 1]) {
                count++;
                if(count > 1 && count > size) {
                    index = i - count;
                    size = count;
                }
            } else {
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
            array[i] = in.nextInt();
        }

        getHighSlet(array);

    }
}



