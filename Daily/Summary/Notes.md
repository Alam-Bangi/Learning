```
Data- State 
Functions- Behaviour


- What happens when Object is created internally 
    - 1. Memory Allocation
        - System allocates memory for object (heap memory)
        - Size depends on class variables
    - 2. Instance Variable Initialization
        - All instance variables are initialized.
        - Default values are assigned first, then
        
         
Arrays → fixed size, contiguous memory, faster, primitives allowed
ArrayList → dynamic, resizing, Object[], wrapper classes only
Use Arrays.toString() / deepToString() for printing
Be careful with covariant arrays → ArrayStoreException
ArrayList iterators → fail-fast
Cloning → deep copy; assignment → shallow copy
subList → view backed by original list
```
# ARRAY / ARRAYLIST
```
Operation	                Time Complexity
Access                      O(1) ✅
Search	                    O(n) ❌
Insertion (end)	            O(1) / O(n)*
Insertion (mid)	            O(n) ❌
Deletion	                O(n) ❌

            ARRAY vs ARRAYLIST
Feature	        Array	        ArrayList
Size	        Fixed           Dynamic
Speed	        Faster	        Slightly slower
Flexibility	    Low	            High
Memory	        Efficient	    Extra overhead

            ARRAYLIST vs LINKEDLIST
Feature	          ArrayList	           LinkedList
Structure	      Dynamic Array	       Doubly linked list
Access	          Fast (O(1))	       Slow (O(n))
Insertion	      Slow (O(n))	       Fast (O(1) at ends)
Memory	          Less	               More (extra pointers)
Use case	      Frequent reads	   Frequent insert/delete

- How does ArrayList grow internally?
    - Default capacity = 10
    - When full:
        1. Creates a new larger array
        2. Copies old elements
        3. Adds new element
    👉 Growth formula:
        newCapacity = oldCapacity + (oldCapacity / 2)

Why is ArrayList slower than array?
    - ArrayList is slightly slower than normal arrays because:
        1. It has extra methods (overhead)
        2. It may need resizing + copying
        3. It uses wrapper classes(eg- Integer instead of int)

👉 Arrays are faster because:
    Direct memory access
    No resizing
    No object overhead

            SIZE() vs CAPACITY()
Feature	        size()	                        capacity()
Meaning	        Number of elements	            Internal storage size
Changes	        When elements added/removed	    When resized
Access	        Available method	            Not directly accessible
👉 Example:
Capacity = 10
Size = 3

            ARRAYS VS GENERICS(ex.ArrayList)
Feature	            Arrays	        Generics
Type checking	    Runtime	        Compile-time
Behavior	        Covariant	    Invariant
Safety	            Less safe	    More safe
Performance	        Faster	        Slightly slower
Flexibility	        Less	        More
Memory	            Efficient       Extra overhead
Runtime type info	Present	        Erased

Covariance in Arrays
Arrays in Java are covariant, meaning:
    A parent type reference can refer to a child type array.
    Object[] arr = new String[3]; // allowed

⚠️ Why is it dangerous?
Because it breaks type safety at runtime.
    Object[] arr = new String[3];
    arr[0] = 10; // ❌ Runtime error
👉 Even though compilation is fine, JVM throws:
ArrayStoreException

When an array is passed to a method in Java:
    The reference of the array is passed by value (not the actual array).
    So:
    Both caller and method point to the same array object in heap
    Any modification inside the method affects the original array
```
```
Inheritance
    Inheritance is a mechanism where one class acquires properties (fields + methods) of another class using extends.

Why is inheritance used?
    Code reusability
    Method overriding (runtime polymorphism)
    Better organization (IS-A relationship) 

Does Java support multiple inheritance?
   ❌ Not with classes 
   ✅ Yes with interfaces

Types of inheritance in Java
    Single - One child class inherits from one parent class.
    Multilevel - A class inherits from a class, which itself inherits from another class.
    Hierarchical - Multiple child classes inherit from one parent class.
    Multiple (via interfaces only) - One class inherits from multiple sources (interfaces).
    ❗ Java does NOT support multiple inheritance with classes.
    Hybrid (via interfaces) - Combination of two or more inheritance types.
       A
      / \
     B   C
      \ /
       D

Difference between overloading and overriding?
Feature	                Overloading	    Overriding
Same method name	    Yes	            Yes
Parameters	            Different	    Same
Inheritance needed	    No	            Yes
Runtime polymorphism    No	            Yes

What is protected access modifier?
Accessible:
    Within package
    Outside package via inheritance

What is dynamic method dispatch?
    Method call resolved at runtime based on object type.

What is diamond problem?
    Occurs in multiple inheritance when two parents have same method.

Can we downcast safely?
    Yes, but requires explicit casting:
    Parent p = new Child();
    Child c = (Child) p;

Can child class access parent static variables?
    ✅ Yes (via class name or inheritance)
```
# Abstract Class
```

    An abstract class in Java is used for partial abstraction and code reuse with a common base structure for related classes.

    An abstract class is a class declared with abstract keyword that:
        Cannot be instantiated
        May contain abstract (no body) and non-abstract methods

What is an abstract method?
    A method without implementation.

Why use abstract classes?
    To provide a common base
    To enforce method implementation in subclasses
    To achieve partial abstraction

Can abstract class have variables?
✅ Yes (instance + static)

Can abstract class be final?
    ❌ No
    👉 Because:
    abstract → must be inherited
    final → cannot be inherited

What happens if subclass doesn’t implement abstract method?
    Subclass must also be declared abstract.

Difference between abstract class and interface?
Feature	                Abstract Class	        Interface
Methods	                Abstract + concrete	    Abstract (default/static allowed)
Variables	            Any type	            public static final only
Constructors	        Yes	                    No
Multiple inheritance	No❌                    Yes✅

Can abstract methods be static?
    ❌ No

Can we call constructor of abstract class?
    ✅ Yes, via subclass

What is partial abstraction?
    Abstract class provides some implemented methods and some abstract methods.

When to use abstract class instead of interface?
    Use abstract class when:
        You want default implementation
        You need constructors
        You want state (instance variables)

“If abstract class has no abstract methods, why use it?”
    Prevent instantiation
    Provide common base class

Quick Revision (Must Remember)
    ❌ Cannot instantiate abstract class
    ✅ Can have constructor
    ❌ Abstract methods cannot be:
        private
        final
        static
    Supports partial abstraction
    Used for base class design
```
# INTERFACE 
```
🔹 1. What is an Interface in Java?
    An interface is a blueprint of a class that contains abstract methods (by default) and constants.
    👉 It defines what a class should do, not how to do it.
    interface Animal {
        void makeSound(); // abstract method
    }

🔹 2. Why do we use Interfaces?
    To achieve 100% abstraction
    To support multiple inheritance
    To enforce a contract between classes
    To enable loose coupling

🔹 3. How is Interface different from a Class?
Feature	        Interface	        Class
Methods	        Abstract (default)	Concrete + Abstract
Variables	    public static final	Any type
Inheritance	    Multiple allowed	Single
Object creation	Not possible	    Possible

🔹 4. How do you implement an Interface?
    Use the implements keyword.
    interface Animal {
        void makeSound();
    }
    class Dog implements Animal {
        public void makeSound() {
            System.out.println("Bark");
        }
    }

🔹 5. Can we create an object of an Interface?
    ❌ No, but you can create a reference:
    Animal obj = new Dog();
    obj.makeSound();

🔹 6. What are default methods in Interface? (Java 8+)
    Methods with a body using default keyword.
    interface Animal {
        default void sleep() {
            System.out.println("Sleeping...");
        }
    }

🔹 7. What are static methods in Interface?
    interface Animal {
        static void info() {
            System.out.println("Animals are living beings");
        }
    }
    Call using:
    Animal.info();

🔹 8. What is a functional interface?
    An interface with only one abstract method.
    @FunctionalInterface
    interface MyInterface {
        void display();
    }
    Used in Lambda expressions.

🔹 9. Can an Interface extend another Interface?
✅ Yes
    interface A {
        void methodA();
    }
    interface B extends A {
        void methodB();
}

🔹 10. Can a class implement multiple interfaces?
✅ Yes (this is how Java achieves multiple inheritance)
    interface A {
        void show();
    }
    interface B {
        void display();
    }
    class Test implements A, B {
        public void show() {}
        public void display() {}
    }

🔹 11. What happens if two interfaces have same method?
    No problem if signatures are same:
    interface A {
        void show();
    }
    interface B {
        void show();
    }
    class Test implements A, B {
        public void show() {
            System.out.println("Same method");
        }
    }

🔹 12. What if two interfaces have default methods with same name?
    You must override it:
    interface A {
        default void show() {
            System.out.println("A");
        }
    }
    interface B {
        default void show() {
            System.out.println("B");
        }
    }
    class Test implements A, B {
        public void show() {
            System.out.println("Resolved conflict");
        }
}

🔹 13. Can Interface have constructor?
    ❌ No, because you cannot create objects of interface.

🔹 14. Are variables in Interface final?
✅ Yes, by default:
        interface A {
            int x = 10; // public static final
        }

🔹 15. Can Interface have private methods?
✅ Yes (Java 9+), used internally:
        Interface A {
            private void helper() {
                System.out.println("Helper method");
            }
        }

🔹 16. Real-life example of Interface
    Think of a remote control:
        Buttons = interface methods
        TV = implementing class

🔹 17. Interface vs Abstract Class (Important Interview Q)
Feature	                Interface	        Abstract Class
Multiple inheritance	Yes	                No
Constructors	        No	                Yes
Variables	            final only	        any
Methods	                abstract + default	abstract + concrete

🔹 18. What is marker interface?
    An empty interface used to “mark” a class.
    Example:
    Serializable
    Cloneable

🔹 19. Can we override static methods?
    ❌ No, static methods are not overridden.

🔹 20. When should you use Interface?
    Use interface when:
    You need multiple inheritance
    You want to define a contract
    You want loose coupling

🔹 21. Why interface is preferred in Spring Boot?
    Answer:
    Supports dependency injection
    Enables loose coupling
    Easy testing and mocking
```
# List Interface
```

🔹 1. What is the List interface?
    List is part of the Java Collections Framework and represents an ordered collection that:
    Maintains insertion order
    Allows duplicates
    Supports index-based access
    👉 FAANG tip: Always say order + duplicates + index clearly.

🔹 2. Why do we use List instead of arrays?
    Because List provides:
    Dynamic size
    Built-in methods
    Better abstraction
    👉 Strong answer:
    “Array is fixed, List is flexible.”

🔹 3. What is the difference between ArrayList and LinkedList?
    ArrayList
    Fast access (O(1))
    Slower insert/delete

    LinkedList
    Slow access (O(n))
    Faster insert/delete

    👉 FAANG insight:
    “In real systems, ArrayList is usually preferred due to better cache performance.”

🔹 4. When would you use ArrayList?
    When:
    You need fast reading
    You access elements frequently
    👉 Interview upgrade line:
    “Optimized for read-heavy operations.”

🔹 5. When would you use LinkedList?
    When:
    Frequent insertions/deletions
    Queue or deque operations
    👉 Honest FAANG answer:
    “Rarely used in modern applications.”

🔹 6. What is time complexity of ArrayList operations?
    Access → O(1)
    Add → O(1) (amortized)
    Remove → O(n)
    👉 Key word: amortized (interviewers love this)

🔹 7. Why is ArrayList add() not always O(1)?
    Because when capacity is full:
    A new array is created
    Elements are copied
    👉 This resizing makes it occasionally O(n)

🔹 8. What is the biggest mistake with List?
    Confusing remove() behavior.
    Code:
    list.remove(1);
    Why this is asked:
    Tests understanding of method overloading
    👉 Explanation:
    Removes element at index 1, not value 1

🔹 9. What is fail-fast behavior?
    If you modify a list during iteration:
    It throws ConcurrentModificationException
    👉 FAANG tip:
    Say “fail-fast iterator detects structural modification.”

🔹 10. Why does this fail?
    for(String s : list) {
        list.remove(s);
    }
    Why interviewers ask this:
    Tests understanding of iteration
    👉 Explanation:
    You are modifying the list while iterating
    Iterator detects change → throws exception

🔹 11. What is structural modification?
    Any change that affects list size:
    add/remove → YES
    set → NO

🔹 12. What is the difference between size and capacity?
    Size → number of elements
    Capacity → internal storage
    👉 FAANG insight:
    “ArrayList may have extra unused memory.”

🔹 13. Why is contains() slow in List?
    Because it checks elements one by one → O(n)
    👉 Better alternative:
    Use Set for fast lookup

🔹 14. What is Arrays.asList() trap?
    List<String> list = Arrays.asList("A", "B");
    list.add("C");
    Why this is asked:
    Very common interview trap
    👉 Explanation:
    Creates fixed-size list
    Cannot add/remove elements
    👉 Result:
    UnsupportedOperationException

🔹 15. What is List.of()?
    Creates an immutable list
    👉 Important:
    Cannot add/remove
    Does not allow null

🔹 16. What is subList() and why is it dangerous?
    It returns a view of original list
    👉 Why asked:
    Many think it’s a copy
    👉 Risk:
    Changes affect original list
    Can cause unexpected bugs

🔹 17. Is List thread-safe?
    ❌ No
    👉 Follow-up answer:
    Use:
    Synchronized list
    CopyOnWriteArrayList

🔹 18. Why is CopyOnWriteArrayList used?
    Because:
    Safe for concurrent reads
    No fail-fast exception
    👉 Trade-off:
    Slow writes

🔹 19. Can List store primitives?
    ❌ No
    👉 Reason:
    Java generics work with objects only
    👉 Use wrapper classes:
    int → Integer

🔹 20. What is autoboxing problem?
    Primitive values are converted into objects
    👉 Impact:
    More memory
    Slower performance

🔹 21. What is equality in List?
    Two lists are equal if:
    Same elements
    Same order
    👉 Order matters (important!)

🔹 22. Why is removing from middle slow?
    Because elements shift left
    👉 Time complexity:
    O(n)

🔹 23. What is the best implementation for most cases?
👉 ArrayList

🔹 24. What would you return in a method: List or ArrayList?
    👉 Return List
    👉 Why:
    Abstraction
    Flexibility

🔹 25. What is the most important takeaway?
    Choose correct implementation
    Understand performance
    Avoid common traps

🧠 FAANG Interview Strategy (Important)
If interviewer asks about List:
Start with definition
Compare ArrayList vs LinkedList
Mention complexity
Talk about edge cases
Add one real-world use
👉 That’s a perfect answer structure
```
# Set Interface
```
Set interface can only have unique things. Doesn't allow duplication of data.
It does not provide positional access.
It is unordered.

Types:
    1. HashSet
    2. LinkedHashSet - maintains insertion order
    3. TreeSet - sorted order

TreeSet Operations
    1. floor() - returns value lower or equal to given number
    2. lower()
    3. ceiling() - returns value greater or equal to given number
    4. higher()
    5. subset() - returns all no between 2 i/p no
        - (number, number) - lower number inclusive, upper number exclusive
        - (number, true, no, true) - both number inclusive
        - (number, false, no, false) - both number exclusive
    6. headset() - prints all numbers before given number (excludes i/p)
    7. tailset() - prints all numbers after given number (includes i/p)

1. Basics
What is Set in Java?
    Set is an interface in the Java Collections Framework that represents a collection of unique elements (no duplicates).

What are the key properties of Set?
    No duplicate elements
    Not index-based
    Allows at most one null (depends on implementation)
    Part of Java Programming Language

How is Set different from Collection?
    Collection is a root interface
    Set extends Collection and adds uniqueness constraint

🧱 2. Implementations
What are main Set implementations?
    HashSet
    LinkedHashSet
    TreeSet
    EnumSet
    CopyOnWriteArraySet
    ConcurrentSkipListSet

Difference between HashSet, LinkedHashSet, TreeSet?
Feature	        HashSet	        LinkedHashSet	        TreeSet
Order	        No	            Insertion order	        Sorted
Performance	    Fastest	        Slightly slower	        Slowest
Data structure	Hash table	    Hash + Linked list	    Red-Black Tree

⚙️ 3. Internal Working
How does HashSet work internally?
    Uses HashMap
    Stores elements as keys
    Uses hashCode() + equals()

Why equals() and hashCode() are important?
    hashCode() → finds bucket
    equals() → checks duplicates

What happens if hashCode is not overridden?
    Duplicate objects may be inserted incorrectly

🚫 4. Duplicate Handling
How does Set prevent duplicates?
    If:
    obj1.hashCode() == obj2.hashCode()
    AND obj1.equals(obj2)
    → second element is rejected

Can Set contain duplicate objects?
    No (logically), but:
    If equals()/hashCode() are wrong → duplicates may appear

🧪 5. Null Handling
Set Type	    Null Allowed
HashSet	        Yes (1 null)
LinkedHashSet	Yes
TreeSet	        ❌ No

Why TreeSet does not allow null?
    Because it uses sorting, and null cannot be compared.

🔢 6. Ordering & Sorting
How does TreeSet maintain order?
    Natural ordering (Comparable)
    Custom ordering (Comparator)

    Example using Comparator
    Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
    set.add(10);
    set.add(5);
    System.out.println(set); // [10, 5]

What is Comparable vs Comparator?
Feature	    Comparable	        Comparator
Package	    java.lang	        java.util
Method	    compareTo()	        compare()
Use	        Default sorting	    Custom sorting

🔄 7. Iteration
    Ways to iterate a Set
    For-each loop
    Iterator
    Stream API

Example
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.forEach(System.out::println);

🚀 8. Performance
Time complexity of HashSet
    Add: O(1)
    Remove: O(1)
    Search: O(1)

Why TreeSet is slower?
    Uses tree structure → O(log n)

🧵 9. Thread Safety
Is HashSet thread-safe?
    ❌ No
    Thread-safe alternatives?
    Collections.synchronizedSet()
    CopyOnWriteArraySet
    ConcurrentSkipListSet

🔐 10. Immutable Sets
How to create immutable Set?
    Set<Integer> set = Set.of(1, 2, 3);
    Properties:
    No modification allowed
    Throws UnsupportedOperationException

🧰 11. Advanced Concepts
What is EnumSet?
    Specialized Set for enums
    Very fast (bit vector)

What is CopyOnWriteArraySet?
    Thread-safe
    Copies array on modification

What is ConcurrentSkipListSet?
    Thread-safe
    Sorted
    Uses skip list

🔍 12. Methods in Set Interface
Common methods:
    add()
    remove()
    contains()
    size()
    isEmpty()
    clear()

⚠️ 13. Common Mistakes
Mistake 1: Not overriding equals & hashCode
    → duplicates issue
Mistake 2: Using TreeSet without Comparable
    → ClassCastException
Mistake 3: Assuming order in HashSet
    → order is unpredictable

🔄 14. Set vs Other Collections
Set vs List vs Map
Feature	    Set	        List	        Map
Duplicates	No	        Yes	            Keys: No
Order	    Depends	    Yes	            Depends
Structure	Elements	Elements	    Key-Value

🧠 15. Real-world Use Cases
    Removing duplicates
    Database unique records
    Tag systems
    Caching unique values

💥 16. Tricky Interview Questions
Q: Can we synchronize HashSet?
    Yes:
    Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

Q: Why Set has no get() method?
    Because no index-based access

Q: Can we convert List to Set?
    Set<Integer> set = new HashSet<>(list);

Q: Difference between fail-fast and fail-safe?
    Fail-fast → throws exception (HashSet iterator)
    Fail-safe → works on copy (CopyOnWriteArraySet)

🧾 17. Java 8+ Features
    Stream with Set
    set.stream()
    .filter(x -> x > 10)
    .forEach(System.out::println);
```
