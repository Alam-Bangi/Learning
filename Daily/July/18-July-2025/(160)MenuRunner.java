
import java.util.Scanner;

class MenuRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number1:");
        int number1 = scanner.nextInt();

        System.out.println("Enter number2:");
        int number2 = scanner.nextInt();

        System.out.println("Choices:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();


        System.out.println("Your choices are:");
        System.out.println("number1 = " + number1);
        System.out.println("number2 = " + number2);
        System.out.println("choice = " + choice);
    }
}
