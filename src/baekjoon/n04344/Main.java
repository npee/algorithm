package baekjoon.n04344;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test_case = s.nextInt();
        int test_cases[][] = new int[test_case][];

        int students;

        double averages[] = new double[test_case];

        for (int i = 0; i < test_case; i++) {
            int total = 0;
            students = s.nextInt();
            test_cases[i] = new int[students];
            if (students > 1000 || students < 1) {
                s.close();
                return;
            }
            for (int j = 0; j < students; j++) {
                test_cases[i][j] = s.nextInt();
                if (test_cases[i][j] > 100 || test_cases[i][j] < 0) {
                    s.close();
                    return;
                }
                total += test_cases[i][j];
            }
            averages[i] = total / students;
        }

        double above_average;
        for (int i = 0; i < test_case; i++) {
            above_average = 0;
            for (int j = 0; j < test_cases[i].length; j++) {
                if (test_cases[i][j] > averages[i]) {
                    above_average++;
                }
            }
            System.out.printf("%.3f%%%n", above_average / test_cases[i].length * 100);
        }

        s.close();
    }
}