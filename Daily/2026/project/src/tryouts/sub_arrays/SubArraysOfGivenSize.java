package tryouts.sub_arrays;

public class SubArraysOfGivenSize {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int n = arr.length;

        if (k <= 0 || k > n) {
            System.out.println("Invalid K");
            return;
        }

        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}