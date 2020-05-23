package baekjoon.n10039;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] score = new int[5];
        int total = 0;

        for (int i = 0; i < 5; i++) {
            score[i] = s.nextInt();
            if (score[i] < 0 || score[i] > 100 || score[i] % 5 != 0) {
                s.close();
                return;
            }
            if (score[i] < 40) {
                score[i] = 40;
            }
            total += score[i];
        }

        System.out.println(total / 5);

        s.close();
    }
}