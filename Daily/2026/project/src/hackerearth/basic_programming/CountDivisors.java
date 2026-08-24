/*
You have been given 3 integers - l, r and k. Find how many numbers between l and r (both inclusive) are divisible by k. You do not need to print these numbers, you just have to find their count.

Input Format
The first and only line of input contains 3 space separated integers l, r and k.

Output Format
Print the required answer on a single line.

Constraints


Sample Input
1 10 1
Sample Output
10
 */
package hackerearth.basic_programming;

import java.util.Scanner;

public class CountDivisors {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        int divisor = sc.nextInt();

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % divisor == 0) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}

