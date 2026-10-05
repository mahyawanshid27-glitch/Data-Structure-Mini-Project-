import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create Dictionary
        Dictionary dictionary = new Dictionary();

        // Create SpellChecker
        SpellChecker spellChecker =
                new SpellChecker(dictionary);

        // =========================================
        // ADD 50 UNIQUE INITIAL WORDS
        // =========================================

        dictionary.addWord(
            "computer",
            "An electronic device that processes data"
        );

        dictionary.addWord(
            "coding",
            "The process of writing computer programs"
        );

        dictionary.addWord(
            "code",
            "Instructions written for a computer"
        );

        dictionary.addWord(
            "college",
            "An educational institution"
        );

        dictionary.addWord(
            "algorithm",
            "A step-by-step procedure used to solve a problem"
        );

        dictionary.addWord(
            "application",
            "A software program designed to perform a specific task"
        );

        dictionary.addWord(
            "array",
            "A data structure that stores multiple values"
        );

        dictionary.addWord(
            "database",
            "An organized collection of data"
        );

        dictionary.addWord(
            "developer",
            "A person who creates and maintains software"
        );

        dictionary.addWord(
            "device",
            "An electronic or mechanical object designed for a purpose"
        );

        dictionary.addWord(
            "function",
            "A reusable block of code that performs a specific task"
        );

        dictionary.addWord(
            "internet",
            "A global network connecting computers and devices"
        );

        dictionary.addWord(
            "java",
            "A programming language used to develop applications"
        );

        dictionary.addWord(
            "network",
            "A group of connected computers or devices"
        );

        dictionary.addWord(
            "program",
            "A set of instructions given to a computer"
        );

        dictionary.addWord(
            "python",
            "A high-level programming language"
        );

        dictionary.addWord(
            "software",
            "A set of programs that instruct a computer"
        );

        dictionary.addWord(
            "technology",
            "The application of scientific knowledge for practical purposes"
        );

        dictionary.addWord(
            "variable",
            "A named storage location used to hold a value"
        );

        dictionary.addWord(
            "mobile",
            "A portable electronic device"
        );

        dictionary.addWord(
            "android",
            "An operating system designed mainly for mobile devices"
        );

        dictionary.addWord(
            "keyboard",
            "An input device used to type characters and commands"
        );

        dictionary.addWord(
            "monitor",
            "An output device that displays information"
        );

        dictionary.addWord(
            "memory",
            "A component used to store data and instructions"
        );

        dictionary.addWord(
            "processor",
            "A component that executes instructions and processes data"
        );

        dictionary.addWord(
            "hardware",
            "The physical components of a computer"
        );

        dictionary.addWord(
            "website",
            "A collection of web pages available on the internet"
        );

        dictionary.addWord(
            "browser",
            "A software application used to access websites"
        );

        dictionary.addWord(
            "server",
            "A computer that provides services to other computers"
        );

        dictionary.addWord(
            "client",
            "A computer or application that requests services from a server"
        );

        dictionary.addWord(
            "cloud",
            "A system for storing and accessing data over the internet"
        );

        dictionary.addWord(
            "security",
            "Protection of computers, networks, and data from threats"
        );

        dictionary.addWord(
            "password",
            "A secret combination used to protect an account"
        );

        dictionary.addWord(
            "information",
            "Processed data that has meaning"
        );

        dictionary.addWord(
            "input",
            "Data provided to a computer for processing"
        );

        dictionary.addWord(
            "output",
            "Information produced by a computer after processing"
        );

        dictionary.addWord(
            "loop",
            "A programming structure that repeatedly executes instructions"
        );

        dictionary.addWord(
            "class",
            "A blueprint used to create objects in programming"
        );

        dictionary.addWord(
            "object",
            "An instance of a class"
        );

        dictionary.addWord(
            "method",
            "A block of code that performs a specific operation"
        );

        dictionary.addWord(
            "interface",
            "A structure that defines methods a class can implement"
        );

        dictionary.addWord(
            "inheritance",
            "A feature that allows one class to acquire properties of another"
        );

        dictionary.addWord(
            "sensor",
            "A device that detects changes in the environment"
        );

        dictionary.addWord(
            "robot",
            "A programmable machine capable of performing tasks"
        );

        dictionary.addWord(
            "queue",
            "A data structure that follows the First In First Out principle"
        );

        dictionary.addWord(
            "stack",
            "A data structure that follows the Last In First Out principle"
        );

        dictionary.addWord(
            "tree",
            "A hierarchical data structure made of nodes"
        );

        dictionary.addWord(
            "graph",
            "A data structure consisting of vertices and edges"
        );

        dictionary.addWord(
            "linkedlist",
            "A data structure made of nodes connected through links"
        );

        dictionary.addWord(
            "recursion",
            "A technique in which a function calls itself"
        );
        dictionary.addWord(
            "society",
            "A group of people living together in a community"
        );

        // =========================================
        // MENU LOOP
        // =========================================

        while (true) {

            System.out.println();
            System.out.println("========== DICTIONARY ==========");
            System.out.println("1. Search Word");
            System.out.println("2. Auto-Complete");
            System.out.println("3. Spell Check");
            System.out.println("4. Add New Word");
            System.out.println("5. Delete Word");
            System.out.println("6. Update Meaning");
            System.out.println("7. Display All Words");
            System.out.println("8. Word Statistics");
            System.out.println("9. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                // =================================
                // 1. Search Word
                // =================================
                case 1:

                    System.out.print("Enter word: ");

                    String searchWord =
                            scanner.nextLine().toLowerCase();

                    String meaning =
                            dictionary.searchWord(searchWord);

                    if (meaning != null) {

                        System.out.println(
                            "Meaning: " + meaning
                        );

                    } else {

                        System.out.println(
                            "Word not found."
                        );
                    }

                    break;

                // =================================
                // 2. Auto-Complete
                // =================================
                case 2:

                    System.out.print(
                        "Enter prefix: "
                    );

                    String prefix =
                            scanner.nextLine().toLowerCase();

                    List<String> suggestions =
                            dictionary.autoComplete(prefix);

                    if (suggestions.isEmpty()) {

                        System.out.println(
                            "No suggestions found."
                        );

                    } else {

                        System.out.println(
                            "Suggestions: " + suggestions
                        );
                    }

                    break;

                // =================================
                // 3. Spell Check
                // =================================
                case 3:

                    System.out.print(
                        "Enter word to check: "
                    );

                    String spellWord =
                            scanner.nextLine().toLowerCase();

                    String suggestion =
                            spellChecker.checkSpelling(spellWord);

                    if (suggestion != null) {

                        System.out.println(
                            "Did you mean: " + suggestion + "?"
                        );

                    } else {

                        System.out.println(
                            "No suggestion found."
                        );
                    }

                    break;

                // =================================
                // 4. Add New Word
                // =================================
                case 4:

                    System.out.print(
                        "Enter new word: "
                    );

                    String newWord =
                            scanner.nextLine().toLowerCase();

                    System.out.print(
                        "Enter meaning: "
                    );

                    String newMeaning =
                            scanner.nextLine();

                    dictionary.addWord(
                        newWord,
                        newMeaning
                    );

                    System.out.println(
                        "Word added successfully."
                    );

                    break;

                // =================================
                // 5. Delete Word
                // =================================
                case 5:

                    System.out.print(
                        "Enter word to delete: "
                    );

                    String deleteWord =
                            scanner.nextLine().toLowerCase();

                    boolean deleted =
                            dictionary.deleteWord(deleteWord);

                    if (deleted) {

                        System.out.println(
                            "Word deleted successfully."
                        );

                    } else {

                        System.out.println(
                            "Word not found."
                        );
                    }

                    break;

                // =================================
                // 6. Update Meaning
                // =================================
                case 6:

                    System.out.print(
                        "Enter word: "
                    );

                    String updateWord =
                            scanner.nextLine().toLowerCase();

                    System.out.print(
                        "Enter new meaning: "
                    );

                    String updateMeaning =
                            scanner.nextLine();

                    boolean updated =
                            dictionary.updateMeaning(
                                updateWord,
                                updateMeaning
                            );

                    if (updated) {

                        System.out.println(
                            "Meaning updated successfully."
                        );

                    } else {

                        System.out.println(
                            "Word not found."
                        );
                    }

                    break;

                // =================================
                // 7. Display All Words
                // =================================
                case 7:

                    List<String> words =
                            dictionary.getAllWords();

                    if (words.isEmpty()) {

                        System.out.println(
                            "Dictionary is empty."
                        );

                    } else {

                        System.out.println(
                            "Words in dictionary:"
                        );

                        for (String dictionaryWord : words) {

                            System.out.println(
                                "- " + dictionaryWord
                            );
                        }
                    }

                    break;

                // =================================
                // 8. Word Statistics
                // =================================
                case 8:

                    dictionary.displayStatistics();

                    break;

                // =================================
                // 9. Exit
                // =================================
                case 9:

                    System.out.println(
                        "Thank you for using the Dictionary!"
                    );

                    scanner.close();

                    return;

                // =================================
                // Invalid Choice
                // =================================
                default:

                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }
        }
    }
}