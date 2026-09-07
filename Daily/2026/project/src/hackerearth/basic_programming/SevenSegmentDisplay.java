/*
You all must have seen a seven segment display.If not here it is:



Alice got a number written in seven segment format where each segment was creatted used a matchstick.

Example: If Alice gets a number 123 so basically Alice used 12 matchsticks for this number.

Alice is wondering what is the numerically largest value that she can generate by using at most the matchsticks that she currently possess.Help Alice out by telling her that number.



Input Format:

First line contains T (test cases).

Next T lines contain a Number N.

Output Format:

Print the largest possible number numerically that can be generated using at max that many number of matchsticks which was used to generate N.

Constraints:



Sample Input
2
1
0
Sample Output
1
111
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
If you have 1 as your number that means you have 2 match sticks.You can generate 1 using this.

If you have 0 as your number that means you have 6 match sticks.You can generate 111 using this.
 */
package hackerearth.basic_programming;

import java.util.Scanner;

class SevenSegmentDisplay {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] stickMap = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        while (t-- > 0) {
            String n = sc.next();
            long totalSticks = 0;

            for (int i = 0; i < n.length(); i++) {
                totalSticks += stickMap[n.charAt(i) - '0'];
            }

            StringBuilder result = new StringBuilder();
            if (totalSticks % 2 != 0) {
                result.append("7");
                totalSticks -= 3;
            }

            long onesCount = totalSticks / 2;
            for (long i = 0; i < onesCount; i++) {
                result.append("1");
            }
            System.out.println(result.toString());
        }
        sc.close();
    }
}
