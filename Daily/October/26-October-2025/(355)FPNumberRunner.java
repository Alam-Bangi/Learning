import java.util.List;

class FPNumberRunner {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4,6,8,13,3,15);

        // numbers.stream().forEach(element->System.out.println(element));

        int sum = numbers.stream().reduce(0, (number1 , number2)-> number1+number2);
        System.out.println(sum);
        // System.out.println(normalSum(numbers));
    }

    private static int normalSum(List<Integer> numbers) {
        int sum =0;
        for(int number : numbers) {
            sum+=number;
        }
        return sum;
    }
}