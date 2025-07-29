class Main {
    public static void main(String[] args) {
        int number1 = 96;
        int number2 = 24;
        // int min = 0;
        int gcd = 0;
        if(number1>number2) {
            gcd = number2;
        } else {
            gcd = number1;
        }
        // min = gcd;
        for (; gcd!=1; ) {
            if (number1%gcd==0 && number2%gcd==0) {
                System.out.println("GCD of " +number1 + " & " +number2 + " is " + gcd);
                break;
            }
            gcd = gcd - 1;
            
        }
    }
}