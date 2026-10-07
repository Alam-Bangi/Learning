package tryouts.sorting;

import java.util.Arrays;

class InsertionSort {
    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6};

        System.out.println("Before Sorting: " + Arrays.toString(data));

        insertionSort(data);
        System.out.println("After Sorting:  " + Arrays.toString(data));
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
