import java.util.Scanner;

class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int number = scanner.nextInt();
        boolean isPrime = false;
        if(number==1 || number<0) {
            System.out.println("Composite Number");
        }
        for(int i =2; i<number; i++) {
            if(number%2==1) {
                isPrime = true;
            } 
        }
        if(isPrime) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not a Prime number");
        }
    }
}
