# Encapsulation

What is encapsulation in Java?
```
Encapsulation is the process of wrapping data (variables) and methods (functions) into a single unit (class) while restricting direct access to the data using access modifiers.

Example:
class Student {
    private int age;

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
```
Why is encapsulation used?
```
Encapsulation is used to:
    Protect data from unauthorized access
    Hide implementation details
    Improve security
    Improve maintainability
    Increase code flexibility
    Support data validation
```
What are the advantages of encapsulation?
```
Data hiding
Better security
Controlled access to data
Easy maintenance
Loose coupling
Easier testing
Better code reusability
```
How is encapsulation achieved?
```
By:
    Declaring variables as private
    Providing public getter and setter methods
Example:
class Employee {
    private double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
}
```
What is data hiding?
```
Data hiding means restricting direct access to class variables by making them private.
Users interact with the data only through public methods.
```
Is encapsulation the same as data hiding?
```
No.
Data Hiding → Restricts direct access to data.
Encapsulation → Wraps data and methods together and often uses data hiding.

Data hiding is one part of encapsulation.
```
Why are variables made private?
```
Private variables:
    Prevent direct modification
    Protect object state
    Allow validation before updating values
    Improve security
```
What are getter methods?
```
Getter methods return the value of private variables.

Example:
public String getName() {
    return name;
}
```
What are setter methods?
```
Setter methods update private variables.

Example:
public void setName(String name) {
    this.name = name;
}
```
Why use getters and setters instead of public variables?
```
Getters and setters allow:
    Validation
    Read-only or write-only access
    Logging
    Future changes without affecting other code
```
Can encapsulation exist without getters and setters?
```
Yes.
You can expose only the methods you need.

Example:
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
    public double getBalance() {
        return balance;
    }
}
There is no setBalance() method because clients should not set the balance directly.
```
Can encapsulation have only getters?
```
Yes.
This creates a read-only object.

private int id;
public int getId() {
    return id;
}
```
Can encapsulation have only setters?
```
Yes.
This creates a write-only property (though this is uncommon).

private String password;
public void setPassword(String password) {
    this.password = password;
}
```
What is a fully encapsulated class?
```
A fully encapsulated class has:
    All instance variables declared as private
    Access provided only through public methods

Example:
class Student {
    private int id;
    private String name;
}
```
Give a real-life example of encapsulation.
```
An ATM is a good example.

Users can deposit, withdraw, and check their balance using the machine's interface, but they cannot directly access or modify the bank's internal database.
```
Which access modifier is mainly used for encapsulation?
```
private
It hides the variables from direct access outside the class.
```
Can encapsulation be achieved using protected variables?
```
It is possible, but private provides stronger encapsulation because protected members are accessible to subclasses and classes in the same package.
```
What happens if variables are public?
```
class Student {
    public int age;
}
Anyone can modify the value directly.
student.age = -50;
This can lead to invalid object states.
```
How does encapsulation improve security?
```
By preventing unauthorized or invalid changes to data and allowing validation before updates.

Example:
public void setAge(int age) {
    if (age > 0) {
        this.age = age;
    }
}
```
Can private variables be accessed outside the class?
```
Not directly.
They can only be accessed through methods provided by the class (or through reflection, which is a special case and generally not part of normal application logic).
```
Does encapsulation improve code maintenance?
```
Yes.
Since the internal implementation is hidden, you can change it without affecting code that uses the class, as long as the public interface remains the same.
```
What is controlled access?
```
Controlled access means deciding how data can be read or modified through methods instead of allowing direct access.
```
Can we validate data using encapsulation?
```
Yes.

Example:
public void setAge(int age) {
    if (age >= 18) {
        this.age = age;
    } else {
        System.out.println("Invalid age");
    }
}
```
Explain encapsulation with a Bank Account example.
```
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
    public double getBalance() {
        return balance;
    }
}
The balance cannot be modified directly. All changes happen through controlled methods.
```
Can constructors be used with encapsulation?
```
Yes.
Constructors initialize private fields when an object is created.

class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }
}
```
Difference between encapsulation and abstraction
```
Encapsulation	                            Abstraction
Hides data by restricting access	        Hides implementation details
Achieved using classes & access modifiers	Achieved using abstract classes and interfaces
Focuses on data protection	                Focuses on exposing only essential features
```
Is encapsulation an OOP principle?
```
Yes.
It is one of the four core OOP principles:
    Encapsulation
    Inheritance
    Polymorphism
    Abstraction
```
Can immutable classes be considered encapsulated?
```
Yes.
Immutable classes typically use private fields and expose only getter methods, with no setters, so their state cannot change after construction.
```
Can static variables be encapsulated?
```
Yes.
Static variables can also be declared private and accessed through static getter and setter methods if needed.

class Config {
    private static String appName = "Demo";

    public static String getAppName() {
        return appName;
    }
}
```
What is the interview definition of encapsulation?
```
Encapsulation is the process of wrapping data and methods into a single class while restricting direct access to the data using private fields. Access is provided through controlled methods like getters and setters. This improves security, supports validation, and makes the code easier to maintain.
```
Write a fully encapsulated Java class.
```
class Student {
    private int id;
    private String name;
    private double marks;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
    }
}
```