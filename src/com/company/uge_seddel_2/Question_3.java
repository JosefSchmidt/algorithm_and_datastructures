package com.company.uge_seddel_2;

public class Question_3 {


    public static boolean binary_search(int[] A, int i, int j, int x) {
        if(j < i) return false;
        int m = (i + j) / 2;

        if(A[m] == x) return true;
        else if (A[m] < x ) return binary_search(A, m+1, j, x);
        else return binary_search(A, i, m-1, x); //A[x] > x
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 6, 7};

        System.out.println(binary_search(arr, 0, arr.length-1, 111));

    }
}
