package com.example.employeeservice.validator;

import com.example.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeValidator {

    public List<String> validate(Employee employee){
        List<String> validationErrors = new ArrayList<>();

        if(employee.getFirstName() == null || employee.getFirstName().isEmpty()){
            validationErrors.add("First name is required");
        }
        if (employee.getLastName() == null || employee.getLastName().isEmpty()){
            validationErrors.add("Last name is required");
        }
        if (employee.getEmail() == null || employee.getEmail().isEmpty()){
            validationErrors.add("Email is required");
        }
        if (employee.getPhoneNumber() == null || employee.getPhoneNumber().isEmpty()){
            validationErrors.add("Phone number is required");
        }
        if (employee.getSeniority() == null ){
            validationErrors.add("Seniority is required");
        }
        if (employee.getJobTitle() == null || employee.getJobTitle().isEmpty()){
            validationErrors.add("Job title is required");
        }

        return validationErrors;
    }
}
