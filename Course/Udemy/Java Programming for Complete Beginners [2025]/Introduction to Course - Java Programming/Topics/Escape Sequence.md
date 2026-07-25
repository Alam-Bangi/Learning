
> **"Escape sequences are special character combinations that start with a backslash (`\`). They allow us to represent characters that are difficult or impossible to type directly in a string or character literal, such as a newline, tab, or quotation mark."**

### Common escape sequences in Java

| Escape Sequence | Meaning         | Example             | Output                                                          |
| --------------- | --------------- | ------------------- | --------------------------------------------------------------- |
| `\n`            | New line        | `"Hello\nWorld"`    | Hello<br>World                                                  |
| `\t`            | Horizontal tab  | `"Java\tPython"`    | Java    Python                                                  |
| `\b`            | Backspace       | `"ABC\bD"`          | ABD                                                             |
| `\r`            | Carriage return | `"Hello\rJava"`     | Overwrites from the beginning (behavior depends on the console) |
| `\f`            | Form feed       | `"Hello\fWorld"`    | Form feed character                                             |
| `\'`            | Single quote    | `'\''`              | `'`                                                             |
| `\"`            | Double quote    | `"He said \"Hi\""`  | He said "Hi"                                                    |
| `\\`            | Backslash       | `"C:\\Users\\John"` | C:\Users\John                                                   |

### Example Program

```java
public class EscapeDemo {
    public static void main(String[] args) {
        System.out.println("Hello\nWorld");
        System.out.println("Java\tProgramming");
        System.out.println("He said \"Hello\"");
        System.out.println("Path: C:\\Users\\Admin");
    }
}
```

**Output:**

```
Hello
World
Java    Programming
He said "Hello"
Path: C:\Users\Admin
```

### Interview Follow-up

**Q: Why do we use escape sequences?**

> "Escape sequences help represent special characters in strings and character literals. For example, they allow us to print quotes inside a string, create new lines, insert tabs, or include backslashes without causing syntax errors."

### 30-second interview answer

> "Escape sequences in Java are special character combinations beginning with a backslash (`\`). They are used to represent characters like a newline (`\n`), tab (`\t`), double quote (`\"`), single quote (`\'`), and backslash (`\\`) inside strings or character literals. They improve formatting and allow special characters to be included without syntax errors."


Here are examples of each escape sequence with its output.

### 1. `\n` – New Line

Moves the cursor to the next line.

```java
System.out.println("Hello\nWorld");
```

**Output:**

```
Hello
World
```

---

### 2. `\t` – Horizontal Tab

Adds a tab space.

```java
System.out.println("Name\tAge");
System.out.println("John\t25");
```

**Output:**

```
Name    Age
John    25
```

---

### 3. `\b` – Backspace

Removes the character immediately before it.

```java
System.out.println("ABC\bD");
```

**Output:**

```
ABD
```

**Explanation:**

* `ABC`
* `\b` removes `C`
* `D` is printed
* Final output: `ABD`

---

### 4. `\r` – Carriage Return

Moves the cursor to the beginning of the current line. Characters printed afterward overwrite existing ones.

```java
System.out.println("Hello\rJava");
```

**Possible Output (depends on the console):**

```
Javao
```

**Explanation:**

* `Hello` is printed.
* `\r` moves the cursor back to the start.
* `Java` overwrites the first four letters (`Hell`), leaving the last `o`.

Because behavior varies by terminal, `\r` is rarely used in modern Java applications.

---

### 5. `\f` – Form Feed

Represents a form-feed character. Most modern consoles don't visibly display it.

```java
System.out.println("Hello\fWorld");
```

**Output:**

```
HelloWorld
```

(Some terminals may show a page break or ignore it.)

---

### 6. `\'` – Single Quote

```java
System.out.println('\'');
```

**Output:**

```
'
```

Another example:

```java
System.out.println("It's Java");
```

Since the string is enclosed in double quotes, no escape is needed for the apostrophe.

---

### 7. `\"` – Double Quote

Allows double quotes inside a string.

```java
System.out.println("He said, \"Java is easy.\"");
```

**Output:**

```
He said, "Java is easy."
```

---

### 8. `\\` – Backslash

Prints a backslash.

```java
System.out.println("C:\\Users\\Admin\\Documents");
```

**Output:**

```
C:\Users\Admin\Documents
```

---

## Complete Program

```java
public class EscapeSequenceDemo {
    public static void main(String[] args) {

        // New Line
        System.out.println("1. Hello\nWorld");

        // Tab
        System.out.println("2. Java\tPython");

        // Backspace
        System.out.println("3. ABC\bD");

        // Carriage Return
        System.out.println("4. Hello\rJava");

        // Form Feed
        System.out.println("5. Hello\fWorld");

        // Double Quote
        System.out.println("6. He said \"Hello\"");

        // Single Quote
        System.out.println('\'');
        
        // Backslash
        System.out.println("7. C:\\Users\\Admin");
    }
}
```

### Interview Tip

* `\n` → New line
* `\t` → Tab
* `\"` → Double quote
* `\\` → Backslash

The others (`\b`, `\r`, and `\f`) are valid Java escape sequences but are used much less frequently in everyday programming.
