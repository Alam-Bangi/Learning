class Fibonacci {
    public static void main(String[] args) {
        int a =0;
        int b =1;
        int sum;
        int digits = 10; 
        sum = a + b;
        System.out.print(a + " " + b + " " + sum + " ");

        for(int i=2; i<digits; i++) {
            a = b;
            b = sum;
            sum = a + b;
            System.out.print(sum + " ");
        }
    }
}