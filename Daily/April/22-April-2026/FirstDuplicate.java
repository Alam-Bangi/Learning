import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class FirstDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements: ");
        int totalElements = sc.nextInt();

        int[] elements = new int[totalElements];
        for (int i = 0; i < totalElements; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            elements[i] = sc.nextInt();
        }

        for (int n : elements) {
            System.out.print(n + " ");
        }
        System.out.println();

        Set<Integer> uniqueValues = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : elements) {
            if (uniqueValues.contains(num)) {
                duplicates.add(num);
                break;
            }
            uniqueValues.add(num);
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found!!!");
        } else {
            System.out.println("First duplicate: " + duplicates.get(0));
        }

        sc.close();
    }
}
