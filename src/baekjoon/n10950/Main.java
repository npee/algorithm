package baekjoon.n10950;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int res[] = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = Integer.valueOf(s.next()) + Integer.valueOf(s.next());
        }
        for (int result: res) {
            System.out.println(result);
        }
        s.close();
    }
}