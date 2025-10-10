class MyNumberRunner {
    public static void main(String[] args) {
        MyNumber number = new MyNumber(9);
        boolean isPrime = number.isPrime();
        System.out.println("isPrime " + isPrime);
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
}