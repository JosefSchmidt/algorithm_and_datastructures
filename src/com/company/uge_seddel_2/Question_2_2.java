package com.company.uge_seddel_2;

public class Question_2_2 {

    /*Function to sort array using insertion sort*/
    public static void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{31, 41, 59, 26, 41, 58};

        sort(numbers);

        for (int i = 0; i <numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }


    public static int find_duplicate() {
        int[] numbersArr = new int[]{1, 2, 3, 2, 5, 6};

        // O(n) -> lineær
        for (int i = 0; i <numbersArr.length-1; i++) {
            int currentValue = numbersArr[i];

            // O(n^2)
            for (int j = i+1; j <numbersArr.length; j++) {
                if(currentValue == numbersArr[j]) return currentValue;
            }
        }
        return -1;
    }
}
