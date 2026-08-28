/*
You are given two arrays
 and
. In each step, you can set
 if
. Determine the minimum number of steps that are required to make all
's equal.

Input format

First line:

Second line:
Third line:
Output format

Print the minimum number of steps that are required to make all
's equal. If it is not possible, then print -1.

Constraints



Sample input

25 64 3

Sample output

-1

Sample Input
5
5 7 10 5 15
2 2 1 3 5
Sample Output
8
 */
package hackerearth.basic_programming;

import java.util.Scanner;

public class NumberOfSteps {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (min > a[i]) {
                min = a[i]-b[i];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (a[i] > min && b[i] != 0) {
                a[i] -= b[i];
                res++;
            }
            if (a[i] != min) {
                res = -1;
                break;
            }
        }
        System.out.println(res);
    }
}
