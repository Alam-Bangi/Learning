A **Segmentation Fault (SegFault)** is a runtime error that occurs when a program tries to **access memory that it is not allowed to access**. On most operating systems, the OS immediately terminates the program to protect memory.

## Interview Definition

> **A segmentation fault occurs when a program attempts to read from or write to an invalid memory location, such as a NULL pointer, an uninitialized pointer, freed memory, or memory outside the bounds of an object.**

---

# Common Causes

## 1. Dereferencing a NULL pointer

```c
#include <stdio.h>

int main() {
    int *p = NULL;
    *p = 10;   // Segmentation fault
    return 0;
}
```

**Why?**

`NULL` points to no valid memory.

---

## 2. Dereferencing a wild (uninitialized) pointer

```c
int *p;
*p = 5;
```

`p` contains a garbage address.

---

## 3. Using a dangling pointer

```c
#include <stdlib.h>

int main() {
    int *p = malloc(sizeof(int));
    *p = 10;

    free(p);

    *p = 20;   // Undefined behavior; may cause a segmentation fault
}
```

After `free()`, the memory no longer belongs to your program.

---

## 4. Accessing beyond array bounds

```c
int arr[5];

arr[100] = 10;
```

This is **undefined behavior**. It **may** cause a segmentation fault, but it is not guaranteed—sometimes it appears to work, which is why it's dangerous.

---

## 5. Writing to a string literal

```c
char *str = "Hello";

str[0] = 'h';   // Often causes a segmentation fault
```

String literals are typically stored in read-only memory.

---

# Memory Diagram

```text
int x = 10;

Address      Value
1000         10

p = 1000

*p = 20
```

Valid access.

---

```text
p = NULL

Address
0x00000000

*p = 20
```

Invalid access → Segmentation fault.

---

# Why is it called "Segmentation" fault?

Modern operating systems divide a process's memory into regions (segments), such as:

* Code (text)
* Data
* Heap
* Stack

If your program accesses a memory region incorrectly or violates memory protection, the operating system raises a **segmentation fault**.

---

# How to Avoid It

* Initialize pointers.
* Check for `NULL` before dereferencing.
* Don't use memory after `free()`.
* Stay within array bounds.
* Don't write to string literals.
* Use debugging tools like `gdb` or memory checkers such as `valgrind` (on supported systems).

---

# Interview Answer (30 seconds)

> **A segmentation fault is a runtime error that occurs when a program accesses memory it is not permitted to access. Common causes include dereferencing a NULL pointer, using an uninitialized or dangling pointer, writing beyond array bounds, or attempting to modify read-only memory. The operating system detects the invalid memory access and terminates the program.**

### Common follow-up question

**Q: Is every invalid memory access guaranteed to cause a segmentation fault?**

**Answer:** No. In C, many invalid memory accesses result in **undefined behavior**. Sometimes the program crashes with a segmentation fault, sometimes it produces incorrect results, and sometimes it appears to work. You should never rely on any particular outcome.
