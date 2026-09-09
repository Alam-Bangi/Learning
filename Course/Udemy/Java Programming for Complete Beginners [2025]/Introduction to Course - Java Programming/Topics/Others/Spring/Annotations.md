
 ## 1. Core Spring Annotations

 | Annotation | Use case |
| --- | --- |
| `@Component` | Marks a class as a Spring-managed bean |
| `@Service` | Marks a service/business-logic class |
| `@Repository` | Marks a DAO/repository class; also translates persistence exceptions |
| `@Controller` | Marks a class as an MVC controller |
| `@RestController` | Creates REST APIs; equivalent to `@Controller + @ResponseBody` |
| `@Autowired` | Injects a dependency automatically |
| `@Qualifier` | Selects a specific bean when multiple beans have the same type |
| `@Primary` | Makes one bean the default when multiple candidates exist |
| `@Bean` | Explicitly creates a Spring bean inside a configuration class |
| `@Configuration` | Indicates a class containing Spring bean definitions |

### Example

```
@Service
public class PaymentService {

    private final PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }
}
```

 Here, Spring creates `PaymentService` and injects `PaymentRepository`.

---

 ## 2\. Spring Boot Annotations

 | Annotation | Use case |
| --- | --- |
| `@SpringBootApplication` | Main annotation for a Spring Boot application |
| `@EnableAutoConfiguration` | Enables Spring Boot's automatic configuration |
| `@ComponentScan` | Tells Spring where to scan for components |
| `@ConfigurationProperties` | Maps configuration properties to a Java class |
| `@Value` | Reads a single value from `application.properties` / YAML |
| `@Profile` | Loads a bean only for a specific environment |

 ### Most important

```
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

 `@SpringBootApplication` effectively combines:

```
@Configuration
@EnableAutoConfiguration
@ComponentScan
```

---

 ## 3\. REST API Annotations

 | Annotation | Use case |
| --- | --- |
| `@RestController` | Defines a REST controller |
| `@RequestMapping` | Defines a common URL path |
| `@GetMapping` | Handles HTTP GET |
| `@PostMapping` | Handles HTTP POST |
| `@PutMapping` | Handles HTTP PUT |
| `@PatchMapping` | Handles HTTP PATCH |
| `@DeleteMapping` | Handles HTTP DELETE |
| `@PathVariable` | Gets a value from the URL path |
| `@RequestParam` | Gets a query parameter |
| `@RequestBody` | Converts request JSON into a Java object |
| `@ResponseStatus` | Specifies HTTP response status |
| `@ExceptionHandler` | Handles exceptions in a controller |

 ### Example

```
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getUsers(@RequestParam String city) {
        return userService.getUsers(city);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
```

 For:

```
GET /users/10
```

 `@PathVariable` gets `10`.

 For:

```
GET /users?city=Pune
```

 `@RequestParam` gets `Pune`.

 For:

```
POST /users
Content-Type: application/json

{
  "name": "Rahul",
  "age": 25
}
```

 `@RequestBody` converts JSON into a `User` object.

---

 ## 4\. JPA / Database Annotations

 If you're using Spring Data JPA:

 | Annotation | Use case |
| --- | --- |
| `@Entity` | Marks a class as a database entity |
| `@Table` | Specifies the database table |
| `@Id` | Marks the primary key |
| `@GeneratedValue` | Automatically generates ID |
| `@Column` | Configures a database column |
| `@Transient` | Excludes a field from persistence |
| `@OneToOne` | One-to-one relationship |
| `@OneToMany` | One-to-many relationship |
| `@ManyToOne` | Many-to-one relationship |
| `@ManyToMany` | Many-to-many relationship |
| `@JoinColumn` | Specifies foreign-key column |

 ### Example

```
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
}
```

 This tells JPA that `User` should be persisted as a database entity.

---

 ## 5\. Transaction Annotations

 ### `@Transactional`

 Used when multiple database operations should behave as **one transaction**.

```
@Service
public class OrderService {

    @Transactional
    public void placeOrder(Order order) {
        orderRepository.save(order);
        paymentService.processPayment(order);
    }
}
```

 If an appropriate runtime exception causes the transaction to roll back, the database changes made within that transaction are rolled back.

 **Common use case:** money transfer, order creation, inventory updates, etc.

---

 ## 6\. Validation Annotations

 Usually used with Jakarta Bean Validation.

 | Annotation | Use case |
| --- | --- |
| `@Valid` | Triggers validation of an object |
| `@NotNull` | Value cannot be null |
| `@NotBlank` | String cannot be null/empty/whitespace |
| `@NotEmpty` | Collection/string cannot be empty |
| `@Size` | Checks size |
| `@Min` | Minimum numeric value |
| `@Max` | Maximum numeric value |
| `@Email` | Validates email format |
| `@Pattern` | Validates against regex |

 ### Example

```
public class UserRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Min(18)
    private int age;
}
```

 Controller:

```
@PostMapping
public User createUser(@Valid @RequestBody UserRequest request) {
    return userService.createUser(request);
}
```

---

 ## 7\. Exception Handling

 ### `@ControllerAdvice`

 Used for **global exception handling**.

 ### `@ExceptionHandler`

 Specifies which exception a method handles.

```
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(
            UserNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
```

 This prevents you from writing the same exception-handling logic in every controller.

---

 ## 8\. Lombok Annotations Commonly Used with Spring

 These aren't Spring annotations, but you'll see them constantly in Spring Boot projects.

 | Annotation | Use case |
| --- | --- |
| `@Getter` | Generates getters |
| `@Setter` | Generates setters |
| `@Data` | Generates getters, setters, `equals`, `hashCode`, etc. |
| `@NoArgsConstructor` | Generates no-argument constructor |
| `@AllArgsConstructor` | Generates constructor for all fields |
| `@RequiredArgsConstructor` | Generates constructor for final/non-null fields |
| `@Slf4j` | Creates a logger |

 Example:

```
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
```

 Lombok generates the constructor, allowing Spring to perform constructor injection.

---

 ## 9\. Important Annotations to Remember for Interviews

 If you're preparing for a **Spring Boot interview**, prioritize these:

```
@SpringBootApplication
@Component
@Service
@Repository
@Controller
@RestController

@Autowired
@Qualifier
@Primary
@Bean
@Configuration

@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@RequestMapping
@PathVariable
@RequestParam
@RequestBody

@Entity
@Id
@GeneratedValue
@OneToMany
@ManyToOne
@ManyToMany

@Transactional

@Valid
@NotNull
@NotBlank
@Size
@Email

@ControllerAdvice
@RestControllerAdvice
@ExceptionHandler

@Value
@Profile
```

 ### Easy way to remember the architecture

```
Client
   ↓
@RestController
   ↓
@Service
   ↓
@Repository
   ↓
Database
```

 For example:

```
@RestController
class UserController {

    // API layer
}

@Service
class UserService {

    // Business logic
}

@Repository
interface UserRepository extends JpaRepository<User, Long> {

    // Database layer
}
```

 **In short:** `@Controller/@RestController` = API layer, `@Service` = business logic, `@Repository` = database layer, and `@Autowired`/constructor injection = connect the layers.