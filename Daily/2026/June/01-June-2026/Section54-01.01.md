## App03GamingSpringBeans.java
```
package com.learning.coding;

import com.learning.coding.game.GameRunner;
import com.learning.coding.game.GamingConsole;
import com.learning.coding.game.PacManGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App03GamingSpringBeans {

    @Bean
    public GamingConsole game() {
        var game = new PacManGame();
        return game;
    }
    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
    public static void main(String[] args) {
        try(var context =
                    new AnnotationConfigApplicationContext
                            (App03GamingSpringBeans.class)) {

            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
```