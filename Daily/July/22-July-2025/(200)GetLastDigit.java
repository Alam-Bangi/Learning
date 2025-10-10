```

// Coding Exercise: Find Last Digit Of A Number
// In this problem, you are tasked with completing the implementation of a NumberUtils class in Java that retrieves the last digit of a given integer.

// The last digit of an integer n is the rightmost digit of the integer. For instance, the last digit of 2345 is 5, and the last digit of 90 is 0.

// If the input number is 0, return 0 as the last digit of 0 is 0. If the input number is negative, return -1 as the last digit of negative numbers will not be considered in this problem.

// Here is the skeleton of the NumberUtils class:

// public class NumberUtils {
 
//     public int getLastDigit(int number) {
//         // Write your code here
//     }
// }
// Task

// Your task is to implement the getLastDigit(int number) method in the NumberUtils class.

// getLastDigit(int number) - This method will take one parameter, number (an integer), and it should retrieve the last digit of this number. If the input number is negative, it should return -1.

// Examples

// Here are some examples of how your NumberUtils class should behave once implemented:

// NumberUtils utils = new NumberUtils();
 
// System.out.println(utils.getLastDigit(1234));   // Output: 4
// System.out.println(utils.getLastDigit(90));     // Output: 0
// System.out.println(utils.getLastDigit(9));      // Output: 9
// System.out.println(utils.getLastDigit(0));      // Output: 0
// System.out.println(utils.getLastDigit(-67));    // Output: -1
// In the above examples, the last digit of each number is retrieved as described, and -1 is returned for the negative input.

// Good luck!

```

class GetLastDigit {
 
    public int getLastDigit(int number) {
        if (number == 0) {
            return 0;
        }
       
        if (number < 0) {
            return -1;
        }
 
        int lastDigit = number % 10;
 
        return lastDigit;
    }
}