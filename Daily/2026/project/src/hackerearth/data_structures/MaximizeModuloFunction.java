/*
Problem
You are given an integer
 that is represented in the form of string
 of length
. You can remove at most 1 digit from the number after removing the rest of the digits that are arranged in the same order.

Example

For
, if you delete the digit
, the new number is
.

You are also given an integer
. Find the maximum possible value of (
 mod
) after deleting at most 1 digit from number
.

Input format

The first line contains an integer
 denoting the number of test cases.
The first line of each test case contains two space-separated integers
 and
.
The second line of each test case contains string
.
Output format

For each test case, print the maximum possible value of the mod function in a new line.

Constraints


Sample Input
1
5 12
52436
Sample Output
11
Time Limit: 2
Memory Limit: 256
Source Limit:
Explanation
If we remove the last digit from the number
, then the new number will be
.


 */
package hackerearth.data_structures;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximizeModuloFunction {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        ArrayList<Integer> results = new ArrayList<>();

        while (testCases-- > 0) {
            int strLength = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int ogValue = Integer.parseInt(s);
            int max = ogValue % k;

            for (int i = 0; i < strLength; i++) {
                String newNumber = s.substring(0, i)
                        + s.substring(i + 1);

                long value = Long.parseLong(newNumber);
                int remainder = Math.toIntExact(value % k);

                max = Math.max(max, remainder);
            }

            results.add(max);
        }
        for (int result : results) {
            System.out.println(result);
        }
        sc.close();
    }
}
