/*
Minimum AND xor OR
Given an array 
 of 
 integers. Find out the minimum value of the following expression for all valid 
.

, where 
.

Video approach to solve this question: here

Input format

First line: A single integer 
 denoting the number of test cases
For each test case:
First line contains a single integer 
, denoting the size of the array.
Second line contains 
 space separated integers 
Output format

For each test case, print a single line containing one integer that represents the minimum value of the given expression

Constraints


Note: Sum of 
 overall test cases does not exceed 

Sample Input
2
5
1 2 3 4 5
3
2 4 7

Sample Output
1
3

Explanation
For test case #1, we can select elements 
 and 
, the value of the expression is 
, which is the minimum possible value. Another possible pair is 4 and 5.

For test case #2, we can select elements 4 and 7, the value of the expression is 
, which is the minimum possible value.
*/

import java.util.Arrays;
import java.util.Scanner;

class MinimumANDxorOr {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            sc.close();
            Arrays.sort(A);
            int minXor = Integer.MAX_VALUE;

            for (int i = 0; i < N - 1; i++) {
                int currentXor = A[i] ^ A[i + 1];
                minXor = Math.min(minXor, currentXor);
            }
            System.out.println(minXor);
        }
    }
}
