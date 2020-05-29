package etc.intbaseball;

import java.util.Scanner;

public class Baseball {
    private static int[] serializer(int pitching, boolean isHuman) {
        int hundreds = pitching / 100;
        int tens = pitching % 100 / 10;
        int units = pitching % 100 % 10;
        if (tens * units == 0) {
            if (isHuman) {
                System.out.println("0은 포함할 수 없습니다.");
            }
            return null;
        } else if ((pitching < 100 || pitching >= 1000) && isHuman) {
            System.out.println("세자리 숫자를 입력해주세요.");
            return null;
        } else if (hundreds != tens && tens != units && units != hundreds) {
            return new int[]{hundreds, tens, units};
        } else {
            if (isHuman) {
                System.out.println("각 자리수를 다르게 입력해주세요.");
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[] homerun;

        // Target
        do {
            int rand = (int) Math.round(Math.random() * 1000);
            homerun = serializer(rand, false);
        } while (homerun == null);

        // Input
        while(true) {
            int[] swing;
            Scanner s = new Scanner(System.in);
            String input = s.next();

            try {
                swing = serializer(Integer.parseInt(input), true);
            } catch (NumberFormatException nfe) {
                System.out.println("3자리 자연수를 입력해주세요.");
                continue;
            }

            if (swing == null) {
                continue;
            }

            // Logic
            int ball = 0;
            int strike = 0;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (swing[i] == homerun[j])
                        if (i == j) strike++;
                        else ball++;

            // Output
            if (strike == 3) {
                System.out.println("HOMERUN! 정답입니다!");
                break;
            } else if (strike == 0 && ball == 0){
                System.out.println("OUT!");
            } else {
                if (strike == 0) {
                    System.out.println(ball + " BALL");
                } else if (ball == 0) {
                    System.out.println(strike + " STRIKE");
                } else {
                    System.out.println(strike + " STRIKE, " + ball + " BALL");
                }
            }
        }
    }
}
