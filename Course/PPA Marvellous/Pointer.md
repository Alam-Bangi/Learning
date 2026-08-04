
# 1. What is a pointer?

A pointer is a variable that stores the memory address of another variable.

```c
int x = 10;
int *p = &x;
```

Here, `p` stores the address of `x`.

---

# 2. Why do we use pointers?

* Dynamic memory allocation
* Pass arguments efficiently
* Modify variables inside functions
* Arrays and strings
* Linked lists, trees, graphs
* Function pointers
* Operating systems and embedded programming

---

# 3. Difference between variable and pointer?

| Variable            | Pointer        |
| ------------------- | -------------- |
| Stores value        | Stores address |
| Example: `int x=5;` | `int *p=&x;`   |

---

# 4. What does `&` mean?

Returns address.

```c
int x=5;

printf("%p",&x);
```

---

# 5. What does `*` mean?

Two meanings.

Declaration

```c
int *p;
```

Dereference

```c
printf("%d",*p);
```

---

# 6. What is dereferencing?

Accessing value through pointer.

```c
*p
```

---

# 7. What is NULL pointer?

```c
int *p=NULL;
```

Pointer points to nothing.

---

# 8. Difference between NULL, Wild and Dangling pointer?

### NULL Pointer

Points nowhere.

```c
int *p=NULL;
```

### Wild Pointer

Not initialized.

```c
int *p;
```

### Dangling Pointer

Points to deleted/out-of-scope memory.

```c
int *p;

{
   int x=10;
   p=&x;
}
```

---

# 9. What happens if NULL is dereferenced?

Undefined behavior (often a segmentation fault).

---

# 10. What is void pointer?

Generic pointer.

```c
void *p;
```

Can store address of any type.

Need type cast before dereferencing.

---

# 11. Can void pointer be dereferenced?

No.

Need cast.

```c
*(int*)p;
```

---

# 12. Pointer arithmetic?

```c
p++
```

Moves pointer by

```
sizeof(data type)
```

---

# 13. Can we add two pointers?

No.

```c
p+q
```

Invalid.

---

# 14. Can we subtract pointers?

Yes.

```c
p2-p1
```

Returns number of elements between them (when they point into the same array).

---

# 15. Why pointer arithmetic depends on datatype?

Compiler knows object size.

```
int → 4 bytes

char →1 byte

double→8 bytes
```

---

# 16. Difference between

```c
int *p;
```

and

```c
int p;
```

Pointer stores address.

Integer stores value.

---

# 17. Difference between

```c
*p
```

and

```c
&p
```

```
*p -> value

&p -> address
```

---

# 18. Difference between array and pointer?

Array owns memory.

Pointer stores address.

---

# 19. Why does array name behave like pointer?

Array name decays into pointer to first element in most expressions.

---

# 20. Why can't we do

```c
arr++;
```

Array name is not modifiable.

---

# 21. Difference

```c
sizeof(arr)
```

vs

```c
sizeof(pointer)
```

Array

```
total bytes
```

Pointer

```
pointer size
```

---

# 22. Why does this work?

```c
arr[3]
```

Compiler converts to

```c
*(arr+3)
```

---

# 23. Why does

```c
3[arr]
```

work?

Because

```c
arr[3]
```

=

```c
*(arr+3)
```

=

```c
*(3+arr)
```

---

# 24. What is pointer to pointer?

```c
int **pp;
```

Stores address of another pointer.

---

# 25. Triple pointer?

```c
int ***ppp;
```

Stores address of pointer to pointer.

---

# 26. Pointer to array?

```c
int (*p)[10];
```

Points to entire array.

---

# 27. Array of pointers?

```c
int *p[10];
```

Array containing pointers.

---

# 28. Difference

```c
int (*p)[10];
```

vs

```c
int *p[10];
```

Classic interview question.

Parentheses change meaning.

---

# 29. Function pointer?

```c
int (*fp)(int,int);
```

Stores address of function.

---

# 30. Why use function pointers?

* Callback functions
* Menu-driven programs
* Interrupt handlers
* Event handling

---

# 31. Function returning pointer?

```c
int *fun();
```

---

# 32. Pointer to function returning pointer?

```c
int *(*fp)();
```

Advanced interview question.

---

# 33. Can pointer point to itself?

Yes.

Rarely useful.

---

# 34. Can pointer store float address?

```c
float x;

float *p=&x;
```

Yes.

---

# 35. Can int pointer store float address?

```c
int *p=(int*)&f;
```

Possible with a cast, but reading through an incompatible pointer type can invoke undefined behavior because of C's aliasing rules.

---

# 36. Why do we cast malloc?

In C

```c
int *p=malloc(sizeof(int));
```

Casting is not required if `<stdlib.h>` is included.

---

# 37. Difference between malloc and calloc?

malloc

* Doesn't initialize memory

calloc

* Initializes memory to zero

---

# 38. What is realloc?

Changes allocated memory size.

---

# 39. What is memory leak?

Allocated memory not freed.

---

# 40. What is double free?

Calling

```c
free(p);
free(p);
```

Undefined behavior.

---

# 41. Why set pointer NULL after free?

Avoid accidental reuse of a dangling pointer.

```c
free(p);
p=NULL;
```

---

# 42. What is pointer aliasing?

Two pointers point to same memory.

---

# 43. What is const pointer?

```c
int *const p=&x;
```

Pointer cannot change.

Data can.

---

# 44. Pointer to const?

```c
const int *p;
```

Cannot modify data through pointer.

Pointer can change.

---

# 45. Constant pointer to constant?

```c
const int *const p;
```

Neither pointer nor data changes through `p`.

---

# 46. What is segmentation fault?

Accessing invalid memory.

Examples

* NULL pointer
* Wild pointer
* Dangling pointer
* Array out of bounds

---

# 47. Difference between pass by value and pass by reference?

C passes arguments by value. To let a function modify a caller's variable, you pass its address (a pointer).

```c
void increment(int *p) {
    (*p)++;
}
```

---

# 48. What is a generic pointer?

`void *`

Can point to any datatype.

---

# 49. What is pointer comparison?

```c
if(p==q)
```

Checks addresses.

---

# 50. Explain pointers in one sentence.

> **A pointer is a variable that stores the memory address of another object, allowing indirect access and manipulation of that object.**

---

# Coding Questions Frequently Asked in Interviews

1. Swap two numbers using pointers.
2. Reverse an array using pointers.
3. Reverse a string using pointers.
4. Find string length without `strlen()`.
5. Copy one string to another using pointers.
6. Compare two strings using pointers.
7. Find the largest element using pointers.
8. Traverse an array using pointer arithmetic.
9. Implement `strcpy()` using pointers.
10. Implement `strcmp()` using pointers.
11. Allocate an array using `malloc()`.
12. Create a linked list using pointers.
13. Reverse a linked list.
14. Detect a memory leak in a code snippet.
15. Explain the output of pointer-based code.

---

## Tip for interviews

For most entry-level C interviews, interviewers are less interested in memorized definitions than in whether you can **trace pointer code correctly**. Practice questions like:

```c
int x = 10;
int *p = &x;
int **pp = &p;

printf("%d %d\n", *p, **pp);

(*p)++;
printf("%d\n", x);
```
