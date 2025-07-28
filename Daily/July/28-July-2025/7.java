class Main {
    public static void main(String[] args) {
        int number = 12345;
        int countOfDigit = 0;
        for (; number!=0; ) {
            int lastDigit = number%10;
            
            countOfDigit = countOfDigit + 1;
            number=number/10;
        }
        System.out.print("Count of Digits is: " +countOfDigit);
    }
}