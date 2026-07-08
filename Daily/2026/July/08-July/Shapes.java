import java.util.Scanner;

class Shapes {
    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = input.nextInt();
        input.close();

        System.out.println("");
        /*
         * * * *
         * * * *
         * * * *
         * * * *
         */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        System.out.println("");
        /*
        *
        **
        ***
        ****
        */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        /*
        ****
        ***
        **
        *
        */
        for (int row = 0; row <= number; row++) {
            for (int col = 0; col < number - row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        /*
        *
        **
        ***
        ****
        */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number - row - 1; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < row + 1; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        /*
        ****
        ***
        **
        *
        */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < number - row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        /*
        *
        **
        ***
        ****
        ****
        ***
        **
        *
        */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

        // System.out.println("");

        for (int row = 0; row <= number; row++) {
            for (int col = 0; col < number - row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println("");
        /*
           * 
          ** 
         *** 
        **** 
        **** 
         *** 
          ** 
           *
        */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number - row - 1; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < row + 1; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

        for (int row = 0; row < number; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < number - row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

        System.out.println(" ");
        /*
         * * * *
         * *
         * *
         * * * *
         */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                if (row == 0 || row == number - 1 || col == 0 || col == number - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }

        System.out.println("");
        /*
         * * * *
         * *
         * *
         * 
         */
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                if (row == 0 || col == 0 || col == number - 1 - row) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }

        System.out.println("");
        /*
         * 
         * * *
         * * * * *
         * * * * * * *
         */
        for (int row = 0; row < number; row++) {
            int k = 0;
            for (int col = 0; col < (2 * number); col++) {
                if (col < number - row - 1) {
                    System.out.print("  ");
                } else if (k < 2 * row + 1) {
                    System.out.print("* ");
                    k++;
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }

        System.out.println("");

        /*
         * 
         * *
         * *
         * * * * * * *
         */
        for (int row = 0; row < number; row++) {
            int k = 0;
            for (int col = 0; col < ((2 * number) - 1); col++) {
                if (col < number - row - 1) {
                    System.out.print("  ");
                } else if (k < 2 * row + 1) {
                    if (k == 0 || k == 2 * row || row == number - 1) {
                        System.out.print("* ");
                        k++;
                    } else {
                        System.out.print("  ");
                        k++;
                    }
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }
}