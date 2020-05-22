package baekjoon.n02439;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                if (j <= count - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}