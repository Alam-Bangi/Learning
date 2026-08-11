> **“An interface in Java is a contract that defines what a class should do, without specifying the complete implementation. A class implements an interface using the `implements` keyword.**
>
> **Interfaces are mainly used to achieve abstraction and loose coupling. A class can implement multiple interfaces, which is one way Java supports multiple inheritance of behavior/contracts.**
>
> **An interface can contain abstract methods, and since Java 8 it can also contain default and static methods with implementations. Since Java 9, it can also have private methods. Interface variables are implicitly `public`, `static`, and `final`.**
>
> **For example, if I create a `Payment` interface with a `pay()` method, different classes like `CreditCardPayment` and `UPIPayment` can implement it in their own way.”**

### Example

```java
interface Payment {
    void pay();
    
    default void receipt() {
        System.out.println("Generating receipt");
    }
}

class CreditCardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying by credit card");
    }
}

class UPIPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying using UPI");
    }
}
```

Then you can demonstrate **loose coupling**:

```java
Payment payment = new UPIPayment();
payment.pay();
```

Here, the code depends on the **`Payment` interface**, not directly on `UPIPayment`.

### If they ask: “Why do we use interfaces?”

A good answer is:

> **“We use interfaces to define a common contract, achieve loose coupling, support multiple implementations, and make our code easier to extend and test.”**

### Very common follow-up: Interface vs Abstract Class

You can say:

> **“An abstract class is useful when related classes need to share common state and implementation, whereas an interface is useful when I want to define a common contract or capability that potentially unrelated classes can implement. Also, a class can extend only one abstract class but can implement multiple interfaces.”**

### ⭐ One-line version if they want a quick answer

> **“An interface is a contract in Java that defines a set of behaviors a class must provide, helping us achieve abstraction, loose coupling, and multiple implementations.”**
