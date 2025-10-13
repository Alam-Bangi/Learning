class Swap2Numbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 0;
        System.out.println("Before swapping: a = " + a + ", b = " + b);
        
        c = a;
        a = b;
        b = c;
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}