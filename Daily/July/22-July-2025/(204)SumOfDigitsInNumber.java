```

// Coding Exercise: Calculate Sum of Digits of a Number
// In this exercise, you are given an incomplete Java class named NumberUtils. This class currently has a single unimplemented method named getSumOfDigits(int number).

// Your task is to complete the implementation of this method. The method should perform the following actions:

// If the given number is negative, the method should return -1. This is because the sum of digits of a negative number is undefined.

// If the given number is 0, the method should return 0, since the sum of digits of 0 is 0.

// If the given number is a positive integer, the method should calculate and return the sum of its digits.

// In conclusion, the method getSumOfDigits should be designed to handle any integer input, and be able to return the sum of its digits (or -1 for negative numbers). The method should also consider that zero is a valid input and should return 0 in this case, since the sum of digits of 0 is 0.

// Here is the skeleton of the NumberUtils class that you will complete:

// public class NumberUtils {
 
//     public int getSumOfDigits(int number) {
//         // Write your code here
//     }
// }
// Examples

// Let's take a few examples to understand the problem statement better:

// Example 1:

// Suppose the given number is 1234.

// The sum of its digits is 1 + 2 + 3 + 4 = 10.

// So, if the input is 1234, the method getSumOfDigits should return 10.

// Example 2:

// Suppose the given number is 0.

// The sum of its digits is 0.

// So, if the input is 0, the method getSumOfDigits should return 0.

// Example 3:

// Suppose the given number is -1234.

// The sum of the digits of a negative number is undefined.

// So, if the input is -1234, the method getSumOfDigits should return -1.

// Example 4:

// Suppose the given number is 999.

// The sum of its digits is 9 + 9 + 9 = 27.

// So, if the input is 999, the method getSumOfDigits should return 27.

// Task

// Your task is to implement the getSumOfDigits(int number) method in the NumberUtils class.

// getSumOfDigits(int number) - This method takes one parameter, number (an integer), and it should return the sum of its digits. If the input number is negative, it should return -1. If the input number is 0, it should return 0.

// Examples with Code

// Here are some examples of how your NumberUtils class should behave once the getSumOfDigits(int number) method is implemented:

// NumberUtils utils = new NumberUtils();
 
// System.out.println(utils.getSumOfDigits(123));   // Output: 6
// System.out.println(utils.getSumOfDigits(90));    // Output: 9
// System.out.println(utils.getSumOfDigits(5));     // Output: 5
// System.out.println(utils.getSumOfDigits(0));     // Output: 0
// System.out.println(utils.getSumOfDigits(-67));   // Output: -1
// In the above examples, the sum of digits of each number is calculated as expected, and -1 is returned for negative inputs.

// Note

// The sum of digits of a number can be calculated by repeatedly removing the last digit from the number and adding it to the sum. For instance, the sum of digits of 123 can be calculated as follows:

// The last digit of 123 is 3. Remove 3 from 123 to get 12. Add 3 to the sum.

// The last digit of 12 is 2. Remove 2 from 12 to get 1. Add 2 to the sum.

// The last digit of 1 is 1. Remove 1 from 1 to get 0. Add 1 to the sum.

// Now that the number is 0, we stop. The sum of digits of 123 is 3 + 2 + 1 = 6.

// Good luck with your implementation!

```

class SumOfDigitsInNumber {
 
    /**
     * This method calculates and returns the sum of digits in a given integer.
     * If the number is negative, it returns -1 as the sum of digits for a negative number is undefined.
     * If the number is zero, it returns 0 as the sum of digits of 0 is 0.
     * @param number: an integer
     * @return sum of digits in number, or -1 if number is negative, or 0 if number is zero.
     */
    public int getSumOfDigits(int number) {
        if (number == 0) {
            return 0;
        }
    
        if (number < 0) {
            return -1; 
        }
 
      
        int sumOfDigits = 0;
 
    
        while (number != 0) {
     
            int digit = number % 10;
           
            sumOfDigits += digit;
            
            number /= 10;
        }
 
        return sumOfDigits;
    }
}