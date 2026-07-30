/*
1. Two Sum
Easy
Topics
premium lock icon
Companies
Hint
You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
package leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {7, 9, 10, 4};
        System.out.println(Arrays.toString(twoSum(numbers, 11)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> eleIndex = new LinkedHashMap<>();
        int[] answer = new int[2];

        if(nums.length == 2 && nums[0]+nums[1]==target) {
            answer[0]  = 0;
            answer[1]  = 1;
            return answer;
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(eleIndex.containsKey(complement)) {
                return new int[]{eleIndex.get(complement), i};
            }
            eleIndex.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];
            if(eleIndex.containsKey(ele)) {
                answer[0] = i;
                answer[1] = eleIndex.get(ele);
            }
        }
        return answer;
    }
}
