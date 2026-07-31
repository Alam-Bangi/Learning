**"What is a constructor in Java?"**
> "A constructor in Java is a special method that's called automatically when an object is created. Its main purpose is to initialize the object's state by assigning initial values to its instance variables. A constructor has the same name as the class and does not have a return type, not even `void`."

Then add a simple example:
```java
class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Rahul", 22);
        s1.display();
    }
}
```

**Output:**
```
Rahul 22
```

### Mention the types of constructors

**1. Default Constructor**

* If you don't write any constructor, Java provides one automatically (only if no constructor is defined).
* It initializes variables to default values.

Example:

```java
class Car {
    Car() {
        System.out.println("Car object created");
    }
}
```

**2. Parameterized Constructor**

* Accepts arguments to initialize objects with different values.

```java
Car(String model) {
    this.model = model;
}
```

### Explain constructor overloading

> "Java allows constructor overloading, which means a class can have multiple constructors with different parameter lists."

Example:

```java
class Employee {
    Employee() {
        System.out.println("Default");
    }

    Employee(String name) {
        System.out.println(name);
    }
}
```

### Explain `this()` and `super()`

Interviewers often ask follow-up questions.

* `this()` calls another constructor in the same class.
* `super()` calls the parent class constructor.
* Both must be the first statement inside a constructor.

Example:

```java
class A {
    A() {
        System.out.println("A");
    }
}

class B extends A {
    B() {
        super();
        System.out.println("B");
    }
}
```

### Common interview questions

**Q: Can a constructor be `static`?**
> No. Constructors belong to objects, not the class.

**Q: Can a constructor be `final`?**
> No. Constructors are not inherited or overridden.

**Q: Can a constructor return a value?**
> No. Constructors have no return type.

**Q: Why do we use constructors?**
> To initialize objects immediately when they are created.

### A concise 1-minute interview answer

> "A constructor in Java is a special method used to initialize objects. It is automatically called when an object is created using the `new` keyword. A constructor has the same name as the class and doesn't have a return type. Constructors can be default or parameterized, and Java also supports constructor overloading. We use constructors to ensure an object starts with the required initial values. If no constructor is written, Java provides a default constructor, provided no other constructor exists."
