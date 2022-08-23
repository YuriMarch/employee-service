package com.example.employeeservice.service.impl;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> payEmployee(String id){
        employeeRepository.findById(id).ifPresent(empl -> {
            if (!empl.isPaycheckPaid()){
                empl.setPaycheckPaid(true);
                log.info("Employee successfully paid.");
            } else {
                log.info("Employee was already paid.");
            }
            employeeRepository.save(empl);
        });
        return employeeRepository.findById(id);
    }
}
