package beakjoon.n11720;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = Integer.parseInt(s.nextLine());
        String num = s.nextLine();

        int total = 0;
        for (int i = 0; i < length; i++) {
            total += (int) num.charAt(i) - 48;
        }

        System.out.println(total);
    }
}
