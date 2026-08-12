package tryouts.functional_programming;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 20, 40, 50, 30, 60, 70, 80);

//        Filter
        List<Integer> filtered = numbers.stream()
                .filter(n -> n > 30)
                .collect(Collectors.toList());

        System.out.println("Filtered: " + filtered);

//        Remove Duplicates
        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct: " + distinct);

//        Sort
        List<Integer> sorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted: " + sorted);

//        Sort descending
        List<Integer> descending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Descending: " + descending);

//        Get Max
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);

        System.out.println("Max: " + max.orElse(0));

//        Get Min
        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);

        System.out.println("Min: " + min.orElse(0));

//        Reduce
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);

//        Boxed
        List<Integer> boxedNumbers = numbers.stream()
                .mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Boxed: " + boxedNumbers);

//        All in one
        List<Integer> result = numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n > 20)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Final Result: " + result);

        int filteredSum = numbers.stream()
                .filter(n -> n > 20)
                .distinct()
                .reduce(0, Integer::sum);

        System.out.println("Filtered Sum: " + filteredSum);
    }
}