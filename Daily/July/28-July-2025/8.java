class Main {
    public static void main(String[] args) {
        int number = 12445;
        int countOfDigit = 0;
        for (; number!=0; ) {
            int digit = number%10;
            countOfDigit = countOfDigit + 1;
            number=number/10;
            if (countOfDigit%2!=0) {
                System.out.println("Digits at odd position are: " +digit);
            }
        }
    }
}