package programmers.ex.hash;

public class Solution {
    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"mislav", "stanko", "ana"};

        print(solution(participant1, completion1));
        print(solution(participant2, completion2));
        print(solution(participant3, completion3));

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        String[] temp = new String[participant.length];

        for (int i = 0; i < participant.length; i++) {
            temp[i] = participant[i];
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < completion.length; j++) {
                if (temp[i].equals(completion[j])) {
                    completion[j] = "";
                    temp[i] = "";
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(temp[i])) {
                answer += temp[i];
            }
        }

        return answer;
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
