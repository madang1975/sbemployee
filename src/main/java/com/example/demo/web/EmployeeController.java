package com.example.demo.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.domain.*;

@RestController
public class EmployeeController {

  @Autowired  
  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/hello")
  String sayHello() {
    return "hello";
  }

  @GetMapping("/employees")
  List<Employee> all() {
    
    List<Employee> employees = new ArrayList<Employee>();
    repository.findAll().forEach(e -> employees.add(e));

    return employees;
  }

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable String id) {

    return repository.findById(id).get();
  }

  @PutMapping("/employees/{id}")
  Employee update(@RequestBody Employee newEmployee, @PathVariable String id) {

    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void delete(@PathVariable String id) {
    repository.deleteById(id);
  }
}