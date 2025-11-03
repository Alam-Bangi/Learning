class ThreadsBasicRunner {
    public static void main(String[] args) {
        for( int i = 101; i<=109; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask1 Done");

        for( int i = 201; i<=209; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask2 Done");

        for( int i = 301; i<=309; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask3 Done");

        System.out.print("\nMain Done");
    }
}