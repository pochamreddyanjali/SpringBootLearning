package com.example.fooddemo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddemo.dto.EmployeeDto;
import com.example.fooddemo.service.FoodService;

@RestController
public class foodemo1controller {
	@Autowired
	FoodService foodservice;
	@PostMapping("/add")
	public String addCustomer(@RequestBody EmployeeDto emp)
	{
		return foodservice.addEmployee(emp);
		
	}
	@GetMapping("/get/{id}")
	public String getCustomer(@PathVariable int id)
	{
		return foodservice.getEmployee(id);
	}
	@GetMapping("/search")
	public String search(@RequestParam String name)
	{
		return foodservice.find(name);
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		return foodservice.deleteEmployee(id);
	}
   }
