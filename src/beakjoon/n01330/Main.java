package beakjoon.n01330;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = Integer.valueOf(s.next());
        int b = Integer.valueOf(s.next());

        if (a > b) {
            System.out.println(">");
        } else if (a < b) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }

        s.close();
    }
}