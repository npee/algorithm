package baekjoon.n10102;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner getVote = new Scanner(System.in);

        String voters = getVote.nextLine();
        String voteBox = getVote.nextLine();

        int V;
        if (1 <= Integer.valueOf(voters) || 15 >= Integer.valueOf(voters)) {
            V = Integer.valueOf(voters);
        } else {
            getVote.close();
            return;
        }

        int voteA = 0, voteB = 0;

        for (int i = 0; i < V; i++) {
            if ('A' == voteBox.charAt(i)) {
                voteA++;
            } else {
                voteB++;
            }
        }

        if (voteA > voteB) {
            System.out.println("A");
        } else if (voteB > voteA) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }

        getVote.close();
    }
}