class Main {
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 1;
        int sum;
        int numberOfDigits = 10;
        sum = n1+ n2;
        System.out.print(n1+" "+n2 +" ");
        
        for(int i = 0; i<numberOfDigits-2; i++) {
            
            n1 = n2;
            n2 = sum;
            sum = n1+ n2;
            System.out.print(sum+" ");
        }
    }
}