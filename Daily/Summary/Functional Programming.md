```
🔹 Basic Questions

1. What is functional programming in Java?
    A programming style where computation is done using functions, avoiding shared state and mutable data. Java supports it using lambdas, streams, and functional interfaces (introduced in Java 8).

2. What is a functional interface?
    An interface with exactly one abstract method.
Example:
    @FunctionalInterface
    interface MyFunc {
        int apply(int a);
    }

3. What are lambda expressions?
    Anonymous functions used to implement functional interfaces.
    (a, b) -> a + b

4. Difference between lambda expression and method reference?
Lambda:
    x -> System.out.println(x)
Method reference:
    System.out::println
    Method references are shorter and more readable.

5. What are the types of functional interfaces in Java?
    Function<T, R> → takes input, returns output
    Predicate<T> → returns boolean
    Consumer<T> → takes input, no return
    Supplier<T> → no input, returns value

🔹 Intermediate Questions

6. What is the Streams API?
    A way to process collections in a functional and declarative style.

7. Difference between map() and flatMap()?
    map() → transforms each element
    flatMap() → flattens nested structures
    Example:
    List<List<String>> list = ...
    list.stream().flatMap(Collection::stream);

8. What is the difference between filter() and map()?
    filter() → selects elements
    map() → transforms elements

9. What is lazy evaluation in streams?
    Stream operations are executed only when a terminal operation is called.

10. What are intermediate and terminal operations?
    Intermediate → filter(), map() (lazy)
    Terminal → collect(), forEach() (trigger execution)

11. What is immutability and why is it important?
    Objects that cannot be changed after creation.
    Important because it avoids bugs in concurrent programs.

12. What is a pure function?
    A function that:
    Has no side effects
    Returns same output for same input

🔹 Advanced Questions

13. What is the difference between forEach() and peek()?
    forEach() → terminal operation
    peek() → intermediate, mainly for debugging

14. What is parallel stream?
    A stream that runs operations in multiple threads.
    list.parallelStream()

15. When should you use parallel streams?
    Use when:
        Large data sets
        Independent operations
    Avoid when:
        Shared mutable state
        Small datasets (overhead)

16. What is the difference between findFirst() and findAny()?
    findFirst() → deterministic
    findAny() → faster in parallel streams, not guaranteed order

17. What is Optional in Java?
    Container object to avoid null checks.
    Optional<String> name = Optional.of("John");

18. Difference between orElse() and orElseGet()?
    orElse() → always executes
    orElseGet() → executes only if value is absent

19. What is a higher-order function?
    A function that:
    Takes another function as input OR
    Returns a function

20. What are side effects in functional programming?
    Changes in external state (e.g., modifying variables, I/O).
    Functional programming tries to avoid them.

🔹 Coding-Based Questions (Very Common)

21. Find even numbers from a list
    list.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());

22. Count frequency of elements
    Map<String, Long> freq =
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

23. Find duplicate elements
    Set<Integer> seen = new HashSet<>();
    list.stream()
        .filter(n -> !seen.add(n))
    .forEach(System.out::println);

24. Sort a list using lambda
    list.sort((a, b) -> a - b);

25. Find max element
    int max = list.stream().max(Integer::compare).get();

🔹 Trick / Conceptual Questions

26. Can we have multiple abstract methods in a functional interface?
    ❌ No (only one allowed)

27. Can a functional interface have default methods?
    ✅ Yes

28. Are streams reusable?
    ❌ No (once consumed, cannot reuse)

29. Difference between Collection and Stream?
Collection	    Stream
Stores data	    Processes data
Eager	        Lazy

30. Why avoid stateful lambdas?
    Because they can cause thread-safety issues in parallel streams.

🔹 Pro Tip for Interviews
Interviewers often expect:
    Clear concept explanation
    Small code example
    Awareness of performance & pitfalls

| Structure | Can stream directly?  | How                       |
| --------- | --------------------  | ------------------------- |
| List      | ✅ Yes                | `list.stream()`           |
| Set       | ✅ Yes                | `set.stream()`            |
| Queue     | ✅ Yes                | `queue.stream()`          |
| Map       | ❌ No                 | `map.entrySet().stream()` |

```
# Operations
```
🔹 1. Stream Creation (How you start a stream)

These methods create a stream from data sources:

✔ From Collection
    list.stream()
    set.stream()
✔ From values
    Stream.of(1, 2, 3)
✔ From array
    Arrays.stream(arr)

🔹 2. Intermediate Operations (Return Stream)

👉 These are lazy operations (they don’t run immediately)

🔸 filter()
    👉 Selects elements based on condition
    list.stream().filter(n -> n % 2 == 0)
    ✔ Keeps only matching elements
    ✔ Example: even numbers, primes, etc.

🔸 map()
    👉 Transforms each element
    list.stream().map(n -> n * 2)
    ✔ 1 input → 1 output
    ✔ Used for square, cube, uppercase, conversion

🔸 flatMap()
    👉 Flattens nested structures
    List<List<Integer>> list;
    list.stream().flatMap(List::stream)
    ✔ Converts List of Lists → single stream
    ✔ Used in complex data structures

🔸 sorted()
    👉 Sorts elements
    list.stream().sorted()
    list.stream().sorted((a, b) -> b - a)
    ✔ Natural or custom sorting

🔸 distinct()
    👉 Removes duplicates
    list.stream().distinct()
    ✔ Keeps only unique values

🔸 limit(n)
    👉 Takes first n elements
    list.stream().limit(3)

🔸 skip(n)
    👉 Skips first n elements
    list.stream().skip(2)

🔸 peek()
    👉 Debugging purpose (see values in pipeline)
    list.stream().peek(System.out::println)
    ✔ Does not modify data
    ✔ Used for debugging only

🔹 3. Terminal Operations (End the stream)
👉 These trigger execution

🔸 forEach()
    👉 Prints or consumes elements
    list.stream().forEach(System.out::println);

🔸 collect()
    👉 Converts stream to collection
    list.stream().collect(Collectors.toList());
    ✔ Most important terminal operation

🔸 reduce()
    👉 Combines elements into one result
    list.stream().reduce(0, (a, b) -> a + b);
    ✔ Sum, product, max, min logic

🔸 count()
    👉 Counts elements
    long count = list.stream().count();

🔸 min() / max()
    👉 Finds smallest / largest
    list.stream().max(Integer::compareTo)

🔸 anyMatch()
    👉 True if ANY element matches condition
    list.stream().anyMatch(n -> n > 10)

🔸 allMatch()
    👉 True if ALL elements match
    list.stream().allMatch(n -> n > 0)

🔸 noneMatch()
    👉 True if NO element matches
    list.stream().noneMatch(n -> n < 0)

🔸 findFirst()
    👉 Gets first element
    list.stream().findFirst()

🔸 findAny()
    👉 Gets any element (useful in parallel streams)
    list.stream().findAny()

🔹 4. Numeric Streams (Special Streams)

Used for performance with numbers:
    ✔ IntStream / LongStream / DoubleStream
    IntStream.range(1, 10)
    IntStream.rangeClosed(1, 10)
Useful methods:
    sum()
    average()
    max()
    min()

🔹 5. Collectors (Used with collect())

Very important utility class:
🔸 toList()
    Collectors.toList()

🔸 toSet()
    Collectors.toSet()

🔸 joining()
    Collectors.joining(", ")

🔸 groupingBy()
    Collectors.groupingBy(n -> n % 2)

🔸 counting()
    Collectors.counting()

🔥 Simple Flow Example
    list.stream()
    .filter(n -> n % 2 == 0)     // intermediate
    .map(n -> n * n)            // intermediate
    .sorted()                   // intermediate
    .collect(Collectors.toList()); // terminal

🔹 FINAL SUMMARY

✔ Intermediate (build pipeline)
    filter
    map
    flatMap
    sorted
    distinct
    limit
    skip
    peek
✔ Terminal (execute pipeline)
    forEach
    collect
    reduce
    count
    min / max
    anyMatch / allMatch / noneMatch
    findFirst / findAny

🔥 Key Idea (very important)
    Streams = data pipeline
    Intermediate = transformation steps
    Terminal = final result execution
```
```
🔹 1. Advanced Mapping Operations

🔸 mapToInt / mapToLong / mapToDouble
    👉 Converts to primitive streams (faster + numeric operations)
    int sum = list.stream()
            .mapToInt(Integer::intValue)
            .sum();
    ✔ Used for sum, average, min, max efficiently

🔸 boxed()
    👉 Converts primitive stream back to object stream
    List<Integer> list = IntStream.range(1, 10)
            .boxed()
            .collect(Collectors.toList());

🔹 2. Advanced Filtering Operations

🔸 takeWhile()
    👉 Takes elements until condition becomes false
    list.stream()
        .takeWhile(n -> n < 50)
    ✔ Stops as soon as condition fails

🔸 dropWhile()
    👉 Skips elements until condition becomes false
    list.stream()
        .dropWhile(n -> n < 50)

🔹 3. Stream Combination

🔸 concat()
    👉 Combines two streams
    Stream<Integer> s1 = Stream.of(1, 2);
    Stream<Integer> s2 = Stream.of(3, 4);
    Stream.concat(s1, s2)
        .forEach(System.out::println);

🔹 4. Advanced Collectors

🔸 partitioningBy()
    👉 Splits into true/false groups
    Map<Boolean, List<Integer>> map =
        list.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    ✔ Output: even vs odd

🔸 groupingBy()
    👉 Groups elements by condition
    Map<Integer, List<Integer>> map =
        list.stream()
            .collect(Collectors.groupingBy(n -> n % 3));
    ✔ Groups by remainder

🔸 mapping() (inside collectors)
    👉 Transform while grouping
    list.stream()
        .collect(Collectors.groupingBy(
            n -> n % 2,
            Collectors.mapping(n -> n * 2, Collectors.toList())
        ));

🔸 joining()
    👉 Works only for Strings
    words.stream()
        .collect(Collectors.joining(", "))

🔸 summarizingInt()
    👉 Gives full stats in one go
    IntSummaryStatistics stats =
        list.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
    ✔ Gives:
        count
        sum
        min
        max
        average

🔹 5. Optional (Important in Streams)
    Streams often return Optional values:
    🔸 Optional usage
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        Safe handling:
        max.ifPresent(System.out::println);

🔹 6. Parallel Streams
    👉 Runs operations in multiple threads
    list.parallelStream()
        .forEach(System.out::println);
    ✔ Faster for large datasets
    ⚠ Not always ordered

🔹 7. peek() (real use case)
    list.stream()
    .peek(n -> System.out.println("Before filter: " + n))
    .filter(n -> n % 2 == 0)
    .peek(n -> System.out.println("After filter: " + n))
    .collect(Collectors.toList());

✔ Used for debugging pipeline

🔥 FINAL MAP OF ALL STREAM OPERATIONS

✔ Intermediate
    filter
    map
    flatMap
    sorted
    distinct
    limit
    skip
    peek
    takeWhile
    dropWhile

✔ Terminal
    forEach
    collect
    reduce
    count
    min / max
    findFirst / findAny
    anyMatch / allMatch / noneMatch
    toArray

✔ Advanced Collectors
    groupingBy
    partitioningBy
    mapping
    joining
    summarizingInt

✔ Numeric + Utility
    mapToInt / mapToLong / mapToDouble
    boxed
    summaryStatistics
```
# Interview Guide

