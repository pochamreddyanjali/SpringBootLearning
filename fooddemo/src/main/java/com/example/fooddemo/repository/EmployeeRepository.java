package com.example.fooddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	
}
