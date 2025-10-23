/**
 
Coding Exercise - Anagram Checker
You are given two strings str1 and str2. Your task is to determine if str1 and str2 are anagrams of each other.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. For example, the word "listen" is an anagram of "silent", "hello" and "olelh" are anagrams.

You need to implement the areAnagrams(String str1, String str2) method of the StringMagic class, which returns true if str1 and str2 are anagrams of each other, and false otherwise.

Edge conditions:

The comparison should be case insensitive. That is, "Listen" and "Silent" should be considered anagrams.

If either str1 or str2 is null, the method should return false.

The method should also return false if the lengths of str1 and str2 are not the same.

Input format

The method takes in two parameters:

str1 - A String

str2 - A String

Output Format

The method should return:

true - If str1 and str2 are anagrams.

false - If str1 and str2 are not anagrams.

Instructions

To check whether two strings are anagrams:

Convert the strings to lowercase.

Check if the lengths of the strings are different. If so, return false.

Convert the strings to character arrays.

Sort the character arrays.

If the sorted arrays are equal, return true. Otherwise, return false.

Java Library Methods

Few methods would be helpful for you:

string.toLowerCase() - Converts all of the characters in this String to lower case.

string.toCharArray() - Converts this string to a new character array.

Arrays.sort(charArray) - Sorts the specified array into ascending numerical order.

Arrays.equals(charArray1, charArray2) - Returns true if the two specified arrays of chars are equal to one another.

These methods are very helpful for solving this problem, and you are encouraged to use them in your implementation.

*/

import java.util.Arrays;

class AnagramChecker {

    public boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
 
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
 
        if (str1.length() != str2.length()) {
            return false;
        }
 
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
 
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
 
        return Arrays.equals(charArray1, charArray2);
    }
}
