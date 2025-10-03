class BookRunner {
    public static void main(String[] args) {
        Book artOfComputerProgramming = new Book();
        Book cleanCode = new Book();
        Book effectiveJava = new Book();

        artOfComputerProgramming.noOfCopies = 100;
        cleanCode.noOfCopies = 50;
        effectiveJava.noOfCopies = 45;
    }
}
class Book {
    int noOfCopies;
}