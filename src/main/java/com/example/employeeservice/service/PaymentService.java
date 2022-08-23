package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;

import java.util.Optional;

public interface PaymentService {

    Optional<Employee> payEmployee(String id);
}
