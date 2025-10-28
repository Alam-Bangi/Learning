import java.util.*;
import java.util.function.*;

import EvenNumberPredicate.SystemOutConsumer;

class LambdaBTSRunner {

    public static void main(String[] args) {
        List.of(23,43,34,45,36,48).stream()
        .filter(n -> n%2==0)
        .map(n -> n * n)
        .forEach(e -> System.out.println(e));
        
        List.of(23,43,34,45,36,48).stream()
        .filter(n -> n%2==0)
        .map(new NumberSquareMapper())
        .forEach(e -> System.out.println(e));
    }
} 
class EvenNumberPredicate implements Predicate<Integer> {
    public boolean Test(Integer number) {
        return number%2 ==0;
    }
    // List.of(23,43,34,45,36,48).stream()
    //     .filter(new EvenNumberPredicate())
    //     .forEach(e -> System.out.println(e));
}
class SystemOutConsumer implements Consumer<Integer> {
    public void accept(Integer number) {
        System.out.println(number);
    }
    // List.of(23,43,34,45,36,48).stream()
    //     .filter(new EvenNumberPredicate())
    //     .forEach(new SystemOutConsumer());
}
class NumberSquareMapper implements Function<Integer, Integer> {
    public Integer apply(Integer number) {
        return number * number;
    }
}