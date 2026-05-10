import java.util.*;
import java.util.concurrent.*;

class DiceGame {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> players = List.of(new Player("Player 1"),
                new Player("Player 2"), new Player("Player 3"));

        try {
            String winner = executor.invokeAny(players);

            System.out.println("\nWINNER: " + winner);

        } catch (Exception e) {
            System.out.println("Game error.");
        }

        executor.shutdown();
    }
}

class Player implements Callable<String> {

    String name;
    int dice = 1;

    Player(String name) {
        this.name = name;
    }

    private int rollDice() {
        int value = dice;
        dice++;

        if (dice > 6) {
            dice = 1;
        }

        return value;
    }

    public String call() throws Exception {

        while (!Thread.currentThread().isInterrupted()) {

            int roll = rollDice();

            System.out.println(name + " rolled: " + roll);

            Thread.sleep(400);

            if (roll == 6) {
                System.out.println(name + " HIT 6!");
                return name + " wins the game!";
            }
        }
        return "Game stopped";
    }
}