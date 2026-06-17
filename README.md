day-1
learned spring boot basics

----------------------------------------------------------------------------------
day-2
package com.example.fooddemo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddemo.dto.EmployeeDto;

@RestController
public class foodemo1controller {
	ArrayList<EmployeeDto> fres=new ArrayList<EmployeeDto>();
   @GetMapping("/employee/{id}")
   public String hello(@PathVariable int id) {
	   for(EmployeeDto x:fres)
	   {
		   if(x.getId()==id)
		   {
			   return x.getName();
		   }
	   }
	   return "not found";
   }
   @PostMapping("/employee")
   public String addEmployee(@RequestBody EmployeeDto employee1) {
	   fres.add(employee1);
	   return "Sucessfully Added";
   }
   @GetMapping("/search")
    public String searchEmployee(@RequestParam int id1) {
	   for(EmployeeDto x:fres)
	   {
		   if(x.getId()==id1)
		   {
			   return x.getName();
		   }
	   }
	   return "Not Found";
	   
   }
}

1. Path Variable

Learned how to pass values directly in URL.

Example:

@GetMapping("/employee/{id}")
public String hello(@PathVariable int id)

URL:

/employee/572

Used for identifying specific resources.

2. Request Param

Learned how to pass query parameters in URL.

Example:

@GetMapping("/search")
public String searchEmployee(@RequestParam int id1)

URL:

/search?id1=572

Used mainly for:

searching
filtering
sorting
3. Request Body

Learned how to send complete JSON object using POST method.

Example:

@PostMapping("/employee")
public String addEmployee(@RequestBody EmployeeDto employee1)

JSON:

{
   "name":"Anjali",
   "id":572
}

Used for creating or updating data.

4. DTO Creation

Created EmployeeDto class with:

name
id
getters and setters

Learned how Spring automatically converts JSON into Java object.
-------------------------------------------------------------------------
day-3

Today I learned about the Service Layer and Dependency Injection in Spring Boot. 
Earlier, all my business logic such as adding, searching, and deleting employees was 
written inside the Controller layer. I learned that this is not a good practice for large 
applications because controllers should only handle HTTP requests and responses. 
Business logic should be moved to the Service layer, which makes the application more
 organized and easier to maintain.

I learned to create a Service class using the `@Service` annotation and understood that
 Spring Boot automatically creates and manages objects of service classes. I also learned 
 about `@Autowired`, which is used for Dependency Injection. Instead of manually creating 
 objects using the `new` keyword, Spring Boot injects the required objects automatically.

I understood the layered architecture used in Spring Boot applications: 
Frontend → Controller → Service → Repository → Database.
 Currently, I have implemented the Controller and Service layers.
  I also created a Delete API and learned how `@PathVariable` is used to pass dynamic values 
  through URLs. During practice, I discovered that String values should be compared using
   `equals()` or `equalsIgnoreCase()` instead of `==`, because `==` compares memory 
   references rather than actual content.

By the end of Day 3, I was able to separate responsibilities between Controller and Service
 layers, use Dependency Injection with `@Autowired`, implement add, search, get, and delete
  operations, and understand how a real Spring Boot application is structured.

--------------------------------------------------------------------------------------------

day-4 

Today I learned how to connect a Spring Boot application to a MySQL database and store data permanently.
I understood the difference between storing data in an ArrayList (temporary storage) and 
storing data in a database (permanent storage). I learned database concepts such as tables,
rows, columns, and primary keys. I created an Employee entity using the @Entity annotation 
and marked the primary key using @Id. I configured the database connection in application.
properties using spring.datasource.url, spring.datasource.username, and spring.datasource.
password. I also learned the purpose of spring.jpa.hibernate.ddl-auto=update, which 
automatically creates or updates tables based on entity classes, and 
spring.jpa.show-sql=true, which displays SQL queries in the console.

I created an EmployeeRepository by extending JpaRepository<Employee, Integer> and learned 
that Spring Data JPA provides methods like save(), findAll(), and findById() automatically.
I replaced the old ArrayList approach with repo.save(employee) to store employee data in
MySQL. During the process, I fixed several real-world issues such as missing MySQL JDBC 
driver dependencies, incorrect @Id imports, missing getter/setter methods, and duplicate 
primary key errors. Finally, I successfully sent employee data from Postman to a Spring
Boot REST API and verified that the data was stored in the MySQL employee table. 
This was my first complete end-to-end flow from 
Postman → Controller → Service → Repository → MySQL
Database

