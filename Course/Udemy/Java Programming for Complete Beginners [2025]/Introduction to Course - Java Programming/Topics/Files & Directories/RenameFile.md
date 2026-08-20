In Java, renaming a file can be done in multiple ways using both the old `java.io` API and the modern `java.nio.file` API.

---

# 1. Using `File.renameTo()` (Old Approach)

```java id="k3p9qv"
import java.io.File;

public class RenameFile {
    public static void main(String[] args) {

        File oldFile = new File("oldName.txt");
        File newFile = new File("newName.txt");

        boolean success = oldFile.renameTo(newFile);

        if (success) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Rename failed.");
        }
    }
}
```

### Notes:

* Simple but **not reliable across all systems**
* May fail if file is open or already exists

---

# 2. Using `Files.move()` (Recommended ⭐ Modern Way)

```java id="7zv4nt"
import java.nio.file.*;

public class RenameFile {
    public static void main(String[] args) throws Exception {

        Path source = Paths.get("oldName.txt");
        Path target = Paths.get("newName.txt");

        Files.move(source, target);

        System.out.println("File renamed successfully.");
    }
}
```

---

## 3. Using `Files.move()` with Replace Option (Safer)

If the new file already exists, you can replace it:

```java id="x8qk1m"
import java.nio.file.*;
import java.nio.file.StandardCopyOption;

public class RenameFile {
    public static void main(String[] args) throws Exception {

        Path source = Paths.get("oldName.txt");
        Path target = Paths.get("newName.txt");

        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("File renamed (with replace option).");
    }
}
```

---

# 4. Rename File in Different Directory (Move + Rename)

Renaming can also mean moving to another folder:

```java id="l2m8sd"
import java.nio.file.*;

public class RenameFile {
    public static void main(String[] args) throws Exception {

        Path source = Paths.get("C:/files/oldName.txt");
        Path target = Paths.get("C:/backup/newName.txt");

        Files.move(source, target);

        System.out.println("File moved and renamed.");
    }
}
```

---

# Summary

| Method                              | Package         | Recommended       | Notes                    |
| ----------------------------------- | --------------- | ----------------- | ------------------------ |
| `File.renameTo()`                   | `java.io`       | ❌ Not recommended | May fail silently        |
| `Files.move()`                      | `java.nio.file` | ⭐ Yes             | Reliable and modern      |
| `Files.move()` + `REPLACE_EXISTING` | `java.nio.file` | ⭐ Yes             | Overwrites existing file |

---

# Best Practice

👉 Always use:

```java
Files.move(source, target);
```

because it is:

* Reliable
* Cross-platform
* Part of modern Java NIO API

---
