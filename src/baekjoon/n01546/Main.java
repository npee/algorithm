package baekjoon.n01546;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int score[] = new int[1000];

        int max = 1;
        double total = 0;

        for (int i = 0; i < N; i++) {
            score[i] = s.nextInt();
            if (max < score[i]) {
                max = score[i];
            }
        }

        for (int i = 0; i < N; i++) {
            total += (double) score[i] / max * 100;
        }

        System.out.println(total / N);
        s.close();
    }
}