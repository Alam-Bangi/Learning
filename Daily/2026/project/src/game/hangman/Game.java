package game.hangman;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"abrupt", "books", "leaves", "alright", "avenue"};
        System.out.println("Welcome to Hangman game!");

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String word = words[randomIndex];

        StringBuilder hidden = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(Character.isLetter(ch)) {
                hidden.append("_");
            } else {
                hidden.append(ch);
            }
        }
        String hiddenWord = hidden.toString();
        int attempts = 6;

        while (attempts > 0 && hiddenWord.contains("_")) {
            System.out.println("\nTotal Words: " + hiddenWord.length() + "\n" + hiddenWord);
            System.out.println("\nAttempts left: " + attempts);
            System.out.print("Guess a letter: ");
            char guess = sc.nextLine().charAt(0);

            if (word.toLowerCase().indexOf(Character.toLowerCase(guess)) >= 0) {
                StringBuilder newHiddenWord = new StringBuilder(hiddenWord);
                for (int i = 0; i < word.length(); i++) {
                    if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(guess)) {
                        newHiddenWord.setCharAt(i, Character.toLowerCase(guess));
                    }
                }
                hiddenWord = newHiddenWord.toString();
            } else {
                attempts--;
            }
            if (attempts == 0) {
                System.out.println("\nGame Over! The word was: " + word);
            } else if(!hiddenWord.contains("_")) {
                System.out.println("\nCongratulations!! You guessed the right word : " + word);
            }
        }
        sc.close();
    }
}
