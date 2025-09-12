class GameRunner {
    public static void main(String[] args) {
        // MarioGame game = new MarioGame();
        GamingConsole game = new MarioGame();
        game.up();
        game.down();
        game.left();
        game.right();

        // ChessGame play = new ChessGame();
        GamingConsole play = new ChessGame();
        play.up();
        play.down();
        play.left();
        play.right();
    }
}
public interface GamingConsole {
    public void up();
    public void down();
    public void left();
    public void right();
}
class MarioGame implements GamingConsole {
    public void up() {
        System.out.println("Jumps");
    }
    public void down() {
        System.out.println("Slides");
    }
    public void left() {
        
    }
    public void right() {
        System.out.println("Go Forward");
    }
}
class ChessGame implements GamingConsole {
    public void up() {
        System.out.println("Move piece upwards");
    }
    public void down() {
        System.out.println("Move piece downwards");
    }
    public void left() {
        System.out.println("Move piece to left");
    }
    public void right() {
        System.out.println("Move piece to right");
    }
}