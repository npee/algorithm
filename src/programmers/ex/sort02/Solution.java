package programmers.ex.sort02;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));

    }

    public static String solution(int[] numbers) {
        String answer = "";

        PriorityQueue<String> queue = new PriorityQueue<>((str1, str2) -> Integer.parseInt(str2 + str1) - Integer.parseInt(str1 + str2));

        for (int number: numbers) {
            queue.offer(String.valueOf(number));
        }

        while (!queue.isEmpty()) {
            answer += queue.poll();
        }

        // 결과가 0인 경우
        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }
}
