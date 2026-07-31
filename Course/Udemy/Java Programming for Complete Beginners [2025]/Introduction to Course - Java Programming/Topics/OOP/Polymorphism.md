**"What is polymorphism in Java?"**

> **"Polymorphism is one of the four main principles of Object-Oriented Programming (OOP). The word 'polymorphism' means 'many forms.' In Java, polymorphism allows the same method or object reference to behave differently depending on the context."**

There are **two types of polymorphism** in Java:

1. **Compile-time Polymorphism (Method Overloading)**
2. **Run-time Polymorphism (Method Overriding)**

---

# 1. Compile-time Polymorphism (Method Overloading)

* Achieved by defining multiple methods with the **same name** but **different parameter lists**.
* The compiler decides which method to call based on the method signature.

### Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Demo {
    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println(c.add(10, 20));
        System.out.println(c.add(10, 20, 30));
    }
}
```

**Output**

```
30
60
```

---

# 2. Run-time Polymorphism (Method Overriding)

* Achieved through **inheritance**.
* A subclass provides its own implementation of a method defined in the parent class.
* The method that executes is determined at runtime based on the actual object.

### Example

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Demo {
    public static void main(String[] args) {

        Animal a = new Dog();

        a.sound();
    }
}
```

**Output**

```
Dog barks
```

---

# Types of Polymorphism

| Compile-time            | Run-time                                       |
| ----------------------- | ---------------------------------------------- |
| Method Overloading      | Method Overriding                              |
| Decided by the compiler | Decided at runtime                             |
| In the same class       | Requires inheritance                           |
| Faster                  | Slightly slower due to dynamic method dispatch |

---

# Advantages of Polymorphism

* Improves code reusability.
* Makes code easier to extend and maintain.
* Reduces code duplication.
* Allows one interface or base class to represent many implementations.

---

# Real-Life Example

Think of a **payment system**:

* `Payment` is the parent class.
* `CreditCardPayment`, `UPIPayment`, and `NetBankingPayment` are subclasses.
* Each implements its own `pay()` method.

The application can call `pay()` without needing to know the specific payment type.

---

# Common Interview Questions

**Q: What is the difference between overloading and overriding?**

| Method Overloading                     | Method Overriding                         |
| -------------------------------------- | ----------------------------------------- |
| Same method name, different parameters | Same method signature in parent and child |
| Compile-time polymorphism              | Run-time polymorphism                     |
| Inheritance not required               | Inheritance required                      |

---

**Q: Can constructors be overloaded?**

> Yes. Constructors can be overloaded because they can have different parameter lists.

---

**Q: Can static methods be overridden?**

> No. Static methods belong to the class and are hidden, not overridden.

---

**Q: Can private methods be overridden?**

> No. Private methods are not inherited by subclasses.

---

# Interview-Ready Answer (1 Minute)

> **"Polymorphism means 'many forms' and allows the same method or object reference to perform different behaviors. Java supports two types of polymorphism: compile-time polymorphism through method overloading, where methods have the same name but different parameters, and run-time polymorphism through method overriding, where a subclass provides its own implementation of a parent class method. Run-time polymorphism is achieved using inheritance and dynamic method dispatch. Polymorphism makes code more flexible, reusable, and easier to maintain."**
