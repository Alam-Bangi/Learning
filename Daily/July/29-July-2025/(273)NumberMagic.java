/**

Coding Exercise: Return ArrayList with multiples of a given number less than a specified limit
You are given a partially completed NumberMagic class.

The class contains a method, determineMultiples(int number, int limit), which is supposed to return a list of multiples of a given number less than a specified limit.

Your task is to complete the implementation of this method.

The method signature is:

public List<Integer> determineMultiples(int number, int limit)
Input

The method takes two integer arguments:

number : The number to find multiples of.

limit : The upper bound for the multiples.

Output

The method should return a List<Integer> which contains all multiples of the given number that are less than the limit.

If number or limit is less than or equal to 0, the method should return an empty list.



Examples

Example 1

Pass number as 3 and limit as 20. Returned list should be [3, 6, 9, 12, 15, 18].

Example 2

Pass number as 5 and limit as 1. Method should return an empty list: [].

 */

import java.util.ArrayList;
import java.util.List;
 
class NumberMagic {
    /**
     * This method generates a list of multiples of a given number less than a specified limit.
     * 
     * @param number the number to find multiples of
     * @param limit the upper bound for the multiples
     * @return a List of multiples of the number less than the limit
     */
    public List<Integer> determineMultiples(int number, int limit) {
 
        if (number <= 0 || limit <= 0) {
            return new ArrayList<>();
        }
 
        List<Integer> multiples = new ArrayList<>();
 
        for (int i = 1; i * number < limit; i++) {
            multiples.add(i * number);
        }
 
        return multiples;
    }
}
