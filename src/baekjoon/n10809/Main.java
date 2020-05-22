package baekjoon.n10809;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) {
                --alphabet[i];
        }
        for (int i = 0; i < str.length(); i++) {
            if (alphabet[(int) str.charAt(i) - 97] == -1) {
                alphabet[(int) str.charAt(i) - 97] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (i == 25) {
                System.out.print(alphabet[i]);
            } else {
                System.out.print(alphabet[i] + " ");
            }
        }
        System.out.println();
        s.close();
    }
}
