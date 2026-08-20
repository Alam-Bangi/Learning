Appending means **adding data to the end of an existing file without deleting its current contents**. Java provides several ways to append data.

---

## 1. Using `FileWriter` (Most Common)

Pass `true` as the second argument to enable append mode.

```java
import java.io.FileWriter;

FileWriter writer = new FileWriter("sample.txt", true);

writer.write("Hello Java\n");

writer.close();
```

**Best for:** Simple text appending.

---

## 2. Using `BufferedWriter`

Efficient for appending large amounts of text.

```java
import java.io.BufferedWriter;
import java.io.FileWriter;

BufferedWriter writer =
    new BufferedWriter(new FileWriter("sample.txt", true));

writer.write("Hello Java");
writer.newLine();

writer.close();
```

**Best for:** Large text files.

---

## 3. Using `PrintWriter`

Useful for formatted text.

```java
import java.io.FileWriter;
import java.io.PrintWriter;

PrintWriter writer =
    new PrintWriter(new FileWriter("sample.txt", true));

writer.println("Name: John");
writer.printf("Age: %d%n", 20);

writer.close();
```

**Best for:** Formatted output.

---

## 4. Using `FileOutputStream`

Append bytes to a file.

```java
import java.io.FileOutputStream;

FileOutputStream fos =
    new FileOutputStream("sample.txt", true);

fos.write("Hello Java\n".getBytes());

fos.close();
```

**Best for:** Binary or text data.

---

## 5. Using `BufferedOutputStream`

Buffered version of `FileOutputStream`.

```java
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

BufferedOutputStream bos =
    new BufferedOutputStream(
        new FileOutputStream("sample.txt", true));

bos.write("Hello Java\n".getBytes());

bos.close();
```

**Best for:** Faster byte writing.

---

## 6. Using `Files.write()` (Java 7+)

Use `StandardOpenOption.APPEND`.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

Files.write(
    Path.of("sample.txt"),
    "Hello Java\n".getBytes(),
    StandardOpenOption.APPEND
);
```

If the file may not exist:

```java
Files.write(
    Path.of("sample.txt"),
    "Hello Java\n".getBytes(),
    StandardOpenOption.CREATE,
    StandardOpenOption.APPEND
);
```

**Best for:** Modern Java.

---

## 7. Using `Files.writeString()` (Java 11+)

Append a string directly.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

Files.writeString(
    Path.of("sample.txt"),
    "Hello Java\n",
    StandardOpenOption.APPEND
);
```

Or create the file if it doesn't exist:

```java
Files.writeString(
    Path.of("sample.txt"),
    "Hello Java\n",
    StandardOpenOption.CREATE,
    StandardOpenOption.APPEND
);
```

**Best for:** Java 11+.

---

## 8. Using `Files.newBufferedWriter()`

Open a buffered writer in append mode.

```java
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

BufferedWriter writer =
    Files.newBufferedWriter(
        Path.of("sample.txt"),
        StandardOpenOption.APPEND
    );

writer.write("Hello Java");
writer.newLine();

writer.close();
```

**Best for:** Efficient modern text appending.

---

## 9. Using `Files.newOutputStream()`

Append bytes using an output stream.

```java
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

OutputStream os =
    Files.newOutputStream(
        Path.of("sample.txt"),
        StandardOpenOption.APPEND
    );

os.write("Hello Java\n".getBytes());

os.close();
```

**Best for:** Modern byte appending.

---

## 10. Using `RandomAccessFile`

Move the file pointer to the end and write.

```java
import java.io.RandomAccessFile;

RandomAccessFile raf =
    new RandomAccessFile("sample.txt", "rw");

raf.seek(raf.length());   // Move to end

raf.writeBytes("Hello Java\n");

raf.close();
```

**Best for:** Appending when you also need random file access.

---

# Summary

| Method                         | Data Type  | Append Support                  | Best Use                    |
| ------------------------------ | ---------- | ------------------------------- | --------------------------- |
| `FileWriter(file, true)`       | Text       | ✅                               | Simple text appending       |
| `BufferedWriter`               | Text       | ✅                               | Efficient text appending    |
| `PrintWriter`                  | Text       | ✅                               | Formatted text              |
| `FileOutputStream(file, true)` | Bytes      | ✅                               | Binary/text files           |
| `BufferedOutputStream`         | Bytes      | ✅                               | Efficient binary appending  |
| `Files.write()`                | Bytes      | ✅ (`StandardOpenOption.APPEND`) | Modern Java                 |
| `Files.writeString()`          | String     | ✅ (`StandardOpenOption.APPEND`) | Java 11+                    |
| `Files.newBufferedWriter()`    | Text       | ✅                               | Modern buffered writing     |
| `Files.newOutputStream()`      | Bytes      | ✅                               | Modern byte writing         |
| `RandomAccessFile`             | Text/Bytes | ✅ (using `seek(length())`)      | Random access and appending |

## Most commonly used methods

For most applications, these are the preferred choices:

* **`FileWriter(file, true)`** – Simple text appending
* **`BufferedWriter`** – Efficient text appending
* **`PrintWriter`** – Formatted text appending
* **`Files.writeString()`** – Simplest modern approach (Java 11+)
* **`Files.write()`** – Modern API (Java 7+)
* **`RandomAccessFile`** – When you need to append and also write at arbitrary positions within the file
