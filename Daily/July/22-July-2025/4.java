class Main {
    public static void main(String[] args) {
        int a = 5;
        int b =10;
        int c = 0;
        
        System.out.println("Value before swapping a-"+a +" b-"+b);
        
         c = a;
         a = b;
         b = c;
        
        System.out.println("Value after swapping a-"+a +" b-"+b);
    }
}