package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;

import java.util.Optional;

public interface PromotionService {
    Optional<Employee> promoteEmployee(String id);
}
