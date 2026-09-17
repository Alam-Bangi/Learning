package tryouts.functional_programming;

import java.util.stream.IntStream;

public class PrimeWithFp {
    public static void main(String[] args) {
        IntStream.range(2,100)
                .filter(e -> IntStream.range(2,e/2).allMatch(e1 -> e % e1 !=0))
                    .filter(e -> (e > 10 && e < 30) ||  (e > 50 && e < 80))
                        .forEach(System.out::println);
    }
}
