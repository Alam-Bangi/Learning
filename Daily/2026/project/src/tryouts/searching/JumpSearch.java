package tryouts.searching;

public class JumpSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int index = jumpSearch(arr, 80);
        if(index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Found at index: " + index);
        }
    }
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int jump = (int) Math.sqrt(n);
        int step = jump;
        int prev = 0;

        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += jump;
        }
        while (prev < Math.min(step, n)) {
            if (arr[prev] == target) {
                return prev;
            }
            prev++;
        }
        return -1;
    }
}
