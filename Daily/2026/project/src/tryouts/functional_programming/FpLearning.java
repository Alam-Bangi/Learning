package tryouts.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FpLearning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.asList(70, 20, 30, 40, 50, 50, 60);

        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        int[] no = new int[10];

        for(int i=0; i< no.length; i++) {
            System.out.print("Enter no " + (i+1) + ": ");
            no[i] = sc.nextInt();
        }
        System.out.println("\nEven Numbers");
        Arrays.stream(no).filter(e -> e%2==0).forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("\nOdd Numbers");
        Arrays.stream(no).filter(e -> e%2==1).forEach(e -> System.out.print(e + " "));

        System.out.println("\n\nSorted Array");
        Arrays.stream(no).sorted().forEach(e -> System.out.print(e + " "));

        int sum = Arrays.stream(no).reduce(0, Integer::sum);
        System.out.println("\n\nSum " + sum);

        int max = Arrays.stream(no).max().getAsInt();
        System.out.println("\nMax " + max);

        System.out.println("\nNo duplicates");
        Arrays.stream(no).distinct().forEach(n -> System.out.print(n + " "));

        System.out.println("\n\nMap to square");
        Arrays.stream(no).distinct().map(n -> n*n).forEach(n -> System.out.print(n + " "));

        System.out.println("\n\nCollect to list");
        List<Integer> collect = Arrays.stream(no).distinct().boxed().filter(e -> e%2==0).collect(Collectors.toList());
        System.out.print(collect);

        System.out.println("\n\nIntStream");
        IntStream.range(1,13).forEach(e -> System.out.print(e + " "));

        System.out.println("\n\nPeek");
        numbers.stream()
                .filter(n -> n > 20)
                .peek(n -> System.out.println("After filter: " + n))
                .map(n -> n * 2)
                .forEach(n -> System.out.println("Final: " + n));

        System.out.println("\ndropWhile()");
        numbers.stream()
                .dropWhile(n -> n == 40)
                .forEach(System.out::println);

        System.out.println("\ntakeWhile()");
        numbers.stream()
                .takeWhile(n -> n < 40)
                .forEach(System.out::println);

        System.out.println("\nskip()");
        Arrays.stream(no)
                .skip(3)
                .forEach(System.out::println);

        System.out.println("\nlimit()");
        Arrays.stream(no)
                .limit(3)
                .forEach(System.out::println);


        System.out.println("\nflatMapToDouble()");
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


        System.out.println("\nflatMapToLong()");
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


        System.out.println("\nflatMapToInt()");
        int flatIntSum = nestedNumbers.stream()
                .flatMapToInt(list ->
                        list.stream()
                                .mapToInt(Integer::intValue))
                                .sum();
        System.out.println("Sum = " + flatIntSum);


        System.out.println("\nforEachOrdered()");
        numbers.parallelStream()
                .forEachOrdered(System.out::println);


        System.out.println("\nfindFirst()");
        Optional<Integer> first = numbers.stream()
                .findFirst();
        System.out.println("First = " + first.orElse(0));


        System.out.println("\nfindAny()");
        Optional<Integer> any = numbers.stream()
                .findAny();
        System.out.println("Any = " + any.orElse(0));


        System.out.println("\nanyMatch()");
        boolean anyGreaterThan50 = numbers.stream()
                .anyMatch(n -> n > 50);
        System.out.println(anyGreaterThan50);


        System.out.println("\nallMatch()");
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 40);
        System.out.println(allPositive);


        System.out.println("\nnoneMatch()");
        boolean noNegativeNumbers = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println(noNegativeNumbers);
    }
}
