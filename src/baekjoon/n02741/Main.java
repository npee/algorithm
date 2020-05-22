package baekjoon.n02741;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = s.nextInt();
        for (int i = 1; i <= count; i++) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        s.close();
    }
}