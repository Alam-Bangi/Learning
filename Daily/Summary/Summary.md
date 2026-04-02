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

- Wrapper Classes
    - Byte
    - Short
    - Integer
    - Long
    - Float
    - Double
    - Boolean
    - Character

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