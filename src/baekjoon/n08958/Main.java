package baekjoon.n08958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = 0;
        int score = 0;

        int num = Integer.valueOf(s.nextLine());

        String[] tests = new String[num];
        for (int i = 0; i < num; i++) {
            tests[i] = s.nextLine();
        }

        for (int i = 0; i < num; i++) {
            score = 0;
            total = 0;
            for (int j = 0; j < tests[i].length(); j++) {
                if (tests[i].charAt(j) == 'O') {
                    total += ++score;
                } else if (tests[i].charAt(j) == 'X') {
                    score = 0;
                }
            }
            System.out.println(total);
        }

        s.close();
    }
}