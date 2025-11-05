class PrimeNumbersUsingThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new GetPrimeNumbers());
        thread.start();
        thread.join(); 
    }
}

class GetPrimeNumbers extends Thread {
    @Override
    public void run() {
        int count = 1;
        int num = 2;

        System.out.println("First 10 Prime Numbers are: ");
        while (count<=10) {
            if (isPrime(num)) {
                System.out.println("("+count+") "+num);
                count++;
            }
            num++;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
