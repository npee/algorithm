package beakjoon.n02446;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int line = s.nextInt();
        if (line < 1 || line > 100) {
            s.close();
            return;
        }
        int i, j = 0, k, l = 0;
        for (i = line, k = 0; i > 0; i--, k++) {
            for (l = 0; l < k; l++) {
                System.out.print(" ");
            }
            for (j = i * 2 - 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (i = 1, k = line; i < line; i++, k--) {
            for (l = k-2; l > 0; l--) {
                System.out.print(" ");
            }
            for (j = i * 2 + 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        s.close();
    }
}