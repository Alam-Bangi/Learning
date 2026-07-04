
---
# ✅ 1. Update File Content (Full File Rewrite)

In Java, updating usually means:
👉 Read entire file → modify → write back

## ⭐ Using `Files.writeString()` (Java 11+)

```
id="upd1"
import java.nio.file.*;

public class UpdateFile {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("sample.txt");

        String content = Files.readString(path);

        content = content + "\nNew line added";

        Files.writeString(path, content);

        System.out.println("File updated successfully.");
    }
}
```

---

## ⭐ Using `Files.write()` (Java 7+)

``` 
id="upd2"
import java.nio.file.*;
import java.util.*;

public class UpdateFile {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("sample.txt");

        List<String> lines = Files.readAllLines(path);

        lines.add("New line added");

        Files.write(path, lines);

        System.out.println("File updated.");
    }
}
```

---

# ✏️ 2. Replace Specific Line in File

## ⭐ Best Method: Read → Modify List → Write Back

``` 
id="upd3"
import java.nio.file.*;
import java.util.*;

public class ReplaceLine {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("sample.txt");

        List<String> lines = Files.readAllLines(path);

        int lineNumber = 2; // replace 2nd line

        if (lineNumber <= lines.size()) {
            lines.set(lineNumber - 1, "This line is replaced");
        }

        Files.write(path, lines);

        System.out.println("Line replaced successfully.");
    }
}
```

---

## ⭐ Using BufferedReader + BufferedWriter (for large files)

``` 
id="upd4"
import java.io.*;

public class ReplaceLine {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));

        String line;
        int count = 1;

        while ((line = br.readLine()) != null) {

            if (count == 3) {
                line = "Updated third line";
            }

            bw.write(line);
            bw.newLine();
            count++;
        }

        br.close();
        bw.close();

        new File("sample.txt").delete();
        new File("temp.txt").renameTo(new File("sample.txt"));

        System.out.println("Line replaced.");
    }
}
```

---

# 🔤 3. Replace Specific Word / Text

## ⭐ Using `Files.readString()` + `replace()`

``` 
id="upd5"
import java.nio.file.*;

public class ReplaceWord {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("sample.txt");

        String content = Files.readString(path);

        content = content.replace("Java", "Python");

        Files.writeString(path, content);

        System.out.println("Word replaced successfully.");
    }
}
```

---

## ⭐ Replace only first occurrence

``` 
id="upd6"
content = content.replaceFirst("Java", "Python");
```

---

## ⭐ Case-insensitive replace (advanced)

``` 
id="upd7"
content = content.replaceAll("(?i)java", "Python");
```

---

# ⚙️ 4. Update Using Buffered Streams (Large Files)

``` 
id="upd8"
import java.io.*;

public class ReplaceWord {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));

        String line;

        while ((line = br.readLine()) != null) {
            line = line.replace("Java", "Python");
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        new File("sample.txt").delete();
        new File("temp.txt").renameTo(new File("sample.txt"));

        System.out.println("Text replaced successfully.");
    }
}
```

---

# 📌 SUMMARY

| Operation         | Best Method            | Works For           |
| ----------------- | ---------------------- | ------------------- |
| Update full file  | `Files.writeString()`  | Small/medium files  |
| Add/update lines  | `Files.readAllLines()` | Simple edits        |
| Replace line      | List `.set()`          | Line-based updates  |
| Replace word/text | `replace()`            | String modification |
| Large file update | BufferedReader/Writer  | Big files           |

---

# ⭐ FINAL KEY IDEA

👉 Java does NOT directly support “edit-in-place” for text files
So almost always:

> Read → Modify → Rewrite

---
