/*
You are given an array
 of
 integers. You want to choose some integers from the array subject to the condition that the number of distinct integers chosen should not exceed
. Your task is to maximize the sum of chosen numbers.

You are given
 test cases.

Input format

The first line contains a single integer
 denoting the number of test cases.
The first line of each test case contains two space-separated integers
 and
 denoting the length of the array and the maximum number of distinct integers you can choose.
The second line of each test case contains
 space-separated integers denoting the integer array
.
Output format

For each test case(in a separate line), print the maximum sum you can obtain by choosing some elements such that the number of distinct integers chosen is at most
. If you cannot choose any element, output
.

Constraints


Sample Input
2
4 1
3 -1 2 5
4 2
2 1 2 5
Sample Output
5
9
Time Limit: 1.5
Memory Limit: 256
Source Limit:
Explanation
In the first test case, we have
,
. Since we can choose atmost 1 distinct integer, we choose
. The sum is also
 and we output it.

In the second test case, we have
,
. We need to choose atmost 2 distinct integers, we choose
. Note that the condition is choosing atmost
 distinct integers. So we can choose repeated number as many times as we want. The sum is
 and we output it.
 */
package hackerearth.data_structures;

import java.util.Arrays;
import java.util.Scanner;

public class MaximiseTheSum {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        int[] ans = new int[testCases];

        int a = 0;
        while(testCases > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                int ele = sc.nextInt();
                arr[i] = ele;
            }
            testCases--;

            int z = arr.length-1;
            arr = Arrays.stream(arr).sorted().toArray();
            if(k == 1) {
                ans[a] = arr[z];
                a++;
                continue;
            }
            int sum = 0;

            for(int j = 0; j < k; j++) {
                sum += arr[z];
                if(arr[j] == arr[z-1]) {
                    sum += arr[z-1];
                }
                z--;
            }
            ans[a] = sum;
            a++;
        }
        for(int r : ans) {
            System.out.println(r);
        }
    }
}
