import java.util.Scanner;

class CalculatorRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ScientificCalculator calc = new ScientificCalculator();

        double a;
        double b;

        int choice;

        do {
            System.out.println("\n===== CALCULATOR MENU =====");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Sin");
            System.out.println("8. Cos");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter two numbers: \n");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    calc.displayResult(calc.add(a, b));
                    break;

                case 2:
                    System.out.print("Enter two numbers: \n");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    calc.displayResult(calc.subtract(a, b));
                    break;

                case 3:
                    System.out.print("Enter two numbers: \n");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    calc.displayResult(calc.multiply(a, b));
                    break;

                case 4:
                    System.out.print("Enter two numbers: \n");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    calc.displayResult(calc.divide(a, b));
                    break;

                case 5:
                    System.out.print("Enter base and exponent: \n");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    calc.displayResult(calc.power(a, b));
                    break;

                case 6:
                    System.out.print("Enter number: ");
                    a = sc.nextDouble();
                    calc.displayResult(calc.squareRoot(a));
                    break;

                case 7:
                    System.out.print("Enter angle (degrees): ");
                    a = sc.nextDouble();
                    calc.displayResult(calc.sin(a));
                    break;

                case 8:
                    System.out.print("Enter angle (degrees): ");
                    a = sc.nextDouble();
                    calc.displayResult(calc.cos(a));
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    break;

                default:
                    System.out.println("Invalid choice!");
                    sc.close();
            }
        } while (choice != 0);

    }
}

abstract class Calculator {
    abstract double add(double a, double b);

    abstract double subtract(double a, double b);

    abstract double multiply(double a, double b);

    abstract double divide(double a, double b);

    void displayResult(double result) {
        System.out.println("Result: " + result);
    }
}

class BasicCalculator extends Calculator {

    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero");
        }
        return a / b;
    }
}

class ScientificCalculator extends BasicCalculator {

    double power(double a, double b) {
        return Math.pow(a, b);
    }

    double squareRoot(double a) {
        return Math.sqrt(a);
    }

    double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}
