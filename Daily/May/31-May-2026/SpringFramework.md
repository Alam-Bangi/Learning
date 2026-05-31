## App02HelloWorldSpring.java
```
package com.learning.coding;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
//        System.out.println(context.getBean(Address.class));

    }
}
```
## HelloWorldConfiguration
```
package com.learning.coding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return new Person("Amaan", 24, new Address("246, Ghorpade", ", Pune - 42"));
    }
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }
    @Bean
    public Person person3Parameters(String name, int age, Address myAddress) {
        return new Person(name, age, myAddress);
    }
    @Bean(name = "myAddress")
    public Address address() {
        return new Address("246, Ghorpade", ", Pune - 42");
    }
}
```