## Functional Programming vs Imperative Style
```
What is Imperative Style?
    Uses step-by-step logic to solve a problem.
    Focuses on how to achieve the result.
What is Functional Programming?
    Uses declarative code instead of loops.
    Focuses on what needs to be done, not how.
Example 1: Imperative Code (Using Loops)
    private static int addListImperative(List<Integer> numbers) {
        int sum = 0;  
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
Example 2: Functional Programming (Using Streams)
    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

Feature	            Imperative Style	            Functional Programming
Style	            Step-by-step logic	            Declarative (focus on what, not how)
Looping	            Uses for/while loops	        Uses Streams
State Management	Uses mutable variables (sum)	Avoids mutation
Code Readability	More verbose	                More concise & readable
```
## Core Concepts of Functional Programming
```
courses.stream().map(course -> course.toUpperCase())  
    .forEach(System.out::println);

1. Stream
    What? A sequence of elements that supports functional-style operations.
    Why? Allows processing of data in a declarative and efficient way.
    Example:
        courses.stream() creates a stream from the list of courses.
        This stream enables pipeline processing without modifying the original list.
2. Lambda Function
        What? An anonymous function that represents a short piece of code.
        Why? Makes code concise and readable.
    Example:
        course -> course.toUpperCase() is a lambda function that converts each course name to uppercase.
        It eliminates the need for writing a separate method.
3. Method Reference
    What? A shorthand for calling a method using ClassName::methodName or object::methodName.
    Why? Further simplifies lambda expressions when an existing method can be used directly.
    Example:
        System.out::println is a method reference that replaces x -> System.out.println(x).
```
## What are different ways to create Streams in Java?
```
1. From Collections (Lists, Sets, Maps)
    What? Convert collections into streams.
    Why? Allows functional operations on lists, sets, and maps.
    How? Use .stream()
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    Stream<Integer> numberStream = numbers.stream();
    numberStream.forEach(System.out::println);
//{Java=100, Python=80}
Map<String, Integer> courses = Map.of("Java", 100, "Python", 80);
//["Java", "Python"]
Stream<String> keyStream = courses.keySet().stream();
//[100, 80]
Stream<Integer> valueStream = courses.values().stream();
//{Java=100, Python=80}
Stream<Map.Entry<String, Integer>> entryStream = courses.entrySet().stream();

2. Using Stream.of()
    What? Create a stream from individual elements.
    Why? Useful for small, fixed data sets.
    How? Use Stream.of().
    Stream<String> stream = Stream.of("Apple", "Banana", "Cherry");
    stream.forEach(System.out::println);

3. Using Arrays.stream()
    What? Convert primitive arrays into streams.
    How? Use Arrays.stream().
    int[] numbers = {10, 20, 30, 40, 50};
    IntStream intStream = Arrays.stream(numbers);
    intStream.forEach(System.out::println);

4. Using Stream.builder()
    What? Manually build a stream.
    Why? Allows adding elements dynamically.
    How? Use Stream.builder().
    Stream.Builder<String> builder = Stream.builder();
    builder.add("Java").add("Python").add("JavaScript");
    Stream<String> stream = builder.build();
    stream.forEach(System.out::println);

5. Using Stream.generate()
    What? Create an stream of generated values.
    Why? Useful for lazy evaluation or dynamic data.
    How? Use Stream.generate().
    Stream<Double> randomNumbers 
            = Stream.generate(Math::random).limit(5);
    randomNumbers.forEach(System.out::println);

6. Using Stream.iterate()
    What? Create a stream by applying a function.
    Why? Useful for sequences (e.g., even numbers).
    How? Use Stream.iterate().
    Stream<Integer> evenNumbers 
            = Stream.iterate(0, n -> n + 2).limit(5);
    evenNumbers.forEach(System.out::println);

7. Using Files (Files.lines())
    What? Read a file as a stream of lines.
    Why? Helps process large files efficiently.
    How? Use Files.lines().
    Stream<String> fileStream  
            = Files.lines(Paths.get("file.txt"));
    fileStream.forEach(System.out::println);

8. Using IntStream.range()
    What? Create a stream of numbers within a range.
    Why? Useful for generating sequences.
    How? Use IntStream.range()
    // Output: 1234
    IntStream.range(1, 5).forEach(System.out::print);
    // Output: 12345
    IntStream.rangeClosed(1, 5).forEach(System.out::print); 

Comparison Table

Method	                Use Case
collection.stream()	    Convert List, Set, Map to a stream
Stream.of()	            Create a stream from values
Arrays.stream()	        Efficient for primitive arrays
Stream.builder()	    Manually construct a stream
Stream.generate()	    Infinite stream using random values
Stream.iterate()	    Infinite stream using a pattern
Files.lines()	        Stream file lines
IntStream.range()	    Number range stream
```
## What operations can you apply to a Java Stream?
```
1. Intermediate Operations
    What? Transform or filter elements and return a new stream.
    Lazy Execution: These operations do not execute until a terminal operation is called.
Operation	            Purpose	                                                    Example
filter()	            Retains elements that satisfy a condition.	                numbers.stream().filter(n -> n % 2 == 0);
map()	                Transforms each element in the stream.	                courses.stream().map(course -> course.length());
distinct()	            Removes duplicate elements.	                                    numbers.stream().distinct();
sorted()	            Sorts elements in natural or custom order.	                    courses.stream().sorted();
limit(n)	            Takes only the first n elements.	                            numbers.stream().limit(3);
skip(n)	                Skips the first n elements.	                                    numbers.stream().skip(2);
takeWhile(predicate)    Takes elements while condition is true, stops at 1st failure.	numbers.stream().takeWhile(n -> n < 10);
dropWhile(predicate)	Drops elements while condition is true, then takes the rest.	numbers.stream().dropWhile(n -> n < 10);

2. Terminal Operations
    What? Consumes the stream and produces a result.
    Trigger Execution: The stream is processed when a terminal operation is called.
Operation	Purpose	                                            Example
forEach()	Iterates over each element and performs an action.	numbers.stream(). forEach(System.out::println);
collect()	Gathers elements into collection(List, Set, Map).	List<Integer> squared = numbers.stream().map(n->n*n).collect(Collectors.toList());
reduce()	Combines elements to produce a single result.	    int sum = numbers.stream().reduce(0, Integer::sum);
count()	    Returns the number of elements in the stream.	    long count = numbers.stream().count();
findFirst()	Retrieves the first element of the stream.	        Optional<Integer> first = numbers.stream().findFirst();
findAny()	Retrieves any element (non-deterministic).	        Optional<Integer> any = numbers.stream().findAny();
anyMatch()	Returns true if any element matches the condition.	numbers.stream().anyMatch(n -> n > 10);
allMatch()	Returns true if all elements match the condition.	numbers.stream().allMatch(n -> n > 0);
noneMatch()	Returns true if no element matches the condition.	numbers.stream().noneMatch(n -> n < 0);
```
## What should you keep in mind when working with Streams?
```
1. Streams Do Not Store Data
    What? Streams process data on the fly without storing it.
    Why? This makes them memory efficient, especially for large datasets.
Example:
    Stream<Integer> numberStream = List.of(1, 2, 3, 4, 5).stream();

2. Streams Are Lazy
    What? Intermediate operations (filter, map, etc.) are not executed immediately.
    Why? Streams only process data when a terminal operation (e.g., forEach, collect, reduce) is called.
Example:
    List.of(1, 2, 3, 4, 5).stream().map(n -> {System.out.println("Mapping: " + n);
        return n * 2; 
        }); // No output because there is no terminal operation
    Intermediate operations (like filter() and map()) are lazy.
    NOT executed immediately when encountered
    Instead, Java "chains" these operations and waits for a terminal operation (like findFirst()) to trigger their execution.

3. Streams Are Immutable
    What? Stream operations do not modify the original collection.
    Why? This ensures functional purity and avoids side effects.
Example:
    List<Integer> numbers = List.of(1, 2, 3);
    numbers.stream().map(n -> n * 2); // Original list remains unchanged

4. Streams Cannot Be Reused
    What? A stream is consumed once a terminal operation is called.
    Why? You need to create a new stream if you need to process the data again.
Example:
    Stream<Integer> stream = numbers.stream();
    // Works
    stream.forEach(System.out::println); 
    // ❌ ERROR: Stream already consumed!
    stream.forEach(System.out::println);
```
## Can you provide some examples of Lambda Functions?
```
Lambda expressions are anonymous functions that simplify writing code by reducing boilerplate.

Syntax of Lambda Functions
    Parameters: The input to the function.
    Arrow (->): Separates parameters from the function body.
    Body: Contains the logic of the function.
    (parameters) -> { body }

Filtering Even Numbers Using Lambda
    numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);

Mapping Course Names to Uppercase
    courses.stream().map(course -> course.toUpperCase()).forEach(System.out::println);

Sorting Courses by Length of Name
    courses.stream().sorted((c1, c2) -> c1.length() - c2.length()).forEach(System.out::println);

Using UnaryOperator to Triple a Number
    UnaryOperator<Integer> triple = x -> x * 3;
    System.out.println(triple.apply(10)); // Output: 30
```
## When should you use Method References instead of Lambda Functions?
```
    Method references are shortcuts for writing lambda expressions that call an existing method. They use the syntax ClassName::methodName or object::methodName.
📌 1. Calling a Static Method
    When? When an existing static method can be directly referenced without modifications.
    Why? It improves readability and eliminates redundant lambda expressions.
Example 1: Java Utility Method
Using Method Reference
    courses.stream().forEach(System.out::println);
Equivalent Lambda Expression
    courses.stream().forEach(course -> System.out.println(course));

Example 2: Custom Utility Method
Using Method Reference
    numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
Equivalent Lambda Expression
    numbers.stream().filter(number -> FP01Functional.isEven(number)).forEach(number -> System.out.println(number));

📌 2. Calling an Instance Method
    instance method on each element.
Using Method Reference
    courses.stream().map(String::toUpperCase).forEach(System.out::println);
Equivalent Lambda Expression
    courses.stream().map(course -> course.toUpperCase()).forEach(course -> System.out.println(course));

📌 3. When creating new objects - Constructor Reference
    When? When creating new objects inside a stream.
Using Constructor Reference
    Supplier<String> stringSupplier = String::new;
Equivalent Lambda Expression
    Supplier<String> stringSupplier = () -> new String();
```
## What are Functional Interfaces? Provide some examples.
```
    Core component of Java's functional programming approach
    Contains exactly one abstract method
    Allow passing behavior as an argument using lambda expressions
Examples:
Consumer processes an input.
    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }
    Consumer<Integer> printOdd = number -> {
        if (number % 2 != 0) {
            System.out.println(number);
        }
    };
    //What happens in the background?
    public class PrintOdd implements Consumer<Integer> {
        @Override
        public void accept(Integer number) {
            if (number % 2 != 0) {
                System.out.println(number);
            }
        }

    }

Function transforms data and returns the result.
    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }
    Function<Integer, Integer> squareFunction = number -> number * number;
    //What happens in the background?
    public class SquareFunction 
            implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer number) {
            return number * number;
        }
    }
    Predicate tests a condition.
    @FunctionalInterface
    public interface Predicate<T> {
    boolean test(T t);
    }
    Predicate<Integer> isEven = number -> number % 2 == 0;
    //What happens in the background?
    public class IsEvenPredicate implements Predicate<Integer> {
        @Override
        public boolean test(Integer number) {
            return number % 2 == 0;
        }
    }

BiFunction combines two inputs into a result.
    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }
    BiFunction<Integer, Integer, Integer> maxFunction = (x, y) -> x > y ? x : y;
    //What happens in the background?
    public class MaxFunction implements BiFunction<Integer, Integer, Integer> {
        @Override
        public Integer apply(Integer x, Integer y) {
            return x > y ? x : y;
        }
    }
```
## What are some key Functional Interfaces, and how do they work?
```
1. Predicate (Conditional Testing)
    Purpose: Tests a condition on input and returns a boolean.
Example: Checking if a number is even.
Using Lambda (Preferred)
    Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
Equivalent Anonymous Class
    Predicate<Integer> isEvenPredicate2 = new Predicate<>() {
        @Override
        public boolean test(Integer x) {
            return x % 2 == 0;
        }
    };
Usage in Streams
    numbers.stream().filter(isEvenPredicate).forEach(System.out::println);

2. Function (Mapping Input to Output)
    Purpose: Accepts one argument and returns a transformed value.
Example: Squaring a number.
Using Lambda (Preferred)
    Function<Integer, Integer> square = x -> x * x;
    Equivalent Anonymous Class
    Function<Integer, Integer> square = new Function<>() {
        @Override
        public Integer apply(Integer x) {
            return x * x;
        }
    };
Usage in Streams
    numbers.stream().map(squareFunction).forEach(System.out::println);

3. Consumer (Processing Without Return)
    Purpose: Accepts an input but does not return anything.
Example: Printing values.
Using Lambda (Preferred)
    Consumer<Integer> sysoutConsumer = System.out::println;
Equivalent Anonymous Class
Consumer<Integer> sysoutConsumer2 = new Consumer<>() {
    @Override
    public void accept(Integer x) {
        System.out.println(x);
    }
};
Usage in Streams
    numbers.stream().forEach(sysoutConsumer);

4. BinaryOperator (Two Inputs, Same Type)
    Purpose: Takes two arguments and returns a result of the same type.
Example: Summing two numbers.
Using Lambda
    BinaryOperator<Integer> sum = (a, b) -> a + b;
Using Method Reference
    BinaryOperator<Integer> sum = Integer::sum;
Equivalent Anonymous Class
    BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<>() {
    @Override
    public Integer apply(Integer a, Integer b) {
        return Integer.sum(a, b);
    }
};
Usage in Reduce Operation
    int sum = numbers.stream().reduce(0, sumBinaryOperator);
    System.out.println(sum);

5. Supplier (Generating Values Without Input)
    Purpose: Provides a value without any input.
Example: Returning a random number.
Using Lambda (Preferred)
    Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt(100);
Equivalent Anonymous Class
    Supplier<Integer> randomIntegerSupplier2 = new Supplier<>() {
        @Override
        public Integer get() {
            return new Random().nextInt(100);
        }
    };
Usage
    System.out.println(randomIntegerSupplier.get());

6. UnaryOperator (Single Input, Same Type)
    Purpose: Takes one argument and returns a result of the same type.
Example: Tripling a number.
Using Lambda (Preferred)
    UnaryOperator<Integer> tripleOperator = x -> 3 * x;
Equivalent Anonymous Class
    UnaryOperator<Integer> tripleOperator2 = new UnaryOperator<>() {
        @Override
        public Integer apply(Integer x) {
            return 3 * x;
        }
    };
Usage in Streams
    numbers.stream().map(tripleOperator).forEach(System.out::println);

7. BiPredicate (Conditional Testing with Two Inputs)
    Purpose: Tests two inputs and returns a boolean.
Example: Checking if two numbers are equal.
Using Lambda (Preferred)
    BiPredicate<Integer, Integer> isEqual = (a, b) -> a.equals(b);
Equivalent Anonymous Class
    BiPredicate<Integer, Integer> isEqual2 = new BiPredicate<>() {
        @Override
        public boolean test(Integer a, Integer b) {
            return a.equals(b);
        }
    };
Usage
    System.out.println(isEqual.test(5, 5)); // Output: true

8. BiFunction (Two Inputs, One Output)
    Purpose: Accepts two inputs and returns one output.
Example: Concatenating strings.
Using Lambda (Preferred)
    BiFunction<String, String, String> concat = (a, b) -> a + " " + b;
Equivalent Anonymous Class
    BiFunction<String, String, String> concat2 = new BiFunction<>() {
    @Override
    public String apply(String a, String b) {
        return a + " " + b;
    }
    };
Usage
    // Output: Hello World
    System.out.println(concat.apply("Hello", "World")); 

9. BiConsumer (Processing Two Inputs Without Return)
    Purpose: Accepts two inputs but does not return anything.
Example: Printing a key-value pair.
Using Lambda (Preferred)
    BiConsumer<String, Integer> printKeyValue = (key, value) -> System.out.println(key + ": " + value);
Equivalent Anonymous Class
    BiConsumer<String, Integer> printKeyValue2 = new BiConsumer<>() {
        @Override
        public void accept(String key, Integer value) {
            System.out.println(key + ": " + value);
        }
    };
Usage
    printKeyValue.accept("Java", 8); // Output: Java: 8

Summary

Functional Interface	Purpose	                                Example Lambda
Predicate	            Returns true or false	                x -> x % 2 == 0
Function<T, R>	        Maps input T to output R	            x -> x * x
Consumer	            Processes input T without return	    System.out::println
BinaryOperator	        Takes two T inputs, returns T	        (a, b) -> a + b
Supplier	            Generates a T value	                    () -> new Random().nextInt(100)
UnaryOperator	        Takes T, returns T	                    x -> x * 3
BiPredicate<T, U>	    Tests two inputs, returns boolean	    (a, b) -> a.equals(b)
BiFunction<T, U, R>	    Takes two inputs, returns R	            (a, b) -> a + " " + b
BiConsumer<T, U>	    Processes two inputs without return	    (k, v) -> System.out.println(k + v)
```
## Why were Primitive Functional Interfaces introduced in Java?
```
Overview
    What? Special interfaces for primitive data types like int, double, long.
    Why? Avoids boxing/unboxing overhead, making code faster and memory-efficient.
Example: Use IntBinaryOperator instead of BinaryOperator<Integer>.
Before (Less Efficient)
    BinaryOperator<Integer> sum = (x, y) -> x + y;
After (Better Performance)
    IntBinaryOperator sum = (x, y) -> x + y;

Key Benefits
    Faster Execution: No need to wrap/unwrap primitive values.
    Less Memory Usage: No Integer, just int!
    Cleaner Code: Works directly with primitives, reducing complexity.
Other Primitive Interfaces

Interface	        Purpose	                Example Type
IntPredicate	    Checks conditions	    int -> boolean
IntFunction<R>	    Maps int to result	    int -> R
IntConsumer	        Accepts int, no return	int -> void
IntBinaryOperator	Operates on two int	    (int, int) -> int
Other Examples: LongPredicate, LongFunction, LongConsumer, DoublePredicate, DoubleFunction, DoubleConsumer and a lot of others!
```
## When Do You Use Collectors.groupingBy?
```
    What? Groups elements of a stream into a Map based on a key.
    Why? Simplifies grouping, counting, and aggregating data in Java Streams.
public record Course(
    String name, String category, 
    int reviewScore, int students) {}
List<Course> courses = List.of(
        new Course("AWS", "Cloud", 95, 200000),
        new Course("Azure", "Cloud", 90, 150000),
        new Course("Docker", "Cloud", 85, 180000),
        new Course("Kubernetes", "Cloud", 88, 170000),
        new Course("Spring", "Framework", 97, 220000),
        new Course("Spring Boot", "Framework", 93, 210000),
        new Course("Microservices", "Microservices", 98, 250000),
        new Course("FullStack", "FullStack", 96, 230000)
    );
Group Courses by Category
    Map<String, List<Course>> coursesByCategory = courses.stream().collect(Collectors.groupingBy(Course::category));
    System.out.println(coursesByCategory);
Output:
    //Simplified only to show course name
    {Cloud=[AWS, Azure, Docker, Kubernetes], 
    Framework=[Spring, Spring Boot], 
    Microservices=[Microservices], 
    FullStack=[FullStack]}

Count Courses in Each Category
    Map<String, Long> courseCountByCategory = courses.stream()
                .collect(Collectors.groupingBy(Course::category, Collectors.counting()));
    System.out.println(courseCountByCategory);
Output:
{Cloud=4, Framework=2, Microservices=1, FullStack=1}

Find Highest Rated Course in Each Category
    Map<String, Optional<Course>> highestRatedCourseByCategory = courses.stream()
        .collect(Collectors.groupingBy(
            Course::category, 
            Collectors.maxBy(Comparator.comparing(Course::reviewScore))
        ));
    System.out.println(highestRatedCourseByCategory);
Output:
    {Cloud=Optional[AWS], 
    Framework=Optional[Spring], 
    Microservices=Optional[Microservices], 
    FullStack=Optional[FullStack]}

Get List of Course Names per Category
    Map<String, List<String>> courseNamesByCategory = courses.stream()
        .collect(Collectors.groupingBy(Course::category,
            Collectors.mapping(Course::name, Collectors.toList())
    ));
    System.out.println(courseNamesByCategory);
Output:
    {Cloud=[AWS, Azure, Docker, Kubernetes], 
    Framework=[Spring, Spring Boot], 
    Microservices=[Microservices], 
    FullStack=[FullStack]}
```
## How does the Optional class help handle missing values?
```
    What? A container that may or may not hold a value.
    Why? Avoids NullPointerException by explicitly handling missing values.
Example:
    // Safe handling of null
    Optional<String> optional = Optional.ofNullable(getValueFromDatabase()); 
    optional.ifPresent(System.out::println);

Method	                    Purpose	                                    Example Usage
Optional.of(value)	        Creates an Optional with a non-null value	Optional.of("Hello")
Optional.ofNullable(value)	Creates an Optional (null safe)	            Optional.ofNullable("Hello")
Optional.empty()	        Creates an empty Optional	                Optional.empty()
isPresent()	                Checks if a value is present	            opt.isPresent()
ifPresent(Consumer)	        Executes code if value exists	            opt.ifPresent(System.out::println)
orElse(defaultValue)	    Returns value or default if empty	        opt.orElse("Default")
orElseGet(Supplier)	        Returns value or calls supplier function	opt.orElseGet(() -> "Generated")
orElseThrow()	            Throws an exception if value is missing	opt.orElseThrow(() -> new RuntimeException("No Value"))
```
## How do Parallel Streams enhance performance in Java?
```
    Modern multi-core processors: Today's computers have multiple cores.
    They can run different tasks at the same time.
    Traditional Programming: Old-style coding uses loops and shared variables.
    Why is this a problem? Many threads need to share the same data (e.g., a sum variable).
    This makes parallel execution hard.
//Traditional
    int sum = 0;  
    for (int number : numbers) {
        sum += number;
    }
    return sum;

Functional Programming: Uses stateless streams.
    Why is this good? No shared data → Easy to run in parallel.
    //Functional
    return numbers.stream().reduce(0, Integer::sum);

How does Java parallelize streams?
    parallel() tells Java to use multiple cores.
    Java splits the stream into smaller parts.
    Each part runs on a different core.
    Finally, Java combines all results.
// Sequential
    long sum = LongStream.range(0, 1000000000L).sum();

// Parallel on Existing Streams
long parallelSum = LongStream.range(0, 1000000000L).parallel().sum();

How Does It Work?
    Creates a Stream of Longs → LongStream.range(0, 1000000000L) generates numbers from 0 to 999,999,999.
    Enables Parallel Processing → .parallel() splits the range into chunks and processes them across multiple cores.
    Calculates the Sum Efficiently → .sum() combines results from all threads.
parallel() vs parallelStream()
Feature	        parallel()	                                parallelStream()
Applied On	    Any existing stream	                        Collections (List, Set, etc.)
Purpose	        Converts a sequential stream to parallel	Directly creates a parallel stream
When to Use?	When you already have a stream	            When starting from a collection
Example	        list.stream().parallel()	                list.parallelStream()

Example - Using parallel()
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.stream().parallel().forEach(System.out::println);
Example - Using parallelStream()
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.parallelStream().forEach(System.out::println);
```
## In what ways does Functional Programming simplify Java code?
```
1. Creating a Thread
Before FP:
    // ❌ Traditional way (Verbose)
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread running...");
        }
    });
    thread1.start();

With FP (Lambda Expression): Shorter and more readable.
    // ✅ Functional way (Lambda)
    Thread thread2 = new Thread(
            () -> System.out.println("Thread running..."));
    thread2.start();

2. Creating a Comparator
Before FP:
    import java.util.*;
    List<String> names = Arrays.asList("John", "Alice", "Bob");
    // ❌ Traditional way
    Collections.sort(names, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    });

With FP: Uses a lambda function, reducing code complexity.
    // ✅ Functional way (Lambda)
    names.sort((s1, s2) -> s1.compareTo(s2));

3. Listing Files in a Directory
Before FP: Uses a for-loop.
    import java.nio.file.*;

    Path path = Paths.get(".");

    // ❌ Traditional way
    File[] files = new File(".").listFiles();
    for (File file : files) {
        System.out.println(file.getName());
    }

With FP: Uses Files.list() with method reference.
    // ✅ Functional way (Streams)
    Files.list(path).forEach(System.out::println);

4. Filtering & Transforming a List
Before FP: Uses loops and conditionals.
    List<String> words = Arrays.asList("apple", "banana", "cherry");
    // ❌ Traditional way
    List<String> ucWords = new ArrayList<>();
    for (String word : words) {
        if (word.length() > 5) {
            uppercaseWords.add(word.toUpperCase());
        }
    }

With FP: Uses stream().filter().map().
    // ✅ Functional way (Streams)
    List<String> ucWordsFp = words.stream().filter(word -> word.length() > 5).map(String::toUpperCase).toList();
```
## How do Higher-Order Functions, Behavior Parameterization, and First-Class Functions differ?
```
Quick Comparison

Concept	                        What It Is?
Higher-Order Functions	        Function that returns or takes a function as a parameter
Behavior Parameterization	    Passing behavior (a function) dynamically (as a parameter)
Functions as 1st-Class Citizens	Treats functions like values (Store function in variable, Pass function to method, Return function)

Example: Returning a Function
    This function returns a predicate based on a cutoff value.
    This allows dynamic filtering without hardcoding conditions.
    The returned predicate is then applied to a stream.
public static Predicate<Course> 
        createPredicate(int cutoff) {
    return course -> 
           course.getReviewScore() > cutoff;
}
// Usage
Predicate<Course> highScore = createPredicate(95);

List<Course> filtered = courses.stream().filter(highScore).collect(Collectors.toList());

Example: Passing a Function
    This method accepts a predicate as an argument, allowing flexible filtering logic.
    Different conditions can be applied without modifying the method, making the code more reusable.
public static void filterAndPrint(
    List<Integer> numbers, 
    Predicate<Integer> predicate) {
    numbers.stream().filter(predicate).forEach(System.out::println);
}
// Usage
filterAndPrint(numbers, x -> x % 2 == 0);
filterAndPrint(numbers, x -> x % 2 != 0);
filterAndPrint(numbers, x -> x % 3 == 0);
```
## What are the benefits of using Functional Programming?
```
What?
    Computation is treated as the evaluation of mathematical functions
List<String> transformedNumbers = numbers.stream()
            .map(x -> x * x)  // Step 1: Square each number
            .map(x -> x + 10) // Step 2: Add 10
            .map(x -> "Value: " + x) // Step 3: Convert
            .toList();    // Collect the result

Core idea: focus on "what to do" rather than "how to do it."
Key Principles:
    First-Class Functions: Functions are treated as values, meaning they can be passed as arguments, returned from other functions, or assigned to variables.
    Immutability: Avoids modifying variables or data.
    No Side Effects: Functions do NOT affect other parts of the program (e.g., modifying global variables).

Why Use Functional Programming?
    Declarative Style → Focuses on what needs to be done, not how, making code cleaner and easier to read.
    Immutability → Data is not modified, reducing unexpected side effects and making debugging easier.
    Concise Code → Less boilerplate compared to traditional loops and conditionals.
    Thread Safety → No shared state means safer parallel execution without race conditions.
    Parallel Processing → Works well with streams and multi-core processors, improving performance.
```