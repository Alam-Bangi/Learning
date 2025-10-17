/* 

Coding Exercise: Check if an Array is Sorted
You are given an incomplete Java method called isSorted() in the class ArrayMagic.

The method takes an integer array as an input and should return true if the array is sorted in ascending order, or false if it is not.

The method should handle the following edge cases:

If the array is empty or only contains one element, the method should return true, as such arrays are considered to be sorted.

The array may contain negative numbers and zero.

The array may contain duplicate elements.

Examples

Let's take the example of the array [1, 2, 3, 4, 5]. If we feed this array to our isSorted() method, it should return true, as the array is sorted in ascending order.

Now, consider an array with the elements [5, 4, 3, 2, 1]. The elements in this array are in descending order. Hence, if we pass this array to our isSorted() method, it should return false.

*/

class IfArraySorted {
 
    public boolean isSorted(int[] array) {
 
        if (array.length <= 1) {
            return true;
        }
 
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
