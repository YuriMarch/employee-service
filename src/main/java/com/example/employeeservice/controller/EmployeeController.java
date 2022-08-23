package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
@Tag(name="Employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    @Operation(summary = "Get all employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    @Operation(summary = "Save new employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    @Operation(summary = "Get employee by ID")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    @Operation(summary = "Delete employee by ID")
    public void deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    @Operation(summary = "Update employee by ID")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees")
    @Operation(summary = "Delete all employees")
    public void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
    }
}
