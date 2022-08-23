package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Get all employees", responses = {
            @ApiResponse(description = "Get all employees success ", responseCode = "200", content = @Content(mediaType = "application/json", schema= @Schema(implementation = Employee.class))),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content)})
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    @Operation(summary = "Save new employee", responses = {
            @ApiResponse(description = "Employee successfully saved ", responseCode = "201", content = @Content(mediaType = "application/json", schema= @Schema(implementation = Employee.class))),
            @ApiResponse(description = "Employee not saved", responseCode = "409", content = @Content)})
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    @Operation(summary = "Get employee by ID", responses = {
            @ApiResponse(description = "Get employee success ", responseCode = "200", content = @Content(mediaType = "application/json", schema= @Schema(implementation = Employee.class))),
            @ApiResponse(description = "Employee not found", responseCode = "404", content = @Content)})
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    @Operation(summary = "Delete employee by ID", responses = {
            @ApiResponse(description = "Employee successfully deleted", responseCode = "204"),
            @ApiResponse(description = "Employee not found", responseCode = "404", content = @Content)})
    public void deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    @Operation(summary = "Update employee by ID", responses = {
            @ApiResponse(description = "Employee successfully updated ", responseCode = "200", content = @Content(mediaType = "application/json", schema= @Schema(implementation = Employee.class))),
            @ApiResponse(description = "Employee not found", responseCode = "404", content = @Content)})
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees")
    @Operation(summary = "Delete all employees", responses = {
            @ApiResponse(description = "All employees successfully deleted", responseCode = "204"),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content)})
    public void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
    }
}
