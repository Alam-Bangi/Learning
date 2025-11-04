import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrimeNumbersUsingThreads {
    public static void main(String[] args) {
        // GetPrimeNumbers primeNumbers = new GetPrimeNumbers();
        // primeNumbers.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new GetPrimeNumbers());
        executorService.shutdown();
    }
}
class GetPrimeNumbers extends Thread {
    public void run() {
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean isPrime = true;
        for(int i =2; i<n; i++) {
            if(n%i==0) {
                isPrime = false;
            }
        }
        if(isPrime) {
            System.out.println(n + " is Prime Number");
        } else {
            System.out.println(n + " is not a Prime Number");
        }
    }
}