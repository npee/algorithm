package baekjoon.n10817;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int a = Integer.valueOf(s.next());
        int b = Integer.valueOf(s.next());
        int c = Integer.valueOf(s.next());
        int temp;

        if (a < c) {
            temp = a;
            a = c;
            c = temp;
            if (a < b) {
                temp = a;
                a = b;
                b = temp;
            }
            if (b < c) {
                temp = b;
                b = c;
                c = temp;
            }
        } else {
            if (a < b) {
                temp = a;
                a = b;
                b = temp;
            }
            if (b < c) {
                temp = b;
                b = c;
                c = temp;
            }
        }

        System.out.println(b);

    }
}