# Variable
```
> A variable is a named memory location used to store data. Every variable has a data type, a name, and a value. The data type determines what kind of data the variable can hold.
Example
int age = 25;
```
```
Why do we use variables?
> Variables are used to store and manipulate data during program execution. They make programs dynamic because values can change while the program is running.
```
```
What is the syntax for declaring a variable?
> dataType variableName;
Example
int age;
```
```
What is variable initialization?
> Initialization means assigning a value to a variable.
int age = 25;
```
```
What is variable declaration?
> Declaration means telling the compiler the variable's name and data type.
int age;
```
```
Can we declare and initialize together?
> Yes.
int age = 25;
```
```
What are the types of variables in Java?
> There are three types:
1. Local Variable
2. Instance Variable
3. Static Variable
```
```
What is a local variable?
> A local variable is declared inside a method, constructor, or block. It is accessible only within that block and exists only while the block is executing.

Example
void display() {
    int x = 10;
}
```
```
What is an instance variable?
> An instance variable is declared inside a class but outside any method. Each object gets its own copy.

Example
class Student {
    int rollNo;
}
```
```
What is a static variable?
> A static variable belongs to the class rather than an object. It is shared among all objects.

Example
class Student {
    static String college = "ABC";
}
```
```
Difference between Local, Instance and Static Variables?
| Local                          | Instance                   | Static                    |
| ------------------------------ | -------------------------- | ------------------------- |
| Inside method                  | Inside class               | Inside class with static  |
| No default value               | Gets default value         | Gets default value        |
| Exists during method execution | Exists until object exists | Exists until program ends |
| Cannot use access modifiers    | Can use access modifiers   | Can use access modifiers  |
```
```
What are default values of variables?
| Data Type | Default Value |
| --------- | ------------- |
| byte      | 0             |
| short     | 0             |
| int       | 0             |
| long      | 0L            |
| float     | 0.0f          |
| double    | 0.0           |
| char      | '\u0000'      |
| boolean   | false         |
| Object    | null          |

Note: Local variables do not receive default values.
```
```
Why must local variables be initialized?
> Because Java does not assign default values to local variables.

Wrong
int x;
System.out.println(x);

Correct
int x = 10;
System.out.println(x);
```
```
Can variable names start with numbers?
> No.

Wrong
int 1age;

Correct
int age1;
```
```
What are the rules for naming variables?
>   * Cannot start with a digit.
    * Can start with `_` or `$`.
    * Cannot use keywords.
    * Case-sensitive.
    * No spaces.

Examples
age
studentName
_marks
$salary
```
```
What is variable scope?
> Scope defines where a variable can be accessed.

Example
void test() {
    int x = 10;
}
Here `x` is accessible only inside `test()`.
```
```
What is variable lifetime?
> Lifetime is the duration a variable exists in memory.
    * Local → Until method finishes
    * Instance → Until object is destroyed
    * Static → Until program ends
```
```
Can two variables have the same name?
> Yes, if they are in different scopes.
int x = 10;

void display() {
    int x = 20;
}
```
```
Can we change the value of a variable?
> Yes.
int age = 20;
age = 30;
```
```
What is a constant variable?
>  A constant is declared using the `final` keyword. Its value cannot be changed after initialization.
final double PI = 3.14;
```
```
Difference between final and normal variable?
> Normal variable
int x = 10;
x = 20;

Final variable
final int x = 10;
x = 20; // Compile-time error
```
```
What is type inference in Java?
> Java allows local variables to use the `var` keyword (Java 10+). The compiler infers the type from the assigned value.
var name = "John";
var age = 25;
```
```
Can `var` be used for instance variables?
> No.
`var` is allowed only for local variables.
```
```
What is variable shadowing?
> When a local variable has the same name as an instance variable, the local variable hides (or "shadows") the instance variable.
class Test {
    int x = 10;

    void show() {
        int x = 20;
        System.out.println(x);      // 20
        System.out.println(this.x); // 10
    }
}
```
```
What is variable hiding?
> Variable hiding occurs when a subclass declares a variable with the same name as one in its superclass.
class A {
    int x = 10;
}
class B extends A {
    int x = 20;
}
```
```
What is the difference between declaration and definition?
> In Java, declaration and definition usually happen together. When you declare a variable, memory is allocated for it.
Example
int age;
```
```
Can variables store objects?
> Yes.
Student s = new Student();
Here, `s` stores a reference to the `Student` object.
```
```
What is a reference variable?
> A reference variable stores the memory address (reference) of an object, not the object itself.
String name = "Java";
`name` is a reference variable.
```
```
Difference between primitive and reference variables?
| Primitive           | Reference                       |
| ------------------- | ------------------------------- |
| Stores actual value | Stores object reference         |
| Fixed size          | Variable size                   |
| Cannot be null      | Can be null                     |
| Examples: int, char | Examples: String, Array, Object |
```
```
Can a variable be null?
> Only reference variables can be `null`.
String s = null;
Primitive variables cannot be `null`.
```
```
# Frequently Asked Rapid-Fire Questions

Q: Which variable gets default values?
A: Instance and static variables.

Q: Which variable does not get default values?
A: Local variables.

Q: Which keyword makes a variable constant?
A: `final`.

Q: Which variable belongs to the class?
A: Static variable.

Q: Which variable belongs to an object?
A: Instance variable.

Q: Which variable is created inside a method?
A: Local variable.

Q: Can we declare multiple variables in one line?
A: Yes.
int a = 10, b = 20, c = 30;

Q: Is Java case-sensitive for variable names?
A: Yes. `age` and `Age` are different variables.

Q: Can variable names contain `_` and `$`?
A: Yes.

Q: Can variable names be Java keywords?
A: No.
```