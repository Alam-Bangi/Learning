```

// Coding Exercise: GCD of a Number
// In this assignment, you are given an incomplete Java program, BiNumber, that is meant to calculate the Greatest Common Divisor (GCD) of two integers. The GCD of two numbers is the largest number that divides both of them without leaving a remainder.

// The BiNumber class is already defined with two private fields, number1 and number2, which represent the two integers. The constructor for creating a new BiNumber and getter methods for number1 and number2 are also provided.

// Your task is to complete the calculateGCD() method, which should return the GCD of number1 and number2.

// What is GCD?

// GCD of two numbers can be found by:

// Making a list of all positive integers that can divide each of the numbers.

// Finding the greatest number that appears in both lists.

// For instance, if we want to find the GCD of 48 and 18:

// The divisors of 48 are: 1, 2, 3, 4, 6, 8, 12, 16, 24, 48.

// The divisors of 18 are: 1, 2, 3, 6, 9, 18.

// The common divisors are: 1, 2, 3, 6.

// Hence, the GCD is 6.

// Similarly, to find the GCD of 20 and 15:

// The divisors of 20 are: 1, 2, 4, 5, 10, 20.

// The divisors of 15 are: 1, 3, 5, 15.

// The common divisors are: 1, 5.

// Hence, the GCD is 5.

// Examples

// Here are some examples of how your calculateGCD method should work:

// BiNumber binum = new BiNumber(48, 18);
// System.out.println(binum.calculateGCD()); // Output: 6
 
// binum = new BiNumber(0, 5);
// System.out.println(binum.calculateGCD()); // Output: 0
 
// binum = new BiNumber(-4, 2);
// System.out.println(binum.calculateGCD()); // Output: 1
// Implementation Guide

// The calculateGCD() method should handle edge cases first:

// If either number1 or number2 is zero, the method should immediately return 0, since the GCD of 0 and any other number is 0.

// If either number1 or number2 is negative, the method should immediately return 1, as the GCD for negative numbers is 1.

// If number1 equals number2, the method should immediately return number1 (or number2), as the GCD of two equal numbers is the number itself.

// Next, implement the logic for finding the GCD. Easiest way is to find the smaller of two numbers. Create a loop from the smaller number down upto 1 and for each number, check if it divides both number1 and number2. The first number that meets this criteria is the GCD.

// Finally, the method should return the GCD.

// Good Luck :)

```

class BiNumber {
    private int number1;
    private int number2;
 
    /**
     * Constructor that initializes the two numbers.
     * @param number1: The first number.
     * @param number2: The second number.
     */
    public BiNumber(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
 
    /**
     * Getter for the first number.
     * @return the first number.
     */
    public int getNumber1() {
        return number1;
    }
 
    /**
     * Getter for the second number.
     * @return the second number.
     */
    public int getNumber2() {
        return number2;
    }
 
    /**
     * Calculates and returns the greatest common divisor (GCD) of the two numbers.
     * Edge case: If either number is negative, returns 1 as the GCD for negative numbers is 1.
     * Edge case: If either number is zero, returns 0 as the GCD of 0 and any other number is 0.
     * Edge case: If two numbers are equal, returns the number as the GCD of two equal numbers is the number itself.
     * @return GCD of the two numbers, or 1 if either number is negative, or 0 if either number is zero.
     */
    public int calculateGCD() {
        if (number1 == 0 || number2 == 0) {
            return 0; // GCD of 0 and any other number is 0
        }
        if (number1 < 0 || number2 < 0) {
            return 1; // GCD of negative numbers is 1
        }
        if (number1 == number2) {
            return number1; 
        }
 
        int smallerNumber = Math.min(number1, number2); 
        for (int i = smallerNumber; i >= 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                return i;
            }
        }
 
        return 1;
    }
}

