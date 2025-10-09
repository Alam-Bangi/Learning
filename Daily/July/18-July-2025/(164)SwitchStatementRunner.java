class IfConditionRunner {
    public static void main(String[] args) {
        // puzzle1();
        // puzzle2();
        // puzzle3();
        puzzle4();
    }

    private static void puzzle1() {
        int number = 2;

        switch (number) {
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("Three");
            default:
                System.out.println("Default");
        }
       
    }

    private static void puzzle2() {
        int number = 2;

        switch (number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
            case 3:
                System.out.println("Two or Three");
                break;
            default:
                System.out.println("Default");
                break;
        }
    }
    private static void puzzle3() {
        int number = 10;

        switch (number) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println("Default");
        }
    }

    private static void puzzle4() {
        int number = 10;

        switch (number) {
            default:
                System.out.println("Default");
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
                break;
        }
    }

    private static void puzzle5() {
        int number = 10;
        int i = number * 2;
        switch (number) {
            // case number>5: System.out.println("Greater than 5");
            //     break;
        }
    }
}