package com.example.fooddemo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.fooddemo.entity.Employee;
import com.example.fooddemo.repository.EmployeeRepository;

@Service
public class FoodService {
	@Autowired
	EmployeeRepository repo;
    public String addEmployee(Employee user)
    {
    	repo.save(user);
    	return "Employee Added SucessFully";
    }
	
}
