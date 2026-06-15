package com.example.fooddemo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.fooddemo.entity.Employee;
import com.example.fooddemo.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public List<Employee> getEmployeeByName(String name)
    {
    	return repo.findByName(name);
    }
    public List<Employee> getEmployeeByContain(String name)
    {
    	return repo.findByNameContaining(name);
    }
    public Employee getEmployeeByIdAndName(int id,String name)
    {
    	return repo.findByIdAndName(id, name);
    }
    public List<Employee> findNameByStartingWith(String name)
    {
    	return repo.findByNameStartingWith(name);
    }
    public List<Employee> findNameByEndingWith(String name)
    {
    	return repo.findByNameEndingWith(name);
    }
    public List<Employee> findEvenNames()
    {
    	return repo.findEvenNames();
    }
    public List<Employee> findOddNames()
    {
    	return repo.findOddNames();
    }
    public Employee findDetailsByIdQuery(int id)
    {
    	return repo.findByIdQuery(id);
    }
    public List<Employee> findDetailsByNameQuery(String name)
    {
    	return repo.findByNameQuery(name);
    }
    public Employee findDetailsByIdAndName(int id,String name)
    {
    	return repo.findByIdAndNameQuery(id, name);
    }
    public Page<Employee> getEmployeeRecord(int paging,int size)
    {
    	PageRequest pageable=PageRequest.of(paging, size);
    	return repo.findAll(pageable);
    	
    }
    public List<Employee> getSortedNames()
    {
    	return repo.findAll(Sort.by("name"));
    }
    public List<Employee> getSortedNamesDesc()
    {
    	return repo.findAll(Sort.by("name").descending());
    }
    public Page<Employee> getsortandpage(int paging,int size)
    {
    	PageRequest pageable=PageRequest.of(paging,size,Sort.by("name"));
    	return repo.findAll(pageable);
    }
}
