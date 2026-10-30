package tryouts.other;

import java.util.Scanner;

public class Delimiter {
    public static void main(String[] args) {
        String input = "Hello World Java";
        Scanner scanner = new Scanner(input);

        // Set the delimiter to the '#' character
        scanner.useDelimiter(" ");
        System.out.println(scanner.next());

//        while (scanner.hasNext()) {
//            System.out.println(scanner.next());
//        }
        System.out.println(input);
        scanner.close();
    }
}
