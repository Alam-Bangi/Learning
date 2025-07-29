import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int randomNumber = 25;
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: " );
        number = input.nextInt();
       
        for (; number != randomNumber; ) { 
            if (number < randomNumber) {
                System.out.println("Number is smaller than random number.");
            } else {
                System.out.println("Number is greater than random number.");
            }
            System.out.println("Enter a number: " );
            number = input.nextInt();
        }
        System.out.println("You've entered the correct number.");
    }
}