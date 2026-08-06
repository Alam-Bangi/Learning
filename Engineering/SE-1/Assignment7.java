/*
Write a Python Program for magic square. A magic square is an nn matrix of the integers 1 to n2 such that the sum of each row, 
column, and diagonal is the same. The figure given below is an example of magic square for case n=5. 
In this example, the common sum is 65.

*/
import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size (odd number): ");
        int size = sc.nextInt();
        
        createMagicSquare(size);
        sc.close();
    }

    static void createMagicSquare(int n) {
        if(n % 2 == 0) {
            System.out.println("Enter odd number ( Eg: 3, 5, 7, ...)");
        }
        
        int[][] magicSquare = new int[n][n];
        
        int row = 0;
        int col = n / 2;
        
        for(int number = 1; number <= (n * n); number++) {
            magicSquare[row][col] = number;
            
            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;
            
            if(magicSquare[nextRow][nextCol] != 0) {
                row = row + 1;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }
        
        int magicSum = n * (n * n + 1) / 2;
        System.out.println("Magic sum is " + magicSum);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(magicSquare[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}
