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