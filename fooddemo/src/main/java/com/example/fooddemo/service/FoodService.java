package com.example.fooddemo.service;
import java.util.List;

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
    public List<Employee> getEmployee()
    {
    	return repo.findAll();
    }
    public Employee findId(int id)
    {
    	return repo.findById(id).orElse(null);
    }
    public void deleteId(int id)
    {
    	
    	 repo.deleteById(id);
    }
    public String update(Employee emp)
    {
    	if(repo.existsById(emp.getId()))
    	{
    		repo.save(emp);
    		return "Employee updated Suceesfully";
    	}
    	return "Employee not found to be updated";
    }
}
