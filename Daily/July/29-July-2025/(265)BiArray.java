/*

Coding Exercise: Are Sum of Arrays Equal
In the class BiArray, you are given two integer arrays.

Your task is to write a method to compare the sum of these two arrays and determine if they are equal.

You are also required to write a method to calculate the sum of the elements of an array.

Instructions

Complete the following methods in the BiArray class:

calculateSum(int[] array): This method should calculate and return the sum of the elements in the provided array. Use a for-each loop to iterate over each element in the array and add it to a sum variable. At the end of the loop, return the sum.

areSumsEqual(): This method should compare the sum of array1 and array2 and return true if they are equal, and false otherwise. Use the calculateSum(int[] array) method to calculate the sum of array1 and array2.

Examples

Example 1:

Consider array1 as [1, 2] and array2 as [4, -2, 1]. sum1 is 3 and sum2 is also 3. Method should return true.

Example 2:

Consider array1 as [5, 10, 15] and array2 as [1, 9, 20]. sum1 is 30 and sum2 is also 30. Method should return true.

Example 3:

Consider array1 as [-1, -1, -1] and array2 as [-2, 1]. sum1 is -3 and sum2 is -1. Method should return false.

*/

class BiArray {
 
    private int[] array1;
    private int[] array2;
 
    public BiArray(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }
 
    public boolean areSumsEqual() {
 
        int sum1 = calculateSum(array1);
        int sum2 = calculateSum(array2);
 
        return sum1 == sum2;
    }
 
    private int calculateSum(int[] array) {
 
        int sum = 0; 
        for (int num : array) {
            sum += num;
        }
 
        return sum;
    }
}
