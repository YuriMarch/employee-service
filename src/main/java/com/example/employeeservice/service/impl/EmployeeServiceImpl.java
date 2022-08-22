package com.example.employeeservice.service.impl;

import com.example.employeeservice.exception.BusinessValidationException;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.validator.EmployeeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeValidator employeeValidator;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        List<String> validationErrors = employeeValidator.validate(employee);

        if (!validationErrors.isEmpty()){
            throw new BusinessValidationException(validationErrors);
        }
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        employeeRepository.findById(id).ifPresent(empl -> {
            empl.setFirstName(employee.getFirstName());
            empl.setLastName(employee.getLastName());
            empl.setEmail(employee.getEmail());
            empl.setPhoneNumber(employee.getPhoneNumber());
            empl.setSeniority(employee.getSeniority());
            empl.setJobTitle(employee.getJobTitle());

            List<String> validationErrors = employeeValidator.validate(empl);
            if (!validationErrors.isEmpty()){
                throw new BusinessValidationException(validationErrors);
            }
            employeeRepository.save(empl);
        });
        return employee;
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}



