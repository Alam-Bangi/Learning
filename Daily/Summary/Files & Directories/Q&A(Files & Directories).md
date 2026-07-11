```
1. Does File actually create a file?
    No.
    File f = new File("a.txt");
    This only creates a Java object representation.
    Actual file is created only when:
    f.createNewFile();
    or using streams/writers.

2. Why does createNewFile() return false?
    Because file already exists.
    boolean x = f.createNewFile();
    true → newly created
    false → already existed

3. Why does Java allow creating File object for non-existing files?
    Because File represents path metadata, not actual file content.
    Java lets you:
    inspect path
    check existence
    create later
    delete later

4. Why is File class considered old API?
    Because:
        poor exception handling
        not scalable
        limited features
        weak symbolic-link support
    Modern Java uses:
        java.nio.file
    especially:
        Path
        Files

5. Why is NIO faster than IO?
    Because NIO uses:
    buffers
    channels
    non-blocking operations
    lower-level OS optimization
    Traditional IO is stream-oriented and blocking.

6. Why does file writing sometimes not appear immediately?
    Because of buffering.
    Data may remain in memory buffer until:
    buffer fills
    stream closes
    flush() called

7. Difference between flush() and close()?
flush()	                close()
Forces writing	        Releases resource
Stream remains open	    Stream closes
    Example:
    bw.flush();
    bw.close();

8. Can close() automatically call flush()?
    Yes.
    Most writer streams flush before closing.

9. Why should files always be closed?
    Otherwise:
    memory leaks
    file locks
    corrupted writes
    too many open files error

10. What is file locking?
    OS prevents multiple conflicting accesses.
    Example:
    one process writing
    another process denied access

11. Why does Windows sometimes refuse file deletion?
    Because file is still open by:
    Java process
    editor
    antivirus
    another application
    Windows strongly locks files.
    Linux is more permissive.

12. Why can Linux delete open files but Windows cannot?
    Linux removes directory reference only.
    Actual data remains until all processes release file handle.
    Windows uses stricter locking semantics.

13. Why does renameTo() fail randomly?
    Because:
        file locked
        cross-drive move
        permission issue
        destination exists
    Better modern approach:
        Files.move()

14. Why is File.separator important?
    Windows:
    \

    Linux/Mac:
    /

    Portable code:
    File.separator

15. Why is hardcoding paths dangerous?
    Bad:
    "C:\\Users\\Admin"
    Fails on:
    Linux
    Mac
    cloud servers

16. Difference between Absolute Path and Relative Path?
Absolute	    Relative
Full location	Depends on current directory
    Example:
    C:\Java\a.txt
    vs
    a.txt

17. Why does relative path confuse beginners?
    Because it depends on:
    System.getProperty("user.dir")
    Current working directory changes based on:
    IDE
    terminal
    server

18. Why does file exist in folder but Java says “not found”?
    Usually:
    wrong working directory
    spelling case mismatch
    hidden extension
    permission issue

19. Why does Java show weird characters while reading file?
    Encoding mismatch.
    Example:
    file UTF-8
    Java reading default charset
    Fix:
    new InputStreamReader(fis, StandardCharsets.UTF_8)

20. Why should encoding always be specified?
    Default charset changes by:
    OS
    locale
    JVM settings
    Can break production systems.

21. Difference between ASCII and UTF-8?
ASCII	    UTF-8
128 chars	Supports all languages
Old	        Modern standard

22. Why is BufferedReader faster?
    Because it reduces OS calls.
    Without buffering:
    every character = system call
    Buffering batches reads.

23. Why is system call expensive?
    Crosses:
    JVM
    OS kernel
    hardware
    Much slower than memory operations.

24. Why is reading one byte at a time slow?
    Because:
    repeated disk access
    repeated kernel interaction
    Better:
    byte[] buffer = new byte[8192];

25. What is EOF?
    End Of File.
    Usually represented by:
    -1
    during reads.

26. Why does read() return int instead of char?
Because:
    must represent all byte values (0–255)
    plus EOF (-1)
    char cannot represent -1 safely.

27. Why is RandomAccessFile important?
    Allows jumping to any location.
Used in:
    databases
    media players
    file indexing

28. Why is serialization dangerous?
    Because:
        version mismatch
        security vulnerabilities
        huge memory use
    Modern systems prefer:
        JSON
        protobuf
        XML

29. What is serialVersionUID?
    Version identifier for serialized class.
    Without it:
    deserialization may fail after class changes.

30. Why is Java serialization considered insecure?
    Attackers can craft malicious serialized objects.
    Can lead to:
    remote code execution
    memory attacks

31. Why should ObjectInputStream from unknown source be avoided?
    Because deserialization can execute dangerous object chains.
    Huge security risk.

32. Why is try-with-resources important?
    Automatically closes resources even during exceptions.
    try(FileReader fr = new FileReader("a.txt")) {

    }
    Safer than manual close.

33. What happens if exception occurs before close()?
    Resource leak.
    That’s why finally block or try-with-resources matters.

34. Why is finally block important in old Java?
    Ensures cleanup.
    finally {
    fr.close();
    }

35. Difference between checked and unchecked exceptions in file handling?
Checked	        Unchecked
Must handle	    Optional
IOException	    NullPointerException

36. Why is IOException checked?
    Because file operations are unreliable by nature:
    disk failure
    permissions
    network issues
    Java forces handling.

37. What is path traversal vulnerability?
    Dangerous user input:
    ../../secret.txt
    Can access unauthorized files.

38. How to prevent path traversal?
Validate paths:
    Path.normalize()
    and restrict directories.

39. Why should temp files be deleted?
Otherwise:
    storage leaks
    security exposure
    server clutter

40. Why are temp files security-sensitive?
Attackers may:
    predict filenames
    replace files
    steal data

41. What is symbolic link?
    Shortcut/reference to another file.
Like:
    Linux symlink
    Windows junction

42. Why are symlinks dangerous?
    Can redirect program to sensitive files unexpectedly.

43. Difference between delete() and deleteOnExit()?
delete()	deleteOnExit()
Immediate	JVM shutdown

44. Why is deleteOnExit() risky in servers?
    Long-running JVM:
    files accumulate
    memory tracks deletions

45. Why does file copy become slow for huge files?
    Disk IO bottleneck.
    Not CPU bottleneck.

46. Why are SSDs faster than HDDs?
    SSD:
        no moving parts
        electronic access
    HDD:
        spinning disks
        mechanical seek time

47. Why does antivirus slow file operations?
    Every read/write may be scanned.

48. Why can file operations block threads?
    Disk IO is slow.
    Thread waits for:
        hardware
        kernel
        filesystem

49. What is memory-mapped file?
    File mapped directly into memory.
    Using:
    MappedByteBuffer
    Very fast for huge files.

50. Why do databases use memory-mapped files?
    Because:
    ultra-fast access
    OS-level caching
    efficient random access

51. Why is file handling harder in cloud servers?
    Because files may be:
    distributed
    temporary
    containerized
    Local disk may disappear.

52. Why should uploads never trust filename from user?
    User may upload:
    virus.exe
    or:
    ../../../system32
    Always sanitize names.

53. Why are file permissions important?
    Prevent:
    unauthorized reads
    writes
    execution

54. Why does Java sometimes fail despite admin rights?
    OS-level restrictions:
    sandboxing
    antivirus
    file ownership
    mounted filesystem permissions

55. Why is concurrent file writing dangerous?
    Multiple threads may:
    overwrite data
    corrupt file
    interleave content

56. How to safely write files concurrently?
    Using:
    synchronization
    locks
    append mode
    queues

57. Why do logs use append mode?
    Avoid overwriting previous logs.
    new FileWriter("log.txt", true)

58. Why can log files crash servers?
    Huge logs can:
        fill disk
        stop databases
        crash applications

59. What is log rotation?
    Automatically:
    archive old logs
    create new logs

60. Biggest hidden truth about file handling?
File handling is not just Java.
    It involves:
        Operating System
        Filesystem
        Hardware
        Permissions
        Encoding
        Concurrency
        Security
        Performance
        Networking
        JVM internals
    That’s why “simple file IO” becomes complex in real-world systems.
```