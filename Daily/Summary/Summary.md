```
OOP:-
- Name of Object of class - Instance
- Behaviour ad State of object - Instance Variable

- Encapsulation - Only the class should have access to its variables , if other class wants then it can through object/instance of class

- Access Modifiers - Private, Public, Protected

- Abstraction - Its process of hiding internal implementations and showing essential functionality to user.
```

```
- Primitive Data Types
    - Integer - byte, short, int, long
    - Floating point - float, double
    - Boolean - boolean
    - Character - char

- Wrapper Classes - Converts primitive data types to Objects
    - Byte
    - Short
    - Integer
    - Long
    - Float
    - Double
    - Boolean
    - Character
- Needed for Collections (e.g ArrayList<Integer>)
- Required for Object-based APIs
- Support null values
- Provide utility methods (parsing, comparison)
- Autoboxing: primitive → object (Integer a = 10)
- Unboxing: object → primitive (int b = a)
- Wrapper objects are immutable
- Caching - Integer catches vallues from -128 to 127
- Parsing Methods
    - int x = Integer.parseInt("123");
    - double y = Double.parseDouble("12.5");
- parseInt() → returns primitive
- valueOf() → returns object
- Slower than primitives due to:
    - object creation
    - memory overhead


- By default floating point value(decimal value) is double

- BigDecimal is a class.
- BigDecimal is immutable.
- int i =1 . then to add it to BigDecimal - number.add(new BigDecimal(i)) Use same for multiply and divide.
- We can perform operations  on BigDecimal value with BigDecimal value only

- Logical Operators - &&(AND) , ||(OR) , ^(XOR) , !(NOT)
- Short Circuit Operator - They are used in boolean expressions and stop evaluating the rest of the expression as soon as the outcome can be determined, which optimizes performance and prevents runtime errors.
``` 

```
- Switch 
    - byte, short, int, char, String, enum (Allowed)
    - float, double, long (Not Allowed)
    - fall-through - if break missing then execution continues for each case until break is there or cases end.
    - can't use multiple conditions

- Operators (=)- Assignment, (==)- comparison

- Conditon can't be non-boolean

- |(Bitwise OR)
    - Evaluates both sides
    - Uses numbers and boolean

- ||(Logical OR)
    - Short-circuit (stops evaluating further conditions as soon as the result is determined.)
    - Uses boolean only

- &(Bitwise AND)
    - Evaluates both sides
    - Uses numbers and boolean

- &&(Logical AND)
    - Short-circuit
    - Uses boolean only

- &&, || → short-circuit
- &, | → always evaluate both sides
- break → stops switch execution
- default → can be anywhere
- case → must use constants
```

```
- Infinite loop? Loop that never ends (condition always true).
- Entry: for, while (check before execution)
-Exit: do-while (check after execution)
- Can loop run 0 times? Yes (for/while if condition is false initially)
- Loop without body? Yes (used in rare cases like delays).
- Multiple variables in loop? Yes
- Semicolon after loop? Loop runs but does nothing; block runs once.

- break → exits loop immediately
- continue → skips current iteration
- break vs return → break exits loop, return exits method
- Labeled break → breaks outer loop
```

```
Reference variable - name of object as it refers to object

- String - immutable sequence of characters.
    - Java.lang package
    - once created, can't be changed for thread safety, security, string pool optimization
- String Constant Pool (SCP) - Special memory area in heap
    - stores unique string literals.
- (==) → compares reference
- (.equals()) → compares content
- intern() - moves string to string pool
- String is final - to prevent modification and ensure security and consistency.
- String s1 = "abc" (SCP)
- String s1 = new String("abc") (SCP+HEAP)
- String concatenation - Uses StringBuilder 
- trim() → removes basic spaces
- strip() → removes Unicode whitespace
- String can be null
- (.equalsIgnoreCase) - Ignores case of string and check if same
- HashCode of string is based on characters and its positions
- isEmpty() → length == 0
- isBlank() → empty or only whitespace
- String to int - int num = Integer.parseInt("123");
- Int to String - String s = String.valueOf(123);
- Uses StringBuilder to avoid creating multiple objects.
- (+) → more readable
- (concat()) → method-based
- String - stored as char[] (before java9)
    - stored as byte[] (after java9)
```

