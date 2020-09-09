package etc.tree.trie;

public class TrieTest {
    public static void main(String[] args) {

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

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
            System.out.println(queries[i] + ": " + results[i]);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        System.out.println();

/*
        Trie trie = new Trie();

        trie.insert("frodo");
        trie.insert("front");
        trie.insert("frozen");
        trie.insert("frodon");
        trie.insert("kakao");

        System.out.println(trie.contains("frodo"));
        System.out.println(trie.contains("fro??"));
        System.out.println(trie.contains("froz??"));
*/

    }
}
