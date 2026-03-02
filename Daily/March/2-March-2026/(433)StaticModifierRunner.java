class StaticModifierRunner {
    public static void main(String[] args) {
        Player player1 = new Player("Valverde");
        System.out.println(player1.getCount());
        Player player2 = new Player("Asensio");
        System.out.println(player2.getCount());
    }
}

class Player {
    private String name;
    private static int count = 0;

    public Player(String name) {
        super();
        this.name = name;
        count++;
    }

    public int getCount() {
        return count;
    }
}