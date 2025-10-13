class TernaryEx {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int max = (a > b) ? a : b;
        System.out.println("The maximum value is: " + max);

        int x = 15;
        int y = 25;
        int z = 20;
        int largest = (x > y) ? (x > z ? x : z) : (y > z ? y : z);
        System.out.println("The largest value is: " + largest);
    }
}