-------------------------------------------------------------------------------------------
CRUD Operations with Spring Boot & MySQL

Topics Covered
1. Read Operations
- Implemented `findAll()` to fetch all employee records.
- Implemented `findById()` to fetch a specific employee using ID.
- Learned about `Optional<Employee>` and handling null cases using `orElse(null)`.

2. Delete Operation
- Implemented `deleteById()` to delete employee records.
- Added validation to check whether the employee exists before deletion.
- Returned appropriate messages for successful deletion and employee-not-found scenarios.

3. Update Operation
- Implemented employee update functionality using `save()`.
- Learned that `save()` performs:
  - `INSERT` when ID does not exist.
  - `UPDATE` when ID already exists.
- Used `existsById()` to ensure updates are performed only on existing records.
 4. Repository Methods Learned
```java
save()
findAll()
findById()
deleteById()
existsById()

---------------------------------------------------------------------------------------------
Custom Query Methods in Spring Data JPA

Objective

Learned how Spring Data JPA automatically generates SQL queries based on method names without writing SQL manually.

Topics Covered

1. Custom Query Methods

Spring Data JPA can generate queries automatically by following method naming conventions.

2. Exact Match Search

java
List<Employee> findByName(String name);

Returns employees whose name exactly matches the given value.

3. Partial Search

java
List<Employee> findByNameContaining(String name);

Returns employees whose name contains the given text.

4. Search Using Multiple Conditions

java
Employee findByIdAndName(int id, String name);

Returns an employee when both ID and Name match.
5. Search Using Prefix

java
List<Employee> findByNameStartingWith(String name);


Returns employees whose names start with the given text.

6. Search Using Suffix

java
List<Employee> findByNameEndingWith(String name);


Returns employees whose names end with the given text.

Concepts Learned

* Spring Data JPA Query Generation
* Repository Layer Query Methods
* Method Naming Conventions
* Exact Match Queries
* Partial Match Queries
* Multiple Condition Queries
* Prefix and Suffix Searches

Benefits of Custom Query Methods

* No need to write SQL queries manually
* Cleaner code
* Better readability
* Faster development
* Easy maintenance

APIs Implemented

Get Employee By Name

http
GET /getbyname/{name}


Search Employee By Partial Name

http
GET /search/{name}


Get Employee By ID And Name

http
GET /getbynameandid/{id}/{name}


Get Employees Starting With Given Text

http
GET /startwith/{name}


Get Employees Ending With Given Text

http
GET /endwith/{name}

Outcome

Successfully implemented and tested multiple Spring Data JPA Custom Query Methods without writing SQL queries.

------------------------------------------------------------------------------------------------

JPQL and Native Queries in Spring Data JPA
Learned how to write custom queries using the `@Query` annotation in Spring Data JPA.

Topics Covered

1. JPQL (Java Persistence Query Language)

JPQL is used to write queries using Entity class names and field names instead of database table names and column names.

Example:

java
@Query("SELECT e FROM Employee e WHERE e.id=:id")
Employee findByIdQuery(@Param("id") int id);

2. Named Parameters

Named parameters use `@Param` annotation and improve query readability.

Example:

@Query("SELECT e FROM Employee e WHERE e.id=:id AND e.name=:name")
Employee findByIdAndNameQuery(
    @Param("id") int id,
    @Param("name") String name
);


3. Positional Parameters
Positional parameters use `?1`, `?2`, etc., based on the method parameter position.

Example:


@Query("SELECT e FROM Employee e WHERE e.id=?1 AND e.name=?2")
Employee findByIdAndNamePosition(int id, String name);

4. Custom JPQL Queries
Implemented custom queries using JPQL.

Examples:

@Query("SELECT e FROM Employee e WHERE MOD(e.id,2)=0")
List<Employee> findEvenIds();

@Query("SELECT e FROM Employee e WHERE MOD(e.id,2)=1")
List<Employee> findOddIds();

5. Native SQL Queries

Learned how to execute actual SQL queries using `nativeQuery=true`.

Example:

@Query(
value="SELECT * FROM employee WHERE id=:id",
nativeQuery=true
)
Employee findByIdNative(@Param("id") int id);

Concepts Learned

* JPQL
* @Query Annotation
* Named Parameters
* Positional Parameters
* Native SQL Queries
* Difference between JPQL and SQL
* Custom Query Execution

Difference Between JPQL and Native Query

JPQL

@Query("SELECT e FROM Employee e WHERE e.id=:id")


Uses:

* Entity Class Name
* Field Names

@Query(
value="SELECT * FROM employee WHERE id=:id",
nativeQuery=true
)

Uses:

* Table Names
* Column Names
* Actual SQL Syntax
Successfully implemented and tested JPQL queries, positional parameters, named parameters, and native SQL queries using Spring Data JPA.

-----------------------------------------------------------------------------------------------
Pagination and Sorting in Spring Data JPA

Learned how to efficiently retrieve and organize large datasets using Pagination and Sorting.

1. Pagination

Pagination is used to divide large datasets into smaller chunks called pages.

Benefits:

* Improves performance
* Reduces memory usage
* Faster API responses

2. Pageable

`Pageable` is an interface that stores pagination information such as page number, page size, and sorting information.

Example:

Pageable pageable = PageRequest.of(page,size);

3. PageRequest

Used to create a Pageable object.

Example:

PageRequest.of(0,5);

Meaning:

* Page Number = 0
* Records Per Page = 5

4. Page<Employee>

Used as the return type for paginated data.

Provides:

* Employee records
* Total pages
* Total elements
* Current page number
* Page size

Sorting

Used to arrange records in ascending or descending order.

Ascending:

repo.findAll(Sort.by("name"));

Descending:

repo.findAll(
    Sort.by("name").descending()
);

Pagination and Sorting Together

Example:

PageRequest.of(
    page,
    size,
    Sort.by("name")
);

Used to fetch limited records in a sorted order.

Successfully implemented Pagination, Sorting, and Pagination with Sorting using Spring Data JPA.
----------------------------------------------------------------------------------------------------
Exception Handling in Spring Boot


* Introduction to Exception Handling
* Custom Exceptions
* RuntimeException
* `throw` keyword
* `Optional.orElseThrow()`
* `@ExceptionHandler`
* `@RestControllerAdvice`
* Global Exception Handling

ustom Exception
Created custom exceptions to represent application-specific errors.

public class EmployeeNotFoundException extends RuntimeException
{
    public EmployeeNotFoundException(String msg)
    {
        super(msg);
    }
}

#### Using `orElseThrow()`

return repo.findById(id)
        .orElseThrow(() ->
        new EmployeeNotFoundException("Employee Not Found"));

* Returns employee if present.
* Throws exception if employee is not found.

#### Global Exception Handling

Created a global exception handler using:

@RestControllerAdvice
public class GlobalExceptionHandler
{
}

This class handles exceptions across the entire application.


#### Handling Specific Exceptions

@ExceptionHandler(EmployeeNotFoundException.class)
public String handleEmployeeNotFound(
        EmployeeNotFoundException ex)
{
    return ex.getMessage();
}

* Catches a specific exception.
* Returns a custom response instead of the default Spring Boot error response.

### Additional Implementation

Implemented custom exception handling for employee search operations:

* `EmployeeNotFoundException`
* `NameNotFoundException`

Handled both exceptions using `@ExceptionHandler`.

### Exception Flow

Client Request
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
Data Found ?
      ↓
Yes → Return Data
      ↓
No
      ↓
Throw Custom Exception
      ↓
GlobalExceptionHandler
      ↓
@ExceptionHandler
      ↓
Custom Response Returned

* Learned how to create and use custom exceptions.
* Learned how `orElseThrow()` works with `Optional`.
* Learned the purpose of `RuntimeException`.
* Learned centralized exception handling using `@RestControllerAdvice`.
* Learned to return meaningful error messages to API clients.
* Improved application robustness and maintainability through global exception handling.

-----------------------------------------------------------------------------------------------------------------------






