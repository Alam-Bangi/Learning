```
Data- State 
Functions- Behaviour


- What happens when Object is created internally 
    - 1. Memory Allocation
        - System allocates memory for object (heap memory)
        - Size depends on class variables
    - 2. Instance Variable Initialization
        - All instance variables are initialized.
        - Default values are assigned first, then
        
         
Arrays → fixed size, contiguous memory, faster, primitives allowed
ArrayList → dynamic, resizing, Object[], wrapper classes only
Use Arrays.toString() / deepToString() for printing
Be careful with covariant arrays → ArrayStoreException
ArrayList iterators → fail-fast
Cloning → deep copy; assignment → shallow copy
subList → view backed by original list
```
```
            ARRAYS / ARRAYLIST
Operation	                Time Complexity
Access                      O(1) ✅
Search	                    O(n) ❌
Insertion (end)	            O(1) / O(n)*
Insertion (mid)	            O(n) ❌
Deletion	                O(n) ❌

            ARRAY vs ARRAYLIST
Feature	        Array	        ArrayList
Size	        Fixed           Dynamic
Speed	        Faster	        Slightly slower
Flexibility	    Low	            High
Memory	        Efficient	    Extra overhead

            ARRAYLIST vs LINKEDLIST
Feature	          ArrayList	           LinkedList
Structure	      Dynamic Array	       Doubly linked list
Access	          Fast (O(1))	       Slow (O(n))
Insertion	      Slow (O(n))	       Fast (O(1) at ends)
Memory	          Less	               More (extra pointers)
Use case	      Frequent reads	   Frequent insert/delete

- How does ArrayList grow internally?
    - Default capacity = 10
    - When full:
        1. Creates a new larger array
        2. Copies old elements
        3. Adds new element
    👉 Growth formula:
        newCapacity = oldCapacity + (oldCapacity / 2)

Why is ArrayList slower than array?
    - ArrayList is slightly slower than normal arrays because:
        1. It has extra methods (overhead)
        2. It may need resizing + copying
        3. It uses wrapper classes(eg- Integer instead of int)

👉 Arrays are faster because:
    Direct memory access
    No resizing
    No object overhead

            SIZE() vs CAPACITY()
Feature	        size()	                        capacity()
Meaning	        Number of elements	            Internal storage size
Changes	        When elements added/removed	    When resized
Access	        Available method	            Not directly accessible
👉 Example:
Capacity = 10
Size = 3

            ARRAYS VS GENERICS(ex.ArrayList)
Feature	            Arrays	        Generics
Type checking	    Runtime	        Compile-time
Behavior	        Covariant	    Invariant
Safety	            Less safe	    More safe
Performance	        Faster	        Slightly slower
Flexibility	        Less	        More
Memory	            Efficient       Extra overhead
Runtime type info	Present	        Erased

Covariance in Arrays
Arrays in Java are covariant, meaning:
    A parent type reference can refer to a child type array.
    Object[] arr = new String[3]; // allowed

⚠️ Why is it dangerous?
Because it breaks type safety at runtime.
    Object[] arr = new String[3];
    arr[0] = 10; // ❌ Runtime error
👉 Even though compilation is fine, JVM throws:
ArrayStoreException

When an array is passed to a method in Java:
    The reference of the array is passed by value (not the actual array).
    So:
    Both caller and method point to the same array object in heap
    Any modification inside the method affects the original array
```
```
Inheritance
    Inheritance is a mechanism where one class acquires properties (fields + methods) of another class using extends.

Why is inheritance used?
    Code reusability
    Method overriding (runtime polymorphism)
    Better organization (IS-A relationship) 

Does Java support multiple inheritance?
   ❌ Not with classes 
   ✅ Yes with interfaces

Types of inheritance in Java
    Single - One child class inherits from one parent class.
    Multilevel - A class inherits from a class, which itself inherits from another class.
    Hierarchical - Multiple child classes inherit from one parent class.
    Multiple (via interfaces only) - One class inherits from multiple sources (interfaces).
    ❗ Java does NOT support multiple inheritance with classes.
    Hybrid (via interfaces) - Combination of two or more inheritance types.
       A
      / \
     B   C
      \ /
       D

Difference between overloading and overriding?
Feature	                Overloading	    Overriding
Same method name	    Yes	            Yes
Parameters	            Different	    Same
Inheritance needed	    No	            Yes
Runtime polymorphism    No	            Yes

What is protected access modifier?
Accessible:
    Within package
    Outside package via inheritance

What is dynamic method dispatch?
    Method call resolved at runtime based on object type.

What is diamond problem?
    Occurs in multiple inheritance when two parents have same method.

Can we downcast safely?
    Yes, but requires explicit casting:
    Parent p = new Child();
    Child c = (Child) p;

Can child class access parent static variables?
    ✅ Yes (via class name or inheritance)
```
```
Abstract Class

    An abstract class in Java is used for partial abstraction and code reuse with a common base structure for related classes.

    An abstract class is a class declared with abstract keyword that:
        Cannot be instantiated
        May contain abstract (no body) and non-abstract methods

What is an abstract method?
    A method without implementation.

Why use abstract classes?
    To provide a common base
    To enforce method implementation in subclasses
    To achieve partial abstraction

Can abstract class have variables?
✅ Yes (instance + static)

Can abstract class be final?
    ❌ No
    👉 Because:
    abstract → must be inherited
    final → cannot be inherited

What happens if subclass doesn’t implement abstract method?
    Subclass must also be declared abstract.

Difference between abstract class and interface?
Feature	                Abstract Class	        Interface
Methods	                Abstract + concrete	    Abstract (default/static allowed)
Variables	            Any type	            public static final only
Constructors	        Yes	                    No
Multiple inheritance	No❌                    Yes✅

Can abstract methods be static?
    ❌ No

Can we call constructor of abstract class?
    ✅ Yes, via subclass

What is partial abstraction?
    Abstract class provides some implemented methods and some abstract methods.

When to use abstract class instead of interface?
    Use abstract class when:
        You want default implementation
        You need constructors
        You want state (instance variables)

“If abstract class has no abstract methods, why use it?”
    Prevent instantiation
    Provide common base class

Quick Revision (Must Remember)
    ❌ Cannot instantiate abstract class
    ✅ Can have constructor
    ❌ Abstract methods cannot be:
        private
        final
        static
    Supports partial abstraction
    Used for base class design
```
```
INTERFACE 
🔹 1. What is an Interface in Java?
    An interface is a blueprint of a class that contains abstract methods (by default) and constants.
    👉 It defines what a class should do, not how to do it.
    interface Animal {
        void makeSound(); // abstract method
    }

🔹 2. Why do we use Interfaces?
    To achieve 100% abstraction
    To support multiple inheritance
    To enforce a contract between classes
    To enable loose coupling

🔹 3. How is Interface different from a Class?
Feature	        Interface	        Class
Methods	        Abstract (default)	Concrete + Abstract
Variables	    public static final	Any type
Inheritance	    Multiple allowed	Single
Object creation	Not possible	    Possible

🔹 4. How do you implement an Interface?
    Use the implements keyword.
    interface Animal {
        void makeSound();
    }
    class Dog implements Animal {
        public void makeSound() {
            System.out.println("Bark");
        }
    }

🔹 5. Can we create an object of an Interface?
    ❌ No, but you can create a reference:
    Animal obj = new Dog();
    obj.makeSound();

🔹 6. What are default methods in Interface? (Java 8+)
    Methods with a body using default keyword.
    interface Animal {
        default void sleep() {
            System.out.println("Sleeping...");
        }
    }

🔹 7. What are static methods in Interface?
    interface Animal {
        static void info() {
            System.out.println("Animals are living beings");
        }
    }
    Call using:
    Animal.info();

🔹 8. What is a functional interface?
    An interface with only one abstract method.
    @FunctionalInterface
    interface MyInterface {
        void display();
    }
    Used in Lambda expressions.

🔹 9. Can an Interface extend another Interface?
✅ Yes
    interface A {
        void methodA();
    }
    interface B extends A {
        void methodB();
}

🔹 10. Can a class implement multiple interfaces?
✅ Yes (this is how Java achieves multiple inheritance)
    interface A {
        void show();
    }
    interface B {
        void display();
    }
    class Test implements A, B {
        public void show() {}
        public void display() {}
    }

🔹 11. What happens if two interfaces have same method?
    No problem if signatures are same:
    interface A {
        void show();
    }
    interface B {
        void show();
    }
    class Test implements A, B {
        public void show() {
            System.out.println("Same method");
        }
    }

🔹 12. What if two interfaces have default methods with same name?
    You must override it:
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
    class Test implements A, B {
        public void show() {
            System.out.println("Resolved conflict");
        }
}

🔹 13. Can Interface have constructor?
    ❌ No, because you cannot create objects of interface.

🔹 14. Are variables in Interface final?
✅ Yes, by default:
        interface A {
            int x = 10; // public static final
        }

🔹 15. Can Interface have private methods?
✅ Yes (Java 9+), used internally:
        Interface A {
            private void helper() {
                System.out.println("Helper method");
            }
        }

🔹 16. Real-life example of Interface
    Think of a remote control:
        Buttons = interface methods
        TV = implementing class

🔹 17. Interface vs Abstract Class (Important Interview Q)
Feature	                Interface	        Abstract Class
Multiple inheritance	Yes	                No
Constructors	        No	                Yes
Variables	            final only	        any
Methods	                abstract + default	abstract + concrete

🔹 18. What is marker interface?
    An empty interface used to “mark” a class.
    Example:
    Serializable
    Cloneable

🔹 19. Can we override static methods?
    ❌ No, static methods are not overridden.

🔹 20. When should you use Interface?
    Use interface when:
    You need multiple inheritance
    You want to define a contract
    You want loose coupling

🔹 21. Why interface is preferred in Spring Boot?
    Answer:
    Supports dependency injection
    Enables loose coupling
    Easy testing and mocking
```