package com.example.fooddemo.entity;



import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class Employee {
  @Id
  @Min(value=100,message="minimum value is 100")
  @Max(value=1000,message="maximum value is 1000")
  private int id;
  @NotBlank(message="name cannot be empty")
  @Size(min=3,max=10,message="name size minimum 3 and maximum 10")
  @NotNull(message="name cannot be null")
  private String name;
  public int getId()
  {
	  return id;
  }
  public void setId(int id)
  {
	  this.id=id;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  
}
