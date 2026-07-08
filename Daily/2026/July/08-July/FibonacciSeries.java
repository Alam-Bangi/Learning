import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int firstNo = 0, secondNo = 1;

        System.out.println("Fibonacci Series up to " + n + " terms:");
        for (int i = 1; i <= n; ++i) {
            System.out.print(firstNo + " ");

            int sum = firstNo + secondNo;
            firstNo = secondNo;
            secondNo = sum;
        }
        sc.close();
    }
}
