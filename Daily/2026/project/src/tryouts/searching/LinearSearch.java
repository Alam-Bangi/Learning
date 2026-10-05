package tryouts.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] elements = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        
        int index = linearSearch(elements, 10);
        if(index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }

    private static int linearSearch(int[] arr, int value) {
        for(int i = 0; i< arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
