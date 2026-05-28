- ## [Built-in Classes](https://interview.in28minutes.com/interview-guides/java/built-in-classes-in-java/)
## Object
```
What?
    Object is the root class for all Java classes.
Why?
    Ensures that all Java objects have basic functionality, such as comparison (equals()), hashing (hashCode()), and string representation (toString()). In addition, there are several methods related to synchronizing threads (wait(),notify(),notifyAll()).
An Example:
    class Example {
        int id;

        Example(int id) {
            this.id = id;
        }
        @Override
        public String toString() {
            return "Example ID: " + id;
        }
    }
    public class ObjectExample {
        public static void main(String[] args) {
            Example obj = new Example(10);
            System.out.println(obj.toString());  // Output: Example ID: 10
        }
    }
--- Common Methods in java.lang.Object ---
Method	                            Type	    Purpose
hashCode()	                        Instance	Returns hash code for the object (used in collections like HashMap)
toString()	                        Instance	Returns string representation of the object
getClass()	                        Instance	Returns runtime class of the object (Class<?>)
clone()	                            Instance	Creates and returns a copy of the object (requires Cloneable)
finalize()	                        Instance	Called by GC before object is collected (Deprecated in Java 9+)
wait()	                            Instance	Pauses the current thread until notified (used with synchronized)
wait(long timeoutMillis)	        Instance	Waits for a specified time (ms)
wait(long timeoutMillis, int nanos)	Instance	Waits for specified time
notify()	                        Instance	Wakes up one thread waiting on the object
notifyAll()	                        Instance	Wakes up all threads waiting on the object
```
## Void
```
What?
    Void is a special class that represents the absence of a return value.
Example Usecase
    Used in generics where a method does not return any value.
Example: Future<Void>
    import java.util.concurrent.*;

    public class FutureVoidExample {
        public static void main(String[] args) throws Exception {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Void> future = executor.submit(() -> {
                System.out.println("Running task...");
                return null; // Do something, but return nothing
            });
            // Wait for task to complete
            future.get(); // Returns null
            System.out.println("Task done!");
            executor.shutdown();
        }
    }
Example: Using Void with Generics
    class Task<I, R> {
        private I input;
        private R result;

        public Task(I input, R result) {
            this.input = input;
            this.result = result;
        }
        public R process() {
            System.out.println("Processing input: " + input);
            if (result != null) {
                System.out.println("Returning result: " + result);
            } else {
                System.out.println("Returning no result (Void)");
            }
            return result;
        }
    }
    Task<String, Integer> wordLength = new Task<>("Hello", 5);
    Integer length = wordLength.process();
    // Output:
    // Processing input: Hello
    // Returning result: 5

    Task<String, Void> logTask = new Task<>("Log this", null);
    Void result = logTask.process();
    // Output:
    // Processing input: Log this
    // Returning no result (Void)
```
## Runtime
```
What?
    Runtime allows interaction with the JVM, such as executing system commands and managing memory.
Why?
    Used for memory optimization and running external system processes.
An Example:
    public class RuntimeExample {
        public static void main(String[] args) throws Exception {
            Runtime runtime = Runtime.getRuntime();
            // 1️⃣ Get Available Processors (CPU Cores)
            System.out.println("Available Processors: " + runtime.availableProcessors());
            // 2️⃣ Get Free Memory in JVM
            System.out.println("Free Memory: " + runtime.freeMemory() + " bytes");
            // 3️⃣ Get Total Memory in JVM
            System.out.println("Total Memory: " + runtime.totalMemory() + " bytes");
            // 4️⃣ Get Maximum Memory JVM Can Use
            System.out.println("Max Memory: " + runtime.maxMemory() + " bytes");
            // 5️⃣ Run an External System Command
            Process process = runtime.exec("echo Hello, World!");
            // Wait for command to finish
            process.waitFor(); 
            // 6️⃣ Request Garbage Collection
            runtime.gc();
            // 7️⃣ Shutdown the JVM 
            // 0 (Normal Exit)
            // Non Zero (abnormal termination)
            // runtime.exit(0);
        }
    }
```
## System
```
What?
    System provides system-level functionalities like console I/O, environment variables, and system properties.
Why?
    Used for printing output, reading input, and retrieving environment settings.
An Example:
    public class SystemExample {
        public static void main(String[] args) {
            // 1️⃣ Retrieve Java Version
            System.out.println("Java Version: " + System.getProperty("java.version"));
            // 2️⃣ Retrieve Operating System Name
            System.out.println("OS Name: " + System.getProperty("os.name"));
            // 3️⃣ Retrieve User's Home Directory
            System.out.println("User Home: " + System.getProperty("user.home"));
            // 4️⃣ Retrieve an Environment Variable (e.g., PATH)
            System.out.println("System PATH: " + System.getenv("PATH"));
            // 5️⃣ Measure Execution Time of a Task
            long startTime = System.nanoTime();
            // Simulated workload
            for (int i = 0; i < 1000000; i++) {} 
            long endTime = System.nanoTime();
            System.out.println("Execution Time (ns): " + (endTime - startTime));
            // 6️⃣ Print an Error Message
            System.err.println("This is an error message.");
            // 7️⃣ Exit the Program with Status Code
            // 0 (Normal Exit)
            // Non Zero (abnormal termination)
            // System.exit(0);  
        }
    }
```
## ThreadLocal
```
What?
    ThreadLocal allows each thread to have its own copy of a variable.
Why?
    Used in multi-threaded applications to maintain thread-specific data.
An Example:
    class ThreadLocalExample {
        private static ThreadLocal<Integer> threadLocalCount = ThreadLocal.withInitial(() -> 0);
        public static void main(String[] args) {
            Runnable task = () -> {
                int count = threadLocalCount.get();
                threadLocalCount.set(count + 1);
                System.out.println(Thread.currentThread().getName() + " - " + threadLocalCount.get());
            };
            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);
            t1.start();
            t2.start();
        }
    }
```
## UUID
```
What?
    UUID (Universally Unique Identifier) generates unique 128-bit identifiers.
Why?
    Ensures uniqueness without needing centralized ID management.
    Useful for database primary keys, transaction IDs, and session tracking.
    Prevents collisions better than traditional sequential IDs.
An Example:
    import java.util.UUID;

    public class UUIDExample {
        public static void main(String[] args) {
            UUID uniqueID = UUID.randomUUID();
            System.out.println("Generated UUID: " + uniqueID);
        }
    }
```
## Files
```
What?
    Files is a utility class for reading, writing, and managing files.
Why?
    Simplifies file operations without requiring FileInputStream or BufferedReader.
An Example:
    import java.nio.file.Files;
    import java.nio.file.Path;

    public class FilesExample {
        public static void main(String[] args) throws Exception {
            String content = Files.readString(Path.of("example.txt"));
            System.out.println("File Content: " + content);
        }
    }
Another Example
    import java.nio.file.Files;
    import java.nio.file.Path;

    public class AdvancedFilesExample {
        public static void main(String[] args) throws Exception {
            Path filePath = Path.of("example.txt");
            // 1️⃣ Write to a file
            Files.writeString(filePath, "Hello, Java!");
            // 2️⃣ Check if file exists
            System.out.println("File Exists: " + Files.exists(filePath)); // Output: true
            // 3️⃣ Get file size
            System.out.println("File Size: " + Files.size(filePath) + " bytes");
            // 4️⃣ Copy file to a new location
            Files.copy(filePath, Path.of("copy_example.txt"));
            // 5️⃣ Delete the copied file
            Files.delete(Path.of("copy_example.txt"));
        }
    }
Common Methods in java.nio.file.Files

Method	                    Type	Purpose	                                Example
exists(Path)	            Static	Checks if a file or directory exists	Files.exists( Path.of("data.txt"))
notExists(Path)	            Static	Checks if a file does not exist	        Files.notExists( Path.of("missing.txt"))
createFile(Path)	        Static	Creates a new empty file	            Files.createFile( Path.of("file.txt"))
createDirectory(Path)	    Static	Creates a single directory	            Files.createDirectory( Path.of("newDir"))
createDirectories(Path)	    Static	Creates directory + all missing parents	Files.createDirectories( Path.of("a/b/c"))
delete(Path)	            Static	Deletes file or empty directory	        Files.delete( Path.of("temp.txt"))
copy(Path, Path)	        Static	Copies file to a new location	        Files.copy( Path.of("source.txt"), Path.of("target.txt"))
move(Path, Path)	        Static	Moves or renames a file	                Files.move( Path.of("old.txt"), Path.of("new.txt"))
readAllLines(Path)	        Static	Reads all lines from a file (as List)	Files.readAllLines( Path.of("notes.txt"))
write(Path, byte[] or List)	Static	Writes bytes or lines to file	        Files.write( Path.of("log.txt"), "Hello".getBytes())
size(Path)	                Static	Returns file size in bytes	            Files.size( Path.of("image.png"))
isDirectory(Path)	        Static	Checks if the path is a directory	    Files.isDirectory( Path.of("folder"))
isRegularFile(Path)	        Static	Checks if the path is a regular file	Files.isRegularFile( Path.of("doc.txt"))
lines(Path)	                Static	Stream lines from a file (lazy reading)	Files.lines( Path.of("bigfile.txt"))
```
## Timer
```
What?
    Timer schedules tasks for execution at a fixed rate or delay.
Why?
    Useful for running periodic background tasks.
An Example: 
    The Timer starts after 2 seconds (2000ms) and repeats every 3 seconds (3000ms).
    import java.util.Timer;
    import java.util.TimerTask;

    public class TimerExample {
        public static void main(String[] args) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Task executed!");
                }
            }, 2000, 3000);
        }
    }
```
## Locale
```
What?
    Locale represents geographical, cultural, and political regions for internationalization.
Why?
    Used to format numbers, dates, and messages based on the user’s location.
An Example:
//Example Locales
    public static final byte ENGLISH = 0,
            FRENCH = 1,
            GERMAN = 2,
            ITALIAN = 3,
            JAPANESE = 4,
            KOREAN = 5,
            CHINESE = 6,
            SIMPLIFIED_CHINESE = 7,
            TRADITIONAL_CHINESE = 8,
            FRANCE = 9,
            GERMANY = 10,
            ITALY = 11,
            JAPAN = 12,
            KOREA = 13,
            UK = 14,
            US = 15,
            CANADA = 16,
            CANADA_FRENCH = 17;

    import java.text.NumberFormat;
    import java.util.Locale;

    public class LocaleExample {
        public static void main(String[] args) {
            Locale locale = Locale.FRANCE;
            System.out.println("Country: " + locale.getDisplayCountry()); // Output: France
            System.out.println("Language: " + locale.getDisplayLanguage());  // Output: French
            double amount = 1234.56;
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println("Formatted Currency: " + currencyFormatter.format(amount)); //$1,234.56
            //Locale.UK - £1,234.56
        }
    }
```