/** 
Coding Exercises: Length of Course Names
In this problem, you are required to complete the getCourseNameCharacterCount() function inside the FunctionalProgrammingMagic class. This function receives a list of course names and returns a list of the character counts of each course name.



Edge Conditions:

The input list can be null. Even in that case, the function should return an empty list.



Examples

Consider the following examples for a better understanding of the problem:

Example 1

Input:

List<String> courses = List.of("Math", "English", "History", "Physics");

Output:

List<Integer> result = List.of(4, 7, 7, 7);

Example 2

Input:

List<String> courses = List.of(); (An empty list)

Output:

List<Integer> result = List.of(); (An empty list)

Example 3

Input:

List<String> courses = null; (A null list)

Output:

List<Integer> result = List.of(); (An empty list)



Notes

The stream() function is used to create a sequence of elements (a stream) from a list.

The map() function is used to apply a given function to each element in a stream.

The String::length method reference is used to get the length of each string.

The collect() function is used to get the result from a stream. Collectors.toList() is a collector that accumulates the input elements into a new List.
*/

import java.util.List;
import java.util.stream.Collectors;

class FunctionalProgrammingMagic {

    public static List<Integer> getCourseNameCharacterCount(List<String> courses) {
        // TODO: Write code
        if(courses==null) {
            return List.of();
        }
        return courses.stream().map(String::length).collect(Collectors.toList());
    }
}