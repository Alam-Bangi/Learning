## App02HelloWorldSpring.java
```
package com.learning.coding;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        var context =
            new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        System.out.println(context.getBean("name"));
    }
}
```
## HelloWorldConfiguration.java
```
package com.learning.coding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Alam";
    }


}
```