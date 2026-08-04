> **Inheritance in Java** is an object-oriented programming concept that allows one class (called the **child** or **subclass**) to acquire the properties and methods of another class (called the **parent** or **superclass**) using the `extends` keyword.

> The main purpose of inheritance is **code reusability**, **method overriding for runtime polymorphism**, and creating an **"is-a" relationship** between classes.

> **Example:**

> ```java
> class Animal {
>     void eat() {
>         System.out.println("Animal is eating");
>     }
> }
>
> class Dog extends Animal {
>     void bark() {
>         System.out.println("Dog is barking");
>     }
> }
>
> public class Main {
>     public static void main(String[] args) {
>         Dog d = new Dog();
>         d.eat();   // Inherited method
>         d.bark();  // Child class method
>     }
> }
> ```
>
> Here, `Dog` inherits the `eat()` method from `Animal`, so we don't need to write it again.

You can then add these interview points:

* **Types of inheritance supported in Java classes:**

  * Single inheritance ✅
  * Multilevel inheritance ✅
  * Hierarchical inheritance ✅
  * Multiple inheritance ❌ (not with classes, to avoid ambiguity; Java supports it through interfaces)
  * Hybrid inheritance ❌ (possible through interfaces)

* **Advantages:**

  * Promotes code reuse.
  * Makes code easier to maintain.
  * Supports method overriding and runtime polymorphism.
  * Models real-world relationships using the "is-a" relationship.

* **Important keywords:**

  * `extends` – used for class inheritance.
  * `super` – used to access parent class constructors, methods, and variables.
  * `protected` – members are accessible in subclasses.

### Interview-friendly 1-minute answer

> "Inheritance is one of the core OOP concepts in Java. It allows one class to inherit the properties and methods of another class using the `extends` keyword. The child class can reuse the parent's code and also add new functionality or override existing methods. This promotes code reusability, maintainability, and supports runtime polymorphism. Java supports single, multilevel, and hierarchical inheritance through classes, while multiple inheritance is achieved using interfaces to avoid ambiguity."

### If the interviewer asks, "Why doesn't Java support multiple inheritance with classes?"

You can answer:

> "Java does not support multiple inheritance with classes to avoid the **Diamond Problem**, where a child class inherits the same method from two parent classes, creating ambiguity about which implementation to use. Instead, Java allows multiple inheritance through interfaces, where conflicts can be resolved explicitly."
