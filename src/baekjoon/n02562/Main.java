package baekjoon.n02562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int array[] = new int[9];
        int max = 1;

        for (int i = 0; i < 9; i++) {
            array[i] = s.nextInt();
            if (array[i] > max) {
                max = array[i];
            }
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j] || array[i] <= 0) {
                    s.close();
                    return;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (array[i] == max) {
                System.out.println(max);
                System.out.println(i + 1);
            }
        }
        s.close();
    }
}