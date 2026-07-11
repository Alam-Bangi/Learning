```
JAVA INTERFACE — COMPLETE SUMMARY + Q&A

📌 1. What is an Interface in Java?
✅ Answer:
    An interface is a blueprint of a class that contains abstract methods, default methods, static methods, and constants. It defines what to do, not how to do it.

📌 2. Why do we use Interfaces?
✅ Answer:
        Achieve abstraction
        Support multiple inheritance
        Enable loose coupling
        Improve scalability and flexibility
        Used in design patterns (Factory, Strategy, etc.)

📌 3. Can we create object of interface?
    ❌ No
    Because interface is abstract by nature.
    ✔ But we can do:
    Interface obj = new Class();

📌 4. Can interface have methods with body?
    ✅ Yes (Java 8+ )
    Types:
    default methods (with body)
    static methods (with body)

📌 5. Can interface have variables?
✅ Yes, but only:
        public static final (constant by default)
        Example:
        interface A {
            int x = 10;
        }
        Internally:
        public static final int x = 10;

📌 6. Can interface have constructor?
        ❌ No
        Because interfaces cannot be instantiated.

📌 7. Can a class implement multiple interfaces?
✅ Yes
        This is how Java supports multiple inheritance
        class A implements X, Y, Z

📌 8. Can interface extend another interface?
✅ Yes
        interface A {}
        interface B extends A {}

📌 9. Difference between abstract class and interface
Feature	        Interface	                    Abstract Class
Methods	        abstract + default + static	    abstract + concrete
Variables	    only constants	                any type
Inheritance	    multiple	                    single
Constructor	    ❌ No	✅                      Yes
Usage	        full abstraction	            partial abstraction

📌 10. What is marker interface?
✅ Answer:
        An interface with no methods or fields
        Example:
        Serializable
        Cloneable
        Used to give metadata to JVM.

📌 11. What is functional interface?
✅ Answer:
        Interface with only one abstract method
        Example:
        @FunctionalInterface
        interface A {
            void show();
        }
        Used in:
        Lambda expressions
        Streams API

📌 12. Can interface override Object class methods?
    ✅ Yes indirectly
    But implementation is in class, not interface.

📌 13. What happens if two interfaces have same default method?
        ⚠️ Problem: Conflict
        Solution: Class must override it.
        interface A {
            default void show() {}
        }
        interface B {
            default void show() {}
        }
        class C implements A, B {
            public void show() {
                System.out.println("Resolved conflict");
            }
        }

📌 14. Can interface be private or protected?
        ❌ No (top-level interface must be public or default)

📌 15. Hidden Concept: Interface inheritance hierarchy
        Interface can extend multiple interfaces
        Class can implement multiple interfaces
        Interface forms contract chain

📌 16. What is marker interface used for internally?
    Example: Serializable
    JVM uses it to decide:
    Whether object can be converted to bytes
    Enables file/network transfer

📌 17. Hidden Interview Trick Question
    ❓ Can interface have main method?
    ✅ Yes (Java 8+ static method allowed)
    interface A {
        static void main(String[] args) {
            System.out.println("Yes, interface can run");
        }
    }

📌 18. Real-life mapping of interface
Real World	        Java Interface
Payment system	    Payment interface
Vehicle types	    Vehicle interface
Login methods	    Auth interface
Delivery system	    DeliveryService

📌 19. Most important hidden rule
    👉 Interface = contract enforcement tool
    👉 Class = implementation tool

📌 20. Final Interview One-liner
    👉 “Interface in Java is used to achieve abstraction and multiple inheritance, and it defines a contract that implementing classes must follow.”
```
```
🔹 1. Why does Java allow default methods in interface? Isn’t interface supposed to be pure abstraction?
    Answer:
    Originally, interfaces were 100% abstract. But Java added default methods (Java 8) to:
    Add new methods without breaking existing implementations
    Support backward compatibility in large APIs (like Collections framework)
    👉 Example problem it solved:
    If Java added a new method to List, all existing classes would break. Default methods prevent that.

🔹 2. Can interface break encapsulation?
    Answer (tricky):
    Indirectly yes, if misused.
    Because:
    Interface exposes methods publicly
    No control over implementation hiding inside interface contract
    But it still promotes abstraction, not full encapsulation.
    👉 Encapsulation = hiding state
    👉 Interface = hiding implementation logic (not data)

🔹 3. Why can’t we have instance variables in interface?
    Answer:
    Because:
    Interface is not meant to hold state
    State belongs to objects (classes), not contracts
    So Java forces:
    public static final
    👉 This ensures interface remains stateless design contract

🔹 4. What problem happens if interface had instance variables?
    Answer (important thinking question):
    It would create:
    Multiple copies per object
    Confusion in multiple inheritance
    State ambiguity (diamond problem again)
    So Java avoided it completely.

🔹 5. Can abstract class solve everything interface does?
    Answer:
    No.
    Because abstract class has limitations:
    Only single inheritance
    Tightly couples base class

    Interface gives:
    Multiple inheritance
    Loose coupling
    👉 So both exist for different design goals.

🔹 6. Why does Java not support multiple inheritance with abstract classes?
    Answer:
    Because of:
    👉 Method ambiguity problem
    If two parent classes have same method:
    class A { void show() {} }
    class B { void show() {} }
    Child class won't know which one to inherit.
    Interfaces avoid this because:
    No implementation conflict (until default methods, which must be resolved manually)

🔹 7. What happens if two interfaces have same default method?
    Answer:
    Compiler forces override:
    interface A {
        default void show() {
            System.out.println("A");
        }
    }
    interface B {
        default void show() {
            System.out.println("B");
        }
    }
    class C implements A, B {
        public void show() {
            A.super.show(); // or B.super.show()
        }
    }
    👉 This is called diamond resolution manually handled

🔹 8. Why is interface preferred in Spring Boot?
    Answer:
    Because Spring uses:
    Proxy pattern
    Dependency injection
    Runtime polymorphism

    👉 Without interfaces:
    No mocking in testing
    No flexible swapping of implementations

🔹 9. Can abstract class be replaced with interface completely in modern Java?
    Answer:
    Almost yes, but not fully.

    Interface cannot:
    Hold instance state
    Have constructors
    Maintain object lifecycle logic

    So abstract class still needed for:
    shared state
    base logic initialization

🔹 10. What is “tight coupling hidden inside abstract class”?
    Answer:
    If you use abstract class heavily:
    class Service extends BaseService
    👉 Your class becomes dependent on base implementation
    👉 Harder to change parent later
    So abstract class = semi-tight coupling risk

🔹 11. Can interface be used for dependency injection without Spring?
Answer:
Yes.
    interface Payment {
        void pay();
    }
    class UPI implements Payment {
        public void pay() {}
    }
    class Checkout {
        Payment p;
        Checkout(Payment p) {
            this.p = p;
        }
    }
    👉 This is manual DI (Spring automates it)

🔹 12. What is hidden cost of using interfaces everywhere?
    Answer (rarely asked):
    More object creation layers
    Slight runtime overhead (dynamic dispatch)
    Harder debugging due to abstraction layers
    👉 But benefits outweigh cost in large systems

🔹 13. Why Java uses keyword “implements” instead of “extends” for interface?
    Answer:
    Because:
    extends = inheritance (is-a relationship)
    implements = contract fulfillment
    👉 Interface is NOT parent class, it's a behavior agreement

🔹 14. Can interface methods be overridden partially?
    Answer:
    No.
    You must:
    implement full method OR
    use default method
    Partial implementation is not allowed.

🔹 15. What is the biggest design mistake beginners make with interface?
    Answer:
    👉 Creating interface for everything
    Bad design:
    interface Car {
        void drive();
    }
    If only one implementation exists → interface is unnecessary.

🔥 Final “Senior-Level” Insight

👉 Use interface when behavior may change
👉 Use abstract class when structure is fixed but partial logic is shared
```