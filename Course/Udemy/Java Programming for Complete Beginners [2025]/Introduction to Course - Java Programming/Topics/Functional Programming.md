
> **“Functional programming is a programming style where we treat computation as the evaluation of functions and try to avoid changing state and side effects. Java supports functional programming mainly through lambda expressions, functional interfaces, the Stream API, and method references, which were introduced significantly in Java 8.”**
>
> **“For example, instead of writing a loop to filter a list, I can use the Stream API:**
>
> ```java
> List<Integer> numbers = List.of(1, 2, 3, 4, 5);
>
> List<Integer> evenNumbers = numbers.stream()
>         .filter(n -> n % 2 == 0)
>         .toList();
> ```
>
> **Here, `filter` takes a lambda expression, and we describe what we want rather than explicitly managing the loop. Java isn't purely functional, because it still supports object-oriented and imperative programming.”**

### If they ask “What are the main features?”

Mention these:

1. **Lambda expressions**

   ```java
   (a, b) -> a + b
   ```

2. **Functional interfaces** — interfaces with one abstract method, such as `Function`, `Predicate`, `Consumer`, and `Supplier`.

3. **Stream API** — operations such as `filter()`, `map()`, `reduce()`, and `collect()`.

4. **Immutability** — prefer not to modify existing state.

5. **Higher-order functions** — functions can be passed as arguments or returned from methods.

6. **Method references**

   ```java
   names.forEach(System.out::println);
   ```

### A strong follow-up answer

If they ask **“Why use functional programming?”**, say:

> “It can make code more concise and expressive, especially for collection processing. It also encourages immutability and reduces side effects, which can make code easier to test, reason about, and maintain. However, I wouldn't use functional constructs everywhere; for complex logic, traditional imperative code can sometimes be clearer.”

---
---
Absolutely. For a Java interview, you don't need to memorize *every* functional-programming method. You should understand the major **functional interfaces + Stream API operations**, what they accept, what they return, and when to use them.

## 1. First: Functional Interfaces

Java's functional programming is built heavily around `java.util.function`.

### `Predicate<T>` — takes input, returns boolean

Used when you want to **test/filter** something.

```java
Predicate<Integer> isEven = n -> n % 2 == 0;

System.out.println(isEven.test(4)); // true
```

Main method:

```java
test(T value)
```

**Interview answer:**

> Predicate is used when I need to evaluate a condition. It takes one argument and returns a boolean.

---

### `Function<T, R>` — takes input, produces output

Used for **transformation**.

```java
Function<String, Integer> length = s -> s.length();

System.out.println(length.apply("Java")); // 4
```

Main method:

```java
apply(T value)
```

Example with Stream:

```java
names.stream()
     .map(String::length)
     .toList();
```

**Think:** `input → output`

---

### `Consumer<T>` — takes input, returns nothing

Used when you want to **perform an action**.

```java
Consumer<String> print = s -> System.out.println(s);

print.accept("Hello");
```

Main method:

```java
accept(T value)
```

Common example:

```java
names.forEach(System.out::println);
```

**Think:** `input → action`

---

### `Supplier<T>` — takes nothing, produces something

Used when you need to **generate/provide a value**.

```java
Supplier<Double> random = () -> Math.random();

System.out.println(random.get());
```

Main method:

```java
get()
```

**Think:** `nothing → output`

---

## 2. The four most important ones

Remember this table:

| Interface       | Input   | Output  | Main method | Typical use    |
| --------------- | ------- | ------- | ----------- | -------------- |
| `Predicate<T>`  | 1       | boolean | `test()`    | condition      |
| `Function<T,R>` | 1       | result  | `apply()`   | transformation |
| `Consumer<T>`   | 1       | nothing | `accept()`  | action         |
| `Supplier<T>`   | nothing | result  | `get()`     | generate value |

This is **very important for interviews**.

---

# 3. Stream API

Now we get to the methods you'll probably be asked about most.

Suppose:

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5, 6);
```

You can create a stream:

```java
numbers.stream()
```

A stream lets you process data through a pipeline.

For example:

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .map(n -> n * 2)
       .toList();
```

The pipeline is:

```text
List
 ↓
stream()
 ↓
filter()
 ↓
map()
 ↓
toList()
```

---

# 4. `filter()`

Used to **select elements** based on a condition.

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .toList();
```

Result:

```text
[2, 4, 6]
```

It takes a:

```java
Predicate<T>
```

So:

```java
filter(Predicate<T>)
```

### Interview answer

> `filter()` is an intermediate Stream operation used to select elements based on a condition. It takes a Predicate.

---

# 5. `map()`

Used to **transform each element**.

```java
numbers.stream()
       .map(n -> n * 10)
       .toList();
