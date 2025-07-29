class Main {
    public static void main(String[] args) {
        int number = 12345;
        for (; number!=0; ) {
            int lastDigit = number%10;
            System.out.println("Digits of number is: " +lastDigit);
            number=number/10;
        }
    }
}