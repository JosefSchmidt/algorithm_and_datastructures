package com.company.uge_seddel_1;

public class Question_8_2 {

    public static int recursive_first_high_point(int[] arr, int i, int j) {
        int m = (i + j) / 2;
        if (arr[m] >= arr[m - 1] && arr[m] >= arr[m - 1]) return arr[m];
        else if (arr[m - 1] > arr[m]) return recursive_first_high_point(arr, i, m - 1);
        else if (arr[m] < arr[m + 1]) return recursive_first_high_point(arr, m + 1, j);
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{2, 4, 5, 6, 5, 8, 9, 2};
        // int topPoint = algo_one_get_first_high_point(numbers);
        int topPoint = recursive_first_high_point(numbers, 0, numbers.length);
        System.out.println(topPoint);
    }
}
