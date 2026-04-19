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