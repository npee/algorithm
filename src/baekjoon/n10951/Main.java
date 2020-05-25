package baekjoon.n10951;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int sum, a, b;
        while (s.hasNext()) {
            a = s.nextInt();
            b = s.nextInt();

            sum = a + b;
            System.out.println(sum);
        }
        s.close();
    }
}
