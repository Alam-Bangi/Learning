package tryouts.searching;

public class SentinelSearch {
    public static void main(String[] args) {
        int[] data = {10, 25, 4, 85, 52, 12, 43, 37, 6};
        int target = 12;

        int result = sentinelSearch(data, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
    public static int sentinelSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;

        int lastElement = arr[n - 1];
        arr[n - 1] = target;

        int i = 0;
        while (arr[i] != target) {
            i++;
        }
        arr[n - 1] = lastElement;
        if ((i < n - 1) || (arr[n - 1] == target)) {
            return i;
        }
        return -1;
    }
}
