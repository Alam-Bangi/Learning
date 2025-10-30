/**
 
Coding Exercise - Filter Odd Numbers
You are given a list of integers and your task is to filter out the odd numbers from this list using Java Stream API.

Note that the order of the numbers in the output list should be the same as their order in the input list.

Edge Conditions

The list may contain both positive and negative integers.

The list may be empty.

Input Format

The input will be a List<Integer> that contains n integers (both positive and negative).

Output Format

The output should be a List<Integer> which contains all the odd numbers from the input list.

Examples

Input: [1, 2, 3, 4, 5] Output: [1, 3, 5]

Input: [6, 7, 8, 9, 10] Output: [7, 9]

Input: [-3, -2, -1, 0, 1, 2, 3] Output: [-3, -1, 1, 3]

Notes

The list.stream() function is used to convert a list into a stream.

The stream.filter() function takes a predicate (an expression that returns a boolean). It is used to filter out elements that do not satisfy the predicate.

The stream.collect() function is used to convert a stream back into a list. Inside this function, Collectors.toList() is used, which is a utility method that instructs the .collect() function to accumulate the input elements into a new list.

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class FunctionalProgrammingMagic {

    /**
     * This method filters out the odd numbers from a given list of integers.
     * @param numbers This is the list of integers from which odd numbers are to be filtered out.
     * @return List<Integer> This returns a list of odd integers.
     */
    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
        
        // Write your code here
        return numbers.stream().filter(e -> e%2!=0).collect(Collectors.toList());
        
    }
}