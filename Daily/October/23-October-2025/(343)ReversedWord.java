/** 
Coding Exercise - Word Reverser
In this exercise, you are required to write a Java method called reverseWordsInSentence within the provided StringMagic class.

The method should take a string sentence as input and return a string in which each word in the sentence is reversed while maintaining the original word order.

Edge conditions:

If the input string is null, your method should return the string "INVALID".

If the input string is empty (i.e., ""), your method should return an empty string.

Input Format

A single string which is a sentence.

Output Format

A string in which each word in the sentence is reversed while maintaining the original word order.

Examples

Let's take a look at some examples:

Example 1

Input:

StringMagic sm = new StringMagic();
sm.reverseWordsInSentence("Hello World");
Return Value:

"olleH dlroW"
Example 2

Input:

StringMagic sm = new StringMagic();
sm.reverseWordsInSentence("");
Return Value:

""
Example 3

Input:

StringMagic sm = new StringMagic();
sm.reverseWordsInSentence(null);
Return Value:

"INVALID"
Notes

In the solution, we have used a few methods and classes from the Java standard library. Here's a brief overview:

string.split(String regex): This method splits the string around matches of the given regular expression.

stringBuilder:  It is more efficient to use StringBuilder for string manipulation operations than String.

stringBuilder.reverse(): This method reverses the sequence of characters in the StringBuilder

stringBuilder.append(String str): This method appends the specified string to the sequence.

string.trim(): This method returns a copy of the string, with leading and trailing white space omitted.

Good luck!
*/

class ReversedWord {

    public String reverseWordsInSentence(String sentence) {
        if(sentence==null) {
            return "INVALID";
        }
        if(sentence=="") {
            return "";
        }
        StringBuilder reversedSentence = new StringBuilder();
        
        for (String word : sentence.split(" ")) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            reversedSentence.append(reversedWord).append(" ");
        }
        return reversedSentence.toString().trim();
    }
}
