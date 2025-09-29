/**
 * https://www.hackerrank.com/challenges/java-substring/problem
 * 
 * 29 September 2025
 * 
 * @author Marko Lazarevic
 * 
 * Task:
 * 
 * You are given a string, , and two indices,  and . Print the substring consisting of all characters in the inclusive range from  to .
 * 
 * Input Format
 * 
 * The first line contains a single string denoting .
 * The second line contains two space-separated integers denoting the respective values of  and .
 * 
 * Constraints
 * 
 * String  consists of English alphabetic letters (i.e., ) only.
 * Output Format
 * 
 * Print the substring in the inclusive range from  to .
 * 
 * Sample Input
 * 
 * Helloworld
 * 3 7
 * Sample Output
 * 
 * lowo
 * Explanation
 * 
 * In the diagram below, the substring is highlighted in green:
 * 
 * substring.png
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        S.substring(start , end);
        System.out.println(S.substring(start , end));
    }
}