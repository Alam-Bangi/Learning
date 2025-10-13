/*
Write a code to print odd position of digits of a given number.
*/

import java.util.Scanner;
class Task2 {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int size = getSizeOfNumber(number);
        System.out.println("Size of number is: " +size);
        for(int i =size; i>0 ; i--) {
            int number1 = number%10;
            number = number/10;
            if(i%2==1) {
                System.out.println(number1);
            }
        }
    }
    public static int getSizeOfNumber(int number) {
        int i =0;
        while(number>0){
            // int number1 = number%10;
            number = number/10;
            i++;
        }
        return i;
    }
}