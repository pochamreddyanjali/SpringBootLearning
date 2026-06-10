package com.example.fooddemo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddemo.dto.EmployeeDto;

@RestController
public class foodemo1controller {
	ArrayList<EmployeeDto> fres=new ArrayList<EmployeeDto>();
   @GetMapping("/employee/{id}")
   public String hello(@PathVariable int id) {
	   for(EmployeeDto x:fres)
	   {
		   if(x.getId()==id)
		   {
			   return x.getName();
		   }
	   }
	   return "not found";
   }
   @PostMapping("/employee")
   public String addEmployee(@RequestBody EmployeeDto employee1) {
	   fres.add(employee1);
	   return "Sucessfully Added";
   }
   @GetMapping("/search")
    public String searchEmployee(@RequestParam int id1) {
	   for(EmployeeDto x:fres)
	   {
		   if(x.getId()==id1)
		   {
			   return x.getName();
		   }
	   }
	   return "Not Found";
	   
   }
}
