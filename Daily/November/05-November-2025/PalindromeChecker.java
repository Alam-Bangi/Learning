/**
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string , print Yes if it is a palindrome, print No otherwise.

Constraints

A will consist at most  lower case english letters.
Sample Input

madam
Sample Output

Yes

*/

import java.io.*;
import java.util.*;

class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String reverseStr = "";
        for (int i = (A.length() - 1); i >=0; i--) {
        reverseStr = reverseStr + A.charAt(i);
        }

        if (A.toLowerCase().equals(reverseStr.toLowerCase())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}