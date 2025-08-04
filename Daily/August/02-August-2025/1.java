
import java.util.Scanner;

class Main {

    public static void for_loop() {
        int number = 10;
        System.out.println("Printing Hello World 10 times");
        // For Loop
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World");
        }
        // If Else Statement
        if (number < 10) {
            System.out.println("Hi");
        } else {
            System.out.println("Hey");
        }

    }

    public static void switch_case() {
        System.out.println("Demonstrating Switch Case and input is 10 for this example");
        int number = 10;
        // Switch statement
        switch (number) {
            case 1:
                System.out.println("Number is Less than 10");
                break;
            case 5:
                System.out.println("Number is Less than 10");
                break;
            case 10:
                System.out.println("Correct Number");
                break;
            default:
                System.out.println("Wrong Number");
        }

    }

    public static void while_loop() {
        System.out.println("Demonstrating While Loop and input is 10 for this example");
        int number = 10;
        // While
        while (number <= 10) {
            System.out.println(number);
            break;
        }
    }

    public static void square_pattern() {
        System.out.println("Demonstrating Square Pattern with 10 rows and columns");
        int number = 10;
        // Square Pattern
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void prime_number() {
        System.out.println("Demonstrating Prime Number and input is 19 for this example");
        // Prime Number
        int prime = 19;
        boolean isDivisible = false;
        for (int no = 2; no < prime; no++) {
            if (prime % no == 0) {
                System.out.println("Not a prime number");
                isDivisible = true;
                break;
            }
            // else if(prime%no==1) {
            //     System.out.println("prime number");
            //     break;
            // }
        }
        if (!isDivisible) {
            System.out.println("Number is Prime");
        }
    }

    public static void prime_number_till_n() {
        System.out.println("Demonstrating Prime Number till N and input is 100 for this example");
        // System.out.println(isPrime(35));
        for (int i = 3; i < 100; i++) {
            // System.out.println(i);
            // boolean answer= isPrime();
            boolean answer = isPrime(i);
            if (answer) {
                System.out.println(i);
            }
        }
    }

    public static void fibonacci() {
        System.out.println("Demonstrating Fibonacci Series and input is 5 for this example");
        // Fibonacci
        int fib = 5;
        int n1 = 0;
        int n2 = 1;
        int sum = n1 + n2;
        System.out.print(n1 + " " + n2 + " ");

        for (int f = 0; f < fib; f++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    public static void LCM() {
        System.out.println("Demonstrating LCM and input is 5 and 8 for this example");
        // LCM
        int num1 = 5;
        int num2 = 8;
        int lcm = 0;
        int max;
        if (num1 < num2) {
            max = num2;
        } else {
            max = num1;
        }
        lcm = lcm + max;
        while (lcm != 0) {
            if (lcm % num1 == 0 && lcm % num2 == 0) {
                System.out.println("LCM of " + num1 + " & " + num2 + " is " + lcm);
                break;
            }
            lcm = lcm + max;
        }
    }

    public static void GCD() {
        System.out.println("Demonstrating GCD and input is 82 and 20 for this example");
        // GCD
        int number1 = 82;
        int number2 = 20;
        int gcd = 0;

        if (number1 > number2) {
            gcd = number2;
        } else {
            gcd = number1;
        }
        while (gcd != 0) {
            if (number1 % gcd == 0 && number2 % gcd == 0) {
                System.out.println("GCD of " + number1 + " & " + number2 + " is " + gcd);
                break;
            }
            gcd = gcd - 1;
        }
    }

    public static void guessTheNumber() {
        System.out.println("Demonstrating Guess the Number and input is 50 for this example");
        // Random Number
        int randomNumber = 50;
        int number0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number0 = input.nextInt();

        while (number0 != randomNumber) {
            if (number0 < randomNumber) {
                System.out.println("Number is smaller than random number.");
            } else {
                System.out.println("Number is greater than random number.");
            }
            System.out.println("Enter a number: ");
            number0 = input.nextInt();
        }
        System.out.println("You've entered the correct number.");

    }

    public static void summationOfDigits() {
        System.out.println("Demonstrating Summation of Digits and input is 12345 for this example");
        // Summation of digits
        int number12 = 12345;
        int sum1 = 0;
        while (number12 != 0) {
            int lastDigit = number12 % 10;

            sum1 = sum1 + lastDigit;
            number12 = number12 / 10;
        }
        System.out.println("Sum of all digits is: " + sum1);
    }

    public static void printDigits() {
        System.out.println("Demonstrating Print Digits and input is 54321 for this example");
        // Print digits of number

        int number123 = 54321;
        int tempNumber = number123;
        int divisor = 10;

        while (tempNumber / divisor > 10) {
            divisor = divisor * 10;
        }

        while (divisor > 0) {
            int digit = number123 / divisor;
            System.out.println(digit);
            number123 = number123 % divisor;
            divisor = divisor / 10;
        }

    }

    public static void checkEvenOrOdd() {
        System.out.println("Demonstrating Even or Odd Number and input is 2025 for this example");
        // Even or Odd Number
        int numberCheck = 2025;
        if (numberCheck % 2 == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static void checkValidTriangleAngles() {
        System.out.println("Demonstrating Valid Triangle and summation of angles is 180 and input are 90, 40, 50 for this example");
        // Valid Triangle
        int triangle = 180;
        int angle1 = 90;
        int angle2 = 40;
        int angle3 = 50;
        if (angle1 + angle2 + angle3 == triangle) {
            System.out.println("Triangle is Valid");
        } else {
            System.out.println("Triangle is not Valid");
        }
    }


    public static void checkDate() {
        System.out.println("Demonstrating Date Check and input for week day is 1 and month name number is 8  and day number is 5 for this example");
        System.out.println(isWeekDay(1));
        System.out.println(determineNameOfMonth(8));
        System.out.println(determineNameOfDay(5));
    }

    public static void checkDivisibility() {
        System.out.println("Demonstrating Divisibility and input is 9, 16 and 18 for this example");
        System.out.println(isDivisibleByThree(9));
        System.out.println(isDivisibleByFive(16));
        System.out.println(isDivisibleByThreeOrFive(18));
    }


    public static void main(String[] args) {
        Integer choice = 0;
        while (choice != 17) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("This code is to demonstrate learning from 9 July 2025 to 31 July 2025");
            System.out.println("0. All the codes");
            System.out.println("1. For loop");
            System.out.println("2. Switch Case Statement");
            System.out.println("3. While Loop");
            System.out.println("4. Square Pattern");
            System.out.println("5. Prime Number");
            System.out.println("6. Prime Number till N");
            System.out.println("7. Fibonacci");
            System.out.println("8. LCM");
            System.out.println("9. GCD");
            System.out.println("10. Guess the Number");
            System.out.println("11. Summation of Digits");
            System.out.println("12. Print Digits");
            System.out.println("13. Even or Odd Number");
            System.out.println("14. Valid Triangle Angles");
            System.out.println("15. Check Date");
            System.out.println("16. Check Divisibility");
            System.out.println("17 Exit");
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.print("Choose the option which you want to try (0-17): ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    for_loop();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    switch_case();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    while_loop();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    square_pattern();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    prime_number();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    prime_number_till_n();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    fibonacci();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    LCM();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    GCD();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    guessTheNumber();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    summationOfDigits();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    printDigits();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    checkEvenOrOdd();
                    
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    checkValidTriangleAngles();
                    
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    checkDate();
                    System.out.println("--------------------------------------------------------------------------------------------------");
    
                    checkDivisibility();
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    break;
                case 1:
                    for_loop();
                    break;
                case 2:
                    switch_case();
                    break;
                case 3:
                    while_loop();
                    break;
                case 4:
                    square_pattern();
                    break;
                case 5:
                    prime_number();
                    break;
                case 6:
                    prime_number_till_n();
                    break;
                case 7:
                    fibonacci();
                    break;
                case 8:
                    LCM();
                    break;
                case 9:
                    GCD();
                    break;
                case 10:
                    guessTheNumber();
                    break;
                case 11:
                    summationOfDigits();
                    break;
                case 12:
                    printDigits();
                    break;
                case 13:
                    checkEvenOrOdd();
                    break;
                case 14:
                    checkValidTriangleAngles();
                    break;
                case 15:
                    checkDate();
                    break;
                case 16:
                    checkDivisibility();
                    break;
                case 17:
                    System.out.println("Exiting the program.");
                    sc.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

    }

    // Determine Weekday, Month, Name of day
    public static boolean isWeekDay(int dayNumber) {
        switch (dayNumber) {
            case 7:
                return false;
            case 6:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
        }
        return false;
    }

    public static String determineNameOfMonth(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "Invalid_monthNumber";
    }

    public static String determineNameOfDay(int dayNumberr) {
        switch (dayNumberr) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
        }
        return "Invalid Day";
    }

    // Check if divisible by three
    public static boolean isDivisibleByThree(int value) {
        return value % 3 == 0;
    }

    // Check if divisible by five
    public static boolean isDivisibleByFive(int value) {
        return value % 5 == 0;
    }

    // Check if divisible by threeorfive
    public static boolean isDivisibleByThreeOrFive(int value) {
        return value % 3 == 0 || value % 5 == 0;
    }


    static boolean isPrime(int number) {
        for (int x = 2; x < number; x++) {
            if (number % x == 0) {
                return false;
            }

        }
        return true;
    }
}
