package programmers.ex.hash04;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};

        print(solution(genres1, plays1));

    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        return answer;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

//class Music {
//    String genre;
//    int plays;
//
//    Music(String genre, int plays) {
//        this.genre = genre;
//        this.plays = plays;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public int getPlays() {
//        return plays;
//    }
//}
