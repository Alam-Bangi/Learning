/*
You are given an array of numbers
 which contains positive as well as negative numbers . The cost of the array can be defined as

 , where T is the transfer array which contains N zeros initially.

You need to minimize this cost . You can transfer value from one array element to another if and only if the distance between them is at most K.

Also, transfer value can't be transferred further.

Say array contains
 and

if we transfer 3 from
 element to
 , the array becomes

Original Value

Transferred value

 which is minimum in this case

Note :

Only positive value can be transferred

It is not necessary to transfer whole value i.e partial transfer is also acceptable. This means that if you have
 then you can distribute the value 5 across many other array elements provided that they finally sum to a number less than equal to 5. For example 5 can be transferred in chunks of smaller values say 2 , 3 but their sum should not exceed 5.

Input:

First line contains N and K separated by space

Second line denotes an array of size N

Output

Minimum value of

Constraints



Sample Input
3 2
3 -1 -2
Sample Output
0
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
Array contains
 and

if we transfer 1 from
 element to
 and 2 from
 element to
, the array becomes

Original Value

Transferred value

 which is minimum in this case
 */
package hackerearth.basic_programming;

import java.io.*;
import java.util.*;

public class MinimizeCost {
    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            long k = sc.nextLong();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long out_ = Solve(k, arr);
            System.out.println(out_);

            sc.close();
        }

    static long Solve(long k, int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                continue;
            }
            while (i - j > k) {
                ++j;
            }
            while (arr[i] != 0 && (i + k) >= Math.min(arr.length - 1, j)) {
                if (arr[j] > 0) {
                    j++;
                    continue;
                }
                int x = Math.min(arr[i], Math.abs(arr[j]));
                arr[i] -= x;
                arr[j] += x;

                if (arr[j] >= 0) {
                    j++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += Math.abs(arr[i]);
        }
        return ans;
    }
}