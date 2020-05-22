package beakjoon.n05543;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int menu[] = new int[5];
        int set = 0;
        int min_berger = 2000, min_beverage = 2000;

        for (int i = 0; i < 5; i++) {
            int cost = s.nextInt();

            if (cost < 100 || cost > 2000) {
                s.close();
                return;
            }
            if (i < 3) {
                menu[i] = cost;
                if (menu[i] < min_berger) {
                    min_berger = menu[i];
                }
            } else {
                menu[i] = cost;
                if (menu[i] < min_beverage) {
                    min_beverage = menu[i];
                }
            }
        }
        set = min_berger + min_beverage - 50;

        System.out.println(set);

        s.close();
    }
}
