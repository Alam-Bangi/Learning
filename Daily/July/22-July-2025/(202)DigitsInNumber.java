```

// Coding Exercise: Find Number of Digits in a Number
// In this problem, you are tasked with completing the implementation of a NumberUtils class in Java that calculates the number of digits in a given integer.

// The number of digits in an integer is the count of digits present. For example, the number 12345 has 5 digits, and the number 90 has 2 digits.

// If the input number is 0, return 1 as 0 is considered to have one digit.

// If the input number is negative, return -1 as the count of digits for negative numbers will not be considered in this problem.

// Here is the skeleton of the NumberUtils class:

// public class NumberUtils {
 
//     /**
//      * This method calculates and returns the number of digits in a given integer.
//      * If the number is negative, it returns -1.
//      * If the number is zero, it returns 1 as zero is considered to have one digit.
//      * @param number: an integer
//      * @return number of digits in number, or -1 if number is negative, or 1 if number is zero.
//      */
//     public int getNumberOfDigits(int number) {
//         // Write your code here
        
//     }
    
// }
// Task

// Your task is to implement the getNumberOfDigits(int number) method in the NumberUtils class.

// getNumberOfDigits(int number) - This method will take one parameter, number (an integer), and it should calculate the number of digits in this number. If the input number is negative, it should return -1.

// Concepts to know

// Division(/): Division in programming is similar to normal mathematical division. If you divide an integer by 10, it will remove the last digit of the number.

// For example,

// 12345 / 10 = 1234

// 90 / 10 = 9

// While Loop: The while loop is used to execute a block of code repeatedly until a given condition is met.

// Examples

// Here are some examples of how your NumberUtils class should behave once implemented:

// NumberUtils utils = new NumberUtils();
 
// System.out.println(utils.getNumberOfDigits(12345)); // Output: 5
// System.out.println(utils.getNumberOfDigits(90));    // Output: 2
// System.out.println(utils.getNumberOfDigits(9));     // Output: 1
// System.out.println(utils.getNumberOfDigits(0));     // Output: 1
// System.out.println(utils.getNumberOfDigits(-67));   // Output: -1
// In the above examples, the number of digits for each number is calculated as described, and -1 is returned for the negative input.

// Good luck!

```

class NumberUtils {
 
    /**
     * This method calculates and returns the number of digits in a given integer.
     * If the number is negative, it returns -1.
     * If the number is zero, it returns 1 as zero is considered to have one digit.
     * @param number: an integer
     * @return number of digits in number, or -1 if number is negative, or 1 if number is zero.
     */
    public int getNumberOfDigits(int number) {
        if (number == 0) {
            return 1; 
        }
        if (number < 0) {
            return -1; 
        }
 
        int numberOfDigits = 1; 
 
        // Step 3: Count the digits
        while (number >= 10) {
            number /= 10; 
            numberOfDigits++; 
        }
 
        return numberOfDigits;
    }
}