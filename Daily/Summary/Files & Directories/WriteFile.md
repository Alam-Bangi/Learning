Java provides multiple ways to write data to a file. Each approach is suited to different use cases.

## 1. Using `FileWriter`

Writes text to a file. Overwrites existing content by default.

```java
import java.io.FileWriter;

FileWriter writer = new FileWriter("sample.txt");
writer.write("Hello Java");
writer.close();
```

**Append mode:**

```java
FileWriter writer = new FileWriter("sample.txt", true);
writer.write("Hello Java");
writer.close();
```

---

## 2. Using `BufferedWriter`

Efficient for writing large amounts of text.

```java
import java.io.BufferedWriter;
import java.io.FileWriter;

BufferedWriter writer = new BufferedWriter(new FileWriter("sample.txt"));

writer.write("Hello Java");
writer.newLine();
writer.write("Welcome");

writer.close();
```

---

## 3. Using `PrintWriter`

Best for formatted text output.

```java
import java.io.PrintWriter;

PrintWriter writer = new PrintWriter("sample.txt");

writer.println("Name: John");
writer.println("Age: 20");
writer.printf("Marks: %.2f", 95.75);

writer.close();
```

---

## 4. Using `FileOutputStream`

Writes bytes to a file (binary or text).

```java
import java.io.FileOutputStream;

FileOutputStream fos = new FileOutputStream("sample.txt");

fos.write("Hello Java".getBytes());

fos.close();
```

**Append mode:**

```java
FileOutputStream fos = new FileOutputStream("sample.txt", true);

fos.write("Hello".getBytes());

fos.close();
```

---

## 5. Using `BufferedOutputStream`

Buffered version of `FileOutputStream`.

```java
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

BufferedOutputStream bos =
    new BufferedOutputStream(new FileOutputStream("sample.txt"));

bos.write("Hello Java".getBytes());

bos.close();
```

---

## 6. Using `Files.write()` (Java 7+)

Modern and concise method.

```java
import java.nio.file.Files;
import java.nio.file.Path;

Files.write(Path.of("sample.txt"),
            "Hello Java".getBytes());
```

---

## 7. Using `Files.writeString()` (Java 11+)

Simplest way to write a string.

```java
import java.nio.file.Files;
import java.nio.file.Path;

Files.writeString(Path.of("sample.txt"),
                  "Hello Java");
```

---

## 8. Using `Files.newBufferedWriter()`

Modern buffered writer.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedWriter;

BufferedWriter writer =
    Files.newBufferedWriter(Path.of("sample.txt"));

writer.write("Hello Java");

writer.close();
```

---

## 9. Using `Files.newOutputStream()`

Modern output stream.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.OutputStream;

OutputStream os =
    Files.newOutputStream(Path.of("sample.txt"));

os.write("Hello Java".getBytes());

os.close();
```

---

## 10. Using `ObjectOutputStream`

Writes Java objects to a file (serialization).

```java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

ObjectOutputStream out =
    new ObjectOutputStream(
        new FileOutputStream("object.dat"));

out.writeObject("Hello Java");

out.close();
```

---

## 11. Using `DataOutputStream`

Writes primitive data types.

```java
import java.io.DataOutputStream;
import java.io.FileOutputStream;

DataOutputStream dos =
    new DataOutputStream(
        new FileOutputStream("data.dat"));

dos.writeInt(100);
dos.writeDouble(95.5);
dos.writeUTF("Hello");

dos.close();
```

---

## 12. Using `RandomAccessFile`

Writes data at any position in the file.

```java
import java.io.RandomAccessFile;

RandomAccessFile raf =
    new RandomAccessFile("sample.txt", "rw");

raf.writeBytes("Hello Java");

raf.close();
```

---

# Summary

| Method                      | Data Type          | Append Supported | Best Use                       |
| --------------------------- | ------------------ | ---------------- | ------------------------------ |
| `FileWriter`                | Text               | ✅                | Simple text writing            |
| `BufferedWriter`            | Text               | ✅                | Efficient text writing         |
| `PrintWriter`               | Text               | ✅                | Formatted text                 |
| `FileOutputStream`          | Bytes              | ✅                | Binary files                   |
| `BufferedOutputStream`      | Bytes              | ✅                | Efficient binary writing       |
| `Files.write()`             | Bytes/List<String> | ✅ (with options) | Modern Java                    |
| `Files.writeString()`       | String             | ✅ (with options) | Java 11+, simplest for strings |
| `Files.newBufferedWriter()` | Text               | ✅ (with options) | Modern buffered writing        |
| `Files.newOutputStream()`   | Bytes              | ✅ (with options) | Modern byte writing            |
| `ObjectOutputStream`        | Objects            | ❌                | Object serialization           |
| `DataOutputStream`          | Primitive types    | ❌                | Binary primitive data          |
| `RandomAccessFile`          | Text/Binary        | N/A              | Random-position writing        |

## Most commonly used methods

For most Java applications, these are the methods you'll use most often:

* `FileWriter` – Simple text writing
* `BufferedWriter` – Efficient text writing
* `PrintWriter` – Formatted text output
* `Files.write()` – Modern API (Java 7+)
* `Files.writeString()` – Easiest string writing (Java 11+)
* `FileOutputStream` – Binary file writing
* `RandomAccessFile` – Updating data at specific file positions
