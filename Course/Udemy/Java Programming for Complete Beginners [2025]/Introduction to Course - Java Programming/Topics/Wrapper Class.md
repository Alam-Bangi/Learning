**"What is a Wrapper Class in Java?"**

> **"A wrapper class in Java is a class that wraps a primitive data type into an object. Wrapper classes are useful when an object is required instead of a primitive, such as when working with collections, generics, or utility methods."**

---
## Primitive Data Types and Their Wrapper Classes

| Primitive Type | Wrapper Class |
| -------------- | ------------- |
| `byte`         | `Byte`        |
| `short`        | `Short`       |
| `int`          | `Integer`     |
| `long`         | `Long`        |
| `float`        | `Float`       |
| `double`       | `Double`      |
| `char`         | `Character`   |
| `boolean`      | `Boolean`     |
---

## Example

```java
int num = 100;

// Autoboxing (primitive → object)
Integer obj = num;

// Unboxing (object → primitive)
int value = obj;

System.out.println(obj);
System.out.println(value);
```

**Output:**

```
100
100
```

---

## Why Do We Need Wrapper Classes?

* Collections like `ArrayList` cannot store primitive types directly.
* Generics work only with objects.
* Wrapper classes provide useful methods for parsing and conversions.

Example:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);

System.out.println(numbers);
```

Without wrapper classes, `ArrayList<int>` is **not allowed**.

---

## Autoboxing and Unboxing

### Autoboxing

Java automatically converts a primitive into its wrapper object.

```java
Integer num = 10;
```

Equivalent to:

```java
Integer num = Integer.valueOf(10);
```

### Unboxing

Java automatically converts a wrapper object back to a primitive.

```java
Integer num = 10;
int value = num;
```

Equivalent to:

```java
int value = num.intValue();
```

---

## Useful Methods in Wrapper Classes

```java
String s = "123";

int num = Integer.parseInt(s);

System.out.println(num);
```

Other commonly used methods:

* `Integer.parseInt("123")`
* `Double.parseDouble("12.5")`
* `Boolean.parseBoolean("true")`
* `Character.isDigit('5')`
* `Integer.valueOf(100)`

---

## Wrapper Class vs Primitive Type

| Primitive             | Wrapper Class                           |
| --------------------- | --------------------------------------- |
| Stores a value        | Stores an object                        |
| Faster                | Slightly slower due to object overhead  |
| Cannot be `null`      | Can be `null`                           |
| Used for calculations | Used in collections, generics, and APIs |

---

## Common Interview Questions

**Q: Why do we use wrapper classes?**

> To treat primitive values as objects, especially when using collections, generics, or utility methods.

**Q: What is autoboxing?**

> Automatic conversion of a primitive type to its wrapper object.

**Q: What is unboxing?**

> Automatic conversion of a wrapper object to its corresponding primitive type.

**Q: Can a wrapper object be `null`?**

> Yes. Wrapper classes are objects, so they can hold `null`. Primitive types cannot.

**Q: Which package contains wrapper classes?**

> `java.lang`.

---

## Interview-Ready Answer (1 Minute)

> "Wrapper classes in Java convert primitive data types into objects. Each primitive type has a corresponding wrapper class, such as `int` → `Integer` and `char` → `Character`. Wrapper classes are needed because collections and generics work only with objects. Java also supports autoboxing, which automatically converts primitives to wrapper objects, and unboxing, which converts wrapper objects back to primitives. Wrapper classes also provide utility methods like `parseInt()` and `valueOf()` for data conversion and manipulation."
