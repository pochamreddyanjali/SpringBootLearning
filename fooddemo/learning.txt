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

By the end of Day 4, I was able to separate responsibilities between Controller and Service
 layers, use Dependency Injection with `@Autowired`, implement add, search, get, and delete
  operations, and understand how a real Spring Boot application is structured.
