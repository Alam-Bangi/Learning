
> "The `System` class is a final utility class in the `java.lang` package. It provides access to system-level resources and utilities, so we don't create objects of it because all of its commonly used members are static.

Some of the most common uses are:

> * `System.out` for standard output, such as `System.out.println()`.
> * `System.err` for printing error messages.
> * `System.in` for reading input from the keyboard.
> * `System.currentTimeMillis()` and `System.nanoTime()` for measuring time.
> * `System.exit(int)` to terminate the JVM.
> * `System.getenv()` to access environment variables.
> * `System.getProperty()` to retrieve JVM system properties like the Java version or OS name.
> * `System.arraycopy()` to efficiently copy elements from one array to another.
> * `System.gc()` to request garbage collection, although the JVM is not required to run it immediately."

### If they ask "Why is `System` final?"

> "The `System` class is final to prevent inheritance. Since it provides core JVM functionality like input/output, system properties, and process termination, Java prevents it from being extended or its behavior being modified."

### If they ask "Why are the methods static?"

> "The methods are static because they provide global JVM-level functionality rather than behavior tied to an object. There's only one standard input, output, and environment for a running JVM, so creating instances of `System` isn't necessary."

### Common interview follow-up questions

**Q: Difference between `System.out` and `System.err`?**

* `System.out` is the standard output stream.
* `System.err` is the standard error stream, typically used for error messages.

**Q: Difference between `currentTimeMillis()` and `nanoTime()`?**

* `currentTimeMillis()` returns the current wall-clock time since January 1, 1970.
* `nanoTime()` is used for measuring elapsed time with higher precision and should not be used as the current date/time.

**Q: Why is `System.arraycopy()` preferred over a loop?**

* It's a native method optimized for performance, making it generally faster than copying elements one by one in Java.

### A concise 1-minute interview answer

> "The `System` class is a final class in the `java.lang` package that provides access to system-level resources. Since its members are static, we don't instantiate it. We commonly use `System.out.println()` for output, `System.in` for input, `System.err` for error messages, `currentTimeMillis()` and `nanoTime()` for timing, `getProperty()` and `getenv()` for configuration information, `arraycopy()` for efficient array copying, and `exit()` to terminate the JVM. It's final to prevent modification of these core JVM services."
