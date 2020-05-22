package beakjoon.n02742;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = s.nextInt();
        for (int i = count; i >= 1; i--) {
            bw.write(i + "\n");
        }
        bw.flush();
        s.close();
        bw.close();
    }
}
