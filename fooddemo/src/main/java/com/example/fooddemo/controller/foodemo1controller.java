package com.example.fooddemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.fooddemo.entity.Employee;
import com.example.fooddemo.service.FoodService;

@RestController
public class foodemo1controller {
	@Autowired
	FoodService foodservice;
	@PostMapping("/add")
	public String addCustomer(@RequestBody Employee emp)
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

	    if(emp != null)
	    {
	        return emp;
	    }

	    return "Employee Id Not Found";
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
	@PostMapping("/update")
	public String updateEmployee(@RequestBody Employee emp)
	{
		return foodservice.update(emp);
	}
   }