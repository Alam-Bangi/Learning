**"What is Map interface in Java?"**

> **"The `Map` interface in Java is a part of the Collection Framework that stores data in the form of key-value pairs. Each key is unique and is mapped to a corresponding value. The `Map` interface is present in the `java.util` package and is implemented by classes like `HashMap`, `LinkedHashMap`, `TreeMap`, and `Hashtable`."**

---

# Features of Map Interface

* Stores data as **key-value pairs**.
* Each **key must be unique**.
* Values can be duplicated.
* Allows one `null` key in `HashMap` and multiple `null` values.
* Does **not extend the Collection interface**.
* Provides fast data retrieval using keys.

---

# Map Interface Hierarchy

```text id="2i5v5d"
             Map
              |
 --------------------------------
 |              |               |
HashMap    LinkedHashMap     TreeMap
 |
Hashtable
```

---

# Creating a Map

```java id="d7crj2"
import java.util.Map;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "John");
        students.put(102, "Alex");
        students.put(103, "David");

        System.out.println(students);
    }
}
```

**Output:**

```text id="y4hjx4"
{101=John, 102=Alex, 103=David}
```

---

# Common Methods of Map Interface

| Method                 | Description                      |
| ---------------------- | -------------------------------- |
| `put(key, value)`      | Adds or updates a key-value pair |
| `get(key)`             | Returns value for a key          |
| `remove(key)`          | Removes entry using key          |
| `containsKey(key)`     | Checks if a key exists           |
| `containsValue(value)` | Checks if a value exists         |
| `keySet()`             | Returns all keys                 |
| `values()`             | Returns all values               |
| `entrySet()`           | Returns key-value pairs          |
| `size()`               | Returns number of entries        |
| `clear()`              | Removes all entries              |

---

# Iterating Through a Map

### Using `entrySet()`

```java id="t4z7os"
Map<Integer, String> map = new HashMap<>();

map.put(1, "Java");
map.put(2, "Python");

for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

**Output:**

```text id="q7n3j5"
1 Java
2 Python
```

---

# Implementations of Map Interface

## 1. HashMap

* Stores data using hashing.
* Does not maintain insertion order.
* Allows one null key and multiple null values.
* Provides fast searching.

Example:

```java id="z2e1wy"
Map<Integer, String> map = new HashMap<>();

map.put(1, "Java");
map.put(2, "SQL");

System.out.println(map);
```

---

## 2. LinkedHashMap

* Maintains insertion order.
* Uses linked list along with hashing.
* Slightly slower than HashMap.

Example:

```java id="1c0wq4"
Map<Integer, String> map = new LinkedHashMap<>();

map.put(2, "B");
map.put(1, "A");

System.out.println(map);
```

Output:

```text id="6y0e8t"
{2=B, 1=A}
```

---

## 3. TreeMap

* Stores entries in sorted order based on keys.
* Uses Red-Black tree internally.
* Does not allow null keys.

Example:

```java id="9u9tqv"
Map<Integer, String> map = new TreeMap<>();

map.put(30, "C");
map.put(10, "A");
map.put(20, "B");

System.out.println(map);
```

Output:

```text id="j98f0f"
{10=A, 20=B, 30=C}
```

---

## 4. Hashtable

* Legacy class.
* Thread-safe because methods are synchronized.
* Does not allow null keys or null values.

---

# HashMap vs LinkedHashMap vs TreeMap

| Feature            | HashMap     | LinkedHashMap            | TreeMap        |
| ------------------ | ----------- | ------------------------ | -------------- |
| Ordering           | No order    | Insertion order          | Sorted order   |
| Performance        | Fastest     | Slightly slower          | Slower         |
| Null Key           | One allowed | One allowed              | Not allowed    |
| Internal Structure | Hash table  | Hash table + linked list | Red-Black tree |

---

# Map vs Collection

| Map                                  | Collection                                |
| ------------------------------------ | ----------------------------------------- |
| Stores key-value pairs               | Stores individual elements                |
| Keys must be unique                  | Duplicate rules depend on collection type |
| Does not extend Collection interface | Collection is a root interface            |
| Example: HashMap                     | Example: ArrayList                        |

---

# Common Interview Questions

**Q: Does Map allow duplicate keys?**

> No, duplicate keys are not allowed. If a duplicate key is inserted, the existing value is replaced.

**Q: Can Map have duplicate values?**

> Yes, multiple keys can have the same value.

**Q: Why does Map not extend Collection?**

> Because Map stores data as key-value pairs, while Collection stores individual elements.

**Q: Which Map implementation maintains insertion order?**

> LinkedHashMap.

**Q: Which Map implementation stores keys in sorted order?**

> TreeMap.

---

# Interview-Ready Answer (1 Minute)

> **"Map is an interface in Java Collection Framework that stores data in key-value pairs. Each key is unique, but values can be duplicated. Map does not extend the Collection interface because it represents a different data structure. Common implementations are HashMap, LinkedHashMap, TreeMap, and Hashtable. HashMap provides fast access but does not maintain order, LinkedHashMap maintains insertion order, and TreeMap stores keys in sorted order. Maps are commonly used when data needs to be retrieved quickly using a unique key."**
