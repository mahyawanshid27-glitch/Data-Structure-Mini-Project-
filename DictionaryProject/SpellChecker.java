public class SpellChecker {

    private Dictionary dictionary;

    // Constructor
    public SpellChecker(Dictionary dictionary) {

        this.dictionary = dictionary;
    }

    // Calculate edit distance between two words
    private int editDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Convert word1 to empty word
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert empty word to word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Calculate minimum edit distance
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                        insert,
                        Math.min(delete, replace)
                    );
                }
            }
        }

        return dp[m][n];
    }

    // Find the closest word in the dictionary
    public String checkSpelling(String word) {

        java.util.List<String> words = dictionary.getAllWords();

        String bestMatch = null;
        int smallestDistance = Integer.MAX_VALUE;

        for (String dictionaryWord : words) {

            int distance = editDistance(word, dictionaryWord);

            if (distance < smallestDistance) {

                smallestDistance = distance;
                bestMatch = dictionaryWord;
            }
        }

        return bestMatch;
    }
}