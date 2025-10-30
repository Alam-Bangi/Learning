/**
Coding Exercise: Sum of Squares
You have to implement a function named sumOfSquares in the class FunctionalProgrammingMagic which takes a list of integers as input and returns the sum of squares of these integers.

Please consider the following edge conditions:

If the input list is null, your function should return 0.



Examples

Let's consider the following examples:

Example 1:

Input:

List<Integer> numbers = List.of(1, 2, 3);
Output:

long sum = sumOfSquares(numbers);
System.out.println(sum); // Prints: 14
Example 2:

Input:

List<Integer> numbers = null;
Output:

long sum = sumOfSquares(numbers);
System.out.println(sum); // Prints: 0
Example 3:

Input:

List<Integer> numbers = List.of();
Output:

long sum = sumOfSquares(numbers);
System.out.println(sum); // Prints: 0


Notes

The stream() method is used to create a stream of elements from a collection.

The mapToLong() method is a special version of the map() method. It produces an LongStream (a stream of long values) and takes a function that transforms an object into an int.

The sum() method calculates the sum of numbers in the stream.



These are very powerful methods in Java's Stream API, allowing us to perform complex data processing queries on collections of objects. The use of these methods can greatly simplify your code.
*/

import java.util.List;

class FunctionalProgrammingMagic {

    public static long sumOfSquares(List<Integer> numbers) {
        
        // Check if the list is null. If so, return 0.
        if(numbers==null) {
            return 0;
        }

        // Stream over the list of numbers, find squares and sum them up
        return numbers.stream().mapToLong(e -> e*e).sum();
    }
}