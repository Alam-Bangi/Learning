# Data Type
```
What are Data Types in Java?
> "A data type in Java specifies the type of data that a variable can store, the amount of memory allocated, the range of values it can hold, and the operations that can be performed on it. Java is a strongly typed language, so every variable must be declared with a data type before it is used."
```
```
Why do we use data types?
> "Data types help Java allocate the correct amount of memory, ensure type safety, improve performance, and prevent invalid operations."
```
```
How many types of data types are there in Java?
> Java has two categories of data types:
    1. Primitive Data Types
    2. Non-Primitive (Reference) Data Types
```
```
What are primitive data types?
> "Primitive data types are predefined by Java. They store simple values directly in memory and are faster because they don't involve objects."

Java has 8 primitive data types:
| Data Type | Size          | Default Value | Example                          |
| --------- | ------------- | ------------- | -------------------------------- |
| byte      | 1 byte        | 0             | `byte age = 20;`                 |
| short     | 2 bytes       | 0             | `short salary = 20000;`          |
| int       | 4 bytes       | 0             | `int marks = 95;`                |
| long      | 8 bytes       | 0L            | `long population = 8000000000L;` |
| float     | 4 bytes       | 0.0f          | `float price = 99.5f;`           |
| double    | 8 bytes       | 0.0           | `double pi = 3.14159;`           |
| char      | 2 bytes       | '\u0000'      | `char grade = 'A';`              |
| boolean   | JVM-dependent | false         | `boolean active = true;`         |
```
```
What are non-primitive data types?
> "Non-primitive data types store references to objects rather than the actual values. They are created by programmers or provided by Java libraries."

Examples:
* String
* Arrays
* Classes
* Objects
* Interfaces
* Enums

String name = "John";
int[] numbers = {1, 2, 3};
```
```
Difference between primitive and non-primitive data types?
| Primitive                          | Non-Primitive                          |
| ---------------------------------- | -------------------------------------- |
| Stores actual value                | Stores object reference                |
| Predefined by Java                 | Created by Java or programmer          |
| Fixed memory size                  | Variable size                          |
| Cannot be `null`                   | Can be `null`                          |
| Faster                             | Slightly slower due to object handling |
| Examples: `int`, `char`, `boolean` | Examples: `String`, `Array`, `Object`  |
```
```
Why is `String` not a primitive data type?
> "Because `String` is a class in Java. It stores a reference to a `String` object and provides many built-in methods like `length()`, `substring()`, and `toUpperCase()`."
```
```
Which data type is used for whole numbers?
>   * `byte`
    * `short`
    * `int`
    * `long`

The most commonly used is `int`.
```
```
Which data type is used for decimal numbers?
>   * `float`
    * `double`

`double` is preferred because it provides greater precision.
```
```
Difference between `float` and `double`?
| float               | double           |
| ------------------- | ---------------- |
| 4 bytes             | 8 bytes          |
| Lower precision     | Higher precision |
| Suffix `f` required | No suffix needed |

Example:
float price = 10.5f;
double pi = 3.1415926535;
```
```
Difference between `byte`, `short`, `int`, and `long`?
| Type  | Size    | Typical Use              |
| ----- | ------- | ------------------------ |
| byte  | 1 byte  | Small integers           |
| short | 2 bytes | Memory-sensitive cases   |
| int   | 4 bytes | General-purpose integers |
| long  | 8 bytes | Very large integers      |
```
```
Why is `int` more commonly used than `byte`?
> "`int` is the default integer type in Java. It provides a wider range, and modern processors are optimized to handle `int` efficiently."
```
```
What is the default data type for integer literals?
> `int`
int x = 100;
```
```
What is the default data type for decimal literals?
> `double`
double d = 10.5;
```
```
Why do we use `L` with `long`?
> Because integer literals are treated as `int` by default.
long population = 8000000000L;
```
```
Why do we use `f` with `float`?
> Because decimal literals are treated as `double` by default.
float price = 10.5f;
```
```
Can we assign an `int` to a `byte`?
> Not directly, because `byte` has a smaller range.
int x = 100;
byte b = (byte) x;

This uses explicit type casting.
```
```
What is type casting?
> "Type casting is converting one data type into another."

* Widening (automatic)
int x = 10;
double y = x;

* Narrowing (manual)
double d = 20.5;
int x = (int) d;
```
```
What is the range of each primitive type?
| Type    | Range                            |
| ------- | -------------------------------- |
| byte    | -128 to 127                      |
| short   | -32,768 to 32,767                |
| int     | -2³¹ to 2³¹−1                    |
| long    | -2⁶³ to 2⁶³−1                    |
| float   | ~7 decimal digits precision      |
| double  | ~15–16 decimal digits precision  |
| char    | 0 to 65,535 (Unicode code units) |
| boolean | `true` or `false`                |
```
```
Why is Java called a strongly typed language?
> "Because every variable must have a declared data type, and Java checks type compatibility at compile time, reducing many programming errors."
```
```
What are wrapper classes?
> Wrapper classes convert primitive types into objects.
| Primitive | Wrapper   |
| --------- | --------- |
| byte      | Byte      |
| short     | Short     |
| int       | Integer   |
| long      | Long      |
| float     | Float     |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |
```
```
What is autoboxing?
> Autoboxing automatically converts a primitive value into its wrapper object.
Integer num = 10;
```
```
What is unboxing?
> Unboxing automatically converts a wrapper object into its primitive value.
Integer num = 10;
int value = num;
```
```
What is the difference between `char` and `String`?
| char                 | String                     |
| -------------------- | -------------------------- |
| Stores one character | Stores multiple characters |
| Primitive            | Reference type             |
| Uses single quotes   | Uses double quotes         |

Example:
char grade = 'A';
String name = "John";
```
Interview summary (30–45 seconds)

> "Data types in Java define the type of data a variable can store, the memory allocated, and the operations allowed. Java has two categories of data types: primitive and non-primitive. Primitive data types include `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`, which store values directly. Non-primitive types such as `String`, arrays, and classes store references to objects. Choosing the appropriate data type helps optimize memory usage, improves performance, and ensures type safety."

```
#Rapid-fire interview questions

Q: How many primitive data types are there in Java?
A: Eight.

Q: Which data type is used most often for integers?
A: `int`.

Q: Which data type provides higher precision for decimals?
A: `double`.

Q: Is `String` a primitive data type?
A: No, it is a class (reference type).

Q: Which primitive data type stores only `true` or `false`?
A: `boolean`.

Q: Why does `float` require an `f` suffix?
A: Because decimal literals are `double` by default.

Q: Which data type stores a single character?
A: `char`.

Q: Which data type is used for very large integers?
A: `long`.

Q: What is type casting?
A: Converting one data type to another.

Q: Why is Java strongly typed?
A: Because every variable must have a declared data type, and Java enforces type compatibility at compile time.
```