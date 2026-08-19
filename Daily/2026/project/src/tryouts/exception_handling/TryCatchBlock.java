package tryouts.exception_handling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryCatchBlock {
    public static void main(String[] args) {
        System.out.println("Checked Exception");
        try {
            FileReader fileReader = new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n");
        }

        System.out.println("Unchecked Exception");
        int a = 10;
        int b = 0;
        int ans =0;

        try {
            ans = a/b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0");
        }
    }
}
