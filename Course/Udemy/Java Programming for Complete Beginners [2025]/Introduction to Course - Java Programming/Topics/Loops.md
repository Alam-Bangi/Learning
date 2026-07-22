# Loops

What is a loop in Java?
```
> A loop is a control statement that repeatedly executes a block of code until a specified condition becomes false.

Uses:
    Repeating tasks
    Processing arrays
    Iterating through collections
    Reducing duplicate code
```
What are the types of loops in Java?
```
Java has four types of loops:
    for loop
    while loop
    do-while loop
    Enhanced for loop (for-each)
```
What is a for loop?
```
> A for loop is used when the number of iterations is known.

Syntax:
for(initialization; condition; update) {
    // code
}

Example:
for(int i = 1; i <= 5; i++) {
    System.out.println(i);
}
Output:

1
2
3
4
5
```
What are the parts of a for loop?
```
A for loop has three parts:
    Initialization
    Condition
    Update (increment/decrement)
Example:
    for(int i = 0; i < 10; i++)

int i = 0 → Initialization
i < 10 → Condition
i++ → Update
```
What is a while loop?
```
A while loop executes as long as the condition is true. It is useful when the number of iterations is not known beforehand.

Syntax:
while(condition) {
    // code
}

Example:
int i = 1;
while(i <= 5) {
    System.out.println(i);
    i++;
}
```
What is a do-while loop?
```
A do-while loop executes the loop body at least once because the condition is checked after the loop body.

Syntax:
do {
    // code
} while(condition);

Example:
int i = 1;
do {
    System.out.println(i);
    i++;
} while(i <= 5);
```
What is an enhanced for loop (for-each)?
```
The enhanced for loop is used to iterate through arrays or collections without using an index.
Syntax:
for(dataType variable : collection) {
    // code
}

Example:
int[] numbers = {10, 20, 30};
for(int n : numbers) {
    System.out.println(n);
}
```
Difference between for and while loops?
```
for Loop	                                    while Loop
Used when the number of iterations is known	    Used when the number of iterations is unknown
Initialization, condition, and update are in 	Initialization and update are usually separate
one statement
More compact	                                More flexible
```
Difference between while and do-while?
```
while	                            do-while
Condition checked before execution	Condition checked after execution
May execute zero times	            Executes at least once
```
Which loop executes at least once?
```
The do-while loop.
```
What is an infinite loop?
```
A loop that never ends because its condition is always true.

Example:
while(true) {
    System.out.println("Hello");
}
```
How can you stop an infinite loop?
```
Use:
    break
    A condition that eventually becomes false
    return (inside a method)
```
What is the break statement?
```
break immediately exits the loop.

Example:
for(int i = 1; i <= 10; i++) {
    if(i == 5)
        break;
    System.out.println(i);
}
Output:

1
2
3
4
```
What is the continue statement?
```
continue skips the current iteration and moves to the next iteration.

Example:
for(int i = 1; i <= 5; i++) {
    if(i == 3)
        continue;
    System.out.println(i);
}
Output:

1
2
4
5
```
Difference between break and continue?
```
break	        continue
Exits the loop	Skips the current iteration
Loop ends	    Loop continues
```
Can we use nested loops?
```
Yes. A loop inside another loop is called a nested loop.

Example:
for(int i = 1; i <= 3; i++) {
    for(int j = 1; j <= 2; j++) {
        System.out.println(i + " " + j);
    }
}
```
What is the use of nested loops?
```
They are commonly used for:
    Pattern printing
    Matrix operations
    Comparing elements
    Multi-dimensional arrays
```
Can we write a for loop without initialization?
```
Yes.

Example:
int i = 0;
for(; i < 5; i++) {
    System.out.println(i);
}
```
Can we omit the condition in a for loop?
```
Yes.

Example:
for(;;) {
    // Infinite loop
}
```
Can we omit the update statement?
```
Yes.

Example:
int i = 1;
for(; i <= 5;) {
    System.out.println(i);
    i++;
}
```
Can we have multiple variables in a for loop?
```
Yes.

Example:
for(int i = 0, j = 5; i < j; i++, j--) {
    System.out.println(i + " " + j);
}
```
Which loop is best for arrays?
```
The enhanced for loop (for-each) is often the simplest choice when you only need to read elements.

Example:
String[] names = {"A", "B", "C"};
for(String name : names) {
    System.out.println(name);
}
```
Can we modify an array using a for-each loop?
```
No. Changing the loop variable does not change the array elements.

Example:
int[] arr = {1, 2, 3};
for(int x : arr) {
    x = x * 2;
}
The array remains {1, 2, 3}.
```
Which loop is faster?
```
There is usually no significant performance difference. Choose the loop that makes your code the clearest:
    for when you need an index
    while when the number of iterations is unknown
    do-while when the body must execute at least once
    Enhanced for for simple traversal
```
What is loop control?
```
Loop control statements change the normal flow of a loop:
    break → exits the loop
    continue → skips the current iteration
```
Can we use loops with strings?
```
Yes.

Example:
String s = "Java";
for(int i = 0; i < s.length(); i++) {
    System.out.println(s.charAt(i));
}
```
Can loops be nested infinitely?
```
Yes, Java allows multiple levels of nesting, but deeply nested loops can make code harder to read and maintain.
```
What are common uses of loops?
```
Printing patterns
Traversing arrays
Searching elements
Sorting algorithms
Calculating sums or averages
Reading input repeatedly
Frequently Asked Coding Questions
Print numbers from 1 to 100.
Print even and odd numbers.
Find the sum of the first n numbers.
Calculate the factorial of a number.
Reverse a number.
Check whether a number is a palindrome.
Generate the Fibonacci series.
Print multiplication tables.
Print star (*) patterns.
Find the largest number in an array.
```
Interview Tip
```
"A loop is a control structure that repeatedly executes a block of code while a condition is true. Java provides four types of loops: for, while, do-while, and the enhanced for loop. A for loop is best when the number of iterations is known, a while loop is useful when it isn't known, a do-while loop guarantees at least one execution, and the enhanced for loop is ideal for iterating through arrays or collections. Loop control statements like break and continue allow us to alter the normal flow of execution."
```