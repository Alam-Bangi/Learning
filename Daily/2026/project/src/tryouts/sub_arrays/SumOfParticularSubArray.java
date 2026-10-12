package tryouts.sub_arrays;

public class SumOfParticularSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int left = 1;
        int right = 3;
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }

        System.out.println("Sum = " + sum);
    }
}