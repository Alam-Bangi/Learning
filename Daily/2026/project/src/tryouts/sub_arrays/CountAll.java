package tryouts.sub_arrays;

public class CountAll {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        long n = arr.length;
        long count = n * (n + 1) / 2;

        System.out.println("Count = " + count);
    }
}
