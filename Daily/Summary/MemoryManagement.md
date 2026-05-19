```
Java memory management revolves around how the Java Virtual Machine (JVM) organizes memory, allocates it to programs, and automatically frees unused memory using Garbage Collection (GC).

1. Heap Memory (Most Important Area)
    Heap memory is where objects and arrays are stored.
Characteristics
    Shared among all threads
    Dynamically allocated
    Managed by Garbage Collector
    Usually the largest memory area

Heap Structure
    Heap
    ├── Young Generation
    │     ├── Eden Space
    │     ├── Survivor S0
    │     └── Survivor S1
    │
    └── Old (Tenured) Generation

A. Young Generation
    Newly created objects are stored here.
        Eden Space
        Every new object starts in Eden.
    Example:
    Student s = new Student();
    The Student object goes into Eden space.

    Survivor Spaces (S0 and S1)
        Objects that survive garbage collection move here.
        Why Survivor Spaces Exist

    Most objects die quickly. Survivor spaces help JVM determine:
        Which objects are temporary
        Which objects live longer
        Minor Garbage Collection
    When Eden becomes full:
        JVM pauses application briefly.
        Removes unreachable objects.
        Moves surviving objects to Survivor space.
        This is called Minor GC.
    Object Aging
        Each object has an age count.
        If an object survives several GCs:
        It gets promoted to Old Generation.

B. Old Generation (Tenured Generation)
    Stores long-lived objects.
Examples:
    Cached data
    Singleton objects
    Session objects
    Major/Full GC
When Old Generation fills up:
    JVM performs Major GC or Full GC.
    Slower than Minor GC.
    Application pauses longer.

Heap Example
    class Employee {
        String name;
    }
    public class Main {
        public static void main(String[] args) {
            Employee e1 = new Employee();
            Employee e2 = new Employee();
        }
    }
What Happens Internally
    e1, e2 references → Stack
    Actual Employee objects → Heap
    Heap Memory Problems
    OutOfMemoryError
    Occurs when heap cannot allocate more memory.
Example:
    List<byte[]> list = new ArrayList<>();
    while(true){
        list.add(new byte[1024 * 1024]);
    }

Heap Tuning

Set heap size:
    -Xms512m
    -Xmx4g
    Xms = Initial heap
    Xmx = Maximum heap

2. Stack Memory
    Every thread has its own stack memory.
    What Stack Stores
    Each method call creates a stack frame containing:
        Local variables
        Method parameters
        Return address
        Partial results
    Stack Example
        public void test() {
            int x = 10;
            int y = 20;
        }
        x and y are stored in stack.
    Method Call Stack
        main()
        └── methodA()
                └── methodB()
        Each method gets its own frame.
    When method ends:
        Frame removed automatically.
        Stack Properties
        Fast Access
    Stack memory is very fast because:
        Allocation/deallocation follows LIFO order.
        Thread-Safe
        Each thread has separate stack.
        StackOverflowError
        Occurs when stack becomes full.
        Usually due to infinite recursion.
Example:
    void recursive() {
        recursive();
    }
Stack vs Heap
Feature	        Stack	            Heap
Stores	        Local vars	        Objects
Shared?	        No	                Yes
Speed	        Fast	            Slower
Managed by	    JVM automatically	Garbage Collector
Lifetime	    Method scope	    Until unreachable

3. Method Area / Metaspace
    Stores class-level information.
    Contains
        Class metadata
        Static variables
        Runtime constant pool
        Method bytecode
    Example
        class Demo {
            static int count = 0;
        }
        count is stored in Method Area.
    PermGen vs Metaspace
    Before Java 8
    Used Permanent Generation (PermGen).
    Problems:
        Fixed size
        Frequent OutOfMemoryError
        Java 8+
        Replaced by Metaspace.
    Advantages:
        Uses native memory
        Dynamically expands
        Metaspace Error
        java.lang.OutOfMemoryError: Metaspace
        Occurs if too many classes are loaded.

4. Program Counter (PC) Register
    Each thread has a PC register.
    Stores:
    Address of current JVM instruction.
    Needed because:
    JVM executes multiple threads simultaneously.

5. Native Method Stack
    Used for:
        Native methods written in C/C++
    Example:
        System.loadLibrary("nativeLib");
        JNI (Java Native Interface) uses native stacks.

Garbage Collection (GC) in Detail
    GC automatically removes unused objects.
        How JVM Determines Garbage
        Uses reachability analysis.
    If object cannot be reached from:
        Stack references
        Static references
        Active threads
    → Object becomes eligible for GC.
    Example
    Employee e = new Employee();
    e = null;
    The object becomes unreachable.

Types of References
    Strong Reference
    Normal reference.
        Employee e = new Employee();
        GC will NOT remove object.
    Weak Reference
        GC can remove object anytime.
    Used in:
        WeakHashMap
        Caching
        Soft Reference
        Collected only when memory is low.
    Used for:
        Memory-sensitive caches
        Phantom Reference
        Used for advanced cleanup mechanisms.

Garbage Collection Algorithms

A. Mark and Sweep
    Steps:
    Mark reachable objects.
    Remove unreachable objects.
    Problem:
    Memory fragmentation.

B. Mark-Compact
    Compacts memory after cleanup.
    Advantage:
    Reduces fragmentation.

C. Copying Algorithm
    Copies live objects from one area to another.
    Used in Young Generation.

Modern Garbage Collectors

1. Serial GC
    Single-threaded.
    Best for:
    Small applications

2. Parallel GC
    Uses multiple threads.
    Goal:
    High throughput

3. G1 GC (Garbage First)
    Default in modern Java.
    Features:
        Splits heap into regions
        Predictable pause times

4. ZGC
    Ultra-low pause collector.
    Best for:
        Large heaps
        Real-time systems
    Pause times:
        Usually under 10 ms

5. Shenandoah
    Low-pause collector from Red Hat.
    Garbage Collection Example
    for(int i=0; i<100000; i++) {
        String s = new String("Hello");
    }

Most objects:
    Become garbage quickly
    Collected in Young Generation
    JVM Memory Parameters
    Heap Settings
        -Xms1g
        -Xmx4g
    Stack Size
        -Xss2m
    Metaspace Size
        -XX:MetaspaceSize=256m

Monitoring JVM Memory

1. JVisualVM
    Monitors:
    Heap usage
    Threads
    GC activity

2. JConsole
    Built-in JVM monitoring tool.

3. Java Flight Recorder (JFR)
    Advanced profiling and diagnostics.

4. Heap Dumps
    Analyze memory leaks.
        Command:
        jmap -dump:live,file=heap.hprof <pid>
    Memory Leak in Java
        Java can still have leaks.
        Example:
        static List<Object> cache = new ArrayList<>();
        public void add() {
            cache.add(new Object());
        }
        Objects remain referenced forever.

Best Practices for Memory Management

1. Avoid Creating Unnecessary Objects
    Bad:
        String s = new String("hello");
    Good:
        String s = "hello";

2. Use StringBuilder for Concatenation
    Bad:
        String s = "";
        for(int i=0;i<1000;i++)
            s += i;
    Good:
        StringBuilder sb = new StringBuilder();

3. Close Resources
    Use try-with-resources:
    try(BufferedReader br = new BufferedReader(...)) {
    }

4. Prefer Primitive Types
    Primitives consume less memory.

5. Remove Unused References
    obj = null;
    Useful for large objects.
    Complete Memory Flow Example
    public class Main {
        static int counter = 0;
        public static void main(String[] args) {
            int x = 10;
            Person p = new Person();
        }
    }

Memory Allocation
Item	        Memory Area
counter	        Method Area
x	            Stack
p reference	    Stack
Person object	Heap

Simplified JVM Architecture

                JVM Memory
       +----------------------+
       |     Method Area      |
       +----------------------+
       +----------------------+
       |         Heap         |
       | Young Gen | Old Gen  |
       +----------------------+
       +----------------------+
       |        Stack         |
       |  Thread-specific     |
       +----------------------+
       +----------------------+
       |     PC Register      |
       +----------------------+
       +----------------------+
       |  Native Method Stack |
       +----------------------+
```
# Memory Spaces
```
| Memory Space | Stores                      | Shared? |
| ------------ | --------------------------- | ------- |
| Heap         | Objects                     | Yes     |
| Stack        | Local vars, method calls    | No      |
| Method Area  | Class metadata, static vars | Yes     |
| PC Register  | Current instruction         | No      |
| Native Stack | Native method execution     | No      |


Real JVM Flow

Java Code
    ↓
Compiled to Bytecode
    ↓
Loaded into Method Area
    ↓
Methods execute in Stack
    ↓
Objects created in Heap
    ↓
GC removes unused objects


Important Differences

Feature	        Heap        Stack
Stores	        Objects	    Local variables
Shared	        Yes	        No
Managed by GC	Yes	        No
Access Speed	Slower	    Faster
Memory Size	    Larger	    Smaller


Memory Allocation

Variable/Object	    Memory Space
count	            Method Area
x	                Stack
d reference	        Stack
Demo object	        Heap
Method execution	Stack Frames
Bytecode	        Method Area


Thread-wise Memory Usage

Memory Space	Shared or Private
Heap	        Shared
Method Area	    Shared
Stack	        Per-thread
PC Register	    Per-thread
Native Stack	Per-thread


Stack & Heap Memory

Features            Stack                          Heap
Stores              Local variables, method calls  Objects, instance variables
Lifespan            Cleared after method calls     Objects remain until GC removes them
Memory Management   Automatic                      By GC
Thread Scope        Each thread has its own stack  Shared among all threads
```
# Garbage Collection
```
Steps:
    1. Marking - Finds object still in use.
    2. Sweeping - Removes unused objects from memory.
    3. Compacting - Rearranges memory to avoid fragmentation.

Why is it Complex?

Task Complexity
Finding unused objects          Objects may be referenced indirectly
Minimizing Application pauses   GC involves a lot of work. Doing GC 
                                without impact running applications can be a challenge.
Avoiding Memory Fragmentation   Free memory may be scattered.
Providing flexibility           Different applications have different needs.

- GENERATIONS IN GC

Java divides heap memory into generations to improve Garbage Collection performance.
1. Young Generation
    Stores newly created objects.
    Contains:
    Eden Space → new objects created here
    Survivor S0 & S1 → objects that survive Minor GC
    Most objects die here quickly.
    GC Type:
    Minor GC

2. Old (Tenured) Generation
    Stores long-lived objects that survive many Minor GCs.
    GC Type:
    Major / Full GC

3. Metaspace
    Stores:
    Class metadata
    Method information
    Static structures
    (Not part of heap)

Object Lifecycle
    New Object
    ↓
    Eden
    ↓
    Survivor Spaces
    ↓
    Old Generation
    ↓
    Garbage Collected

Quick Difference

Generation	Purpose
Young Gen	Temporary objects
Old Gen	    Long-living objects
Metaspace	Class metadata

Key Point
    Most objects die young, so JVM cleans Young Generation frequently for better performance.

- STOP THE WORLD GC
    - STW GC pauses all app threads for GC.
    - No user code runs during this time.
    - Ensures memory safety but affects performance and response time.

When does it occur?
    - Minor GC: Brief pause for young generation cleanup.
    - Major GC(Full GC): Longer pause for old generation cleanup.
    - New GC methods: Aim to reduce oe eliminate the STW pauses.

- TYPES
| GC Type     | Threads    | Pause Time | Best For         |
| ----------- | ---------- | ---------- | ---------------- |
| Serial GC   | Single     | High       | Small apps       |
| Parallel GC | Multiple   | Medium     | High throughput  |
| CMS GC      | Multiple   | Low        | Responsive apps  |
| G1 GC       | Multiple   | Low        | General purpose  |
| ZGC         | Concurrent | Very Low   | Large heaps      |
| Shenandoah  | Concurrent | Very Low   | Low latency apps |

- CATEGORIES
    - Stop-the-World GC
    Application pauses during cleanup.
    Examples:
        Serial GC
        Parallel GC
        Concurrent GC
    
    - GC works alongside application threads.
    Examples:
    CMS
    G1
    ZGC
    Shenandoah

- CUSTOMIZATION FOR GC
| Option               | Description                                                        | Example                                           |
| -------------------- | ------------------------------------------------------------------ | ------------------------------------------------- |
| `-XX:+UseSerialGC`   | Enables **Serial GC** (single-threaded, best for small apps)       | `java -XX:+UseSerialGC MyApp `   |
| `-XX:+UseParallelGC` | Enables **Parallel GC** (multi-threaded, good for high throughput) | `java -XX:+UseParallelGC MyApp ` |
| `-XX:+UseG1GC`       | Enables **G1 GC** (low-latency, region-based GC)                   | `java -XX:+UseG1GC MyApp `       |
| `-XX:+UseZGC`        | Enables **ZGC** (fully concurrent, ultra-low pause time)           | `java -XX:+UseZGC MyApp `        |
| `-Xms<size>`         | Sets **initial heap size**                                         | `java -Xms512m MyApp `           |
| `-Xmx<size>`         | Sets **maximum heap size**                                         | `java -Xmx2g MyApp `             |
| `-XX:+PrintGCDetails | Prints detailed GC logs                                            | `java -XX:+PrintGCDetails MyApp` |
```
# Reference Counting vs Mark & Sweep
```
- Reference counting
    - Each object has a refernce counter, tracking how many references point to it.
    - When count gets to zero, objects is eligible for GC.
    - It's simple and fast.
    - Memory can be freed as soon as references are zero.
    - Fails with circular references. 2 objects refering each other wont be collected.

- Mark & Sweep
    - JVM scans heap and marks reachable objects.
    - Unmarked objects are deleted(sweeped).
    - Avoids circular reference issues.

- 
Features                        Reference Counting                                  Mark & Sweep
Concept                         Tracks the number of references to each object.     Scans memory and marks reachable objects.
Performance                     Fast(Immediate cleanup)                             Slow(Needs to scan memory)
Handles Circular references     Fails                                               Works correctly
Used in java                    No                                                  Yes
```