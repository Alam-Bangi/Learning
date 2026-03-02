class StaticModifierRunner {
    public static void main(String[] args) {
        Player player1 = new Player("Valverde");
        Player player2 = new Player("Asensio");
        System.out.println(Player.getCount());
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

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}