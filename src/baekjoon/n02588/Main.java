package baekjoon.n02588;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int b100, b10, b1;
        b100 = b / 100;
        b10 = (b % 100) / 10;
        b1 = (b % 100) % 10;

        System.out.println(b1 * a);
        System.out.println(b10 * a);
        System.out.println(b100 * a);
        System.out.println(a * b);

        s.close();
    }
}