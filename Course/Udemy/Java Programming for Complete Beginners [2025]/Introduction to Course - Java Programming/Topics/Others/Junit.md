## What is JUnit?

**JUnit** is a Java testing framework used to write and run automated tests.

---

## Why use JUnit?

JUnit helps us:

- Automatically test Java code
- Detect bugs early
- Verify expected behavior
- Run tests repeatedly
- Test many input combinations
- Organize setup and cleanup
- Run tests as part of CI/CD
- Refactor code with more confidence

 Typical flow:

```
Write code
   ↓
Write tests
   ↓
Run tests
   ↓
PASS / FAIL
   ↓
Fix code
   ↓
Run tests again
```

---

## JUnit 5 Architecture

JUnit 5 is commonly thought of as:

```
JUnit 5
├── JUnit Platform
├── JUnit Jupiter   ← annotations + programming model
└── JUnit Vintage   ← support for older JUnit 3/4 tests
```
---

```
The basic pattern is:

Arrange
   ↓
Act
   ↓
Assert

This is commonly called the **AAA pattern**.
```

---

 ## `@Test`

 ### What?

 Marks a method as a normal test method.

 ### Why?

 JUnit needs to know which methods are tests.

 Without `@Test`, JUnit does not treat the method as a normal test method.

 ### When?

 Use it when you want to test one particular scenario.

 Example:

```
@Test
void shouldReturnTrueWhenUserIsActive() {
    assertTrue(user.isActive());
}
```

---

 ## `@ParameterizedTest`

 ### What?

 Runs the **same test multiple times with different input values**.

 Instead of:

```
@Test
void testPositiveNumber() {
    assertTrue(isPositive(10));
}

@Test
void testAnotherPositiveNumber() {
    assertTrue(isPositive(20));
}

@Test
void testAnotherPositiveNumberAgain() {
    assertTrue(isPositive(100));
}
```

 You can write:

```
@ParameterizedTest
@ValueSource(ints = {10, 20, 100})
void shouldIdentifyPositiveNumbers(int number) {
    assertTrue(isPositive(number));
}
```

 JUnit effectively runs:

```
number = 10 → test
number = 20 → test
number = 100 → test
```

 ### Why?

 Avoid duplicate test code.

 ##### `@ValueSource`

 Simple values:

```
@ParameterizedTest
@ValueSource(strings = {"Java", "JUnit", "Spring"})
void shouldNotBeEmpty(String value) {
    assertFalse(value.isEmpty());
}
```

 Supports common primitive/string types.

---

 ## `@RepeatedTest`

 ### What?

 Runs the same test a specified number of times.

```
@RepeatedTest(5)
void shouldRunFiveTimes() {
    System.out.println("Running test");
}
```

 JUnit executes it 5 times.

 ### Why?

 Useful when you want to verify behavior repeatedly.

 Example:

```
@RepeatedTest(10)
void shouldGenerateRandomNumberWithinRange() {
    int number = randomNumber();

    assertTrue(number >= 1 && number <= 100);
}
```

 ### Difference from `@ParameterizedTest`

 ##### Parameterized

 Different **inputs**:

```
10
20
30
40
```

 ##### Repeated

 Same **test**, repeated:

```
Run 1
Run 2
Run 3
Run 4
```

---

 ## `@BeforeAll`

 ### What?

 Runs **once before all tests** in the class.

```
@BeforeAll
static void setup() {
    System.out.println("Runs once");
}
```

 Example:

```
class UserServiceTest {

    @BeforeAll
    static void setupDatabase() {
        System.out.println("Start database");
    }

    @Test
    void test1() {
    }

    @Test
    void test2() {
    }
}
```

 Execution:

```
@BeforeAll
    ↓
test1
    ↓
test2
```

 ### Why?

 Use it for expensive setup that only needs to happen once.

 Examples:

 - Start a shared resource
- Initialize configuration
- Create expensive test infrastructure

 ##### Important

 By default, `@BeforeAll` must be `static`.

```
@BeforeAll
static void setup() {
}
```

