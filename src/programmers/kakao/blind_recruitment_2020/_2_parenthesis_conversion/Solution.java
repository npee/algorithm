package programmers.kakao.blind_recruitment_2020._2_parenthesis_conversion;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("(()())()")); // 균형, 올바른 -> "(()())()"
        System.out.println(solution(")(")); // 균형, not 올바른 -> "()"
        System.out.println(solution("()))((()")); // 균형, not 올바른 -> "()(())()"
    }

    public static String solution(String p) {
        if ("".equals(p)) return "";

        String u = "", v = "";
        int l = 0, r = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') l++;
            else r++;

            if (l == r) {
                u = p.substring(0, l + r);
                v = p.substring(l + r);
                break;
            }
        }

        int lp = 0;
        int rp = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') lp++;
            else rp++;
            if (rp > lp) {
                String newStr = "(" + solution(v) + ")";
                u = u.substring(1, u.length() - 1);
                u = u.replace('(', 't');
                u = u.replace(')', '(');
                u = u.replace('t', ')');

                return newStr + u;
            }
        }
        return u + solution(v);
    }
}
