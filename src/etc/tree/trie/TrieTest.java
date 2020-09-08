package etc.tree.trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("frodo");
        trie.insert("front");
        trie.insert("frozen");
        trie.insert("frodo");
        trie.insert("kakao");

        System.out.println(trie.contains("frodo"));

    }
}
