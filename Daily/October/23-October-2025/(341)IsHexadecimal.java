/**
 Coding Exercise - Is Hexadecimal String?
In this problem, you are given a class MyString with a String variable str and two methods: isHexadecimalChar(char ch) and isHexadecimal().

You have to complete these methods.

A string is considered to be a valid hexadecimal if it only contains digits (0-9) and letters A-F (case-insensitive).

The isHexadecimalChar(char ch) method should return true if the character is a valid hexadecimal character (A-F or a-f) and false otherwise.

The isHexadecimal() method should return true if the string str is a valid hexadecimal string and false otherwise.

Edge Conditions

The isHexadecimal() method should return false for an empty string and for a null string.

The isHexadecimalChar(char ch) method should handle both upper and lower case characters.

Examples

"123F" => true "A23g" => false.

Notes

The Character.isDigit(char ch) method checks if a character is a digit.

The String.toCharArray() method converts a string to a character array.

The relational operators >= and <= are used to check if a character is within a certain range.

Be aware of the difference between lower case and upper case characters in ASCII. 'a'-'f' and 'A'-'F' are two distinct ranges.
*/

class isHexadecimal {

    public String str;

    public isHexadecimal(String str) {
        this.str = str;
    }
    
    public boolean isHexadecimalChar(char ch) {
        return (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f');
    }
 
    public boolean isHexadecimal() {
        if (str == null || str.length() == 0) {
            return false;
        }
 
        for (char ch : str.toCharArray()) 
            if (!Character.isDigit(ch) && !isHexadecimalChar(ch)) {
                return false;
            }
        return true;
    }
 
}