---

 ## `@BeforeEach`

 ### What?

 Runs **before every test method**.

```
@BeforeEach
void setup() {
    calculator = new Calculator();
}
```

 Example:

```
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
    }
}
```

 Execution:

```
@BeforeEach
    ↓
testAddition

@BeforeEach
    ↓
testSubtraction
```

 ### Why?

 To prepare a **fresh test state** before each test.

---

 ##  `@AfterEach`

 ### What?

 Runs after every test.

```
@AfterEach
void cleanup() {
    System.out.println("Cleanup");
}
```

 Execution:

```
@BeforeEach
     ↓
@Test
     ↓
@AfterEach
```

 ### Why?

 For cleanup after each test.

 Examples:

 - Reset test data
- Close resources
- Clear state
- Delete temporary files

---

 ##  `@AfterAll`

 ### What?

 Runs once after all tests are complete.

```
@AfterAll
static void cleanup() {
    System.out.println("Runs once after all tests");
}
```

 Execution:

```
@BeforeAll
    ↓
test1
    ↓
test2
    ↓
test3
    ↓
@AfterAll
```

 ### Why?

 For cleanup of resources created by `@BeforeAll`.

 Example:

```
@BeforeAll
static void startServer() {
    // start server
}

@AfterAll
static void stopServer() {
    // stop server
}
```
---

 ##  `@DisplayName`

 ### What?

 Gives a test a readable name.

 Instead of:

```
shouldCalculateTotalCorrectly
```

 you can have:

```
@DisplayName("Should calculate total correctly")
@Test
void calculateTotal() {
}
```

 The test report can show:

```
Should calculate total correctly
```

 ### Why?

 Makes test reports easier for humans to understand.

 Example:

```
@DisplayName("Adding two positive numbers should return their sum")
@Test
void addPositiveNumbers() {
    assertEquals(5, calculator.add(2, 3));
}
```

---

 ##  `@Tag`

 ### What?

 Adds a label/category to a test.

```
@Tag("unit")
@Test
void shouldAddNumbers() {
}
```

 Another:

```
@Tag("integration")
@Test
void shouldSaveUserToDatabase() {
}
```

 You can have multiple tags:

```
@Tag("unit")
@Tag("calculator")
@Test
void shouldAddNumbers() {
}
```

 ### Why?

 Useful for grouping/filtering tests.

 For example:

```
unit
integration
slow
smoke
regression
```

 You can configure your build tool/IDE to run particular categories.

---

 ##  `@Disabled`

 ### What?

 Temporarily disables a test.

```
@Disabled
@Test
void temporarilyDisabledTest() {
}
```

 You can also give a reason:

```
@Disabled("Feature is currently under development")
@Test
void newFeatureTest() {
}
```

 ### Why?

 Useful when a test should temporarily not run.

 ##### Important

 Don't use `@Disabled` as a permanent way to hide broken tests.

 A disabled test is **not being verified**.

---

 ##  Assertions

 Assertions are how we tell JUnit:

 > "This is what I expect to happen."

 The most important import is:

```
import static org.junit.jupiter.api.Assertions.*;
```
---

 ##  `assertEquals`

 Checks that two values are equal.

```
assertEquals(expected, actual);
```

 Example:

```
assertEquals(5, calculator.add(2, 3));
```
---

 ##  `assertNotEquals`

 Checks that values are different.

```
assertNotEquals(10, calculator.add(2, 3));
```

---

 ##  `assertTrue`

 Checks that a condition is `true`.

```
assertTrue(user.isActive());
```

 Example:

```
assertTrue(10 > 5);
```

---

 ##  `assertFalse`

 Checks that a condition is `false`.

```
assertFalse(user.isBlocked());
```

 Example:

```
assertFalse(10 < 5);
```

---

 ##  `assertNull`

 Checks that a value is `null`.

```
assertNull(user.getMiddleName());
```

---

 ##  `assertNotNull`

 Checks that a value is not `null`.

```
assertNotNull(user);
```

---

 ##  `assertSame`

 Checks whether two references point to the **same object**.

