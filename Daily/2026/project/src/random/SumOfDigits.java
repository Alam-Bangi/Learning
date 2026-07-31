package random;

public class SumOfDigits {
    public static void main(String[] args) {
        int number = 9384756;
        System.out.println("Sum of digits: " + sumDigits(number));
    }
    public static int sumDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}