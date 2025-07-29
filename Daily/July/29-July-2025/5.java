import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: " );
        number = input.nextInt();
        for (int row=0 ; row<number;row++) {
            for (int col=0 ; col<number; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        
        for (int row=0 ; row<number; row++) {
            for (int col=0 ; col<=row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        
        System.out.println("");
        
        for (int row=0 ; row<=number; row++) {
            for (int col=0 ; col<number-row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        
        for (int row=0 ; row<number; row++) {
            for (int col=0 ; col<number-row-1; col++) {
                System.out.print(" ");
            }
            for (int col=0 ; col<row+1; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        
        for (int row=0 ; row<number; row++) {
            for (int col=0 ; col<row; col++) {
                System.out.print(" ");
            }
            for (int col=0 ; col<number-row; col++) {
                System.out.print("*");
            }
            
            System.out.println(" ");
        }
        
         System.out.println("");
        
        for (int row=0 ; row<number; row++) {
            for (int col=0 ; col<=row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        
        // System.out.println("");
        
        for (int row=0 ; row<=number; row++) {
            for (int col=0 ; col<number-row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        
        System.out.println("");
        
        for (int row=0 ; row<number; row++) {
            for (int col=0 ; col<number-row-1; col++) {
                System.out.print(" ");
            }
            for (int col=0 ; col<row+1; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        // System.out.println("");
        
        for (int row=0 ; row<number; row++) {
            for (int col=0 ; col<row; col++) {
                System.out.print(" ");
            }
            for (int col=0 ; col<number-row; col++) {
                System.out.print("*");
            }
            
            System.out.println(" ");
        }
        
         
    }
}