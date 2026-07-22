# Method

> "A method in Java is a block of code that performs a specific task. It helps organize code, promotes reusability, and improves readability by allowing the same logic to be called multiple times instead of being rewritten. A method executes only when it is invoked."
```
Then explain the syntax:
accessModifier returnType methodName(parameters) {
    // method body
}

Example:
public int add(int a, int b) {
    return a + b;
}

Explanation:

public → Access modifier
int → Return type
add → Method name
(int a, int b) → Parameters
return a + b; → Returns the result
```
```
You can also mention the main classifications:

Predefined methods – Provided by Java libraries.
Math.max(10, 20);

User-defined methods – Written by the programmer.
public void display() {
    System.out.println("Hello");
}
```
```
And common variations:
Methods with parameters and without parameters
Methods with a return value and without a return value (void)
Static methods (called using the class name)
Instance methods (called using an object)
```
If the interviewer asks, "Why do we use methods?"
You can answer:
> "Methods help break a program into smaller, manageable pieces. They improve code reusability, readability, modularity, and make testing and maintenance easier."

> "A method in Java is a reusable block of code that performs a specific task. It is defined inside a class and runs only when called. A method consists of an access modifier, return type, method name, parameters, and the method body. Methods improve code reusability, readability, and modularity. They can be predefined, like Math.max(), or user-defined. They can also be static or instance methods, accept parameters or not, and return a value or have a void return type."

What is a method in Java?
```
> A method is a block of code that performs a specific task. It is defined inside a class and executes only when called. Methods improve code reusability, readability, and modularity.

Example:
public void greet() {
    System.out.println("Hello");
}
```
Why do we use methods?
```
> Methods are used to:
    Reuse code
    Reduce code duplication
    Improve readability
    Make programs modular
    Simplify testing and maintenance
```
What is the syntax of a method?
```
> accessModifier returnType methodName(parameters) {
        // method body
    }

Example:
public int add(int a, int b) {
    return a + b;
}
```
What are the parts of a method?
```
> A method consists of:
    Access modifier
    Return type
    Method name
    Parameters
    Method body
    Return statement (optional)
```
What is a method signature?
```
> A method signature includes:
    Method name
    Parameter list
It does not include:
    Return type
    Access modifier

Example:
add(int, int)
```
What is a return type?
```
> The return type specifies the value returned by the method.

Example:
public int square(int n) {
    return n * n;
}
```
What is a void method?
```
> A void method does not return any value.

Example:
public void display() {
    System.out.println("Hello");
}
```
What is a parameter?
```
> A parameter is a variable declared in the method definition.

Example:
public void printName(String name)
name is the parameter.
```
What is an argument?
```
> An argument is the actual value passed to a method.

Example:
printName("John");
"John" is the argument.
```
Difference between parameter and argument?
```
Parameter	            Argument
Declared in method	    Passed while calling method
Placeholder	            Actual value
```
What are predefined methods?
```
> Methods already provided by Java.

Examples:
Math.sqrt(25);
System.out.println();
String.length();
```
What are user-defined methods?
```
Methods created by the programmer.

Example:
public void display() {
    System.out.println("Welcome");
}
```
What is method calling?
```
> Invoking or executing a method.

Example:
display();
```
What is a static method?
```
> A static method belongs to the class rather than an object.

Example:
public static void show() {
}
Called using:
ClassName.show();
```
What is an instance method?
```
> An instance method belongs to an object.

Example:
public void display() {
}
Called using:
Student s = new Student();
s.display();
```
Difference between static and instance methods?
```
Static	                                        Instance
Belongs to class	                            Belongs to object
Called using class	                            Called using object
Cannot directly access instance variables	    Can access all members
```
Can a static method call a non-static method?
```
No, not directly.
It requires an object.

Example:
Test t = new Test();
t.display();
```
Can a non-static method call a static method?
```
Yes.

Example:
public void demo() {
    show();
}
```
What is method overloading?
```
> Having multiple methods with the same name but different parameter lists.

Example:
void add(int a, int b){}
void add(int a, int b, int c){}
```
Can we overload methods by changing only the return type?
```
No.
This causes a compile-time error.
```
What is method overriding?
```
When a subclass provides its own implementation of a method already defined in the superclass.

Example:
class Animal{
    void sound(){}
}
class Dog extends Animal{
    @Override
    void sound(){}
}
```
Difference between overloading and overriding?
```
Overloading	                Overriding
Same class	                Parent-child classes
Different parameters	    Same parameters
Compile-time polymorphism	Runtime polymorphism
```
Can a method return multiple values?
```
Not directly.
You can return:
    Array
    Object
    List
    Record (Java 16+)
```
Can methods return objects?
```
Yes.

Example:
public Student getStudent() {
    return new Student();
}
```
Can methods return arrays?
```
Yes.

Example:
public int[] numbers() {
    return new int[]{1,2,3};
}
```
Can methods call other methods?
```
Yes.

Example:
void A(){
    B();
}
void B(){
}
```
What is recursion?
```
A method calling itself until a base condition is met.

Example:
int fact(int n){
    if(n==1)
        return 1;
    return n*fact(n-1);
}
```
What is method recursion used for?
```
Factorial
Fibonacci
Tree traversal
Divide and conquer algorithms
```
What is pass by value?
```
Java always uses pass-by-value. A copy of the variable (or object reference) is passed to the method.
```
Can we pass objects to methods?
```
Yes.

Example:
void print(Student s){
}
```
Can methods have default arguments?
```
No.
Java does not support default parameters.

Instead use:
Method overloading
```
Can methods be final?
```
Yes.
A final method cannot be overridden.
final void show(){}
```
Can methods be abstract?
```
Yes.
Abstract methods have no body.
abstract void display();
```
Can methods be private?
```
Yes.
Private methods are accessible only within the same class.
```
Can constructors be overloaded?
```
Yes.

Example:
Student(){}
Student(int id){}
```
Is a constructor a method?
```
No.
Differences:
    Constructor initializes objects.
    Constructor has no return type.
    Constructor name must match the class name.
```
Can a method be synchronized?
```
Yes.
Used in multithreading.
public synchronized void display(){}
```
Can main() be overloaded?
```
Yes.

Example:
public static void main(String[] args){}

public static void main(int x){}

Only the standard main(String[] args) is used as the program entry point.
```
Can main() be overridden?
```
No.
It is static, and static methods cannot be overridden (they can only be hidden).
```
What is the difference between a method and a constructor?
```
Method	                    Constructor
Performs an action	        Initializes an object
Has a return type	        No return type
Can be called many times	Called automatically when an object is created
Can have any name	        Name must match the class
```
Interview Tip
```
For method-related questions, remember these core topics:

Method syntax
Parameters vs. arguments
Return type vs. void
Static vs. instance methods
Method overloading
Method overriding
Recursion
Pass-by-value
Constructor vs. method
Access modifiers
```