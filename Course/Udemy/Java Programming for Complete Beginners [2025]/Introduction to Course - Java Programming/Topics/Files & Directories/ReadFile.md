Java provides many ways to read data from a file. The best choice depends on whether you're reading **text**, **binary data**, **objects**, or **primitive data**.

---

## 1. Using `FileReader`

Reads a file character by character.

```java
import java.io.FileReader;

FileReader reader = new FileReader("sample.txt");

int ch;
while ((ch = reader.read()) != -1) {
    System.out.print((char) ch);
}

reader.close();
```

**Best for:** Small text files.

---

## 2. Using `BufferedReader`

Reads text efficiently, usually line by line.

```java
import java.io.BufferedReader;
import java.io.FileReader;

BufferedReader reader =
    new BufferedReader(new FileReader("sample.txt"));

String line;

while ((line = reader.readLine()) != null) {
    System.out.println(line);
}

reader.close();
```

**Best for:** Large text files.

---

## 3. Using `Scanner`

Easy to read lines, words, and numbers.

```java
import java.io.File;
import java.util.Scanner;

Scanner sc = new Scanner(new File("sample.txt"));

while (sc.hasNextLine()) {
    System.out.println(sc.nextLine());
}

sc.close();
```

**Best for:** Reading formatted text.

---

## 4. Using `FileInputStream`

Reads bytes from a file.

```java
import java.io.FileInputStream;

FileInputStream fis =
    new FileInputStream("sample.txt");

int data;

while ((data = fis.read()) != -1) {
    System.out.print((char) data);
}

fis.close();
```

**Best for:** Binary files.

---

## 5. Using `BufferedInputStream`

Buffered version of `FileInputStream`.

```java
import java.io.BufferedInputStream;
import java.io.FileInputStream;

BufferedInputStream bis =
    new BufferedInputStream(
        new FileInputStream("sample.txt"));

int data;

while ((data = bis.read()) != -1) {
    System.out.print((char) data);
}

bis.close();
```

**Best for:** Faster binary reading.

---

## 6. Using `Files.readAllBytes()` (Java 7+)

Reads the entire file as a byte array.

```java
import java.nio.file.Files;
import java.nio.file.Path;

byte[] data =
    Files.readAllBytes(Path.of("sample.txt"));

System.out.println(new String(data));
```

**Best for:** Small files.

---

## 7. Using `Files.readAllLines()` (Java 7+)

Reads all lines into a list.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

List<String> lines =
    Files.readAllLines(Path.of("sample.txt"));

for (String line : lines) {
    System.out.println(line);
}
```

**Best for:** Small to medium text files.

---

## 8. Using `Files.readString()` (Java 11+)

Reads the entire file as a single string.

```java
import java.nio.file.Files;
import java.nio.file.Path;

String content =
    Files.readString(Path.of("sample.txt"));

System.out.println(content);
```

**Best for:** Reading complete text files.

---

## 9. Using `Files.newBufferedReader()`

Modern buffered reader.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;

BufferedReader reader =
    Files.newBufferedReader(Path.of("sample.txt"));

String line;

while ((line = reader.readLine()) != null) {
    System.out.println(line);
}

reader.close();
```

**Best for:** Modern Java applications.

---

## 10. Using `Files.newInputStream()`

Opens a file as an input stream.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.InputStream;

InputStream is =
    Files.newInputStream(Path.of("sample.txt"));

int data;

while ((data = is.read()) != -1) {
    System.out.print((char) data);
}

is.close();
```

**Best for:** Byte-based reading.

---

## 11. Using `ObjectInputStream`

Reads serialized Java objects.

```java
import java.io.FileInputStream;
import java.io.ObjectInputStream;

ObjectInputStream in =
    new ObjectInputStream(
        new FileInputStream("object.dat"));

String text = (String) in.readObject();

System.out.println(text);

in.close();
```

**Best for:** Reading serialized objects.

---

## 12. Using `DataInputStream`

Reads primitive data types.

```java
import java.io.DataInputStream;
import java.io.FileInputStream;

DataInputStream dis =
    new DataInputStream(
        new FileInputStream("data.dat"));

int number = dis.readInt();
double marks = dis.readDouble();
String name = dis.readUTF();

System.out.println(number);
System.out.println(marks);
System.out.println(name);

dis.close();
```

**Best for:** Reading binary primitive data.

---

## 13. Using `RandomAccessFile`

Reads from any position in the file.

```java
import java.io.RandomAccessFile;

RandomAccessFile raf =
    new RandomAccessFile("sample.txt", "r");

String line;

while ((line = raf.readLine()) != null) {
    System.out.println(line);
}

raf.close();
```

**Best for:** Random access to files.

---

# Summary

| Method                      | Reads                 | Best Use                |
| --------------------------- | --------------------- | ----------------------- |
| `FileReader`                | Characters            | Small text files        |
| `BufferedReader`            | Lines of text         | Large text files        |
| `Scanner`                   | Text, words, numbers  | Easy parsing            |
| `FileInputStream`           | Bytes                 | Binary files            |
| `BufferedInputStream`       | Bytes                 | Faster binary reading   |
| `Files.readAllBytes()`      | Entire file as bytes  | Small files             |
| `Files.readAllLines()`      | All lines             | Small/medium text files |
| `Files.readString()`        | Entire file as string | Java 11+, text files    |
| `Files.newBufferedReader()` | Lines                 | Modern text reading     |
| `Files.newInputStream()`    | Bytes                 | Modern binary reading   |
| `ObjectInputStream`         | Serialized objects    | Object deserialization  |
| `DataInputStream`           | Primitive data        | Binary data             |
| `RandomAccessFile`          | Random positions      | Random access reading   |

## Most commonly used methods

For most Java programs, these are the methods you'll use most often:

* `BufferedReader` – Read text line by line
* `Scanner` – Read text, words, and numbers easily
* `Files.readString()` – Read an entire text file (Java 11+)
* `Files.readAllLines()` – Read all lines into a list
* `Files.newBufferedReader()` – Modern and efficient text reading
* `FileInputStream` – Read binary files
* `RandomAccessFile` – Read from specific positions in a file
