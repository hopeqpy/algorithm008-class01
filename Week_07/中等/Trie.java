package 中等;

/**
 * @program: algorithm
 * @description: 实现树
 * @author: qpy
 */
public class Trie  {

    private final int ALPHABET_SIZE = 26;
    private Trie [] next = new Trie [ALPHABET_SIZE];
    boolean isEndOfWord = false;

    public Trie () {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (null == word || "".equals( word )) {
            return;
        }
        Trie  root = this;
        for (char i : word.toCharArray()) {
            if (root.next[i - 'a'] == null) {
                root.next[i - 'a'] = new Trie ();
            }
            root = root.next[i - 'a'];
        }
        root.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (null == word || "".equals( word )) {
            return false;
        }
        Trie  root = this;
        for (char i : word.toCharArray()) {
            if (root.next[i - 'a'] == null) {
                return false;
            }
            root = root.next[i - 'a'];
        }
        return root.isEndOfWord ? true : false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || "".equals( prefix )) {
            return false;
        }
        Trie  root = this;
        for (char i : prefix.toCharArray()) {
            if (root.next[i - 'a'] == null) {
                return false;
            }
            root = root.next[i - 'a'];
        }
        return true;
    }
}
