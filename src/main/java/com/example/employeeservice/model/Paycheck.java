package com.example.employeeservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Paycheck {

    private Integer hoursWorked;
    private Double hourlyRate;
    private boolean isPaycheckPaid = false;
}


