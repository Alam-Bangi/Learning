# Wrapper Classes
```
📌 What?
    Represents wrappers around primitive data types (int, double, etc.)
    Implemented in java.lang package (e.g., Integer, Double)
📌 Why?
    Allows primitives to be used as objects (e.g., in collections like ArrayList).
        Works with collections and other generic classes (List<Integer>, Optional<Double>).
    Provides utility methods (e.g., Integer.parseInt(), Double.valueOf()).
    Supports autoboxing and unboxing, making conversions easier.
Example:
    // Cannot use List<int>
    List<Integer> numbers = new ArrayList<>();
    numbers.add(10);  // Autoboxing (int → Integer)
    numbers.add(20);
    // Unboxing (Integer → int)
    int sum = numbers.get(0) + numbers.get(1); 
    System.out.println("Sum: " + sum);

Example Methods in Wrapper Classes

Wrapper     Method	                Description	                            Example
Integer	    valueOf (String s)	    Converts a string to an Integer object	Integer num = Integer. valueOf("100");
Integer	    parseInt (String s)	    Converts a string to an int primitive	int num = Integer. parseInt("100");
Integer	    compare (int x, int y)	Compares two int values	                Integer. compare(10, 20); // returns -1
Integer	    toBinaryString (int n)	Converts an int to a binary string	    Integer. toBinaryString(5); // "101"
Double	    valueOf (String s)	    Converts a string to a Double object	Double num = Double. valueOf("3.14");
Double	    parseDouble (String s)	Converts a string to a double primitive	double num = Double. parseDouble("3.14");
Double	    isNaN (double d)	    Checks if value is NaN(Not a Number)	Double. isNaN(0.0 / 0.0); // true
Boolean	    valueOf (String s)	    Converts a string to a Boolean object	Boolean flag = Boolean. valueOf("true");
Boolean	    parseBoolean (String s)	Converts a string to boolean primitive	boolean flag = Boolean. parseBoolean("true");
Character	isDigit (char ch)	    Checks if a character is a digit	    Character. isDigit('5'); // true
Character	toUpperCase (char ch)	Converts a character to uppercase	    Character. toUpperCase('a'); // 'A'
Character	toLowerCase (char ch)	Converts a character to lowercase	    Character. toLowerCase('A'); // 'a'

- Autoboxing: Converts a primitive into a wrapper object automatically.
    Integer num = 10;  // int → Integer
- Unboxing: Converts a wrapper object back into a primitive automatically.
    int value = num;   // Integer → int
- Immutable: Wrapper class objects cannot be modified after creation.

--------------------- Usage ---------------------
📌 1. Creating Wrapper Objects
    Use valueOf() instead of new (Efficient Memory Usage)
    Integer num = Integer.valueOf(10); // Uses cached objects
    Integer num = new Integer(10); // Unnecessary object creation

📌 2. Avoid Autoboxing in Loops (Performance Issue)
    Autoboxing creates unnecessary objects, leading to performance issues.
    int sum = 0;
    for (int i = 0; i < 1000; i++) {
        sum += i;  // Uses int (fast) 
    }
    int sumFunctional = IntStream.range(0, 1000).sum(); //Even Faster
Avoid: 
    Integer sum = 0;
    for (int i = 0; i < 1000; i++) {
        sum += i;  // Autoboxing occurs (slow)
    }

📌 3. Use parseXxx() for String to Primitive Conversion
    Avoids unnecessary object creation
    int num = Integer.parseInt("123");
    Integer num = new Integer("123"); // Deprecated and inefficient

--------------------- Usage with Integer.valueOf() ---------------------
📌 What?
    Integer.valueOf(int) caches commonly used integer values.
    Instead of creating a new object, it reuses an existing one from the cache when possible.
📌 Why?
    Reduces memory usage by avoiding unnecessary object creation.
    Improves performance since cached objects are returned instead of allocating new memory.
📌 How?
    Java maintains a cache of Integer objects for values from -128 to 127.
    When Integer.valueOf(n) is called within this range, it returns a cached object instead of creating a new one.
    If the number is outside the range, a new object is created.
📌 Example: 
    Integer a = Integer.valueOf(100); // Cached
    Integer b = Integer.valueOf(100); // Cached
    System.out.println(a == b); // true (Same cached object)

    Integer x = Integer.valueOf(200); // Not Cached
    Integer y = Integer.valueOf(200); // Not Cached
    System.out.println(x == y); // false (Different objects)

📌 Where is this cache defined?
    Java uses an internal cache inside the Integer class.
    The cache is implemented in IntegerCache (an inner class of Integer).

    private static class IntegerCache {
        static final Integer cache[];
        static {
            // Cache range: -128 to 127
            cache = new Integer[-(-128) + 127 + 1]; 
            for (int i = 0; i < cache.length; i++)
                cache[i] = new Integer(i - 128);
        }
    }

Wrapper Class	Cached Values
Byte	        All values (-128 to 127)
Short	        -128 to 127
Integer	        -128 to 127
Long	        -128 to 127
Character	    0 to 127 (ASCII characters)
Boolean	        true and false
Float	        ❌ No caching
Double	        ❌ No caching

--------------------- Wrapper Classes in Java Immutable ---------------------
📌 What is Immutability?
    What? Immutability means an object cannot be modified after it is created.
    Why? Helps with thread safety, caching, and predictable behavior.
    How? Any modification creates a new object instead of changing the existing one.
Example of an Immutable Class in Java:
    Final class prevents subclassing.
    Private final fields prevent changes after initialization.
    No setter methods ensure immutability.

📌 Wrapper Classes are Immutable
    What? Wrapper classes (Integer, Double, Boolean, etc.) are immutable in Java.
    Why?
    Caching Mechanism – Frequently used values (Integer.valueOf(10)) are reused, reducing memory usage.
    Thread Safety – Threads cannot modify shared values.

    Integer x = 10;
    // Creates a new Integer object, 
    //old one is discarded
    x = x + 1; 
    System.out.println(x); // Output: 11
```
# String vs StringBuffer vs StringBuilder
```
📌 Using String for Immutable Data
    What? Used for storing fixed values like constants, configuration keys, or error messages.
    
    String greeting = "Hello";  
    greeting += " World"; // Creates a new String object
    System.out.println(greeting); // Output: Hello World
When to Use String class?
    ✅ Fixed values that do not change
    ❌ Avoid for frequent modifications (creates multiple objects)

📌 Using StringBuffer for Thread-Safe Modifications
    What? A mutable string alternative that is thread-safe (synchronized).
    Why? Ensures safe string modification in multi-threaded environments.

    StringBuffer buffer = new StringBuffer("Thread-safe");
    buffer.append(" operations");
    buffer.insert(0, "Ensuring ");
    buffer.reverse();
    System.out.println(buffer);
When to Use?
    ✅ Multi-threaded modifications
    ❌ Avoid in single-threaded cases (slower than StringBuilder)

📌 Using StringBuilder for Fast String Modifications
    What? A mutable string alternative optimized for performance.
    Why? Faster than StringBuffer because it is not synchronized.

    StringBuilder builder = new StringBuilder("Efficient");
    builder.append(" string");
    builder.append(" operations");
    builder.delete(0, 4); // Removes "Effe"
    System.out.println(builder);
When to Use?
    ✅ Frequent modifications in single-threaded programs
    ❌ Avoid in multi-threaded environments (not thread-safe)

📌 Avoiding Performance Issues with String Concatenation in Loops
    ❌ Inefficient Approach Using String: Creates 1000+ unnecessary String objects, impacting performance.
    String result = ""; 
    for (int i = 0; i < 1000; i++) {
        // Creates a new String object in every iteration
        result += i; 
    }
    System.out.println(result.length());

    ✅ Optimized Approach Using StringBuilder: Uses a single StringBuilder object, significantly improving performance.
    StringBuilder result = new StringBuilder(); 
    for (int i = 0; i < 1000; i++) {
        result.append(i);
    }
    System.out.println(result.length());

Factor	            String	                StringBuffer	                    StringBuilder
Immutable Data	✅  YES	                   ❌ NO	                               ❌ NOT
Thread Safety	✅  Thread-Safe	✅         Thread-Safe	                       ❌ Not Safe
Performance (Loops)	❌ Slowest	           ❌ Slower (due to synchronization)   Fast
Frequent Changes	❌ Creates new objects  Thread-Safe	✅                      Best for performance
```
# Why Are String Classes in Java Immutable?
```
    What? The String class in Java is immutable, meaning its value cannot be changed after creation.
    Why?
    Security – Strings are used in class loading, networking, and security keys. If mutable, an attacker could change "password123" to "password456".
    Thread Safety – Since a String object cannot change, it can be shared safely across threads.
    String Pooling Optimization – Multiple references to the same string reuse the same object, saving memory.
Example of String Immutability:
    public class StringImmutableExample {
        public static void main(String[] args) {
            String s = "Hello";
            s.concat(" World"); // Creates a new object
            //does NOT modify `s`
            System.out.println(s); // Output: Hello
        }
    }
    Why does "Hello" remain unchanged? → s.concat(" World") creates a new String, but s still points to "Hello".
```
# Text Blocks
```
Example Without Text Blocks:
    String json = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": 30\n" +
                "}";
Same Example With Text Blocks:
    String json = """
        {
        "name": "John",
        "age": 30
        }
        """;
    //json ==> "{\n  \"name\": \"John\",\n  \"age\": 30\n}\n"

Summary:
    Java New Feature: Introduced in JDK 15
    Less Escape Sequences: No more \n or \" for multi-line strings.
    More Readable: Code looks like actual text formatting.
    Auto Alignment: Handles indentation automatically.
    Better for JSON, HTML, SQL: Keeps structure intact.
```
# String Pool
```
    What? A special memory area inside the heap where string literals are stored only once.
    Why? Saves memory by reusing the same String object instead of creating duplicates.
    How? When a new string is created using double quotes (""), it is automatically added to the pool.
        If the same string already exists, Java reuses the existing reference instead of creating a new object.
Example of String Pool Optimization:
    Both s1 and s2 refer to the same "Java" object in the pool, improving memory efficiency.
        String s1 = "Java"; // Stored in String Pool
        String s2 = "Java"; // Reuses the same object
        System.out.println(s1 == s2); // Output: true (same reference)

Heap Memory
    When using new String("Hello"), a new object is always created in the heap memory, even if the same value exists in the pool.
    This results in two objects: one in the heap and one in the pool (if not already present).
Example:
    String s1 = "Hello"; // Stored in String Constant Pool
    String s2 = "Hello"; // Reuses the same object
    String s3 = new String("Hello"); // Creates a new object in Heap 
    System.out.println(s1 == s2); // true (same reference)
    System.out.println(s1 == s3); // false (different objects)
🎯 Best Practice:
    Always prefer string literals (String str = "Hello";) to save memory and improve performance.
```
# How Does intern() Work?
```
    What? Forces a string to be stored in the String Pool, even if it was created using new.
    Why? Helps reduce duplicate objects and optimize memory.
Example of intern() Method:
    s1 is created outside the pool, but s1.intern() moves it into the pool.
    s2 and s3 now share the same reference, saving memory.
        String s1 = new String("Hello");
        String s2 = s1.intern(); // Moves to String Pool
        String s3 = "Hello";
        System.out.println(s2 == s3); // Output: true
```
# What are the things to be careful about when comparing Strings?
```
Using == instead of .equals()
    == compares references, not values.
    Always use .equals() to check content equality.
        String s1 = "Hello";
        String s2 = new String("Hello");
        System.out.println(s1 == s2); // false (different objects)
        System.out.println(s1.equals(s2)); // true (same content)
Case Sensitivity
    equals() is case-sensitive. Use equalsIgnoreCase() for case-insensitive checks.
    System.out.println("hello".equalsIgnoreCase("HELLO")); // true
String Pool Behavior
    String literals are stored in the String Constant Pool and can be shared.
    Using new String() creates a new object, even if the same value exists.
        String a = "Java"; 
        String b = "Java"; 
        
        System.out.println(a == b); // true (same object in pool)
        String c = new String("Java");
        System.out.println(a == c); // false (different objects)
```
# What Are the Best Practices with Conditionals?
```
Use else if Instead of Multiple if Statements
        if (age < 18) {
            System.out.println("Minor");
        } else if (age < 60) {
            System.out.println("Adult");
        } else {
            System.out.println("Senior");
        }
Avoid Complex Conditions
Hard to Read (Complex Condition in if)
    if ((age > 18 && hasLicense) 
            || (age > 16 && hasPermit && !hasViolations)) {
        System.out.println("Allowed to drive");
    }
Improved Readability (Using Meaningful Variables)
    boolean isAdultWithLicense = age > 18 && hasLicense;
    boolean isTeenWithPermit = age > 16 && hasPermit && !hasViolations;
    if (isAdultWithLicense || isTeenWithPermit) {
        System.out.println("Allowed to drive");
    }
Prefer Ternary Operator for Simple Cases
    // ❌ Verbose
    String result;
    if (x > 10) result = "High"; else result = "Low";
    // ✅ Use ternary
    String result = (x > 10) ? "High" : "Low";

Use switch Instead of Multiple if-else When Applicable
    String result = switch (day) {
        //Add other days :)
        case "Monday", "Tuesday" -> "Workday";        
        default -> "Weekend";
    };
    System.out.println(result);
```
# What Are the Best Practices with Loops?
```
Use Enhanced for Loop or Functional Programming for Collections (Faster & Readable)
    // ❌ Slower: Uses index-based access repeatedly
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    }
    // ✅ Faster: Uses iterator internally
    for (String item : list) {
        System.out.println(item);
    }
// ✅ ALTERNATIVE: Functional Programming
    list.forEach(System.out::println);

Avoid Expensive Operations Inside Loops
    // ❌ Inefficient: Calls `list.size()` in each iteration
    for (int i = 0; i < list.size(); i++) {
        process(list.get(i));
    }
    // ✅ Efficient: Store size in a variable
    int size = list.size();
    for (int i = 0; i < size; i++) {
        process(list.get(i));
    }
// ✅ ALTERNATIVE: Functional Programming
    list.forEach(this::process);

Use StringBuilder Instead of String for Concatenation
    // ❌ Inefficient: Creates new String objects in each iteration
    String result = "";
    for (String word : words) {
        result += word;  // New object each time
    }
    // ✅ Efficient: Uses a single `StringBuilder` object
    StringBuilder result = new StringBuilder();
    for (String word : words) {
        result.append(word);
    }

Use break and continue Wisely
    // ❌ Inefficient: Loops through all elements 
    //  even after finding the match
    for (int num : numbers) {
        if (num == target) {
            System.out.println("Found!");
        }
    }
    // ✅ Efficient: Stops loop once found
    for (int num : numbers) {
        if (num == target) {
            System.out.println("Found!");
            break; // Exits loop early
        }
    }

Use Parallel Streams for Large Data Sets (Java 8+)
    // ✅ Parallel processing for large lists
    list.parallelStream().forEach(System.out::println);

Choose the Right Loop Type

Scenario	                    Best Loop Type
Fixed number of iterations	    for loop
Loop until condition is met	    while loop
Iterating over a collection	    Enhanced for loop
Processing large datasets	    parallelStream()
```
# What Are the Best Practices with Using Arrays?
```
Use Arrays.toString() to Print Arrays
    int[] myArray = {1, 2, 3, 4};
    // ❌ Prints something like [I@1b6d3586
    System.out.println(myArray); 
    // ✅ Prints: [1, 2, 3, 4]
    System.out.println(Arrays.toString(myArray));

Use Enhanced for Loop or Functional Programming instead of Traditional for Loop
    for (int num : myArray) {
        System.out.println(num);
    }
    Arrays.stream(myArray).forEach(System.out::println); // Functional Programming

Use Arrays.equals() to Compare Arrays
    if (Arrays.equals(array1, array2)) {
        System.out.println("Arrays are equal");
    }
    //If you compare arrays using ==, 
    //it checks only the memory references, NOT the actual contents.

Use Arrays.deepEquals() for Multidimensional Arrays
    if (Arrays.deepEquals(array1, array2)) {
        System.out.println("2D Arrays are equal");
    }

Use Arrays.copyOf() for Cloning
    int[] original = {1, 2, 3, 4, 5};
    int[] copy = Arrays.copyOf(original, original.length);
    //[1, 2, 3]
    int[] partialCopy = Arrays.copyOf(original, 3);
    //[1, 2, 3, 4, 5, 0, 0]
    int[] expanded = Arrays.copyOf(original, 7);
    //Creates a new array → No modification of the original.
    //Simple way to resize arrays

Use System.arraycopy() for Fast Copying of values (Faster than looping for large arrays)
    //dest is an existing array
    System.arraycopy(src, 0, dest, 0, src.length);
    //Can copy from any index
    //Faster (native implementation)

Use List Instead of Arrays When Possible
    //Allows Adding/Removing Elements
    List<String> list = new ArrayList<>(Arrays.asList(array));

Use Streams for Advanced Array Operations
    int sum = Arrays.stream(myArray).sum();
```
# How do Records improve the conciseness of Java code?
```
    Records eliminate boilerplate code in Java Beans by automatically generating:
    Constructor
    Getters (accessors)
    toString(), equals(), and hashCode()
    Makes code more readable and maintainable.
    Before Records (Verbose Java Class)

public class Person {
    private final String name;
    private final String email;
    private final String phoneNumber;

    public Person(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getName() { 
        return name; 
    }
    public String getEmail() { 
        return email; 
    }
    public String getPhoneNumber() { 
        return phoneNumber; 
    }
    @Override
    public String toString() { 
        /* Implementation */ 
    }
}

With Records (Concise and Readable)
    public record Person(
        String name, String email, 
        String phoneNumber) {}
    //You Can Write Code like this!
    Person person = new Person("John Doe", "john@example.com", "1234567890");
    // Auto-generated toString()
    System.out.println(person); 
    // No need for getName()
    System.out.println(person.name());
    // No need for getEmail()
    System.out.println(person.email());
```
# What are the things that you should be careful about when using Records?
```
📌 Records Are Immutable
    Fields cannot be changed after object creation.
    Person p = new Person("Alice", "alice@example.com");
    // p.name = "Bob";  // Compilation Error
    If a class needs mutable state or complex behavior, use a regular class instead.

    public class BankAccount {
        private double balance;
        public void deposit(double amount) { 
            balance += amount; 
        }
        public void withdraw(double amount) { 
            balance -= amount; 
        }
    }

📌 Cannot Add Instance Variables
    Fields must be declared in the record header.
    public record Product(String name, double price) {
        // private int discount;  
        // ❌ ERROR - Cannot add instance variables
    }

📌 Inheritance is Not Supported
    Records extend java.lang.Record.
    Records cannot extend other classes (but can implement interfaces).
    public record Employee(
            String name, int id) /* extends Person */ {}  
            // ❌ ERROR

📌 When to Use Records?
    Data Models (e.g., UserDTO)
    Configurations (e.g., AppSettings)
    Lightweight Domain Objects (e.g., Rectangle, Person)

📌 When NOT to Use Records?
    Mutable Objects (e.g., BankAccount)
    Complex Business Logic
    Inheritance-Based Hierarchies

📌 Good to Know: Simple Record Pattern Matching
    record Course(int id, String name) {}
    public static void processCourse(Object obj) {
        if (obj instanceof Course(int id, String name)) {
            System.out.println(
                "Course ID: " + id + ", Name: " + name);
        }
    }

📌 Good to Know: Nested Record Pattern Matching
    record Person(String name, int age) {}
    record Address(String street, String city) {}
    record Contact(Person person, Address address) {}
    public static void processContact(Object obj) {
        if (obj instanceof Contact(
                Person(var name, var age), 
                Address(var street, var city))) {
            System.out.println(name + " lives in " + city);
        }
    }

Summary:
    Records introduced in JDK 16
    Advanced Pattern Matching in JDK 21
```