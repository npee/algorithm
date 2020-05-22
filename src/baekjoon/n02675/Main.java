package baekjoon.n02675;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String alphanumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ$%*+-./:";
        Scanner s = new Scanner(System.in);
        int test_total = Integer.parseInt(s.nextLine());
        int[] repeat = new int[test_total];
        char[][] test_case = new char[test_total][];
        for (int i = 0; i < test_total; i++) {
            repeat[i] = Integer.parseInt(s.next());
            test_case[i] = s.next().toCharArray();
        }
        for (int i = 0; i < test_total; i++) {
            for (int j = 0; j < test_case[i].length; j++) {
                if (!alphanumeric.contains("" + test_case[i][j])) {
                    s.close();
                    return;
                }
                for (int k = 0; k < repeat[i]; k++) {
                    System.out.print(test_case[i][j]);
                }
            }
            System.out.println();
        }
        s.close();
    }
}
