import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FpPractice {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 45, 56, 23, 35, 12, 45);

        System.out.println(numbers.stream().distinct().reduce(0, (number1, number2) -> number1 + number2));

        int max = numbers.stream().max((number1, number2) -> Integer.compare(number1, number2)).get();
        System.out.println("Max number: " + max);

        int min = numbers.stream().min((number1, number2) -> Integer.compare(number1, number2)).get();
        System.out.println("Min number: " + min);

        List number = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Elements in the list: " + number);

        List number1 = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Elements in the list(with duplicate values): " + number1);

        List number2 = numbers.stream().collect(Collectors.toList());
        System.out.println("Elements in the list(in insertion order): " + number2);

        int no1 = numbers.stream().filter(e -> e%7==0).max((n1,n2) -> Integer.compare(n1, n2)).orElse(0);
        System.out.println("Number divisible by 7: " + no1);

        List<Integer> no = List.of(1, 2, 3, 4, 5);

        List squares = no.stream().distinct().map(e -> e * e).collect(Collectors.toList());
        System.out.println("After mapping squares: " + squares);

        IntStream.range(1, 11).boxed().map(e -> e * e).collect(Collectors.toList());
        // boxed() converts the IntStream to Stream<Integer>

        List.of("Apple", "Ant", "Bat").stream().map(String::toLowerCase).forEach(e -> System.out.println(e));

        List strLength = List.of("Apple", "Ant", "Bat").stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(strLength);
    }
}