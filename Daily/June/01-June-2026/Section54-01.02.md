## App03GamingSpringBeans.java
```
package com.learning.coding;

import com.learning.coding.game.GameRunner;
import com.learning.coding.game.GamingConsole;
import com.learning.coding.game.PacManGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.learning.coding.game;")
public class App03GamingSpringBeans {

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        System.out.println("Game - " + game);
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

    public static void main(String[] args) {
        try(var context =
                    new AnnotationConfigApplicationContext
                            (App03GamingSpringBeans.class)) {

//            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
```