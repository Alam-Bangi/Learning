/* 

Coding Exercise: Right most Digit in a String
Your task is to complete the method getRightmostDigit in the class StringMagic. This method should take a string as an argument and return the rightmost digit in the string.

Instructions

The method getRightmostDigit takes a string str as its argument. The string can contain any characters, including digits, letters, and special characters.

Your task is to iterate through the string from right to left, checking each character to see if it's a digit.

If you encounter a digit, you should immediately return it as an integer. Note that the digit is represented as a character in the string, so you will need to convert it to an integer before returning it.

If you have checked all the characters in the string and haven't found a digit, you should return -1.

Edge Case: If the string is empty, you should also return -1.

Here are a few methods from the Character class in Java that will be helpful:

Character.isDigit(c): This method takes a character c as its argument and returns true if c is a digit (0-9), and false otherwise.

Character.getNumericValue(c): This method takes a character c as its argument and returns the numeric value of c if it's a digit. If c is not a digit, the method returns a value that's not a digit (this value can be ignored for this problem as we're only interested in digits).

Example

Here's are a few examples to illustrate the problem:

If the input string is "I bought 5 apples, 4 bananas, and 3 oranges", the method should return 3 because 3 is the rightmost digit in the string.

If the input string is "There are no numbers in this string", the method should return -1 because there are no digits in the string.

*/

class StringMagic {
 
    /**
     * This method finds the rightmost digit in a given string.
     *
     * @param str The string to find the rightmost digit in.
     * @return The rightmost digit in the string. If no digit is found, return -1.
     */
    public int getRightmostDigit(String str) {
 
        if (str.isEmpty()) {
            return -1;
        }

        int length = str.length();

        for (int i = length - 1; i >= 0; i--) {
            
            char c = str.charAt(i);

            if (Character.isDigit(c)) {

                return Character.getNumericValue(c);
            }
        }
        return -1;
    }
}