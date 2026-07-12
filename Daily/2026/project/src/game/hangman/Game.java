package game.hangman;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hangman game!");
        System.out.print("Enter a word for Hangman game: ");
        String word = sc.nextLine();

        String hiddenWord = word.replaceAll(".", "-");
        int attempts = 6;

        while (attempts > 0 && hiddenWord.contains("-")) {
            System.out.println("\nWord: " + hiddenWord);
            System.out.println("\nAttempts left: " + attempts);
            System.out.print("Guess a letter: ");
            char guess = sc.nextLine().charAt(0);

            if (word.indexOf(guess) >= 0) {
                StringBuilder newHiddenWord = new StringBuilder(hiddenWord);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        newHiddenWord.setCharAt(i, guess);
                    }
                }
                hiddenWord = newHiddenWord.toString();
            } else {
                attempts--;
            }
            if (attempts == 0) {
                System.out.println("Game Over! The word was: " + word);
            } else if(!hiddenWord.contains("-")) {
                System.out.println("You guessed the right word!! " + word);
            }
        }
        sc.close();
    }
}
