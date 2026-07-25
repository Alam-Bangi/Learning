/*
Monk and Nice Strings
100 points
1s time
256MB memory
Monk's best friend Micro's birthday is coming up. Micro likes Nice Strings very much, so Monk decided to gift him one. Monk is having N nice strings, so he'll choose one from those. But before he selects one, he need to know the Niceness value of all of those. Strings are arranged in an array A, and the Niceness value of string at position i is defined as the number of strings having position less than i which are lexicographicaly smaller than
. Since nowadays, Monk is very busy with the Code Monk Series, he asked for your help.
Note: Array's index starts from 1.

Video approach to solve this question: here

Input:
First line consists of a single integer denoting N.
N lines follow each containing a string made of lower case English alphabets.

Output:
Print N lines, each containing an integer, where the integer in
 line denotes Niceness value of string
.

Constraints:

, where
 denotes the length of
 string.

Examples
Input

4
a
c
d
b
Output

0
1
2
1
Explanation
Number of strings having index less than 1 which are less than "a" = 0
Number of strings having index less than 2 which are less than "c": ("a") = 1
Number of strings having index less than 3 which are less than "d": ("a", "c") = 2
Number of strings having index less than 4 which are less than "b": ("a") = 1
*/
package hackerearth;

import java.util.*;

class MonksAndNiceStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scan.next();
        }
        scan.close();

        int[] outputs = new int[n];
        String[] s = new String[n + 1];
        int j = 0;
        s[0] = "A";

        for (int i = 1; i <= n; i++) {
            String str = inputs[i - 1];
            for (j = i - 1; j >= 0; j--) {
                if (s[j].compareTo(str) >= 0) {
                    s[j + 1] = s[j];
                } else {
                    break;
                }
            }
            outputs[i - 1] = j;
            s[j + 1] = str;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(outputs[i]);
        }
    }
}
