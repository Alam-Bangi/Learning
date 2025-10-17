/*

Coding Exercise: Reverse an Array
In this task, your goal is to complete a method called reverseArray(int[] array) in the ArrayMagic Java class.

This method should take an array of integers and return an array that holds the elements of the input array, but in the reverse order.

Instructions

Your task is to implement the reverseArray method. To achieve this, you need to:

Define two pointers. Let's call them start and end. The start pointer should point to the first element of the array, while the end pointer should point to the last one.

Create a new array to store the reversed elements. You can call this array reversedArray.

Iterate over the input array starting from both ends (start and end) and moving towards the middle. During each iteration, you should:

Copy the element at the end index of the input array to the start index of reversedArray.

Copy the element at the start index of the input array to the end index of reversedArray.

Move the start pointer one step towards the end of the array.

Move the end pointer one step towards the beginning of the array.

Once all elements of the input array have been processed, reversedArray should hold the elements of the input array in reverse order. At this point, the method should return reversedArray.

Edge Cases

The reverseArray method should be able to handle a few edge cases:

If the input array is empty (i.e., its length is 0), the method should return an empty array.

If the input array contains only one element, the method should return the array back.

Examples

Let's illustrate how the reverseArray method should work with a few examples:

Example 1:
Input: [1, 2, 3, 4]
Output: [4, 3, 2, 1]
Explanation: The input array contains four elements. The reversed array should hold these elements in the opposite order.

Example 2:
Input: [5, -10, 15, -20]
Output: [-20, 15, -10, 5]
Explanation: The input array contains four elements, including positive and negative numbers. The reversed array should hold these elements in the opposite order.

Example 3:
Input: [100, 200, 300, 400, 500]
Output: [500, 400, 300, 200, 100]
Explanation: The input array contains five elements. The reversed array should hold these elements in the opposite order.

Good luck!

 */

class ArrayReversed {
 
    /**
     * This method reverses an array.
     * 
     * @param array the array to reverse
     * @return a new array with elements in reverse order
     */
    public int[] reverseArray(int[] array) {
 
        if (array.length <= 1) {
            return array;
        }
        
        int start = 0;
        int end = array.length - 1;
 
        int[] reversedArray = new int[array.length];
 
        while (start <= end) {
            reversedArray[start] = array[end];
            reversedArray[end] = array[start];
 
            start++;
            end--;
        }
 
        return reversedArray;
    }
}
