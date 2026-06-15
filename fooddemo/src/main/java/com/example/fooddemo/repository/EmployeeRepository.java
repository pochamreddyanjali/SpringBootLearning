package com.example.fooddemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fooddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	List<Employee> findByName(String name);
	List<Employee> findByNameContaining(String name);
	Employee findByIdAndName(int id,String name);
	List<Employee> findByNameStartingWith(String name);
	List<Employee> findByNameEndingWith(String name);
	@Query("select e from Employee e where mod(e.id,2)=0")
	List<Employee> findEvenNames();
	@Query("select e from Employee e where mod(e.id,2)!=0")
	List<Employee> findOddNames();
	@Query("select e from Employee e where e.id=?1")
	Employee findByIdQuery(@Param("id") int id);
	@Query("select e from Employee e where e.name=:name")
	List<Employee> findByNameQuery(@Param("name") String name);
	@Query(value="select * from Employee where id=:id and name=:name",nativeQuery=true)
	Employee findByIdAndNameQuery(@Param("id") int id,@Param("name") String name);
}
