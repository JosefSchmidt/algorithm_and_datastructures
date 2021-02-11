package com.company.uge_seddel_2;

public class Question_4_1 {
    public static void Merge(int[] A, int p, int q, int r) {
        int n_1 = q - p + 1;
        int n_2 = r - q;
        int[] L = new int[n_1 + 1];
        int[] R = new int[n_2 + 1];
        for (int i = 1; i < n_1; i++) {
            L[i] = A[p + i - 1];
        }
        for (int j = 1; j < n_2; j++) {
            R[j] = A[q + j];
        }
        L[n_1 + 1] = Integer.MAX_VALUE;
        R[n_2 + 1] = Integer.MAX_VALUE;
        int i = 1;
        int j = 1;
        for (int k = p; k < r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i = i + 1;
            } else {
                j = j + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{21, 32, 11, 8, 16, 21};
        Merge(unsorted, 0, unsorted.length/2, unsorted.length-1);
        System.out.println(unsorted);
    }
}
