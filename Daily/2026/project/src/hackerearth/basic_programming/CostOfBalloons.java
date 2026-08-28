/*
You are conducting a contest at your college. This contest consists of two problems and
 participants. You know the problem that a candidate will solve during the contest.

You provide a balloon to a participant after he or she solves a problem. There are only green and purple-colored balloons available in a market. Each problem must have a balloon associated with it as a prize for solving that specific problem. You can distribute balloons to each participant by performing the following operation:

Use green-colored balloons for the first problem and purple-colored balloons for the second problem
Use purple-colored balloons for the first problem and green-colored balloons for the second problem
You are given the cost of each balloon and problems that each participant solve. Your task is to print the minimum price that you have to pay while purchasing balloons.

Input format

First line:
 that denotes the number of test cases (
)
For each test case:
First line: Cost of green and purple-colored balloons
Second line:
 that denotes the number of participants (
)
Next
 lines: Contain the status of users. For example, if the value of the
 integer in the
 row is
, then it depicts that the
 participant has not solved the
 problem. Similarly, if the value of the
 integer in the
 row is
, then it depicts that the
 participant has solved the
 problem.
Output format
For each test case, print the minimum cost that you have to pay to purchase balloons.

Sample Input
2
9 6
10
1 1
1 1
0 1
0 0
0 1
0 0
0 1
0 1
1 1
0 0
1 9
10
0 1
0 0
0 0
0 1
1 0
0 1
0 1
0 0
0 1
0 0
Sample Output
69
14

 */
package hackerearth.basic_programming;

import java.util.Scanner;

public class CostOfBalloons {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[][] p;
        int testCases = sc.nextInt();
        for (int z = 0; z < testCases; z++) {
            int purpleBalloon = sc.nextInt();
            int greenBalloon = sc.nextInt();
            int participants = sc.nextInt();
            p = new int[participants][2];
            for (int i = 0; i < participants; i++) {
                for (int j = 0; j < 2; j++) {
                    p[i][j] = sc.nextInt();
                }
            }
            int col1count = 0;
            int col2count = 0;
            for (int i = 0; i < participants; i++) {
                if (p[i][0] == 1) {
                    col1count++;
                }
                if (p[i][1] == 1) {
                    col2count++;
                }
            }

            int cost = 0;
            if(col1count < col2count) {
                if(purpleBalloon < greenBalloon) {
                    cost = (greenBalloon * col1count) + (purpleBalloon * col2count);
                } else {
                    cost = (greenBalloon * col2count) + (purpleBalloon * col1count);
                }
            } else {
                if(purpleBalloon > greenBalloon) {
                    cost = (greenBalloon * col1count) + (purpleBalloon * col2count);
                } else {
                    cost = (greenBalloon * col2count) + (purpleBalloon * col1count);
                }
            }
            System.out.println(cost);
        }
    }
}
