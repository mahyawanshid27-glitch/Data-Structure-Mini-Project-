public class HashNode {

    String word;
    String meaning;
    HashNode next;

    // Constructor
    public HashNode(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
        this.next = null;
    }
}