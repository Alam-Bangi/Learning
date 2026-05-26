- [Generics Notes](https://interview.in28minutes.com/interview-guides/java/generics-in-java/)
```
🧠 1. What are generics in Java?
Answer:
    Generics allow you to write classes, interfaces, and methods with type parameters, so they can work with any data type safely.
Example:
    List<String> list = new ArrayList<>();
Explanation:
    Without generics, everything was treated as Object. Generics move type checking to compile time, preventing runtime errors and removing the need for casting.

🎯 2. Why were generics introduced?
Answer:
    To provide type safety
    To eliminate explicit casting
    To improve code reusability
Explanation:
    Before generics:
    Object obj = list.get(0);
    String s = (String) obj;
    After generics:
    String s = list.get(0);
    Errors are caught earlier → safer code.

🧩 3. What is a type parameter?
Answer:
    A placeholder for a type, usually written as T, E, K, V.
Explanation:
    class Box<T> { }
    Here, T is replaced with an actual type when used:
    Box<Integer> b = new Box<>();

🔄 4. Difference between <T> and <?>?
Answer:
    <T> → specific type (known inside method/class)
    <?> → unknown type (wildcard)
Explanation:
    <T> void method(List<T> list)
    → same type throughout
    void method(List<?> list)
    → type is unknown, more restrictive
    👉 Use <T> when you need consistency, ? when you don’t care.

⚖️ 5. What is the PECS rule?
Answer:
    Producer Extends, Consumer Super
Explanation:
    ? extends T → read (producer)
    ? super T → write (consumer)
    List<? extends Number> // read only
    List<? super Integer>  // can add Integer
    👉 This avoids unsafe operations.

🔍 6. What is type erasure?
Answer:
    Generics are removed at runtime by the compiler.
    Explanation:
    List<String> → List
    At runtime, JVM doesn’t know about String.
    👉 This is why:
    No instanceof List<String>
    No generic method overloading

🚫 7. Why can’t we use primitives in generics?
Answer:
    Generics work only with objects, not primitives.
    Explanation:
    List<int> ❌
    List<Integer> ✅
    Because generics rely on type erasure and object handling.

🧱 8. Why can’t we create generic arrays?
Answer:
    Because arrays are runtime-typed, but generics are compile-time only.
    Explanation:
    T[] arr = new T[10]; // illegal
    👉 This would break type safety due to type erasure.

🔄 9. What is invariance in generics?
    Answer:
        List<Integer> is NOT a subtype of List<Number>.
    Explanation:
        List<Integer> ints = new ArrayList<>();
        List<Number> nums = ints; // ❌
    Why?
        Because it could allow unsafe inserts:
        nums.add(3.14); // breaks Integer list

🔁 10. What is covariance and contravariance?
Answer:
    Covariance → ? extends
    Contravariance → ? super
Explanation:
    List<? extends Number> // covariance (read-only)
    List<? super Integer>  // contravariance (write-safe)

🧪 11. What are raw types?
Answer:
    Using generics without specifying type.
    List list = new ArrayList();
    Explanation:
    Disables type checking
    Can cause runtime errors
    👉 Only used for backward compatibility.

🧨 12. What is heap pollution?
Answer:
    When a variable of a parameterized type refers to an object of a different type.
    Example:
    List<String> list = new ArrayList();
    list.add(10); // unsafe
    Explanation:
    Mixing raw types and generics breaks type safety.

🔧 13. Can we overload methods using generics?
Answer: ❌ No
Explanation:
    void print(List<String> list)
    void print(List<Integer> list)
After type erasure:
    void print(List list)
    → same signature → compile error

🧠 14. What are bounded type parameters?
Answer:
    Restrict the type that can be used.
    Example:
    <T extends Number>
    Explanation:
    Ensures only subclasses of Number are allowed, so you can safely call methods like doubleValue().

🔄 15. What is a generic method?
Answer:
    A method with its own type parameter.
    <T> T identity(T value) {
        return value;
    }
    Explanation:
    Works independently of class generics.

🧩 16. Difference between extends in generics vs inheritance?
Answer:
    In generics → means upper bound
    In classes → means inheritance
Explanation:
    <T extends Number>
    → includes subclasses (Integer, Double)

🧠 17. Why can’t we do new T()?
Answer:
    Because type information is erased at runtime.
Explanation:
    JVM doesn’t know what T is → cannot instantiate.

🔍 18. Why is List<?> mostly read-only?
Answer:
    Because the exact type is unknown.
    Explanation:
    List<?> list = new ArrayList<String>();
    list.add("hello"); // ❌
    👉 Java prevents unsafe inserts.

🧠 19. What is wildcard capture?
Answer:
    A technique where the compiler assigns a temporary type to ?.
    Explanation:
    void process(List<?> list) {
        helper(list);
    }
    <T> void helper(List<T> list) { }

🧠 20. What is the biggest limitation of generics in Java?
Answer:
    Type erasure
    Explanation:
        No runtime type info
        Cannot use primitives
        Cannot create generic arrays
        Limits flexibility compared to other languages

⚡ Final tip (what interviewers really check)
    They don’t care if you memorize definitions—they check if you understand:
        PECS rule
        Type erasure consequences
        Why invariance exists
```
## Why Do We Need Generics in Java?
```
What Are Generics?
    What? A way to create type-safe and reusable code in Java.
    Why? Eliminates the need for multiple versions of the same class for different data types.
    How? Instead of hardcoding a specific type, we use a type parameter (ex: T).
Problems without Generics - 1 - Too Rigid
    Works for One Type Only – Code below can only store String values
    No Reusability – Need to rewrite class if you want Integer, Double, etc.
    Lots of Duplicate Code – Repeating logic for each data type gets messy
    Hard to Maintain – More classes to write, test, and manage for every type
class MyList {
    private List values = new ArrayList();
    void add(String value) {
        values.add(value);
    }
    void remove(String value) {
        values.remove(value);
    }
}
MyList myList = new MyList();
myList.add("Value 1");
myList.add("Value 2");

Problems without Generics - 2 - OR Too Much Flexibility
    No Type Safety – Any object type can be added without warnings
    Mixing Types – Strings, Integers, Objects can all go into one list
    Manual Casting – Must cast values when reading from the list
    Runtime Errors – Wrong casts cause ClassCastException at runtime
    Hard to Read – No clear info on what the list is supposed to store
Code Example:
    import java.util.ArrayList;
    import java.util.List;

    class MyList {
        private List values = new ArrayList(); // Raw list, no generics
        void add(Object value) {
            values.add(value);
        }
        void remove(Object value) {
            values.remove(value);
        }
        Object get(int index) {
            return values.get(index);
        }
    }
    //Usage
    MyList myList = new MyList();
    myList.add("Value 1");
    myList.add("Value 2");
    myList.add(123); // ✅ Allowed – no type safety
    // Optional: safe cast if you *know* the type
    String first = (String) myList.get(0); // ✅ okay
    // Integer wrong = (Integer) myList.get(0); // ❌ runtime error

Solution: Using Generics
    Use Type Parameter T – Replace hardcoded type like String.
    Flexible and Reusable – One class works for all data types.
    Type Safe – Compiler checks type at compile time.
    No Casting Needed – You get the right type automatically.
    class MyListGeneric<T> {
        private List<T> values = new ArrayList<>();

        void add(T value) {
            values.add(value);
        }
        void remove(T value) {
            values.remove(value);
        }
        T get(int index) {
            return values.get(index);
        }
    }
    MyListGeneric<String> myListString = new MyListGeneric<>();
    myListString.add("Value 1"); // ✅ Type safe
    myListString.add("Value 2");
    // myListString.add(10); // ❌ Compile-time error
    String strValue = myListString.get(0); // ✅ No casting required
    MyListGeneric<Integer> myListInteger = new MyListGeneric<>();
    myListInteger.add(1);
    myListInteger.add(2);
    Integer num = myListInteger.get(0);
```
## Generic Class vs Generic Method – What’s the Real Difference?
```
- What is a Generic Class?
    Uses Type Parameter T in class definition – Works with different data types.
    Code Reusability – One class, many data type options.
    Type Safe – Compiler checks the type during compilation.
    No Need for Casting – You get the right type automatically.

- What Is a Generic Method?
    Method Defines Its Own <T> – Not tied to class-level generic types.
    Flexible and Reusable – Method works with any data type.
    Common in Utility Classes – Like sorting, printing, comparing.
        class Utility {
            // Generic Method (T can be any type)
            public static <T> void printArray(T[] array) {
                for (T element : array) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
        // Using Generic Method
        String[] words = {"Hello", "World"};
        Integer[] numbers = {1, 2, 3};
        Utility.printArray(words);   // Output: Hello World
        Utility.printArray(numbers); // Output: 1 2 3
        //Example Generic Methods From JDK
        public class Collections {
            public static <T> void sort(List<T> list) {/*Code*/}
            public static <T> boolean replaceAll(
                    List<T> list, T oldVal, T newVal){} }

Feature	        Generic Class	                                    Generic Method
Scope	        Applies to all methods in the class	                Only applies to the specific method
Type Parameter  Definition	Defined at class level (class Box<T>)	Defined within method (<T> void method())
Use Case	    Used when multiple methods in class need same type  Used when only one method needs a type parameter
Example	        Box<T> for storing generic values	                printArray<T>() for printing arrays

- What are Generic Interfaces?
    What? Interfaces can define type parameters just like classes
    Why? Makes them reusable with any type
    Used In? Collections, functional interfaces, comparators, etc.
Code Example:
    //Generic Interface
    interface Printer<T> {
        void print(T value);
    }
    // Generic implementation
    class GenericPrinter<T> implements Printer<T> {
        public void print(T value) {
            System.out.println("Printing: " + value);
        }
    }
    // Examples from JDK
    public interface Comparable<T> {
        int compareTo(T o);
    }
    public interface Iterator<E> {
        boolean hasNext();
        E next();
    }
    public interface Supplier<T> {
        T get();
    }
```
## How Are Generics Actually Used in the JDK?
```
1. Collections Framework (List, Set, Map, ...)
    Built Using Generics – Core of Java’s data structures.
    Type Safe – Prevents adding wrong data types.
    No Typecasting Needed – Compiler handles types automatically.
    Flexible and Reusable – Use same class with different types.
//public class ArrayList<E>
List<String> names = new ArrayList<>();
names.add("Java");
// names.add(123); // Compile error
String first = names.get(0); // No casting

//public class HashMap<K,V>
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
map.put("Bob", 30);

2. Comparable and Comparator Interfaces
    Comparable – Define natural order for instances of a Class
    Comparator – Define custom sort order for specific cases
Eg: Comparable
    class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public int getAge() { 
            return age; 
        }
        public String getName() { 
            return name; 
        }
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
    }
Eg: Comparator
    List<Person> people = new ArrayList<>();
    people.add(new Person("Alice", 25));
    people.add(new Person("Bob", 30));
    Collections.sort(people);

    // Custom sorting (Comparator)
    // public interface Comparator<T> {
    //  int compare(T o1, T o2);
    // }
    class NameSorter implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
    //USAGE
    Collections.sort(people, new NameSorter());

3. Optional in Java 8+
    Avoids Null Checks – No more if (obj != null) madness.
    Type Safe Wrapper – Wraps values that may or may not be present.
    Cleaner Code – Handles defaults with orElse, maps with map.
    No NullPointerException – Safer than returning null.
//public final class Optional<T> {
//  public static <T> Optional<T> of(T value) {}
//}
Optional<String> optional = Optional.of("Hello");
System.out.println(optional.orElse("Default")); // Output: Hello

//public static<T> Optional<T> empty() {
Optional<String> emptyOptional = Optional.empty();
System.out.println(emptyOptional.orElse("Default")); // Output: Default
}

4. Stream API (Java 8+)
    Type-Safe Processing – Works with the type you stream.
    Generic All the Way – filter, map, collect keep type info.
    No Casting Required – Results are the right type automatically.
    Functional Style – Chain operations in a clean, readable way.
List<String> names = List.of("Alice", "Bob", "Charlie");
//public interface List<E>
//  public Stream<E> stream()
//public interface Stream<T>
//  Stream<T> filter(Predicate<? super T> predicate);

List<String> filtered = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());
System.out.println(filtered); // Output: [Alice]
```
## What Is Type Erasure and Why Should You Care?
```
    Replaces Type Parameters – T becomes its bound or Object.
    Compile Time – Done at compile time, not runtime.
    No Runtime Type Info – Reflection can’t access actual type arguments.
    Raw Types at Runtime – JVM sees List, not List<String>.
Example: Type Erasure in Action
Before Type Erasure (What Compiler Sees):
    class Box<T> {  // Generic class
        private T value;
        public void set(T value) { 
            this.value = value; 
        }
        public T get() { 
            return value; 
        }
    }
After Type Erasure (What JVM Sees):
    class Box {  // No generics at runtime
        private Object value;
        public void set(Object value) { 
            this.value = value; 
        }
        public Object get() { return value; }
    }

- Effects of Erasure
    No Type Info at Runtime – JVM forgets all generic details.
    instanceof Doesn’t Work – Can’t check for Box<String>.
    Type Checks Are Limited – All generics look the same to JVM.
Box<String> strBox = new Box<>();
// ❌ Compilation error
// if (strBox instanceof Box<String>) { } 

- Why Does Java Use Erasure?
    Backward Compatibility – Supports old Java code without generics.
    Simpler Bytecode – No extra bytecode for every generic type.
    No Runtime Overhead – Type info removed, so faster execution.
    Easier JVM Implementation – JVM doesn’t need to handle generics.
```
## How Can You Restrict Types Using Generics in Java?
```
1. Bounded Type (T extends SomeClass)
    What? Restricts T to subclasses of a specific class
    Why? Allows safe access to superclass methods
    Example? Accepts Integer, Double, Float – all extend Number
    Prevents? Using unrelated types like String or Boolean
class MathUtils<T extends Number> {
    public double square(T num) {
        //NOTE: Calling a Number specific method!
        return num.doubleValue() * num.doubleValue();
    }
}
MathUtils<Integer> intMath = new MathUtils<>();
System.out.println(intMath.square(5)); // Output: 25.0
// ❌ Compilation error: String is not a subclass of Number
// MathUtils<String> strMath = new MathUtils<>();

2. Multiple Bounds (T extends Class & Interface)
    What? Restricts T to extend a class and implement one or more interfaces
    Why? Ensures T has both class behavior and interface methods
    Example? T must extend Document and implement Printable
    Prevents? Using types that only meet one condition (just class or just interface)
interface Printable {
    void print();
}
class Document {}
class Report<T extends Document & Printable> {
    private T content;

    public Report(T content) {
        this.content = content;
    }
    public void printReport() {
        content.print();
    }
}
class MyReport extends Document implements Printable {
    public void print() {
        System.out.println("Printing report...");
    }
}
Report<MyReport> report = new Report<>(new MyReport());
report.printReport(); // Output: Printing report...

3. Upper Bound Wildcard in Methods (<? extends T>)
    What? Accepts any type that extends T (or is T itself)
    Example? You can pass Integer, Double, Float to a method expecting ? extends Number
    Safe For? Reading only, because all elements are guaranteed to be at least Number
    Prevents? Adding elements (compiler says: "I don’t know what exact type to accept!")
How It Works
    The method says: “Give me a list of something that’s a Number”
    But I don’t know what that “something” is (could be Integer, Double, etc.)
    So I’ll just read it — I can safely treat all items as Number
    But I won’t write to it — I might mess up the actual subtype stored inside
public class WildcardExample {
    public static void printNumbers(
            List<? extends Number> numbers) {
        for (Number n : numbers) {
            System.out.println(n);
        }
        // ❌ Not safe to add 
        // type could be Integer, Double, etc.
        // numbers.add(42); 
    }
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> dblList = List.of(1.1, 2.2);
        printNumbers(intList);  // ✅ Allowed
        printNumbers(dblList);  // ✅ Allowed
    }
}

4. Lower Bound Wildcard in Methods (? super T)
    What? Accepts T or any of its supertypes
    Example? Accepts Integer, Number, or Object for ? super Integer
    Why? Allows safely adding elements of type T
    Prevents? Reading elements as Integer – type is too generic to trust
How It Works
    The method says: “Give me a list that can hold an Integer”
    That could be a List<Integer>, List<Number>, or List<Object>
    You can safely write an Integer to any of those
    But reading? Nope. The compiler doesn’t know what exact type is inside
public class SuperExample {
    public static void addNumbers(
        List<? super Integer> numbers) {
        numbers.add(10); 
        numbers.add(20); // ✅ safe
        // ❌ Not safe to read as Integer
        // Compilation Error: Type Mismatch
        // numbers.get(0) is assumed of type Object
        // Integer num = numbers.get(0);
        //Needs Casting
        //Integer num = (Integer) numbers.get(0); 
    }
    public static void main(String[] args) {
        List<Number> nums = new ArrayList<>();
        // ✅ Number is a supertype of Integer
        addNumbers(nums); 
        List<Object> objs = new ArrayList<>();
        // ✅ Object is also a supertype
        addNumbers(objs); 
        System.out.println(nums); // Output: [10, 20]
    }
}
//Collections class
//Replaces all of the elements of the 
//specified list with the specified element.
//public static <T> void fill(
//            List<? super T> list, T obj) {}

5. Generic Method with Both Wildcards
    What? A method that uses both Upper Bound Wildcard (? extends T) and Lower Bound Wildcard (? super T)
    Why? Offers maximum flexibility for utility methods
    Example? Copy elements from one list to another
    Use Case? Utility methods in libraries like Collections.copy()
How It Works
    ? extends T → read from source (safe for reading)
    ? super T → write to destination (safe for writing)
    “Producer Extends, Consumer Super” (PECS rule) (collection's point of view)
    If you are only reading items from a generic collection, it is a producer => use extends
    If you are only writing items in, it is a consumer => use super.
    If you do both with the same collection, you shouldn't use either extends or super.
    Prevents? Copying incompatible types (like String into Integer list)
public class GenericUtils {
    public static <T> void copyElements(
        List<? super T> destination,
        List<? extends T> source) {        
        for (T item : source) {
            destination.add(item);
        }
    }
    public static void main(String[] args) {
        List<Integer> source = List.of(1, 2, 3);
        List<Number> destination = new ArrayList<>();
        // ✅ Integer → Number
        copyElements(destination, source);   
        // Output: [1, 2, 3]
        System.out.println(destination);   
    }
}
//Collections
//public static <T> void copy(
//  List<? super T> dest, List<? extends T> src) {}
```