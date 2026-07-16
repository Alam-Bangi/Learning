/*
Monk and Suffix Sort
100 points
1s time
256MB memory
Monk loves to play games. On his birthday, his friend gifted him a string S. Monk and his friend started playing a new game called as Suffix Game. In Suffix Game, Monk's friend will ask him lexicographically
 smallest suffix of the string S. Monk wants to eat the cake first so he asked you to play the game.

Video approach to solve this question: here

Input Format:
First line contains a string S (
) and an integer k (
).

Output Format:
Print the lexicographically
 smallest suffix of the string S.

Note:
Those who are not familiar with suffix and lexicographical order, can read about it from https://en.wikipedia.org/wiki/Suffix and https://en.wikipedia.org/wiki/Lexicographical_order.

Examples
Input

aacb 3
Output

b
Explanation
All the suffices of the string are:
aacb
acb
cb
b

After sorting the order of the suffices will be:
aacb
acb
b
cb

 smallest suffix will be b.
 */
package hackerearth;

import java.util.*;

public class MonksAndSuffixSort {

    public static void main(String args[]) throws Exception {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int k = sc.nextInt();

        int n = s.length();
        String[] suffixes = new String[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i);
        }
        Arrays.sort(suffixes);
        System.out.println(suffixes[k - 1]);
    }
}

