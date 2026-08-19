1. What is an Exception?

**An exception is an unexpected event that occurs during the execution of a program and disturbs the normal flow of the program.**

For example:

int a = 10;
int b = 0;

int result = a / b;

Here, dividing by zero causes an ArithmeticException.

Interview answer

>**“An exception in Java is an unwanted or unexpected event that occurs during program execution and disrupts the normal flow of the application. Java provides exception-handling mechanisms such as try, catch, finally, throw, and throws to handle these situations.”**

2. Why Do Exceptions Occur?

Exceptions can occur for different reasons, such as:

Invalid input
int number = Integer.parseInt("abc");

This causes:
NumberFormatException

Division by zero
int result = 10 / 0;

This causes:
ArithmeticException

Accessing a null object
String name = null;
System.out.println(name.length());

This causes:
NullPointerException

Accessing an invalid array index
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);

This causes:
ArrayIndexOutOfBoundsException

### Interview answer

>“Exceptions occur when something unexpected happens during program execution, such as invalid input, dividing by zero, accessing a null object, accessing an invalid array index, or failing to find a file.”

3. Difference Between Error and Exception

This is a very common interview question.
```
Exception	                                                       Error
Usually represents problem that an application may handle 	     Usually represents a serious JVM/system problem
Can often be recovered from	                                   Generally difficult or inappropriate to recover from
Examples: IOException, SQLException, NullPointerException 	     Examples: OutOfMemoryError, StackOverflowError
Usually related to application conditions	                    Usually related to JVM/system conditions
```
Example
```
Exception
    ↓
Application can potentially handle it
```
```
Error
    ↓
Serious JVM/system problem
```
Interview answer

>“An exception generally represents a condition that an application can potentially handle, whereas an error usually represents a serious problem with the JVM or system that an application should not normally try to recover from.”

4. Compile-Time vs Runtime Problems

This distinction is important.

Compile-time problem
>A problem detected before the program runs, during compilation.

Example:
System.out.println(name);

if name has not been declared.
The program does not compile.

Runtime problem
>The program successfully compiles, but something goes wrong while it is running.

Example:

int a = 10;
int b = 0;

System.out.println(a / b);

This compiles successfully, but when executed:
```
ArithmeticException

Simple comparison
Compile time
     ↓
Code is being compiled
     ↓
Compiler finds problem
     ↓
Program doesn't run


Runtime
     ↓
Program has compiled
     ↓
Program starts running
     ↓
Exception/problem occurs
```
```
“An exception is an unexpected event that occurs during program execution and disrupts the normal flow of the application. Exceptions can occur because of invalid input, division by zero, null references, invalid array indexes, or problems while accessing resources.

An exception is different from an error. Exceptions are generally conditions that an application can handle, while errors usually indicate serious JVM or system-level problems, such as OutOfMemoryError or StackOverflowError.

Compile-time problems are detected by the compiler before the program runs, whereas runtime problems occur after the program has successfully compiled and started executing.”
```
---
# Java Exception Handling – Types

## 1. Checked Exceptions

These are checked by the **compiler at compile time**.

You must either:

- Handle them using `try-catch`
- Declare them using `throws`

### Examples

- `IOException`
- `SQLException`
- `FileNotFoundException`
- `ClassNotFoundException`

### Example

```java
try {
    FileReader file = new FileReader("test.txt");
} catch (FileNotFoundException e) {
    System.out.println("File not found");
}
```

Interview Answer

`"Checked exceptions are exceptions that the compiler forces us to handle or declare. They generally represent conditions that an application can reasonably recover from."`

## 2. Unchecked Exceptions

These occur at runtime. The compiler does not force us to handle them.

They are subclasses of RuntimeException.

Examples
- `NullPointerException`
- `ArithmeticException`
- `ArrayIndexOutOfBoundsException`
- `NumberFormatException`
- `IllegalArgumentException`

Example
```
int a = 10;
int b = 0;

int result = a / b;  // ArithmeticException`
```

Interview Answer

`"Unchecked exceptions occur at runtime and are usually caused by programming errors or invalid input."`

## 3. Errors

Technically, Java's Throwable hierarchy also contains Errors.

Errors are different from exceptions and generally indicate serious problems that an application should not normally try to recover from.

Examples
- `OutOfMemoryError`
- `StackOverflowError`

Interview Answer

`"Errors usually indicate serious JVM or system-level problems, so we generally don't handle them like normal exceptions."`

Easy Hierarchy to Remember
Throwable
├── Exception
│   ├── Checked Exceptions
│   └── RuntimeException
│       └── Unchecked Exceptions
│
└── Error

Best Short Interview Answer

>"In Java, we mainly classify exceptions as checked and unchecked exceptions. Checked exceptions are verified at compile time and must be handled or declared, while unchecked exceptions occur at runtime and don't require mandatory handling. Apart from exceptions, Java also has Errors, which usually represent serious JVM-level problems."


```
Throwable
├── Error          ← catch(Exception) does NOT catch these
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
└── Exception      ← catch(Exception) catches these
    ├── RuntimeException
    │   ├── NullPointerException
    │   └── ArithmeticException
    └── IOException
        └── FileNotFoundException
```