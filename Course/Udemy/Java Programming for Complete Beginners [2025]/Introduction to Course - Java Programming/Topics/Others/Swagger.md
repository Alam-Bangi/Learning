## Swagger 

> Swagger is a set of tools used to design, document, and test APIs. It is commonly used with the OpenAPI Specification.

Key points:

OpenAPI → Standard format for describing APIs.
Swagger UI → Interactive webpage to view and test API endpoints.
Swagger Editor → Tool for creating/editing OpenAPI files.
Swagger Codegen → Generates client/server code from API definitions.
Documents endpoints, HTTP methods, parameters, request bodies, responses, schemas, and authentication.
Supports testing APIs using “Try it out.”
Makes API documentation easy for developers, testers, frontend, and backend teams.

In one line:

Swagger helps developers document, understand, and test APIs easily, while OpenAPI defines the API structure.

---
---
### 1. Add this to pom.xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>


You should already have Spring Web:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>


So your dependencies could look like:

<dependencies>

    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Swagger / OpenAPI -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.7.0</version>
    </dependency>

</dependencies>

### 2. You don't need a Swagger config

For basic Swagger functionality, don't create a SwaggerConfig class.

Your controller can simply be:

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "All users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return "User " + id;
    }

    @PostMapping
    public String createUser(@RequestBody String name) {
        return "Created " + name;
    }
}


Start your application.

### 3. Open Swagger UI

Go to:

http://localhost:8080/swagger-ui.html

You should see something like:

Swagger UI

User Controller

GET    /users
GET    /users/{id}
POST   /users


You can expand an endpoint and click Try it out → Execute.

### 4. Check the OpenAPI JSON

Also try:

http://localhost:8080/v3/api-docs

If this returns JSON, Springdoc is successfully generating your API specification.

### 5. Then learn the annotations

Once the basic setup works, I'd recommend learning these in this order:

@Tag
@Operation
@ApiResponse
@Parameter
@RequestBody
@Schema


For example:

```
@Tag(name = "Users", description = "User management APIs")
@RestController
@RequestMapping("/users")
public class UserController {

    @Operation(
        summary = "Get all users",
        description = "Returns all registered users"
    )
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
```
Swagger will then turn that information into much nicer documentation.

Your setup, summarized
Your project	            Use
Spring Boot	                2.7
Java	                    11
Build	                    Maven
Swagger/OpenAPI library	    springdoc-openapi-ui
Version	                    1.7.0
Swagger UI	                /swagger-ui.html
OpenAPI JSON	            /v3/api-docs
