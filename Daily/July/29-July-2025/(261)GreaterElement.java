/*
Coding Exercise: Is There a Greater Element
In this exercise, you are required to complete the implementation of a method doesHaveElementGreaterThan() in the ArrayMagic class.

This method accepts an integer array and a number as input and returns true if there's an element greater than the given number in the array.

If no such element exists, it should return false.



Here's the method signature that you need to implement:

public boolean doesHaveElementGreaterThan(int[] array, int number)


Instructions

Your task is to traverse through the given array and check each element to see if it's greater than the given number.

If you find an element that's greater than the given number, you should immediately return true.

If you traverse the entire array and don't find any element that's greater than the given number, then you should return false.

If the input array is empty, your method should return false.

Java Notes

The for-each loop in Java is used to traverse array or collection elements. The advantage of a for-each loop is that it eliminates the possibility of bugs and makes the code more readable. Here is the general form of the for-each loop:

for (type var : array) 
{
    // code block to be executed
}
Examples

Let's go through an example to see how this method works:

Example 1:

int[] array = {1, 2, 3, 4, 5};
int number = 3;
Here, your method should return true.

Example 2:

int[] array = {1, 2, 3};
int number = 4;
In this case, your method should return false.

*/

class GreaterElement {
    
    /**
     * This method determines whether there's an element greater than a given number in an array.
     *
     * @param array The array to search through.
     * @param number The number to compare with the array elements.
     * @return True if there's an element greater than the given number in the array, false otherwise.
     */
    public boolean doesHaveElementGreaterThan(int[] array, int number) {
 
            if (array.length == 0) {
            return false;
        }
     for (int element : array) {
 
            if (element > number) {
                return true;
            }
        }
        return false;
    }
}
