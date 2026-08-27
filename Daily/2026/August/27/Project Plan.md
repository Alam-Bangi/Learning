## DoneDeck (Task Tracker)

1. Backend
	- Java Code
		11 version

2. Database
	- MySql 

3. SpringBoot 
	- 2.7
	- Backend Framework
	- @RestController
	- @Service
	- @Repository
	- @Entity, etc

4. Spring Web/API
	- POST
	- GET
	- DELETE
	- PUT

5. Spring Data JPA
	- Interaction with SQL Database
---

Function to mark each as not completed once day is over
For each user generate a unique user id
User can add task as per their need 

---

User opens website
	unique id is created for user
	table dates will be starting from day user id is created(if new user)
	can add/edit/delete task
	marks task as completed/not completed

---

- How will you manage database?
	- Using Spring Data JPA

- how will tables get created
	- Using Spring Annotations

- How Will store data will you seed data ( what is seeding data means)
	- MySql to store data
	- Seeding needs to be done to help new user understand how  our app works and what all can be done in it
	- Can be seeded using Raw SQL

- What about maven docker java springboot flyway swagger
	- Maven is a build automation and project management tool (instead of searching, downloading & adding dependencies manually we can specify it in pom.xml and let maven import it)

	- Flyway is needed because traditional ways of managing databases—like sharing raw SQL files manually—fail as teams and applications grow.(to make changes for each  machine without data loss/change)

	- Swagger is useful to test code without testing tools(it created website based on backend code to check working of api's). It also helps us document backend code automatically by reading code itself.

    - Docker is used to create an app in a container to run on each machine

- How about UI 
	- UI is needed and can be done in HTML, CSS

- Only api or frontend 
	- Frontend in HTML, CSS

- How about authentication / authorization
	- Create user table with username and password
	- Spring security
	- Id and name for each user
	- Admin/User role

- How about in memory db to start to test with, till we are final about db schema?
	- Using H2 database

How about the ER diagram of the project 

