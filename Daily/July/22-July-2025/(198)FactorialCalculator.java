```

// Coding Exercise: Calculate Factorial Of a Number
// In this problem, you are tasked with completing the implementation of a FactorialCalculator class in Java that calculates the factorial of a given number.

// The factorial of a non-negative integer n, denoted by n!, is the product of all positive integers less than or equal to n. The factorial function can be defined by the product:

// n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1

// For example,

// 4! = 4 * 3 * 2 * 1 = 24

// 3! = 3 * 2 * 1 = 6

// 2! = 2 * 1 = 2

// 1! = 1

// 0! is defined to be 1

// If the input is negative, return -1 as the factorial for negative numbers is undefined.

// Here is the skeleton of the FactorialCalculator class:

// public class FactorialCalculator {
 
//     public int calculateFactorial(int number) {
//         // Write your code here
//     }
// }
// Task

// Your task is to implement the calculateFactorial(int number) method in the factorialCalculator class.

// calculateFactorial(int number) - This method will take one parameter, number (an integer), and it should calculate the factorial of this number. If the input number is negative, it should return -1.

// Examples

// Here are some examples of how your FactorialCalculator class should behave once implemented:

// FactorialCalculator calculator = new FactorialCalculator();
 
// System.out.println(calculator.calculateFactorial(5));    // Output: 120
// System.out.println(calculator.calculateFactorial(4));    // Output: 24
// System.out.println(calculator.calculateFactorial(3));    // Output: 6
// System.out.println(calculator.calculateFactorial(2));    // Output: 2
// System.out.println(calculator.calculateFactorial(1));    // Output: 1
// System.out.println(calculator.calculateFactorial(0));    // Output: 1
// System.out.println(calculator.calculateFactorial(-5));   // Output: -1
// In the above examples, the factorial of each number is computed as described, and -1 is returned for the negative input as the factorial for negative numbers is undefined.

// Good luck!

```

class FactorialCalculator {
    public int calculateFactorial(int number) {
        // If the input is negative, we return -1 as factorial is undefined for negative numbers.
        if (number < 0) {
            return -1;
        }
        
        int factorial = 1;
        
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        
        return factorial;
    }
}
