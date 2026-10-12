package tryouts.sub_arrays;

public class SumOfSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 3, 5};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.println("\nSum: " + sum);
            }
        }

        SubArrayWithSum(arr);
    }
    public static void SubArrayWithSum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                System.out.println(
                        "Subarray [" + i + ".." + j +
                                "], Sum = " + sum
                );
            }
        }
    }
}