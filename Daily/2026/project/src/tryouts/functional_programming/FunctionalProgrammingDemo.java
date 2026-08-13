package tryouts.functional_programming;

import java.util.*;
import java.util.function.*;

public class FunctionalProgrammingDemo {

    public static void main(String[] args) {

        List<String> students = Arrays.asList(
            "Alice", "Bob", "Charlie", "David", "Eva"
        );

        // 1. Predicate: checks a condition
        Predicate<String> isLongName = name -> name.length() > 4;

        // 2. Function: transforms the input
        Function<String, String> convertToUpperCase =
            name -> name.toUpperCase();

        // 3. Consumer: performs an action
        Consumer<String> printStudent =
            name -> System.out.println("Student: " + name);

        // 4. Supplier: supplies a value
        Supplier<String> defaultStudent =
            () -> "Unknown Student";


        // Using Predicate + Function + Consumer
        students.stream()
                .filter(isLongName)              // Predicate
                .map(convertToUpperCase)         // Function
                .forEach(printStudent);          // Consumer


        // Using Supplier
        System.out.println("Default: " + defaultStudent.get());
    }
}