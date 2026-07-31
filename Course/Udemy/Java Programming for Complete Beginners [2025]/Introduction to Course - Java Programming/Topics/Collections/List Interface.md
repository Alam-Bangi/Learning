**"What is List interface in Java?"**

> **"The `List` interface in Java is a part of the Collection Framework and is used to store an ordered collection of elements. It allows duplicate elements and maintains the insertion order of elements. The `List` interface is present in the `java.util` package and is implemented by classes like `ArrayList`, `LinkedList`, and `Vector`."**

---

# Features of List Interface

* Maintains **insertion order**.
* Allows **duplicate elements**.
* Allows **null values**.
* Elements can be accessed using an **index**.
* Supports dynamic size (grows and shrinks automatically).  
* Allows searching, insertion, and deletion operations.

---

# List Interface Hierarchy

```
Collection
    |
    List
    |
 -------------------------
 |          |             |
ArrayList  LinkedList   Vector
```

---

# Creating a List

```java id="qgk1d5"
import java.util.List;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Alex");
        names.add("John");

        System.out.println(names);
    }
}
```

**Output:**

```id="7e2f7h"
[John, Alex, John]
```

---

# Common Methods of List Interface

| Method                | Description                            |
| --------------------- | -------------------------------------- |
| `add()`               | Adds an element                        |
| `add(index, element)` | Adds an element at a specific position |
| `get(index)`          | Retrieves an element                   |
| `set(index, element)` | Updates an element                     |
| `remove(index)`       | Removes an element                     |
| `contains()`          | Checks if an element exists            |
| `size()`              | Returns number of elements             |
| `clear()`             | Removes all elements                   |
| `isEmpty()`           | Checks whether list is empty           |

---

# Implementations of List Interface

## 1. ArrayList

* Uses a dynamic array internally.
* Fast for retrieving elements.
* Slower for insertion/deletion in the middle.

Example:

```java id="rqv8qf"
List<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);

System.out.println(list);
```

---

## 2. LinkedList

* Uses a doubly linked list internally.
* Faster for frequent insertions and deletions.
* Slower for random access.

Example:

```java id="xg2k9p"
List<Integer> list = new LinkedList<>();

list.add(10);
list.add(20);

System.out.println(list);
```

---

## 3. Vector

* Similar to ArrayList.
* Thread-safe because methods are synchronized.
* Slower compared to ArrayList.

---

# ArrayList vs LinkedList

| ArrayList                   | LinkedList                    |
| --------------------------- | ----------------------------- |
| Uses dynamic array          | Uses doubly linked list       |
| Faster for searching/access | Faster for insertion/deletion |
| Less memory overhead        | More memory overhead          |
| Implements List             | Implements List and Deque     |

---

# List vs Set

| List                      | Set                             |
| ------------------------- | ------------------------------- |
| Allows duplicates         | Does not allow duplicates       |
| Maintains insertion order | Order depends on implementation |
| Uses index-based access   | No index-based access           |
| Example: ArrayList        | Example: HashSet                |

---

# Common Interview Questions

**Q: Does List allow duplicate values?**

> Yes, List allows duplicate elements.

**Q: Does List maintain insertion order?**

> Yes, List maintains the order in which elements are inserted.

**Q: Can List store null values?**

> Yes, List can store null values.

**Q: Is List an interface or class?**

> List is an interface.

**Q: Which is faster, ArrayList or LinkedList?**

> ArrayList is faster for searching/access, while LinkedList is faster for frequent insertions and deletions.

---

# Interview-Ready Answer (1 Minute)

> **"List is an interface in Java's Collection Framework that represents an ordered collection of elements. It allows duplicate values and maintains insertion order. List supports index-based operations and provides methods like add(), remove(), get(), and set(). Common implementations of List are ArrayList, LinkedList, and Vector. ArrayList is preferred for fast searching and accessing elements, while LinkedList is preferred when frequent insertions and deletions are required."**
