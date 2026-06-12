package com.example.fooddemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
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
   }