package beakjoon.n01110;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int inputNum = s.nextInt();
        int cycle = 0;
        int temp = inputNum;
        do {
            temp = (temp % 10 * 10) + ((temp / 10 + temp % 10) % 10 );
            cycle++;
        } while (temp != inputNum);
        System.out.println(cycle);
        s.close();
    }
}