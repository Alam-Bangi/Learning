class PatternMatchingRunner {
    public static void main(String[] args) {
        // Object objStr = "Some String";

        // instanceOfNew(objStr);
        // instanceOfOld(objStr);

        printTransactonOld(new Transaction("ABC", "XYZ", 10000));
        printTransactonNew(new Transaction("XYZ", "ABC", 1000));
    }

    private static void instanceOfNew(Object objStr) {
        if (objStr instanceof String str) {
            System.out.println(str.toLowerCase());
        }
    }

    private static void instanceOfOld(Object objStr) {
        if (objStr instanceof String) {
            String str = (String) objStr;
            System.out.println(str.toLowerCase());
        }
    }

    record Transaction(String sender, String receiver, int amount) {

    }

    private static void printTransactonOld(Object objTransaction) {
        if (objTransaction instanceof Transaction transaction) {
            String sender = transaction.sender();
            String receiver = transaction.receiver();
            int amount = transaction.amount();

            System.out.println("Sender: " + sender);
            System.out.println("Receiver: " + receiver);
            System.out.println("Amount: " + amount);
        }
    }

    private static void printTransactonNew(Object objTransaction) {
        if (objTransaction instanceof Transaction(String sender, String receiver, int amount)) {

            System.out.println("Sender: " + sender);
            System.out.println("Receiver: " + receiver);
            System.out.println("Amount: " + amount);
        }
    }
}
