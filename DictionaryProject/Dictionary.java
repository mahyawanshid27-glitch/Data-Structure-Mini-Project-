public class Dictionary {

    private Trie trie;
    private HashTable hashTable;

    // Constructor
    public Dictionary() {

        trie = new Trie();
        hashTable = new HashTable(10);
    }

    // Add a word to the dictionary
    public void addWord(String word, String meaning) {

        trie.insert(word);
        hashTable.insert(word, meaning);
    }

    // Search for a word and return its meaning
    public String searchWord(String word) {

        return hashTable.search(word);
    }

    // Get auto-complete suggestions
    public java.util.List<String> autoComplete(String prefix) {

        return trie.autoComplete(prefix);
    }

    // Get all words from the dictionary
    public java.util.List<String> getAllWords() {

        return trie.getAllWords();
    }

    // Update the meaning of a word
    public boolean updateMeaning(
            String word,
            String newMeaning) {

        return hashTable.update(word, newMeaning);
    }

    // Delete a word from the dictionary
    public boolean deleteWord(String word) {

        // Check whether the word exists
        if (!trie.search(word)) {
            return false;
        }

        // Delete from Trie
        trie.delete(word);

        // Delete from HashTable
        hashTable.delete(word);

        return true;
    }

    // Display word statistics
    public void displayStatistics() {

        java.util.List<String> words = trie.getAllWords();

        // Check if dictionary is empty
        if (words.isEmpty()) {

            System.out.println("Dictionary is empty.");
            return;
        }

        int totalWords = words.size();
        int totalCharacters = 0;

        String longestWord = words.get(0);
        String shortestWord = words.get(0);

        // Calculate statistics
        for (String word : words) {

            totalCharacters += word.length();

            // Find longest word
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }

            // Find shortest word
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }

        // Calculate average word length
        double averageLength =
                (double) totalCharacters / totalWords;

        System.out.println();
        System.out.println("========== WORD STATISTICS ==========");

        System.out.println(
            "Total Words: " + totalWords
        );

        System.out.println(
            "Total Characters: " + totalCharacters
        );

        System.out.println(
            "Average Word Length: " + averageLength
        );

        System.out.println(
            "Longest Word: " + longestWord
        );

        System.out.println(
            "Shortest Word: " + shortestWord
        );

        System.out.println(
            "====================================="
        );
    }
}