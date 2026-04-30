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