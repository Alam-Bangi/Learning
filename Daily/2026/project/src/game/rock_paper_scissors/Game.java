package game.rock_paper_scissors;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] choices = { "Rock", "Paper", "Scissors" };
        System.out.println("Welcome to Rock-Paper-Scissors Game!!");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.print("Enter your choice (1-3): ");
        int userInput = sc.nextInt();
        sc.nextLine();
        while(userInput < 1 || userInput > 3) {
            System.out.println("Invalid choice!! \nEnter your choice(1-3): ");
            userInput = sc.nextInt();
        }
        String userChoice = choices[userInput-1];
        System.out.println("You chose: " + userChoice);

        int computerChoice = (int) (Math.random() * choices.length);
        System.out.println("Computer chose: " + choices[computerChoice]);

        if (userChoice.equalsIgnoreCase(choices[computerChoice])) {
            System.out.println("Tie!!");
        } else if (userChoice.equalsIgnoreCase("Rock") && (choices[computerChoice].equalsIgnoreCase("Scissors"))
                || userChoice.equalsIgnoreCase("Paper") && (choices[computerChoice].equalsIgnoreCase("Rock"))
                || userChoice.equalsIgnoreCase("Scissors") && (choices[computerChoice].equalsIgnoreCase("Paper"))) {
            System.out.println("You win!!");
        } else {
            System.out.println("Computer wins!!");
        }
        sc.close();
    }
}
