import java.util.*;
import java.util.function.Predicate;

class LambdaBTSRunner {

    public static void main(String[] args) {
        List.of(23,43,34,45,36,48).stream()
        .filter(n -> n%2==0)
        .forEach(e -> System.out.println(e));

        List.of(23,43,34,45,36,48).stream()
        .filter(new EvenNumberPredicate())
        .forEach(e -> System.out.println(e));
    }
}
class EvenNumberPredicate implements Predicate<Integer> {
    public boolean Test(Integer number) {
        return number%2 ==0;
    }
}