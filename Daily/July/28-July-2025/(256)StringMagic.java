/* 

Coding Exercise: Longest Word Finder
You have been given an incomplete StringMagic class that contains a method findLongestWord. Your task is to complete this method.

The method should find the longest word in a given sentence. It receives a sentence as a string input and returns the longest word as a string output.

In case the sentence is empty, the method should return an empty string.

Here is the method signature:

public String findLongestWord(String sentence)


Example 1: Consider a sentence: "A quick brown fox jumps over the lazy dog". "quick" is the longest word with a length of 5.

Example 2: Consider a sentence: "Java is an object oriented programming language" function should return "programming".



Note

Make sure to handle edge cases where the sentence might be empty, or have leading or trailing white spaces.

Good luck!

*/

class StringMagic {
 
    /**
     * This method finds the longest word in a given sentence.
     *
     * @param sentence The sentence to find the longest word in.
     * @return The longest word in the sentence. If sentence is empty, return an empty string.
     */
    public String findLongestWord(String sentence) {
 
        if (sentence.isEmpty()) {
            return "";
        }
 
        String[] words = sentence.split(" ");
 
        String longestWord = "";
        int maxLength = 0;
 
        for (String word : words) {
 
            if (word.length() > maxLength) {
                longestWord = word;
                maxLength = word.length();
            }
        }

    return longestWord;
    }
}
