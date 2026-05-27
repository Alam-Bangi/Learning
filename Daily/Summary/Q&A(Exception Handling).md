- [Exception Handling](https://interview.in28minutes.com/interview-guides/java/exception-handling-in-java/#why-is-exception-handling-important%3F)
```
1. Can finally block override return statement?
    Yes.
    class Test {
        static int m1() {
            try {
                return 10;
            } finally {
                return 20;
            }
        }
        public static void main(String[] args) {
            System.out.println(m1());
        }
    }
    Output:
    20
    The finally return overrides the try return.

2. Is returning from finally block good practice?
    No.
    Because it:
    suppresses exceptions
    hides bugs
    creates debugging nightmares

3. Can finally block change variable value?
    Yes.
    static int test() {
        int x = 10;
        try {
            return x;
        } finally {
            x = 20;
        }
    }
    Output:
    10
    Because primitive return value is copied before finally executes.

4. What if object is returned and modified in finally?
    Object changes WILL reflect.
    class A {
        int x = 10;
    }
    static A test() {
        A obj = new A();

        try {
            return obj;
        } finally {
            obj.x = 99;
        }
    }
    Output:
    99
    Because object reference is returned.

5. Can catch block catch parent before child?
    No.
    Wrong:
    catch(Exception e) {}
    catch(IOException e) {}
    Compile-time error:
    Unreachable catch block
    Child must come first.

6. Can we write empty catch block?
    Yes, but dangerous.
    catch(Exception e) {}
    This is called:
    swallowing exception
    exception suppression
    Very bad practice.

7. What happens if exception occurs inside catch block?
    Another exception propagates outward.
    try {
        int x = 10 / 0;
    } catch(Exception e) {
        String s = null;
        s.length();
    }
    New exception:
    NullPointerException

8. What happens if finally throws exception?
    It overrides previous exception.
    try {
        int x = 10 / 0;
    } finally {
        throw new RuntimeException();
    }
    Visible exception:
        RuntimeException
        Original ArithmeticException disappears.

9. Can try exist without catch and finally?
    No.
    Invalid:
    try {

    }
    Must have:
    catch
    OR
    finally

10. Which executes first: return or finally?
    finally executes first.
    Flow:
    return prepared
    finally executes
    value returned

11. Can System.exit() stop finally?
    Yes.
    try {
        System.exit(0);
    } finally {
        System.out.println("Won't execute");
    }

12. Does JVM always create exception object?
    Yes.
    Every thrown exception is an object.

13. Why exceptions are slow?
    Because JVM must:
    create stack trace
    unwind call stack
    allocate objects
    Exception creation is expensive.

14. Is exception handling expensive?
    Yes.
    Especially:
    throwing frequently
    using exceptions in loops
    Never use exceptions for normal logic.

15. Why RuntimeException exists?
    To avoid excessive boilerplate.
    Unchecked exceptions represent:
        programming mistakes
        logic bugs
    Examples:
        NullPointerException
        IllegalArgumentException

16. Why checked exceptions are controversial?
    Because they:
    increase verbosity
    pollute method signatures
    create unnecessary handling
    Many modern frameworks avoid them.

17. Why does Java force checked exception handling?
    Java designers wanted:
        reliability
        safer APIs
    Especially for:
        file handling
        networking
        databases

18. Can constructor throw exception?
    Yes.
    class A {
        A() throws Exception {
            throw new Exception();
        }
    }

19. If constructor throws exception, is object created?
    No.
    Object creation remains incomplete.

20. Can static block throw exception?
    Yes.
    static {
        int x = 10 / 0;
    }
    Causes:
    ExceptionInInitializerError

21. What is ExceptionInInitializerError?
    Occurs when static initialization fails.

22. Can main method throw exception?
    Yes.
    public static void main(String[] args) throws Exception {
    }

23. What happens if main throws exception?
    JVM handles it and terminates program.

24. Why Throwable is superclass of Error and Exception?
    Because JVM wanted unified handling mechanism.

25. Can we directly instantiate Throwable?
    Yes.
    throw new Throwable();
    But rarely used.

26. Can we catch Error?
    Yes.
    catch(Error e)
    But usually bad idea.
    Errors indicate serious JVM problems.

27. Difference between StackOverflowError and OutOfMemoryError
StackOverflowError	    OutOfMemoryError
Stack memory full	    Heap memory full
Infinite recursion	    Object allocation failure

28. What is suppressed exception?
    In try-with-resources:
    original exception preserved
    closing exception suppressed

29. How to get suppressed exceptions?
    e.getSuppressed();

30. What happens if both try and close() throw exceptions?
    try exception becomes primary.
    close() exception becomes suppressed.

31. Why AutoCloseable introduced?
    To support automatic resource cleanup.

32. Difference between Closeable and AutoCloseable
Closeable	        AutoCloseable
throws IOException	throws Exception
Narrower	        Broader

33. Can finally fail?
    Yes.

    Example:

    finally {
    int x = 10 / 0;
    }

34. Can exception occur before main starts?
    Yes.
    Examples:
    static block failure
    class loading issues

35. What is NoClassDefFoundError?
    Class existed during compilation but missing during runtime.

36. Difference between ClassNotFoundException and NoClassDefFoundError
ClassNotFoundException	        NoClassDefFoundError
Checked exception	            Error
Happens during dynamic loading	Class missing at runtime

37. Why NullPointerException is so common?
    Because Java references can be null.

38. Best way to avoid NullPointerException?
    null checks
    Optional
    defensive programming

39. Can catch block itself throw checked exception?
    Yes.
    catch(Exception e) {
        throw new IOException();
    }

40. Can we throw interface type?
    No.
    Must throw subclass of Throwable.

41. Can abstract class extend Throwable?
    Yes.

42. Can Throwable implement interface?
    Yes.
    Like any Java class.

43. What is chained exception?
    One exception wrapped inside another.
    throw new RuntimeException(e);

44. Why wrap exceptions?
    To:
    add abstraction
    hide implementation details

45. What is root cause analysis?
    Finding original underlying exception.
    Using:
    e.getCause();

46. Why exception messages matter?
    Good messages:
        reduce debugging time
        improve maintainability
    Bad:
        Error occurred
    Good:
        Invalid user id: 105

47. Why logging exception is important?
    Without logs:
    production debugging becomes difficult

48. Why catch(Exception) is dangerous?
    It may:
    hide important bugs
    catch unintended exceptions

49. Why catching Throwable is terrible?
    Because it catches:
    Errors
    JVM failures
    May destabilize application.

50. Can exceptions affect performance optimization?
    Yes.
    JIT compiler optimizations may reduce around exception-heavy code.

51. What is fail-fast philosophy?
    Stop execution immediately on invalid state.

52. Why exceptions should not control loops?
    Bad:
    try {
    while(true) {
        arr[i++];
    }
    } catch(Exception e) {}
    Very poor performance.

53. What is hidden cost of stack trace?
    Capturing stack trace is CPU expensive.

54. Can stack trace be disabled?
    Yes.
    Advanced constructor:
    super(message, cause, false, false);
    Used in high-performance systems.

55. Why immutable exceptions are preferred?
    Thread safety.

56. What is exception transparency?
    Method should expose actual meaningful exceptions.

57. What is exception translation?
    Convert low-level exception into business-level exception.
    Example:
    SQLException
    →
    DatabaseException

58. What is exception masking?
    One exception hiding another exception.
    Often caused by finally block.

59. What is phantom exception bug?
    Exception occurred but disappeared due to bad handling.

60. Most dangerous exception handling mistake?
    This:
    catch(Exception e) {
    }
    Silent failure = nightmare debugging.
```
### Interview
```
1. What is exception handling in Java?
    Exception handling is a mechanism to handle runtime errors and maintain normal program flow.

2. What is an exception?
    An exception is an abnormal event that disrupts program execution.
    Examples:
    Divide by zero
    File not found
    Null reference

3. What is the superclass of all exceptions?
    Java Throwable
    Hierarchy:
    Throwable
    ├── Error
    └── Exception
    
4. Difference between Error and Exception?
Error	                    Exception
JVM/System problem	        Application problem
Not recoverable	            Recoverable
Example: OutOfMemoryError	Example: IOException

5. What are checked exceptions?
    Exceptions checked at compile time.
    Examples:
        IOException
        SQLException
    Must be handled using:
        try-catch
        throws

6. What are unchecked exceptions?
    Exceptions checked at runtime.
    Examples:
        NullPointerException
        ArithmeticException
    Subclass of:
        RuntimeException

7. Difference between checked and unchecked exceptions?
Checked	                Unchecked
Compile-time	        Runtime
Must handle	            Optional
Exception subclass	    RuntimeException subclass

8. What is try block?
    Contains risky code.
    try {
        int x = 10 / 0;
    }

9. What is catch block?
    Handles exception.
    catch(Exception e) {
        System.out.println(e);
    }

10. What is finally block?
    Always executes whether exception occurs or not.
    Used for:
    cleanup
    closing resources

- Important Tricky Questions

11. Will finally always execute?
    No.
    Cases where it may not execute:
    System.exit(0)
    JVM crash
    power failure

12. Can try exist without catch?
    Yes.
    try {

    } finally {

    }

13. Can try exist without finally?
    Yes.
    try {

    } catch(Exception e) {

    }

14. Can try exist alone?
    No.
    Must have:
    catch
    OR
    finally

15. Can we write multiple catch blocks?
    Yes.
    try {

    } catch(IOException e) {

    } catch(Exception e) {

    }

16. Why child catch must come before parent catch?
    Otherwise child catch becomes unreachable.
    Wrong:
    catch(Exception e) {}
    catch(IOException e) {}
    Compile-time error.

17. Difference between throw and throws?
throw	                    throws
Used to throw exception	    Used to declare exception
Inside method	            Method signature

18. What is throw keyword?
    Used to explicitly throw exception.
    throw new ArithmeticException();

19. What is throws keyword?
    Declares exception responsibility.
    void m1() throws IOException

20. Can finally block override return?
    Yes.
    try {
        return 10;
    } finally {
        return 20;
    }
    Output:
    20
    Runtime Exception Questions

21. What is NullPointerException?
    Occurs when accessing null reference.
    String s = null;
    s.length();

22. What is ArithmeticException?
    Arithmetic error.
    10 / 0

23. What is ArrayIndexOutOfBoundsException?
    Invalid array index access.

24. What is NumberFormatException?
    Invalid string-to-number conversion.
    Integer.parseInt("abc");

25. What is ClassCastException?
    Invalid object casting.

- Advanced Interview Questions

26. What is exception propagation?
    Passing exception from one method to another.
    m1() → m2() → m3()

27. Can checked exceptions propagate?
    Yes, using throws.

28. Can unchecked exceptions propagate?
    Yes, automatically.

29. What is stack trace?
    Sequence of method calls before exception occurred.
    e.printStackTrace();

30. Difference between final, finally, finalize?
final	                finally	    finalize
keyword	                block	    method
constant/restriction	cleanup	    garbage collection

31. What is custom exception?
    User-defined exception.
    class MyException extends Exception {
    }

32. Why custom exceptions are used?
    To represent business-specific errors.
    Examples:
    InvalidAgeException
    InsufficientBalanceException

33. Difference between Exception and RuntimeException?
Exception	    RuntimeException
Checked	        Unchecked

34. Can constructor throw exception?
    Yes.
    A() throws Exception

35. Can static block throw exception?
    Yes.
    Leads to:
    ExceptionInInitializerError

36. What is ExceptionInInitializerError?
    Occurs when static initialization fails.

37. Can main method throw exception?
    Yes.
    public static void main(String[] args) throws Exception

38. Can we catch Throwable?
    Yes, but not recommended.
    Because it catches:
    Exception
    Error

39. Why catching Throwable is dangerous?
    May catch serious JVM errors.
    Examples:
    OutOfMemoryError
    StackOverflowError

40. Difference between ClassNotFoundException and NoClassDefFoundError?
ClassNotFoundException	    NoClassDefFoundError
Checked exception	        Error
During dynamic loading	    Missing class at runtime

- Try-With-Resources Questions

41. What is try-with-resources?
    Automatically closes resources.
    try(FileReader fr = new FileReader("a.txt")) {

    }

42. Which interface is required?
    AutoCloseable

43. Difference between AutoCloseable and Closeable?
AutoCloseable	    Closeable
throws Exception	throws IOException

44. What are suppressed exceptions?
    Exceptions suppressed during automatic resource closing.

45. How to get suppressed exceptions?
    e.getSuppressed();
    Best Practices Questions

46. Why empty catch block is dangerous?
    It hides bugs.
    Bad:
    catch(Exception e) {
    }

47. Why should we catch specific exceptions?
    Improves:
    debugging
    readability
    maintainability

48. Why exceptions should not be used for normal flow?
    Because exception handling is expensive.

49. What is exception translation?
    Converting low-level exception into business exception.
    Example:
    SQLException
    → DatabaseException

50. What is root cause analysis?
    Finding original exception using:
    e.getCause();

Most Asked Coding Programs

1. Divide by Zero Handling
    class Test {
        public static void main(String[] args) {
            try {
                int x = 10 / 0;
            } catch(ArithmeticException e) {
                System.out.println("Cannot divide by zero");
            }
        }
    }

2. Custom Exception Program
    class InvalidAgeException extends Exception {
        InvalidAgeException(String msg) {
            super(msg);
        }
    }
    class Test {
        static void checkAge(int age)
                throws InvalidAgeException {

            if(age < 18)
                throw new InvalidAgeException("Not eligible");
        }
        public static void main(String[] args) {
            try {
                checkAge(15);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

3. Finally Block Example
    class Test {
        public static void main(String[] args) {

            try {
                int x = 10 / 0;
            } catch(Exception e) {
                System.out.println("Exception");
            } finally {
                System.out.println("Finally");
            }
        }
    }
    Output:
    Exception
    Finally
```
## Why is Exception Handling Important?
```
Exceptions Happen Regularly
Why? Complex code, changing environments, and human errors
    Defects Are Inevitable – Even great developers miss edge cases
    Runtime Surprises – Files missing, servers down, data corrupted
    External Systems Fail – APIs, databases, and networks aren’t always reliable
    Environment Changes – OS updates, memory limits, config issues, etc.
    Moral of the Story? Expect exceptions. Handle them gracefully.
Need to Handle Them Properly
What? Handling exceptions isn't just about catching them
    It's about solving them gracefully without scaring your end users!
1. User Communication
    Show friendly, non-technical error messages
    Avoid app crashes or ugly stack traces
    Display a unique error ID the user can report
    Guide users on how to contact support
2. Debugging Support
    Log the full stack trace and context
    Include the same error ID shown to the user
    Capture input data, user actions, or environment details
    Helps support/dev teams trace and fix the issue fast
```
## Which Design Pattern Powers Java's Exception Flow?
```
Chain of Responsibility: A behavioral pattern where a request moves through a chain of handlers
    Why?: Decouples sender and receiver — each handler decides to process or pass along
How It Works:
    Exception travels up the call stack method by method
    Each method can catch or pass the exception higher
    Stops when an appropriate handler is found
Real-World Analogy:
    Like a leave request going from employee → manager → HR
    Each can approve or escalate the request
```
## Can You Walk Through a Practical Example of Java Exception Handling?
```
    PaymentApp Tries to make a payment of $600 (more than balance) using PaymentService
    Custom exception InsufficientFundsException extends Exception
    PaymentService throws InsufficientFundsException if not enough money
    PaymentApp Uses try-catch-finally to handle exceptions cleanly
    Logs and prints appropriate error or success messages
    Always prints “Transaction attempt completed” using finally
public class PaymentApp {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        try {
            paymentService.makePayment(600);
        } catch (InsufficientFundsException e) {
            System.err.println(
                "Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(
                "Invalid Input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(
                "Unexpected error: " + e.getMessage());
        } finally {
            System.out.println(
                "Transaction attempt completed.");
        }
    }
}
class PaymentService {
    private static final Logger logger 
        = Logger.getLogger(PaymentService.class.getName());
    private double balance = 500.0;  // Initial balance
    public void makePayment(double amount) throws InsufficientFundsException {
        logger.info("Processing payment of $" + amount);
        if (amount <= 0) {
            throw new IllegalArgumentException
                ("Payment amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException
                ("Available balance: $" 
                    + balance);
        }
        balance -= amount;
        System.out.println
            ("Payment of $" + amount + " successful. Remaining balance: $" + balance);
    }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```
## What Happens When You Swallow Exceptions — And Why Is It Bad?
```
    What? An exception is caught but silently ignored
    Why It's Bad? Looks like everything is fine... but it's not
    No Logging = No Clues – Developer's can't trace what went wrong
    Program Continues – But state might be broken or inconsistent
    Result? Bugs hide, grow, and jump out later in weirder places
❌ Example of Exception Swallowing (Bad Practice)
    try {
        int[] numbers = {1, 2};
        // ❌ ArrayIndexOutOfBoundsException
        System.out.println(numbers[3]); 
    } catch (Exception e) {
        // ❌ Exception is caught but ignored
    }
    System.out.println("Program continues...");
Why Is This a Problem?
    No Clue Something Broke – Developer can’t fix what they can’t see
    Silent Failures = Sneaky Bugs – App keeps running in a bad state
    Delayed Explosions – Errors surface much later in unrelated places
    Wasted Time – Debugging without logs is like finding a needle in a dark room
    ✅ Always log, handle, or rethrow exceptions
    Your future self (and your team) will thank you!
```
## In What Scenarios is Code in finally Not Executed?
```
❌ Example Without finally (Problem Case)
    Connection connection = new Connection();
    connection.open();
    try {
        String str = null;
        str.toString();
    } catch (Exception e) {
        System.out.println("Exception Handled - Method 2");
    } // Connection is never closed if exception occurs ❌
Problem: If an exception occurs, opened connections may remain unclosed.
✅ Example With finally (Proper Resource Cleanup)
    Connection connection = new Connection();
    connection.open();
    try {
        String str = null;
        str.toString();
    } catch (Exception e) {
        System.out.println("Exception Handled - Method 2");
    } finally {
        // Ensures connection is always closed ✅
        connection.close();  
    }
finally is NOT executed in these two cases
    Exception Inside finally – If something goes wrong inside finally, it may skip the rest
    JVM Shutdown – If the JVM dies (e.g., System.exit() or crash), finally won’t get a chance
```
## What Combinations of try, catch, and finally Are Allowed?
```
try + catch – ✅ Allowed
    Handles exceptions, no need for finally
    try {
        riskyThing();
    } catch (Exception e) {
        handleIt(e);
    }
try + finally – ✅ Allowed
    Cleanup logic runs, even without handling exceptions
    try {
        riskyThing();
    } finally {
        cleanup();
    }
try + catch + finally – ✅ Allowed
    The full combo: handle errors + cleanup
    try {
        riskyThing();
    } catch (Exception e) {
        handleIt(e);
    } finally {
        cleanup();
    }
try Alone – ❌ Not allowed
    Compilation error: must have at least a catch or finally
try {
    riskyThing();
} // ❌ Error: Missing catch or finally
```
## What Is the Class Hierarchy Behind Java Exceptions?
```
Class Name	                        Category(Parent)	        Checked?	        Description
Throwable	                        —	                        —	                Root of all exceptions and errors
Error	                            Throwable	                No	                Serious system-level issues
OutOfMemoryError	                VirtualMachineError (Error)	No	                JVM ran out of memory
StackOverflowError	                VirtualMachineError (Error)	No	                Stack memory exhausted (e.g., recursion)
Exception	                        Throwable	                Yes	                Base for all application exceptions
IOException	                        Exception	                Yes	                Input/output failure
SQLException	                    Exception	                Yes	                Database access error
ClassNotFoundException	            Exception	                Yes	                Class loading failed
RuntimeException	                Exception	                No	                Base for unchecked exceptions
NullPointerException                RuntimeException	        No	                Accessing null reference
ArrayIndexOutOfBoundsException	    RuntimeException	        No	                Invalid array index
IllegalArgumentExceptn              RuntimeException	        No	                Invalid method argument
Arithmetic Exception	            RuntimeException	        No	                Math error (e.g., divide by zero)
                            Error vs Exception
Error	                                        Exception
Used for critical system failures.	            Used for recoverable issues.
Cannot be handled by the programmer.	        Can be handled by the programmer.
Eg: StackOverflowError, OutOfMemoryError.	    Eg: IOException, NullPointerException.
```
## What Are Chained Exceptions?
```
    What? Chained exceptions allow you to link one exception to another
    Why? To show the original cause of an exception
    How? Use initCause() method
    Helps With? Debugging and tracing multi-layered errors
Common Use Case:
    You catch a low-level exception and wrap it inside a higher-level one
    This way, you don’t lose the original stack trace
        try {
            validate(null);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            System.out.println("Caused by: " 
                                + e.getCause());
        }
    static void validate(String name) throws Exception {
        try {
            if (name == null) {
                throw new NullPointerException("Username is null");
            }
        } catch (NullPointerException e) {
            Exception wrapped = new Exception("User validation failed");
            wrapped.initCause(e); // ✅ Linking original cause
            throw wrapped;
        } } 
```
## What Are the Best Practices for Handling Exceptions in Java?
```
1. Never Hide Exceptions – Always log them, even if you re-throw or recover
    Why? Silent failures are hard to debug
2. User-Friendly Messages – Show clear, non-technical messages to users
    Why? Users shouldn't see scary stack traces
3. Provide Debugging Info – Log stack traces and context for developers
    Why? Helps devs trace root cause
4. Global Exception Handling – Use centralized mechanisms (like @ControllerAdvice in Spring)
    Why? Avoids duplicate try-catch blocks everywhere
5. Avoid Misusing Exceptions – Don’t use exceptions for expected logic like looping or validation
    Why? Bad for performance and readability
```
## What Are the Newer Java Features That Help with Exception Handling?
```
1. Try-With-Resources (Automatic Resource Management)
    What? A try block that automatically closes resources
    Why? No need for manual finally cleanup
    When? Use with classes that implement AutoCloseable
    Benefit? Less boilerplate, fewer resource leaks
Common Resources:
        BufferedReader, FileInputStream, Connection, Scanner
        try (BufferedReader br = 
            new BufferedReader( new FileReader("file.txt"))) {         
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Use with classes that implement AutoCloseable
        public interface AutoCloseable {
            void close() throws Exception;
        }
2. Multi-Catch Block
    What? Handle multiple exception types in one catch block
    How? Use | to separate exception classes
    Why? Avoids repeating the same logic for different exceptions
    When? When multiple exceptions need the same handling
        try {
            methodThatThrowsException();
        // Multi-catch block
        } catch (IOException | SQLException ex) {  
            System.err.println("Exception occurred: " + ex.getMessage());
        }
3. Optional.orElseThrow()
    What? Throws an exception if the value is absent
    Why? Avoids null checks and improves readability
    When? Use when a value is required and absence is exceptional
    Benefit? Cleaner, expressive, and avoids if (optional.isPresent())
Optional<String> name = Optional.ofNullable(null);
String result = name.orElseThrow(
    () -> new IllegalArgumentException("Value is missing"));
```