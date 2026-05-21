# Object class
```
- In Java, the superclass of every class is the Object class.
- All Java classes implicitly inherit from Object - even if not explicitly specified.
- The Object class provides common methods that all Java objects inherit.
    toString() → Returns a string representation of the object.
    equals() → Compares two objects for equality.
    hashCode() → Returns a unique integer (hash code) for the object.
Few other methods related to synchronization that we will discuss later!

📌 Example: Using Object Methods
    public class Demo {
        public static void main(String[] args) {
            Object obj = new Object();

            // Outputs: java.lang.Object@<hashcode>
            System.out.println(obj.toString()); 
        }
    }
```
# toString() method
```
📌 Overview
    The toString() method provides a string representation of an object.
    By default, it prints ClassName@hashcode.
    Best Practice: Override toString() to return meaningful information about the object.

📌 Example: Default toString() Behavior
    public class Animal {
        private String name;
        public Animal(String name) {
            this.name = name;
        }
    }
    public class Main {
        public static void main(String[] args) {
            Animal dog = new Animal("Tommy");
            
            // Output: Animal@<hashcode>
            System.out.println(dog); 
        }
    }

Default Implementation in Object Class:
    public String toString() {
        return getClass().getName() 
                + "@" + Integer.toHexString(hashCode());
    }

📌 Example: Overriding toString() for Better Readability
    class Animal {
        private String name;
        public Animal(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Animal{name='" + name + "'}";
        }
    }
    public class Main {
        public static void main(String[] args) {
            Animal dog = new Animal("Tommy");       
            // Output: Animal{name='Tommy'}
            System.out.println(dog); 
        }
    }

toString() Implementation in String Class:
    public String toString() {
        return this; //Returns the string itself
    }

toString() Implementation in ArrayList Class:
    //Returns a string representation of the list's elements.
    //Empty - []
    //Single Element - [10]
    //Multiple Values - [10, 20, 30]
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

📌 Best Practices for Overriding toString():
    Provide Meaningful Information: Include relevant details about the object's state to aid in debugging and logging.
    Ensure Consistency: The string representation should be consistent with the object's state and behavior.
    Avoid Sensitive Information: Do NOT include confidential data in the toString() output.
```
# equals() method
```
📌 Overview
    Purpose: Used to compare two objects for equality.
    Default Behavior: Compares memory addresses of the objects (same as ==).
    Object Class:
    Returns true only if both references point to the same object
    public boolean equals(Object obj) {
        return (this == obj);
    }

📌 String class equals method:
    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String) anObject;
            int n = value.length;
            if (n == aString.value.length) {
                char[] v1 = value;
                char[] v2 = aString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }

Explanation:
    Reference Check: If both references point to the same object (this == anObject), it returns true.
    Type Check: It verifies that the passed object is an instance of String.
    Content Comparison: It compares the lengths and corresponding characters of the two strings.

📌 AbstractList class
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof List))
            return false;
        ListIterator<E> e1 = listIterator();
        ListIterator<?> e2 = ((List<?>) o).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1 == null ? o2 == null : o1.equals(o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
}

Explanation:
    Reference Check: If the object o is the same instance as this, it returns true.
    Type Check: It verifies that o is an instance of List.
    Element Comparison: It uses ListIterator to traverse both lists simultaneously, comparing corresponding elements using their equals() method. If any pair of elements is not equal, it returns false.
    Size Check: After the loop, if one list has more elements than the other, it returns false. Otherwise, it returns true.

📌 Best Practices for Implementing equals()
    Reflexive → x.equals(x) must return true.
    Symmetric → If x.equals(y), then y.equals(x).
    Transitive → If x.equals(y) and y.equals(z), then x.equals(z).
    Consistent → Multiple calls to x.equals(y) should return the same result unless any of the objects are modified.
    Non-null → x.equals(null) must always return false.
    Important: Always override hashCode() when overriding equals() to ensure correct behavior in collections like HashSet and HashMap.

📌 Objects.equals() method
    Static method in Objects class
    Provides a null-safe way to compare two objects for equality
    Commonly used when overriding the equals() method
    System.out.println(Objects.equals("Hello", "Hello")); // true
    System.out.println(Objects.equals("Hello", "World")); // false
    System.out.println(Objects.equals(null, null));       // true
    System.out.println(Objects.equals(null, "Hello"));    // false

Example Implementation
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;        
        if (obj == null 
            || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return age == animal.age &&
            Objects.equals(name, animal.name) &&
            Objects.equals(species, animal.species);
    }
```
# hashCode() method
```
📌 Overview
    Purpose: Generates a unique integer (hash code) for an object.
    Why?: Used in hashing-based collections like HashMap, HashSet, and HashTable.
    Key Rule: If two objects are equal (equals() returns true), they must have the same hashCode().

📌 Objects.hash() Method
    Static method in Objects class
    Provides a simple way to compute a hash code based on multiple fields of an object
    Commonly used when overriding the hashCode() method
    public static int hash(Object... values)
    //return Objects.hash(name, age);

📌 Example: Overridden hashCode()
    import java.util.Objects;
    class Animal {
        private String name;
        public Animal(String name) {
            this.name = name;
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

📌 Example with both hashCode and equals
    import java.util.Objects;
    class Animal {
        private String name;
        private int age;
        private String species;

        public Animal(String name, int age, String species) {
            this.name = name;
            this.age = age;
            this.species = species;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;   
            if (obj == null 
                || getClass() != obj.getClass()) return false;
            Animal animal = (Animal) obj;
            return age == animal.age &&
                Objects.equals(name, animal.name) &&
                Objects.equals(species, animal.species);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, age, species);
        }
        public static void main(String[] args) {
            Animal a1 = new Animal("Leo", 5, "Lion");
            Animal a2 = new Animal("Leo", 5, "Lion");
            Animal a3 = new Animal("Simba", 3, "Lion");

            System.out.println(a1.hashCode()); // Same as a2
            System.out.println(a2.hashCode()); // Same as a1
            System.out.println(a3.hashCode()); // Different
            System.out.println(a1.equals(a2)); // true
            System.out.println(a1.equals(a3)); // false
        }
    }
```
# Ways to Initialize Objects in Java
```
📌 1. Using a Constructor
    What? Assigns values when the object is created.
    Why? Ensures the object starts with valid data.
    How? Define a constructor and pass values.
    public class Fan {
        private String make;
        private double radius;
        private String color;

        public Fan(String make, 
            double radius, String color) {
            this.make = make;
            this.radius = radius;
            this.color = color;
        }
        public void display() {
            System.out.println(make 
                + " " + radius + " " + color);
        }
        public static void main(String[] args) {
            Fan fan = new Fan("Bajaj", 12.5, "White");
            fan.display();
        }
    }

📌 2. Using Setter Methods
    What? Assigns values after creating the object.
    Why? Allows changing values later.
    How? Create setter methods and call them.
    public class Fan {
        private String make;
        private double radius;
        private String color;

        public void setMake(String make) {
            this.make = make;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public void display() {
            System.out.println(make 
                + " " + radius + " " + color);
        }
        public static void main(String[] args) {
            Fan fan = new Fan();
            fan.setMake("Havells");
            fan.setRadius(14.0);
            fan.setColor("Black");
            fan.display();
        }
    }

📌 3. Using Object Initialization Block
    What? Initializes variables inside an instance block.
    Why? Ensures some default values before constructors run.
    Usecase? Avoids code duplication in multiple constructors.
    How? Use { } blocks inside the class.
    public class Fan {
        private String make;
        private double radius;
        private String color;
        private String serialNumber;

        // Instance Initialization Block
        // Runs before any constructor
        // Common to multiple constructors!
        {
            //Let's assume that this is unique!
            serialNumber = "FAN-" 
                            + System.currentTimeMillis();
        }
        // Default Constructor
        public Fan() {
            System.out.println("Default Constructor: ");
        }
        // Constructor with make and radius
        public Fan(String make, double radius) {
            this.make = make;
            this.radius = radius;
            System.out.println(
                "Constructor: make and radius");
        }
        // Fully Parameterized Constructor
        public Fan(String make, double radius, String color) {
            this.make = make;
            this.radius = radius;
            this.color = color;
            System.out.println(
                "Constructor: make, radius, and color.");
        }
        public void display() {
            System.out.println(
                serialNumber + " " + make + 
                " " + radius + " " + color);
        }
    }

📌 4. Using Static Block (For Static Initialization)
    What? Initializes static variables before object creation.
    Why? Useful for loading configuration data, database records, or external resources before objects are created.
    Executes once when the class is loaded.
    Ensures static data is ready before any instance is accessed.
    How? Use static { } inside the class.
    import java.util.ArrayList;
    import java.util.List;

    public class Fan {
        private static List<String> availableModels;

        // Static block for initialization
        static {
            availableModels = new ArrayList<>();
            loadModelsFromDatabase();
        }
        // Simulated database loading method
        private static void loadModelsFromDatabase() {
            availableModels.add("Orient Aeroquiet");
            availableModels.add("Havells Stealth");
            availableModels.add("Crompton Energion");
            availableModels.add("Usha Bloom");
        }
        public static void main(String[] args) {
            System.out.println("Available Fan Models: " 
                                        + availableModels);
        }
    }

📌 5. Using a Factory Method
    What?: A static method creates and returns objects based on specific conditions.
    Why?
    Controls object creation by centralizing logic.
    Allows customization before returning instances.
    Helps manage different object types or caching.
    How?
    Use static methods to create and return instances.
    Implement validation, default values, or object reuse inside the method.

    enum FanType {
        CEILING, TABLE, EXHAUST
    }
    public class Fan {
        private String make;
        private double radius;
        private String color;
        private FanType type;
        private int speedLevels;

        // Private constructor to restrict direct instantiation
        private Fan(String make, double radius, 
            String color, FanType type, int speedLevels) {
            this.make = make;
            this.radius = radius;
            this.color = color;
            this.type = type;
            this.speedLevels = speedLevels;
        }
        // Factory method
        public static Fan createFan(FanType type, String make, 
            double radius, String color) {
            int defaultSpeedLevels;
            switch (type) {
                case CEILING:
                    // Ceiling fans typically have more speeds
                    defaultSpeedLevels = 5; 
                    break;
                case TABLE:
                    // Table fans usually have 3 speeds
                    defaultSpeedLevels = 3;
                    break;
                case EXHAUST:
                    // Exhaust fans generally have a single speed
                    defaultSpeedLevels = 1; 
                    break;
                default:
                    throw new IllegalArgumentException(
                                        "Unknown fan type");
            }
            return new Fan(make, radius, 
                            color, type, defaultSpeedLevels);
        }
        public void display() {
            StringBuilder sb = new StringBuilder();
            sb.append(type != null ? type + " Fan - " : "Fan - ");
            sb.append(make != null ? make : "Unknown Make");
            sb.append(", ").append(
                radius > 0 ? radius + " inches" : "Unknown Size");
            sb.append(", ").append(
                color != null ? color : "Unknown Color");
            sb.append(", Speed Levels: ")
            .append(speedLevels > 0 ? speedLevels : "N/A");

            System.out.println(sb.toString());
        }
        public static void main(String[] args) {
            Fan ceilingFan = Fan.createFan(FanType.CEILING, 
                                    "Havells", 48.0, "White");
            Fan tableFan = Fan.createFan(FanType.TABLE, 
                                    "Crompton", 16.0, "Blue");
            Fan exhaustFan = Fan.createFan(FanType.EXHAUST, 
                                    "Bajaj", 12.0, "Black");
            ceilingFan.display();
            tableFan.display();
            exhaustFan.display();
        }
    }

📌 6. Using Reflection API
    What? Creates an object using reflection.
    Why? Used in frameworks and dynamic object creation.
    How? Use Class.forName() and newInstance().
    public class Fan {
        private String make;
        private double radius;
        private String color;

        public Fan() {
            System.out.println(
                "Fan object created using Reflection!");
        }
        public static void main(String[] args) 
                                        throws Exception {
            Fan fan = (Fan) Class.forName("Fan")
                        .getDeclaredConstructor().newInstance();
        }
    }

📌 7. Using Cloning
    What? Copies an existing object.
    Why? Useful for creating duplicate objects.
    Cloning preserves the exact structure and properties of an object.
    Useful when an object has multiple attributes, and manually copying each field is cumbersome.
    How? Implement Cloneable and override clone().
    public class Fan implements Cloneable {
        private String make;
        private double radius;
        private String color;

        public Fan(String make, 
                    double radius, String color) {
            this.make = make;
            this.radius = radius;
            this.color = color;
        }
        @Override
        protected Object clone() 
                    throws CloneNotSupportedException {
            return super.clone();
        }
        public void display() {
            System.out.println(make + 
                    " " + radius + " " + color);
        }
        public static void main(String[] args) 
                    throws CloneNotSupportedException {
            Fan original = new Fan("Kenstar", 12.0, "Green");
            Fan cloned = (Fan) original.clone();
            original.display();
            cloned.display();
        }
    }

📌 8. Using Singleton
    What? Ensures only one instance of a class exists and provides a global access point to it.
    Why?
        Prevents multiple object creation, reducing memory usage.
        Ensures controlled access to shared resources.
    How?
        Declare a private static instance inside the class.
        Provide a public static method to return the instance.
        Make the constructor private to restrict direct instantiation.
        Example: Singleton for Database Connection

    Ensures only one database connection exists – getInstance() always returns the same reference.
    Prevents multiple connections – Avoids unnecessary resource usage.
    Global Access – Any class can get a database connection using DatabaseConnection.getInstance().

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class DatabaseConnection {
        private static DatabaseConnection instance;
        private Connection connection;

        private DatabaseConnection() {
            try {
                // Simulated database connection
                String url = "jdbc:mysql://localhost:3306/mydatabase";
                String user = "root";
                String password = "password";
                connection = DriverManager.
                                getConnection(url, user, password);
                System.out.println("Database connected.");
            } catch (SQLException e) {
                throw new RuntimeException(
                    "Error connecting to database!", e);
            }
        }
        // Public method to provide access to the single instance
        // TODO: Synchronize if you want to make this thread safe
        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }
        public Connection getConnection() {
            return connection;
        }
        public static void main(String[] args) {
            // Getting the singleton instance
            DatabaseConnection db1 
                    = DatabaseConnection.getInstance();
            DatabaseConnection db2 
                    = DatabaseConnection.getInstance();
            // Verifying both references point to the same object
            System.out.println("db1 == db2: " + (db1 == db2));
        }
    }

Method	                Purpose	                                                    JDK Example
Constructor	            When all values are known at creation	                    new Animal(Type.Dog, "name")

Setter Methods	        When values may change later	                            someObj.setSomeValue(100)

Initialization Block	Default values before constructor runs 	                    { name = "Default"; }
                        (Common logic for multiple constructors)

Static Block	        Useful for loading configuration data, database records,	static { System.loadLibrary("nativeLib"); }
                        or external resources before objects are created.

Factory Method	        Helps manage different object types or caching.	            List<String> list = List.of("A", "B", "C");

Reflection API	        Frameworks and dependency injection	                        Fan fan = (Fan) Class .forName("Fan").
                                                                                    getDeclaredConstructor() .newInstance();

Cloning	                Quickly and easily create an exact copy of an object	    Object clone = obj.clone();

Singleton	            Ensures only one instance exists in the JVM	                Runtime.getRuntime()
```
# default constructor 
```
What?
    A default constructor is a constructor with no parameters.
    If a class has no constructor, Java automatically provides a default constructor.
Why?
    It initializes an object with default values.
Example:
    public class Fan {
        public static void main(String[] args) {
            Fan fan = new Fan(); // Calls default constructor
            fan.display();
        }
    }
    Will a default constructor be provided if you define a custom constructor?
    No: Java does NOT provide a default constructor if a custom constructor is defined.
Example Without Custom Constructor
    public class Fan {
        private String make;
        // Java automatically provides:
        // public Fan() { }
    }
    //`new Fan();` 
// Java adds a default constructor. 

Example With Custom Constructor (No Default Constructor)
    public class Fan {
        private String make;
        // Custom Constructor
        public Fan(String make) {
            this.make = make;
        }
        public static void main(String[] args) {
            Fan fan1 = new Fan("Havells"); // ✅ Works
            Fan fan2 = new Fan(); // ❌ Compilation Error
        }
    }

How to Fix?
    If both default and parameterized constructors are needed, explicitly define the default constructor.
    public class Fan {
        private String make;
        // Default Constructor
        public Fan() { 
        }
        // Custom Constructor
        public Fan(String make) {
            this.make = make;
        }
    }
```
# copy constructor
```
What?
    A copy constructor creates a new object by copying another object.
Why?
    clone() copies everything. Copy constructor provides a way to customize what you want to copy!
How?
    Define a constructor that takes an object of the same class as a parameter.
Example:
    public class Fan {
        private String make;
        private double radius;
        private String color;
        // Constructor
        public Fan(String make, double radius, String color) {
            this.make = make;
            this.radius = radius;
            this.color = color;
        }
        // Copy Constructor
        public Fan(Fan other) {
            this.make = other.make;
            this.radius = other.radius;
            this.color = other.color;
        }
        public void display() {
            System.out.println(make + " " + radius + " " + color);
        }
        public static void main(String[] args) {
            Fan fan1 = new Fan("Havells", 12.5, "Black");
            Fan fan2 = new Fan(fan1); // Using copy constructor
            fan1.display();
            fan2.display();
        }
    }
```
# private constructor
```
What?
    A private constructor restricts object creation from outside the class.
Why?
    Singleton Pattern (Only one instance of a class).
    Factory Methods (Control object creation).
    Utility Classes (Prevent object creation).
Example (Singleton Pattern):
    public class Fan {
        private static Fan instance;
        // Private Constructor
        private Fan() {
            System.out.println("Fan instance created!");
        }
        public static Fan getInstance() {
            if (instance == null) {
                instance = new Fan();
            }
            return instance;
        }
        public static void main(String[] args) {
            Fan fan1 = Fan.getInstance();
            Fan fan2 = Fan.getInstance();
        }
    }

Example (Factory Method)
    enum FanType {
        CEILING, TABLE, EXHAUST
    }
    public class Fan {
        private String make;
        private double radius;
        private String color;
        private FanType type;
        private int speedLevels;

        // Private constructor to restrict direct instantiation
        private Fan(String make, double radius, 
            String color, FanType type, int speedLevels) {
            this.make = make;
            this.radius = radius;
            this.color = color;
            this.type = type;
            this.speedLevels = speedLevels;
        }
        // Factory method
        public static Fan createFan(FanType type, String make, 
            double radius, String color) {
            int defaultSpeedLevels;
            switch (type) {
                case CEILING:
                    // Ceiling fans typically have more speeds
                    defaultSpeedLevels = 5; 
                    break;
                case TABLE:
                    // Table fans usually have 3 speeds
                    defaultSpeedLevels = 3;
                    break;
                case EXHAUST:
                    // Exhaust fans generally have a single speed
                    defaultSpeedLevels = 1; 
                    break;
                default:
                    throw new IllegalArgumentException(
                                        "Unknown fan type");
            }
            return new Fan(make, radius, 
                            color, type, defaultSpeedLevels);
        }
    }

JDK Example: java.lang.Math
    The Math class consists solely of static methods and constants. To prevent instantiation, it employs a private constructor:
    public final class Math {
        // Private constructor prevents instantiation
        private Math() {}
        // Static methods and constants follow
    }

JDK Example: java.lang.Runtime
    The Runtime class follows the Singleton pattern, ensuring a single instance throughout the application's lifecycle. It achieves this by using a private constructor and a static method to provide access to the instance:
    public class Runtime {
        private static final Runtime currentRuntime = new Runtime();
        // Private constructor prevents instantiation
        private Runtime() {}
        public static Runtime getRuntime() {
            return currentRuntime;
        }
    }
```
# super() vs this() vs super. vs this.
```
Keyword	    What It Does	                            Where Used?	                    Example
super()	    Calls parent class constructor	            Inside a subclass constructor	super();
this()	    Calls another constructor in same class	    Inside a constructor	        this("Default", 10.0, "White");
super.	    Accesses parent class variables/methods	    Inside a subclass	            super.color
this.	    Refers to current class variables/methods	Inside the same class	        this.color

1. Using super() (Calling Parent Constructor)
    class Appliance {
        Appliance() {
            System.out.println("Appliance Constructor");
        }
    }
    class Fan extends Appliance {
        Fan() {
            super(); // Calls Appliance constructor
            System.out.println("Fan Constructor");
        }
        public static void main(String[] args) {
            Fan fan = new Fan();
        }
    }

2. Using this() (Calling Another Constructor)
    public class Fan {
        private String make;
        private double radius;
        private String color;

        // Constructor 1
        public Fan() {
            this("Havells", 12.0, "Black"); // Calls Constructor 2
        }
        // Constructor 2
        public Fan(String make, double radius, String color) {
            this.make = make;
            this.radius = radius;
            this.color = color;
        }
        public void display() {
            System.out.println(make + " " + radius + " " + color);
        }
        public static void main(String[] args) {
            // Calls first constructor
            // which calls the second constructor
            Fan fan = new Fan(); 
            fan.display();
        }
    }

3. Using super. and this. (Accessing Variables)
    class Appliance {
        String brand = "Generic";
    }
    class Fan extends Appliance {
        String brand = "Havells";

        public void showBrands() {
            System.out.println("Fan Brand: " 
                + this.brand); // Refers to Fan's brand
            System.out.println("Appliance Brand: " 
                + super.brand); // Refers to Appliance's brand
        }
        public static void main(String[] args) {
            Fan fan = new Fan();
            fan.showBrands();
        }
    }

Using this. is optional except when there is shadowing
    class Animal {
        private String name;
        private int age;
        private String species;

        public Animal(String name, int age, String species) {
            this.name = name;
            this.age = age;
            this.species = species;
        }
        //Equals
        @Override
        public int hashCode() {
            return Objects.hash(name, age, species);
        }
    }
```
# default methods in an interface
```
What?
    Default methods in an interface are methods with a body (implementation).
    Introduced in Java 8 using the default keyword.
Why?
    Helps in achieving backward compatibility:
    Allows adding new methods to interfaces without breaking existing code.
    Provides a default implementation that classes can override.
Example:
    interface Fan {
        void turnOn();
        // Default Method
        default void showStatus() {
            System.out.println("Fan is running");
        }
    }
    class CeilingFan implements Fan {
        public void turnOn() {
            System.out.println("Ceiling Fan is ON");
        }
    }
    public class Main {
        public static void main(String[] args) {
            CeilingFan fan = new CeilingFan();
            fan.turnOn();
            fan.showStatus(); // Calls default method
        }
    }
```
# How Do Default Methods Help in Achieving Backward Compatibility?
```
What
    Default methods in interfaces (introduced in Java 8) allow adding new methods without breaking existing implementations.
    This avoids the need to modify all implementing classes, making library upgrades smoother.
    Problem: Adding a New Method to an Interface
Consider an interface with an existing method methodA() and four implementations:
    //Defined in a Common Library
    interface ExampleInterface {
        void methodA();  // Existing method
    }
    // Four different classes implementing the interface
    // In Four Different Projects!
    class Class1 implements ExampleInterface {
        public void methodA() { 
            System.out.println("Class1 - methodA"); 
        }
    }
    class Class2 implements ExampleInterface {
        public void methodA() { 
            System.out.println("Class2 - methodA"); 
        }
    }
    class Class3 implements ExampleInterface {
        public void methodA() { 
            System.out.println("Class3 - methodA"); 
        }
    }
    class Class4 implements ExampleInterface {
        public void methodA() { 
            System.out.println("Class4 - methodA"); 
        }
    }

Option 1: Adding methodB() to Interface (Without Default Method)
    All four classes must implement methodB(), or the code won’t compile.
    interface ExampleInterface {
        void methodA();
        // New method added
        // Breaks existing implementations
        void methodB();  
    }
    If this interface is part of a library and the four implementations are in different components, every component must be updated, which is not practical for backward compatibility.
Option 2: Using a Default Method for Backward Compatibility
    Instead of breaking all implementations, we provide a default implementation in the interface.
    Existing classes continue to work without modification, but they can override methodB() if needed.
    interface ExampleInterface {
        void methodA();  
        default void methodB() {
            System.out.println("Default methodB implementation");
        }
    }
```
# Marker Interface
```
What?
    A marker interface is an interface with no methods or fields.
Why?
    Tells the Java compiler or runtime that a class has a special property.
    Used by Java libraries to enable specific behavior.
    Example: Serializable tells Java that an object can be serialized.
Examples in Java:
Marker Interface	Purpose
Serializable	    Enables object serialization
Cloneable	        Allows object cloning
Remote	            Supports remote method invocation

Example (Creating Marker Interface)
    SecureResource is an empty interface used to mark classes needing extra security.
    BankAccount implements SecureResource, while PublicDocument does not require extra security.
    verifyAccess() uses instanceof to determine if an object needs additional verification.

    // Marker Interface (Empty)
    interface SecureResource {}

    // Class implementing the marker interface
    class BankAccount implements SecureResource {
        private String accountNumber;
        private double balance;

        public BankAccount(
            String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
        public void display() {
            System.out.println("Bank Account: " + accountNumber + 
                            ", Balance: $" + balance);
        }
    }
    // Class without marker interface
    class PublicDocument {
        private String title;
        public PublicDocument(String title) {
            this.title = title;
        }
        public void display() {
            System.out.println("Public Document: " + title);
        }
    }
    // Utility to check security access
    class SecurityCheck {
        public static void verifyAccess(Object obj) {
            if (obj instanceof SecureResource) {
                System.out.println(
                    "Additional security check needed.");
            } else {
                System.out.println("Access granted.");
            }
        }
    }
    public class MarkerInterfaceDemo {
        public static void main(String[] args) {
            BankAccount account = 
                new BankAccount("123456789", 5000.00);
            PublicDocument doc = 
                new PublicDocument("Public Guidelines");
            account.display();
            doc.display();
            SecurityCheck.verifyAccess(account);
            SecurityCheck.verifyAccess(doc);
        }
    }
```
# Different Types of Inner Classes in Java
```
What?
    An inner class is a class defined inside another class.
Why?
    Improves encapsulation (restricts access).
    Helps group related logic together.
    Can access private members of the outer class.

Types of Inner Classes in Java
Type	                Definition	                                    Use Case
Member Inner Class	    A class inside another class (without static).	When an inner class needs access to
                                                                        all members of the outer class.

Static Nested Class	    A static class inside another class.	        When the inner class does not need access
                                                                        to instance members of the outer class.

Local Inner Class	    A class inside a method.	                    When a class is used only within a method.

Anonymous Inner Class	A class without a name, used once.	            When a class is needed only for a single use case.

📌 1. Member Inner Class
What?
    A non-static class inside another class.
    Can access all members (including private) of the outer class.
    Use when an inner class needs access to instance members of the outer class.
    When you need to encapsulate logic that is tightly coupled with the outer class, like handling employee salary calculations inside an Employee class.
Example: Member Inner Class
    class Employee {
        private String name;
        private double baseSalary;

        Employee(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }
        // Member Inner Class
        class SalaryCalculator {
            double calculateBonus(double percentage) {
                return baseSalary * percentage / 100;
            }
            void displaySalaryDetails() {
                System.out.println("Employee: " + name);
                System.out.println("Base Salary: $" + baseSalary);
                System.out.println("Bonus: $" + calculateBonus(10));
            }
        }
    }
    public class Main {
        public static void main(String[] args) {
            Employee emp = new Employee("John Doe", 5000);       
            // Creating Inner Class Object
            Employee.SalaryCalculator calculator = emp.new SalaryCalculator();
            calculator.displaySalaryDetails();
        }
    }

📌 2. Static Nested Class
What?
    A static inner class does not require an instance of the outer class.
    Can only access static members of the outer class.
    Use when an inner class does not need access to instance variables of the outer class.
    When you need a helper class that groups related functionality, like a Database.Connection class managing database connections without needing an outer class instance.

    class Database {
        private static String url = "jdbc:mysql://localhost:3306/mydb";
        // Static Nested Class
        static class Connection {
            void connect() {
                // Can access only static members
                System.out.println("Connecting to: " + url);
            }
        }
    }
    public class Main {
        public static void main(String[] args) {
            // No outer class object needed
            Database.Connection connection = new Database.Connection();       
            connection.connect();
        }
    }

📌 3. Local Inner Class
What?
    A class inside a method.
    Only accessible within the method where it is defined.
    Use a local inner class when you need temporary, method-specific logic, like generating invoices inside an order processing method without exposing the class globally.

Example: Defining a Class Inside a Method
    class Order {
        private String orderId = "ORD123";
        void processOrder() {
            // Local Inner Class
            class Invoice {
                void generateInvoice() {
                    System.out.println("Generating invoice for Order ID: " + orderId);
                }
            }
            // Local Inner Class object
            Invoice invoice = new Invoice();
            invoice.generateInvoice();
        }
    }
    public class Main {
        public static void main(String[] args) {
            Order order = new Order();
            order.processOrder();
        }
    }

📌 4. Anonymous Inner Class
What?
    A class without a name.
    Defined and instantiated in one step.
    Use when only a single-use implementation is needed.

Example: Implementing an Interface Without Creating a Separate Class
    interface Fan {
        void turnOn();
    }
    public class Main {
        public static void main(String[] args) {
            // Anonymous Inner Class
            Fan fan = new Fan() {
                public void turnOn() {
                    System.out.println("Fan is turning on...");
                }
            };
            fan.turnOn();
        }
    }

📌 When to Use What?
    Member Inner Class → Use when an employee’s salary calculation logic is tightly coupled with the Employee class (needs full access to outer class members).
    Static Nested Class → Use when a Database.Connection class manages connections independently of the Database instance (does not need instance variables of the outer class).
    Local Inner Class → Use when an Order class needs an Invoice generator inside its processOrder() method (used only within a specific method).
    Anonymous Inner Class → Use when handling a button click event in a GUI application (needed only once, for immediate use).
```
# How is a reference variable different from a primitive variable?
```
A reference variable stores the memory location of an object, while a primitive variable directly stores a value.
    // Primitive variable stores the actual value 5
    int i = 5; 
    // Reference variable stores the memory location of the object
    Animal dog = new Animal(12); 

    Primitive variables are stored in the stack memory.
    Reference variables are stored in the stack, but the objects they refer to are stored in the heap memory.
What happens when you assign a reference variable to another?
    When a reference variable is assigned to another, only the memory location (reference) is copied, not the actual object.
Example:
    Animal cat = new Animal(15);
    Animal nothing = cat; // Copies reference, not the object
    Both cat and nothing now point to the same object in memory.
    Since reference variables point to the same object, modifying the object through one reference affects all references pointing to it.

Example:
    nothing.id = 10;
    // Output: 10
    System.out.println(cat.id); 
    Since nothing and cat refer to the same object, changing nothing.id also updates cat.id.
```