```
assertSame(object1, object2);
```

 Example:

```
User user = new User();

User anotherReference = user;

assertSame(user, anotherReference);
```

 This checks **object identity**.

 Think:

```
object1 ─────┐
             ↓
           Object
             ↑
object2 ─────┘

Same object → PASS
```

---

 ##  `assertNotSame`

 Checks that two references are **not the same object**.

```
assertNotSame(user1, user2);
```

 Even if:

```
user1.equals(user2)
```

 is true, they can still be different objects.

---

 ##  `assertThrows`

 Checks that code throws the expected exception.

 Example:

```
@Test
void shouldThrowExceptionForInvalidAge() {

    assertThrows(
        IllegalArgumentException.class,
        () -> userService.createUser(-1)
    );
}
```

 Think:

```
Run code
   ↓
Exception expected?
   ↓
YES → PASS
NO  → FAIL
```

 You can also capture the exception:

```
IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> userService.createUser(-1)
        );

assertEquals("Age cannot be negative", exception.getMessage());
```

---

 ##  `assertDoesNotThrow`

 Checks that code does **not** throw an exception.

```
assertDoesNotThrow(() -> userService.createUser(25));
```

 Useful when successful execution itself is what you're verifying.

---

 ##  `assertArrayEquals`

 Compares arrays.

```
int[] expected = {1, 2, 3};
int[] actual = {1, 2, 3};

assertArrayEquals(expected, actual);
```

---

 ##  `assertIterableEquals`

 Compares iterable collections element by element.

```
List<String> expected = List.of("A", "B", "C");
List<String> actual = service.getNames();

assertIterableEquals(expected, actual);
```

---

 ##  `assertLinesMatch`

 Useful for comparing lines of text.

```
assertLinesMatch(
    List.of("Hello", "World"),
    List.of("Hello", "World")
);
```
---

 ##  `assertAll`

 Runs multiple assertions together.

 Instead of:

```
assertEquals("John", user.getName());
assertEquals(25, user.getAge());
assertTrue(user.isActive());
```

 You can write:

```
assertAll(
    () -> assertEquals("John", user.getName()),
    () -> assertEquals(25, user.getAge()),
    () -> assertTrue(user.isActive())
);
```

 ### Why?

 JUnit can report failures from multiple assertions rather than stopping at the first failed assertion.

 Useful when validating an object's multiple properties.

---

 ##  Assertion Cheat Sheet

 | Assertion | Purpose |
| --- | --- |
| `assertEquals()` | Expected == actual |
| `assertNotEquals()` | Expected != actual |
| `assertTrue()` | Condition must be true |
| `assertFalse()` | Condition must be false |
| `assertNull()` | Value must be null |
| `assertNotNull()` | Value must not be null |
| `assertSame()` | Same object/reference |
| `assertNotSame()` | Different object/reference |
| `assertThrows()` | Exception must be thrown |
| `assertDoesNotThrow()` | Exception must not be thrown |
| `assertArrayEquals()` | Arrays must match |
| `assertIterableEquals()` | Iterables must match |
| `assertAll()` | Group multiple assertions |

---

 ##  `assertEquals` vs `assertSame`

 This is an important interview/revision topic.

 ##### `assertEquals`

 Checks **equality**.

```
assertEquals(user1, user2);
```

 Conceptually:

```
Do these objects have equal values?
```

 It generally relies on `equals()`.

 ##### `assertSame`

 Checks **identity**.

```
assertSame(user1, user2);
```

 Conceptually:

```
Are these two references pointing to the exact same object?
```

 Example:

```
User user1 = new User("John");
User user2 = new User("John");

assertEquals(user1, user2); // depends on equals()
assertNotSame(user1, user2); // different objects
```

---

 ##  `assertTrue` vs `assertEquals`

 You could write:

```
assertTrue(result == 5);
```

 But generally this is clearer:

```
assertEquals(5, result);
```

 Use the assertion that communicates the intention best.

 For example:

```
assertTrue(user.isActive());
```

 is natural because you're checking a boolean condition.

---

 ##  Testing Exceptions

 Bad/less useful:

