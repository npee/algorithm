package baekjoon.n02444;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String astr = "*";
        String space = "";
        for (int i = 0; i < N - 1; i++) {
            space = space.concat(" ");
        }

        for (int i = 0; i < N * 2 - 1; i++) {
            if (i == 0) {
                System.out.println(space + astr);
                continue;
            }
            if (i >= N) {
                astr = astr.replaceFirst("\\*\\*", "");
                space = space.concat(" ");
            } else {
                astr = astr.concat("**");
                space = space.replaceFirst(" ", "");
            }
            System.out.println(space + astr);
            s.close();
        }
    }
}