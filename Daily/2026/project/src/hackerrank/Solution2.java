/*
This Java 8 challenge tests your knowledge of Lambda expressions!

Write the following methods that return a lambda expression performing a specified action:

PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.
Input Format

Input is handled for you by the locked stub code in your editor.

Output Format

The locked stub code in your editor will print  lines of output.

Sample Input

The first line contains an integer,  (the number of test cases).

The  subsequent lines each describe a test case in the form of  space-separated integers:
The first integer specifies the condition to check for ( for Odd/Even,  for Prime, or  for Palindrome). The second integer denotes the number to be checked.

5
1 4
2 5
3 898
1 3
2 12
Sample Output

EVEN
PRIME
PALINDROME
ODD
COMPOSITE
 */
package hackerrank;

import java.util.*;

class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        int condition;
        int value;
        int[] conditions = new int[testcases];
        int[] values = new int[testcases];
        for(int i=0; i<testcases; i++) {
            condition = sc.nextInt();
            if(condition > 0 || condition < 4) {
                conditions[i] = condition;
            }
            value = sc.nextInt();
            values[i] = value;
        }
        for(int i = 0; i<conditions.length; i++) {
            if(conditions[i] == 1) {
                if(isOdd(values[i])) {
                    System.out.println("ODD");
                } else {
                    System.out.println("EVEN");
                }
            }else if(conditions[i] == 2) {
                if(isPrime(values[i])) {
                    System.out.println("PRIME");
                } else {
                    System.out.println("COMPOSITE");
                }
            }else if(conditions[i] == 3) {
                if(isPalindrome(values[i])) {
                    System.out.println("PALINDROME");
                } else {
                    System.out.println("NOT A PALINDROME");
                }
            }
        }
    }
    static boolean isOdd(int number) {
        if(number % 2 == 1) {
            return true;
        }
        return false;
    }

    static boolean isPrime(int number) {
        for(int i=2; i<number;i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int number) {
        int no = number;
        if (no == 0) {
            return false;
        }

        if (no < 0) {
            return false;
        }

        int reversedNumber = 0;

        while (no != 0) {
            int digit = no % 10;

            reversedNumber = reversedNumber * 10 + digit;

            no /= 10;
        }
        if(number == reversedNumber) {
            return true;
        }
        return false;
    }
}