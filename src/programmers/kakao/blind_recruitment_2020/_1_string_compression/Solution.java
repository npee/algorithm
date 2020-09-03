package programmers.kakao.blind_recruitment_2020._1_string_compression;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("a"));
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }
    public static int solution(String s) {
        String tempStr = "";
        String tempSub = "";
        int duplicated = 1;
        int minLength = 1000;

        int i = 1;
        int j = 0;
        for (; i <= Math.round((double) s.length() / 2); i++) {
            while (j < s.length()) {
                String currSub;
                if (s.length() % i != 0 && j == s.length() - s.length() % i) {
                    currSub = s.substring(j);
                } else {
                    currSub = s.substring(j, j + i);
                }

                if (j == 0) {
                    tempSub = currSub;
                } else {
                    if (currSub.equals(tempSub)) {
                        duplicated++;
                    } else {
                        if (duplicated == 1) {
                            tempStr += tempSub;
                        } else {
                            tempStr += duplicated + tempSub;
                        }
                        tempSub = currSub;
                        duplicated = 1;
                    }
                }

                if (j >= s.length() - i) {
                    if (duplicated == 1) {
                        tempStr += tempSub;
                    } else {
                        tempStr += duplicated + tempSub;
                    }
                }

                j += i;
            }

            if (tempStr.length() < minLength) {
                minLength = tempStr.length();
            }

            j = 0;
            tempStr = "";
            tempSub = "";
            duplicated = 1;
        }

        return minLength;
    }
}
