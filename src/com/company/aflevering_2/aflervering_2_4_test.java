package com.company.aflevering_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aflervering_2_4_test {

    public static void Main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Antal borgere
        int n = Integer.parseInt(in.readLine());

        // Antal dage, undtagen startdagen 0
        int m = Integer.parseInt(in.readLine());



        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            boolean hasAssignedBase = false;
            Integer.parseInt(st.nextToken());
        }
    }

}
