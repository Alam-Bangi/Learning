/*
Micro purchased an array A having N integer values. After playing it for a while, he got bored of it and decided to update value of its element. In one second he can increase value of each array element by 1. He wants each array element's value to become greater than or equal to K. Please help Micro to find out the minimum amount of time it will take, for him to do so.

Input:
First line consists of a single integer, T, denoting the number of test cases.
First line of each test case consists of two space separated integers denoting N and K.
Second line of each test case consists of N space separated integers denoting the array A.

Output:
For each test case, print the minimum time in which all array elements will become greater than or equal to K. Print a new line after each test case.

Constraints:



Sample Input
2
3 4
1 2 5
3 2
2 5 5
Sample Output
3
0
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
For first test case,
After 1 second, array will be

After 2 second, array will be

After 3 second, array will be

So it will take 3 second for all array elements to become greater than or equal to 4.
 */
package hackerearth.data_structures;

import java.util.Scanner;

public class MicroAndArrayUpdate {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val < minVal) {
                    minVal = val;
                }
            }

            if (minVal >= k) {
                System.out.println(0);
            } else {
                System.out.println(k - minVal);
            }
        }
        sc.close();
    }
}
