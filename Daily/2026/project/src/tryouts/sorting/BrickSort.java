package tryouts.sorting;

import java.util.Arrays;

public class BrickSort {
    public static void main(String[] args) {
        int[] data = {34, 2, 10, -9, 45, 0, 11};

        System.out.println("Original array: " + Arrays.toString(data));
        brickSort(data);
        System.out.println("Sorted array:   " + Arrays.toString(data));
    }
    public static void brickSort(int[] arr) {
        boolean isSorted = false;
        int n = arr.length;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < n - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            for (int i = 0; i < n - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
