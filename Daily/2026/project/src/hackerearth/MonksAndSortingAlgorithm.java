/*
Monk and Sorting Algorithm
100 points
1s time
256MB memory
Monk recently taught Fredo about sorting. Now, he wants to check whether he understood the concept or not. So, he gave him the following algorithm and asked to implement it:

Assumptions:
We consider the rightmost digit of each number to be at index 1, second last at index 2 and so on till the leftmost digit of the number.
Meaning of
 chunk: This chunk consists of digits from position
 to
 in the given number.If there is no digit at some position in the number, take the digit to be 0.

Initially, i is 1.

Construct the
 chunk, for all of the integers in the array. Let's call the value of this chunk to be the weight of respective integer in the array.
If weight of all the integers of the array is 0, then STOP
Sort the array according to the weights of integers. If two integers have same weight, then the one which appeared earlier should be positioned earlier after the sorting is done. The array changes to this sorted array.
Increment i by 1 and repeat from STEP 1

See the sample explanation for a better understanding.
So, Fredo understood the concept and coded it. Now, Monk asks you to write the code for the algorithm to verify Fredo's answer.

Video approach to solve this question: here

Input:
The first line of the input contains N denoting the number of elements in the array to be sorted.
The next line contains N single space separated integers denoting the array elements.

Output:
You need to print the new array in each step of the algorithm.

Constraints:
; A[] is the input array
Size of integers (number of digits in integer) in A may not be same.

Note
Use Fast I/O
Examples
Input
3
213456789 167890 123456789
Output
213456789 123456789 167890
167890 123456789 213456789
Explanation
Each line of output is the array after each transformation.
Here goes the explanation:
1st chunk of respective integers= 56789, 67890, 56789
weight of respective integers= 56789, 67890, 56789
So, sorted array according to weights is [213456789, 123456789, 167890] because 56789< 67890.
Note that the weight of 213456789 and 123456789 are the same, so we need to keep the given order.This becomes the new array.

The array now is [213456789, 123456789, 167890]
2nd chunk of respective integers in the array= 02134, 01234, 00001
weight of respective integers= 2134, 1234, 1
So, sorted array according to weights is [167890, 123456789, 213456789] because 1<1234<2134.
This becomes the new array.

The array now is [167890, 123456789, 213456789].
So, as the 3rd chunk would have no digits for any integer, so weights of all integers will be 0 and the algorithm would stop.
*/
package hackerearth;

import java.util.*;

public class MonksAndSortingAlgorithm {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(numbers, (a, b) -> Integer.compare(a % 100000, b % 100000));
        for(Integer no : numbers) {
            System.out.print(no + " ");
        }
//        System.out.println();
//        for(int j = n-1; j >=0; j--) {
//            System.out.print(numbers[j] + " ");
//        }
    }
}
