import java.util.*;

class MethodReferencesRunner {
    public static void main(String[] args) {
        List.of("Apple","Bat","Cat","Dog","Elephant").stream()
        .map(s -> s.length())
        .forEach(s -> System.out.println(s));

        List.of("Apple","Bat","Cat","Dog","Elephant").stream()
        .map(s -> s.length())
        .forEach(System.out::println);

        Integer max = List.of(23,45,67,12).stream()
        .filter(MethodReferencesRunner::isEven)
        .max(Integer::compare)
        .orElse(0);
        System.out.println(max);
    }
    public static boolean isEven(Integer number) {
        return number%2==0;
    }

}
