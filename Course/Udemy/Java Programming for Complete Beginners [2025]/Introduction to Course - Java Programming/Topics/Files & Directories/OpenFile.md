In Java, "opening" a file means creating a stream or reader/writer to access it. The method depends on whether you want to **read**, **write**, **append**, or **read binary data**.

## 1. Using `FileReader` (Read Text)

Opens a text file for reading character by character.

```
import java.io.FileReader;

FileReader fr = new FileReader("sample.txt");
```

---

## 2. Using `BufferedReader` (Efficient Text Reading)

Opens a file for buffered reading (line by line).

```
import java.io.BufferedReader;
import java.io.FileReader;

BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
```

---

## 3. Using `Scanner` (Easy Input Parsing)

Opens a file and reads text conveniently.

```
import java.io.File;
import java.util.Scanner;

Scanner sc = new Scanner(new File("sample.txt"));
```

---

## 4. Using `FileInputStream` (Read Binary Files)

Opens a file for reading binary data.

```
import java.io.FileInputStream;

FileInputStream fis = new FileInputStream("sample.txt");
```

---

## 5. Using `FileWriter` (Write Mode)

Opens a file for writing. Creates it if it doesn't exist and **overwrites** existing content.

```
import java.io.FileWriter;

FileWriter fw = new FileWriter("sample.txt");
```

---

## 6. Using `FileWriter` in Append Mode

Opens a file for appending without deleting existing content.

```
import java.io.FileWriter;

FileWriter fw = new FileWriter("sample.txt", true);
```

---

## 7. Using `BufferedWriter`

Opens a file for efficient writing.

```
import java.io.BufferedWriter;
import java.io.FileWriter;

BufferedWriter bw = new BufferedWriter(new FileWriter("sample.txt"));
```

---

## 8. Using `PrintWriter`

Opens a file for formatted text output.

```
import java.io.PrintWriter;

PrintWriter pw = new PrintWriter("sample.txt");
```

---

## 9. Using `FileOutputStream`

Opens a file for writing binary data.

```
import java.io.FileOutputStream;

FileOutputStream fos = new FileOutputStream("sample.txt");
```

---

## 10. Using `Files.newBufferedReader()` (Java 7+)

Modern way to open a text file for reading.

```
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;

BufferedReader br = Files.newBufferedReader(Path.of("sample.txt"));
```

---

## 11. Using `Files.newBufferedWriter()` (Java 7+)

Modern way to open a file for writing.

```
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedWriter;

BufferedWriter bw = Files.newBufferedWriter(Path.of("sample.txt"));
```

---

## 12. Using `Files.newInputStream()` (Java 7+)

Opens a file as an input stream.

```
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.InputStream;

InputStream is = Files.newInputStream(Path.of("sample.txt"));
```

---

## 13. Using `Files.newOutputStream()` (Java 7+)

Opens a file as an output stream.

```
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.OutputStream;

OutputStream os = Files.newOutputStream(Path.of("sample.txt"));
```

---

## Summary

| Method                      | Purpose                | Text/Binary | Read/Write |
| --------------------------- | ---------------------- | ----------- | ---------- |
| `FileReader`                | Read characters        | Text        | Read       |
| `BufferedReader`            | Read lines efficiently | Text        | Read       |
| `Scanner`                   | Read and parse data    | Text        | Read       |
| `FileInputStream`           | Read bytes             | Binary      | Read       |
| `FileWriter`                | Write (overwrite)      | Text        | Write      |
| `FileWriter(file, true)`    | Append                 | Text        | Write      |
| `BufferedWriter`            | Efficient writing      | Text        | Write      |
| `PrintWriter`               | Formatted writing      | Text        | Write      |
| `FileOutputStream`          | Write bytes            | Binary      | Write      |
| `Files.newBufferedReader()` | Modern text reading    | Text        | Read       |
| `Files.newBufferedWriter()` | Modern text writing    | Text        | Write      |
| `Files.newInputStream()`    | Modern binary reading  | Binary      | Read       |
| `Files.newOutputStream()`   | Modern binary writing  | Binary      | Write      |

### Which one should you use?

* **Read a text file:** `BufferedReader`, `Scanner`, or `Files.newBufferedReader()`
* **Write a text file:** `FileWriter`, `BufferedWriter`, `PrintWriter`, or `Files.newBufferedWriter()`
* **Read/write binary files:** `FileInputStream`, `FileOutputStream`, `Files.newInputStream()`, or `Files.newOutputStream()`
* **Modern Java (Java 7+):** Prefer the `java.nio.file.Files` methods where practical.
