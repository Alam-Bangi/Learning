## What are some best practices for using enums in Java?
```
How does Enum help?
    Fixed Set of Constants – Define all allowed values in one place
    Type Safe – Only valid enum values can be used
    Readable Code – Improves clarity over magic strings or numbers
    Prevents Errors – No typos or invalid assignments
    Switch Friendly – Works great in switch statements
JDK Examples
    java.time.DayOfWeek (enum representing the 7 days of the week)
    java.util.concurrent.TimeUnit (Represents time durations - NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS)
    java.lang.Thread.State
    public enum State {
        NEW,
        RUNNABLE,
        BLOCKED,
        WAITING,
        TIMED_WAITING,
        TERMINATED;
    }
Simple Example:
    enum Status {
        PENDING, APPROVED, REJECTED;
    }
    Status status = Status.APPROVED;
Using switch with Enums
    enum Season {
        WINTER, SPRING, SUMMER, FALL
    }
    class Weather {
        public int getMaxTemperature(Season season) {
            return switch (season) {
                case WINTER -> 5;
                case SPRING, FALL -> 15;
                case SUMMER -> 30;
            };
        }
    }
Enum with Fields, Constructor, and Methods
    enum Direction {
        NORTH("Up"), 
        SOUTH("Down"), 
        EAST("Right"), 
        WEST("Left");
        private final String movement;
        Direction(String movement) {
            this.movement = movement;
        }
        public String getMovement() {
            return movement;
        }
    }
    public class EnumExample {
        public static void main(String[] args) {
            System.out.println(Direction.NORTH.getMovement());
        }
    }
Enum Best Practices
    Uppercase Names – Use all caps for enum constants (MONDAY, HIGH, STARTED)
    Add Fields & Methods – Enums can have constructors, fields, and behavior
    Avoid ordinal() for Logic – Enum order can change, leading to bugs
    Use switch or switch expressions – Clean and readable for branching logic
    Use Enums Instead of Strings – Prevents typos and invalid values
    Don’t Subclass Enums – Enums are implicitly final
    Override toString() if Needed – For user-friendly display values
    Use EnumSet / EnumMap – Optimized for enum keys
```
## In what scenarios should you use an EnumSet?
```
    What? – EnumSet is a specialized Set for enum types
    Why? – Much faster than HashSet when working with enums
    How? – Internally uses a bit vector for storage
    Null Allowed? – ❌ No null values allowed
    All Constants? – Use EnumSet.allOf(EnumType.class)
    Empty Set? – Use EnumSet.noneOf(EnumType.class)
    Range of Values? – Use EnumSet.range(A, C)
Example: Using EnumSet
    import java.util.EnumSet;
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, 
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public class EnumSetExample {
        public static void main(String[] args) {        
            // Use Case 1: Weekend Days
            EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
            System.out.println("Weekend: " + weekend);
            // Use Case 2: Working Days
            EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
            System.out.println("Weekdays: " + weekdays);
            // Use Case 3: All Days
            EnumSet<Day> allDays = EnumSet.allOf(Day.class);
            System.out.println("All Days: " + allDays);
            // Use Case 4: Empty Set (will add later)
            EnumSet<Day> holidays = EnumSet.noneOf(Day.class);
            holidays.add(Day.FRIDAY); // dynamically add
            System.out.println("Holidays: " + holidays);
            // Use Case 5: Removing from a set
            weekdays.remove(Day.WEDNESDAY);
            System.out.println("Working Days (No Wednesday): " + weekdays);
        }
    }
Best Practices for EnumSet
    Use EnumSet for Enums – Better than HashSet in speed and memory
    Faster Operations – add(), remove(), contains() are constant-time
    No Nulls Allowed – Inserting null throws NullPointerException
    Cleaner Code – Methods like of(), allOf(), range() make code more readable
```
## What is the purpose of using assertions in Java?
```
    What? – Assertions check conditions that must be true during development
    How? – Use assert condition; or assert condition : "message";
    Fails? – Throws AssertionError if the condition is false
    When? – Only works if assertions are enabled (-ea flag)
    Not for Production – Meant for testing, not for handling runtime errors
Example: Using assert
    public void processFile(String fileNameTxt) {        
        assert fileNameTxt.endsWith(".txt") : "Invalid file type: " + fileNameTxt;
        //Other code to process the file!
    }
Running with assertions enabled:
    java -ea AssertionExample
    Asserts - Best Practices
    Validate Assumptions – Use assertions to catch logic errors during development
    Pre/Post Conditions – Check method input/output expectations in private/internal code
    Never for User Input Validation – Don’t validate user input with assertions
    Never for Business Logic – Business rules must throw proper exceptions
    Don't Use for Security – Never rely on assertions for security-sensitive checks
    Add Messages – Use assert condition : "Helpful message" for clarity
```
## When should you use variable arguments (varargs) in a method?
```
    What? – Varargs (...) let a method take zero or more arguments
    Syntax? – Use type... name as the last parameter in the method
    Internally? – Treated as an array inside the method
    Why? – Makes method calls flexible without overloading
JDK Examples?
    String.format(String format, Object... args)
    Collections.addAll(Collection<? super T> c, T... elements)
    List.of(E... elements)
Example: Using Varargs
    public class VarargsExample {        
        public static int sum(int... numbers) {
            return Arrays.stream(numbers).sum();
        }
        public static void main(String[] args) {
            System.out.println(sum(1, 2, 3));
            System.out.println(sum(5, 10, 15, 20));
            System.out.println(sum());
        }
    }
Best Practices for Varargs
    Use When Necessary – Avoid overusing varargs; prefer specific parameters if possible
    Only One Vararg – A method can’t have more than one varargs parameter
    Always Last – Varargs must be the last parameter in the method signature
    Avoid Ambiguity – Overloaded methods with varargs can confuse the compiler
    Handle Nulls Safely – Varargs can be null; check before using
    Combine with Streams – Use functional style (Arrays.stream(...)) for clean code
```
## What are the best practices for working with date and time APIs in Java?
```
Evolution of Date and Time APIs
API	                                            Introduced-in	Issues	                                    Recommended?
java.util.Date	                                Java 1.0	    Mutable, time zone issues, bad API design	❌ No
java.util.Calendar	                            Java 1.1	    Complex, still mutable, verbose	            ❌ No
java.time(LocalDate, LocalTime, ZonedDateTime)	Java 8	        Immutable, easy to use, thread-safe	        ✅ Yes

Example: java.util.Date (Not Recommended)
    import java.util.Date;
    public class DateExample {
        public static void main(String[] args) {
            Date date = new Date();       
            // Output: Mon Mar 04 12:30:45 IST 2024
            System.out.println("Current Date: " + date);  
        }
    }
Example: Calendar (Better, but still not ideal)
    import java.util.Calendar;
    public class CalendarExample {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.MARCH, 4);
            System.out.println("Date: " + calendar.getTime());  
        }
    }
Best Practice: Use java.time API (Java 8+)
    import java.time.*;
    import java.time.format.DateTimeFormatter;
    import java.time.temporal.ChronoUnit;

    public class JavaTimeExample {
        public static void main(String[] args) {
            // 1️⃣ LocalDate – Immutable, thread-safe (unlike Date)
            LocalDate today = LocalDate.now();
            System.out.println("Today's Date: " + today);
            // 2️⃣ LocalDateTime + Formatting (no SimpleDateFormat)
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("Formatted: " + dateTime.format(formatter));
            // 3️⃣ Specific Date – Easier than Calendar
            // No month-0 confusion (Jan = 1, not 0)
            LocalDate independenceDay = LocalDate.of(1947, 8, 15);
            System.out.println("Independence Day: " + independenceDay);
            // 4️⃣ Add Days/Months – Fluent API, clear syntax
            LocalDate nextMonth = today.plusMonths(1);
            System.out.println("Next Month: " + nextMonth);
            LocalDate tenDaysLater = today.plusDays(10);
            System.out.println("10 Days Later: " + tenDaysLater);
            // 5️⃣ Subtract Time – No confusing Calendar math
            LocalDate lastYear = today.minusYears(1);
            System.out.println("Last Year: " + lastYear);
            // 6️⃣ Change Fields
            LocalDate changedYear = today.withYear(2020);
            System.out.println("Changed Year: " + changedYear);
            LocalDate firstDay = today.withDayOfMonth(1);
            System.out.println("First Day: " + firstDay);
            // 7️⃣ Compare Dates – Easier than Date.before/after
            boolean isBefore = independenceDay.isBefore(today);
            System.out.println("Is Before Today? " + isBefore);
            boolean isAfter = today.isAfter(independenceDay);
            System.out.println("Is After Independence? " + isAfter);
            // 8️⃣ Days Between – Use ChronoUnit directly
            long days = ChronoUnit.DAYS.between(independenceDay, today);
            System.out.println("Days Since 1947: " + days);
        }
    }
Advantages of java.time API:
    Immutable and thread-safe.
    Clear and concise API.
    Better formatting support (DateTimeFormatter).
Best Practices for Date and Time Handling
    Prefer java.time over Date and Calendar.
    Use DateTimeFormatter for proper formatting instead of SimpleDateFormat.
```
## What is the Use of Reflection?
```
    What? – Reflection lets you inspect and interact with code at runtime
    Used For? – Dynamic loading, calling methods, accessing fields, working with annotations
Common Uses
    Dependency injection
    Test frameworks
    Annotation processing
    JDK API Classes – Class, Method, Field, Constructor (from java.lang.reflect)
Example: Getting Class Information Using Reflection
    import java.lang.reflect.Method;
    class ReflectionExample {
        public static void main(String[] args) {
            Class<String> clazz = String.class;
            // 1️⃣ Print declared methods of String class
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("Method: " + method.getName());
            }
        }
    }

Example: Creating Objects Using Reflection
    import java.lang.reflect.Constructor;
    class Example {
        public void display() {
            System.out.println("Reflection Example");
        }
    }
    public class ReflectionConstructorExample {
        public static void main(String[] args) throws Exception {
            Class<Example> clazz = Example.class;
            // Create instance dynamically
            Constructor<Example> constructor = clazz.getDeclaredConstructor();
            Example obj = constructor.newInstance();            
            obj.display();  // Output: Reflection Example
        }
    }
Best Practices with Reflection:
    Use When Needed – Prefer reflection only for special use cases (frameworks, testing)
    Avoid in Hot Paths – Reflection is slower than direct access — not for performance-critical code
    Handle Exceptions Properly – Catch and log ClassNotFoundException, NoSuchMethodException, etc.
    Respect Security – Accessing private fields/methods may break encapsulation — use with caution
    Document Usage – Clearly explain why reflection is used in code comments
    Avoid Reflection for Business Logic – Keep it in utilities or framework-level code only
    Test Thoroughly – Reflective code is harder to debug — write strong tests to verify behavior
```
## Why are annotations used in Java?
```
    What? – Annotations are special markers that add metadata to code
JDK Examples:
    @Override – Tells the compiler you're overriding a super-class method or implementing an interface method.
    Catches typos or mismatches early.
    @Deprecated – Marks a method or class as outdated.
    Warns developers to avoid using it.
    @FunctionalInterface – Ensures the interface has only one abstract method.
    Required for lambda expressions.
    Fails at compile-time if multiple abstract methods exist in an interface.
    Marker Annotations: Annotations without parameters
    Framework Usage? – Widely used in Java, Spring, JUnit, Jakarta EE
Examples of Using Annotations
    class Parent {
        void show() {
            System.out.println("Parent class method");
        }
    }
    class Child extends Parent {
        @Override
        void show() {
            System.out.println("Child class method");
        }
        @Deprecated
        void oldMethod() {
            System.out.println("This method is deprecated");
        }
        @SuppressWarnings("unchecked")
        void warningFree() {
            // No warning due to SuppressWarnings
            List rawList = new ArrayList(); 
        }
    }
@FunctionalInterface
    interface Greeter {
        void greet(String name);
        // ❌ Uncommenting the below method 
        // would cause a compile error
        // void sayBye(); 
    }
```
## How do you define and use a custom annotation in Java?
```
    What? – Custom annotations are user-defined markers that add metadata to code
    @Retention – Controls how long the annotation is retained
    SOURCE – Discarded by compiler, used only in code (e.g., @Generated for code gen tools)
    CLASS – Kept in bytecode, ignored at runtime (e.g., @Deprecated)
    RUNTIME – Available at runtime via reflection (e.g., @Override, custom annotations)
    @Target – Controls where the annotation can be applied
    METHOD – Used on methods
    FIELD – Used on fields or variables
    TYPE – Used on classes, interfaces, enums
    PARAMETER – Used on method parameters
    CONSTRUCTOR, etc. – More specialized use cases
Creating a Custom Annotation:
    import java.lang.annotation.*;
    // Define the custom annotation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface TestAnnotation {
        String value();  // Annotation element
    }
Applying the Custom Annotation
    class Example {
        @TestAnnotation("This is a test method")
        public void myMethod() {
            System.out.println("Method executed");
        }
    }
Using Reflection to Process the Annotation
    import java.lang.reflect.Method;

    public class AnnotationProcessor {
        public static void main(String[] args) throws Exception {
            Example example = new Example();
            // Get the method
            Method method = Example.class.getMethod("myMethod");
            // Check if annotation is present
            if (method.isAnnotationPresent(TestAnnotation.class)) {
                // Retrieve the annotation
                TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
                System.out.println("Annotation Value: " + annotation.value());
                // Execute the method dynamically
                method.invoke(example);
            }
        }
    }
Creating a Simple Unit Test Framework with Annotations
    The @Test annotation is applied to test methods.
    TestRunner automatically finds and runs methods marked with @Test.
    The test description is displayed before executing each test.
        import java.lang.annotation.*;
        import java.lang.reflect.Method;

        // Define a test annotation
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface Test {
            String description() default "No description";
        }

        // Example test class
        class TestSuite {
            @Test(description = "Test for addition")
            public void testAddition() {
                System.out.println("Addition Test Passed!");
            }
            @Test(description = "Test for subtraction")
            public void testSubtraction() {
                System.out.println("Subtraction Test Passed!");
            }
        }
        // Annotation Processor
        //Runs all methods with @Test annotation
        public class TestRunner {
            public static void main(String[] args) throws Exception {
                TestSuite testSuite = new TestSuite();
                for (Method method : TestSuite.class.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Test.class)) {
                        Test test = method.getAnnotation(Test.class);
                        System.out.println("Running Test: " + test.description());
                        // Execute the test method
                        method.invoke(testSuite);
                    }
                }
            }
        }
Example Output
    Running Test: Test for addition
    Addition Test Passed!
    Running Test: Test for subtraction
    Subtraction Test Passed!
```
## What are unnamed variables and patterns, and why are they useful?
```
    Unnamed variables (_) and unnamed patterns (catch (NumberFormatException _)) help reduce clutter when a variable or exception is declared but not used.
Example 1: Using Unnamed Variable in Try-Catch
    try {
        // Invalid integer
        int n = Integer.parseInt("abc"); 
    } catch (NumberFormatException _) {  // No name needed
    //} catch (NumberFormatException ex) { // 'ex' is unused
        System.err.println("Invalid number format!");
    }
Example 2: Unnamed Pattern in Switch Expressions
    static void checkObject(Object obj) {
        switch (obj) {
            case String _ 
                -> System.out.println("It's a string.");
            case Integer _ 
                -> System.out.println("It's an integer.");
            default 
                -> System.out.println("Unknown type.");
        }
    }
Example 3: Unnamed Variable in For-Each Loops
    String[] names = {"Alice", "Bob", "Charlie"};
    //Since we don’t need to use the variable, `_` replaces it.
    for (String _ : names) {
        System.out.println("Processing...");
    }
Example 4: Unnamed Variable in Record Patterns
    record Person(String name, int age) {}
    static void printPerson(Object obj) {
        //Here, `name` is ignored, as we only need `age`.
        if (obj instanceof Person(_, int age)) {
            System.out.println("Person's age: " + age);
        }
    }
Example 5: Ignoring Unused Return Values
    static int calculate(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        _ = calculate(10, 20); // We ignore the return value
        System.out.println("Calculation done.");
    }
Advantages
    Cleaner Code – Removes unnecessary variable names when they are not used.
    Improved Readability – Makes the intent clearer by avoiding unused variables.
    Less Clutter – No warnings for unused variables, reducing distractions in IDEs.
```
## How has pattern matching evolved across recent Java versions?
```
Before Java 14 Example
    Requires explicit casting ((String) obj).
    Redundant code for type checking.
        public void process(Object obj) {
            if (obj instanceof String) {
                // Explicit casting needed
                String s = (String) obj;  
                System.out.println("Message: " + s);
            }
        }
Java 14: Simplified instanceof Check
    Eliminates explicit casting.
    Declares variable inline.
    Cleaner and safer.
        public void process(Object obj) {
            if (obj instanceof String s) {
                // No explicit cast needed
                System.out.println("Message: " + s);  
            }
        }
Java 21: Record Patterns
    Java 21 allows automatic deconstruction of records.
    Automatically extracts fields (sender, receiver, amount).
        record Transaction(String sender, String receiver, double amount) {}
        public void processTransaction(Object obj) {
            if (obj instanceof Transaction(String sender, String receiver,double amount)) {
                System.out.println("Processing transaction: " + sender + " -> " + receiver + " : ₹" + amount);
            }
        }
Java 21: Nested Record Patterns
    Nested pattern matching extracts values directly.
    Eliminates manual field access (order.customer().name()).
    More concise and readable.
        package com.in28minutes;
        record Customer(String name, String email) {}
        record Product(String name, double price) {}
        record Order(Customer customer, Product product) {}
        public class CustomerSupport {
            public static void processOrder(Object obj) {
                if (obj instanceof Order(Customer(String name, String email), 
                    Product(String prodName, double price))) {
                    System.out.println("Customer " + name + " ordered " + prodName + " for ₹" + price);
                }
            }
            public static void main(String[] args) {
                processOrder(new Order(new Customer("Ranga","Email"), new Product("Cricket Bat",100)));
            }
        }
```
## How have switch expressions improved in modern Java?
```
Java 14: Arrow Syntax (->) in switch
    No need for break statements.
    More concise and readable.
    Uses -> instead of case : syntax.
switch (day) {
    case "Monday" -> System.out.println("Start of the week");
    case "Friday" -> System.out.println("Weekend is near");
    case "Sunday" -> System.out.println("Weekend");
    default -> System.out.println("Regular day");
}
Java 14: Switch Expression with Return Values
    switch as an expression (returns a value).
        public class CustomerSupportSwitchExpression {
            public static void main(String[] args) {
                Object message = "Need help with my order";
                String response = switch (message) {
                    case String text -> "Processing text message: " + text;
                    case Integer ticketNumber -> "Processing support ticket: #" + ticketNumber;
                    case Double rating -> "Processing feedback rating: " + rating + " stars";
                    case byte[] attachment -> "Processing attachment of size: " + attachment.length;
                    default -> "Unknown message type.";
                };
                System.out.println(response);
            }
        }
Java 17: Switch Expression with Enums
Eliminates repetitive if-else logic.
    enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL
    }
    public class CustomerSupportJava17 {
        public static void main(String[] args) {       
            // Example: High-priority Ticket
            Priority priority = Priority.HIGH; 
            String response = switch (priority) {
                case LOW 
                    -> "Response within 48 hours.";
                case MEDIUM 
                    -> "Response within 24 hours.";
                case HIGH 
                    -> "Immediate response required!";
                case CRITICAL 
                    -> "Escalating to the highest level!";
            };
            System.out.println(response);
        }
    }
Java 21: Switch Expression with Record Patterns
    Pattern Matching in switch allows direct record deconstruction.
    More concise and readable code.
        sealed interface CustomerMessage permits TextMessage, Ticket, Feedback, Attachment {}
        record TextMessage(String text) implements CustomerMessage {}
        record Ticket(int ticketNumber) implements CustomerMessage {}
        record Feedback(double rating) implements CustomerMessage {}
        record Attachment(byte[] file) implements CustomerMessage {}

        public class CustomerSupportJava21 {
            public static void main(String[] args) {
                CustomerMessage message = new Ticket(1050);
                String response = switch (message) {
                    case TextMessage(String text) 
                            -> "Processing text message: " + text;
                    case Ticket(int ticketNumber) 
                            -> "Processing support ticket: #" + ticketNumber;
                    case Feedback(double rating) 
                            -> "Processing feedback rating: " + rating + " stars";
                    case Attachment(byte[] file) 
                        -> "Processing attachment of size: " + file.length;
                };
                System.out.println(response);
            }
        }
Java 21: Nested Record Patterns in Switch Expressions
    Switch expressions work seamlessly with nested records.
    Automatic deconstruction of records inside switch.
        package com.in28minutes;
        sealed interface CustomerMessage permits TextMessage, Ticket, Feedback, Attachment {}
        record TextMessage(String text) implements CustomerMessage {}
        record Ticket(int ticketNumber) implements CustomerMessage {}
        record Feedback(double rating) implements CustomerMessage {}
        record Attachment(byte[] file) implements CustomerMessage {}
        record SupportRequest(String user, CustomerMessage message) {}
        public class CustomerSupport {
            public static void main(String[] args) {
                SupportRequest request = new SupportRequest("Alice", new Feedback(4.8));
                String response = switch (request) {
                    case SupportRequest(String user, Ticket(int ticketNumber)) -> 
                        "User " + user + " has a support ticket: #" + ticketNumber;
                    case SupportRequest(String user, Feedback(double rating)) -> 
                        "User " + user + " left a rating: " + rating + " stars";
                    case SupportRequest(String user, TextMessage(String text)) -> 
                        "User " + user + " sent a message: " + text;
                    case SupportRequest(String user, Attachment(byte[] file)) -> 
                        "User " + user + " uploaded a file of size: " + file.length;
                };
                System.out.println(response);
            }
        }
📌 Java 22: when Guards in Switch Expressions
    What? Add extra conditions inside switch cases
    Why? Filter patterns without nesting if statements
    Benefit? Cleaner and more powerful control flow
Example: Using when for Additional Filtering
        record Feedback(double rating) implements CustomerMessage {}
        public class SupportWithWhen {
            public static void main(String[] args) {
                CustomerMessage message = new Feedback(2.5);
                String response = switch (message) {
                    case Feedback(double rating) when rating < 3.0 ->
                        "We're sorry to hear that. Support will contact you.";
                    case Feedback(double rating) ->
                        "Thanks for your positive feedback!";
                    default ->
                        "Unhandled message type.";
                };
                System.out.println(response);
            }
        }
```