
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int number = 10;
        // For Loop
        for (int i = 0; i<10; i++) {
            System.out.println("Hello World");
        }
        // If Else Statement
        if (number < 10) {
            System.out.println("Hi");
        } else {
            System.out.println("Hey");
        }
        // Switch statement
        switch(number) {
            case 1 : System.out.println("Number is Less than 10");
            break;
            case 5 : System.out.println("Number is Less than 10");
            break;
            case 10 : System.out.println("Correct Number");
            break;
            default : System.out.println("Wrong Number");
        }
        
        // While 
        while (number<=10) {
            System.out.println(number);
            break;
        }
        // Square Pattern
        for (int row = 0; row<number; row++) {
            for (int col=0; col<number; col++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        // Prime Number
        int prime=19;
        boolean isDivisible = false;
        for (int no=2; no<prime; no++) {
            if (prime%no==0) {
                System.out.println("Not a prime number");
                isDivisible=true;
                break;
            } 
            // else if(prime%no==1) { 
            //     System.out.println("prime number");
            //     break;
            // }
        }
        if (isDivisible==false ) {
            System.out.println("Number is Prime");
        }
        // System.out.println(isPrime(35));
        for (int i = 3; i<100; i++) {
            // System.out.println(i);
            // boolean answer= isPrime();
            boolean answer = isPrime(i);
            if(answer) {
                System.out.println(i);
            }
        }
        // Fibonacci
        int fib = 5;
        int n1=0;
        int n2=1;
        int sum=n1+n2;
        System.out.print(n1+" "+n2 + " " );
        
        for (int f= 0; f<fib; f++) {
            sum= n1+ n2;
            n1=n2;
            n2=sum;
            System.out.print( sum + " ");
        }
        System.out.println("");
        
        // LCM
        int num1 = 5;
        int num2 = 8;
        int lcm=0;
        int max;
        if(num1<num2) {
            max = num2;
        } else {
            max = num1;
        }
        lcm = lcm + max;
        for(; lcm!=0; ) {
            if (lcm%num1==0 && lcm%num2==0) {
                System.out.println("LCM of "+num1 +" & " +num2 +" is " +lcm);
                break;
            }
        lcm = lcm + max;
        }
        
        // GCD
        int number1 = 82;
        int number2 = 20;
        int gcd=0;
        
        if(number1>number2) {
            gcd = number2;
        } else {
            gcd = number1;
        }
        for (; gcd!=0;) {
            if (number1%gcd==0 && number2%gcd==0) {
                System.out.println("GCD of "+number1 +" & " +number2 +" is " +gcd);
                break;
            }
        gcd = gcd-1;
        }
        // Random Number
        int randomNumber =50;
        int number0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: " );
        number0 = input.nextInt();
       
        for (; number0 != randomNumber; ) { 
            if (number0 < randomNumber) {
                System.out.println("Number is smaller than random number.");
            } else {
                System.out.println("Number is greater than random number.");
            }
            System.out.println("Enter a number: " );
            number0 = input.nextInt();
        }
        System.out.println("You've entered the correct number.");
        
        // Summation of digits
        int number12 = 12345;
        int sum1 = 0;
        for (; number12!=0; ) {
            int lastDigit = number12%10;
            
            sum1 = sum1 + lastDigit;
            number12=number12/10;
        }
        System.out.println("Sum of all digits is: " +sum1);
        
        // Print digits of number
        
        int number123 = 54321;
        int tempNumber = number123;
        int divisor=10;
        
        while(tempNumber/divisor > 10) {
            divisor = divisor*10;
        }
        
        while (divisor>0) {
            int digit = number123/divisor;
            System.out.println(digit);
            number123 = number123%divisor;
            divisor= divisor/10;
        }
        
        // Even or Odd Number
        int numberCheck = 2025;
        if (numberCheck%2==0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
        
        // Valid Triangle
        int triangle=180;
        int angle1 = 90;
        int angle2 = 40;
        int angle3 = 50;
        if(angle1 + angle2 + angle3 == triangle) {
            System.out.println("Triangle is Valid");
        } else {
            System.out.println("Triangle is not Valid");
        }
        
        
        System.out.println(isWeekDay(1));
        System.out.println(determineNameOfMonth(8));
        System.out.println(determineNameOfDay(5));
        
        System.out.println(isDivisibleByThree(9));
        System.out.println(isDivisibleByFive(16));
        System.out.println(isDivisibleByThreeOrFive(18));
    }   
        // Determine Weekday, Month, Name of day
    public static boolean isWeekDay (int dayNumber) {
         switch (dayNumber) {
            case 7 : return false;
            case 6 : return false;
            case 1 : return true;
            case 2 : return true;
            case 3 : return true;
            case 4 : return true;
            case 5 : return true;
        }
        return false;
    }
    
     public static String determineNameOfMonth(int monthNumber) {
        switch (monthNumber) {
            case 1 : return "January";
            case 2 : return "February";
            case 3 : return "March";
            case 4 : return "April";
            case 5 : return "May";
            case 6 : return "June";
            case 7 : return "July";
            case 8 : return "August";
            case 9 : return "September";
            case 10 : return "October";
            case 11 : return "November";
            case 12 : return "December";
        }
        return "Invalid_monthNumber";
    }
    
     public static String determineNameOfDay(int dayNumberr) {
        switch (dayNumberr) {
            case 1 : return "Monday";
            case 2 : return "Tuesday";
            case 3 : return "Wednesday";
            case 4 : return "Thursday";
            case 5 : return "Friday";
            case 6 : return "Saturday";
            case 7 : return "Sunday";
        }
        return "Invalid Day";
    }
    
    // Check if divisible by three
    public static boolean isDivisibleByThree (int value) {
        if(value%3==0) 
            return true;
        else {
            return false;
        }
    }
    
    // Check if divisible by five
    public static boolean isDivisibleByFive (int value) {
        if(value%5==0) 
            return true;
        else {
            return false;
        }
    }
    
    // Check if divisible by threeorfive
    public static boolean isDivisibleByThreeOrFive (int value) {
        if(value%3==0 || value%5==0) 
            return true;
        else {
            return false;
        }
    }
    
    
    
    static boolean isPrime (int number) {
        for (int x = 2; x<number; x++) {
            if(number%x==0) {
                return false;
            }
            
        }
    return true;
    }
}