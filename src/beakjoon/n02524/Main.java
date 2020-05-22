package beakjoon.n02524;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int line = s.nextInt();
        if (line < 1 || line > 100) {
            s.close();
            return;
        }
        int i, j = 0;
        for (i = 1; i <= line; i++) {
            for (j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (i -= 2; i > 0; i--) {
            for (j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        s.close();
    }
}