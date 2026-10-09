package tryouts.searching;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] ele = new int[1000];
        int target = 786;

        for (int i = 0; i < ele.length; i++) {
            ele[i] = i;
        }

        int index = fibonacciSearch(ele, target);
        if (index == -1) {
            System.out.println(target + " not found");
        } else {
            System.out.println("Element found at index: " + index);
        }
    }

    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;

        int fibM2 = 0;
        int fibM1 = 1;
        int fibM = fibM2 + fibM1;

        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;
        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);

            if (arr[i] < target) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i;
            }
        }
        if (fibM1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            System.out.println("Inspecting index: " + (offset + 1) + " | Value: " + arr[offset + 1]);
            return offset + 1;
        }
        return -1;
    }
}
