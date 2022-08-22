package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee saveEmployee(Employee employee);
    public Employee getEmployeeById(String id);
    public void deleteEmployeeById(String id);
    public Employee updateEmployee(String id, Employee employee);
    void deleteAllEmployees();
}
