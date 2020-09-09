package programmers.kakao.blind_recruitment_2020._4_lyrics_search;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao", "a"};
        String[] quries = {"fro??", "????o", "fr???", "fro???", "pro?", "?", "frodo"};

        print(solution(words, quries));
    }
    public static int[] solution(String[] words, String[] queries) {
        int[] results = new int[queries.length];
        Trie trie = new Trie();

        trie.printTrie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            if (trie.contains(queries[i])) {
                results[i]++;
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
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean end;

    Map<Character, TrieNode> getChildren() {
        return this.children;
    }
    boolean getEnd() {
        return this.end;
    }

    void setEnd(boolean end) {
        this.end = end;
    }


}

class Trie {
    private TrieNode root;
    private int quantityOFWord;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode currentNode = this.root;

        for (int i = 0; i < word.length(); i++) {
            currentNode = currentNode.getChildren().computeIfAbsent(word.charAt(i), ch -> new TrieNode());
        }
        quantityOFWord++;
        currentNode.setEnd(true);
    }

    boolean contains(String query) {
        TrieNode currentNode = this.root;
        System.out.println(query);

        int wordLength = 0;

        for (int i = 0; i < query.length(); i++) {
            char queryChar = query.charAt(i);

            if (queryChar == '?') {
                wordLength++;
                continue;
            }

            TrieNode findNode = currentNode.getChildren().get(queryChar);
            System.out.print(queryChar);

            if (findNode == null) {
                System.out.println();
                return false;
            }

            currentNode = findNode;
            wordLength++;
        }

        if (wordLength != query.length()) {
            return false;
        }

        System.out.println();
        System.out.println("query length: " + query.length());
        System.out.println("word length: " + wordLength);

        return currentNode.getEnd();
    }

    void printTrie() {
        TrieNode nodePointer = this.root;
        AtomicReference<String> temp = new AtomicReference<>("");
        for (char i = 'a'; i < 'z'; i++) {

        }
        System.out.println();
    }

}