```

Result:

```text
[10, 20, 30, 40, 50, 60]
```

It takes a:

```java
Function<T, R>
```

Example:

```java
List<String> names = List.of("John", "Mike", "Sam");

List<Integer> lengths = names.stream()
        .map(String::length)
        .toList();
```

Result:

```text
[4, 4, 3]
```

### Easy way to remember

```text
filter → remove/select
map    → transform
```

---

# 6. `flatMap()`

This is a **very common interview question**.

`map()` gives you a nested structure when each element produces multiple elements.

Example:

```java
List<List<Integer>> numbers = List.of(
        List.of(1, 2),
        List.of(3, 4),
        List.of(5, 6)
);
```

Using `map()`:

```java
numbers.stream()
       .map(list -> list.stream())
```

You get:

```text
Stream<Stream<Integer>>
```

But `flatMap()` flattens them:

```java
numbers.stream()
       .flatMap(List::stream)
       .toList();
```

Result:

```text
[1, 2, 3, 4, 5, 6]
```

### Interview answer

> `map()` transforms each element, whereas `flatMap()` transforms each element and then flattens the resulting streams into one stream.

---

# 7. `distinct()`

Removes duplicates.

```java
List<Integer> numbers =
        List.of(1, 2, 2, 3, 3, 4);

numbers.stream()
       .distinct()
       .toList();
```

Result:

```text
[1, 2, 3, 4]
```

---

# 8. `sorted()`

Sorts elements.

```java
numbers.stream()
       .sorted()
       .toList();
```

Descending:

```java
numbers.stream()
       .sorted(Comparator.reverseOrder())
       .toList();
```

For objects:

```java
employees.stream()
         .sorted(Comparator.comparing(Employee::getSalary))
         .toList();
```

---

# 9. `limit()`

Takes only the first N elements.

```java
numbers.stream()
       .limit(3)
       .toList();
```

Result:

```text
[1, 2, 3]
```

---

# 10. `skip()`

Skips the first N elements.

```java
numbers.stream()
       .skip(2)
       .toList();
```

Result:

```text
[3, 4, 5, 6]
```

Very useful for pagination.

---

# 11. `peek()`

Mostly used for **debugging/observing** elements as they pass through a pipeline.

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .peek(System.out::println)
       .toList();
```

Don't normally use `peek()` for business logic.

Interviewers sometimes ask this because `peek()` is an intermediate operation and is **lazy**.

---

# 12. `forEach()`

Performs an action on every element.

```java
numbers.stream()
       .forEach(System.out::println);
```

It takes a `Consumer`.

```java
forEach(Consumer<T>)
```

Difference:

```java
map()     → transforms
forEach() → performs an action
```

---

# 13. `collect()`

Used to collect stream results into another data structure or perform a reduction.

For example:

```java
List<Integer> result = numbers.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
```

You can also create a `Set`:

```java
Set<Integer> result = numbers.stream()
        .collect(Collectors.toSet());
```

Or a Map:

```java
Map<Integer, String> map = employees.stream()
        .collect(Collectors.toMap(
                Employee::getId,
                Employee::getName
        ));
```

`collect()` is extremely important in real-world Java.

---

# 14. `reduce()`

Used to **combine multiple elements into one result**.

Example: sum.

```java
int sum = numbers.stream()
        .reduce(0, (a, b) -> a + b);
```

Result:

```text
21
```

Another way:

```java
int sum = numbers.stream()
        .reduce(0, Integer::sum);
```

Think:

```text
1 + 2 + 3 + 4 + 5 + 6
             ↓
            21
```

### Interview answer

> `reduce()` combines the elements of a stream into a single result using an accumulation function.

---

# 15. `count()`

Counts elements.

```java
long count = numbers.stream()
        .filter(n -> n % 2 == 0)
        .count();
```

Result:

```text
3
```

---

# 16. `min()` and `max()`

Find minimum/maximum.

```java
Optional<Integer> max = numbers.stream()
        .max(Integer::compareTo);
```

And:

```java
Optional<Integer> min = numbers.stream()
        .min(Integer::compareTo);
```

Notice they return:

```java
Optional<Integer>
```

because the stream could be empty.

---

# 17. `anyMatch()`

Checks whether **at least one** element matches.

```java
boolean result = numbers.stream()
        .anyMatch(n -> n > 5);
```

Result:

```text
true
```

Think:

```text
ANY → true if at least one matches
```

---

# 18. `allMatch()`

Checks whether **every** element matches.

```java
boolean result = numbers.stream()
        .allMatch(n -> n > 0);
```

Result:

```text
true
```

Think:

```text
ALL → every element must match
```

---

# 19. `noneMatch()`

Checks whether **no** element matches.

```java
boolean result = numbers.stream()
        .noneMatch(n -> n < 0);
```

Result:

```text
true
```

Easy memory trick:

```text
anyMatch  → at least one
allMatch  → everyone
noneMatch → nobody
```

---

# 20. `findFirst()`

Returns the first element.

```java
Optional<Integer> result =
        numbers.stream()
               .findFirst();
```

---

# 21. `findAny()`

Returns any matching element.

```java
Optional<Integer> result =
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .findAny();
```

It's particularly relevant when working with parallel streams, where "any" element can potentially be returned.

---

# 22. Intermediate vs Terminal Operations

This is **very important in interviews**.

### Intermediate operations

They return another Stream and can be chained:

```text
filter()
map()
flatMap()
distinct()
sorted()
limit()
skip()
peek()
```

Example:

```java
numbers.stream()
       .filter(...)
       .map(...)
       .sorted()
```

### Terminal operations

They produce the final result and terminate the stream:

```text
forEach()
collect()
reduce()
count()
min()
max()
findFirst()
findAny()
anyMatch()
allMatch()
noneMatch()
```

Example:

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .map(n -> n * 2)
       .collect(Collectors.toList());
```

`collect()` terminates the stream.

---

# 23. Lazy Evaluation

Another common interview question.

Stream operations like:

```java
filter()
map()
```

are **lazy**.

They don't execute until a terminal operation is called.

For example:

```java
numbers.stream()
       .filter(n -> {
           System.out.println(n);
           return n % 2 == 0;
       });
```

Nothing happens yet.

But:

```java
numbers.stream()
       .filter(n -> {
           System.out.println(n);
           return n % 2 == 0;
       })
       .toList();
```

Now the stream executes.

### Interview answer

> Intermediate stream operations are lazy. They are executed only when a terminal operation triggers the stream pipeline.

---

# 24. Method References

Instead of:

```java
names.forEach(name -> System.out.println(name));
```

you can write:

```java
names.forEach(System.out::println);
```

This is called a **method reference**.

Common forms:

```java
ClassName::staticMethod
object::instanceMethod
ClassName::instanceMethod
ClassName::new
```

Example:

```java
List<String> names = List.of("A", "B", "C");

names.forEach(System.out::println);
```

---

# 25. `Optional`

`Optional` is not technically a Stream operation, but it is heavily associated with modern functional-style Java.

Instead of:

```java
if (user != null) {
    System.out.println(user.getName());
}
```

you might use:

```java
Optional<User> user = findUser();

user.ifPresent(u -> System.out.println(u.getName()));
```

Important methods:

```java
isPresent()
isEmpty()
ifPresent()
orElse()
orElseGet()
orElseThrow()
map()
filter()
flatMap()
```

For example:

```java
String name = user
        .map(User::getName)
        .orElse("Unknown");
```

---

# 26. The most important interview example

Suppose you have:

```java
List<Employee> employees;
```

You want:

> Get names of employees whose salary is greater than 100,000, sort them, and return a list.

You could write:

```java
List<String> names = employees.stream()
        .filter(e -> e.getSalary() > 100000)
        .map(Employee::getName)
        .sorted()
        .toList();
```

This single example demonstrates:

```text
stream()
   ↓
filter()  → Predicate
   ↓
map()     → Function
   ↓
sorted()
   ↓
toList()
```

That's the kind of example I'd use in an interview.

---

## What I would memorize for an interview

Don't try to memorize 50 methods. Know these extremely well:

```text
Predicate  → test()
Function   → apply()
Consumer   → accept()
Supplier   → get()

filter()   → select
map()      → transform
flatMap()  → transform + flatten
distinct() → remove duplicates
sorted()   → sort
limit()    → first N
skip()     → skip N

forEach()  → perform action
collect()  → collect result
reduce()   → combine into one result
count()    → count
min/max()  → minimum/maximum

anyMatch() → at least one
allMatch() → all
noneMatch()→ none

findFirst()
findAny()
```

If you're preparing for a **Java interview**, the next thing you should learn is **`map()` vs `flatMap()`, `filter()` vs `map()`, `reduce()` vs `collect()`, and `stream()` vs `parallelStream()`**. These are frequent interview questions.
