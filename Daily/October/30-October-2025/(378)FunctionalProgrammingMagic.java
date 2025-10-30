/** 
Coding Exercise: Find Max Even Number
In this task, you are given a list of integers. Your task is to complete the function findMaxEvenNumber, which returns the maximum even number from the list. If the list is null or doesn't contain any even numbers, return 0.



Edge Conditions

The list can be null. In this case, return 0.

The list can be empty. Again, return 0.

The list can contain all odd numbers. Return 0 in this case too.

The list can contain negative numbers as well. In this case, consider them while finding the maximum even number.



Examples

Let's take a few examples to understand the problem and the solution.

Example 1:

Input: [23, 45, 67, 12, 34, 56, 78]

Output: 78

Example 2:

Input: [1, 3, 5, 7, 9]

Output: 0

Example 3:

Input: null

Output: 0



Notes

stream(): This is a function in the Java Collection interface. It returns a sequential stream of the elements in the collection. A stream is a sequence of elements that can be processed in parallel or sequentially.

filter(): This is a function in the Java Stream interface. It takes a Predicate (a lambda function that returns a boolean) and returns a new stream that includes all elements for which the Predicate returned true.

max(): This is another function in the Java Stream interface. It takes a Comparator and returns the maximum element of the stream according to the provided Comparator, wrapped in an Optional.

Optional: This is a container object that may or may not contain a non-null value. If a value is present, isPresent() returns true. If not, the object is considered empty and isPresent() returns false. An Optional can be used to avoid NullPointerException.

orElse(): This is a function in the Java Optional class. It returns the value if present,

otherwise returns the default value passed as an argument.

Integer::compare: This is a method reference in Java. It refers to the static method compare in the Integer class, which compares two integers numerically. The :: is a token in Java that is used to reference a method or constructor.
*/

import java.util.List;
import java.util.Optional;

class FunctionalProgrammingMagic {

    public static int findMaxEvenNumber(List<Integer> numbers) {
        // Write your code here 
        if(numbers==null) {
            return 0;
        }
        return numbers.stream().filter(e -> e%2==0).max(Integer::compare).orElse(0);
    }
}