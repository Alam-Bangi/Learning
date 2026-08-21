
> “Generics in Java allow us to write classes, interfaces, and methods that can work with different data types while providing compile-time type safety.

> For example, instead of using a raw `List` and casting objects manually, I can use `List<String>`. This tells the compiler that the list should contain only strings.

> ```java
> List<String> names = new ArrayList<>();
> names.add("John");
> // names.add(10); // compile-time error
> ```

> The main benefits of generics are **type safety, avoiding unnecessary type casting, and writing reusable code**.

> Java generics are implemented using **type erasure**, so generic type information is primarily used by the compiler and isn't generally available at runtime.”

### If the interviewer asks for more

You can explain a generic class:
```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
Box<String> box = new Box<>();
box.set("Hello");

String value = box.get();
```

Here, `T` is a **type parameter**. When we create `Box<String>`, `T` effectively represents `String`.

### Know these common follow-ups
**1. What is `<?>`?**
> “`<?>` is an unbounded wildcard. It means the collection can contain objects of some unknown type.”

```java
List<?> list;
```

**2. `extends` vs `super`?**
A good interview rule is **PECS — Producer Extends, Consumer Super**.

```java
List<? extends Number>   // producer: read Numbers
List<? super Integer>    // consumer: can add Integers
```

**3. Why can't we use primitives?**
```java
List<int>       // ❌
List<Integer>   // ✅
```

Generics work with reference types, so we use wrapper classes such as `Integer`, `Double`, etc.

**Interview tip:** Don't start with type erasure, wildcards, or PECS unless asked. Start with **“generics provide compile-time type safety and reusable code”**, then demonstrate it with `List<String>`. That sounds much clearer and more confident.
---
| Generic Concept        | Example              | Meaning                          |
|------------------------|----------------------|----------------------------------|
| Generic class          | `Box<T>`             | Class works with any type       |
| Generic method         | `<T> void print(T x)` | Method works with any type      |
| Bounded type           | `<T extends Number>` | T must be Number or subclass    |
| Unbounded wildcard     | `<?>`                | Any type                        |
| Upper-bounded wildcard | `<? extends Number>` | Number or its subclasses       |
| Lower-bounded wildcard | `<? super Integer>`  | Integer or its superclasses     |
| Generic collection     | `List<String>`       | Collection restricted to String |
---
In Java, **generics** allow you to write classes, interfaces, and methods that work with different data types while providing **compile-time type safety**.

## 1. Generic Class

A class can have a type parameter.

```java
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

Box<Integer> b1 = new Box<>();
b1.set(10);

Box<String> b2 = new Box<>();
b2.set("Hello");
```

Here, `T` is a **type parameter**.

Common naming conventions:

* `T` → Type
* `E` → Element
* `K` → Key
* `V` → Value
* `N` → Number
* `S`, `U`, `V` → additional types

---

## 2. Generic Interface

```java
interface Container<T> {
    void add(T value);
    T get();
}

class StringContainer implements Container<String> {
    public void add(String value) {
        // ...
    }

    public String get() {
        return "Hello";
    }
}
```

---

## 3. Generic Method

A method can have its own type parameter.

```java
class Demo {
    public static <T> void print(T value) {
        System.out.println(value);
    }
}

Demo.print(10);
Demo.print("Hello");
Demo.print(10.5);
```

`<T>` before `void` declares the method's type parameter.

---

# 4. Multiple Type Parameters

You can use multiple generic types.

```java
class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

Pair<Integer, String> p = new Pair<>(1, "Apple");
```

This is commonly used in structures such as `Map<K, V>`.

---

# 5. Bounded Generics

You can restrict what types can be used.

### Upper bound — `extends`

```java
class Box<T extends Number> {
    T value;
}
```

Allowed:

```java
Box<Integer> b1;
Box<Double> b2;
Box<Float> b3;
```

Not allowed:

```java
Box<String> b;  // Error
```

`extends` can mean a **class or interface bound** in a type parameter.

```java
<T extends Number>
<T extends Runnable>
<T extends Number & Comparable<T>>
```

---

# 6. Lower-Bounded Wildcard — `super`

```java
List<? super Integer> list;
```

This can refer to:

```java
List<Integer>
List<Number>
List<Object>
```

A lower bound is written with `super`.

---

# 7. Unbounded Wildcard — `?`

`?` means an **unknown type**.

```java
List<?> list;
```

It can refer to:

```java
List<Integer>
List<String>
List<Double>
List<Object>
```

Example:

```java
public static void printList(List<?> list) {
    for (Object x : list) {
        System.out.println(x);
    }
}
```

---

# 8. Upper-Bounded Wildcard — `extends`

```java
List<? extends Number> list;
```

Possible types:

