package etc.tree.trie;

public class Trie {
    private TrieNode rootNode;
    private TrieNode rootNodeReverse;

    Trie() {
        rootNode = new TrieNode();
        rootNodeReverse = new TrieNode();
        print("생성 시(생성자 호출 시) 빈 TrieNode 생성하여 root로 사용");
    }

    void insert(String word) {
        commonInsert(word);
        reverseInsert(word);
    }

    void commonInsert(String word) {
        TrieNode thisNode = this.rootNode;
        print("rootNode로 연산 시작(빈 노드)");
        int depth = 0;

        print("삽입할 단어(" + word + ")의 길이(" + word.length() + ")만큼 반복 시작");
        for (int i = 0; i < word.length(); i++) {
            // Map.computeIfAbsent(Key, Lamda expression);
            // 특정 키가 준비되지 않았거나 null인 경우 주어진 함수로 연산을 시도한다.
            // null이 아닌 경우 새로운 Map을 등록한다.
            // 함수의 return 값이 null인 경우 아무것도 기록하지 않는다.
            // 함수에서 예외가 발생하면 예외를 다시 던지고 아무것도 기록하지 않는다.
            // 가장 일반적인 사용 예는 함수로 새 객체를 생성하는 것이다.
            System.out.println("[i = " + i + "] 현재 노드의 keyset - " + thisNode.getChildNodes().entrySet() + "]");
            print("마지막 문자? " + thisNode.isLastChar());
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> {
                print("찾는 노드가 없으면(Key가 null이면) [" + c + "]을 Key로 하는 새 노드 생성");
                return new TrieNode();
            });
            thisNode.increaseCount();
        }

        thisNode.setIsLastChar(true);
        print("마지막 문자? " + thisNode.isLastChar() + " ======== insert() finished");
        print("");
        System.out.println(depth);
    }

    void reverseInsert(String word) {
        TrieNode thisNode = this.rootNodeReverse;
        int depth = 0;

        for (int i = word.length() - 1; i >= 0; i--) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            thisNode.increaseCount();
        }
        System.out.println(depth);
    }

    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);

            TrieNode node = thisNode.getChildNodes().get(character);

            if (node == null) {
                return false;
            }
            thisNode = node;
        }
        return thisNode.isLastChar();
    }

    int getCount(String query) {
        if (query.charAt(0) == '?') {
            return getCountReverseCase(query);
        } else {
            return getCountCommonCase(query);
        }
    }

    int getCountCommonCase(String query) {
        TrieNode currentNode = this.rootNode;
        for (int i = 0; i < query.length(); i++) {
            char ch = query.charAt(i);
            if (ch == '?') {
                break;
            }
            if (!currentNode.getChildNodes().containsKey(ch)) {
                return 0;
            }
            currentNode = currentNode.getChildNodes().get(ch);
        }
        return currentNode.getCount();
    }

    int getCountReverseCase(String query) {
        TrieNode currentNode = this.rootNodeReverse;
        for (int i = query.length() - 1; i >= 0; i--) {
            char ch = query.charAt(i);
            if (ch == '?') {
                break;
            }
            if (!currentNode.getChildNodes().containsKey(ch)) {
                return 0;
            }
            currentNode = currentNode.getChildNodes().get(ch);
        }
        return currentNode.getCount();
    }

    void delete(String word) {
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode thisNode, String word, int index) {
        char character = word.charAt(index);

        if (thisNode.getChildNodes().containsKey(character)) {
            throw new Error("There is no [" + word + "] in this Trie.");
        }

        TrieNode childNode = thisNode.getChildNodes().get(character);
        index++;

        if (index == word.length()) {
            if (!childNode.isLastChar()) {
                throw new Error("There is no [" + word + "] in this Trie.");
            }

            childNode.setIsLastChar(false);

            if (childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(character);
            }
        } else {
            delete(childNode, word, index);

            if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(character);
            }
        }
    }

    void print(String s) {
        System.out.println(s);
    }
}
