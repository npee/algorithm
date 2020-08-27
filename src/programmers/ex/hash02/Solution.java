package programmers.ex.hash02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        System.out.println(solution(phone_book1));
        System.out.println(solution(phone_book2));
        System.out.println(solution(phone_book3));
    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (phone1, phone2) -> phone1.length() - phone2.length());

        Node root = new Node();

        for (String phone: phone_book) {
            Node currentNode = root;
            for (char digit : phone.toCharArray()) {
                currentNode = currentNode.getNodeMap().computeIfAbsent(digit, d -> new Node());
                if (currentNode.isEnd) {
                    answer = false;
                }
            }
            currentNode.setEnd();
        }

        return answer;
    }
}

class Node {
    Map<Character, Node> nodeMap;
    boolean isEnd;

    Node() {
        nodeMap = new HashMap<>();
        isEnd = false;
    }

    Map<Character, Node> getNodeMap() {
        return this.nodeMap;
    }

    void setEnd() {
        this.isEnd = true;
    }
}
