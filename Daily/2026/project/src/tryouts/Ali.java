package tryouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Ali {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,4,7,10,9,8,5};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        int no = 0;

        for (int a = 0; a < arr.length; a++) {
            for(int k = a + 1; k < arr.length; k++) {
                if(arr[a] > arr[k]) {
                    no = arr[a];
                    arr[a] = arr[k];
                    arr[k] = no;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}