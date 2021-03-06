package etc.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;
    private int count = 0;

    Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    boolean isLastChar() {
        return this.isLastChar;
    }

    void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }

    void increaseCount() {
        this.count++;
    }

    int getCount() {
        return this.count;
    }

    @Override
    public String toString() {
        return this.childNodes.entrySet().toString();
    }
}
