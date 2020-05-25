package baekjoon.n10871;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int lt = Integer.parseInt(st.nextToken());
        int temp;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (temp < lt) {
                bw.write(temp + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}