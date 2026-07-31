**"What are jump statements in Java?"**

> **"Jump statements are statements that transfer the control of execution from one part of a program to another. Java provides three jump statements: `break`, `continue`, and `return`."**

## 1. `break` Statement

* Used to terminate a loop (`for`, `while`, `do-while`) or a `switch` statement.
* Control moves to the statement immediately after the loop or `switch`.

**Example:**

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        break;
    }
    System.out.println(i);
}
```

**Output:**

```
1
2
```

---

## 2. `continue` Statement

* Skips the current iteration of a loop.
* Execution continues with the next iteration.

**Example:**

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.println(i);
}
```

**Output:**

```
1
2
4
5
```

---

## 3. `return` Statement

* Exits a method.
* Can optionally return a value.

**Example:**

```java
public class Demo {
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(10, 20));
    }
}
```

**Output:**

```
30
```

---

## Difference Between `break`, `continue`, and `return`

| Statement  | Purpose                                         | Where Used      |
| ---------- | ----------------------------------------------- | --------------- |
| `break`    | Exits the loop or `switch` completely           | Loops, `switch` |
| `continue` | Skips the current loop iteration                | Loops           |
| `return`   | Exits the method and optionally returns a value | Methods         |

---

## Common Interview Questions

**Q: Can `break` be used outside a loop?**

> Yes, it can also be used inside a `switch` statement. It cannot be used arbitrarily outside a loop or `switch`.

**Q: Can `continue` be used in a `switch` statement?**

> No. `continue` is used only with loops.

**Q: Can a method have multiple `return` statements?**

> Yes. A method can have multiple `return` statements as long as the program logic ensures only one is executed during a method call.

---

## Interview-Ready Answer (30–45 seconds)

> "Jump statements in Java change the normal flow of execution. There are three jump statements: `break`, `continue`, and `return`. The `break` statement exits a loop or `switch` statement immediately. The `continue` statement skips the current iteration of a loop and proceeds with the next one. The `return` statement exits a method and can optionally return a value to the caller. These statements help control program flow efficiently."