```
@Test
void testException() {
    try {
        service.createUser(null);
        fail();
    } catch (IllegalArgumentException e) {
        // expected
    }
}
```

 JUnit provides:

```
@Test
void shouldThrowExceptionWhenUserIsNull() {

    assertThrows(
        IllegalArgumentException.class,
        () -> service.createUser(null)
    );
}
```
---

 ##  Combining Annotations

 Annotations can be combined.

 Example:

```
@DisplayName("Valid email should be accepted")
@Tag("unit")
@Test
void validEmailShouldBeAccepted() {
    assertTrue(isValidEmail("john@example.com"));
}
```

 Parameterized:

```
@DisplayName("Positive numbers should be accepted")
@Tag("unit")
@ParameterizedTest
@ValueSource(ints = {1, 5, 10, 100})
void positiveNumbersShouldBeAccepted(int number) {
    assertTrue(number > 0);
}
```

---

 ##  Parameterized Test Example

```
@ParameterizedTest
@CsvSource({
    "2, 3, 5",
    "10, 20, 30",
    "100, 200, 300"
})
void shouldAddNumbers(int a, int b, int expected) {

    assertEquals(
        expected,
        calculator.add(a, b)
    );
}
```
---

 ##  What Should a Unit Test Look Like?

 A good unit test usually has:

```
@Test
void shouldCalculateDiscountForPremiumUser() {

    // Arrange
    User user = new User("John", true);

    // Act
    double discount = service.calculateDiscount(user);

    // Assert
    assertEquals(20, discount);
}
```

 Remember:

```
ARRANGE
   ↓
Set up data

ACT
   ↓
Call method

ASSERT
   ↓
Verify result
```

---
 ##  The Most Important Things to Remember

 If you forget everything else, remember this:

```
@Test
→ This is a test

@BeforeEach
→ Prepare before every test

@AfterEach
→ Clean up after every test

@BeforeAll
→ Prepare once

@AfterAll
→ Clean up once

@ParameterizedTest
→ Same test + different inputs

@RepeatedTest
→ Same test + repeat N times

@DisplayName
→ Give test a readable name

@Tag
→ Categorize the test

@Disabled
→ Temporarily skip the test
```

 And assertions:

```
assertEquals()
→ values should be equal

assertNotEquals()
→ values should be different

assertTrue()
→ condition should be true

assertFalse()
→ condition should be false

assertNull()
→ should be null

assertNotNull()
→ should not be null

assertSame()
→ exact same object

assertNotSame()
→ different objects

assertThrows()
→ exception expected

assertDoesNotThrow()
→ no exception expected

assertAll()
→ check multiple things
```

---

 ##  Quick Mental Model

 Think of a JUnit test class as:

```
                 TEST CLASS
                     │
             ┌───────┴───────┐
             │               │
        Before All       After All
             │               │
             ↓               ↑
        ┌────────┐     ┌─────────┐
        │ Before │     │  After  │
        │  Each  │     │  Each   │
        └────┬───┘     └────▲────┘
             │              │
             ↓              │
           @Test ───────────┘
```

 The test itself follows:

```
Arrange → Act → Assert
```

 That's the core of everyday JUnit usage.

---

 ##  One-Page Revision

```
                     JUNIT 5
                        │
        ┌───────────────┼────────────────┐
        │               │                │
     TESTS           LIFECYCLE        ORGANIZATION
        │               │                │
     @Test          @BeforeAll       @DisplayName
     @Parameterized @BeforeEach      @Tag
     @Repeated       @AfterEach      @Disabled
                    @AfterAll
        │
        ↓
   ASSERTIONS
        │
   ┌────┼───────────────┐
   │    │               │
 equals boolean       null
   │    │               │
   │    ├─ true         ├─ null
   │    └─ false        └─ notNull
   │
   ├─ assertSame
   ├─ assertNotSame
   ├─ assertThrows
   ├─ assertDoesNotThrow
   ├─ assertArrayEquals
   ├─ assertIterableEquals
   └─ assertAll

```
---
