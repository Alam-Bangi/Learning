class BookRunner {
    public static void main(String[] args) {
        Book artOfComputerProgramming = new Book();
        Book cleanCode = new Book();
        Book effectiveJava = new Book();

        artOfComputerProgramming.setNoOfCopies(100);
        cleanCode.setNoOfCopies(50);
        effectiveJava.setNoOfCopies(45);
    }
}
class Book {
    int noOfCopies;

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