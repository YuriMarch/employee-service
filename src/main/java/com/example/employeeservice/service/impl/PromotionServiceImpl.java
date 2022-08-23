package com.example.employeeservice.service.impl;

import com.example.employeeservice.enums.Seniority;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.PromotionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromotionServiceImpl implements PromotionService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> promoteEmployee(String id){
        employeeRepository.findById(id).ifPresent(empl -> {
            if (empl.getSeniority() == Seniority.Junior){
                empl.setSeniority(Seniority.Medior);
                log.info("Employee promoted to {}!", empl.getSeniority());
            } else if (empl.getSeniority() == Seniority.Medior){
                empl.setSeniority(Seniority.Senior);
                log.info("Employee promoted to {}!", empl.getSeniority());
            } else {
                log.info("Employee is already a Senior.");
            }
            employeeRepository.save(empl);
        });
        return employeeRepository.findById(id);
    }
}
