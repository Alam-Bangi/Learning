```
1. @Bean
Q: What is @Bean?
	A: It tells Spring that a method creates and returns an object that should be managed as a Spring bean.
	@Configuration
	public class AppConfig {
	    @Bean
	    public EmailService emailService() {
	        return new EmailService();
	    }
	}

Q: When do you use @Bean instead of @Component?
	A: When you need to configure third-party classes or require custom bean creation logic.

2. @Configuration
Q: What is @Configuration?
	A: Marks a class that contains bean definitions.
	@Configuration
	public class AppConfig {
	}

Q: Difference between @Configuration and @Component?
	A: @Configuration is specifically for bean configuration classes, while @Component is for general Spring-managed classes.

3. @Component
Q: What is @Component?
	A: A generic stereotype annotation used to register a class as a Spring bean.
	@Component
	public class EmailService {
	}

Q: How does Spring detect @Component classes?
	A: Through component scanning (@ComponentScan).

4. @ComponentScan
Q: What does @ComponentScan do?
	A: It tells Spring where to search for beans.
	@ComponentScan("com.example")

Q: What happens if a package isn't scanned?
	A: Spring won't create beans from classes in that package.

5. @Primary
Q: Why use @Primary?
	A: When multiple beans of the same type exist, Spring chooses the @Primary bean by default.
	@Primary
	@Component
	public class StripePaymentService implements PaymentService {}

Q: Can @Qualifier override @Primary?
	A: Yes.

6. @Qualifier
Q: Why use @Qualifier?
	A: To specify exactly which bean should be injected.
	@Autowired
	@Qualifier("paypalPaymentService")
	private PaymentService paymentService;

Q: When is it needed?
	A: When multiple beans of the same type exist.

7. @Autowired
Q: What is @Autowired?
	A: Automatically injects dependencies.
	@Autowired
	private EmailService emailService;

Q: Which injection type is recommended?
	A: Constructor injection.
	@Autowired
	public UserService(EmailService emailService) {
	    this.emailService = emailService;
	}

8. @Scope
Q: What does @Scope do?
	A: Defines bean lifecycle.
	@Scope("prototype")
	@Component
	public class User {}

	Common scopes:
	singleton (default)
	prototype
	request
	session

Q: Default scope?
	A: Singleton.

9. @Named
Q: What is @Named?
	A: JSR-330 equivalent of @Component.
	@Named
	public class EmailService {}

Q: Why use it?
	A: For framework-independent dependency injection.

10. @Inject
Q: What is @Inject?
	A: JSR-330 equivalent of @Autowired.
	@Inject
	private EmailService emailService;

Q: Difference from @Autowired?
	A: Similar functionality, but @Inject is a Java standard.

11. @Lazy
Q: What does @Lazy do?
	A: Delays bean creation until first use.
	@Lazy
	@Component
	public class HeavyService {}

Q: Benefit?
	A: Faster application startup.

12. @PostConstruct
Q: When is @PostConstruct executed?
	A: After dependency injection is complete.
	@PostConstruct
	public void init() {
	    System.out.println("Initialized");
	}

Q: Typical use?
	A: Initialization logic.

13. @PreDestroy
Q: When is @PreDestroy executed?
	A: Before bean destruction.
	@PreDestroy
	public void cleanup() {
	    System.out.println("Cleanup");
	}

Q: Typical use?
	A: Closing resources.
	Spring Stereotype Annotations

14. @Service
Q: What is @Service?
	A: Indicates business logic layer.
	@Service
	public class UserService {}

Q: Difference from @Component?
	A: Semantically represents business services.

15. @Repository
Q: What is @Repository?
	A: Marks DAO/data access layer classes.
	@Repository
	public class UserRepository {}

Q: Special feature?
	A: Automatic database exception translation.
	Spring MVC / REST Annotations

16. @RestController
Q: What is @RestController?
	A: Combination of @Controller and @ResponseBody.
	@RestController
	public class UserController {}

Q: What does it return?
	A: JSON/XML response directly.

17. @RequestMapping
Q: What is @RequestMapping?
	A: Maps requests to controller methods/classes.
	@RequestMapping("/users")

Q: Can it specify HTTP methods?
	A: Yes.
	@RequestMapping(method = RequestMethod.GET)

18. @GetMapping
Q: Purpose of @GetMapping?
	A: Handles HTTP GET requests.
	@GetMapping("/{id}")
	Use case: Fetch data.

19. @PostMapping
Q: Purpose of @PostMapping?
	A: Handles HTTP POST requests.
	@PostMapping
	Use case: Create data.

20. @PutMapping
Q: Purpose of @PutMapping?
	A: Handles HTTP PUT requests.
	@PutMapping("/{id}")
	Use case: Update existing records.

21. @DeleteMapping
Q: Purpose of @DeleteMapping?
	A: Handles HTTP DELETE requests.
	@DeleteMapping("/{id}")
	Use case: Delete records.

JPA/Hibernate Annotations
22. @Entity
Q: What is @Entity?
	A: Maps a Java class to a database table.
	@Entity
	public class User {}

Q: Requirements?
	A: Must have a primary key.

23. @Id
Q: What is @Id?
	A: Marks the primary key field.
	@Id
	private Long id;

24. @GeneratedValue
Q: What does @GeneratedValue do?
	A: Automatically generates primary key values.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	Common strategies:
	IDENTITY
	SEQUENCE
	TABLE
	AUTO

Configuration Properties
25. @ConfigurationProperties
Q: What is @ConfigurationProperties?
	A: Maps application properties into Java objects.
	@ConfigurationProperties(prefix = "app")
	public class AppProperties {
	    private String name;
	}
	application.yml
	app:
	  name: MyApp

	Benefit?
	Type-safe configuration
	Cleaner than many @Value annotations

JUnit 5 Testing Annotations
26. @BeforeAll
Q: When does @BeforeAll run?
	A: Once before all tests.
	@BeforeAll
	static void setup() {}

27. @BeforeEach
Q: When does @BeforeEach run?
	A: Before every test.
	@BeforeEach
	void init() {}

28. @AfterEach
Q: When does @AfterEach run?
	A: After every test.
	@AfterEach
	void cleanup() {}

29. @AfterAll
Q: When does @AfterAll run?
	A: Once after all tests finish.
	@AfterAll
	static void teardown() {}

Frequently Asked Interview Questions
Q: Difference between @Component, @Service, and @Repository?
	Annotation		Layer
	@Component		Generic bean
	@Service		Business logic
	@Repository		Data access layer

Q: Difference between @Autowired and @Inject?
	@Autowired				@Inject
	Spring-specific			JSR-330 standard
	Has required=false		No equivalent
	More Spring features	Framework-independent

Q: Difference between @Bean and @Component?
	@Bean							@Component
	Method level					Class level
	Manual bean creation			Automatic scanning
	Useful for 3rd-party classes	For your own classes

Q: Difference between @Primary and @Qualifier?
	@Primary		@Qualifier
	Default choice	Explicit choice
	Used once		Used at injection point

Q: Singleton vs Prototype Scope?
	Singleton					Prototype
	One instance per container	New instance every request
	Default scope				Explicitly configured
```
```
1. What is Spring Boot?
Answer:
    Spring Boot is an extension of the Spring Framework that simplifies application development by providing:
        Auto Configuration
        Embedded Servers (Tomcat, Jetty, Undertow)
        Starter Dependencies
        Production-ready features
        Minimal configuration
    Example:
        @SpringBootApplication
        public class Application {
            public static void main(String[] args) {
                SpringApplication.run(Application.class, args);
            }
        }

2. Why was Spring Boot created?
Answer:
    To reduce the complexity of Spring applications by:
        Eliminating XML configuration
        Reducing boilerplate code
        Providing sensible defaults
        Simplifying dependency management

3. What are the advantages of Spring Boot?
Answer:
    Rapid development
    Auto Configuration
    Embedded web servers
    Microservice-friendly
    Easy dependency management
    Production-ready monitoring
    Minimal setup

4. What is the difference between Spring and Spring Boot?
    Spring	                        Spring Boot
    Requires configuration	        Auto-configured
    External server needed	        Embedded server
    More setup	                    Less setup
    Dependency management manual    Starter dependencies

5. What is Auto Configuration?
Answer:
    Spring Boot automatically configures beans based on dependencies available in the classpath.
    Example:
    If spring-boot-starter-web is added, Spring Boot automatically configures:
    DispatcherServlet
    Tomcat
    Jackson
    REST support

6. How does Auto Configuration work?
Answer:
    Using:
    @EnableAutoConfiguration

    Spring Boot checks:
    Dependencies
    Classpath
    Existing beans
    and creates required beans automatically.

7. What is @SpringBootApplication?
Answer:
        Combination of:
        @Configuration
        @EnableAutoConfiguration
        @ComponentScan
    Example:
    @SpringBootApplication
    public class App {
    }

8. Explain @EnableAutoConfiguration.
Answer:
    Enables Spring Boot's automatic bean configuration.
        @EnableAutoConfiguration
    Usually included inside:
        @SpringBootApplication

9. Explain Component Scanning.
Answer:
    Spring scans packages for:
        @Component
        @Service
        @Repository
        @Controller
        @RestController
    and creates beans automatically.

10. What are Starter Dependencies?
Answer:
    Predefined dependency bundles.
    Examples:
        spring-boot-starter-web
        spring-boot-starter-data-jpa
        spring-boot-starter-security
        spring-boot-starter-test

11. What is spring-boot-starter-web?
Answer:
Provides:
    Spring MVC
    Embedded Tomcat
    Jackson
    Validation support
    Used for REST applications.

12. What is Embedded Tomcat?
Answer:
    Tomcat packaged inside the application.
    Run directly:
    java -jar app.jar
    No separate server installation required.

13. Can we use servers other than Tomcat?
Answer:
    Yes.
    Supported:
    Tomcat (default)
    Jetty
    Undertow

14. What is Dependency Injection?
Answer:
    A design pattern where Spring provides required objects automatically.
    Example:
        @Service
        public class UserService {
            private final UserRepository repo;
            public UserService(UserRepository repo) {
                this.repo = repo;
            }
        }

15. What is Inversion of Control (IoC)?
Answer:
    Object creation and lifecycle are managed by Spring instead of the programmer.

16. What is IoC Container?
Answer:
    Spring container that creates and manages beans.
    Examples:
        BeanFactory
        ApplicationContext

17. Difference between BeanFactory and ApplicationContext?
    BeanFactory	        ApplicationContext
    Basic container	    Advanced container
    Lazy loading	    Eager loading
    Limited features	Enterprise features

18. What is a Spring Bean?
Answer:
    An object managed by Spring Container.
    @Component
    public class EmailService {
    }

19. Bean Lifecycle?
Answer:
    Bean Instantiation
    Dependency Injection
    @PostConstruct
    Bean Usage
    @PreDestroy

20. What are Bean Scopes?
Answer:
    singleton
    prototype
    request
    session
    application
    Default: singleton

21. What is Singleton Scope?
Answer:
    Only one bean instance per Spring Container.

22. What is Prototype Scope?
Answer:
    A new bean instance is created every time requested.

23. What is application.properties?
Answer:
    Stores application configuration.
    Example:
    server.port=8081
    spring.application.name=myapp

24. What is application.yml?
Answer:
    YAML version of configuration.
    server:
    port: 8081

25. Difference between properties and YAML?
    Properties	    YAML
    Key-value	    Hierarchical
    Verbose	        Cleaner
    Flat structure	Nested structure

26. How to change server port?
Answer:
    server.port=9090

27. How to run a Spring Boot application?
Answer:
    Using:
    mvn spring-boot:run
    or
    java -jar app.jar

28. What is Spring Initializr?
Answer:
    Tool for generating Spring Boot projects with dependencies.
    Commonly used through IDEs or Spring Initializr website.

29. What is Actuator?
    Answer:
    Provides monitoring endpoints.
    Dependency:
    spring-boot-starter-actuator

30. Common Actuator Endpoints?
    Endpoint	Purpose
    /health	    Health status
    /info	    App info
    /metrics	Metrics
    /beans	    All beans
    /env	    Environment

31. What is DevTools?
Answer:
    Provides:
    Automatic restart
    Live reload
    Faster development
    Dependency: spring-boot-devtools

32. What is @Value?
Answer:
    Injects property values.
    @Value("${app.name}")
    private String appName;

33. What is @ConfigurationProperties?
Answer:
    Maps multiple properties to Java object.
    @ConfigurationProperties(prefix="app")
    Preferred for large configurations.

34. What is CommandLineRunner?
Answer:
    Runs code after application startup.
    @Bean
    CommandLineRunner runner() {
        return args -> {
            System.out.println("Started");
        };
    }

35. What is ApplicationRunner?
Answer:
    Similar to CommandLineRunner but provides structured access to arguments.

36. What is Spring Boot Fat Jar?
Answer:
    Single executable JAR containing:
    Application classes
    Dependencies
    Embedded server

37. What is Profiles in Spring Boot?
Answer:
    Used for environment-specific configuration.
    Examples:
    dev
    test
    prod

38. How to activate a profile?
    spring.profiles.active=dev

39. What is application-dev.properties?
Answer:
    Configuration specific to dev environment.
    Example:
    server.port=8081

40. What is Exception Handling in Spring Boot?
Answer:
    Handled using:
    @ControllerAdvice
    and
    @ExceptionHandler

41. What is REST API?
Answer:
    An API using HTTP methods:
    GET
    POST
    PUT
    DELETE
    for communication.

42. Difference between @Controller and @RestController?
    @Controller	    @RestController
    Returns view	Returns JSON
    Used in MVC	    Used in REST

43. What is DispatcherServlet?
Answer:
    Front Controller of Spring MVC.
    Handles all incoming requests.

44. What is Spring Data JPA?
Answer:
    Simplifies database operations using repositories.
    Example:
    public interface UserRepository
            extends JpaRepository<User, Long> {
    }

45. What is JpaRepository?
Answer:
    Provides built-in CRUD operations.
    Examples:
    save()
    findById()
    findAll()
    deleteById()

46. What is Hibernate?
Answer:
    Default ORM framework used by Spring Boot JPA.
    Converts Java objects to database records.

47. What is ORM?
Answer:
    Object Relational Mapping.
    Maps:
    Java Object ↔ Database Table

48. What is H2 Database?
Answer:
    In-memory database commonly used for testing.

49. What is Spring Security?
Answer:
    Framework providing:
    Authentication
    Authorization
    CSRF protection
    Password encryption

50. What are Microservices?
Answer:
    Architecture where applications are divided into small independently deployable services.

- Most Asked Freshers Question
Q. Explain Spring Boot Architecture.
Answer:
        Client
           ↓
        Controller
           ↓
        Service
           ↓
        Repository
           ↓
        Database

    Controller handles requests.
    Service contains business logic.
    Repository interacts with database.
    Database stores data.
```