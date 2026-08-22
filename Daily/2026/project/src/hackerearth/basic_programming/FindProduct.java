/*
You have been given an array A of size N consisting of positive integers. You need to find and print the product of all the number in this array Modulo
.

Input Format:
The first line contains a single integer N denoting the size of the array. The next line contains N space separated integers denoting the elements of the array

Output Format:
Print a single integer denoting the product of all the elements of the array Modulo
.

Constraints:


Sample Input
5
1 2 3 4 5
Sample Output
120
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
There are 5 integers to multiply. Let's store the final answer in
 variable. Since 1 is identity value for multiplication, initialize
 as 1.

So the process goes as follows:


) %

) %

) %

) %

) %

The above process will yield answer as


 */
package hackerearth.basic_programming;

import java.util.Scanner;

public class FindProduct {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] numbers = new int[n];
        for(int i =0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        long product = 1;
        long modulo = 1000000007;
        for(int i =0; i < n; i++) {
            product = (product * numbers[i]) % modulo;
        }
        System.out.println(product);
    }
}
