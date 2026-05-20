```
| Feature               | Structured Programming                     | Object-Oriented Programming (OOP)      |
| --------------------- | ------------------------------------------ | -------------------------------------- |
| **Focus**             | Functions (procedures)                     | Objects (data + methods)               |
| **Data Handling**     | Stored separately, functions operate on it | Encapsulated within objects            |
| **Reusability**       | Code is reused via functions               | Code is reused via classes and objects |
| **Scalability**       | Harder to scale for large apps             | Easy to extend and maintain            |
| **Example Languages** | C, Pascal, ...                             | Java, C++, ...                         |

```
# Design Patterns
```
1. Creational Design Patterns
These deal with object creation.
Pattern	Purpose
Singleton	        Only one object exists
Factory Method	    Creates objects without exposing creation logic
Abstract Factory	Creates families of related objects
Builder	            Builds complex objects step-by-step
Prototype	        Creates objects by cloning

- Singleton Pattern
Ensures only one instance exists.
    class Singleton {
        private static Singleton obj;
        private Singleton() {}
        public static Singleton getInstance() {
            if (obj == null) {
                obj = new Singleton();
            }
            return obj;
        }
    }

Use Cases
    Database connection
    Logger
    Configuration manager

- Factory Pattern
Creates objects based on input.
    interface Animal {
        void sound();
    }
    class Dog implements Animal {
        public void sound() {
            System.out.println("Bark");
        }
    }
    class Cat implements Animal {
        public void sound() {
            System.out.println("Meow");
        }
    }
    class AnimalFactory {
        public Animal getAnimal(String type) {
            if(type.equals("dog"))
                return new Dog();
            else
                return new Cat();
        }
    }

2. Structural Design Patterns
These deal with class/object structure.

Pattern	Purpose
Adapter	    Converts one interface to another
Decorator	Adds functionality dynamically
Facade	    Provides simplified interface
Proxy	    Controls access to object
Composite	Tree structure for objects

- Adapter Pattern
Makes incompatible interfaces work together.

Real-life Example

Phone charger adapter.
    interface MediaPlayer {
        void play(String audioType);
    }
    class Mp4Player {
        void playMp4() {
            System.out.println("Playing MP4");
        }
    }
    class Adapter implements MediaPlayer {
        Mp4Player player = new Mp4Player();
        public void play(String audioType) {
            player.playMp4();
        }
    }

3. Behavioral Design Patterns
    These deal with communication between objects.
Pattern	Purpose
Observer	One-to-many notification
Strategy	Multiple algorithms interchangeable
Command	    Encapsulates requests
Iterator	Sequential access to collection
State	    Changes behavior based on state

- Observer Pattern
    When one object changes, others are notified.

    import java.util.*;
    interface Observer {
        void update(String msg);
    }
    class User implements Observer {
        String name;
        User(String name) {
            this.name = name;
        }
        public void update(String msg) {
            System.out.println(name + " received: " + msg);
        }
    }
    class Channel {
        List<Observer> users = new ArrayList<>();
        void subscribe(Observer o) {
            users.add(o);
        }
        void notifyUsers(String msg) {
            for(Observer o : users) {
                o.update(msg);
            }
        }
    }

Most Important Patterns for Interviews

Frequently Asked	Importance
Singleton	        Very High
Factory	            Very High
Builder	            High
Observer	        High
Strategy	        High
Adapter	            Medium
Decorator	        Medium

Easy Real-World Mapping
Pattern	Real World Example

Singleton	    President of a country
Factory	        Car factory
Builder	        Pizza builder
Observer	    YouTube subscribers
Adapter	        Charger adapter
Decorator	    Coffee toppings
Strategy	    Google Maps route selection

Difference: Factory vs Builder
Factory	                    Builder
Creates object in one step	Creates object step-by-step
Simpler objects	            Complex objects
Focus on type	            Focus on configuration

Why Use Design Patterns?
    Reusable code
    Better architecture
    Easier maintenance
    Scalable applications
    Cleaner OOP design
    Common language among developers

Recommended Order to Learn
    Singleton
    Factory
    Builder
    Observer
    Strategy
    Adapter
    Decorator
    MVC Architecture
```
# Cohesion
```
Cohesion means:
    How strongly related the methods/functions inside a class are.
    High Cohesion → One focused responsibility ✔
    Low Cohesion → Many unrelated tasks ❌

Types of Cohesion

Type	            Meaning	                                Quality
Coincidental	    Unrelated tasks together	            Worst
Logical	            Similar category tasks	                Poor
Temporal	        Tasks executed at same time	            Moderate
Procedural	        Tasks follow sequence	                Better
Communicational	    Tasks use same data	                    Good
Sequential	        Output of one becomes input of another	Very Good
Functional	        All tasks serve one purpose	            Best

Example
    High Cohesion
    class Calculator {
        add()
        subtract()
    }
    Low Cohesion
    class Employee {
        calculateSalary()
        sendEmail()
        connectDatabase()
    }

Key Benefits of High Cohesion
    Easier maintenance
    Better readability
    Reusable code
    Easier testing
    Cleaner design

Best Practice
    High Cohesion + Low Coupling = Good OOP Design
```
# Coupling
```
Coupling means:
    How much one class depends on another class.
        High Coupling → Classes are heavily dependent ❌
        Low Coupling → Classes are independent ✔

Example

High Coupling (Bad)
    class Engine {
        void start() {}
    }
    class Car {
        Engine e = new Engine();
    }
    Car is tightly dependent on Engine.

Low Coupling (Good)
    interface Engine {
        void start();
    }
    class PetrolEngine implements Engine {
        public void start() {}
    }
    class Car {
        Engine e;
        Car(Engine e) {
            this.e = e;
        }
    }
    Now Car can work with any engine type.
    ✔ Flexible
    ✔ Easy to change

- Types of Coupling
Type	            Description	Quality
Content Coupling	One class directly modifies another	Worst
Common Coupling	    Shared global data	Poor
Control Coupling	One class controls another’s logic	Moderate
Stamp Coupling	    Passing full objects unnecessarily	Better
Data Coupling	    Passing only needed data	Best

- How to Reduce Coupling
Method	                Explanation
Use Interfaces	        Reduces dependency
Dependency Injection	Pass objects instead of creating them
Encapsulation	        Hide internal details
Loose Coupling	        Classes communicate minimally
Use Design Patterns	    Factory, Observer, Strategy, etc.

Best Practice
    Low Coupling + High Cohesion = Good OOP Design

Quick Difference
Cohesion	    Coupling
Inside a class	Between classes
High is good	Low is good
``` 
# Abstraction vs Coupling vs Cohesion vs Encapsulation
```
Concept	        Definition  	                            Main goal	                    How to Achieve                	    Example

Encapsulation   Bundling data (variables) and               Prevent unintended changes      Use private variables, getters,     elementData[] (ArrayList) is
                methods (functions) into a single unit      and protect data                setters, and controlled methods     private & accessed with methods 

Abstraction     Hiding implementation details and showing   Reduce complexity and improve   Use Interfaces, Abstract Classes,   Driving a car without knowing 
                only essential features                     usability                       and Encapsulation                   engine internals

Coupling        Measures how much one class depends on      Achieve Loose Coupling for      Use Interfaces, Dependency          Car class works with any 
                another class                               better maintainability          Injection, and modular design       implementation of Engine 
                                                                                                                                interface

Cohesion	    Measures how well a class focuses on        High Cohesion - Increase        Split unrelated responsibilities    Data Parser only parses data,  
                a single responsibility                     maintainability                 into separate classes               Database Storer only stores data
```
# Favor Composition Over Inheritance
```
📌 Overview
    Inheritance and composition are two options to reuse code
    However, composition is generally preferred unless there is a clear "IS-A" relationship.
    Why?
        Provides greater flexibility
        Reduces tight coupling between classes

📌 What is Composition?
    Composition: "has-a" relationship where an object contains another object
    Allows objects to delegate behavior to other objects rather than inheriting behavior from a parent class.

📌 Bad Example For Inheritance
    class Engine {
        public void start() {
            System.out.println("Engine is starting...");
        }
    }
    class Car extends Engine {
        public void drive() {
            System.out.println("Car is driving...");
        }
    }
    public class Main {
        public static void main(String[] args) {
            Car myCar = new Car();
            myCar.start(); // Inherited from Engine
            myCar.drive();
        }
    }

Problems with the Above Approach
    Incorrect Relationship: A Car is not a type of Engine, but it has an engine.
        Using inheritance (extends Engine) creates an incorrect "IS-A" relationship instead of a "HAS-A" relationship.
    Unnecessary Method Inheritance: Every method in Engine is automatically inherited by Car, even if it doesn't logically belong to a car.
        Example: If Engine has a method changeOil(), Car will inherit it, even though a car itself does not change oil—the engine does.
    Limited Flexibility & Maintainability: What if we need to support multiple engine types like PetrolEngine or ElectricEngine?
        With inheritance, we'd have to create multiple Car subclasses (PetrolCar, ElectricCar), making the system harder to extend and maintain.
        A better approach is to use composition, where a Car contains an Engine object and delegates operations to it.

Better Approach: Composition
    class Engine {
        public void start() {
            System.out.println("Engine is starting...");
        }
    }
    class Car {
        // Composition: Car has an Engine
        private Engine engine; 
        public Car(Engine engine) {
            this.engine = engine;
        }
        public void drive() {
            // Delegating behavior to Engine
            engine.start(); 
            System.out.println("Car is driving...");
        }
    }
    public class Main {
        public static void main(String[] args) {
            Engine myEngine = new Engine();
            Car myCar = new Car(myEngine);
            myCar.drive();
        }
    }

Criteria	        Use Inheritance	                                    Use Composition
Relationship Type	When there is a true "is-a" relationship            When there is a "has-a" relationship
                    (e.g., Dog extends Animal)	                        (e.g., Car has an Engine)

Code Reusability	Inherits behavior from the parent class	            Reuses behavior by delegating it

Flexibility	        Creates a rigid relationship – subclasses 	        More flexible – can choose which functionality to reuse
                    inherit everything from the parent class

- Use inheritance only when there is a true "is-a" relationship (e.g., Dog extends Animal).
- Use composition for "has-a" relationships (e.g., Car has an Engine).
- Avoid deep inheritance trees – They make code hard to maintain and understand.
```
# What is Polymorphism?
```
📌 Overview
    What?: Polymorphism allows the same method or function to behave differently
    Meaning: Comes from the Greek words "poly" (many) and "morph" (forms).

📌 Types of Polymorphism
    Compile-Time Polymorphism (Method Overloading) → Decided at compile time.
    Run-Time Polymorphism (Method Overriding) → Decided at runtime.

📌 Example: Compile-Time Polymorphism (Method Overloading)
    public class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        public double add(double a, double b) {
            return a + b;
        }
    }
    public class Main {
        public static void main(String[] args) {
            Calculator calc = new Calculator();
            System.out.println(calc.add(2, 3));
            System.out.println(calc.add(2.5, 3.5));
        }
    }

📌 Example: Run-Time Polymorphism (Method Overriding)
    class Animal {
        public void sound() {
            System.out.println("Some generic animal sound");
        }
    }
    class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("Woof Woof");
        }
    }
    class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("Meow Meow");
        }
    }
    public class Main {
        public static void main(String[] args) {
            Animal[] animals = {new Dog(), new Cat()};

            for (Animal animal : animals) {
                animal.sound();
            }
        }
    }

📌 Polymorphism works with interfaces as well
    When a reference of an interface is used to hold objects of different classes implementing the interface, the method executed depends on the actual object:
    Flyable[] flyingObjects = {new Bird(), new Aeroplane()};
    for (Flyable object : flyingObjects) {
        object.fly();
    }
    This will print:
        Bird flies by flapping wings
        Aeroplane flies using engines.
    Even though object.fly() is called on the same reference type, different implementations are executed.
```
# Static vs Dynamic Binding
```
Feature	                Static Binding	                            Dynamic Binding
Definition	            Method call is resolved at compile time	    Method call is resolved at runtime
Type of Polymorphism	Compile-time(Method Overloading)	        Runtime(Method Overriding)
Method Execution	    Based on reference type	                    Based on actual object type
Performance	            Faster (resolved at compile time)	        Slower (resolved at runtime)
Example	                Static Method Calls	                        Method overriding

Example: Static Binding (Compile-Time Resolution)
    class MathOperations {
        static void multiply(int a, int b) {
            System.out.println("Multiplication: " + (a * b));
        }
    }
    public class Main {
        public static void main(String[] args) {
            // Output: Multiplication: 50
            MathOperations.multiply(5, 10); 
        }
    }

Example: Dynamic Binding (Runtime Resolution)
    class Parent {
        void display() {
            System.out.println("Parent display");
        }
    }
    class Child extends Parent {
        @Override
        void display() {
            System.out.println("Child display");
        }
    }
    public class Main {
        public static void main(String[] args) {
            Parent obj = new Child();
            obj.display(); // Output: Child display
        }
    }

Key Takeaways
    Polymorphism enables flexibility by allowing the same method call to perform different actions.
    Dynamic Method Dispatch is the mechanism for achieving runtime polymorphism in Java.
    Static Binding happens at compile time, while Dynamic Binding happens at runtime.
```
# What is the need for Sealed Interfaces and Classes?
```
📌 Example: Sealed Class
    Only allowed subclasses (Car, Truck, Bike) can extend Vehicle.
    Car is final, so it cannot be extended further.
    Truck is non-sealed, so any class can extend it.
    Bike is sealed again, allowing only ElectricBike to extend it.
    
    sealed class Vehicle permits Car, Truck, Bike {} 
    // No further subclassing  
    final class Car extends Vehicle {}  
    // Can be extended freely  
    non-sealed class Truck extends Vehicle {}
    sealed class Bike extends Vehicle 
                    permits ElectricBike {}  
    // No further subclassing  
    final class ElectricBike extends Bike {}  

📌 Example: Sealed Interface
    Controls which classes can implement Animal.
    Dog is final, so no other class can extend it.
    Bird is non-sealed, so any class can implement it.
    Cat is sealed, so only PersianCat can extend it.

    sealed interface Animal permits Dog, Cat, Bird {}  
    // Cannot be extended  
    final class Dog implements Animal {} 
    // Restricted to PersianCat  
    sealed class Cat implements Animal permits PersianCat {}  
    // Can be freely extended  
    non-sealed class Bird implements Animal {}  
    // No further subclassing  
    final class PersianCat extends Cat {}  

📌 Summary:
    Java New Feature: Introduced in Java 17
    Restricts Inheritance: Only specified classes can extend or implement.
    Prevents Unwanted Subclassing: No accidental extensions.
    Improves Maintainability: Clearer type hierarchy.
```