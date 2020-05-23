package baekjoon.n08393;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        int sum = 0;
        for (int i = input; i > 0; i--) {
            sum += i;
        }
        System.out.println(sum);
    }
}
