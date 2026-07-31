## 1. What is abstraction in Java?

**Abstraction is the process of hiding implementation details and exposing only the essential functionality to the user. It allows users to focus on what an object does rather than how it does it. In Java, abstraction is achieved using abstract classes and interfaces.**

**Example:**

> When using an ATM, you can withdraw money without knowing how the banking system processes the transaction internally.

---

## 2. Why do we use abstraction?

We use abstraction to:

* Hide complex implementation details.
* Reduce code complexity.
* Improve security by exposing only necessary features.
* Increase code maintainability.
* Support loose coupling and better design.

---

## 3. How is abstraction achieved in Java?

Java provides two ways:

1. Abstract class
2. Interface

An abstract class is suitable when classes share common behavior and state. An interface is used to define a contract that multiple unrelated classes can implement.

---

## 4. What is an abstract class?

An abstract class is a class declared with the `abstract` keyword. It cannot be instantiated and may contain both abstract methods (without implementation) and concrete methods (with implementation).

Example:

```java
abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("Eating");
    }
}
```

---

## 5. Can we create an object of an abstract class?

No.

An abstract class cannot be instantiated because it may contain incomplete methods.

```java
Animal a = new Animal(); // Compile-time error
```

---

## 6. Can an abstract class have constructors?

Yes.

Although we cannot create an object of an abstract class directly, its constructor is called when a subclass object is created.

```java
abstract class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}
```

---

## 7. Can an abstract class have normal methods?

Yes.

An abstract class can contain:

* Abstract methods
* Concrete methods
* Constructors
* Variables

---

## 8. What is an abstract method?

An abstract method is declared without a body.

```java
abstract void sound();
```

Every concrete subclass must implement it.

---

## 9. Can an abstract class have static methods?

Yes.

```java
abstract class Test {
    static void display() {
        System.out.println("Hello");
    }
}
```

---

## 10. Can an abstract class have final methods?

Yes.

A final method cannot be overridden.

```java
final void show() {
}
```

---

## 11. Can abstract methods be final?

No.

`abstract` means the method must be overridden, while `final` means it cannot be overridden. These keywords conflict.

---

## 12. Can abstract methods be static?

No.

Static methods belong to the class and cannot be overridden, while abstract methods require overriding.

---

## 13. What happens if a subclass doesn't implement all abstract methods?

The subclass must also be declared abstract.

```java
abstract class Dog extends Animal {
}
```

---

## 14. What is an interface?

An interface defines a contract that implementing classes must follow. It specifies what a class should do, not how it should do it.

```java
interface Vehicle {
    void start();
}
```

---

## 15. Difference between abstract class and interface?

| Abstract Class                                 | Interface                                             |
| ---------------------------------------------- | ----------------------------------------------------- |
| Uses `extends`                                 | Uses `implements`                                     |
| Can have constructors                          | No constructors                                       |
| Can have instance variables                    | Variables are `public static final` by default        |
| Can contain both abstract and concrete methods | Can contain abstract, `default`, and `static` methods |
| Supports single inheritance                    | Supports multiple inheritance                         |

---

## 16. When should you use an abstract class?

Use an abstract class when:

* Classes share common code.
* You want to provide default implementations.
* You need constructors or instance variables.

Example:

* Employee
* Animal
* Shape

---

## 17. When should you use an interface?

Use an interface when:

* Unrelated classes need the same capability.
* You need multiple inheritance of behavior.
* You want to define a contract.

Example:

```java
interface Printable {}
interface Serializable {}
```

---

## 18. Can an abstract class implement an interface?

Yes.

It doesn't have to implement all methods.

```java
interface A {
    void show();
}

abstract class B implements A {
}
```

---

## 19. Can an interface extend another interface?

Yes.

```java
interface A {
}

interface B extends A {
}
```

---

## 20. Can a class implement multiple interfaces?

Yes.

```java
interface A {}
interface B {}

class Test implements A, B {
}
```

---

## 21. Why does Java not support multiple inheritance with classes but allow multiple interfaces?

Multiple inheritance with classes can cause ambiguity (the "diamond problem") if two parent classes define the same method. Interfaces avoid this because they define contracts, and modern Java provides rules for resolving conflicts between default methods.

---

## 22. Can an interface have method implementations?

Yes.

Since Java 8:

* `default` methods
* `static` methods

Since Java 9:

* `private` methods

---

## 23. Is abstraction different from encapsulation?

Yes.

| Abstraction                                    | Encapsulation                                                  |
| ---------------------------------------------- | -------------------------------------------------------------- |
| Hides implementation details                   | Hides data                                                     |
| Focuses on what an object does                 | Focuses on protecting an object's state                        |
| Achieved using abstract classes and interfaces | Achieved using access modifiers (`private`, `protected`, etc.) |

---

## 24. Give a real-world example of abstraction.

A car dashboard exposes controls like the steering wheel, pedals, and ignition. You can drive the car without knowing how the engine, transmission, or fuel injection system works internally. The dashboard provides an abstract view of a much more complex system.

---

## 25. Interview Answer (1-minute)

> "Abstraction is one of the core principles of object-oriented programming. It means hiding implementation details and exposing only the essential functionality to users. In Java, abstraction is achieved through abstract classes and interfaces. An abstract class is useful when related classes share common state or behavior, while an interface defines a contract that different classes can implement. Abstraction helps reduce complexity, improves maintainability, and supports loose coupling, making applications easier to extend and test."

This set of questions and answers covers the abstraction topics commonly asked in Java interviews, from beginner to experienced levels.
