import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class MissingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int n : numbers) {
            uniqueNumbers.add(n);
        }

        List<Integer> missingNumbers = new ArrayList<>();
        System.out.println("Enter total range: ");
        int range = sc.nextInt();
        for (int i = 1; i <= range; i++) {
            if (!uniqueNumbers.contains(i)) {
                missingNumbers.add(i);
            }
        }
        if (missingNumbers.isEmpty()) {
            System.out.println("No missing numbers");
        } else {
            System.out.println("Missing numbers: " + missingNumbers);
        }
        sc.close();
    }
}
