# Spring Container
```
1. What is a Spring Container?
Answer:
    The Spring Container is the core component of Spring that manages the creation, configuration, dependency injection, and lifecycle of beans (objects) in a Spring application.
2. What is a Bean in Spring?
Answer:
    A Bean is an object that is instantiated, configured, and managed by the Spring Container.
Example:
    @Component
    public class UserService {
    }
UserService becomes a Spring bean.

3. What are the types of Spring Containers?
Answer:
    BeanFactory
    Basic container
    Supports Dependency Injection
    Uses lazy initialization
    ApplicationContext
    Advanced container
    Includes BeanFactory features
    Supports AOP, events, i18n, and automatic bean processing
    Most commonly used
4. Difference between BeanFactory and ApplicationContext?
    BeanFactory	                    ApplicationContext
    Basic container	                Advanced container
    Lazy bean loading by default	Eager singleton bean loading by default
    Limited features	            Supports AOP, events, i18n
    Rarely used	                    Widely used
5. What is Dependency Injection (DI)?
Answer:
    Dependency Injection is a design pattern where the Spring Container provides required dependencies to a bean instead of the bean creating them itself.
        @Service
        public class UserService {
            private final UserRepository repository;

            public UserService(UserRepository repository) {
                this.repository = repository;
            }
        }
6. How does the Spring Container create beans?
Answer:
    Reads configuration (XML, Java Config, Annotations)
    Scans classes
    Creates bean instances
    Injects dependencies
    Initializes beans
    Manages lifecycle
7. What are the ways to configure Spring beans?
Answer:
    XML Configuration
    Java-based Configuration (@Configuration, @Bean)
    Annotation-based Configuration (@Component, @Service, etc.)
8. What is @ComponentScan?
Answer:
    @ComponentScan tells Spring where to search for classes annotated with @Component, @Service, @Repository, and @Controller.

    @Configuration
    @ComponentScan("com.example")
    public class AppConfig {
    }
9. What is the default bean scope in Spring?
Answer:
    The default scope is Singleton, meaning only one instance of the bean is created per Spring Container.
10. What are the bean scopes in Spring?
Answer:
    Singleton
    Prototype
    Request
    Session
    Application
    WebSocket
11. What is the bean lifecycle in Spring?
Answer:
    Instantiate Bean
        ↓
    Inject Dependencies
        ↓
    @PostConstruct
        ↓
    Bean Ready
        ↓
    @PreDestroy
        ↓
    Bean Destroyed
12. What is @Autowired?
Answer:
    @Autowired is used to automatically inject dependencies by type.
@Autowired
    private UserRepository repository;
    Constructor injection is generally preferred.
13. Why is constructor injection preferred over field injection?
Answer:
    Promotes immutability
    Easier unit testing
    Dependencies are mandatory
    Better design and maintainability
Example:
    @Service
    public class UserService {
        private final UserRepository repository;
        public UserService(UserRepository repository) {
            this.repository = repository;
        }
    }
14. What is @Bean?
Answer:
    @Bean tells Spring that a method returns an object that should be managed by the Spring Container.
@Configuration
    public class AppConfig {
        @Bean
        public UserRepository userRepository() {
            return new UserRepository();
        }
    }
15. What is the difference between @Component and @Bean?
@Component	                            @Bean
Applied on class	                    Applied on method
Auto-detected during component scan	    Explicitly declared in configuration
Used for application classes	        Used for third-party or custom object creation

Interview One-Liner (Most Asked)
Q: What is Spring Container?
Answer:
    "Spring Container is the core of the Spring Framework that creates, configures, injects dependencies into, and manages the complete lifecycle of beans using Dependency Injection and Inversion of Control (IoC)."
```
## JavaBean vs POJO vs SpringBean
```
Feature	             POJO	                      JavaBean	                      Spring Bean
Full Form	         Plain Old Java Object	      JavaBean	                      Spring-managed Bean
Definition           Any ordinary Java class not  Specialized POJO that follows   Any object managed by the Spring 
                     bound to special frameworks  JavaBean conventions            IoC container
                     or restrictions
Default Constructor  No                           Yes (public no-arg)             Usually recommended, but not always 
Required                                                                          required
Private Fields       Optional                     Typically yes                   Optional
Getters/Setters      Not required                 Required for properties         Not required, but commonly used
Serializable         Not required                 Traditionally should            Not required
                                                  implement Serializable
Framework Dependency None                         JavaBean specification          Spring Framework
Object creation      Using new keyword            Using new keyword               Created and managed by Spring container
Lifecycle Management Developer-managed            Developer-managed               Spring-managed
Dependency Injection No built-in support          No built-in support             Supports dependency injection
Scope Support        No                           No                              Singleton, Prototype, Request,
                                                                                  Session, etc.
Example Annotation   None                         None                           @Component, @Service, @Repository, @Bean

Quick Interview Answer
Term	        One-line Definition
POJO	        Any simple Java object with no special restrictions.
JavaBean	    A POJO that follows JavaBean conventions (no-arg constructor, getters/setters, etc.).
Spring Bean	    Any object whose lifecycle is managed by the Spring container.
```
## @Component vs @Bean
```
Heading             @Component                                  @Bean
Where?              Can be used on any Java class               Typically used on methods in Spring Configuration classes
Ease of use         Very easy. Just add an annotation.          You write all the code.
Autowiring          Yes- Field, Setter or Constructor Injection Yes - method call or method parameters
Who creates beans?  Spring Framework                            You write bean creation code
RecommendedFor      Instantiating Beans for Your Own            1:Custom Business Logic
                    Application Code: @Component                2: Instantiating Beans for 3rd-party
                                                                libraries: @Bean
```
## 