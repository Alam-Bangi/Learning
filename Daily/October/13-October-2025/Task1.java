/*
Write a code to print odd digits of a given number.
*/
import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        
        while(number>0) {
            int number1 = number % 10;
            number = number/10;
            if(number1%2==1) {
                System.out.println(number1);
            }
        }
    }
}
