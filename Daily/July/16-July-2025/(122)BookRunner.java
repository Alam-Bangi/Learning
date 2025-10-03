class BookRunner {
    public static void main(String[] args) {
        Book artOfComputerProgramming = new Book(100);
        Book cleanCode = new Book(50);
        Book effectiveJava = new Book(75);

        artOfComputerProgramming.setNoOfCopies(100);
        cleanCode.setNoOfCopies(50);
        effectiveJava.setNoOfCopies(45);
    }
}
class Book {
    int noOfCopies;

    public Book(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }
    void setNoOfCopies(int noOfCopies) {
        if(noOfCopies > 0)
        this.noOfCopies = noOfCopies;
    }
    void increaseNoOfCopies(int howMuch) {
        setNoOfCopies(this.noOfCopies + howMuch);
    }
    void decreaseNoOfCopies(int howMuch) {
        setNoOfCopies(this.noOfCopies - howMuch);
    }
}