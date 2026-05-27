import java.io.*;
import java.util.*;

public class ExceptionDemo {

    public static void main(String[] args) {

        System.out.println("Program Started\n");

        // 1. Arithmetic Exception
        try {

            int a = 10;
            int b = 0;

            int result = a / b;

            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println(
                    "Arithmetic Exception: " + e);
        }

        System.out.println();

        // 2. Array Index Exception
        try {

            int arr[] = { 1, 2, 3 };

            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Array Index Exception: " + e);
        }

        System.out.println();

        // 3. Null Pointer Exception
        try {

            String str = null;

            System.out.println(str.length());

        } catch (NullPointerException e) {

            System.out.println(
                    "Null Pointer Exception: " + e);
        }

        System.out.println();

        // 4. Number Format Exception
        try {

            String num = "abc";

            int n = Integer.parseInt(num);

            System.out.println(n);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Number Format Exception: " + e);
        }

        System.out.println();

        // 5. Multiple Catch Example
        try {

            int arr[] = new int[3];

            arr[5] = 10;

            int x = 10 / 0;

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Handled Array Exception");

        } catch (ArithmeticException e) {

            System.out.println(
                    "Handled Arithmetic Exception");

        } catch (Exception e) {

            System.out.println(
                    "General Exception: " + e);
        }

        System.out.println();

        // 6. Nested Try
        try {

            try {

                int x = 10 / 0;

            } catch (ArithmeticException e) {

                System.out.println(
                        "Inner Try Catch");
            }

            int arr[] = { 1, 2 };

            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Outer Try Catch");
        }

        System.out.println();

        // 7. Finally Block
        try {

            int x = 100 / 10;

            System.out.println(x);

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            System.out.println(
                    "Finally block always executes");
        }

        System.out.println();

        // 8. Custom Exception
        try {

            checkAge(15);

        } catch (InvalidAgeException e) {

            System.out.println(
                    "Custom Exception: " + e.getMessage());
        }

        System.out.println();

        // 9. Checked Exception (IOException)
        try {

            readFile();

        } catch (IOException e) {

            System.out.println(
                    "\nIO Exception: " + e);
        }

        System.out.println();

        // 10. InputMismatchException
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print(
                    "Enter a number: ");

            int num = sc.nextInt();

            System.out.println(
                    "You entered: " + num);

        } catch (InputMismatchException e) {

            System.out.println(
                    "InputMismatchException: Invalid input! Please enter integer only.");
        }

        System.out.println();

        sc.close();

        System.out.println("Program Ended");
    }

    // Method using throws
    static void checkAge(int age) throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException(
                    "Age must be 18 or above");
        }
        System.out.println("Eligible to vote");
    }

    // File handling method without BufferedReader
    static void readFile() throws IOException {

        FileReader file = new FileReader("sample.txt");

        int ch;

        while ((ch = file.read()) != -1) {
            System.out.print((char) ch);
        }

        file.close();
    }
}

// Custom Exception
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}