```
Arrays- 
    - Arrays.fill(arrname, value)
    - Arrays.equals(arr1,arr2)
    - Arrays.toString(arrname)
    - Arrays.sort(arrname)

An array is a fixed-size data structure that stores elements of the same type in contiguous memory locations, allowing fast access using an index.

🔹 Key Points to Mention
-Fast access: O(1) using index
-Fixed size: Cannot grow or shrink after creation
-Homogeneous data: Same data type only
-Memory efficient: Stored in continuous memory
🔹 Time Complexity
-Access → O(1)
-Search → O(n)
-Insertion/Deletion → O(n) (due to shifting)
🔹 Advantages
-Very fast access
-Simple and easy to use
-Cache-friendly (better performance)
🔹 Disadvantages
-Fixed size
-Costly insert/delete
-Possible memory wastage
🔹 Common Techniques (Important 🔥)
-Two Pointer → pairs, reversing
-Sliding Window → subarray problems
-Prefix Sum → range queries
-Hashing → fast lookup
🔹 When to Use
-When size is known
-When performance is critical
-When frequent access is required

🧠 One-Line Interview Answer
“Array is a fixed-size, index-based data structure stored in contiguous memory, providing O(1) access but O(n) insertion and deletion, and is best used when size is known and fast access is needed.”
```

```
- ArrayList
ArrayList is a dynamic array from the Java Collection Framework that can grow and shrink automatically, and stores elements in ordered form.

🔹 Key Points to Mention
-Dynamic size (resizable)
-Maintains insertion order
-Stores only objects (uses wrapper classes for primitives)
-Backed by an internal array
🔹 Time Complexity
-Access → O(1)
-Add (end) → O(1) amortized
-Insert/Delete (middle) → O(n)
-Search → O(n)
🔹 Internal Working (Very Important 🔥)
-Default capacity starts at 10
-When full → creates a new array (~1.5x bigger)
-Copies old elements to new array
🔹 Advantages
-Flexible size
-Easy to use (built-in methods)
-Good for frequent read operations
🔹 Disadvantages
-Slower than arrays (due to resizing & object handling)
-Extra memory usage
-Not thread-safe
🔹 When to Use
-When size is unknown or changes frequently
-When you need easy insertion at the end
-When working with collections of objects

🧠 One-Line Interview Answer
“ArrayList is a resizable array in Java that provides dynamic sizing with O(1) access and amortized O(1) insertion, but has O(n) cost for insertions and deletions due to element shifting.”
``` 
```
🔹 What is List?
    Part of Java Collections Framework
    An ordered collection
    Allows duplicates
    Supports index-based access
    👉 Keywords to remember:
    Order + Duplicates + Index

🔹 Common Implementations
    ArrayList → Default choice
    LinkedList → Insert/delete use
    Vector → Legacy
    CopyOnWriteArrayList → Thread-safe

🔹 When to Use What?
    ArrayList → Fast reads (most common)
    LinkedList → Frequent insert/delete
    CopyOnWriteArrayList → Multithreading (read-heavy)
👉 Interview truth:
    👉 Use ArrayList in 90% cases

🔹 Core Features
    Maintains insertion order
    Allows nulls (except immutable lists)
    Dynamic size
    Supports indexing

🔹 Important Methods (concept)
    Add element
    Get element
    Remove element
    Replace element
    Check size
    Search element
    👉 These are enough for most problems

🔹 Time Complexity (ArrayList)
    Access → O(1)
    Add → O(1) (amortized)
    Remove → O(n)
    Search → O(n)

🔹 Key Concepts
    1. Size vs Capacity
        Size → elements present
        Capacity → internal array size
    2. Resizing
        ArrayList grows when full
        Causes occasional slow operation
    3. Autoboxing
        Primitive → Object
        Adds memory + performance cost
    4. Equality
        Same elements + same order

🔹 Important Differences
    List vs Set
    List → allows duplicates
    Set → no duplicates
    List vs Array
    List → dynamic
    Array → fixed

🔹 Thread Safety
    List is not thread-safe by default
    Use:
    Synchronized list
    CopyOnWriteArrayList

🔹 Most Asked Tricky Points
    1. remove confusion
        remove(index) vs remove(value)

    👉 Common interview trap

    2. Arrays.asList()
        Fixed-size list
        Cannot add/remove
    3. List.of()
        Immutable list
        No null allowed
    4. subList()
        Returns view, not copy
        Affects original list
    5. Fail-Fast
        Modifying during iteration → exception

🔹 Exceptions to Remember
    IndexOutOfBoundsException
    ConcurrentModificationException
    UnsupportedOperationException

🔹 Performance Insights (Important)
    ArrayList is usually faster than LinkedList
    LinkedList has high memory overhead
    contains() is slow (O(n))

🔹 Best Practices
    Use List, not specific implementation in method return
    Prefer ArrayList
    Avoid modifying list during iteration
    Choose correct structure based on use-case

🧠 Final Memory Trick
    👉 LIST = O D I
    O → Ordered
    D → Duplicates allowed
    I → Indexed
```