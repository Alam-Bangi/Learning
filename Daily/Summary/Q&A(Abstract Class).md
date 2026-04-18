```
Abstract Class 

🧠 Core Concept
Q: What is an abstract class?
A: A class declared with abstract that cannot be instantiated and may contain both abstract (unimplemented) and concrete (implemented) methods.

Q: What is the main goal of an abstract class?
A: To provide a base structure and enforce certain behaviors in subclasses.

Q: What does “cannot be instantiated” mean?
A: You cannot create objects directly using new AbstractClass().

⚙️ Syntax & Declaration
Q: How do you declare an abstract class?
A: Using the abstract keyword.

Q: Can abstract classes exist without abstract methods?
A: Yes.

Q: Can abstract methods exist outside abstract classes?
A: No.

🔧 Methods
Q: What is an abstract method?
A: A method without implementation (no body).

Q: Must abstract methods be overridden?
A: Yes, in the first concrete subclass.

Q: Can abstract methods be private?
A: No (they need to be overridden).

Q: Can abstract methods be static?
A: No.

Q: Can abstract methods be final?
A: No (final prevents overriding).

Q: Can abstract methods be protected/public?
A: Yes.

🧩 Concrete Methods
Q: Can abstract classes have implemented methods?
A: Yes.

Q: Why include concrete methods?
A: For code reuse and shared functionality.

🏗️ Constructors & Variables
Q: Can abstract classes have constructors?
A: Yes.

Q: Why use constructors if objects can't be created?
A: They initialize subclass objects.

Q: Can abstract classes have instance variables?
A: Yes.

Q: Can they have static variables?
A: Yes.

Q: Can variables be final?
A: Yes.

🔗 Inheritance
Q: How is an abstract class used?
A: By extending it using extends.

Q: Can a subclass skip implementing abstract methods?
A: Only if it is also declared abstract.

Q: Can abstract class extend another abstract class?
A: Yes.

Q: Can abstract class extend a normal class?
A: Yes.

Q: Can a normal class extend an abstract class?
A: Yes.

🔄 Multiple Inheritance
Q: Can a class extend multiple abstract classes?
A: No (in languages like Java).

Q: Why not?
A: Because of single inheritance restriction.

🧪 Polymorphism
Q: Can abstract class references be used?
A: Yes.

Q: Example idea?
A:
AbstractClass obj = new SubClass();

Q: Why is this useful?
A: Enables runtime polymorphism.

🧠 Design & Usage
Q: When should you use an abstract class?
A: When classes share common structure but differ in behavior.

Q: When should you avoid it?
A: When there is no real shared logic.

Q: What principle does it support?
A: Abstraction (core OOP principle).

⚖️ Abstract Class vs Interface
Q: Key difference?
A:

Abstract class → partial implementation allowed
Interface → mostly full abstraction (traditionally)

Q: Which is faster?
A: Depends on use—performance difference is usually negligible.

Q: Which is more flexible?
A: Interface (supports multiple inheritance).

🚫 Restrictions
Q: Can abstract classes be instantiated?
A: No.

Q: Can they be final?
A: No (final prevents inheritance).

Q: Can they have private constructors?
A: Yes, but then they can’t be subclassed outside.

🧯 Edge Cases
Q: Can abstract class have only one method?
A: Yes.

Q: Can it have no methods?
A: Yes.

Q: Can abstract class be nested?
A: Yes (in some languages like Java).

Q: Can it be anonymous?
A: Yes (anonymous inner classes in Java).

🧨 Common Mistakes
Q: Mistake 1?
A: Trying to instantiate it.

Q: Mistake 2?
A: Not overriding abstract methods.

Q: Mistake 3?
A: Confusing it with interface.

🧾 Real-Life Analogy
Q: Best way to remember it?
A:
A template with missing steps—you must complete it before using.

⚡ Ultra Quick Revision
❌ Cannot create object
✔ Can have abstract + concrete methods
✔ Used for inheritance
✔ Forces method implementation
✔ Supports abstraction
```