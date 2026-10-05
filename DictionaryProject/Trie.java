import java.util.ArrayList;
import java.util.List;

public class Trie {

    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search for a complete word
    public boolean search(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    // Check whether a prefix exists
    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
    }

    // Get auto-complete suggestions
    public List<String> autoComplete(String prefix) {

        List<String> suggestions = new ArrayList<>();

        TrieNode current = root;

        // Move to the node representing the prefix
        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return suggestions;
            }

            current = current.children[index];
        }

        // Find all words starting with the prefix
        findWords(current, prefix, suggestions);

        return suggestions;
    }

    // Get all words stored in the Trie
    public List<String> getAllWords() {

        List<String> words = new ArrayList<>();

        findWords(root, "", words);

        return words;
    }

    // Recursively find words
    private void findWords(
            TrieNode node,
            String word,
            List<String> words) {

        // If this node represents the end of a word
        if (node.isEndOfWord) {
            words.add(word);
        }

        // Check all 26 possible characters
        for (char ch = 'a'; ch <= 'z'; ch++) {

            int index = ch - 'a';

            if (node.children[index] != null) {

                findWords(
                    node.children[index],
                    word + ch,
                    words
                );
            }
        }
    }

    // Delete a word from the Trie
    public boolean delete(String word) {

        // Check if the word exists
        if (!search(word)) {
            return false;
        }

        delete(root, word, 0);

        return true;
    }

    // Recursive delete method
    private boolean delete(
            TrieNode current,
            String word,
            int depth) {

        // Reached the end of the word
        if (depth == word.length()) {

            current.isEndOfWord = false;

            // Delete this node if it has no children
            return hasNoChildren(current);
        }

        int index = word.charAt(depth) - 'a';

        TrieNode child = current.children[index];

        // Word path does not exist
        if (child == null) {
            return false;
        }

        boolean shouldDeleteChild =
                delete(child, word, depth + 1);

        if (shouldDeleteChild) {

            current.children[index] = null;

            return !current.isEndOfWord
                    && hasNoChildren(current);
        }

        return false;
    }

    // Check whether a node has no children
    private boolean hasNoChildren(TrieNode node) {

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {
                return false;
            }
        }

        return true;
    }
}