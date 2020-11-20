package com.example.demo.domain;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import org.springframework.data.annotation.Id;

//@Entity
public class Employee {

  @Id
  //@GeneratedValue
  private String id;
  private String name;
  private String role;

  public Employee() {}

  public Employee(String name, String role) {

    this.name = name;
    this.role = role;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getRole() {
    return this.role;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRole(String role) {
    this.role = role;
  }
 
  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
  }
}