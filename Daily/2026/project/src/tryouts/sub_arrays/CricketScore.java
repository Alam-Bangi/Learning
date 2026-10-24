package tryouts.sub_arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CricketScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total overs: ");
        int overs = sc.nextInt();

        List<Ball[]> scores = new ArrayList<>();
        int totalExtras = 0;
        int totalWickets = 0;

        for (int j = 0; j < overs; j++) {
            Ball[] over = new Ball[6];
            for (int i = 0; i < 6; i++) {
                System.out.println("-------------------------");
                System.out.println("Over " + (j + 1) + ", Ball " + (i + 1));

                System.out.print("Enter runs scored: ");
                int runs = sc.nextInt();

                System.out.print("No-ball? (y/n): ");
                boolean nb = sc.next().equalsIgnoreCase("y");

                System.out.print("Wide? (y/n): ");
                boolean wide = sc.next().equalsIgnoreCase("y");

                System.out.print("Leg-bye? (y/n): ");
                boolean lb = sc.next().equalsIgnoreCase("y");

                System.out.print("Wicket? (y/n): ");
                boolean out = sc.next().equalsIgnoreCase("y");

                int extras = 0;

                if(nb) {
                    extras += 1;
                } else if(wide) {
                    extras += 1;
                } else if(lb) {
                    System.out.print("Enter leg-bye runs: ");
                    extras += sc.nextInt();
                }
                over[i] = new Ball(runs, nb, wide, lb, out);
                totalExtras += extras;

                if (out) {
                    totalWickets++;
                }
            }
            scores.add(over);
        }
        displayScoreCard(scores);

        int totalRuns = displayTotalScore(scores) + totalExtras;

        System.out.println("\n========== MATCH SUMMARY ==========");
        System.out.println("Runs scored off bat: " + getBatRuns(scores));
        System.out.println("Extras: " + totalExtras);
        System.out.println("Wickets: " + totalWickets);
        System.out.println("Total runs: " + totalRuns);

        sc.close();
    }

    public static void displayScoreCard(List<Ball[]> scorecard) {
        System.out.println("\n========== SCORECARD ==========");

        int overNumber = 1;

        for (Ball[] over : scorecard) {
            System.out.println("\nOver " + overNumber + ":");

            for (int i = 0; i < over.length; i++) {
                System.out.println(
                        "Ball " + (i + 1) + ": " + over[i]
                );
            }

            overNumber++;
        }
    }

    public static int getBatRuns(List<Ball[]> scores) {
        int total = 0;

        for (Ball[] over : scores) {
            for (Ball ball : over) {
                total += ball.runs;
            }
        }

        return total;
    }

    public static int displayTotalScore(List<Ball[]> scores) {
        int total = 0;
        for (Ball[] over : scores) {
            for (Ball ball : over) {
                total += ball.runs;
            }
        }
        return total;
    }
}
