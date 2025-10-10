class MyNumberRunner {
    public static void main(String[] args) {
        MyNumber number = new MyNumber(9);
        boolean isPrime = number.isPrime();
        System.out.println("isPrime " + isPrime);

        int sum = number.sumUptoN();
        System.out.println("Sum upto N " + sum);

        int sumOfDivisors = number.sumOfDivisors();
        System.out.println("Sum of divisors " + sumOfDivisors);
        
    }
}
class MyNumber {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        if (number < 2) {
            return false;
        }
        for (int i =2; i <=number; i++) {
            if (number%i == 0) {
                return false;
            }
        }
        return true;
    }
    public int sumUptoN() {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum = sum + i;
        }
        return sum;
    }
    public int sumOfDivisors() {
        int sum = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}