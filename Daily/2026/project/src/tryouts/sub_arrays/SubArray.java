package tryouts.sub_arrays;

import java.util.*;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        List<int[]> subarrays = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int[] sub = new int[j - i + 1];

                for (int k = i; k <= j; k++) {
                    sub[k - i] = arr[k];
                }
                subarrays.add(sub);
            }
        }
        for (int[] sub : subarrays) {
            System.out.println(Arrays.toString(sub));
        }
    }
}