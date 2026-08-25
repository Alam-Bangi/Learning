/*
Arpasland has surrounded by attackers. A truck enters the city. The driver claims the load is food and medicine from Iranians. Ali is one of the soldiers in Arpasland. He doubts about the truck, maybe it's from the siege. He knows that a tag is valid if the sum of every two consecutive digits of it is even and its letter is not a vowel. Determine if the tag of the truck is valid or not.

We consider the letters "A","E","I","O","U","Y" to be vowels for this problem.

Input Format

The first line contains a string of length 9. The format is "DDXDDD-DD", where D stands for a digit (non zero) and X is an uppercase english letter.

Output Format

Print "valid" (without quotes) if the tag is valid, print "invalid" otherwise (without quotes)

Sample Input
12X345-67
Sample Output
invalid
 */
package hackerearth.basic_programming;

import java.util.Scanner;

public class AliHelpingInnocentPeople {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        String in = sc.next();
        sc.close();

        if (in.length() != 9) {
            System.out.println("invalid");
            return;
        }

        char letter = in.charAt(2);
        if (letter == 'A' || letter == 'E' || letter == 'I' ||
                letter == 'O' || letter == 'U' || letter == 'Y') {
            System.out.println("invalid");
            return;
        }

        if (isEvenSum(in.charAt(0), in.charAt(1)) &&
                isEvenSum(in.charAt(3), in.charAt(4)) &&
                isEvenSum(in.charAt(4), in.charAt(5)) &&
                isEvenSum(in.charAt(7), in.charAt(8))) {

            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

    static boolean isEvenSum(char c1, char c2) {
        int num1 = c1 - '0';
        int num2 = c2 - '0';
        return (num1 + num2) % 2 == 0;
    }
}
