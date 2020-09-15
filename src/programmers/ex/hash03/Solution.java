package programmers.ex.hash03;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> base = new HashMap<>();
        for (String[] cloth: clothes) {
            if (base.getOrDefault(cloth[1], 0) == 0 ) {
                base.put(cloth[1], 1);
            } else {
                base.replace(cloth[1], base.get(cloth[1]) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry: base.entrySet()) {
            answer *= (entry.getValue() + 1);
        }

        return answer - 1;
    }
}