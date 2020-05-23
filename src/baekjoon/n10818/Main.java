package baekjoon.n10818;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int array[] = new int[s.nextInt()];
        int i = 0;
        while (i < array.length) {
            array[i] = s.nextInt();
            i++;
        }
        Arrays.sort(array);
        System.out.printf("%d %d%n", array[0], array[array.length-1]);
        s.close();
    }
}