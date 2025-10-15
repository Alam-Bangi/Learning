/*  

// Coding Exercise: Count uppercase letters in a String
// Your task is to complete a Java method called countUppercaseLetters. This method takes a string as input and returns the number of uppercase letters present in that string. The method is part of a class named StringMagic.

// Remember to consider the following edge cases:

// If the string is empty, the method should return 0.

// If the string does not contain any uppercase letters, the method should also return 0.

// Here is the starting code you're given:

// public class StringMagic {
    
//     public int countUppercaseLetters(String str) {
//         // TODO: Write your code here
//     }
// }

// Helpful Methods to Solve the Problem

// The charAt(int index) method of the String class can be used to get a character at a specific index.

// The isUpperCase(char ch) static method of the Character class can be used to check if a character is an uppercase letter.

// Example

// In this example, the string "Hello WORLd" contains 5 uppercase letters ("H", "W", "O", "R", "L"), so the method countUppercaseLetters returns 5.

// StringMagic stringMagic = new StringMagic();
// int uppercaseLetters = stringMagic.countUppercaseLetters("Hello WORLd");
// System.out.println(uppercaseLetters); // This will print 5

// Best of luck!

*/


class StringMagic {
    
    /**
     * This method counts the number of uppercase letters in a given string.
     *
     * @param str The string to count uppercase letters in.
     * @return The number of uppercase letters in the string.
     */
    public int countUppercaseLetters(String str) {
        int count = 0;
        
        if (str.isEmpty()) {
            return count;
        }
 
        for (int i = 0; i < str.length(); i++) {
            
            char c = str.charAt(i);
            
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        
        return count;
    }
}