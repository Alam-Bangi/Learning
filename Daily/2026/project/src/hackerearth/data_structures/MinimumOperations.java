/*
You are given an array
 of length
 and can perform the following operation on the array:

Select a subarray from array
 having the same value of elements and decrease the value of all the elements in that subarray by any positive integer
.
Find the minimum number of operations required to make all the elements of array
 equal to zero.

Input format

The first line contains an integer
 denoting the number of elements in the array.
The next line contains space-separated integers denoting the elements of array
.
Output format

Print the minimum number of operations required to make all the elements of array
 equal to zero.

Constraints


Sample Input
5
2 2 1 3 1
Sample Output
4
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
 Operation , choose subarray [5,5] and x = 1.
Array
 becomes
 Operation , choose subarray [3,3] and x = 1.
Array
 becomes
 Operation , choose subarray [1,2] and x = 2.
Array
 becomes
 Operation , choose subarray [4,4] and x = 3.
Array
 becomes
Hence, minimum
 operations are required.
 */
package hackerearth.data_structures;

import java.util.Scanner;

public class MinimumOperations {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int elementCount = 1;
        for (int j = 0; j < n - 1; j++) {
            if (a[j] == a[j + 1]) {
                elementCount++;
            }
        }
        int ans = n - elementCount + 1;
        System.out.println(ans);

        sc.close();
    }
}
