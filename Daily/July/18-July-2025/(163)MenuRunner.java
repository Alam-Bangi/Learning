
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

        switch (choice) {
            case 1:
                System.out.println("Result: " + (number1 + number2));
                break;
            case 2:
                System.out.println("Result: " + (number1 - number2));
                break;
            case 3:
                System.out.println("Result: " + (number1 * number2));
                break;
            case 4:
                if (number2 != 0) {
                    System.out.println("Result: " + (number1 / number2));
                    break;
            default :
                System.out.println("Invalid choice!");
                break;
        }

        // if (choice == 1) {
        //     int result = number1 + number2;
        //     System.out.println("The addition is: " + result);
        // } else if (choice == 2) {
        //     int result = number1 - number2;
        //     System.out.println("The subtraction is: " + result);
        // } else if (choice == 3) {
        //     int result = number1 * number2;
        //     System.out.println("The multiplication is: " + result);
        // } else if (choice == 4) {
        //     if (number2 != 0) {
        //         int result = number1 / number2;
        //         System.out.println("The division is: " + result);
        //     } else {
        //         System.out.println("Error: Division by zero is not allowed.");
        //     }
        // } else {
        //     System.out.println("Invalid choice! Please select a valid option.");
        // }
    }
}