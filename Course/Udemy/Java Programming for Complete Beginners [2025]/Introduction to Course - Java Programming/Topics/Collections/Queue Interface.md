**"What is Queue interface in Java?"**

> **"The `Queue` interface in Java is a part of the Collection Framework and is used to store elements before processing. It generally follows the FIFO (First In First Out) principle, meaning the element inserted first is removed first. The `Queue` interface is present in the `java.util` package and is implemented by classes like `PriorityQueue`, `LinkedList`, and `ArrayDeque`."**

---

# Features of Queue Interface

* Follows **FIFO (First In First Out)** order in most implementations.
* Used for holding elements waiting for processing.
* Allows duplicate elements.
* Supports insertion and removal operations from different ends depending on implementation.
* Does not allow index-based access.

---

# Queue Interface Hierarchy

```text
Collection
    |
   Queue
    |
 ---------------------
 |         |          |
LinkedList PriorityQueue ArrayDeque
```

---

# Creating a Queue

```java id="n7f8w0"
import java.util.Queue;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.add("Java");
        queue.add("Python");
        queue.add("C++");

        System.out.println(queue);
    }
}
```

**Output:**

```text id="f2gk8v"
[Java, Python, C++]
```

---

# Common Methods of Queue Interface

| Method      | Description                                                         |
| ----------- | ------------------------------------------------------------------- |
| `add()`     | Inserts an element (throws exception if insertion fails)            |
| `offer()`   | Inserts an element (returns false if insertion fails)               |
| `remove()`  | Removes and returns the head element (throws exception if empty)    |
| `poll()`    | Removes and returns the head element (returns null if empty)        |
| `element()` | Retrieves head element without removing (throws exception if empty) |
| `peek()`    | Retrieves head element without removing (returns null if empty)     |

---

# Example of Queue Operations

```java id="b8uw2s"
import java.util.Queue;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
```

**Output:**

```text id="g7g3z9"
10
20
[20, 30]
```

---

# Types of Queue Implementations

## 1. PriorityQueue

* Elements are processed based on priority, not insertion order.
* By default, elements are stored in natural sorted order.
* Does not allow `null`.

Example:

```java id="mx1j8u"
Queue<Integer> pq = new PriorityQueue<>();

pq.add(30);
pq.add(10);
pq.add(20);

System.out.println(pq.poll());
```

**Output:**

```text id="8t5t9r"
10
```

---

## 2. LinkedList as Queue

* Implements both `List` and `Queue`.
* Maintains insertion order.
* Allows null values.

```java id="t1g6g7"
Queue<String> queue = new LinkedList<>();

queue.add("A");
queue.add("B");
queue.add("C");

System.out.println(queue);
```

---

## 3. ArrayDeque

* Double-ended queue (Deque).
* Allows insertion and removal from both ends.
* Faster than `Stack` and `LinkedList` for queue operations.
* Does not allow null values.

---

# Queue vs Stack

| Queue                                | Stack                               |
| ------------------------------------ | ----------------------------------- |
| Follows FIFO                         | Follows LIFO                        |
| First element added is removed first | Last element added is removed first |
| Uses `offer()` and `poll()`          | Uses `push()` and `pop()`           |
| Example: Waiting line                | Example: Browser history            |

---

# Queue vs List

| Queue                            | List                                        |
| -------------------------------- | ------------------------------------------- |
| Designed for processing elements | Designed for storing and accessing elements |
| Usually FIFO                     | Supports index-based access                 |
| Uses `offer()`/`poll()`          | Uses `add()`/`get()`                        |

---

# Common Interview Questions

**Q: What principle does Queue follow?**

> Queue generally follows FIFO (First In First Out).

**Q: Difference between `poll()` and `remove()`?**

> `poll()` returns `null` if the queue is empty, while `remove()` throws `NoSuchElementException`.

**Q: Difference between `peek()` and `element()`?**

> Both retrieve the first element without removing it, but `peek()` returns `null` for an empty queue while `element()` throws an exception.

**Q: Which Queue implementation provides priority-based ordering?**

> `PriorityQueue`.

---

# Interview-Ready Answer (1 Minute)

> **"Queue is an interface in Java Collection Framework used to store elements before processing. It usually follows the FIFO principle, where the first element inserted is the first one removed. Queue provides methods like `offer()`, `poll()`, and `peek()` for insertion, removal, and accessing elements. Common implementations are `LinkedList`, `PriorityQueue`, and `ArrayDeque`. `PriorityQueue` processes elements based on priority, while `LinkedList` maintains insertion order. Queue is commonly used in applications like task scheduling, messaging systems, and buffering."**
