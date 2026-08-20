Here are the **File Information Operations in Java** with clear explanations and all commonly used methods.

---

# 🔍 1. Check File Exists

## ⭐ Using `Files.exists()` (Modern)

```java id="info1"
import java.nio.file.*;

public class FileInfo {
    public static void main(String[] args) {

        Path path = Paths.get("sample.txt");

        if (Files.exists(path)) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exist");
        }
    }
}
```

---

## ⭐ Using `File.exists()` (Old way)

```java id="info2"
import java.io.File;

public class FileInfo {
    public static void main(String[] args) {

        File file = new File("sample.txt");

        System.out.println(file.exists());
    }
}
```

---

# 📏 2. Get File Size

## ⭐ Using `Files.size()`

```java id="info3"
import java.nio.file.*;

public class FileInfo {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("sample.txt");

        long size = Files.size(path);

        System.out.println("File size: " + size + " bytes");
    }
}
```

---

## ⭐ Using `File.length()`

```java id="info4"
import java.io.File;

public class FileInfo {
    public static void main(String[] args) {

        File file = new File("sample.txt");

        System.out.println("Size: " + file.length() + " bytes");
    }
}
```

---

# 📍 3. Get File Path

## ⭐ Using `Path`

```java id="info5"
import java.nio.file.*;

public class FileInfo {
    public static void main(String[] args) {

        Path path = Paths.get("sample.txt");

        System.out.println("Path: " + path.toAbsolutePath());
    }
}
```

---

## ⭐ Using `File`

```java id="info6"
import java.io.File;

public class FileInfo {
    public static void main(String[] args) {

        File file = new File("sample.txt");

        System.out.println(file.getAbsolutePath());
    }
}
```

---

# 🕒 4. Get Last Modified Date

## ⭐ Using `Files.getLastModifiedTime()`

```java id="info7"
import java.nio.file.*;
import java.nio.file.attribute.FileTime;

public class FileInfo {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("sample.txt");

        FileTime time = Files.getLastModifiedTime(path);

        System.out.println("Last modified: " + time);
    }
}
```

---

## ⭐ Using `File.lastModified()`

```java id="info8"
import java.io.File;
import java.util.Date;

public class FileInfo {
    public static void main(String[] args) {

        File file = new File("sample.txt");

        long lastModified = file.lastModified();

        System.out.println(new Date(lastModified));
    }
}
```

---

# 🔐 5. Check Read / Write / Execute Permissions

## ⭐ Using `Files`

```java id="info9"
import java.nio.file.*;

public class FileInfo {
    public static void main(String[] args) {

        Path path = Paths.get("sample.txt");

        System.out.println("Readable: " + Files.isReadable(path));
        System.out.println("Writable: " + Files.isWritable(path));
        System.out.println("Executable: " + Files.isExecutable(path));
    }
}
```

---

## ⭐ Using `File`

```java id="info10"
import java.io.File;

public class FileInfo {
    public static void main(String[] args) {

        File file = new File("sample.txt");

        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Executable: " + file.canExecute());
    }
}
```

---

# 📌 SUMMARY TABLE

| Operation          | Modern (NIO)                  | Old (IO)                 |
| ------------------ | ----------------------------- | ------------------------ |
| Check exists       | `Files.exists()`              | `File.exists()`          |
| File size          | `Files.size()`                | `File.length()`          |
| File path          | `Path.toAbsolutePath()`       | `File.getAbsolutePath()` |
| Last modified      | `Files.getLastModifiedTime()` | `File.lastModified()`    |
| Read permission    | `Files.isReadable()`          | `File.canRead()`         |
| Write permission   | `Files.isWritable()`          | `File.canWrite()`        |
| Execute permission | `Files.isExecutable()`        | `File.canExecute()`      |

---

# ⭐ FINAL NOTE

👉 In modern Java (Java 7+), prefer:

* `java.nio.file.Files`
* `java.nio.file.Path`

because they are:

* More powerful
* More reliable
* Cross-platform friendly

---
