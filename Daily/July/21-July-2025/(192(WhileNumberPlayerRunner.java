class WhileNumberPlayerRunner {
    public static void main(String[] args) {
        WhileNumberPlayer player = new WhileNumberPlayer(1, 10);
        player.printSquaresUptoLimit();
        player.printCubesUptoLimit();
    }
}
class WhileNumberPlayer {
    private int limit;

    public WhileNumberPlayer(int limit, int end) {
        this.limit = limit;
    }

    public void printSquaresUptoLimit() {
        int i = 1;
        while (i*i<limit) {
            System.out.println("Square of " + i + " is " + (i * i));
            i++;
        }
    }

    public void printCubesUptoLimit() {
        int i = 1;
        while (i*i*i<limit) {
            System.out.println("Cube of " + i + " is " + (i * i * i));
            i++;
        }
    }
}