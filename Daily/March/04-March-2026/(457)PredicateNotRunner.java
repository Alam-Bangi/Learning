import java.util.List;
import java.util.function.Predicate;

class PredicateNotRunner {

    public static boolean isEven(Integer n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 49, 65, 74, 82);
        // Predicate<Integer> isEven = n -> n % 2 == 0;
        // numbers.stream().filter(isEven.negate()).forEach(System.out::println);
        numbers.stream().filter(Predicate.not(PredicateNotRunner::isEven)).forEach(System.out::println);
    }
}
