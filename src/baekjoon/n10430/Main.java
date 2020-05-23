package baekjoon.n10430;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = Integer.valueOf(s.next());
        int b = Integer.valueOf(s.next());
        int c = Integer.valueOf(s.next());

        System.out.println((a + b) % c);
        System.out.println(((a % c) + (b % c)) % c);
        System.out.println((a * b) % c);
        System.out.println(((a % c) * (b % c)) % c);
    }
}
