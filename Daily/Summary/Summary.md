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
