package beakjoon.n02577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int result = 1;
        int temp;
        int operand[] = new int[3];
        for (int i = 0; i < 3; i++) {
            operand[i] = s.nextInt();
            if (operand[i] < 100 || operand[i] >= 1000) {
                s.close();
                return;
            }
            result *= operand[i];
        }

        int idx[] = new int[10];
        for (int i = 0; i < 10; i++) {
            idx[i] = 0;
        }
        temp = result;
        for (int i = 0; i < 10; i++) {
            idx[temp % 10]++;
            temp /= 10;
            if (temp == 0) {
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(idx[i]);
        }

        s.close();
    }
}