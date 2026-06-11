package com.example.fooddemo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fooddemo.dto.EmployeeDto;

@Service
public class FoodService {
	ArrayList<EmployeeDto> emp=new ArrayList<EmployeeDto>();
    public String addEmployee(EmployeeDto user)
    {
    	emp.add(user);
    	return "Employee Added SucessFully";
    }
	public String getEmployee(int id)
	{
		for(EmployeeDto x:emp)
		{
			if(x.getId()==id)
				return x.getName();
		}
		return "Not Found";
	}
	public String find(String name)
	{
		for(EmployeeDto x:emp)
		{
	      if(x.getName().equals(name))
	      {
	    	  return "Employee found with given id:"+x.getId();
	      }
		}
		return "Not found";
	}
	public String deleteEmployee(int id)
	{
		for(EmployeeDto x:emp)
		{
			if(x.getId()==id)
			{
				emp.remove(x);
				return "Employee Deleted Successfully";
			}
		}
		return "Employee Not Found to delete";
	}
}
