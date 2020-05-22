package beakjoon.n02884;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = Integer.valueOf(s.next());
        int m = Integer.valueOf(s.next());

        if (h == 0) {
            if (m < 45) {
                h = 23;
                m += 15;
            } else {
                m -= 45;
            }
        } else {
            if (m < 45) {
                h -= 1;
                m += 15;
            } else {
                m -= 45;
            }
        }
        System.out.println(h + " " + m);

        s.close();
    }
}
