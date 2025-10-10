```

// Coding Exercise: Reverse a Number
// In this exercise, you are required to complete the method reverseNumber in the NumberUtils class.

// This method takes an integer as input and returns the reversed version of the number. For instance, if the input is 123, the method should return 321.

// The method handles two edge cases:

// If the input number is zero, the method returns 0 since the reverse of 0 is 0.

// If the input number is negative, the method returns -1 since the reverse of a negative number is undefined.

// The reverseNumber method's signature is as follows:

// public int reverseNumber(int number)
// You are expected to provide the implementation of this method, adhering to the behavior explained above.

// Examples

// reverseNumber(123) should return 321.

// reverseNumber(5497) should return 7945.

// reverseNumber(-456) should return -1 because the reverse of a negative number is undefined.

// reverseNumber(0) should return 0 because the reverse of 0 is 0.

// Solution Clues

// To reverse the number, you can repeatedly extract the last digit and append it to the reversed number.

// You can use the modulo operator % to get the last digit (e.g., number % 10 gives the last digit) and integer division / to remove the last digit from the number (e.g., number /= 10).

```

class ReverseNumber {
 
    /**
     * This method reverses a given integer and returns the reversed number.
     * If the number is negative, it returns -1 as the reverse of a negative number is undefined.
     * If the number is zero, it returns 0 as the reverse of 0 is 0.
     * @param number: an integer
     * @return reversed number, or -1 if number is negative, or 0 if number is zero.
     */
    public int reverseNumber(int number) {

        if (number == 0) {
            return 0; 
        }

        if (number < 0) {
            return -1; 
        }
 
        int reversedNumber = 0;
 
        while (number != 0) {
            int digit = number % 10;
            
            reversedNumber = reversedNumber * 10 + digit;
            
            number /= 10;
        }
 
        return reversedNumber;
    }
}