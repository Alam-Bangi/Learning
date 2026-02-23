import java.util.Scanner;

class TryWithResourcesRunner {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] numbers = { 12, 3, 4 };
            int number = numbers[5];
        }
    }
}