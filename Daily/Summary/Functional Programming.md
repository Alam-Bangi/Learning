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
```