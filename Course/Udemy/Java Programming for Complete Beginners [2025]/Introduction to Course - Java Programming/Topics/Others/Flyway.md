## Flyway

Flyway is a database migration/version-control tool used to manage database schema changes safely and consistently across development, testing, staging, and production.

### 1. Why use Flyway?

Without Flyway, developers might manually run SQL:

ALTER TABLE users ADD COLUMN phone VARCHAR(20);


This can cause problems because nobody knows exactly which changes have been applied to each environment.

Flyway solves this by storing database changes as versioned migration files.

### 2. How Flyway works

You create SQL files:

V1__create_users.sql
V2__add_phone_to_users.sql
V3__create_orders.sql


Flyway runs them in order:

V1 → V2 → V3


It keeps track of executed migrations in:

flyway_schema_history


So if V1 and V2 are already applied, Flyway only runs V3.

### 3. Migration naming

The common format is:

V<version>__<description>.sql


Example:

V1__create_users_table.sql
V2__add_email_to_users.sql
V3__create_orders_table.sql


The double underscore __ is important.

### 4. Where migrations go

With Spring Boot, normally:

src/main/resources/db/migration/


Example:

db/migration/
├── V1__create_users.sql
├── V2__add_email.sql
└── V3__create_orders.sql

### 5. Most important rule

Never modify an already-applied migration.

❌ Don't change:

V1__create_users.sql


after it has been deployed.

✅ Create:

V2__add_phone.sql


for the new change.

### 6. Important Flyway commands
Command	    Purpose
migrate	    Apply pending migrations
info	    Show migration status
validate	Check migration consistency
repair	    Repair Flyway metadata/history when needed
clean	    Delete database objects — dangerous in production

### 7. Versioned vs Repeatable migrations

Versioned:

V1__create_users.sql
V2__add_email.sql


Used for changes that should happen in a specific order.

Repeatable:

R__create_user_view.sql


Useful for objects such as views, procedures, and functions that may need to be reapplied when their definition changes.

### 8. Flyway + Git

Keep migration files in Git along with your application:

Git
 ├── Java/Spring code
 └── Flyway migrations
       ├── V1
       ├── V2
       └── V3


This gives your team a history of database changes.

### 9. Flyway + Spring Boot

With Spring Boot, Flyway can automatically run pending migrations when the application starts.

Typical flow:

Developer creates migration
          ↓
Commit to Git
          ↓
CI/CD deploys application
          ↓
Flyway checks database
          ↓
Pending migrations execute
          ↓
flyway_schema_history updated

### 10. The big picture

Remember these 5 things and you understand the foundation of Flyway:

1. Migration files = database changes
2. V1 → V2 → V3 = migration order
3. flyway_schema_history = what has already run
4. Never edit an applied migration
5. New database change = new migration


In one sentence:
> **Flyway lets you version, track, and automatically apply database schema changes in a controlled and repeatable way across environments.**

---
---

### 1. Add Flyway to your Spring Boot project

For Maven, add:

<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>


You'll also need your PostgreSQL driver:

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

### 2. Configure your database

In application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/myapp
spring.datasource.username=postgres
spring.datasource.password=password

spring.flyway.enabled=true


The important part is that Flyway knows which database to migrate.

### 3. Create the migration folder

Create:

src/main/resources/db/migration/


Your project should look like:

src/
└── main/
    └── resources/
        └── db/
            └── migration/

### 4. Create your first migration

Create:

V1__create_users_table.sql


Put this inside:

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);


The naming is important:

V1__create_users_table.sql
│ │
│ └── description
└── version


Notice the two underscores between 1 and create.

### 5. Start your application

When Spring Boot starts, Flyway detects:

V1__create_users_table.sql


and executes it.

Your database now contains:

users
----------------
id
name
email


Flyway also creates its history table:

flyway_schema_history


This table lets Flyway know that V1 has already been executed.

### 6. Make another database change

Suppose you now want to add a phone number.

Don't change V1.

Create:

V2__add_phone_to_users.sql


with:

ALTER TABLE users
ADD COLUMN phone VARCHAR(20);


Start your application again.

Flyway sees:

V1 ✅
V2 ⏳


and runs V2.

Now:

V1 ✅
 ↓
V2 ✅


Your database has:

users
----------------
id
name
email
phone

### 7. Keep adding migrations

For example:

db/migration/
├── V1__create_users_table.sql
├── V2__add_phone_to_users.sql
├── V3__create_products_table.sql
├── V4__create_orders_table.sql
└── V5__add_status_to_orders.sql


Each file represents one database change.

The basic workflow is:

You need a DB change
       ↓
Create a new migration
       ↓
Put SQL inside it
       ↓
Commit it to Git
       ↓
Flyway executes it
       ↓
Flyway records it in flyway_schema_history

### 8. One rule you really need to remember
❌ Don't do this

You already deployed:

V1__create_users_table.sql


Then you edit that file.

✅ Do this instead

Create:

V2__add_phone_to_users.sql


This is because Flyway treats migrations as historical changes.

Think of it like:

V1 = "Create users"
V2 = "Add phone"
V3 = "Create orders"
V4 = "Add order status"


not:

V1 = "Current definition of users"

### 9. The most useful Flyway commands

If you're using the Flyway CLI, you'll commonly encounter:

flyway info


See migration status.

flyway migrate


Apply pending migrations.

flyway validate


Check that migration files and the recorded migration history are consistent.

flyway repair


Repair Flyway's schema-history metadata when appropriate.

For Spring Boot, you often don't need to manually run flyway migrate—Flyway can run automatically when the application starts.

### 10. What you should practice

Create a small project with this progression:

V1__create_users.sql
       ↓
V2__add_phone_to_users.sql
       ↓
V3__create_products.sql
       ↓
V4__create_orders.sql
       ↓
V5__add_order_status.sql


After each migration, look at:

flyway_schema_history


and understand why Flyway does or doesn't execute each file.

That's the point where Flyway starts to "click."
