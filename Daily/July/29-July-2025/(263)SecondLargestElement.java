/*

Coding Exercise: Find Second Largest Element
In this programming challenge, you are given an incomplete Java method named findSecondLargestElement(int[] array) in the class ArrayMagic.

This method takes an array of integers and returns the second largest element in that array.

If there are fewer than two distinct elements in the array, the method should return -1.

For instance, if all elements are the same or the array contains only one element, there is no second largest element, so the method should return -1.

Instructions

Begin by understanding the existing structure of the findSecondLargestElement(int[] array) method. You can see that it takes an integer array as an argument and its return type is an integer.

You need to implement the logic to find the second largest number in the array. If there is no second largest number (for example, if all the elements are the same or if the array has less than two elements), return -1.

If there are two or more distinct elements, you need to find the second largest one. For this, iterate over the array, comparing each element with the currently largest and second largest elements. Remember to initialize these two tracking variables properly.

Finally, return the second largest element or -1 if there is no second largest element.

Consider edge cases.

For example, what happens if all the elements in the array are the same?

What if the array contains fewer than two elements?

Example

Example 1:

Input: [5, 7, 9, 2, 4, 9]

Output: 7

Example 2:

Input: [1, 1, 1, 1]

Output: -1

Example 3:

Input: [7]

Output: -1

Remember: Coding is about breaking down problems into manageable parts. Keep calm and code on!

Considerations

You must consider the following situations when implementing your solution:

The array may contain duplicate elements.

The array could include positive or negative numbers, or zero.

If the array contains fewer than two unique elements, there is no "second largest" element, and your method should return -1.

*/

class secondLargestElement {
    
    /**
     * This method finds and returns the second largest element in the given array.
     * 
     * @param array the array in which to find the second largest element
     * @return the second largest element in the array
     */
     
    public int findSecondLargestElement(int[] array) {
 
        if (array.length < 2) {
            return -1;  
        }
 
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
 
        for (int element : array) {
            if (element > largest) {
                secondLargest = largest;
                largest = element;
            } else if (element > secondLargest && element != largest) {
                secondLargest = element;
            }
        }
 
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
 
        return secondLargest;
    }
}
