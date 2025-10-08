class IfStatementRunner {
    public static void main(String[] args) {
        int number = 25;

        if(number == 25) {
            System.out.println("number = 25");
        }else if (number == 24) {
            System.out.println("number = 24");
        } else if (number == 23) {
            System.out.println("number = 23");
        } else {
            System.out.println("number != 23 and number != 24 and number != 25");
        }
    }
}