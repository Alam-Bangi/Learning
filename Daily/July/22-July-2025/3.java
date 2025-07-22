class Main {
    public static void main(String[] args) {
        int number = 15;
        // int fact = 1;
        for (int i=1; i<=number; i++) {
            if(number%i==0){
                System.out.println(i);
            }
        }
    }
}