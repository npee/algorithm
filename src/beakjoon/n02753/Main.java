package beakjoon.n02753;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        int isYun = 0;

        if (input % 400 == 0) {
            isYun = 1;
        } else if (input % 100 == 0) {
            isYun = 0;
        } else if (input % 4 == 0) {
            isYun = 1;
        } else {
            isYun = 0;
        }
        System.out.println(isYun);
    }
}
