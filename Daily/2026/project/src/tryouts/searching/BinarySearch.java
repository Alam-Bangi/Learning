package tryouts.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ele = new int[1000];
        int target = 786;

        for (int i = 0; i < ele.length; i++) {
            ele[i] = i;
        }

        int index = binarySearch(ele, target);
        if(index == -1) {
            System.out.println(target +  " not found");
        } else {
            System.out.println("Element found at index: " + index);
        }
        System.out.println(index);

    }
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = arr[middle];

            System.out.println("Middle: " + value);

            if(value < target) low = middle + 1;
            else if(value > target) high = middle -1;
            else return middle;
        }
        return -1;
    }
}
