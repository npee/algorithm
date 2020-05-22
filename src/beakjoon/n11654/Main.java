package beakjoon.n11654;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char ch = str.charAt(0);
        int ascii = (int) ch;
        System.out.println(ascii);
        s.close();
    }
}
