/*
You are required to enter a word that consists of
 and
 that denote the number of Zs and Os respectively. The input word is considered similar to word zoo if
.

Determine if the entered word is similar to word zoo.

For example, words such as zzoooo and zzzoooooo are similar to word zoo but not the words such as zzooo and zzzooooo.

Input format

First line: A word that starts with several Zs and continues by several Os.
Note: The maximum length of this word must be
.
Output format

Print Yes if the input word can be considered as the string zoo otherwise, print No.

Sample Input
zzzoooooo
Sample Output
Yes
Time Limit: 0.5
Memory Limit: 256
Source Limit:
Explanation
-
 */
package hackerearth.basic_programming;

import java.util.*;

public class Zoos {
    static String check(String input) {
        Map<Character, Integer> count = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        if (count.size() != 2) {
            return "No";
        }

        int first = 0;
        int second = 0;
        int i = 0;

        for (int value : count.values()) {
            if (i == 0) {
                first = value;
            } else {
                second = value;
            }
            i++;
        }
        return second == first * 2 ? "Yes" : "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(check(input));
    }
}
