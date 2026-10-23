package tryouts.sub_arrays;

public class SumOfSubArrayWithFixedLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int left = 0;
        int right = 2;

        while (right < arr.length) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            System.out.println("Sum = " + sum);
            left++;
            right++;
        }
    }
}