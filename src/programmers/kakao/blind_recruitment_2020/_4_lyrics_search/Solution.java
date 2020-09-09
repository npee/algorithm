package programmers.kakao.blind_recruitment_2020._4_lyrics_search;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao", "a"};
        String[] quries = {"fro??", "????o", "fr???", "fro???", "pro?", "?", "frodo", "?????"};

        print(solution(words, quries));
    }
    public static int[] solution(String[] words, String[] queries) {
        int[] results = new int[queries.length];
        Trie[] tries = new Trie[100001];

        for (String word: words) {
            int i = word.length();

            if (tries[i] == null) {
                tries[i] = new Trie();
            }

            tries[i].insert(word);
        }

        for (int i = 0; i < queries.length; i++) {
            int j = queries[i].length();

            if (tries[j] == null) {
                results[i] = 0;
            } else {
                results[i] = tries[j].getCount(queries[i]);
            }
        }

        return results;
    }

    /*
    public static int[] solution(String[] words, String[] queries) {
        return search(words, queries);
    }

    public static int[] search(String[] words, String[] queries) {
        int[] results = new int[queries.length];
        for (String word: words) {
            int i = 0;
            for (String query: queries) {

                boolean isSuffix = false;
                String token;
                String temp;

                if (query.charAt(0) == '?') {
                    isSuffix = true;
                }

                if (word.length() == query.length()) {
                    if (isSuffix) {
                        token = query.substring(query.lastIndexOf('?')+1);
                        temp = word.substring(query.lastIndexOf('?')+1);
                    } else {
                        token = query.substring(0, query.indexOf('?'));
                        temp = word.substring(0, query.indexOf('?'));
                    }
                    if (temp.equals(token) ) {
                        results[i]++;

                    }
                }
                i++;
            }
        }
        for (int result: results) System.out.println(result);
        return results;
    }

     */

    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class TrieNode {
    private Map<Character, TrieNode> children;
    private int count;

    TrieNode() {
        this.children = new HashMap<>();
        this.count = 0;
    }

    Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }
}

class Trie {
    public TrieNode root;
    public TrieNode reverseRoot;
    public int wordCount;

    Trie() {
        wordCount = 0;
        root = new TrieNode();
        reverseRoot = new TrieNode();
    }

    void insert(String word) {
        commonInsert(word);
        reverseInsert(word);
    }

    void commonInsert(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            currentNode = currentNode.getChildren().computeIfAbsent(word.charAt(i), ch -> new TrieNode());
            currentNode.increaseCount();
        }
    }

    void reverseInsert(String word) {
        TrieNode currentNode = reverseRoot;

        for (int i = word.length() - 1; i >= 0; i--) {
            currentNode = currentNode.getChildren().computeIfAbsent(word.charAt(i), ch -> new TrieNode());
            currentNode.increaseCount();
        }
        this.wordCount++;
    }

    int getCount(String query) {
        if (query.charAt(0) == '?') {
            return getCountInReverseCase(query);
        } else {
            return getCountInCommonCase(query);
        }
    }

    int getCountInCommonCase(String query) {
        TrieNode currentNode = this.root;

        for (int i = 0; i < query.length(); i++) {
            char ch = query.charAt(i);
            if (ch == '?') {
                break;
            }
            if (!currentNode.getChildren().containsKey(ch)) {
                return 0;
            }
            currentNode = currentNode.getChildren().get(ch);
        }
        return currentNode.getCount();
    }

    int getCountInReverseCase(String query) {
        TrieNode currentNode = this.reverseRoot;

        for (int i = query.length() - 1; i >= 0; i--) {
            if (query.charAt(query.length() - 1) == '?') {
                return wordCount;
            }

            char ch = query.charAt(i);

            if (ch == '?') {
                break;
            }
            if (!currentNode.getChildren().containsKey(ch)) {
                return 0;
            }
            currentNode = currentNode.getChildren().get(ch);
        }
        return currentNode.getCount();
    }
}
