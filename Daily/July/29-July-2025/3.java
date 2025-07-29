class Main {
    public static void main(String[] args) {
       int number = 12345;
       int divisor;
       int tempNumber = number;
       divisor = 1;
       
       while (tempNumber / divisor >= 10) {
           divisor = divisor * 10;
       }
       
       while ( divisor != 0) {
           int digit = number / divisor;
           System.out.println(digit);
           number = number % divisor;
           divisor = divisor / 10;
       }
    }
}