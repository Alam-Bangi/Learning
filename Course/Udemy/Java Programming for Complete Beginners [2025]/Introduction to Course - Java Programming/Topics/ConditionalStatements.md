# Conditional Statement
```
What are conditional statements in Java?
> "Conditional statements in Java are decision-making statements that allow a program to execute different blocks of code based on whether a condition evaluates to true or false. They help control the flow of execution."
```
```
Why do we use conditional statements?
> "We use conditional statements to make decisions in a program. Depending on whether a condition is true or false, different code blocks can be executed."
int age = 20;

if (age >= 18) {
    System.out.println("Eligible to vote");
}
```
```
What are the types of conditional statements in Java?
> There are five main conditional statements:
1. `if`
2. `if-else`
3. `if-else-if` ladder
4. Nested `if`
5. `switch`
```
```
Explain the `if` statement.
> "The `if` statement executes a block of code only if the specified condition is true."
if (condition) {
    // code
}

int marks = 80;
if (marks >= 35) {
    System.out.println("Pass");
}
```
```
Explain the `if-else` statement.
> "The `if-else` statement executes one block when the condition is true and another block when it is false."
int age = 16;
if (age >= 18) {
    System.out.println("Eligible");
} else {
    System.out.println("Not Eligible");
}
```
```
Explain the `if-else-if` ladder.
> "The `if-else-if` ladder is used to check multiple conditions. The first condition that evaluates to true is executed."
int marks = 75;

if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B");
} else if (marks >= 60) {
    System.out.println("Grade C");
} else {
    System.out.println("Fail");
}
```
```
What is a nested `if` statement?
> "A nested `if` is an `if` statement placed inside another `if` statement. It is used when multiple conditions depend on each other."
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("Can drive");
    }
}
```
```
Explain the `switch` statement.
> "The `switch` statement selects one block of code to execute from multiple choices based on the value of an expression."
int day = 2;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Invalid Day");
}
```
```
Difference between `if-else` and `switch`?
| if-else                                     | switch                              |
| ------------------------------------------- | ----------------------------------- |
| Works with any boolean condition            | Works with specific values          |
| Can evaluate ranges and complex expressions | Checks equality against case labels |
| Better for complex logic                    | Better for multiple fixed choices   |
```
```
What data types can be used in a `switch`?
> Modern Java supports:
* `byte`
* `short`
* `char`
* `int`
* `enum`
* `String`
* Wrapper classes (`Byte`, `Short`, `Integer`, `Character`)

`long`, `float`, `double`, and `boolean` cannot be used.
```
```
What is the purpose of `break` in `switch`?
> "`break` terminates the `switch` statement after a matching case executes. Without it, execution continues into the following cases."
```
```
What happens if `break` is omitted?
> Execution falls through to the next case until a `break` or the end of the `switch` is reached.
int n = 1;
switch (n) {
    case 1:
        System.out.println("One");
    case 2:
        System.out.println("Two");
}
Output
    One
    Two
```
```
What is the `default` case?
> "The `default` case executes when none of the case labels match the expression."
```
```
Can we use relational operators in `switch`?
> No.
This is invalid:
switch (age > 18)

Use `if-else` for relational conditions.
```
```
Which is faster: `if-else` or `switch`?
> "For multiple fixed-value comparisons, `switch` can be more efficient and easier to read. For complex conditions, ranges, or logical expressions, `if-else` is the better choice."
```
```
Can we use multiple conditions in an `if`?
> Yes, using logical operators.
if (age >= 18 && age <= 60) {
    System.out.println("Working Age");
}
```
```
What operators are commonly used in conditions?
>   * Relational: `>`, `<`, `>=`, `<=`, `==`, `!=`
    * Logical: `&&`, `||`, `!`
```
```
What is the ternary operator?
> "The ternary operator (`?:`) is a shorthand form of `if-else` used to choose between two expressions."
int age = 20;

String result = (age >= 18) ? "Adult" : "Minor";
```
```
Can `if` statements be nested?
> Yes.
if (condition1) {
    if (condition2) {
        // code
    }
}
```
```
Interview summary (30–45 seconds)

> "Conditional statements in Java are used to make decisions by executing different blocks of code based on whether conditions evaluate to true or false. Java provides `if`, `if-else`, `if-else-if`, nested `if`, and `switch` statements. I use `if-else` for complex conditions and ranges, and `switch` when comparing a single expression against multiple fixed values. Conditional statements are essential for controlling the flow of a program."
```
```
Rapid-fire interview questions

Q: What are conditional statements?
A: Decision-making statements that control program flow.

Q: How many conditional statements are there in Java?
A: Five: `if`, `if-else`, `if-else-if`, nested `if`, and `switch`.

Q: Which statement is best for ranges?
A: `if-else`.

Q: Which statement is best for multiple fixed values?
A: `switch`.

Q: What is the purpose of `break` in a `switch`?
A: It stops execution after the matched case.

Q: What happens without `break`?
A: Fall-through occurs, and subsequent cases execute.

Q: Which operator checks equality?
A: `==`.

Q: Which operator combines two conditions that must both be true?
A: `&&`.

Q: Which operator checks if at least one condition is true?
A: `||`.

Q: Which operator negates a boolean condition?
A: `!`.
```