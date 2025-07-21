class Main {
    public static void main(String[] args) {
        int sumOfSquares;
        int number = 5;
        int sum=0;
        int sq =0;
        for (int i=1; i<=number; i++) {
            sq = i*i;
            System.out.println(sq);
            sum = sum+sq;
        }
         System.out.println(sum);
    }
}