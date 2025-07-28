class Main {
    public static void main(String[] args) {
        int number = 12445;
        // int evenDigit = 0;
        for (; number!=0; ) {
            int digit = number%10;
            // evenDigit = digit + 0;
            number=number/10;
            if (digit%2==0) {
                System.out.println("Digits which are even: " +digit);
            }
        }
    }
}