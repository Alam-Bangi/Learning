package tryouts.functional_programming;

import java.util.*;
import java.util.stream.*;

public class AllStreamOperations {

    public static void main(String[] args) {

        // ============================================================
        // DATA
        // ============================================================

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40, 50, 50, 60);

        List<String> names =
                Arrays.asList("John", "Alice", "Bob", "David");

        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );


        // ============================================================
        // 1. filter()
        // Intermediate
        // Select elements based on condition
        // ============================================================

        System.out.println("\n1. filter()");

        numbers.stream()
                .filter(n -> n > 30)
                .forEach(System.out::println);


        // ============================================================
        // 2. map()
        // Intermediate
        // Transform each element
        // ============================================================

        System.out.println("\n2. map()");

        numbers.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);


        // ============================================================
        // 3. mapToInt()
        // Intermediate
        // Convert elements to IntStream
        // ============================================================

        System.out.println("\n3. mapToInt()");

        int sumOfNameLengths = names.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println("Sum of name lengths = "
                + sumOfNameLengths);


        // ============================================================
        // 4. mapToLong()
        // Intermediate
        // Convert elements to LongStream
        // ============================================================

        System.out.println("\n4. mapToLong()");

        long sumOfNumbers = names.stream()
                .mapToLong(String::length)
                .sum();

        System.out.println("Sum = " + sumOfNumbers);


        // ============================================================
        // 5. mapToDouble()
        // Intermediate
        // Convert elements to DoubleStream
        // ============================================================

        System.out.println("\n5. mapToDouble()");

        double averageLength = names.stream()
                .mapToDouble(String::length)
                .average()
                .orElse(0.0);

        System.out.println("Average = " + averageLength);


        // ============================================================
        // 6. flatMap()
        // Intermediate
        // Flatten nested collections
        // ============================================================

        System.out.println("\n6. flatMap()");

        nestedNumbers.stream()
                .flatMap(list -> list.stream())
                .forEach(System.out::println);


        // ============================================================
        // 7. flatMapToInt()
        // Intermediate
        // Flatten nested collections into IntStream
        // ============================================================

        System.out.println("\n7. flatMapToInt()");

        int flatIntSum = nestedNumbers.stream()
                .flatMapToInt(list ->
                        list.stream()
                                .mapToInt(Integer::intValue))
                .sum();

        System.out.println("Sum = " + flatIntSum);


        // ============================================================
        // 8. flatMapToLong()
        // Intermediate
        // Flatten nested collections into LongStream
        // ============================================================

        System.out.println("\n8. flatMapToLong()");

        List<List<Long>> nestedLongNumbers = Arrays.asList(
                Arrays.asList(100L, 200L),
                Arrays.asList(300L, 400L)
        );

        long flatLongSum = nestedLongNumbers.stream()
                .flatMapToLong(list ->
                        list.stream()
                                .mapToLong(Long::longValue))
                .sum();

        System.out.println("Sum = " + flatLongSum);


        // ============================================================
        // 9. flatMapToDouble()
        // Intermediate
        // Flatten nested collections into DoubleStream
        // ============================================================

        System.out.println("\n9. flatMapToDouble()");

        List<List<Double>> nestedDoubleNumbers = Arrays.asList(
                Arrays.asList(10.5, 20.5),
                Arrays.asList(30.5, 40.5)
        );

        double flatDoubleSum = nestedDoubleNumbers.stream()
                .flatMapToDouble(list ->
                        list.stream()
                                .mapToDouble(Double::doubleValue))
                .sum();

        System.out.println("Sum = " + flatDoubleSum);


        // ============================================================
        // 10. distinct()
        // Intermediate
        // Remove duplicates
        // ============================================================

        System.out.println("\n10. distinct()");

        numbers.stream()
                .distinct()
                .forEach(System.out::println);


        // ============================================================
        // 11. sorted()
        // Intermediate
        // Sort in natural order
        // ============================================================

        System.out.println("\n11. sorted()");

        numbers.stream()
                .sorted()
                .forEach(System.out::println);


        // ============================================================
        // 12. sorted(Comparator)
        // Intermediate
        // Sort in reverse order
        // ============================================================

        System.out.println("\n12. sorted(Comparator)");

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        // ============================================================
        // 13. limit()
        // Intermediate
        // Take first N elements
        // ============================================================

        System.out.println("\n13. limit()");

        numbers.stream()
                .limit(3)
                .forEach(System.out::println);


        // ============================================================
        // 14. skip()
        // Intermediate
        // Skip first N elements
        // ============================================================

        System.out.println("\n14. skip()");

        numbers.stream()
                .skip(3)
                .forEach(System.out::println);


        // ============================================================
        // 15. takeWhile()
        // Intermediate
        // Java 9+
        // Take elements while condition is true
        // ============================================================

        System.out.println("\n15. takeWhile()");

        numbers.stream()
                .takeWhile(n -> n < 40)
                .forEach(System.out::println);


        // ============================================================
        // 16. dropWhile()
        // Intermediate
        // Java 9+
        // Drop elements while condition is true
        // ============================================================

        System.out.println("\n16. dropWhile()");

        numbers.stream()
                .dropWhile(n -> n < 40)
                .forEach(System.out::println);


        // ============================================================
        // 17. peek()
        // Intermediate
        // Mainly used for debugging
        // ============================================================

        System.out.println("\n17. peek()");

        numbers.stream()
                .filter(n -> n > 20)
                .peek(n -> System.out.println("After filter: " + n))
                .map(n -> n * 2)
                .forEach(n -> System.out.println("Final: " + n));


        // ============================================================
        // 18. forEach()
        // Terminal
        // ============================================================

        System.out.println("\n18. forEach()");

        numbers.stream()
                .forEach(n -> System.out.println(n));


        // ============================================================
        // 19. forEachOrdered()
        // Terminal
        // ============================================================

        System.out.println("\n19. forEachOrdered()");

        numbers.parallelStream()
                .forEachOrdered(System.out::println);


        // ============================================================
        // 20. collect()
        // Terminal
        // Convert stream into collection
        // ============================================================

        System.out.println("\n20. collect()");

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);


        // ============================================================
        // 21. collect() -> Set
        // ============================================================

        System.out.println("\n21. collect() -> Set");

        Set<Integer> uniqueNumbers = numbers.stream()
                .collect(Collectors.toSet());

        System.out.println(uniqueNumbers);


        // ============================================================
        // 22. reduce()
        // Terminal
        // Combine all elements into one value
        // ============================================================

        System.out.println("\n22. reduce()");

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);


        // ============================================================
        // 23. count()
        // Terminal
        // ============================================================

        System.out.println("\n23. count()");

        long count = numbers.stream()
                .count();

        System.out.println("Count = " + count);


        // ============================================================
        // 24. min()
        // Terminal
        // ============================================================

        System.out.println("\n24. min()");

        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);

        System.out.println("Min = " + min.orElse(0));


        // ============================================================
        // 25. max()
        // Terminal
        // ============================================================

        System.out.println("\n25. max()");

        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);

        System.out.println("Max = " + max.orElse(0));


        // ============================================================
        // 26. findFirst()
        // Terminal
        // ============================================================

        System.out.println("\n26. findFirst()");

        Optional<Integer> first = numbers.stream()
                .findFirst();

        System.out.println("First = " + first.orElse(0));


        // ============================================================
        // 27. findAny()
        // Terminal
        // ============================================================

        System.out.println("\n27. findAny()");

        Optional<Integer> any = numbers.stream()
                .findAny();

        System.out.println("Any = " + any.orElse(0));


        // ============================================================
        // 28. anyMatch()
        // Terminal
        // Is at least one element matching?
        // ============================================================

        System.out.println("\n28. anyMatch()");

        boolean anyGreaterThan50 = numbers.stream()
                .anyMatch(n -> n > 50);

        System.out.println(anyGreaterThan50);


        // ============================================================
        // 29. allMatch()
        // Terminal
        // Do all elements match?
        // ============================================================

        System.out.println("\n29. allMatch()");

        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);

        System.out.println(allPositive);


        // ============================================================
        // 30. noneMatch()
        // Terminal
        // Does no element match?
        // ============================================================

        System.out.println("\n30. noneMatch()");

        boolean noNegativeNumbers = numbers.stream()
                .noneMatch(n -> n < 0);

        System.out.println(noNegativeNumbers);


        // ============================================================
        // 31. toArray()
        // Terminal
        // ============================================================

        System.out.println("\n31. toArray()");

        Object[] array = numbers.stream()
                .toArray();

        System.out.println(Arrays.toString(array));


        // ============================================================
        // 32. toArray(Integer[]::new)
        // Terminal
        // Typed array
        // ============================================================

        System.out.println("\n32. toArray(Integer[]::new)");

        Integer[] integerArray = numbers.stream()
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(integerArray));


        // ============================================================
        // 33. boxed()
        // Primitive Stream -> Object Stream
        // ============================================================

        System.out.println("\n33. boxed()");

        IntStream intStream = IntStream.of(10, 20, 30);

        Stream<Integer> boxedStream = intStream.boxed();

        boxedStream.forEach(System.out::println);


        // ============================================================
        // 34. mapToObj()
        // Primitive Stream -> Object Stream
        // ============================================================

        System.out.println("\n34. mapToObj()");

        IntStream.of(10, 20, 30)
                .mapToObj(n -> "Number: " + n)
                .forEach(System.out::println);


        // ============================================================
        // 35. IntStream.sum()
        // ============================================================

        System.out.println("\n35. IntStream.sum()");

        int intSum = IntStream.of(10, 20, 30)
                .sum();

        System.out.println(intSum);


        // ============================================================
        // 36. IntStream.average()
        // ============================================================

        System.out.println("\n36. IntStream.average()");

        double average = IntStream.of(10, 20, 30)
                .average()
                .orElse(0);

        System.out.println(average);


        // ============================================================
        // 37. IntStream.min()
        // ============================================================

        System.out.println("\n37. IntStream.min()");

        int intMin = IntStream.of(10, 20, 30)
                .min()
                .orElse(0);

        System.out.println(intMin);


        // ============================================================
        // 38. IntStream.max()
        // ============================================================

        System.out.println("\n38. IntStream.max()");

        int intMax = IntStream.of(10, 20, 30)
                .max()
                .orElse(0);

        System.out.println(intMax);


        // ============================================================
        // 39. IntStream.count()
        // ============================================================

        System.out.println("\n39. IntStream.count()");

        long intCount = IntStream.of(10, 20, 30)
                .count();

        System.out.println(intCount);


        // ============================================================
        // 40. IntStream.summaryStatistics()
        // ============================================================

        System.out.println("\n40. summaryStatistics()");

        IntSummaryStatistics statistics =
                IntStream.of(10, 20, 30, 40, 50)
                        .summaryStatistics();

        System.out.println("Count = " + statistics.getCount());
        System.out.println("Sum   = " + statistics.getSum());
        System.out.println("Min   = " + statistics.getMin());
        System.out.println("Max   = " + statistics.getMax());
        System.out.println("Avg   = " + statistics.getAverage());


        // ============================================================
        // 41. IntStream.range()
        // ============================================================

        System.out.println("\n41. IntStream.range()");

        IntStream.range(1, 5)
                .forEach(System.out::println);

        // Output:
        // 1
        // 2
        // 3
        // 4


        // ============================================================
        // 42. IntStream.rangeClosed()
        // ============================================================

        System.out.println("\n42. IntStream.rangeClosed()");

        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);

        // Output:
        // 1
        // 2
        // 3
        // 4
        // 5
    }
}
