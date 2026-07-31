If an interviewer asks **"How do you work with dates in Java?"** or **"What are the date classes in Java?"**, here's a good interview answer.

> **"Java provides two main APIs for working with dates. The older API includes `Date` and `Calendar` classes from `java.util`. Since Java 8, the recommended API is the `java.time` package, which provides classes like `LocalDate`, `LocalTime`, `LocalDateTime`, and `DateTimeFormatter`. The Java 8 Date and Time API is immutable, thread-safe, and easier to use."**

---

# Date APIs in Java

## 1. `Date` (Legacy API)

* Package: `java.util`
* Represents a specific date and time.
* Considered a legacy class.

```java
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}
```

**Sample Output**

```
Fri Jul 31 16:00:25 IST 2026
```

---

## 2. `Calendar` (Legacy API)

Used to manipulate dates.

```java
import java.util.Calendar;

public class Demo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH) + 1);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    }
}
```

---

# Java 8 Date and Time API (`java.time`)

## 1. `LocalDate`

Stores only the date.

```java
import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println(today);
    }
}
```

**Output**

```
2026-07-31
```

---

## 2. `LocalTime`

Stores only the time.

```java
import java.time.LocalTime;

public class Demo {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();

        System.out.println(time);
    }
}
```

---

## 3. `LocalDateTime`

Stores both date and time.

```java
import java.time.LocalDateTime;

public class Demo {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();

        System.out.println(dt);
    }
}
```

---

## 4. `DateTimeFormatter`

Formats dates and times.

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Demo {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(today.format(formatter));
    }
}
```

**Output**

```
31-07-2026
```

---

# Common Date Operations

### Add Days

```java
LocalDate today = LocalDate.now();

System.out.println(today.plusDays(5));
```

### Subtract Months

```java
System.out.println(today.minusMonths(2));
```

### Compare Dates

```java
LocalDate d1 = LocalDate.of(2026, 7, 31);
LocalDate d2 = LocalDate.now();

System.out.println(d1.isEqual(d2));
System.out.println(d1.isBefore(d2));
System.out.println(d1.isAfter(d2));
```

---

# Old API vs New API

| Old API         | New API                  |
| --------------- | ------------------------ |
| `Date`          | `LocalDate`              |
| `Calendar`      | `LocalDateTime`          |
| Mutable         | Immutable                |
| Not thread-safe | Thread-safe              |
| Complex         | Easy to use              |
| Legacy          | Recommended since Java 8 |

---

# Common Interview Questions

**Q: Which date API should you use in modern Java?**

> The `java.time` package introduced in Java 8.

**Q: What is the difference between `LocalDate` and `LocalDateTime`?**

> `LocalDate` stores only the date, while `LocalDateTime` stores both the date and time.

**Q: How do you format a date?**

> By using the `DateTimeFormatter` class.

**Q: Is `LocalDate` mutable?**

> No. It is immutable, so operations like `plusDays()` return a new object.

---

# Interview-Ready Answer (1 Minute)

> "Java provides both legacy and modern APIs for handling dates. The older API includes `Date` and `Calendar`, but since Java 8 the preferred approach is the `java.time` package. Classes like `LocalDate`, `LocalTime`, and `LocalDateTime` are immutable, thread-safe, and easier to work with. We use `DateTimeFormatter` to format dates, and methods like `plusDays()`, `minusMonths()`, and `isBefore()` for date calculations and comparisons. In modern Java applications, the `java.time` API is the recommended choice."