```java
List<Integer>
List<Double>
List<Float>
List<Number>
```

You can safely **read** values as `Number`, but generally cannot add a specific `Number` to the list.

```java
Number n = list.get(0);
```

---

# 9. Wildcard Types — All Three

The three major wildcard forms are:

| Generic type    | Meaning                              |
| --------------- | ------------------------------------ |
| `<?>`           | Unknown type                         |
| `<? extends T>` | Some type that is `T` or a subtype   |
| `<? super T>`   | Some type that is `T` or a supertype |

A useful rule is **PECS**:

> **Producer Extends, Consumer Super**

* If you're **reading/producing** `T` → `extends`
* If you're **writing/consuming** `T` → `super`

---

# 10. Recursive / Self-Bounded Generics

A type can use itself as a bound.

```java
class Person<T extends Person<T>> {
}
```

A common real-world example is:

```java
class Student implements Comparable<Student> {
    public int compareTo(Student other) {
        return 0;
    }
}
```

---

# 11. Generic Constructor

Constructors can use generic parameters.

```java
class Demo {
    <T> Demo(T value) {
        System.out.println(value);
    }
}

Demo d1 = new Demo(10);
Demo d2 = new Demo("Hello");
```

---

# 12. Generic Array / Varargs

Generic arrays have restrictions because Java does not allow direct creation of arrays of a type variable:

```java
// T[] arr = new T[10];  // Error
```

But generic varargs can be used:

```java
static <T> void print(T... values) {
    for (T value : values) {
        System.out.println(value);
    }
}
```

---

# 13. Nested Generics

Generics can be nested.

```java
List<List<String>> data = new ArrayList<>();
```

Another example:

```java
Map<String, List<Integer>> marks = new HashMap<>();
```

---

# 14. Generic Collections

Java Collections heavily use generics.

### List

```java
List<String> names = new ArrayList<>();
```

### Set

```java
Set<Integer> numbers = new HashSet<>();
```

### Map

```java
Map<Integer, String> students = new HashMap<>();
```

### Queue

```java
Queue<String> queue = new LinkedList<>();
```

### Deque

```java
Deque<Integer> deque = new ArrayDeque<>();
```

---

# 15. Raw Types

A generic class can technically be used without specifying its type.

```java
List list = new ArrayList();
```

This is called a **raw type**.

It is generally discouraged because type safety is lost.

```java
list.add("Hello");
list.add(10);

String s = (String) list.get(1); // Runtime error
```

Prefer:

```java
List<String> list = new ArrayList<>();
```

---

# 16. Diamond Operator `<>`

Java can infer the generic type from the left side.

Instead of:

```java
List<String> list = new ArrayList<String>();
```

write:

```java
List<String> list = new ArrayList<>();
```

The `<>` is called the **diamond operator**.

---

# 17. Type Erasure

Java generics are primarily implemented using **type erasure**.

For example:

```java
List<String>
```

and

```java
List<Integer>
```

are generally represented as `List` at runtime.

Because of type erasure, you cannot do things like:

```java
if (obj instanceof List<String>) { } // Error
```

And you cannot directly create:

```java
new T();       // Error
new T[10];     // Error
```

---

# 18. Generic Inheritance

```java
class Animal {
}

class Dog extends Animal {
}

class Box<T> {
}
```

You can have:

```java
Box<Dog> dogBox = new Box<>();
```

But:

```java
Box<Animal> animalBox = dogBox; // Error
```

This is important:

**`Box<Dog>` is NOT a subtype of `Box<Animal>`.**

Generics are **invariant** by default.

---

# 19. Wildcard Allows Flexibility

Although this doesn't work:

```java
Box<Animal> box = new Box<Dog>(); // Error
```

you can use:

```java
Box<? extends Animal> box = new Box<Dog>();
```

This is an **upper-bounded wildcard**.

---

## Quick Summary — All Important Generic Types

```java
<T>                    // Type parameter
<T, U>                 // Multiple type parameters

<?>                    // Unbounded wildcard
<? extends Number>     // Upper-bounded wildcard
<? super Integer>      // Lower-bounded wildcard

<T extends Number>     // Bounded type parameter
<T extends A & B>      // Multiple bounds

List<String>           // Parameterized type
List<List<String>>     // Nested generics

List                    // Raw type (avoid)
new ArrayList<>()       // Diamond operator
```

### The most important distinction

```java
<T extends Number>
```

is a **type parameter bound**.

```java
<? extends Number>
```

is a **wildcard bound**.

```java
<? super Integer>
```

is a **lower-bounded wildcard**.

If you're preparing for **Java interviews**, the most important topics are **`extends` vs `super`, PECS, wildcards, bounded type parameters, generic methods, type erasure, and why `List<Integer>` is not a `List<Number>`**.
