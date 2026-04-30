import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FpPractice {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 23, 94, 46, 75, 13, 68, 91, 12);

        List<Integer> squares = numbers.stream()
                .filter(n -> n % 2 == 0) // Filters even numbers
                .map(n -> n * n) // gets their square
                .collect(Collectors.toList()); // adds them to new list

        System.out.println("Even numbers & its square");
        System.out.println(squares);

        List<Integer> cubes = numbers.stream()
                .filter(n -> n % 2 == 1) // Filters odd numbers
                .map(n -> n * n * n) // gets their cube
                .collect(Collectors.toList()); // adds them to new list

        System.out.println("\nOdd numbers & its cubes");
        System.out.println(cubes);

        System.out.println("\nSum of all numbers");
        int sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2); // Sum of all numbers
        System.out.println(sum);

        List<String> words = List.of("Apple", "Bat", "Cat", "Duck");

        System.out.println("\nConverting words to uppercase");
        words.stream().map(w -> w.toUpperCase()).forEach(System.out::println); // Converting words to uppercase

        System.out.println("\nSorted list after removing duplicates");
        List<Integer> sorted = numbers.stream().distinct().sorted().collect(Collectors.toList()); // sorting and
                                                                                                  // removing duplicates
        System.out.println(sorted);

        List<Integer> prime = numbers.stream()
                .filter(n -> n > 1 && IntStream.range(2, n) // iterates from 2 to number in list
                        .allMatch(i -> n % i != 0)) // gives output if all conditions are true
                .collect(Collectors.toList());
        System.out.println("\nPrime numbers in List");
        System.out.println(prime);

        List<Integer> reverseList = numbers.stream()
                // .distinct() // to remove dupplicates
                .sorted((a, b) -> b - a) // reversing list
                .collect(Collectors.toList());
        System.out.println("\nSorted reverse list");
        System.out.println(reverseList);
    }
}
