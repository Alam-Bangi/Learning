## App01GamingBasicJava.java
```
package com.learning.coding;

import com.learning.coding.game.GameRunner;
import com.learning.coding.game.PacmanGame;

public class App01GamingBasicJava {
	public static void main(String[] args) {
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		var game = new PacmanGame(); //1: Object Creation
		var gameRunner = new GameRunner(game); 
			//2: Object Creation + Wiring of Dependencies
			// Game is a Dependency of GameRunner
		gameRunner.run();
	}
}
```
## App03GamingSpringBeans.java
```
package com.learning.coding;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.coding.game.GameRunner;
import com.learning.coding.game.GamingConsole;

public class App03GamingSpringBeans {
	public static void main(String[] args) {
		try (var context = 
				new AnnotationConfigApplicationContext
					(GamingConfiguration.class)) {

			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}
}
```
## GamingConfiguration.java
```
package com.learning.coding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.coding.game.GameRunner;
import com.learning.coding.game.GamingConsole;
import com.learning.coding.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
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
## App02HelloWorldSpring.java
```
package com.learning.coding;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        var context =
            new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println("Direct Object Creation: ");
        System.out.println(context.getBean("person"));
        System.out.println("Bean creation using method calls:");
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println("Bean creation using method parameters:`");
        System.out.println(context.getBean("person3Parameters"));
        System.out.println("Bean naming: ");
        System.out.println(context.getBean("myAddress"));
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean(Address.class));
        System.out.println(context.getBean("person5qualifier"));
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
```
## HelloWorldConfiguration.java
```
package com.learning.coding;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

class Person {
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String toString() {
        return name + " " + age + " [" + address + "]";
    }
}
class Address {
    private String line1;
    private String city;

    public Address(String line1, String city) {
        this.line1 = line1;
        this.city = city;
    }
    public String getLine1() {
        return line1;
    }
    public String getCity() {
        return city;
    }
    public String toString() {
        return line1 + city;
    }
}

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Alam";
    }
    @Bean
    public int age(){
        return 23;
    }
    @Bean
    public Person person() {
        return new Person("Amaan", 24, new Address("307, Ghorpade", ", Pune - 42"));
    }
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }
    @Bean
    public Person person3Parameters(String name, int age, Address myAddress) {
        return new Person(name, age, myAddress);
    }
    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address myAddress2) {
        return new Person(name, age, myAddress2);
    }
    @Bean
    public Person person5qualifier(String name, int age, @Qualifier("address1qualifier") Address myAddress2) {
        return new Person(name, age, myAddress2);
    }
    @Bean(name = "myAddress")
    @Primary
    public Address address() {
        return new Address("246, Ghorpade", ", Pune - 42");
    }
    @Bean(name = "myAddress1")
    @Qualifier("address1qualifier")
    public Address address2() {
        return new Address("307, Ghorpade", ", Pune - 42");
    }
}
```