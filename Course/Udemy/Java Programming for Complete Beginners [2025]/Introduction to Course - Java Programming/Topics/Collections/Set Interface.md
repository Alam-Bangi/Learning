**"What is Set interface in Java?"**

> **"The `Set` interface in Java is a part of the Collection Framework and is used to store a collection of unique elements. It does not allow duplicate values and generally does not maintain insertion order (except implementations like `LinkedHashSet`). The `Set` interface is present in the `java.util` package and is implemented by classes like `HashSet`, `LinkedHashSet`, and `TreeSet`."**

---

# Features of Set Interface

* Does **not allow duplicate elements**.
* Does **not support index-based access**.
* Allows at most one `null` value (depending on implementation).
* Used when uniqueness of elements is required.
* Provides efficient searching operations.

---

# Set Interface Hierarchy

```text
Collection
    |
    Set
    |
 -------------------------
 |           |            |
HashSet  LinkedHashSet  TreeSet
```

---

# Creating a Set

```java id="qz2v4n"
import java.util.Set;
import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();

        names.add("John");
        names.add("Alex");
        names.add("John");  // Duplicate value

        System.out.println(names);
    }
}
```

**Output:**

```text
[Alex, John]
```

The duplicate `"John"` is ignored.

---

# Common Methods of Set Interface

| Method       | Description                      |
| ------------ | -------------------------------- |
| `add()`      | Adds an element                  |
| `remove()`   | Removes an element               |
| `contains()` | Checks whether an element exists |
| `size()`     | Returns number of elements       |
| `isEmpty()`  | Checks if the set is empty       |
| `clear()`    | Removes all elements             |
| `iterator()` | Used to iterate through elements |

---

# Implementations of Set Interface

## 1. HashSet

* Uses a hash table internally.
* Does not maintain insertion order.
* Allows one `null` value.
* Provides fast operations (`add`, `remove`, `contains`).

Example:

```java id="6f7nq9"
Set<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(10);

System.out.println(set);
```

Output:

```text
[20, 10]
```

---

## 2. LinkedHashSet

* Maintains insertion order.
* Uses a combination of hash table and linked list.
* Slightly slower than HashSet.

Example:

```java id="f2i9g1"
Set<String> set = new LinkedHashSet<>();

set.add("Java");
set.add("Python");
set.add("C++");

System.out.println(set);
```

Output:

```text
[Java, Python, C++]
```

---

## 3. TreeSet

* Stores elements in sorted order.
* Uses a Red-Black tree internally.
* Does not allow `null` values.
* Slower than HashSet.

Example:

```java id="1jv3d8"
Set<Integer> set = new TreeSet<>();

set.add(30);
set.add(10);
set.add(20);

System.out.println(set);
```

Output:

```text
[10, 20, 30]
```

---

# HashSet vs LinkedHashSet vs TreeSet

| Feature            | HashSet         | LinkedHashSet              | TreeSet                |
| ------------------ | --------------- | -------------------------- | ---------------------- |
| Order              | No order        | Maintains insertion order  | Sorted order           |
| Performance        | Fastest         | Slightly slower            | Slower                 |
| Internal Structure | Hash table      | Hash table + linked list   | Tree                   |
| Allows null        | Yes (one)       | Yes (one)                  | No                     |
| Use Case           | Unique elements | Unique elements with order | Sorted unique elements |

---

# List vs Set

| List                        | Set                             |
| --------------------------- | ------------------------------- |
| Allows duplicates           | Does not allow duplicates       |
| Maintains insertion order   | Order depends on implementation |
| Supports index-based access | No index-based access           |
| Example: ArrayList          | Example: HashSet                |

---

# Common Interview Questions

**Q: Does Set allow duplicate values?**

> No, Set does not allow duplicate elements.

**Q: Does HashSet maintain insertion order?**

> No, HashSet does not maintain insertion order.

**Q: Which Set implementation maintains insertion order?**

> LinkedHashSet.

**Q: Which Set implementation stores elements in sorted order?**

> TreeSet.

**Q: Can Set store null values?**

> HashSet and LinkedHashSet allow one null value, but TreeSet does not allow null values.

---

# Interview-Ready Answer (1 Minute)

> **"Set is an interface in Java Collection Framework used to store unique elements. It does not allow duplicate values and does not support index-based access. Common implementations of Set are HashSet, LinkedHashSet, and TreeSet. HashSet provides fast operations but does not maintain order, LinkedHashSet maintains insertion order, and TreeSet stores elements in sorted order. Set is mainly used when we need to ensure that duplicate elements are not stored."**
