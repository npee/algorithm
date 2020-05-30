package baekjoon.n02445;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String astr = "";
        String space = "";
        String line;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < 2 * N - 1; i++) {
            space = space.concat(" ");
        }

        for (int i = 0; i < N * 2 - 1; i++) {
            if (i < N) {
                astr = astr.concat("*");
                space = space.replaceFirst(" {2}", "");
                line = astr.concat(space).concat(astr);
                stack.push(line);
                if (i == N - 1) {
                    line = astr.concat(astr).replaceFirst("\\*", "");
                    stack.pop();
                }
                System.out.println(line);
            } else {
                System.out.println(stack.pop());
            }
        }
        s.close();
    }
}
