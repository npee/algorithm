package baekjoon.n03052;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num[] = new int[10];
        int kind_of_mod = 0;
        for (int i = 0; i < 10; i++) {
            num[i] = s.nextInt();
            if (num[i] > 1000 || num[i] < 0) {
                s.close();
                return;
            }
        }

        int mod42[] = new int[42];
        for (int i = 0; i < 42; i++) {
            mod42[i] = 0;
        }

        for (int i = 0; i < 10; i++) {
            mod42[num[i] % 42]++;
        }

        for (int i = 0; i < 42; i++) {
            if (mod42[i] != 0) {
                kind_of_mod++;
            }
        }
        System.out.println(kind_of_mod);

        s.close();
    }
}