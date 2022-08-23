package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> getAllEmployees();
     Employee saveEmployee(Employee employee);
     Employee getEmployeeById(String id);
     void deleteEmployeeById(String id);
     Employee updateEmployee(String id, Employee employee);
     void deleteAllEmployees();
}
