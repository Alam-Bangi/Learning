class Main {
    public static void main(String[] args) {
        int number = 1234561;
        int originalNumber = number;
        int sum = 0;
        for (; number!=0; ) {
            int lastDigit = number%10;
            
            sum = sum + lastDigit;
            number=number/10;
        }
        // System.out.println("Sum of all digits is: " +sum);
        if (sum%2==0) {
            System.out.println("Summation of number " +originalNumber + " is even and summation is " +sum);
        } else {
            System.out.println("Summation of number " +originalNumber + " is odd and summation is " +sum);
        }
    }
}