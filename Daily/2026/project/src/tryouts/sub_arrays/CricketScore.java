package tryouts.sub_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CricketScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total overs : ");
        int overs = sc.nextInt();
        List<int[]> scores = new ArrayList<>();

        for(int j = 0; j < overs; j++) {
            int[] over = new int[6];
            for (int i = 0; i < 6; i++) {
                System.out.println("~~~~~~~~~~~~~~~~~");
                System.out.print("Over " + (j+1) + " ball "+ (i+1) + ": ");
                over[i] = sc.nextInt();
            }
            scores.add(over);
            System.out.println();
        }
        displayScoreCard(scores);
        int total = displayTotalScore(scores);
        System.out.println("Total : " + total);
    }

    public static void displayScoreCard(List<int[]> scorecard) {
        int count = 1;
        System.out.println("~~~~~ Score-card ~~~~~");
        for (int[] score : scorecard) {
            System.out.println("Over " + count + ": " + Arrays.toString(score));
            count++;
        }
    }

    public static int displayTotalScore(List<int[]> scores) {
        int totalScore = 0;
        for(int[] o : scores) {
            for (int j : o) {
                totalScore += j;
            }
        }
        return totalScore;
    }
}
