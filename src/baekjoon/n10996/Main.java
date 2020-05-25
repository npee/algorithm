package baekjoon.n10996;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int line = s.nextInt();
        if (line < 1 || line > 100) {
            s.close();
            return;
        }
        String astr = " *";
        String _1st = "*";
        String _2nd = "";
        if (line == 1) {
            System.out.println(_1st);
        } else {
            int i = 0, j, k;
            for (j = i++; j < line - 1; j++) {
                if (j % 2 != 0) {
                    _1st += astr;
                } else {
                    _2nd += astr;
                }
            }
            for (k = 0; k < line; k++) {
                System.out.println(_1st);
                System.out.println(_2nd);
            }
        }

        s.close();
    }
}