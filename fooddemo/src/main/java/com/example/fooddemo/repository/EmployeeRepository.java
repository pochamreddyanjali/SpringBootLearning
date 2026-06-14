package com.example.fooddemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	List<Employee> findByName(String name);
	List<Employee> findByNameContaining(String name);
	Employee findByIdAndName(int id,String name);
	List<Employee> findByNameStartingWith(String name);
	List<Employee> findByNameEndingWith(String name);
}
