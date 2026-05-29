## How is Java Marching Forward?
```
📌 Breaking Myth
    Myth: "Java is old and unpopular"
    Truth: Java remains one of the most popular programming languages worldwide!
        Java is one of the popular choices for building:
        Modern cloud applications (Spring Boot, Quarkus, Micronaut)
    IMHO Java is evolving faster than ever, staying modern, powerful, and future-proof!
📌 Continuous Innovation in Java Eco System
    Java 8 – Embraced functional programming with Lambda expressions and Streams.
    Java 9 – Introduced modularization to the Java Platform - enabling faster startup and less memory footprint for Java applications
    Java 10 to NOW – Started the six-month release cycle for faster updates and quick feedback.
    Java 11 to NOW – Reduced code verbosity
        Switch Expressions – More concise conditional logic.
        Text Blocks – Simplifies multi-line strings.
        Records – Reduces boilerplate for data objects.
        Pattern Matching – Enhances code readability and conciseness.
Java 21 to NOW:
    Project Loom – Virtual threads for high-performance concurrency.
    Cloud & Container-Ready – Optimized for modern cloud-native applications.
```
## What are the primary goals behind recent Java releases?
```
    Make it concise – Reduce boilerplate and improve readability.
    Records – No need for boilerplate code in data classes.
        record Person(String name, int age) {}

    Switch Expressions – More readable and concise switch statements.
        String result = switch (day) {
            case MONDAY, FRIDAY -> "Weekend is near!";
            default -> "Regular day.";
        };

    Cloud and container support – Improve compatibility with cloud-native environments.
    Optimized JDK Container Images – Optimized JDK images for containers with small memory footprint and fast start up times.
    GraalVM – Enables efficient native image compilation for lightweight, fast-running applications.
    Improve concurrency – Introduce Virtual Threads for scalable parallelism.
    Virtual Threads – Handles millions of lightweight threads efficiently.
        Thread.startVirtualThread(
            () -> System.out.println(
            "Hello from a virtual thread!"));

    Developer productivity – Provide better debugging tools and runtime efficiency.
    JShell – Interactive REPL for quick testing.
        jshell> System.out.println("Hello, Java!");

    Simpler Main Without Class - Write just the method, skip the boilerplate
        //HelloWorld.java
        void main() {
        System.out.println("Hello, World!");
        }

    Easy Launch without Compilation - Run source files directly
        $ java HelloWorld.java

    Reduce startup time – Optimize performance for faster application launch.
    Better memory management – Optimize Garbage Collection (GC) for lower latency.
    Backward compatibility – Ensure smooth migration from older versions.
```
## What are some major Java versions and their most important features?
```
📌 J2SE 5.0
Enhanced For Loop – Simplifies iteration over collections and arrays.
    for (int num : numbers) {
    //Do something
    }
Generics – Enables type safety in collections and methods.
    public class HashMap<K,V> extends AbstractMap<K,V>
Enums – Provides a type-safe way to define constants.
    enum Season {
        WINTER, SPRING, SUMMER, FALL
    }
Autoboxing – Automatically converts primitives to wrapper classes.
    Integer integer = 5;
    int i = integer;

📌 Java SE 7
Try-With-Resources: Automates resource management in try-catch blocks.
    try (BufferedReader br = 
        new BufferedReader(new FileReader("file.txt"))) {
Strings in Switch: Allows using String values in switch statements.
    switch (day) {
        case "Monday": //Do Something;
        case "Friday": //Do Something;
        case "Sunday": //Do Something;
        default: //Do Something;
    }

📌 Java SE 8
Lambda Expressions – Allows writing concise, functional-style code.
    public static Predicate<Course> 
            createPredicate(int cutoff) {
        return course -> course.getReviewScore() > cutoff;
    }
Streams API – Provides a powerful way to process collections.
    List<String> transformedNumbers = numbers.stream()
                .map(x -> x * x)  // Step 1: Square each number
                .map(x -> x + 10) // Step 2: Add 10
                .map(x -> "Value: " + x) // Step 3: Convert
                .toList();    // Collect the result
Functional Programming – Introduces higher-order functions and immutability.
    courses.stream().sorted((c1, c2) -> c1.length() - c2.length())
        .forEach(System.out::println);

📌 Java SE 9
Modularization – Splits JDK into modules for better scalability.
JShell (REPL) – Interactive command-line tool for testing Java code.
    jshell> System.out.println("Hello, Java!");

📌 Java SE 10
Local Variable Type Inference (var) – Allows type inference for local variables.
    // ArrayList<String> numbers = new ArrayList<>();
    // No need to repeat ArrayList<String>
    var numbers = new ArrayList<String>(); 
    // Inferred as HashMap<Integer, String>
    var map = new HashMap<Integer, String>(); 

📌 Java SE 14
Switch Expressions – Enables switch to return values, reducing boilerplate code.
    String result = switch (day) {
        case MONDAY, FRIDAY -> "Weekend is near!";
        default -> "Regular day.";
    };

📌 Java SE 15
Text Blocks – Simplifies working with multi-line strings.
    String json = """
        {
        "name": "John", "age": 30
        }
        """;
    //json ==> "{\n  \"name\": \"John\",\n  \"age\": 30\n}\n"

📌 Java SE 16
Pattern Matching for instanceof - Simplify code making use of instanceof
    public void process(Object obj) {
        if (obj instanceof String s) {
            // No explicit cast needed
            System.out.println("Message: " + s);  
        }
    }
Record Classes – Provides a compact syntax for immutable data objects.
    public record Person(String name, String email, String phoneNumber) {}

📌 Java SE 17
Sealed Classes - Controlled inheritance of your class hierarchies.
    sealed class Vehicle permits Car, Truck, Bike {} 
    // No further subclassing  
    final class Car extends Vehicle {}  
    // Can be extended freely  
    non-sealed class Truck extends Vehicle {}
    sealed class Bike extends Vehicle permits ElectricBike {}  
    // No further subclassing  
    final class ElectricBike extends Bike {}  

📌 Java SE 21
Virtual Threads – Improves concurrency with lightweight threads.
    Thread.startVirtualThread(
        () -> System.out.println("Hello from a virtual thread!"));
Sequenced Collections – Adds operations for ordered collections.
    interface SequencedCollection<E> extends Collection<E> {
        void addFirst(E element);  
        void addLast(E element);
        E getFirst();  
        E getLast();  
        E removeFirst();  
        E removeLast();  
        SequencedCollection<E> reversed();
    }
Record Patterns - Supports deconstruction, including nested patterns
    record Transaction(
        String sender, String receiver, double amount) {}
    public void processTransaction(Object obj) {
        if (obj instanceof Transaction(String sender, String receiver, double amount)) {
            System.out.println("Processing transaction: " + sender + " -> " + receiver + " : ₹" + amount);
        }
    }
Pattern Matching for Switch - More expressive and type-safe switch statements
    interface CustomerMessage{}
    record TextMessage(String text) implements CustomerMessage {}
    record Ticket(int ticketNumber) implements CustomerMessage {}
    CustomerMessage message = new Ticket(1050);
    String response = switch (message) {
        case TextMessage(String text) -> "Processing text message: " + text;
        case Ticket(int ticketNumber) -> "Processing support ticket: #" + ticketNumber;
    };
    System.out.println(response);

📌 Java SE 22
Unnamed Variables & Patterns – Allows ignoring unused variables in code.
    switch (obj) { //I will not use the value!
        case String _ -> System.out.println("String");
        case Integer _ -> System.out.println("Integer");
        default -> System.out.println("Unknown type.");
    }

📌 Java SE 23
Markdown Documentation Comments – Enhances Javadoc with Markdown support.
    /// This is the **traditional** 
    /// *Hello World!* program.
    /// This is the <strong>traditional</strong> 
    /// <em>Hello World!</em> program.

📌 Java SE 24
Stream Gatherers – Introduces new ways to aggregate stream data.
    //A new way to group, 
    //transform, and aggregate stream elements
    List<List<Integer>> windows = numbers.stream()
                .gather(Gatherers.windowFixedSize(3)).toList();
    //[1, 2, 3]
    //[4, 5, 6]
    //[7, 8, 9]
    //[10]

📌 Ongoing Improvements
    Performance Optimizations – Enhances start up speed, memory footprint and efficiency of Java applications.
    Garbage Collection Enhancements – Improves memory management and GC algorithms.
    API and Syntactic Improvements – Continuously refines Java syntax and library functions.
```