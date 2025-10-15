/* 

Coding Exercise: Does a String have two consecutive identical characters
Your task is to complete a method hasConsecutiveDuplicates inside the class StringMagic. This method should check if a given string contains any two consecutive identical characters.

The method signature is as follows:

public boolean hasConsecutiveDuplicates(String str);
Where:

str is a String of length n (0 ≤ n ≤ 1000). The string may contain any printable ASCII characters.

The method should return true if there are two consecutive identical characters in the string and false otherwise.

Examples

Here are some examples to illustrate the behavior of the hasConsecutiveDuplicates method.

Consider the string "Hello". Your method should return true because there are two consecutive 'l' characters.

For the string "World", your method should return false because there are no two consecutive identical characters.

For an empty string "", your method should return false.

For a string with a single character "H", your method should return false.

For a string with multiple identical characters "HHH", your method should return true because there are more than one consecutive 'H' characters.

*/

class StringMagic {
 
    /**
     * This method checks if a given string has two consecutive identical characters.
     *
     * @param str The string to check for consecutive duplicates.
     * @return true if the string has consecutive duplicates, false otherwise.
     */
    public boolean hasConsecutiveDuplicates(String str) {
        
        if (str.isEmpty() || str.length() == 1) {
            return false;
        }
 
        for (int i = 0; i < str.length() - 1; i++) {

            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);
            
            if (currentChar == nextChar) {
                return true;
            }
        }
        
        return false;
    }
}