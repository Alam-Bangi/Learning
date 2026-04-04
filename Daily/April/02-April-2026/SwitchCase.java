import java.util.Scanner;

class SwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = sc.nextInt();

        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);

        System.out.println();
        System.out.println("Choose Operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println();

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Addition: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Subtraction: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Multiplication: " + (num1 * num2));
                break;
            case 4:
                System.out.println("Division: " + (num1 / num2));
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
