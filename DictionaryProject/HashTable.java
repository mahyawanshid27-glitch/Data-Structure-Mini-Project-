public class HashTable {

    private HashNode[] table;
    private int size;

    // Constructor
    public HashTable(int size) {

        this.size = size;
        table = new HashNode[size];
    }

    // Hash function
    private int hash(String word) {

        int hashValue = 0;

        for (char ch : word.toCharArray()) {
            hashValue = hashValue + ch;
        }

        return hashValue % size;
    }

    // Insert a word and its meaning
    public void insert(String word, String meaning) {

        int index = hash(word);

        HashNode newNode = new HashNode(word, meaning);

        // If the bucket is empty
        if (table[index] == null) {

            table[index] = newNode;

        } else {

            // Collision occurred
            HashNode current = table[index];

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    // Search for a word and return its meaning
    public String search(String word) {

        int index = hash(word);

        HashNode current = table[index];

        while (current != null) {

            if (current.word.equals(word)) {
                return current.meaning;
            }

            current = current.next;
        }

        return null;
    }

    // Update the meaning of an existing word
    public boolean update(String word, String newMeaning) {

        int index = hash(word);

        HashNode current = table[index];

        while (current != null) {

            if (current.word.equals(word)) {

                current.meaning = newMeaning;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Delete a word from the HashTable
    public boolean delete(String word) {

        int index = hash(word);

        HashNode current = table[index];
        HashNode previous = null;

        while (current != null) {

            if (current.word.equals(word)) {

                // If the word is the first node
                if (previous == null) {
                    table[index] = current.next;
                }

                // If the word is somewhere in the chain
                else {
                    previous.next = current.next;
                }

                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }
}