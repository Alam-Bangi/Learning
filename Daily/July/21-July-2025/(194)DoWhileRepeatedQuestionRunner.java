import java.util.Scanner;

class DoWhileRepeatedQuestionRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        do { 
            if(number !=1) {
                System.out.println("Cube of " + number + " is " + (number * number * number));
            }
            System.out.println("Enter a number: ");
            number = scanner.nextInt();
        } while (number>=0);
        System.out.println("Thank you!");
    }
}
