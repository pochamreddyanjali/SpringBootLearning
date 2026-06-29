package com.example.fooddemo.controller;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddemo.dto.RequestDto;
import com.example.fooddemo.dto.ResponseDto;
import com.example.fooddemo.entity.Employee;
import com.example.fooddemo.service.FoodService;

import jakarta.validation.Valid;
@RestController
public class foodemo1controller {
	@Autowired
	FoodService foodservice;
	@PostMapping("/add")
	public String addCustomer(@Valid @RequestBody Employee emp)
	{
		return foodservice.addEmployee(emp);
		
	}
	
	@GetMapping("/getinfo")
	public List<Employee> getEmployees()
	{
		return foodservice.getEmployee();
	}
	@GetMapping("/getId/{id}")
	public Object getEmployeeById(@PathVariable int id)
	{
		Employee emp = foodservice.findId(id);

	    return emp;
	}
	@GetMapping("/deleteId/{id}")
	public String deleteById(@PathVariable int id)
	{
		Employee emp = foodservice.findId(id);
		if(emp==null)
		{
			return "Employee id not found to delete";
		}
		foodservice.deleteId(id);
		return "Employee id deleted Sucessfully";
	}
	/*@PostMapping("/update")
	public String updateEmployee(@RequestBody Employee emp)
	{
		return foodservice.update(emp);
	}*/
	@GetMapping("/getbyname/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name)
	{
		return foodservice.getEmployeeByName(name);
	}
	@GetMapping("/getbynamecontains/{name}")
	public List<Employee> getEmployeeByContains(@PathVariable String name)
	{
		return foodservice.getEmployeeByContain(name);
	}
	@GetMapping("/getbynameandid/{name}/{id}")
	public Employee getEmployeeByNameAndId(@PathVariable int id,@PathVariable String name)
	{
		return foodservice.getEmployeeByIdAndName(id, name);
	}
	@GetMapping("/startbyname/{name}")
	public List<Employee> getByName(@PathVariable String name)
	{
		return foodservice.findNameByStartingWith(name);
	}
	@GetMapping("/endbyname/{name}")
	public List<Employee> endByName(@PathVariable String name)
	{
		return foodservice.findNameByEndingWith(name);
	}
	@GetMapping("/findeven")
	public List<Employee> findevenids()
	{
		return foodservice.findEvenNames();
	}
	@GetMapping("/findodd")
	public List<Employee> findoddids()
	{
		return foodservice.findOddNames();
	}
    @GetMapping("/findidquery/{id}")
    public Employee findidquery(@PathVariable int id)
    {
    	return foodservice.findDetailsByIdQuery(id);
    }
    @GetMapping("/findnamequery/{name}")
    public List<Employee> findnamequery(@PathVariable String name)
    {
    	return foodservice.findDetailsByNameQuery(name);
    }
    @GetMapping("/findidandnamequery/{id}/{name}")
    public Employee findidandname(@PathVariable int id,@PathVariable String name)
    {
    	return foodservice.findDetailsByIdAndName(id, name);
    }
    @GetMapping("/employee/{paging}/{size}")
    public Page<Employee> findrecords(@PathVariable int paging,@PathVariable int size)
    {
    	return foodservice.getEmployeeRecord(paging,size);
    }
    @GetMapping("/sortnameasc")
    public List<Employee> findsortednames()
    {
    	return foodservice.getSortedNames();
    }
    @GetMapping("/sortnamedesc")
    public List<Employee> findsortednamesdesc()
    {
    	return foodservice.getSortedNamesDesc();
    }
    @GetMapping("/sortandpage/{page}/{size}")
    public Page<Employee> findpageandsort(@PathVariable int page,@PathVariable int size)
    {
    	return foodservice.getsortandpage(page, size);
    }
    @PostMapping("/addthroughdto")
    public ResponseDto addEmployee(@RequestBody RequestDto dto)
    {
    	return foodservice.addDto(dto);
    }
    @PostMapping("/responseentitydemo")
    public ResponseEntity<String> responseEntityDemo()
    {
    	
    	//return ResponseEntity.ok("ResponseEntity working successfully");
    	//return ResponseEntity.status(HttpStatus.CREATED).body("Employee added");
    	//return ResponseEntity.badRequest().body("Invalid Data");
    	//return ResponseEntity.notFound().build();
    	//return ResponseEntity.internalServerError().body("something went wrong");
    	//return ResponseEntity.noContent().build();
    	//return ResponseEntity.accepted().build();
    	return ResponseEntity.unprocessableEntity().body("validation failed");
    }
   }
