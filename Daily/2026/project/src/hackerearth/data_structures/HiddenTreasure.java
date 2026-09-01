/*
Alice, an aspiring cryptographer, recently discovered an ancient scroll containing a sequence of mysterious numbers. According to a legend, these numbers hold the key to unlocking a hidden treasure buried centuries ago by an enigmatic mathematician. However, deciphering the scroll requires identifying specific pairs of numbers that follow an ancient numerical pattern.

Alice is given an array of integers nums. She wants to determine how many pairs
 exist such that:

The sum of digits of nums[i] is equal to the sum of digits of nums[j].
She believes that the correct count of these pairs will reveal a crucial clue needed to decode the next part of the scroll. Your task is to help Alice compute this number so she can continue her quest.

Task

Return the number of special pairs to assist Alice in uncovering the hidden secret.

Function description

Complete the function solve() provided in the editor. This function takes the following two parameters and returns the required answer:

N: Represents the number of elements in the array

nums: A list of N integers

Input format

The first line contains a single integer N(size of the array).

The second line contains N space-separated integers representing the array nums.

Output format

For each test case, print the required answer on a new line.

Constraints



Sample Input
4
51 71 17 42
Sample Output
2
Time Limit: 5
Memory Limit: 256
Source Limit:
Explanation
Given

N = 4, nums = [51, 71, 17, 42]

Approach:

51 → Sum of digits = 6
71 → Sum of digits = 8
17 → Sum of digits = 8
42 → Sum of digits = 6
Valid pairs:

(1,4) → 51 & 42 (sum = 6)
(2,3) → 71 & 17 (sum = 8)
Total = 2
 */
package hackerearth.data_structures;

import java.io.*;
import java.util.*;

public class HiddenTreasure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_nums = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i_nums = 0; i_nums < arr_nums.length; i_nums++)
        {
            nums[i_nums] = Integer.parseInt(arr_nums[i_nums]);
        }

        long out_ = solve(n, nums);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static long solve(int n, int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        long result = 0;

        for (int num : nums) {
            int sum = 0;
            int temp = num;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            result += map.getOrDefault(sum, 0L);

            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }
        return result;
    }
}
