import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class FindTwoNumbersForSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int size = sc.nextInt();

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            System.out.println();
        }

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            int checkNumbers = target - numbers[i];

            if (set.contains(checkNumbers)) {
                System.out.println("Pair found!");
                System.out.println("Numbers: " + checkNumbers + " and " + numbers[i]);
            }
            set.add(numbers[i]);
        }

        if (set.isEmpty()) {
            System.out.println("No pair found");
        }
        sc.close();
    }
}
