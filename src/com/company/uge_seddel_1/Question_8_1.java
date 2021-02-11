package com.company.uge_seddel_1;

class Question_8_1 {

    // Returns the first high point
    public static int algo_one_get_first_high_point(int[] numbers) {
        if (numbers[0] > numbers[1]) return numbers[0];
        for (int i = 1; i < numbers.length - 2; i++) {
            if (numbers[i - 1] <= numbers[i] && numbers[i] <= numbers[i + 1]) return numbers[i];
        }
        if (numbers[numbers.length - 2] <= numbers[numbers.length - 1]) return numbers[numbers.length - 1];
        return -1;
    }

    // Returns the last high point
    public static int algo_two_get_first_high_point(int[] numbers) {
        int max = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[max]) max = i;
        }
        return numbers[max];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 4, 5, 6, 7, 8, 9, 2};
        // int topPoint = algo_one_get_first_high_point(numbers);
        int topPoint = algo_two_get_first_high_point(numbers);
        System.out.println(topPoint);
    }
}
