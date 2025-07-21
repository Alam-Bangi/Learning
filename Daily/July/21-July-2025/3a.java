class Main {
    public static void main(String[] args) {
        int numberTriangle;
        int number=5;
        
        for(int i=0; i<number; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}