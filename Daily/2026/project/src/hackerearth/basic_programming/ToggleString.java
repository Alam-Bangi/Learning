/*
You have been given a String S consisting of uppercase and lowercase English alphabets. You need to change the case of each alphabet in this String. That is, all the uppercase letters should be converted to lowercase and all the lowercase letters should be converted to uppercase. You need to then print the resultant String to output.

Input Format
The first and only line of input contains the String S

Output Format
Print the resultant String on a single line.

Constraints
 where S denotes the length of string S.

Sample Input
abcdE
Sample Output
ABCDe
 */
package hackerearth.basic_programming;

import java.util.Scanner;

public class ToggleString {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNext()) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (Character.isUpperCase(ch)) {
                    sb.append(Character.toLowerCase(ch));
                } else {
                    sb.append(Character.toUpperCase(ch));
                }
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
