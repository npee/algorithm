package baekjoon.n02443;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String astr;
        for (int i = N; i > 0; i--) {
            astr = "";
            for (int j = 0; j < 2 * i - 1; j++) {
                astr += "*";
            }
            for (int j = N; j > i ; j--) {
                System.out.print(" ");
            }
            System.out.println(astr);
        }
        s.close();
    }
}