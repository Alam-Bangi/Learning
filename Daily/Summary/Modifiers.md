## What Are the Different Access Modifiers in Java and When Should You Use Them?
```
Access modifiers control visibility of classes, methods, and variables.

Modifier    Class   Package  Subclass   World       Applicable To
public	    ✔	    ✔	    ✔	        ✔	      Class, Methods, Constructors, Member Variables
protected	✔	    ✔	    ✔	        ❌	      Methods, Constructors, Member Variables
default	    ✔	    ✔	    ❌	        ❌	      Class, Methods, Constructors, Member Variables
private	    ✔	    ❌	    ❌	        ❌	      Methods, Constructors, Member Variables 

🎯 Best Practices:
Use private – Best for encapsulating fields and internal logic
    In java.lang.String, the value array is private final:
        Ensures immutability and prevent external access or modification.
    In java.lang.Integer, the value field is private:
        Internal representation stays hidden while exposing only necessary methods.
Use protected – Only when subclasses genuinely need access
    The java.util.AbstractList class, the default constructor protected AbstractList() is protected:
        Prevents direct instantiation.
        Ensures only subclasses like ArrayList or LinkedList can extend and initialize it.
    In java.util.AbstractList class protected void removeRange (int fromIndex, int toIndex):
        Allows subclasses to efficiently remove elements in bulk.
        Not exposed publicly to avoid accidental misuse.
Use public – Expose only what external code truly needs
    In java.lang.String, methods like length() and charAt() are public:
        Other classes can safely read string content without touching internals
In java.util.ArrayList, methods like add() and get() are public:
        Other classes can use the collection methods to perform operations.
    Avoid default (package-private) – Visibility leaks across unrelated classes in the same package
```
## How Should You Use the static Modifier Effectively in Java?
```
1. Use static final for Constants
    What? Use static final for constant values.
    Why? Saves memory by sharing a single copy across all instances (static)
    Also the value cannot be changed (final)
    JDK Example: Integer.MAX_VALUE, Math.PI
Example:
class MathUtil {
    public static final double PI = 3.14159;
}

2. Use static for Utility Methods
    What? Methods that don't need instance variables.
    Why? Avoids unnecessary object creation.
    JDK Example: Collections.sort(), Math.abs()
Example:
class MathUtil {
    public static int square(int num) {
        return num * num;
    }
}

3. Use static Blocks for Initialization
    What? Code that runs once when the class loads.
    Why? Useful for setting up static variables.
Example:
class Config {
    public static String appName;
    static {
        appName = "MyApp";
        //Other initialization of static variables
        System.out.println("Static block executed");
    }
}
Source Code (from Integer class)
private static class IntegerCache {
    static final Integer cache[];
    static {
        // Cache range: -128 to 127
        cache = new Integer[-(-128) + 127 + 1]; 
        for (int i = 0; i < cache.length; i++)
            cache[i] = new Integer(i - 128);
    }
}

4. Be Careful with static Variables in Multithreading
    Why? Shared across threads, leading to concurrency issues.
    Solution: Use synchronization (or other concurrency alternatives - AtomicInteger, .. ) if needed.
Example:
class Counter {
    private static int count = 0;
    // ✅ Use synchronized
    public static synchronized void increment() {  
        count++;
    }
}

5. Use static Factory Methods for Object Creation
    Why? Improves readability and flexibility.
    Constructors are great for simple initialization of values
    Factory methods improve readability with meaningful names, allow caching, can return subtypes, and give better control over object creation (like returning Optional, a singleton, or even reusing existing instances)
    JDK Example: List.of(), Optional.of(), LocalDate.now()
Example:
class User {
    private String name;
    private User(String name) {
        this.name = name;
    }
    public static User createUser(String name) {
        return new User(name);
    }
}

6. For Implementing Singleton Pattern
    What? One instance shared across app
    JDK Example: Runtime.getRuntime() (Gives access to the JVM's runtime environment to run system commands (exec()), manage memory (totalMemory(), freeMemory()), trigger garbage collection (gc()), or shut down the JVM (exit()))
class Singleton {
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}

7. Use static Imports Carefully
    What? Lets you access static members without class name
    Why? Overuse can make code less readable.
    Avoid? Wildcard imports – they reduce clarity
Example:
import static java.lang.Math.sqrt;
//import static java.lang.Math.*; AVOID
class Example {
    double result = sqrt(25);
}

8. Use static Methods in Interfaces
    What? Interfaces can define static methods with implementation
    Why? Useful for utility methods specific to the interface
    Not inherited by implementing classes
    Belongs only to the interface
    JDK Example: Comparator.comparing(), Map.entry(), Predicate.isEqual()
Example:
interface MathOperations {
    static int square(int n) {
        return n * n;
    }
}
class Demo {
    public static void main(String[] args) {
        int result = MathOperations.square(5);
        System.out.println(result); // Output: 25
    }
}

9. Use static Nested Classes
    What? A nested class that doesn't require an instance of the outer class
    Why? Ideal when inner class doesn't need access to instance variables
    Can Access? Only static members of the outer class
    When? When you need a helper class that groups related functionality, like a Database.Connection class managing database connections without needing an outer class instance.
    JDK-Like Use Case: Integer.IntegerCache (cache -128 to 127 - inclusive )
Example:
class Database {
    private static String url = "jdbc:mysql://localhost:3306/mydb";
    static class Connection {
        void connect() {
            System.out.println("Connecting to: " + url);
        }
    }
}
class Main {
    public static void main(String[] args) {
        Database.Connection connection = new Database.Connection();
        connection.connect(); // Output: Connecting to: jdbc:mysql://localhost:3306/mydb
    }
}
```
## What Are the Best Practices for Using the final Modifier in Java?
```
1. Use final for Constants
    What? Declare constants using final and static.
    Why? Prevents modification and improves code readability.
    JDK Example: Integer.MAX_VALUE, Math.PI
Example:
class MathUtil {
    public static final double PI = 3.14159;
}
//Examples From JDK
public final class Integer {
    public static final int   MAX_VALUE = 0x7fffffff;
}
public final class Math {
    public static final double PI = 3.141592653589793;
}

2. Use final for Member Variables
    What? Makes a field constant after it’s set
    Why? Ensures the variable is assigned once and never changed
    When? Great for setting values in constructors
Example:
class User {
    private final String name;
    public User(String name) {
        this.name = name; // ✅ Must assign in constructor
    }
    public String getName() {
        return name;
    }
}
//Example from JDK
public final class String {
    private final byte[] value;
}

3. Use final with Classes to Prevent Inheritance
    What? Prevents other classes from extending it.
    Why? Useful for utility or immutable classes.
Example:
final class Utility {
    public static void log(String message) {
        System.out.println(message);
    }
}
//Examples From JDK
public final class String  // Immutable text
public final class Integer // Immutable wrapper
public final class Math    // Utility methods only

4. Use final with Methods to Prevent Overriding
    What? Stops subclasses from modifying behavior.
    Why? Ensures security and correctness.
Example:
class Parent {
    public final void show() {
        System.out.println(
            "This method cannot be overridden.");
    }
}
//Examples from JDK
//These methods are marked `final` to prevent subclasses 
//from changing core thread behavior. Overriding them 
//could break thread safety, consistency, 
//or violate JVM expectations during execution.
public class Thread implements Runnable {
    public final String getName() {}
    public final boolean isAlive() {}
    public final void setPriority(int newPriority) {}
    //And a lot of others!
}

5. Be Cautious with final Reference Variables
    What? A final reference variable cannot change its reference, but the object’s data can be modified.
    Why? Prevents reassignment but allows state changes.
Example:
class Example {
    public static void main(String[] args) {        
        final StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Allowed
        // ❌ Compilation Error
        // sb = new StringBuilder("New"); 
    }
}
```
## What Are the Best Practices for Using the abstract Modifier in Java?
```
1. Best Use Case For abstract class: Template Method Pattern
    What? Defines an algorithm structure, letting subclasses implement specific steps.
    Why? Ensures a controlled workflow while allowing flexibility.
Example:
abstract class AbstractGame {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    public final void play() { // Defines the sequence
        initialize();
        startPlay();
        endPlay();
    }
}

2. abstract class: Use Proper Naming
    What? Use meaningful names that indicate a base class.
    Why? Makes the purpose of the class clear.
Example:
abstract class AbstractLogger {
    abstract void log(String message);
}
//Examples from JDK
public abstract class AbstractList<E>
public abstract class AbstractMap<K,V> implements Map<K,V>

3. Prefer Interfaces if Abstract Class has No Implementation
    What? Use an interface when a class only defines method signatures.
    Why? Provides more flexibility than abstract classes.
Example:
interface Flyable {
    void fly();
}

4. Avoid Full Implementation in an abstract Class
    Why? If all methods are implemented, there is no need for abstract.
Bad Example:
abstract class Utility { // ❌ No need for abstract
    public void log(String message) {
        System.out.println(message);
    }
}

5. Default in Interfaces – No Need to Specify abstract
    What? Methods in interfaces are implicitly abstract unless marked default or static.
    Why? Reduces redundancy in code.
Bad Example:
interface Flyable {
    void fly();
    // abstract void fly(); // ❌ 'abstract' is redundant
    // public abstract void fly(); // ❌ also redundant
}
Good Example:
interface Flyable {
    void fly(); // Abstract by default
}
```
## Can You Explain Other Useful Modifiers in Java With Simple Examples?
Modifier	  Purpose	                               Example	                            Simple Use Case
volatile	  Each thread can cache variables in its   private volatile int count;          Shared variable in a multi-threaded program
              own CPU core or registers. So, there 
              might be delay in visibility of updates 
              from other threads. volatile ensures 
              changes to a variable are visible to 
              all threads immediately.

synchronized  Ensures thread safety by allowing only   synchronized void method(){ }        Prevent race conditions in multi-threading 
              1 thread to access method/block at time.

transient	  Prevents a field from being serialized.  private transient String password;	Avoid saving sensitive data in a file

native	      Declares a method that is implemented    native void nativeMethod();          Calling system-level functions from Java
              in another language (e.g., C/C++). 

strictfp	  Ensures consistent floating-point        strictfp class Calculator { }        Consistent floating-point math across 
              calculations across platforms.                                                different CPUs

sealed	      Restrict which class can extend class.   sealed class Vehicle permits         Control which classes can inherit from 
                                                                        Car, Bike { }       base class

non-sealed	  Allows a subclass of a sealed class       non-sealed class Car extends        Allow further extension of a subclass of 
              to be extended further                                       Vehicle { }      a sealed class
```