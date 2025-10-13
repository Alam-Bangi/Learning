
import java.util.Scanner;

class ScannerEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter byte: ");
        byte byteNum = scanner.nextByte();
        System.out.println("Scanner using Byte: " + byteNum);

        System.out.println("Enter short: ");
        short shortNum = scanner.nextShort();
        System.out.println("Scanner using Short: " + shortNum);

        System.out.println("Enter character: ");
        char character = scanner.next().charAt(0);
        System.out.println("Scanner using Character: " + character);

        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Scanner using Integer: " + number);

        System.out.println("Enter long: ");
        long longNum = scanner.nextLong();
        System.out.println("Scanner using Long: " + longNum);

        System.out.println("Enter a floating-point number: ");
        float decimal = scanner.nextFloat();
        System.out.println("Scanner using Float: " + decimal);

        System.out.println("Enter double number: ");
        double doubleNum = scanner.nextDouble();
        System.out.println("Scanner using Double: " + doubleNum);

        System.out.println("Enter boolean: ");
        boolean bool = scanner.nextBoolean();
        System.out.println("Scanner using Boolean: " + bool);

        System.out.println("Enter a string: ");
        String text = scanner.next();
        System.out.println("Scanner using String: " + text);

        scanner.close();
    }
}