class Main {
    public static void main(String[] args) {
        int sumOfDivisors;
        int number = 9;
        
        int sum=0;
        
        for (int i=2; i<number; i++) {
            if(number%i ==0){
                sum = sum+i;
            }
        }
        System.out.println(sum);
    }
}