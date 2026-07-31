**"What is the String class in Java?"**

> **"The `String` class in Java is used to represent a sequence of characters. It is a class from the `java.lang` package, so it is available automatically without importing it. String objects are immutable, which means once a `String` object is created, its value cannot be changed."**

---

## Why is `String` Immutable?

* Improves security.
* Makes strings thread-safe.
* Allows efficient memory usage through the String Pool.
* Enables caching of hash codes.

**Example:**

```java
String s = "Hello";
s.concat(" World");

System.out.println(s);
```

**Output:**

```
Hello
```

To change it:

```java
String s = "Hello";
s = s.concat(" World");

System.out.println(s);
```

**Output:**

```
Hello World
```

---

## Ways to Create a String

### 1. Using a String Literal

```java
String s1 = "Java";
```

Stored in the **String Pool**.

### 2. Using the `new` Keyword

```java
String s2 = new String("Java");
```

Creates a new object in heap memory.

---

## Common String Methods

| Method               | Description                              | Example                           |
| -------------------- | ---------------------------------------- | --------------------------------- |
| `length()`           | Returns the number of characters         | `"Java".length()` → `4`           |
| `charAt(index)`      | Returns the character at the given index | `"Java".charAt(1)` → `'a'`        |
| `substring()`        | Returns part of a string                 | `"Java".substring(1)` → `"ava"`   |
| `equals()`           | Compares string content                  | `"abc".equals("abc")`             |
| `equalsIgnoreCase()` | Ignores letter case while comparing      | `"Java".equalsIgnoreCase("JAVA")` |
| `compareTo()`        | Lexicographically compares two strings   | `"abc".compareTo("abd")`          |
| `toUpperCase()`      | Converts to uppercase                    | `"java"` → `"JAVA"`               |
| `toLowerCase()`      | Converts to lowercase                    | `"JAVA"` → `"java"`               |
| `trim()`             | Removes leading and trailing spaces      | `" Java ".trim()`                 |
| `replace()`          | Replaces characters or text              | `"Java".replace('a','o')`         |
| `contains()`         | Checks if a substring exists             | `"Java".contains("av")`           |

---

## Example Program

```java
public class StringDemo {
    public static void main(String[] args) {
        String str = "Java Programming";

        System.out.println(str.length());
        System.out.println(str.toUpperCase());
        System.out.println(str.substring(5));
        System.out.println(str.contains("Program"));
    }
}
```

**Output**

```
16
JAVA PROGRAMMING
Programming
true
```

---

## String vs StringBuilder vs StringBuffer

| Feature     | String                            | StringBuilder | StringBuffer                |
| ----------- | --------------------------------- | ------------- | --------------------------- |
| Mutable     | ❌ No                              | ✅ Yes         | ✅ Yes                       |
| Thread-safe | Yes (immutable)                   | ❌ No          | ✅ Yes                       |
| Performance | Slower for frequent modifications | Fastest       | Slower than `StringBuilder` |

---

## String Pool

* Java maintains a special memory area called the **String Pool**.
* Identical string literals share the same object, which saves memory.

```java
String a = "Java";
String b = "Java";

System.out.println(a == b);
```

**Output**

```
true
```

But:

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);
```

**Output**

```
false
```

Because `==` compares object references, not content.

---

## `==` vs `equals()`

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);      // false
System.out.println(s1.equals(s2)); // true
```

* `==` compares whether two references point to the same object.
* `equals()` compares the actual string contents.

---

## Common Interview Questions

**Q: Why is `String` immutable?**

> To improve security, thread safety, and performance through the String Pool.

**Q: Which package contains the `String` class?**

> `java.lang`.

**Q: What is the difference between `==` and `equals()`?**

> `==` compares references, while `equals()` compares the contents of strings.

**Q: When would you use `StringBuilder` instead of `String`?**

> When you need to modify or concatenate strings frequently, because `StringBuilder` is mutable and more efficient.

---

## Interview-Ready Answer (1 Minute)

> "The `String` class in Java represents a sequence of characters and belongs to the `java.lang` package. Strings are immutable, meaning their contents cannot be changed after creation. If a modification appears to happen, Java actually creates a new `String` object. Java also uses a String Pool to reuse identical string literals, improving memory efficiency. Common methods include `length()`, `charAt()`, `substring()`, `equals()`, `replace()`, and `contains()`. For frequent string modifications, `StringBuilder` or `StringBuffer` are preferred because they are mutable."

---
---
---

**"What are the alternatives to `String` in Java?"**

> **"The two main alternatives to the `String` class in Java are `StringBuilder` and `StringBuffer`. Unlike `String`, which is immutable, both `StringBuilder` and `StringBuffer` are mutable, meaning their contents can be changed without creating a new object."**

### 1. StringBuilder

* Mutable.
* Not thread-safe.
* Faster than `StringBuffer`.
* Best for single-threaded applications.

**Example:**

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);
```

**Output:**

```
Hello World
```

---

### 2. StringBuffer

* Mutable.
* Thread-safe (methods are synchronized).
* Slightly slower than `StringBuilder`.
* Best for multi-threaded applications.

**Example:**

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb);
```

**Output:**

```
Hello World
```

---

## Comparison Table

| Feature     | String                            | StringBuilder                | StringBuffer                |
| ----------- | --------------------------------- | ---------------------------- | --------------------------- |
| Mutable     | ❌ No                              | ✅ Yes                        | ✅ Yes                       |
| Thread-safe | Yes (immutable)                   | ❌ No                         | ✅ Yes                       |
| Performance | Slower for frequent modifications | Fastest                      | Slightly slower             |
| Best Use    | Fixed text                        | Single-threaded applications | Multi-threaded applications |

---

## When to Use Which?

* **String** → When the text does not change.
* **StringBuilder** → When you frequently modify strings in a single-threaded application.
* **StringBuffer** → When multiple threads share and modify the same string data.

---

## Interview-Ready Answer (30–45 Seconds)

> "The alternatives to `String` in Java are `StringBuilder` and `StringBuffer`. Both are mutable, so they allow modifications without creating new objects. `StringBuilder` is not thread-safe but offers better performance, making it suitable for single-threaded applications. `StringBuffer` is thread-safe because its methods are synchronized, so it is preferred in multi-threaded environments. In general, use `String` for immutable text, `StringBuilder` for performance, and `StringBuffer` when thread safety is required."
