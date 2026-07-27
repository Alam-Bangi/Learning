/*
In computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated values(Wikipedia).  is an example of a set, but  is not a set. Today you will learn how to use sets in java by solving this problem.
You are given  pairs of strings. Two pairs  and  are identical if  and . That also implies  is not same as . After taking each pair as input, you need to print number of unique pairs you currently have.

Complete the code in the editor to solve this problem.

Input Format
In the first line, there will be an integer  denoting number of pairs. Each of the next  lines will contain two strings seperated by a single space.

Constraints:
Length of each string is atmost  and will consist lower case letters only.

Output Format
Print  lines. In the  line, print number of unique pairs you have after taking  pair as input.

Sample Input
5
john tom
john mary
john tom
mary anna
mary anna

Sample Output
1
2
2
3
3

Explanation
After taking the first input, you have only one pair: (john,tom)
After taking the second input, you have two pairs: (john, tom) and (john, mary)
After taking the third input, you still have two unique pairs.
After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)
After taking the fifth input, you still have three unique pairs.
 */
package hackerrank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HashSett {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Github\\Learning\\Daily\\2026\\project\\resources\\input.txt"));
        String line;

        int t = 1000;
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];
        int count = 0;
        while ((line = reader.readLine()) != null && count<t) {
            String[] part = line.split(" ");
            pair_left[count] = part[0];
            pair_right[count] = part[1];
            count++;
        }

//Write your code here
        ArrayList<Integer> out = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<String>();
        for(int j = 0; j < t; j++) {
            String word = pair_left[j] + " " + pair_right[j];
            uniqueWords.add(word);
            out.add(uniqueWords.size());
        }
        validateOutput(out);
    }
    static void validateOutput(List<Integer> num) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Github\\Learning\\Daily\\2026\\project\\resources\\output.txt"));
        String line;

        int t = 1000;
        int count = 0;
        while ((line = reader.readLine()) != null && count<t) {
            int original = num.get(count);
            int value = Integer.parseInt(line);
            if(value == original) {
//                continue;
            } else {
                System.out.println(original + "  Og- " + value);
            }
            count++;
        }

        }
}
//import java.io.*;
//        import java.util.*;
//        import java.text.*;
//        import java.math.*;
//        import java.util.regex.*;
//
//public class Solution {
//
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        String [] pair_left = new String[t];
//        String [] pair_right = new String[t];
//
//        for (int i = 0; i < t; i++) {
//            pair_left[i] = s.next();
//            pair_right[i] = s.next();
//        }
//
////Write your code here
//        Set<String> uniqueWords = new HashSet<>();
//        for(int j =0; j < t; j++) {
//            String word = pair_left[j].trim() + " " + pair_right[j].trim();
//            uniqueWords.add(word);
//            System.out.println(uniqueWords.size());
//        }
//    }
//}