package com.example.demo.service;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
@Autowired
private Employee employee;
public String getEmployeeDetails() {
return "Dependency Injection Successful: " + employee.toString();
}
}
