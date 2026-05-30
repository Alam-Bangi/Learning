## App01GamingBasic.java
```
package com.learning.coding;

import com.learning.coding.game.GameRunner;
import com.learning.coding.game.MarioGame;
import com.learning.coding.game.PacManGame;
import com.learning.coding.game.SuperContraGame;

public class App01GamingBasic {
    public static void main(String[] args) {
        var game = new MarioGame();
//        var game = new SuperContraGame();
//        var game = new PacManGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
```
## GameRunner.java
```
package com.learning.coding.game;

public class GameRunner {
    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
```
## GamingConsole.java
```
package com.learning.coding.game;

public interface GamingConsole {
    void up();
    void down();
    void left();
    void right();
}
```
## MarioGame.java
```
package com.learning.coding.game;

public class MarioGame implements GamingConsole {
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Go into a hole");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Accelerate");
    }

    @Override
    public String toString() {
        return "Mario";
    }
}
```
## SuperContraGame.java
```
package com.learning.coding.game;

public class SuperContraGame implements GamingConsole{
    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Sit Down");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Shoot");
    }

    @Override
    public String toString() {
        return "SuperContra";
    }
}
```
## PacManGame.java
```
package com.learning.coding.game;

public class PacManGame implements GamingConsole{
    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Down");
    }

    public void left() {
        System.out.println("Left");
    }

    public void right() {
        System.out.println("Right ");
    }

    @Override
    public String toString() {
        return "PacMan";
    }
}
```
