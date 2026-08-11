> **“An abstract class in Java is a class that cannot be instantiated directly and is used as a base class for related classes. It can contain both abstract methods, which don't have a body, and concrete methods, which have an implementation.**
>
> **An abstract class can also have constructors, instance variables, static methods, and non-static methods. A subclass extends the abstract class and must implement its abstract methods unless the subclass is also abstract.**
>
> **For example, if I have an abstract `Vehicle` class with an abstract `start()` method, classes like `Car` and `Bike` can extend `Vehicle` and provide their own implementation of `start()`.**
>
> **I would use an abstract class when multiple related classes share common state or behavior, but some behavior needs to be implemented differently by each subclass.”**

### Simple example

```java
abstract class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println("Car starts with a key");
    }
}
```

### If the interviewer asks “Why abstract class?”

Say:

> **“It provides partial abstraction. I can put common fields and common functionality in the abstract class, while forcing subclasses to implement specific behavior.”**

### Common follow-up: Abstract class vs Interface

A strong short answer:

| Abstract Class                                      | Interface                                       |
| --------------------------------------------------- | ----------------------------------------------- |
| Extended using `extends`                            | Implemented using `implements`                  |
| Can have instance variables/state                   | Mainly defines a contract; fields are constants |
| Can have constructors                               | Cannot have constructors                        |
| A class can extend only one class                   | A class can implement multiple interfaces       |
| Good for closely related classes sharing code/state | Good for defining a common capability/contract  |

**Interview tip:** Don't just memorize the definition. The phrase **“partial abstraction + shared state/common implementation + subclass-specific behavior”** is a very good way to remember the purpose of an abstract class.
