# Class and Object
What is a class in Java?
```
> A class is a blueprint or template used to create objects. It defines the properties (fields) and behaviors (methods) that the objects will have.

Example:
class Student {
    int id;
    String name;

    void study() {
        System.out.println("Studying");
    }
}
```
What is an object?
```
An object is an instance of a class. It occupies memory and can access the class's fields and methods.

Student s = new Student();
```
Difference between Class and Object
```
Class	                Object
Blueprint	            Instance of class
Logical entity	        Physical entity
No memory allocated 	Memory allocated
(until object created)
Declared once	        Many objects can be created
```
Why do we need classes?
```
Classes help:
    Organize code
    Reuse code
    Implement OOP
    Improve maintainability
    Represent real-world entities
```
What are members of a class?
```
A class contains
    Variables (Fields)
    Methods
    Constructors
    Nested Classes
    Blocks
    Constants
```
What is a constructor?
```
Special method used to initialize objects.

Student(){
}
Automatically called when object is created.
```
Rules of constructor
```
Same name as class
No return type
Automatically called
Can be overloaded
```
Types of constructors
```
Default Constructor
No-Argument Constructor
Parameterized Constructor
Copy Constructor (user-defined)
```
Difference between Constructor and Method
```
Constructor	            Method
Initializes object	    Performs task
No return type	        Has return type
Called automatically	Called explicitly
```
Can a class have multiple constructors?
```
Yes.
Student(){}
Student(int id){}
This is constructor overloading.
```
Can constructor be static?
```
No.
```
Can constructor be final?
```
No.
```
Can constructor be private?
```
Yes.
Used in:
    Singleton
    Utility classes
```
What is the this keyword?
```
Represents current object.
this.name = name;

Uses of this
    Refer current object
    Call another constructor
    this();
Pass current object
Return current object
```
What is the super keyword?
```
Represents parent class object.

Used to
    Call parent constructor
    Access parent methods
    Access parent variables
```
Difference between this and super
```
this	                super
Current class	        Parent class
Current constructor	    Parent constructor
Current variables	    Parent variables
```
Can a class be final?
```
Yes.
final class Animal{}
Cannot be inherited.
```
Can a class be abstract?
```
Yes.
abstract class Animal{
}
Cannot create object.
```
Can a class be static?
```
Top-level class → No
Nested class → Yes
```
Can a class be private?
```
Top-level → No
Nested → Yes
```
Can a class be protected?
```
No.
```
Can a class have multiple objects?
```
Yes.

Student s1=new Student();
Student s2=new Student();
```
What happens when object is created?
```
Memory allocated
Instance variables initialized
Constructor called
Object reference returned
```
Where are objects stored?
```
Heap Memory.
Reference variable stored in Stack.
```
Explain memory allocation of class.
```
Class metadata → Method Area
Object → Heap
Reference → Stack
```
What is anonymous object?
```
Object without reference.
new Student().study();
```
Can a class contain another class?
```
Yes.
Called Nested Class.
```
What is inner class?
```
Class inside another class.

class Outer{
   class Inner{
   }
}
```
What is a static nested class?
```
class Outer{
   static class Inner{
   }
}
```
What is encapsulation?
```
Wrapping data and methods into one unit.

Example:
class Student{
   private int age;

   public void setAge(int age){
      this.age=age;
   }
   public int getAge(){
      return age;
   }
}
```
Why make variables private?
```
To prevent unauthorized access and maintain data integrity.
```
What is a getter?
```
Returns variable value.

public int getAge(){
   return age;
}
```
What is a setter?
```
Updates variable.

public void setAge(int age){
   this.age=age;
}
```
Can a class implement multiple interfaces?
```
Yes.
class A implements X,Y
```
Can a class extend multiple classes?
```
No.
Java doesn't support multiple inheritance using classes.
```
Can one class extend another?
```
Yes.
class Dog extends Animal
```
What is inheritance?
```
Mechanism to acquire properties from another class.
```
Why use inheritance?
```
Code reuse
Less duplication
Easy maintenance
```
What is polymorphism?
```
Same method behaves differently depending on the object.

Example:
Animal a = new Dog();
a.sound();
```
What is abstraction?
```
Showing only essential details while hiding implementation.
```
Can a class have main() method?
```
Yes.
public static void main(String args[]){
}
```
Can multiple classes have main()?
```
Yes.
Each can be run separately.
```
What is the default constructor?
```
A constructor automatically provided by Java if no constructor is written.
```
What if I write my own constructor?
```
Java does not generate the default constructor.
```
Can constructors be overloaded?
```
Yes.
```
Difference between overloading and overriding
```
Overloading	            Overriding
Same class	            Parent-child
Compile-time	        Runtime
Different parameters	Same parameters
```
Why is Java called an Object-Oriented language?
```
Because it supports the four main OOP principles:
    Encapsulation
    Inheritance
    Polymorphism
    Abstraction
```
Explain a class using a real-world example.
```
> A class is like a blueprint for building houses. The blueprint defines the structure, but it is not a house itself. Each house built from that blueprint is an object. Similarly, a Car class defines attributes such as color and model, and each car created from it is an object.
```
Can you create an object without a class?
```
Normally, no. Every object is created from a class (or an array type in Java, which also has an associated class).
```
What is the syntax to create an object?
```
ClassName obj = new ClassName();
```
What is the new keyword?
```
It allocates memory for an object on the heap and invokes the constructor.
```
What are the access modifiers for classes?
```
public – accessible from anywhere.
Package-private (no modifier) – accessible only within the same package.
Top-level classes cannot be private or protected.
```
Interview Tips
```
When answering:
    Start with a one-line definition.
    Explain the concept in simple terms.
    Give a short code example if appropriate.
    Mention a practical use case.
    Keep answers concise (30–60 seconds) unless the interviewer asks for more detail.
```