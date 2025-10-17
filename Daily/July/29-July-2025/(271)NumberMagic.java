/**

Coding Exercise: Return Factors Of A Number in an ArrayList
Your task is to complete a Java method, determineAllFactors(int number), in the class NumberMagic.

This method should take an integer, number, and return a List<Integer> containing all factors of number.

This method should behave as follows:

It takes one input argument, an integer number. This argument represents the number for which you will find all factors.

The method should calculate all the factors of number. A factor is an integer that can be divided evenly into another number. In other words, if number modulo another number (let's call it divisor) equals zero, divisor is a factor of number.

The method should return these factors as a List<Integer>. The list should include all positive integers that are factors of number, including 1 and number itself.

Be aware of edge cases. If number is zero or a negative integer, the method should return an empty list.

Examples

NumberMagic nm = new NumberMagic();
System.out.println(nm.determineAllFactors(6));  // Prints: [1, 2, 3, 6]
NumberMagic nm = new NumberMagic();
System.out.println(nm.determineAllFactors(12));  // Prints: [1, 2, 3, 4, 6, 12]
System.out.println(nm.determineAllFactors(15));  // Prints: [1, 3, 5, 15]

 */

import java.util.ArrayList;
import java.util.List;
 
class NumberMagic {
 
    /**
     * This method returns all factors of a given number in an ArrayList.
     * 
     * @param number the number to find factors of
     * @return a List of factors of the number
     */
    public List<Integer> determineAllFactors(int number) {
 
        if (number <= 0) {
            return new ArrayList<>();
        }
 
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
 
        return factors;
    }
}
