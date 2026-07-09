import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // System.out.println("Enter a sentence: ");
        // String sentence = sc.nextLine();
        String sentence = "This is a sample sentence for testing the program. This program is designed to test various string operations.";

        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Display word with longest length");
            System.out.println("2. Display frequency of particular character");
            System.out.println("3. Check for palindrome");
            System.out.println("4. Display index of first appearance of a substring");
            System.out.println("5. Display occurence of each word");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    longestWord(sentence);
                    break;
                case 2:
                    charFrequency(sentence);
                    break;
                case 3:
                    System.out.print("Enter a word: ");
                    String word = sc.nextLine().toLowerCase();
                    String result = isPalindrome(word);
                    System.out.println(result);
                    break;
                case 4:
                    firstAppearance(sentence);
                    break;
                case 5:
                    wordOccurance(sentence);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");

            }
        } while (choice != 6);
    }

    public static void longestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Word with longest length is " + longestWord);
    }

    public static void charFrequency(String sentence) {
        System.out.println("Enter character to search its frequency: ");
        char ch = sc.nextLine().charAt(0);
        int frequency = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ch) {
                frequency++;
            }
        }
        System.out.println("Frequency of character " + ch + " is " + frequency);
    }

    public static String isPalindrome(String word) {
        boolean isPalindrome = false;
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
            isPalindrome = true;
        }

        if (!isPalindrome) {
            return word + " is not a palindrome.";
        } else {
            return word + " is a palindrome.";
        }
    }

    public static void wordOccurance(String sentence) {
        String words[] = sentence.split(" ");
        Map<String, Integer> occuranceMap = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            int count = 1;
            if (occuranceMap.containsKey(words[i])) {
                count = occuranceMap.get(words[i]) + 1;
            }
            occuranceMap.put(words[i], count);
        }
        System.out.println(occuranceMap);
    }

    public static void firstAppearance(String sentence) {
        System.out.println("Enter a substring: ");
        String subString = sc.nextLine();

        int index = sentence.indexOf(subString);
        if (index != -1) {
            System.out.println("Index of first appearance of substring is: " + index);
            ;
        } else {
            System.out.println("Substring not found");
        }
    }
}
