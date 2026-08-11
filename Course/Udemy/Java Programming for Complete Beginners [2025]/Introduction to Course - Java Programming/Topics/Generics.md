
> “Generics in Java allow us to write classes, interfaces, and methods that can work with different data types while providing compile-time type safety.

> For example, instead of using a raw `List` and casting objects manually, I can use `List<String>`. This tells the compiler that the list should contain only strings.

> ```java
> List<String> names = new ArrayList<>();
> names.add("John");
> // names.add(10); // compile-time error
> ```

> The main benefits of generics are **type safety, avoiding unnecessary type casting, and writing reusable code**.

> Java generics are implemented using **type erasure**, so generic type information is primarily used by the compiler and isn't generally available at runtime.”

### If the interviewer asks for more

You can explain a generic class:
```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
Box<String> box = new Box<>();
box.set("Hello");

String value = box.get();
```

Here, `T` is a **type parameter**. When we create `Box<String>`, `T` effectively represents `String`.

### Know these common follow-ups
**1. What is `<?>`?**
> “`<?>` is an unbounded wildcard. It means the collection can contain objects of some unknown type.”

```java
List<?> list;
```

**2. `extends` vs `super`?**
A good interview rule is **PECS — Producer Extends, Consumer Super**.

```java
List<? extends Number>   // producer: read Numbers
List<? super Integer>    // consumer: can add Integers
```

**3. Why can't we use primitives?**
```java
List<int>       // ❌
List<Integer>   // ✅
```

Generics work with reference types, so we use wrapper classes such as `Integer`, `Double`, etc.

**Interview tip:** Don't start with type erasure, wildcards, or PECS unless asked. Start with **“generics provide compile-time type safety and reusable code”**, then demonstrate it with `List<String>`. That sounds much clearer and more confident.
