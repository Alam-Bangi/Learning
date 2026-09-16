## What is Lombok?

 **Lombok is a Java library that reduces boilerplate code by using annotations.**

 It automatically generates common code such as **getters, setters, constructors, `toString()`, `equals()`, `hashCode()`, builders, and loggers** during compilation.

 **In simple words:**

 > Lombok helps you write **less Java code** by automatically generating repetitive code for you.

## Why do we use Lombok in Java?

 The main reason is **to reduce boilerplate code**.

 In normal Java, classes often contain a lot of repetitive code that doesn't represent actual business logic.

 For example, a class may need:

 - Getters and setters
- Constructors
- `toString()`
- `equals()`
- `hashCode()`
- Builder methods
- Logger creation
- Null checks

 Lombok generates much of this automatically using annotations.

 ### Main benefits

 1. **Less code**\
    You don't have to manually write repetitive methods.
2. **Better readability**\
    The class focuses more on its actual fields and business purpose rather than boilerplate.
3. **Faster development**\
    Common methods and constructors can be generated with a single annotation.
4. **Less repetitive maintenance**\
    When fields are added or removed, Lombok-generated methods automatically adapt.
5. **Cleaner DTOs and model classes**\
    This is particularly common in Spring Boot projects.
6. **Easy builder pattern**\
    `@Builder` can generate builder functionality without manually implementing the entire pattern.
7. **Easy logging**\
    `@Slf4j` can create the logger automatically.

 ### Simple way to remember

 **Without Lombok:**

 > "I have to write the same supporting code again and again."

 **With Lombok:**

 > "I tell Lombok what I need through annotations, and it generates the supporting code for me."

 ### One important drawback

 Lombok isn't magic at runtime. It works mainly during **compilation**, generating/modifying code that the Java compiler uses.

 Also, excessive use can sometimes make the actual generated behavior less obvious, so developers should understand what each annotation generates rather than blindly using `@Data` everywhere.

 **In short: Lombok = less boilerplate + cleaner Java classes + faster development.**